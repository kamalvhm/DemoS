package com.spark;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class GettingTopElement {

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		List<Integer> inputData1=new ArrayList<>();
		inputData1.add(1);
		inputData1.add(2);
		inputData1.add(3);
		inputData1.add(4);
		inputData1.add(5);
		
		List<Integer> inputData=new ArrayList<>();
		inputData.add(6);
		inputData.add(7);
		inputData.add(8);
		inputData.add(9);
		inputData.add(10);
		
		
		SparkConf conf=new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc=new JavaSparkContext(conf);
		
		//JavaRDD<Integer> originalInteger1=sc.parallelize(inputData1);
		JavaRDD<Integer> originalInteger=sc.parallelize(inputData);
		List<Integer> list=originalInteger.top(2);
		System.out.print(list);
		/*	
		int rddSize=(int) originalInteger.count();
		System.out.println("RDD size :-"+rddSize);
		
	
	        
		System.out.println("partOne RDD size :-"+originalInteger1.count());
		originalInteger1.foreach(r->System.out.print(r));
		System.out.println("partTwo RDD size :-"+originalInteger.count());
		originalInteger.foreach(r->System.out.print(r));
		
		
		JavaRDD<Integer> allInteger=originalInteger1.union(originalInteger);
		
		System.out.println("allInteger RDD size :-"+allInteger.count());
		
		allInteger.foreach(r->System.out.print(r));*/
	}
}
