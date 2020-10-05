package com.udm;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.*;

//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class UdmDataset1 {

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		
		//SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		//JavaSparkContext sc = new JavaSparkContext(conf);
		SparkSession spark =SparkSession.builder().appName("APP").master("local[*]").config("spark.sql.warehouse.dir","file:///c:/tmp/").getOrCreate();
		
		Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/exam/student.csv");
	/*	dataset.show();
		
		Row firstrow=dataset.first();
		
		String subject=firstrow.getAs("subject").toString();
		System.out.println(subject);*/
		//fileter using string expression
		//Dataset<Row> modernArtResults = dataset.filter("subject = 'Modern Art' AND year >= 2007");
		
		
		//fileter using lambda
		Dataset<Row> modernArtResults2 = dataset.filter(row->row.getAs("subject").equals("Modern Art")
				&& Integer.parseInt(row.getAs("year"))>=2007);
		
		Column subjectColumn=dataset.col("subject");
		Column yearColumn=dataset.col("year");

		//Dataset<Row> modernArtResults3 = dataset.filter(subjectColumn.equalTo("Modern Art").and(yearColumn.geq(2007)));
		
		
		//Dataset<Row> modernArtResults3 = dataset.filter(col("subject").equalTo("Modern Art").and(col("year").geq(2007)));
		
		
		dataset.createOrReplaceTempView("students");
			
		spark.sql("select avg(score) from students where subject ='English'").show();
		
		//modernArtResults2.show();
		spark.close();
	}

}
