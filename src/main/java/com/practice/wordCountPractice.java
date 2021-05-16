package com.practice;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import scala.Tuple2;

public class wordCountPractice {
	private static final Pattern SPACE = Pattern.compile(" ");

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession  sc=SparkSession.builder().appName("WordCount").master("local").getOrCreate();
		
		JavaSparkContext jsc=new JavaSparkContext(sc.sparkContext());
		JavaRDD<String> rdd=jsc.textFile("src/main/resources/boaringwords.txt");
		
		
		JavaRDD<String> words = rdd.flatMap(new FlatMapFunction<String, String>() {
			public Iterator<String> call(String x) {
				return  Arrays.asList(x.split(" ")).iterator();
			}
		});
		
		JavaPairRDD<String, Integer> wordPair=words.mapToPair(r->{
			return new Tuple2<String,Integer>(r,1);
		});
		
		wordPair=wordPair.reduceByKey((v1,v2)->v1+v2);
		
		wordPair.foreach(r->System.out.println(r._1+" COUNT "+r._2));
	}
	
	public static void wordCountWithDF(SparkSession spark) {
		Dataset<Row> df=spark.read().csv("src/main/resources/boaringwords.txt");
		df.createOrReplaceTempView("WordData");
		Dataset<Row> words=spark.sql("Select _c0,count(*) from WordData group by _c0 order by _c0 desc");
		words.show();
	}

}
