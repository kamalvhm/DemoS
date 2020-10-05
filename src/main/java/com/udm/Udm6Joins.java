package com.udm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;

import scala.Tuple2;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class Udm6Joins {

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");

		JavaSparkContext sc = new JavaSparkContext(conf);
		sc.setLogLevel("ERROR");

		List<Tuple2<Integer ,Integer>> left=new ArrayList<>();
		left.add(new Tuple2<Integer, Integer>(4,18));
		left.add(new Tuple2<Integer, Integer>(3,4));
		left.add(new Tuple2<Integer, Integer>(10,9));

		List<Tuple2<Integer ,String>> right=new ArrayList<>();
		right.add(new Tuple2<Integer, String>(1,"ram"));
		right.add(new Tuple2<Integer, String>(2,"shaym"));
		right.add(new Tuple2<Integer, String>(3,"mohan"));
//		right.add(new Tuple2<Integer, String>(4 ,"Doris"));
//		right.add(new Tuple2<Integer, String>(5,"Marybelle"));
//		right.add(new Tuple2<Integer, String>(6,"raquel"));
		
		List<Integer> left2=new ArrayList<>();
		left2.add(4);
		left2.add(3);
		
		
		JavaPairRDD<Integer, Integer> visits = sc.parallelizePairs(left);
		JavaPairRDD<Integer, String> users = sc.parallelizePairs(right);


		// JavaPairRDD<Integer, Tuple2<Optional<Integer>, String>> joinedRdd = visits.rightOuterJoin(users);
		 JavaPairRDD<Integer, Tuple2<Integer, String>> joinedRdd = visits.join(users);


//		//In optional orElse return value if present and if not return value specified
		 //joinedRdd.foreach(it->System.out.println("user "+it._2._2 +"| had |"+it._2._1.orElse(0)));
		 joinedRdd.foreach(it->System.out.println("user "+it._2._2 +"| had |"+it._2._1));

		
		sc.close();

	}

}
