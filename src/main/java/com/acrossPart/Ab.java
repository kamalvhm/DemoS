package com.acrossPart;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import static org.apache.spark.sql.functions.*;
import com.beans.Weather;

import io.netty.buffer.SwappedByteBuf;

public class Ab {

	public static void main(String[] args) throws IOException {
		
		
		Long enumSixtyToFifteen=new Long(1);
		int i=1;
		Long.valueOf(i);
		System.out.print("EQ "+(enumSixtyToFifteen.equals(Long.valueOf(i))));

		
		
		/*//print(5);
		//System.out.println("A".compareTo("Z"));
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark = SparkSession.builder().appName("Demo").master("local").getOrCreate();
		spark.sparkContext().setLogLevel("ERROR");
		
		Dataset<Row> weatherDataset = spark.read().option("header", true).csv("src/main/resources/weather.txt");
		JavaRDD<Weather> wheatherRDD = weatherDataset.toJavaRDD().repartition(2).map(line -> {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			String[] parts = line.split(",");
			Weather w = new Weather();
			w.setId(Integer.parseInt(parts[0].trim()));
			w.setDate(formatter.parse(parts[1].trim()));
			w.setTemp(Integer.parseInt(parts[2].trim()));
			return w;
		});
		Dataset<Row> NewweatherDataset=weatherDataset.withColumn("Centi", functions.lit(col("TEMP")));
		NewweatherDataset.printSchema();
		NewweatherDataset.show(10,false);
		List<Weather> result1=wheatherRDD.take(2);
		result1.forEach(v->System.out.println(v));
		
		//Now transforming F to C formula C=(F-32)*5/9 

		//dF.write.format("parquet").save("<<location>>");
*/	}
	
	private static void print(int n) {
		if(n==0)
			return;
		System.out.println(n);
		print(n-1);
	}

	public static void solve() {
		Scanner s = new Scanner(System.in);
		long row = s.nextLong();
		long column = row;
		HashSet<Long> rowcount = new HashSet();
		HashSet<Long> coulumncount = new HashSet();

		long testcase = s.nextLong();

		for (long x = 0; x < testcase; x++) {
			long r = s.nextLong();
			long c = s.nextLong();
			if (!rowcount.contains(r)) {
				row--;
				rowcount.add(r);
			}

			if (!coulumncount.contains(c)) {
				column--;
				coulumncount.add(c);
			}

			System.out.print(row * column + " ");
		}
	}
	
	
	
}
