package com.spark;

import java.util.TreeSet;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;
import scala.Tuple2;

public class TreeAggregate {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("aggregate_by_key").setMaster("local");
		JavaSparkContext jsc = new JavaSparkContext(conf);
		JavaRDD<String> rdd = jsc.textFile("C:\\codebase\\scala-project\\inputdata\\agg_data");
		
		TreeSet<String> zero = new TreeSet<String>();
		
		Function2<TreeSet<String>, String, TreeSet<String>> mergeValue = new Function2<TreeSet<String>, String, TreeSet<String>>() {
			private static final long serialVersionUID = 2323;

			@Override
			public TreeSet<String> call(TreeSet<String> arg0, String arg1) throws Exception {
				// TODO Auto-generated method stub
				arg0.add(arg1);
				return arg0;
			}
		};
		Function2<TreeSet<String>, TreeSet<String>, TreeSet<String>> mergePartition = new Function2<TreeSet<String>, TreeSet<String>, TreeSet<String>>() {
			private static final long serialVersionUID = 9898;

			@Override
			public TreeSet<String> call(TreeSet<String> arg0, TreeSet<String> arg1) throws Exception {
				// TODO Auto-generated method stub
				arg0.addAll(arg1);
				return arg0;
			}
		};
		TreeSet<String> finalRdd3 = rdd.treeAggregate(zero, mergeValue, mergePartition);
		double add = 0d;
		for (String string : finalRdd3) {
			String[] data = string.split(",");
			add = add + Double.parseDouble(data[1]);
		}
		System.out.println(add);
		String sumTreeReduce = rdd.treeReduce(new Function2<String, String, String>() {
			private static final long serialVersionUID = 89898;

			@Override
			public String call(String arg0, String arg1) throws Exception {
				String[] data = arg1.split(",");
				String[] data1 = arg0.split(",");
				data1[1] = String.valueOf(Double.parseDouble(data1[1]) + Double.parseDouble(data[1]));
				return new StringBuilder(data1[0] + "," + data1[1]).toString();
			}
		});
		System.out.println(sumTreeReduce);
	}
}