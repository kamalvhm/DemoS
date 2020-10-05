package com.studyfromDocs;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.sql.SparkSession;

import scala.Tuple2;

public class SparkDemo {

	public static void main(String[] args) throws Exception{
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");
		
		List<Tuple2<Integer,Integer>> list1=new ArrayList<Tuple2<Integer,Integer>>();
		list1.add(new Tuple2<>(4,18));
		list1.add(new Tuple2<>(2,1));
		list1.add(new Tuple2<>(5,10));

		
		List<Tuple2<Integer,String>> list2=new ArrayList<Tuple2<Integer,String>>();
		list2.add(new Tuple2<>(4,"A"));
		list2.add(new Tuple2<>(8,"B"));
		list2.add(new Tuple2<>(6,"c"));

		
		SparkSession s = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		
		JavaSparkContext sc =new JavaSparkContext(s.sparkContext());
		
		
		JavaPairRDD<Integer, Integer> one =sc.parallelizePairs(list1);
		
		JavaPairRDD<Integer, String> two =sc.parallelizePairs(list2);

		JavaPairRDD<Integer, Tuple2<Integer, Optional<String>>> three=one.leftOuterJoin(two);
		
		three.foreach(r->{
			System.out.println(r);
		});
	}


}
