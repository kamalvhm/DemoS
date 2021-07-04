package com.acrossPart;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.max;
import static org.apache.spark.sql.functions.min;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
import org.apache.spark.sql.types.DataTypes;

public class Udm {
	//Transforamtion-map()   Action:-reduce(),count()

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		SparkSession spark=SparkSession.builder().appName("wc").master("local").getOrCreate();
		JavaSparkContext sc=new JavaSparkContext(spark.sparkContext());
		
		Dataset<Row> df=spark.read().option("header", true).csv("src/main/resources/exam/student.csv");

		df=df.groupBy(col("subject")).agg(
				min(col("score").alias("MIN").cast(DataTypes.IntegerType)),
				max(col("score").alias("MAX").cast(DataTypes.IntegerType))
				);
	
		df.show();
		
		WindowSpec spec=Window.partitionBy(col("")).orderBy(col(""));
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
