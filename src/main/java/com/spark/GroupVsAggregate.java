package com.spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;


public class GroupVsAggregate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> inputData = new ArrayList<>();
		inputData.add(1);
		inputData.add(2);

		List<String> Names = new ArrayList<>();
		Names.add("A");
		Names.add("B");
		Names.add("C");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<Integer> originalInteger = sc.parallelize(inputData);
		JavaRDD<String> nameRdd = sc.parallelize(Names);

		JavaPairRDD<Integer, String> result = originalInteger.cartesian(nameRdd);

		// result.foreach(r -> {
		// transformationfunction(r._1, r._2);
		// });
		// WE SHOULD NOT USE GROUP BY INSETEAD USE AGGREGATE BY KEY
		JavaPairRDD<Integer, Iterable<String>> grpby = result.groupByKey();

		//grpby.foreach(r -> System.out.println("Key " + r._1 + " | Value " + r._2));

		// working on
		// result.combineByKey(createCombiner, mergeValue, mergeCombiners);

		List<String> initialValueEmptyset = new ArrayList<String>();

		Function2<List<String>, String, List<String>> combinerWithInPartion = new Function2<List<String>, String, List<String>>() {

			private static final long serialVersionUID = 2323;

			@Override
			public List<String> call(List<String> arg0, String arg1) throws Exception {
				// TODO Auto-generated method stub

				arg0.add(arg1);
				return arg0;
			}
		};

		Function2<List<String>, List<String>, List<String>> mergeFunAcrossPartion = new Function2<List<String>, List<String>, List<String>>() {

			private static final long serialVersionUID = 9898;

			@Override
			public List<String> call(List<String> arg0, List<String> arg1) throws Exception {
				// TODO Auto-generated method stub

				arg0.addAll(arg1);

				return arg0;
			}
		};

		JavaPairRDD<Integer, List<String>> finalRdd=	result.aggregateByKey(initialValueEmptyset, combinerWithInPartion, mergeFunAcrossPartion);
		
		finalRdd.foreach(r -> System.out.println("Key " + r._1 + " | Value " + r._2));
	}

	public static void transformationfunction(Integer i, String s) {

		System.out.println("D-> " + s + "-" + i);

	}

}
