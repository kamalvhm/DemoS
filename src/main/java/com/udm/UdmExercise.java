package com.udm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;

import scala.Tuple2;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class UdmExercise {

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");

		JavaSparkContext sc = new JavaSparkContext(conf);
		
		sc.setLogLevel("ERROR");

		boolean testMode = true;

		JavaPairRDD<Integer, Integer> viewData = setUpViewDataRdd(sc, testMode);
		//Check the DAG we are reading two time this at stage 6 and 2 so cache it [*********GREEN DOT IN STAGE DENOTES ITS CACHED**********]
		JavaPairRDD<Integer, Integer> chapterData = setUpchapterDataRdd(sc, testMode).cache();
		JavaPairRDD<Integer, String> titlesData = setUptitlesData(sc, testMode);

		//counting no of chapters 
		JavaPairRDD<Integer, Integer> chapterCountRdd = chapterData
				.mapToPair(row -> new Tuple2<Integer, Integer>(row._2, 1))
				.reduceByKey((value1, value2) -> value1 + value2);
		
		//step 1 remove duplicates
		viewData = viewData.distinct();

		viewData = viewData.mapToPair(row -> new Tuple2<Integer, Integer>(row._2, row._1));
		
		
		JavaPairRDD<Integer, Tuple2<Integer, Integer>> joinedRdd = viewData.join(chapterData);
		
		// step 3 don't need chapterIds,setting up for a reduce
		JavaPairRDD<Tuple2<Integer, Integer>, Long> step3 = joinedRdd.mapToPair(row -> {
			Integer userId = row._2._1;
			Integer courseId = row._2._2;
			return new Tuple2<Tuple2<Integer, Integer>, Long>(new Tuple2<Integer, Integer>(userId, courseId), 1L);
		});
		
		
		// step 4 count how many view for each user per course
		step3 = step3.reduceByKey((value1, value2) -> value1 + value2);

		// step 5 remove userIds
		JavaPairRDD<Integer, Long> step5 = step3.mapToPair(row -> new Tuple2<Integer, Long>(row._1._2, row._2));

		// step 6 add in total chapter count
		JavaPairRDD<Integer, Tuple2<Long, Integer>> step6 = step5.join(chapterCountRdd);

		// step 7 create these into percentage
		JavaPairRDD<Integer, Double> step7 = step6.mapValues(value -> (double) value._1 / value._2);
		
		// step 8 convert to scores
		JavaPairRDD<Integer, Long> step8 = step7.mapValues(value -> {
			if (value > 0.9)
				return 10L;
			if (value > 0.5)
				return 5L;
			if (value > 0.25)
				return 2L;
			return 0L;
		});
		
		
		// step 9
		step8 = step8.reduceByKey((v1, v2) -> v1 + v2);

		// step 10
		JavaPairRDD<Integer, Tuple2<Long, String>> step10 = step8.join(titlesData);
		JavaPairRDD<Long, String> step11 = step10.mapToPair(row -> new Tuple2<Long, String>(row._2._1, row._2._2));

		step11.foreach(s -> System.out.println(s));
		
		// //In optional orElse return value if present and if not return value
		// specified
		//To view UI
		Scanner scnr =new Scanner(System.in);
		scnr.nextLine();

		sc.close();

	}

	private static JavaPairRDD<Integer, Integer> setUpchapterDataRdd(JavaSparkContext sc, boolean testMode) {
		// TODO Auto-generated method stub

		if (testMode) {
			List<Tuple2<Integer, Integer>> rawchapterData = new ArrayList<>();
			rawchapterData.add(new Tuple2<Integer, Integer>(96, 1));
			rawchapterData.add(new Tuple2<Integer, Integer>(97, 1));
			rawchapterData.add(new Tuple2<Integer, Integer>(98, 1));
			rawchapterData.add(new Tuple2<Integer, Integer>(99, 2));
			rawchapterData.add(new Tuple2<Integer, Integer>(100, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(101, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(102, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(103, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(104, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(105, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(106, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(107, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(108, 3));
			rawchapterData.add(new Tuple2<Integer, Integer>(109, 3));
			return sc.parallelizePairs(rawchapterData);
		}
		return null;
	}

	private static JavaPairRDD<Integer, String> setUptitlesData(JavaSparkContext sc, boolean testMode) {
		// TODO Auto-generated method stub
		if (testMode) {
			List<Tuple2<Integer, String>> rawViewData = new ArrayList<>();
			rawViewData.add(new Tuple2<Integer, String>(1, "Title1"));
			rawViewData.add(new Tuple2<Integer, String>(2, "Title2"));
			rawViewData.add(new Tuple2<Integer, String>(3, "Title3"));

			return sc.parallelizePairs(rawViewData);
		}
		return null;
	}

	private static JavaPairRDD<Integer, Integer> setUpViewDataRdd(JavaSparkContext sc, boolean testMode) {
		// TODO Auto-generated method stub
		if (testMode) {
			List<Tuple2<Integer, Integer>> rawViewData = new ArrayList<>();
			rawViewData.add(new Tuple2<Integer, Integer>(14, 96));
			rawViewData.add(new Tuple2<Integer, Integer>(14, 97));
			rawViewData.add(new Tuple2<Integer, Integer>(13, 96));
			rawViewData.add(new Tuple2<Integer, Integer>(13, 96));
			rawViewData.add(new Tuple2<Integer, Integer>(13, 96));
			rawViewData.add(new Tuple2<Integer, Integer>(14, 99));
			rawViewData.add(new Tuple2<Integer, Integer>(13, 100));

			return sc.parallelizePairs(rawViewData);
		}
		return null;
	}

}
