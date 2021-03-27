package com.udm;

import static org.apache.spark.sql.functions.col;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

import com.beans.Person;
import com.beans.Weather;

public class JPMC {
	/**
	 * check for details JavaSparkSQLExample
	 * @param args
	 */
	public static void main(String args[]) {
		
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		/**CONVERTING DATASET TO RDD */
		Dataset<String> dataset = spark.read().option("header", true).textFile("src/main/resources/people3.txt");
		JavaRDD<Person> peopleRDD = dataset.toJavaRDD().repartition(10).map(line -> {
			String[] parts = line.split(",");
			Person person = new Person();
			person.setName(parts[0]);
			person.setAge(Integer.parseInt(parts[1].trim()));
			return person;
		});
		
		//List<Person> result=peopleRDD.take(2);
		//result.forEach(v->System.out.println(v.getName()));
		
		/**AGAIN CREATING DATA FRAME FROM RDD **/
		// Apply a schema to an RDD of JavaBeans to get a DataFrame
		Dataset<Row> peopleDF = spark.createDataFrame(peopleRDD, Person.class);
		// Register the DataFrame as a temporary view
		peopleDF.createOrReplaceTempView("people");
		
		
		/**You are getting DEVICE_ID,TIME_STAMP,TEMP (F)
		 * get this data and covert it to Centrigrade and write it to parque file
		 * https://www.tutorialkart.com/apache-spark/spark-add-new-column-to-dataset-example/
		 */
		Dataset<Row> weatherDataset = spark.read().option("header", true).csv("src/main/resources/weather.txt");
		/*JavaRDD<Weather> wheatherRDD = weatherDataset.toJavaRDD().repartition(2).map(line -> {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			String[] parts = line.split(",");
			Weather w = new Weather();
			w.setId(Integer.parseInt(parts[0].trim()));
			w.setDate(formatter.parse(parts[1].trim()));
			w.setTemp(Integer.parseInt(parts[2].trim()));
			return w;
		});*/
		/*Dataset<Row> NewweatherDataset=weatherDataset.withColumn("Centi", functions.lit(col("TEMP")));
		NewweatherDataset.printSchema();
		NewweatherDataset.show(10,false);*/
		
		//with column is to add new col
		Dataset<Row> NewweatherDataset = weatherDataset.withColumn("TEMP_IN_C", col("TEMP_IN_F").minus(32).multiply(5).divide(9));
	    NewweatherDataset.printSchema();
	    NewweatherDataset.show();
	    
	   // to save
	    NewweatherDataset.write().format("parquet").save("resources/temp.parquet");
	  // or
	  // NewweatherDataset.write().parquet("resources/temp_change.parquet");
		
		//Now transforming F to C formula C=(F-32)*5/9 
		
}
	
	/**
	 public static void main(String[] args) {

		 

		    Logger.getLogger("org.apache").setLevel(Level.ERROR);

		 

		    SparkSession spark = SparkSession.builder().appName("Demo").master("local[*]").getOrCreate();

		 

		    Dataset<WeatherData> weatherDataset = spark.read().option("header", true)
		        .csv("resources/weather.txt").as(Encoders.bean(WeatherData.class));

		 

		    weatherDataset.printSchema();
		    weatherDataset.show(10, false);

		 

		    // Now transforming F to C formula C=(F-32)*5/9

		 

		    Dataset<Row> cDataset =
		        weatherDataset.withColumn("TempInC", col("TempInF").minus(32).multiply(5).divide(9));

		 

		    cDataset.printSchema();
		    cDataset.show();

		 

		    // save in parquet format
		    // cDataset.write().format("parquet").save("resources/temp.parquet");
		    // or
		    // cDataset.write().parquet("resources/temp_change.parquet");
		  }
		  */
}
