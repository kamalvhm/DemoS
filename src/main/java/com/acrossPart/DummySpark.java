package com.acrossPart;

import java.util.Arrays;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

public class DummySpark {

	public static void main(String[] args) {
		//D:/PackUp/DemoS/src/main/resources/exam/employee.csv
		
		Logger.getLogger("org.apache").setLevel(Level.ERROR);
		
		SparkSession spark=SparkSession.builder().appName("H").master("local").getOrCreate();
		
		JavaSparkContext sc=new JavaSparkContext(spark.sparkContext());
		
		JavaRDD<String> rdd=sc.textFile("src/main/resources/boaringwords.txt");
		
		rdd=rdd.flatMap(r->{
			return Arrays.asList(r.split(" ")).iterator();
		});
		
		JavaPairRDD<String,Integer> pairs=rdd.mapToPair(r->new Tuple2<String,Integer>(r,1));
		pairs=pairs.reduceByKey((r1,r2)->r1+r2);
		JavaPairRDD<Integer,String> words=pairs.mapToPair(r->new Tuple2<Integer,String>(r._2,r._1));
		//words=words.sortByKey(false);
		System.out.print(words.sortByKey(false).take(10));
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	Logger.getLogger("org.apache").setLevel(Level.WARN);
//	SparkSession spark =SparkSession.builder().appName("wc").master("local").getOrCreate();
//	
//	Dataset<Row> df=spark.read().option("header", true).option("inferschema",true).csv("D:/PackUp/DemoS/src/main/resources/exam/employee.csv");
//	
//	df.show();
//	
//	HashMap<String,Object> valueMap=new HashMap<>();
//	valueMap.put("dept", "N/A");
//	valueMap.put("salary", 0);
//	
//	df.na().fill(valueMap).show();

}
