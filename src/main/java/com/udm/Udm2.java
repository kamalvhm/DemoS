package com.udm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class Udm2 {

	public static void main(String[] args) {
		// TODO Tuple :-to put two or more data in to single unit we use tuple
		
			List<Integer> inputData=new ArrayList<>();
			inputData.add(35);
			inputData.add(12);
			inputData.add(90);
			inputData.add(20);
			
			
			Logger.getLogger("org.apache").setLevel(Level.WARN);

			SparkConf conf=new SparkConf().setAppName("dem").setMaster("local[*]");
			JavaSparkContext sc=new JavaSparkContext(conf);
			
			JavaRDD<Integer> originalInteger=sc.parallelize(inputData);
			
			//instead of this we use tuple to store 
			JavaRDD<IntegerwithSquaqeRoot> sqrtRdd=originalInteger.map(value->new IntegerwithSquaqeRoot(value));
			
			JavaRDD<Tuple2<Integer,Double>> sqrtRdd2=originalInteger.map(value->new Tuple2<Integer,Double>(value,Math.sqrt(value)));

			Tuple2<Integer,Double> myVal=new Tuple2<>(9,3.0);	
			 
			sc.close();
			
			
	}

}
