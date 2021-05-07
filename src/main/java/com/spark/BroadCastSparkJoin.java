package com.spark;

import static org.apache.spark.sql.functions.broadcast;
import static org.apache.spark.sql.functions.col;
import java.util.Arrays;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;


public class BroadCastSparkJoin {
	public static void main(String[] args) {
		SparkSession session = SparkSession.builder()
				.config("spark.hadoop.fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
				.config("spark.hadoop.fs.s3a.access.key", "access_key_amazon")
				.config("spark.hadoop.fs.s3a.secret.key", "secret_key_amazon").config("spark.speculation", "false")
				.config("fs.s3a.connection.ssl.enabled", "false").config("spark.network.timeout", "600s")
				.config("spark.sql.codegen.wholeStage", "false").config("spark.executor.heartbeatInterval", "500s")
				.config("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
				.config("mapreduce.fileoutputcommitter.algorithm.version", "2").getOrCreate();
		
	/*	scala.collection.Seq<String> paths = com.wdc.ddp.utility.Util.javaListToScalaSeq(Arrays.asList(args));
		Dataset<Row> largeDataSet = session.read().format("com.databricks.spark.avro").load(paths);
		Dataset<Row> smallDataSet = session.read().format("com.databricks.spark.avro").load("small_data_path");
		Dataset<Row> joinedDataset = largeDataSet
				.join(broadcast(smallDataSet),//this is to cnsure small is broadcasted
						col("largeDataSet .column1").equalTo(col("smallDataSet .column1"))
								.and(col("largeDataSet .column2").equalTo(col("smallDataSet .column2")))
								.and(col("largeDataSet .column3").equalTo(col("smallDataSet .column3")))
								.and((col("largeDataSet .column4").equalTo(col("smallDataSet .column4")))))
				.select(col("largeDataSet .*"));
		joinedDataset.write().mode(SaveMode.Overwrite).format("com.databricks.spark.avro").save();*/
	}
}