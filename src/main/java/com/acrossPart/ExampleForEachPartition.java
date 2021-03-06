package com.acrossPart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ExampleForEachPartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger.getLogger("org.apache").setLevel(Level.WARN);


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

		JavaRDD<String> originalInteger = sc.parallelize(Names,8);

		
		/*org.apache.spark.Accumulator<Integer> acc=sc.accumulator(0,"Count");

		//
		originalInteger.repartition(4).foreachPartition(it -> {
			System.out.println("HEY"+it);
			acc.add(1);
			it.forEachRemaining(v -> System.out.println("Bey " + v));
		});
		
		System.out.println(acc.value());*/

		
	/*originalInteger.foreachPartition(new VoidFunction<Iterator<String>>() {

			private static final long serialVersionUID = 1L;

			@Override
			public void call(Iterator<String> arg0) throws Exception {
				while (arg0.hasNext()) {
					System.out.println(arg0.next());
				}

			}
		});*/

	}

}
