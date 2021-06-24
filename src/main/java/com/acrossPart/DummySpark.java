package com.acrossPart;

import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DummySpark {

	public static void main(String[] args) {
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkSession spark =SparkSession.builder().appName("wc").master("local").getOrCreate();
		
		Dataset<Row> df=spark.read().option("header", true).option("inferschema",true).csv("D:/PackUp/DemoS/src/main/resources/exam/employee.csv");
		
		df.show();
		
		HashMap<String,Object> valueMap=new HashMap<>();
		valueMap.put("dept", "N/A");
		valueMap.put("salary", 0);
		
		df.na().fill(valueMap).show();
				
		//df.distinct().show();
		
		/*WindowSpec windowSpec=Window.partitionBy("dept").orderBy(col("salary").desc());
		
		df.withColumn("ranks", dense_rank().over(windowSpec)).show();*/
		
		
	}

}
