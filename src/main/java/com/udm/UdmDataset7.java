package com.udm;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;


public class UdmDataset7 {

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkSession spark =SparkSession.builder().appName("APP").master("local[*]").config("spark.sql.warehouse.dir","file:///c:/tmp/").getOrCreate();

		
		Dataset<Row> dataset=spark.read().option("header", true).csv("src/main/resources/exam/student.csv");

		//Column score=dataset.col("score");
		dataset=dataset.groupBy("subject").agg(max(col("score").cast(DataTypes.IntegerType)).alias("max_score"),
											   min(col("score").cast(DataTypes.IntegerType)).alias("min_score"));
		
		dataset.show();
		
		spark.close();
	}

}
