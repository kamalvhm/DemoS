package com.acrossPart;

import static org.apache.spark.sql.functions.callUDF;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.date_format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import com.udm.Util;

import scala.Tuple2;

public class DD {

	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> initRDD = sc.textFile("src/main/resources/input.txt");
		JavaRDD<String> lettersOnlyRDD=initRDD.map(stnc->stnc.replaceAll("[^a-zA-Z\\s]", "").toLowerCase());
		JavaRDD<String> removedblankRDD=lettersOnlyRDD.filter(stnc->stnc.trim().length()>0);
		JavaRDD<String> justWords=removedblankRDD.flatMap(stnc->Arrays.asList(stnc.split(" ")).iterator());
		JavaRDD<String> interastingWords=justWords.filter(w->Util.isNotBoaring(w));
		JavaPairRDD<String ,Long> pairRdd=interastingWords.mapToPair(w->new Tuple2<String,Long>(w,1L));
		JavaPairRDD<String ,Long> totals= pairRdd.reduceByKey((v1,v2)->v1+v2);
		JavaPairRDD<Long ,String> switched=totals.mapToPair(tuple->new Tuple2<Long,String>(tuple._2,tuple._1));
		JavaPairRDD<Long ,String> sorted=switched.sortByKey(false);
		sorted=sorted.coalesce(1);
		List<Tuple2<Long ,String>> result=sorted.take(10);	
		result.forEach(v->System.out.println(v));/**DataTypes.BooleanType this is to tell spark return type */
		
		SparkSession spark =SparkSession.builder().appName("APP").master("local[*]").config("spark.sql.warehouse.dir","file:///c:/tmp/").getOrCreate();
		spark.udf().register("hasPassed", (String grade,String subject)-> {//UDF REGISTER
			if(subject.equals("Gio")) {
				if(grade.startsWith("A")) return true;
				else return false;
			}
			return grade.startsWith("A") || grade.startsWith("B");
			}, DataTypes.BooleanType);//DataTypes.BooleanType this is to tell spark return type 
		Dataset<Row> dataset=spark.read().option("header", true).csv("src/main/resources/exam/student.csv");
		dataset=dataset.withColumn("pass", callUDF("haspassed", col("grade"),col("subject"))); //TO ADD NEW COLUMN
		
		//DataTypes.BooleanType this is to tell spark return type 
		Dataset<Row> results = spark.sql("select level,date_format(datetime,'MMMM') as month ,cast(first(date_format(datetime,'M')) as int) monthnum,count(1) as total "
				+ "from logging_table group by level,month order by monthnum");
		dataset=dataset.select(col("level"),
				date_format(col("datetime"),"MMMM").alias("month"),
				date_format(col("datetime"),"M").alias("monthnum").cast(DataTypes.IntegerType));
		dataset=dataset.groupBy(col("level"),col("month"),col("monthnum")).count().as("total");
		dataset=dataset.drop(col("monthnum"));
		
		List<Row> inMemory=new ArrayList<>();
		inMemory.add(RowFactory.create("WARN","2016-12-31 04:19:32"));
		StructField[] fields=new StructField[] {
				new StructField("level",DataTypes.StringType,false,Metadata.empty()),
				new StructField("datetime",DataTypes.StringType,false,Metadata.empty())
		};StructType schema=new StructType(fields);
		Dataset<Row> results2 = spark.sql("select level,collect_list(datetime) from logging_table group by level order by level");
		

	}

}
