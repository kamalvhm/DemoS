package com.example;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ZonedDateTime zone1 = ZonedDateTime.parse("2016-01-05T08:20:10+05:30[Asia/Kolkata]");

		ZonedDateTime zone2 = ZonedDateTime.parse("2016-10-05T08:20:10+05:30[Asia/Kolkata]");

		List<ZonedDateTime> list_of_date = new ArrayList<ZonedDateTime>();

		if(zone1.isBefore(zone2)) {
			ZonedDateTime tempZonedDateTime = zone1;
				int count=0;
			while (!(tempZonedDateTime.equals(zone2))) {
				list_of_date.add(tempZonedDateTime);
				tempZonedDateTime=tempZonedDateTime.plusDays(1L);
				
				System.out.println("IN "+count++);

			}
			
			System.out.println(list_of_date);

		}*/
		ZonedDateTime start = ZonedDateTime.parse("2016-01-01T08:20:10+05:30[Asia/Kolkata]");

		ZonedDateTime end = ZonedDateTime.parse("2016-01-02T08:20:10+05:30[Asia/Kolkata]");
		
		IntStream.iterate(0, i -> i + 1).limit(ChronoUnit.DAYS.between(start, end))
		.mapToObj(i -> start.plusDays(i)).forEach(r->System.out.print(r+" "));
		
		List<Integer> inputData=new ArrayList<>();
		inputData.add(35);
		inputData.add(12);
		inputData.add(35);
		inputData.add(12);
		inputData.add(35);
		inputData.add(12);
		inputData.add(35);
		inputData.add(12);
		
		
		
		SparkConf conf=new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc=new JavaSparkContext(conf);
		
		JavaRDD<Integer> originalInteger=sc.parallelize(inputData);
		
		int rddSize=(int) originalInteger.count();
		
		
		int chunksize = 5;
		int counter = 1;
		
		List<Integer> list = new ArrayList<>();
		for (Integer lpDaily : originalInteger.collect()) {
			list.add(lpDaily);
			if(counter >= chunksize) {
				//System.out.println(list);
				list.clear();
				counter=1;
			}else {
				counter ++;
			}
			
		}
		//System.out.println(list);
		
		originalInteger.map(r->(r+1));
		
		      
		        
		        
		    
	}

	static long zonedDateTimeDifference(ZonedDateTime d1, ZonedDateTime d2, ChronoUnit unit) {
		return unit.between(d1, d2);
	}

}
