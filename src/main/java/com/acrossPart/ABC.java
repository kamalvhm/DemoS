package com.acrossPart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class ABC {

	public static void main(String[] args) {
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark=SparkSession.builder().appName("wc").master("local").getOrCreate();
		JavaSparkContext sc=new JavaSparkContext(spark.sparkContext());

		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(1);
		list.add(3);
		list.add(3);

		JavaRDD<Integer> rdd=sc.parallelize(list);
		
		System.out.print(rdd.distinct().collect());
		
	}
	
	

}
