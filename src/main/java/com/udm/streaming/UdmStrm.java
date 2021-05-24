package com.udm.streaming;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Durations;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

import scala.Tuple2;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class UdmStrm {

	public static void main(String[] args) throws InterruptedException { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		Logger.getLogger("org.apache.spark.storage").setLevel(Level.ERROR);


		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaStreamingContext sc=new JavaStreamingContext(conf,Durations.seconds(10));
		
		JavaReceiverInputDStream<String> inputData = sc.socketTextStream("localhost", 8989);
		//same as collections of RDDs operations we can perform same as RDD
		JavaDStream<String> result = inputData.map(item->item);
		//result.print();
		result=result.map(rawMsg->rawMsg.split(",")[0]);
		
		JavaPairDStream<String, Long> pairRdd = result.mapToPair(r->new Tuple2<String,Long>(r, 1L));
		//this will accumulate window of 2 min together
		pairRdd=pairRdd.reduceByKeyAndWindow((v1,v2)->v1+v2,Durations.minutes(2));
		
		pairRdd.print();
		//This will start stream program infinitely   
		sc.start();
		sc.awaitTermination();
		
		
	}

}
