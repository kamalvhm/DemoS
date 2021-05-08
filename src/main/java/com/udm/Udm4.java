package com.udm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class Udm4 {

	public static void main(String[] args) {
		//Transforamtion :- filter,flatMap
		//This Program is to filter words length less then 4 (Just to keep Logs and Days)
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir", "C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");
		
		List<String> inputData = new ArrayList<>();
		inputData.add("WARN: Tuesday 4 Sep 0405");
		inputData.add("ERROR: Tuesday 4 Sep 0408");
		inputData.add("FATAL: Wednesday 5 Sep 1632");
		inputData.add("ERROR: Friday 7 Sep 1854");
		inputData.add("WARN: Saturday 8 Sep 1942");

		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		
		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> stance = sc.parallelize(inputData);
		
		// flat map is requires a iterator in return because value could be 0 or more you don't know iterator 
		//and as list is because split produce array and we need list
		JavaRDD<String> words=stance.flatMap(val -> Arrays.asList(val.split(" ")).iterator());

		JavaRDD<String> filtered_words =words.filter(word->word.length()>4);
		
		filtered_words.foreach(v->System.out.println(v));
		
		
		/*JavaRDD<String> peopleRDD = ((Object) sc.textFile("src/main/resources/people.txt", 1))
				.toJavaRDD();*/
		
		

		sc.close();

	}

}
