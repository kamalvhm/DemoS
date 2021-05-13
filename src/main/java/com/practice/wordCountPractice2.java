package com.practice;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import scala.Tuple2;

public class wordCountPractice2 {
	private static final Pattern SPACE = Pattern.compile(" ");

	public static void main(String[] args) {
			Logger.getLogger("org.apache").setLevel(Level.WARN);
			
			
			SparkSession spark=SparkSession.builder().appName("wc").master("local").getOrCreate();
			JavaSparkContext jsp=new JavaSparkContext(spark.sparkContext());
			
			
			JavaRDD<String> words=jsp.textFile("src/main/resources/boaringwords.txt");
			
			words=words.flatMap(r->Arrays.asList(r.split(" ")).iterator());
			
			JavaPairRDD<String,Integer> pairs=words.mapToPair(r->new Tuple2<String,Integer>(r,1));
			
			pairs=pairs.reduceByKey((v1,v2)->v1+v2);
			pairs.take(10).forEach(r->System.out.println(r._1+"-"+r._2));
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
