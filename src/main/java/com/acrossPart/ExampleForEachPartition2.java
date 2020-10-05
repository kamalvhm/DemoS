package com.acrossPart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

import scala.Array;

public class ExampleForEachPartition2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		List<String> Names = new ArrayList<>();
		for(int i=0;i<10000;i++)
		Names.add(""+i);

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> originalInteger = sc.parallelize(Names);

		long stTime=System.currentTimeMillis();
		JavaRDD<String> original=originalInteger.repartition(1).map(r->r+"A");
		long endTime=System.currentTimeMillis();
		
		System.out.println("RDD "+(endTime-stTime));

		
		stTime=System.currentTimeMillis();
		JavaRDD<String> original2=originalInteger.repartition(100).mapPartitions(r->{
			List<String> list=new ArrayList<String>();
			while(r.hasNext()) {
				list.add(r+"A");
			}
			return list.iterator();
			}
		);
		 endTime=System.currentTimeMillis();
		
		System.out.println("MAP PARTION "+(endTime-stTime));
		
	

	}

}
