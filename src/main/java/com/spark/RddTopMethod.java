package com.spark;

import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


public class RddTopMethod {

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		SparkConf conf = new SparkConf().setAppName("pattern").setMaster("local");

		JavaSparkContext jsc = new JavaSparkContext(conf);

		JavaRDD<String> rdd = jsc.textFile("src/main/resources/input2.txt");

		JavaRDD<String> sortedData = rdd.sortBy(new Function<String, Double>() {

			@Override
			public Double call(String arg0) throws Exception {

				String[] data = arg0.split(",");

				return data[7].length() > 0 ? Double.parseDouble(data[7]) : 0.0;
			}
		}, false, 50);

		Iterator<String> top = sortedData.take(10).iterator();

		while (top.hasNext()) {
			System.out.println(top.next());
		}
		
		
		//Using DataFrames
			/*SparkSession session = SparkSession.builder().appName("Test").config("spark.sql.sources.default", "json")
				.master("local").getOrCreate();
				Dataset<Row> dataframe = session.read().option("inferSchema", "true")
				.csv("Input Path")
				.toDF("fname", "lname", "designation", "department", "jobtype", "NA", "NA2", "salary", "NA3");
				dataframe.sort(col("salary").desc()).limit(10).show();*/


		}


}
