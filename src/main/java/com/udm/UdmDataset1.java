package com.udm;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.AnalysisException;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.beans.Student2;

import static org.apache.spark.sql.functions.*;
//*#*#*:-https://www.youtube.com/watch?v=JRJzxdrj7YU
//flatMap in map for one input we had one output 24 and sqrt(24) but in flat map we can have
//multiple output or no output
public class UdmDataset1 {

	public static void main(String[] args) { 
		Logger.getLogger("org.apache").setLevel(Level.WARN);

		System.setProperty("hadoop.home.dir",
				"C:\\Users\\z00427hs\\Downloads\\winutils-master\\winutils-master\\hadoop-3.0.0");

		
		//SparkConf conf = new SparkConf().setAppName("dem").setMaster("local[*]");
		//JavaSparkContext sc = new JavaSparkContext(conf);
		SparkSession spark =SparkSession.builder().appName("APP").master("local[*]")
				.config("spark.sql.warehouse.dir","file:///c:/tmp/").getOrCreate();
		
		Dataset<Row> dataset = spark.read().option("header", true).csv("src/main/resources/exam/student.csv");
/*		Dataset<Student2> ds=spark.read().option("header", true).csv("src/main/resources/exam/student.csv")
				.as(org.apache.spark.sql.Encoders.bean(Student2.class));*/
		dataset.show();
		//dataset.queryExecution().executedPlan(); //this is to print execution Plan
		//returns the first row
		Row firstrow=dataset.first();
		//get and get is to get column 
		//firstrow.get(0); if header is not there other wise getAs as below 
		String subject=firstrow.getAs("subject").toString();
		System.out.println(subject);
		//FIRST APPROACH
		//Filter using string expression some what like sql
		Dataset<Row> modernArtResults = dataset.filter("subject = 'Modern Art' AND year >= 2007");
		
		//SECOUND APPROACH
		//Filter using lambda
		Dataset<Row> modernArtResults2 = dataset.filter(row->row.getAs("subject").equals("Modern Art")
				&& Integer.parseInt(row.getAs("year"))>=2007);
		//THIRD APPROACH-selecting column first and then adding constants in filter using them
		Column subjectColumn=dataset.col("subject");
		Column yearColumn=dataset.col("year");
		//greater then equal to geq 
		Dataset<Row> modernArtResults3 = dataset.filter(subjectColumn.equalTo("Modern Art").and(yearColumn.geq(2007)));
		
		//In ABove method we have to have these col instance but we can create these with static imported function class 
		//directly as below 
		Dataset<Row> modernArtResults4 = dataset.filter(col("subject").equalTo("Modern Art").and(col("year").geq(2007)));
		
		/**we can write sql statement using temp view it create temporary tables (it create in memory table)
		 * which we can use to create sql by sparksession obj dot sql
		 * 
		 */
		dataset.createOrReplaceTempView("students");
			
		spark.sql("select avg(score) from students where subject ='English'").show();
		
		//modernArtResults2.show();
		spark.close();
	}
	
	/**ALL THREE WAYS (OTHER IS TEMP VIEW ALSO BESIDES THESE )
	    1) ds=ds.filter("subject = 'Modern Art' AND year > 2007");
		2) ds=ds.filter(r->r.getAs("subject").equals("Modern Art") && Integer.parseInt(r.getAs("year"))>2007);
		3) dataset.filter(col("subject").equalTo("Modern Art").and(col("year").geq(2007)));
	    4) dataset.createOrReplaceTempView("students");
			
		spark.sql("select avg(score) from students where subject ='English'").show();
	 * 
	 */

}
