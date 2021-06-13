package com.acrossPart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;


public class Udm {
	//Transforamtion-map()   Action:-reduce(),count()

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> inputData = new ArrayList<>();
		inputData.add(10.5);
		
 
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		//METHOD 2
		SparkSession spark = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		JavaSparkContext sc =new JavaSparkContext(spark.sparkContext());
		
		//parallelize will load a collection and turn it into Rdd
		JavaRDD<Double> rdd = sc.parallelize(inputData);
		// reduce to one value its a ACTION  
	if(!rdd.isEmpty()) {
		Double result = rdd.reduce((value1, value2) -> value1 + value2);
		System.out.println("**Reduced Value***-> "+result);

	}
		

		
	
		
		sc.close();
		
		
		 

	}

}
