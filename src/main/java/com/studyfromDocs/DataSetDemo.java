package com.studyfromDocs;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class DataSetDemo {
	
	public static void main(String args[]) {
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		
		
		SparkSession spark=SparkSession.builder().appName("Demo").master("local").getOrCreate();
		
		//DataFrame
		//Dataset<Row> df=spark.read().json("src/main/resources/people.json");
		
		//df.createOrReplaceTempView("peaple");
		
		//spark.sql("select * from peaple").show();
		
		Encoder<Person> encoder= Encoders.bean(Person.class);
		Dataset<Person> ds=spark.read().json("src/main/resources/people2.json").as(encoder);

		try {
			ds.createGlobalTempView("people2");
		} catch (AnalysisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		spark.sql("select * from people2").show();
	}

}
