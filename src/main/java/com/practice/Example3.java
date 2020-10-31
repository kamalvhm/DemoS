package com.practice;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


public class Example3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> inputData=new ArrayList<>();
		inputData.add(1);
		inputData.add(2);
		inputData.add(3);
		inputData.add(4);
		inputData.add(5);
		inputData.add(6);
		inputData.add(7);
		inputData.add(8);
		inputData.add(9);
		inputData.add(10);
		
		
		SparkConf conf=new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc=new JavaSparkContext(conf);
		sc.setLogLevel("ERROR");
		
		JavaRDD<Integer> originalInteger=sc.parallelize(inputData);
		
		int rddSize=(int) originalInteger.count();
		System.out.println("RDD size :-"+rddSize);
		
		//Splitting RDD into tow parts one is 90% and other is 10%
		JavaRDD<Integer>[] splits = originalInteger.randomSplit(new double[]{0.9, 0.1}); 
		JavaRDD<Integer> partOne = splits[0];
		JavaRDD<Integer> partTwo = splits[1];
		        
		/*System.out.println("partOne RDD size :-"+partOne.count());
		partOne.foreach(r->System.out.print(r));
		System.out.println("partTwo RDD size :-"+partTwo.count());
		partTwo.foreach(r->System.out.print(r));*/
		
		JavaRDD<Integer> unionRdd=partOne.union(partTwo);
		System.out.println("UNION RDD size :-"+unionRdd.count());
		unionRdd.foreach(r->System.out.print(r));

		/*
		ZonedDateTime fromZdt = ZonedDateTime.parse("2020-01-05T08:20:10+05:30[America/New_York]");  
		ZonedDateTime toZdt=ZonedDateTime.parse("2020-03-05T08:20:10+05:30[America/New_York]"); 
		
		while (fromZdt.isBefore(toZdt)) {
			
			LocalDate lastDayofMonthGivenDate = fromZdt.toLocalDate().with(TemporalAdjusters.lastDayOfMonth());
			if(fromZdt.toLocalDate().equals(lastDayofMonthGivenDate) || fromZdt.toLocalDate().equals(lastDayofMonthGivenDate.minusDays(1))) {
				System.out.println("------------------------LAST TWO DAYs date :-"+fromZdt);
			}else
			System.out.println("date :-"+fromZdt);
			

			fromZdt=fromZdt.plusDays(1);
			
		
		}
		*/
		
		    
	}
	

}
