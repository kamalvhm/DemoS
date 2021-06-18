package com.udm;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.plans.logical.Window;

import scala.Tuple2;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class Udm5 {


	
	
	public static void main(String[] args) { 
		//This program reads Data from input.txt clean it remove boaring words from it and print  words count with count Desc
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		
		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");

		JavaSparkContext sc = new JavaSparkContext(conf);

		JavaRDD<String> initRDD = sc.textFile("src/main/resources/input.txt");
		//Replacing all char which are not words with empty
		JavaRDD<String> lettersOnlyRDD=initRDD.map(stnc->stnc.replaceAll("[^a-zA-Z\\s]", "").toLowerCase());
		//Removing blank lines
		JavaRDD<String> removedblankRDD=lettersOnlyRDD.filter(stnc->stnc.trim().length()>0);
		
		//now taking out only words from statments 
		JavaRDD<String> justWords=removedblankRDD.flatMap(stnc->Arrays.asList(stnc.split(" ")).iterator());
		//filtering out boaring words		
		JavaRDD<String> interastingWords=justWords.filter(w->Util.isNotBoaring(w));
		//creating tuple with each word as 1 
		JavaPairRDD<String ,Long> pairRdd=interastingWords.mapToPair(w->new Tuple2<String,Long>(w,1L));
		//reducing by key
		JavaPairRDD<String ,Long> totals= pairRdd.reduceByKey((v1,v2)->v1+v2);
		//revering Rdd 
		JavaPairRDD<Long ,String> switched=totals.mapToPair(tuple->new Tuple2<Long,String>(tuple._2,tuple._1));
		//sorting by key -false is to true means Ascding false is desc
		JavaPairRDD<Long ,String> sorted=switched.sortByKey(false);
		//This will reduce no of partions to count "Take all data to single partion"
		sorted=sorted.coalesce(1);
		
		//This will not work as sort and foreach will print on each executor so it will create sckewed output
		//In this forEach is send to each partition and it  is running in parallel 
		//sorted.foreach(element->System.out.print(element));
		//System.out.print("Partition +>"+sorted.getNumPartitions());
		
		//Any action apart from foreach will give correct results for sorted ,so take will work here 
		List<Tuple2<Long ,String>> result=sorted.take(10);
//		
		result.forEach(v->System.out.println(v));

		sc.close();

	}

}
