package com.acrossPart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import static org.apache.spark.sql.functions.*;

public class Demo {

	public static void main(String[] args) {
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkSession spark=SparkSession.builder().appName("A").master("local").getOrCreate();
		JavaSparkContext jsc=new JavaSparkContext(spark.sparkContext());
		Dataset<Row> df =spark.read().option("header", true).csv("src/main/resources/exam/student.csv");
		//df.createOrReplaceTempView("Student");
		
		//df=spark.sql("select avg(score) from student where subject='English'");
		//df.show();
	
		
		//Dataset<Row> dataset=df.filter("subject ='Modern Art' AND year > 2007");
		//Dataset<Row> dataset=df.filter(r->r.getAs("subject").equals("Morder Art") && Integer.parseInt(r.getAs("year"))>=2007);
	
		//df.createOrReplaceTempView("student");
		
		/*Dataset<Row> dataset=spark.sql("select avg(score) from student where subject='English'");
		dataset.show();*/
		
		List<Row> inMemory=new ArrayList<>();
		inMemory.add(RowFactory.create("WARN","2016-12-31 04:19:32"));
		inMemory.add(RowFactory.create("FATAL","2016-12-31 03:22:34"));
		inMemory.add(RowFactory.create("WARN","2016-12-31 03:21:21"));
		inMemory.add(RowFactory.create("INFO","2015-04-21 14:32:21"));
		inMemory.add(RowFactory.create("FATAL","2015-04-21 19:23:20"));
		
		StructField[] fields= {
				new StructField("level",DataTypes.StringType,false,Metadata.empty()),
				new StructField("date_time",DataTypes.StringType,false,Metadata.empty())

		};
		
		StructType schama=new StructType(fields);
		
		Dataset<Row> ddf=spark.createDataFrame(inMemory, schama);
		ddf.createOrReplaceTempView("logging");
		
		Dataset<Row> results=spark.sql("select level,collect_list(date_time) from logging group by level order by level");
		results.show();
		spark.close();
		

	}
	
	
	public void old() {
/*SparkConf conf=new SparkConf().setAppName("A").setMaster("local");
		
		JavaSparkContext jsc=new JavaSparkContext(conf);*/
		SparkSession spark =SparkSession.builder().appName("A").master("local").getOrCreate();
		JavaSparkContext jsc=new JavaSparkContext(spark.sparkContext());
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		
		
		JavaRDD<Integer> rdd=jsc.parallelize(list);
		//Integer val=rdd.reduce((val1,val2)->val1+val2);
		
		rdd=rdd.map(r->2*r);
		rdd.foreach(r->System.out.print(r+". "));
		
		//TO read in Rdd 
		JavaRDD<String> initRDD = jsc.textFile("src/main/resources/input.txt");
		JavaRDD<String> rddd=jsc.textFile("src/main/resources/exam/student.csv");

		
		//To convert to DataFrame
		Dataset<Row> data = spark.createDataFrame(rdd, String.class);
		
		data.select(col("name"), col("rating"));
		data.createOrReplaceTempView("TestView");
		
	}

}
