package com.udm;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;


public class UdmDataset8UDF {
//*******************UDF****************
	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkSession spark =SparkSession.builder().appName("APP").master("local[*]").config("spark.sql.warehouse.dir","file:///c:/tmp/").getOrCreate();

		//Step 1 to add user define function  -register
		spark.udf().register("hasPassed", (String grade,String subject)-> {
			if(subject.equals("Gio")) {
				if(grade.startsWith("A")) return true;
				else return false;
			}
			return grade.startsWith("A") || grade.startsWith("B");
			}, DataTypes.BooleanType);//DataTypes.BooleanType this is to tell spark return type 
		
		Dataset<Row> dataset=spark.read().option("header", true).csv("src/main/resources/exam/student.csv");
		//To add new column
		//To add column on dataset we use withColumn we are dinamically building col by passing literal value 
		
		//dataset=dataset.withColumn("pass", lit(col("grade").equalTo("A+")));//this will add TRUE if A+ and FALSE if not
		
		//but if your requirement is complex then we use UDF to solve this
		//UDF allow us to add our own function in to spark API
		dataset=dataset.withColumn("pass", callUDF("haspassed", col("grade"),col("subject")));

		dataset.show();
		
		spark.close();
	}

}
