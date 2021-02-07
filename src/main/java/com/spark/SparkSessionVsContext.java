package com.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkSessionVsContext {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SparkSession spark1 = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		spark1.sparkContext().setLogLevel("ERROR");
		
		Dataset<Row> df = spark1.read().json("src/main/resources/people.json");
		
		df.createOrReplaceTempView("people"); //temp table created in first session

		//spark1.sqlContext().sql("show tables").show();		
		spark1.sql("show tables").show();	
		SparkSession spark2 = spark1.newSession();  // with new session does not show previos session tables as it in temp view 
		
		spark2.sqlContext().sql("show tables").show();		
		
		System.out.print(spark1.sparkContext());
		//these both will have same hashcode as its one for both session but session will be diffrent 
		System.out.print(spark2.sparkContext());

		
		

	}

}
