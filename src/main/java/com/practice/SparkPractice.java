package com.practice;

import static org.apache.spark.sql.functions.col;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class SparkPractice {

	public static void main(String[] args) {
			Logger.getLogger("org.apache").setLevel(Level.WARN);
			
			SparkSession spark=SparkSession.builder().appName("A").master("local").getOrCreate();
			
			
			Dataset<Row> ds =spark.read().option("header", true).csv("");
			ds=ds.withColumn("Centi", col("F").minus(32).multiply(5).divide(9));
			ds.write().format("parque").save("");
			
		/*	SparkConf conf=new SparkConf().setAppName("").setMaster("local");
			JavaSparkContext jsc=new JavaSparkContext(conf);*/
			
	
					}

}
