package com.spark;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFlatMapFunction;
import scala.Tuple2;

public class TreeAggregatePairRdd {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("aggregate_by_key").setMaster("local");
		JavaSparkContext jsc = new JavaSparkContext(conf);
		JavaRDD<String> rdd = jsc.textFile("C:\\codebase\\scala-project\\inputdata\\agg_data");
		
		
		JavaPairRDD<String, CallData> pair = rdd
				.mapPartitionsToPair(new PairFlatMapFunction<Iterator<String>, String, CallData>() {
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
		
		Function2<TreeSet<CallData>, Tuple2<String, CallData>, TreeSet<CallData>> mergeValue = new Function2<TreeSet<CallData>, Tuple2<String, CallData>, TreeSet<CallData>>() {
			private static final long serialVersionUID = 2323;

			@Override
			public TreeSet<CallData> call(TreeSet<CallData> arg0, Tuple2<String, CallData> arg1) throws Exception {
				// TODO Auto-generated method stub
				arg0.add(arg1._2());
				return arg0;
			}
		};
		
		Function2<TreeSet<CallData>, TreeSet<CallData>, TreeSet<CallData>> mergePartition = new Function2<TreeSet<CallData>, TreeSet<CallData>, TreeSet<CallData>>() {
			private static final long serialVersionUID = 9898;

			@Override
			public TreeSet<CallData> call(TreeSet<CallData> arg0, TreeSet<CallData> arg1) throws Exception {
				// TODO Auto-generated method stub
				arg0.addAll(arg1);
				return arg0;
			}
		};
		
		TreeSet<CallData> finalRdd2 = pair.treeAggregate(set, mergeValue, mergePartition, 6);
		double sum = 0;
		for (CallData callData : finalRdd2) {
			sum = sum + callData.getOctets();
		}
		System.out.println(sum);
		Tuple2<String, CallData> p = pair.treeReduce(
				new Function2<Tuple2<String, CallData>, Tuple2<String, CallData>, Tuple2<String, CallData>>() {
					@Override
					public Tuple2<String, CallData> call(Tuple2<String, CallData> arg0, Tuple2<String, CallData> arg1)
							throws Exception {
						arg0._2.setOctets(arg0._2.getOctets() + arg1._2.getOctets());
						return arg0;
					}
				}, 6);
		System.out.println(p._2.getOctets());
	}
}