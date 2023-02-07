package com.spark;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import com.beans.Person;

import scala.Tuple2;

public class ZipWithIndex {
	
	public static void main(String args[]) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		/*JavaRDD<Reading> readingsRDD = map.filter(r -> r._2 == null).map(r -> r._1);
		int batchSize = 100;
		JavaPairRDD<Reading, Long> readingLongJavaPairRDD = readingsRDD.zipWithIndex();
		JavaPairRDD<Long, Reading> longReadingJavaPairRDD = readingLongJavaPairRDD
				.mapToPair(r -> new Tuple2<>((r._2 / batchSize), r._1));
		List<Reading> list = new ArrayList<>();
		JavaPairRDD<Long, List<Reading>> integerListJavaPairRDD = longReadingJavaPairRDD.aggregateByKey(list,
				(rq0, rq1) -> {
					rq0.add(rq1);
					return rq0;
				}, (rql0, rql1) -> {
					rql0.addAll(rql1);
					return rql0;
				});*/
		
		SparkSession spark=SparkSession.builder().appName("app").master("local").getOrCreate();
		JavaSparkContext jsc=new JavaSparkContext(spark.sparkContext());
		
		List<Person> list=new ArrayList<>();
		list.add(new Person("A",10,1));
		list.add(new Person("B",20,2));
		list.add(new Person("C",30,3));
		list.add(new Person("D",40,4));
		list.add(new Person("E",50,5));
		list.add(null);
		list.add(new Person(null,50,6));

		JavaRDD<Person> rdd=jsc.parallelize(list);
		rdd=rdd.filter(r->r!=null && r.getName()!=null);
		int batchSize = 3;
		JavaPairRDD<Person, Long> personLongJavaPairRDD = rdd.zipWithIndex();
		
		
		JavaPairRDD<Long, Person> longReadingJavaPairRDD = personLongJavaPairRDD
				.mapToPair(r -> new Tuple2<>((r._2 / batchSize), r._1));
		
		List<Person> temp = new ArrayList<>();
		JavaPairRDD<Long, List<Person>> integerListJavaPairRDD = longReadingJavaPairRDD.aggregateByKey(temp,
				(rq0, rq1) -> {
					rq0.add(rq1);
					return rq0;
				}, (rql0, rql1) -> {
					rql0.addAll(rql1);
					return rql0;
				});
		
		integerListJavaPairRDD.foreach(r->{
			System.out.println("NEW BATCH "+r._1);
			System.out.println(" BATCH List "+r._2);

		});

	}

}
