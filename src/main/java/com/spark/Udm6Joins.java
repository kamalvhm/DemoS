package com.spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;

import scala.Tuple2;
public class Udm6Joins {

	public static void main(String[] args) { 

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		

		JavaSparkContext sc = new JavaSparkContext(conf);
		sc.setLogLevel("ERROR");

		List<Tuple2<Integer ,Integer>> left=new ArrayList<>();
		left.add(new Tuple2<Integer, Integer>(4,18));
		left.add(new Tuple2<Integer, Integer>(3,4));
		left.add(new Tuple2<Integer, Integer>(10,9));

		List<Tuple2<Integer ,String>> right=new ArrayList<>();
		right.add(new Tuple2<Integer, String>(1,"ram"));
		right.add(new Tuple2<Integer, String>(2,"shaym"));
		right.add(new Tuple2<Integer, String>(3,"mohan"));
//		right.add(new Tuple2<Integer, String>(4 ,"Doris"));
//		right.add(new Tuple2<Integer, String>(5,"Marybelle"));
//		right.add(new Tuple2<Integer, String>(6,"raquel"));
		
		List<Integer> left2=new ArrayList<>();
		left2.add(4);
		left2.add(3);
		
		
		JavaPairRDD<Integer, Integer> visits = sc.parallelizePairs(left);
		JavaPairRDD<Integer, String> users = sc.parallelizePairs(right);


		 JavaPairRDD<Integer, Tuple2<Integer, Optional<String>>> joinedRdd = visits.leftOuterJoin(users);

//		//In optional orElse return value if present and if not return value specified
		joinedRdd.foreach(it->System.out.println("user "+it._2._2 +"| had |"+it._2._1));
		 
		 
		 List<Tuple2<Integer ,String>> right2=new ArrayList<>();
		 right2.add(new Tuple2<Integer, String>(10,"kamal"));
		 right2.add(new Tuple2<Integer, String>(8,"mm"));
		 JavaPairRDD<Integer, Tuple2<Tuple2<Integer, Optional<String>>, Optional<String>>> joinedRdd2 = joinedRdd.leftOuterJoin(sc.parallelizePairs(right2));
		
		 joinedRdd2.foreach(it->System.out.println("user2 "+it._2._2 +"| had |"+it._2._1));
		

		 
		sc.close();

	}

}
