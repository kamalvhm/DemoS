package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import static org.apache.spark.sql.functions.*;

public class wordCountPractice2 {
	private static final Pattern SPACE = Pattern.compile(" ");

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark=SparkSession.builder().appName("wc").master("local").getOrCreate();
		JavaSparkContext sc=new JavaSparkContext(spark.sparkContext());
			
		Dataset<Row> df=spark.read().option("header", true).csv("src/main/resources/exam/student.csv");
		spark.udf().register("pass",(String score)->{
			if(Integer.parseInt(score)>60)return "pass";
			else return "fail";
		},DataTypes.StringType);
		
		df=df.withColumn("Result", callUDF("pass", col("score")));
		df.show();
		spark.close();
	}
	
	
	
	
	
	
	
	
	
	
	
/*	public static void main2(Strin args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkSession spark=SparkSession.builder().appName("WC").master("local").getOrCreate();
		
		Dataset<Row> dataset=spark.read().option("header", true).csv("src/main/resources/ds/biglog.txt");
		
		dataset.createOrReplaceTempView("logger");
		
		Dataset<Row> results = spark.sql("select level,date_format(datetime,'MMMM') as month ,cast(first(date_format(datetime,'M')) as int) monthnum,count(1) as total "
				+ "from logger group by level,month order by monthnum");
		
	
		results.show(10);
		spark.close();
	}*/

}
