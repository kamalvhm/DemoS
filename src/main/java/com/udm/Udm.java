package com.udm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;


public class Udm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Double> inputData = new ArrayList<>();
		inputData.add(35.5);
		inputData.add(12.49943);
		inputData.add(90.5);
		inputData.add(20.5);
		
		//Two to create spark JavaSparkContext below two METHOD 1
		//SparkConf conf =new SparkConf().setAppname{"sparkStart"}.setMaster("local[*]");
		//JavaSparkContext represents the connection with cluster another way with session is below
		//JavaSparkContext sc =new JavaSparkContext(conf);
		
		//This will filter out all logging to only warn amke sure it log4j in import 
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		//METHOD 2
		SparkSession spark = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		JavaSparkContext sc =new JavaSparkContext(spark.sparkContext());
		
		//parallelize will load a collection and turn it into Rdd
		JavaRDD<Double> rdd = sc.parallelize(inputData);
		// reduce to one value 
		Double result = rdd.reduce((value1, value2) -> value1 + value2);
		
		System.out.println("**Reduced Value***-> "+result);

		
		
		
		List<Integer> inputData2 = new ArrayList<>();
		inputData2.add(8);
		inputData2.add(12);
		inputData2.add(90);
		inputData2.add(20);
		
		
		JavaRDD<Integer> rdd2= sc.parallelize(inputData2);
		// reduce to one value 
		Integer result2 = rdd2.reduce((value1, value2) -> value1 + value2);
		//Video8 Map :-Map allows to transform structure of rdd from one form to another
		JavaRDD<Double> sqrtRdd=rdd2.map(x->Math.sqrt(x));
		
		//sqrtRdd.collect().forEach(System.out::println);  it because of if removed then java.io.NotSerializableException: java.io.PrintStream
		// if this 'sqrtRdd.foreach(System.out::println);' then exception its because  its running on local machine its must be serialize and if machine is having multiple CPU 
		//in spark System.out::println this method ins not serialiable to add Collect() it will gether all data in one JVM in one regular colletion List
		sqrtRdd.collect().forEach(System.out::println);
		
		System.out.print(result2);
	 
		//count a interim value Two method one is call count() other is with Map and reduce both showed below 
		System.out.println(sqrtRdd.count());
		JavaRDD<Long> singleIntRdd=sqrtRdd.map(value->1L);
		Long count =singleIntRdd.reduce((value1,value2)->value1+value2);
		System.out.println(count);

	
		
		sc.close();
		
		
		//TUPLE
		 

	}

}
