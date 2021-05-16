package com.practice;

import static org.apache.spark.sql.functions.col;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;

import com.beans.WeatherData;

public class JPMC2 {
	/**
	 * check for details JavaSparkSQLExample
	 * @param args
	 */
	public static void main(String args[]) {
		//32°F − 32) × 5/9 = 0°C
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark=SparkSession.builder().appName("jp").master("local").getOrCreate();
		
		
		Dataset<WeatherData> ds=spark.read().option("header", true).csv("src/main/resources/weather.txt")
				.as(Encoders.bean(WeatherData.class));
		
		Dataset<Row> df =ds.withColumn("Centi", col("tempInF").minus(32).multiply(5).divide(9).cast(DataTypes.LongType));
		df.write().format("parquet").save("src/main/resources/ds/temp.parquet");
		//df.show();
		spark.close();
		
	}
}
