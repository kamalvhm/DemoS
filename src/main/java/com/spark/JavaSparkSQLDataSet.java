package com.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

public class JavaSparkSQLDataSet {

	public static void main(String[] args) {

		Logger.getLogger("org.apache").setLevel(Level.WARN);

		SparkSession spark = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		List<Row> list = new ArrayList<Row>();
		list.add(RowFactory.create("one"));
		list.add(RowFactory.create("two"));
		list.add(RowFactory.create("three"));
		list.add(RowFactory.create("four"));

		List<org.apache.spark.sql.types.StructField> listOfStructField = new ArrayList<org.apache.spark.sql.types.StructField>();
		listOfStructField.add(DataTypes.createStructField("test", DataTypes.StringType, true));


		StructType structType = DataTypes.createStructType(listOfStructField);
		Dataset<Row> data = spark.createDataFrame(list,structType);
		

		data.printSchema();
		data.show();
		
		System.out.println("DataSet with Encoders");
		List<String> data1 = Arrays.asList("hello", "world");	
		Dataset<String> ds = spark.createDataset(data1, Encoders.STRING());
		ds.collect();
		ds.show();
		
		System.out.println("********Filter*****");
		Dataset<String> filtered = ds.filter((FilterFunction<String>) v -> v.startsWith("h"));
		filtered.show();

		
		
	}

}