package com.acrossPart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class Demo {

	public static void main(String[] args) {
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		/*SparkConf conf=new SparkConf().setAppName("A").setMaster("local");
		
		JavaSparkContext jsc=new JavaSparkContext(conf);*/
		SparkSession spark =SparkSession.builder().appName("A").master("local").getOrCreate();
		JavaSparkContext jsc=new JavaSparkContext(spark.sparkContext());
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		JavaRDD<Integer> rdd=jsc.parallelize(list);
		//Integer val=rdd.reduce((val1,val2)->val1+val2);
		
		rdd=rdd.map(r->2*r);
		rdd.foreach(r->System.out.print(r+". "));
		
		
		
		
	}

}
