package dels;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

public class Basics {

	public static void main(String[] args) {
		// This Program will Aggrgate ALL errors and count no of Error type
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		List<String> inputData = new ArrayList<>();
		inputData.add("WARN: Tuesday 4 September 0405");
		inputData.add("ERROR: Tuesday 4 September 0408");
		inputData.add("FATAL: Wednesday 5 September 1632");
		inputData.add("ERROR: Friday 7 September 1854");
		inputData.add("WARN: Saturday 8 September 1942");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> originalLogMsg = sc.parallelize(inputData);

//		JavaPairRDD<String, String> pairRDD = originalLogMsg.mapToPair(rawValue -> {
//
//			String[] columns = rawValue.split(":");
//
//			String level = columns[0];
//			String date = columns[1];
//
//			return new Tuple2<>(level, date);
//		});
	
		
		/// NOW TO COUNT THE WARNINGS *reducebykey
		JavaPairRDD<String, Long> pairRDD2 = originalLogMsg.mapToPair(rawValue -> {

			String[] columns = rawValue.split(":");

			String level = columns[0];

			return new Tuple2<>(level, 1L);

		});
		

		JavaPairRDD<String, Long> sumRDD = pairRDD2.reduceByKey((val1, val2) -> val1 + val2);

		//sumRDD.foreach(tuple -> System.out.println(tuple._1 + " has " + tuple._2 + " instances"));
		sc.close();

	}
}
