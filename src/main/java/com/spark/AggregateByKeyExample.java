package com.spark;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;

import scala.Tuple2;

public class AggregateByKeyExample {

	public static void main(String[] args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkConf conf = new SparkConf().setAppName("aggregate_by_key").setMaster("local");

		JavaSparkContext jsc = new JavaSparkContext(conf);
		//sequence of data in file (#id,octet,status,time)
		JavaRDD<String> rdd = jsc.textFile("src/main/resources/agg_data.txt");

		JavaPairRDD<String, CallData> pair = rdd.mapPartitionsToPair(new PairFlatMapFunction<Iterator<String>, String, CallData>() {

					private static final long serialVersionUID = 4454545;

					@Override
					public Iterator<Tuple2<String, CallData>> call(Iterator<String> arg0) throws Exception {

						List<Tuple2<String, CallData>> list = new ArrayList<>();

						SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

						while (arg0.hasNext()) {
							String[] data = arg0.next().split(",");

							list.add(new Tuple2<String, CallData>(data[0], new CallData(Double.parseDouble(data[1]),
									Integer.parseInt(data[2]), formatter1.parse(data[3]))));
						}

						return list.iterator();

					}

				});

		TreeSet<CallData> set = new TreeSet<CallData>();

		Function2<TreeSet<CallData>, CallData, TreeSet<CallData>> test = new Function2<TreeSet<CallData>, CallData, TreeSet<CallData>>() {

			private static final long serialVersionUID = 2323;

			@Override
			public TreeSet<CallData> call(TreeSet<CallData> arg0, CallData arg1) throws Exception {
				// TODO Auto-generated method stub

				arg0.add(arg1);
				return arg0;
			}
		};

		Function2<TreeSet<CallData>, TreeSet<CallData>, TreeSet<CallData>> test2 = new Function2<TreeSet<CallData>, TreeSet<CallData>, TreeSet<CallData>>() {

			private static final long serialVersionUID = 9898;

			@Override
			public TreeSet<CallData> call(TreeSet<CallData> arg0, TreeSet<CallData> arg1) throws Exception {
				// TODO Auto-generated method stub

				arg0.addAll(arg1);

				return arg0;
			}
		};

		JavaPairRDD<String, TreeSet<CallData>> finalRdd = pair.aggregateByKey(set, test, test2);

		Double sum = 0d;

		for (Tuple2<String, TreeSet<CallData>> callData : finalRdd.collect()) {

			for (CallData calldata : callData._2) {

				sum = sum + calldata.getOctets();

			}

			System.out.println("Total Octet for id " + callData._1 + " " + sum);

		}
		
		
		
		

	}

}