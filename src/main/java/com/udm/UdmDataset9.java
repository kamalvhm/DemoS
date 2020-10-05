package com.udm;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.date_format;

import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;


public class UdmDataset9 {

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkSession spark =SparkSession.builder().appName("APP").master("local[*]").config("spark.sql.warehouse.dir","file:///c:/tmp/").getOrCreate();

		
		Dataset<Row> dataset=spark.read().option("header", true).csv("src/main/resources/ds/biglog.txt");

		//getting error counts for each month wise
/*		Dataset<Row> results = spark.sql("select level,date_format(datetime,'MMMM') as month ,cast(first(date_format(datetime,'M')) as int) monthnum,count(1) as total "
				+ "from logging_table group by level,month order by monthnum");*/
		
		//dataset=dataset.selectExpr("level","date_format(datetime,'MMMM') as month");
		dataset=dataset.select(col("level"),
				date_format(col("datetime"),"MMMM").alias("month"),
				date_format(col("datetime"),"M").alias("monthnum").cast(DataTypes.IntegerType));
		
		dataset=dataset.groupBy(col("level"),col("month"),col("monthnum")).count().as("total");
		dataset=dataset.drop(col("monthnum"));
		
		dataset.show(100);
		//hit localhost:4040
		//new Scanner(System.in).nextLine();
		
		spark.close();
	}

}
