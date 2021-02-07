package com.cleanup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

public class ExampleForEachPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> Names = new ArrayList<>();
		Names.add("A");
		Names.add("B");
		Names.add("C");
		Names.add("1");
		Names.add("2");
		Names.add("3");
		Names.add("4");
		Names.add("5");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> originalInteger = sc.parallelize(Names, 8);

		//
		originalInteger.foreachPartition(it -> {
			System.out.println("HEY");
			it.forEachRemaining(v -> System.out.println("Bey" + v));
		});

	originalInteger.foreachPartition(new VoidFunction<Iterator<String>>() {

			private static final long serialVersionUID = 1L;

			@Override
			public void call(Iterator<String> arg0) throws Exception {
				while (arg0.hasNext()) {
					System.out.println(arg0.next());
				}

			}
		});

	}

}
