package com.udm.streaming;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.OutputMode;
import org.apache.spark.sql.streaming.StreamingQuery;
import org.apache.spark.sql.streaming.StreamingQueryException;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class UdmStrmStructuredStream {


	public static void main(String[] args) throws InterruptedException { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		Logger.getLogger("org.apache.spark.storage").setLevel(Level.ERROR);


		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		SparkSession session=SparkSession.builder().master("local[*]").appName("Sprk").getOrCreate();
		//in format we can set source mode 
		Dataset<Row> df=session.readStream().format("kafka")
				.option("kafka.bootstrap.servers", "localhost:9092")
				.option("subscribe", "viewrecord")
				.load();
		
		//start some df operations
		df.createOrReplaceTempView("viewing_figures");
		//key value ,timestamp
		Dataset<Row> results=session.sql("select cast(value as string) as course_name from viewing_figures");
		//To write data after processing 
		//https://spark.apache.org/docs/latest/structured-streaming-programming-guide.html#output-sinks
		StreamingQuery query=results
		.writeStream()
		.format("console")
		.outputMode(OutputMode.Append())
		.start();
		
		//This will result of infinite processing of batches
		try {
			query.awaitTermination();
		} catch (StreamingQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
