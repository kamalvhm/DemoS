package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;

import scala.Tuple2;
import scala.Tuple3;
import scala.Tuple4;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class Udm6Joins2 {
	   private static final Logger logger           = Logger.getLogger(Udm6Joins2.class);

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");

		JavaSparkContext sc = new JavaSparkContext(conf);
		
		List<Tuple4<Integer ,String,Integer, Integer>> left=new ArrayList<>();
		left.add(new Tuple4<Integer, String,Integer, Integer>(1,"5",3,1));
		left.add(new Tuple4<Integer, String,Integer, Integer>(7,"5",11,1));
		left.add(new Tuple4<Integer, String,Integer, Integer>(2,"5",8,1));

		List<Tuple4<Integer ,String,Integer, Integer>> right=new ArrayList<>();
		right.add(new Tuple4<Integer, String,Integer, Integer>(1,"5",3,2));
		right.add(new Tuple4<Integer, String,Integer, Integer>(5,"5",7,1));

		JavaRDD<Tuple4<Integer ,String,Integer, Integer>> visits = sc.parallelize(left).distinct();
		JavaRDD<Tuple4<Integer ,String,Integer, Integer>> users = sc.parallelize(right).distinct();

		visits.union(users)
			  .mapToPair(t-> {
		              Tuple2<Integer, String> key = new Tuple2<Integer, String>(t._1(), t._2());
		              return new Tuple2<Tuple2<Integer, String>, Integer> (key, t._4());
		                })
		      .reduceByKey((v1, v2) -> {
		               return (v1 + v2);
		            })
		      .foreach(it->System.out.println("Dy:- |"+it._1()._1+"| VERSION |"+it._1()._2 +"| SDP No. |"+it._2()+"|"));

		sc.close();

	}

}
