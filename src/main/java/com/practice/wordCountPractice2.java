package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaSparkContext;
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

public class wordCountPractice2 {
	private static final Pattern SPACE = Pattern.compile(" ");

	public static void main(String[] args) {
			//src/main/resources/boaringwords.txt
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark=SparkSession.builder().appName("wc").master("local").getOrCreate();
		JavaSparkContext sc =new JavaSparkContext(spark.sparkContext());
	
		

		List<Row> inMemory=new ArrayList<>();
		inMemory.add(RowFactory.create("WARN","2016-12-31 04:19:32"));
		inMemory.add(RowFactory.create("FATAL","2016-12-31 03:22:34"));
		inMemory.add(RowFactory.create("WARN","2016-12-31 03:21:21"));
		inMemory.add(RowFactory.create("INFO","2015-04-21 14:32:21"));
		inMemory.add(RowFactory.create("FATAL","2015-04-21 19:23:20"));
		
		StructField [] felds= {
			new StructField("level" ,DataTypes.StringType,false,Metadata.empty())	,
			new StructField("date" ,DataTypes.StringType,false,Metadata.empty())
		} ;
		StructType type=new StructType(felds);
		Dataset<Row> ds=spark.createDataFrame(inMemory, type);
		
		//ds.createOrReplaceTempView("Logg");
		
		//ds=spark.sql("select level ,date_format(date,'MMMM') as month , date from Logg ");
		//ds.createOrReplaceTempView("Logg");

		//ds=spark.sql("select level,month,count(1),cast(first(date_format(date,'M')) as int)  as monthNum from Logg group by level,month order by monthNum");
		//ds.explain();
		ds =ds.select(col("level"),
					date_format(col("date"), "MMMM").alias("month"),
					date_format(col("date"), "M").alias("monthnum").cast(DataTypes.IntegerType));
		ds=ds.groupBy(col("level"),col("month"),col("monthnum")).count();
		ds=ds.orderBy(col("monthnum"));
		ds.show(10);

		spark.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	public static void main2(Strin args) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		SparkSession spark=SparkSession.builder().appName("WC").master("local").getOrCreate();
		
		Dataset<Row> dataset=spark.read().option("header", true).csv("src/main/resources/ds/biglog.txt");
		
		dataset.createOrReplaceTempView("logger");
		
		Dataset<Row> results = spark.sql("select level,date_format(datetime,'MMMM') as month ,cast(first(date_format(datetime,'M')) as int) monthnum,count(1) as total "
				+ "from logger group by level,month order by monthnum");
		
	
		results.show(10);
		spark.close();
	}*/

}
