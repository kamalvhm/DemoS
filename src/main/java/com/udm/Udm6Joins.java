package com.udm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;

import com.beans.Key;

import scala.Tuple2;
import scala.Tuple4;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class Udm6Joins {
	   private static final Logger logger           = Logger.getLogger(Udm6Joins.class);

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");

		JavaSparkContext sc = new JavaSparkContext(conf);

		List<Tuple4<Integer ,Integer,Integer, Integer>> left=new ArrayList<>();
		left.add(new Tuple4<Integer, Integer,Integer, Integer>(1,2,3,4));
		left.add(new Tuple4<Integer, Integer,Integer, Integer>(9,10,11,12));
		left.add(new Tuple4<Integer, Integer,Integer, Integer>(5,6,8,13));

		List<Tuple4<Integer ,Integer,Integer, Integer>> right=new ArrayList<>();
		right.add(new Tuple4<Integer, Integer,Integer, Integer>(1,2,3,4));
		right.add(new Tuple4<Integer, Integer,Integer, Integer>(5,6,7,8));

		
		
		JavaRDD<Tuple4<Integer ,Integer,Integer, Integer>> visits = sc.parallelize(left);
		JavaRDD<Tuple4<Integer ,Integer,Integer, Integer>> users = sc.parallelize(right);
		
		JavaPairRDD<Key,Integer> visitM=visits.mapToPair(w->new Tuple2<Key,Integer>(Key.create(w),w._4()));
		JavaPairRDD<Key,Integer> usersM=users.mapToPair(w->new Tuple2<Key,Integer>(Key.create(w),w._4()));

		logger.warn("visitM "+visitM.count());
		logger.warn("usersM "+usersM.count());

		//JavaPairRDD<Key, Tuple2<Optional<Integer>, Optional<Integer>>> joinedRdd = visitM.fullOuterJoin(usersM);
		JavaPairRDD<Key, Tuple2<Integer, Integer>> joinedRdd = visitM.join(usersM);

		logger.warn("joinedRdd "+joinedRdd.count());

		 joinedRdd.foreach(it->System.out.println("F1:- "+it._1().one+"| had |"+it._1().two +"| had |"+it._1().three+"| SDP |"+(it._2()._1+it._2()._2)));

		 //joinedRdd.foreach(it->System.out.println("F1:- "+it._1().one+"| had |"+it._1().two +"| had |"+it._1().three+"| SDP |"+(it._2()._1.orElse(0)+it._2()._2.orElse(0))));

		
		sc.close();

	}

}
