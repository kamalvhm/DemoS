package com.spark;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.dense_rank;
import static org.apache.spark.sql.functions.rank;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.expressions.Window;
import org.apache.spark.sql.expressions.WindowSpec;

public class WindowFunctions {
	//https://timepasstechies.com/window-functions-in-spark-sql-and-dataframe-ranking-functionsanalytic-functions-and-aggregate-function/
	public static void main(String[] args) {
		 
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark =SparkSession.builder().appName("windowF").master("local").getOrCreate();
		
		Dataset<Row> df=spark.read().csv("src/main/resources/ds/small_sample.txt").toDF("name","department","salary");
		df.createOrReplaceTempView("Emp");
		
		/** AVG WITH ROW AND RANGE */
		/* df=spark.sql("select * ,AVG(salary) over (partition By department order by salary desc"
				+ " rows between unbounded preceding and current row ) as ranks "
				+ "from Emp");*/
		/** DENSE RANK */
		/*df=spark.sql("select * ,dense_rank() over (partition By department order by salary desc) as ranks "
				+ "from Emp");*/
		
		//df.createOrReplaceTempView("result");
		
		/** SINGLE VALUE FROM TABLE  */
		//df=spark.sql("select salary from result where department ='WATER' and ranks =1");
		/** ROW NUMBER */
		/*df=spark.sql("select * ,row_number() over (partition By department order by salary desc) as ranks "
				+ "from Emp");*/
		/**PERCENT_RANK() – Calculates the relative rank of a row within a group of rows. 
		 *NTILE() – The ntile function takes an integer as an input and divides the records of the result set into that number of groups.
		 * (NTile will in below queries based on salry in two parts 0 to 400 and 400+ to Rest) */
		/*	df=spark.sql("select * , percent_rank () over (order by salary desc) as percent_ranks, "
				+ " ntile(2) over ( order by salary desc) as nTiles from Emp ");*/
		/** CUME_DIST() :-Calculates the cumulative distribution of a value in a group of values . 
		 	It computes the relative position of a specified value in a group of values..*/
		/*df=spark.sql("select * , cume_dist() over (order by salary desc) as CUME_DISTs " + " from Emp ");*/
		/** FIRST VALUE */
		/*df=spark.sql("select * ,first_value(salary) over (partition By department order by salary desc"
				+ " ) as first_value from Emp");*/
		
		/**Lead and Lag */
		df = spark.sql("select *, lead(salary,1,-1) over (order by salary desc) as leads, lag(salary,1,-1) over (order by salary desc) as leg "
				+ "from Emp");
		
		df.show();
		
		//otherWay(spark);
	}
	
	public static void otherWay(SparkSession spark) {
		Dataset<Row> emp=spark.read().csv("src/main/resources/ds/small_sample.txt").toDF("name","department","salary");

		WindowSpec window = Window.partitionBy(col("department")).orderBy(col("salary").desc());
		Column column_rank = rank().over(window);
		emp.select(col("name"), col("department"), col("salary"), column_rank.as("rank")).where(col("rank").leq(2)).show();
		Column column_dense_rank = dense_rank().over(window);
		emp.select(col("name"), col("department"), col("salary"), column_dense_rank.as("rank")).where(col("rank").leq(2)).show();
		
	}
	
	public static void rowNumberFunction(SparkSession spark) {
				Dataset<Row> emp=spark.read().csv("src/main/resources/ds/small_sample.txt").toDF("name","department","salary");

				WindowSpec window=Window.partitionBy(col("department")).
				orderBy(col("salary").desc());
				/*Column column_row = row_number().over(window);
				emp.select(col("name"),col("department"),
				col("salary"),column_row.as("row_num")).show();*/
	}
	
	//percent_rank – Calculates the relative rank of a row within a group of rows.

	//ntile – The ntile function takes an integer as an input and divides the records of the result set into that number of groups.
	
	public static void percentRankAndNtileFunction(SparkSession spark) {
		Dataset<Row> emp=spark.read().csv("src/main/resources/ds/small_sample.txt").toDF("name","department","salary");

	/*	WindowSpec window = Window.partitionBy(col("dep")).orderBy(col("sal").desc());
		Column percentRank = percent_rank().over(window);
		emp.select(col("name"), col("dep"), col("sal"), percentRank.as("percentRank")).show();
		Column ntile = ntile(2).over(window);
		emp.select(col("name"), col("dep"), col("sal"), ntile.as("ntile")).show();*/
}
	//cume_dist – Calculates the cumulative distribution of a value in a group of values . It computes the 
	//relative position of a specified value in a group of values.
	public static void AnalyticFunction(SparkSession spark) {
		Dataset<Row> emp=spark.read().csv("src/main/resources/ds/small_sample.txt").toDF("name","department","salary");

		/*		WindowSpec window=Window.partitionBy(col("dep")).
				orderBy(col("sal").desc());
				Column cume_dist=cume_dist().over(window);
				emp.select(col("name"),col("dep"),col("sal"),
				cume_dist.as("cume_dist")).show();*/
		
		//FIRST_VALUE 
			/*	WindowSpec window=Window.partitionBy(col("dep")).
				orderBy(col("sal").desc());
				Column first=first(col("sal")).over(window);
				emp.select(col("name"),col("dep"),col("sal"),
				first.as("first")).show();*/
		
		//Lead and LAG

/*		WindowSpec window = Window.partitionBy(col("dep")).orderBy(col("sal").desc());
		Column lag = lag(col("sal"), 1, 0).over(window);
		Column lead = lead(col("sal"), 1, 0).over(window);
		emp.select(col("name"), col("dep"), col("sal"), lag.as("lag"), lead.as("lead")).show();*/
}

}
