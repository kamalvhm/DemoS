package com.acrossPart;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;
import static org.apache.spark.sql.functions.*;

public class PractSpark {

	
	public static void main(String args[]) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		SparkSession spark=SparkSession.builder().appName("wc").master("local").getOrCreate();
		
		//JavaSparkContext sc=new JavaSparkContext(spark.sparkContext());
		
		Dataset<Row> data=spark.read().option("header", true).option("inferSchema", true)
				.csv("D:/PackUp/DemoS/src/main/resources/exam/student.csv");
		
		
		//WindowSpec spec=Window.partitionBy(col("grade")).orderBy(col("score").desc());
		
		//data=data.withColumn("Rank", dense_rank().over(spec));
		//data =data.withColumn("RESULT", expr("CASE WHEN score > 45 THEN 'pass' ELSE 'fail' END"));
		data=data.withColumn("RESULT", lit(1));
		data.show();
						
		
	
		
	
	
	
	}
}
