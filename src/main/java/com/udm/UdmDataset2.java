package com.udm;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class UdmDataset2 {

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

//		System.setProperty("hadoop.home.dir",
//				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkSession spark =SparkSession.builder().appName("APP").master("local[*]").config("spark.sql.warehouse.dir","file:///c:/tmp/").getOrCreate();

		//we will use this in memory collection to create dataset, RowFactory is to create spark type row 
		List<Row> inMemory=new ArrayList<>();
		inMemory.add(RowFactory.create("WARN","2016-12-31 04:19:32"));
		inMemory.add(RowFactory.create("FATAL","2016-12-31 03:22:34"));
		inMemory.add(RowFactory.create("WARN","2016-12-31 03:21:21"));
		inMemory.add(RowFactory.create("INFO","2015-04-21 14:32:21"));
		inMemory.add(RowFactory.create("FATAL","2015-04-21 19:23:20"));

		
		StructField[] fields=new StructField[] {
				new StructField("level",DataTypes.StringType,false,Metadata.empty()),
				new StructField("datetime",DataTypes.StringType,false,Metadata.empty())
		};
		//schema is an object to tell spark what are the datatypes of each column are  
		StructType schema=new StructType(fields);
		//to create data frame from inmemo0ry we need StructType and StructField
		Dataset<Row> dataset=spark.createDataFrame(inMemory,schema);
		
		//Grouping the data 
		dataset.createOrReplaceTempView("logging_table");
		//we are also passing count aggregation function with group  collect_list =Collects and returns a list of non-unique elements
		//Dataset<Row> results = spark.sql("select level,count(datetime) from logging_table group by level order by level");
		Dataset<Row> results = spark.sql("select level,collect_list(datetime) from logging_table group by level order by level");

		results.show();
		//https://www.youtube.com/watch?v=UZt_tqx4sII
		//To get Query Plan of operation :- we read this query plan from bottom to top
		//Exchange :- means Shuffle is happening these are expensive operations (Exchange is perfomence bottleneck)
		//
		results.explain();

		spark.close();
	}

}
