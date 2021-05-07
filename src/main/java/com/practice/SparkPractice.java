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

import com.beans.Weather;


public class SparkPractice {

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkSession sc =SparkSession.builder().appName("A").master("local").getOrCreate();
		
		SparkConf scf=new SparkConf().setAppName("A").setMaster("local");
		
			
		Dataset<Row> df =sc.read().option("header", true)
							  .csv("src/main/resources/weather.txt") 
							  ;
		
		Dataset<Row> dff=df.withColumn("CENTI", col("TEMP_IN_F").multiply(2));
		
		dff.write().format("parquet").save("resources/temp2.parquet");
	}

}
