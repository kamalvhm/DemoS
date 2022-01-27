package com.acrossPart;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

public class ABC {

	public static void main(String[] args) {
		
//		Logger.getLogger("org.apache").setLevel(Level.WARN);
//		SparkSession spark=SparkSession.builder().appName("wc").master("local").getOrCreate();
//		JavaSparkContext sc=new JavaSparkContext(spark.sparkContext());
//
//		List<Integer> list=new ArrayList<>();
//		list.add(1);
//		list.add(1);
//		list.add(3);
//		list.add(3);
//
//		JavaRDD<Integer> rdd=sc.parallelize(list);
//		
//		System.out.print(rdd.distinct().collect());
		String a="abcd",b="abca";
		System.out.print(maxSubsequenceSubString(a,b,a.length(),b.length()));
	}
	
	public static int solve(String x,String y,int n,int m) {
		System.out.println(n+" <-N M-> "+m);
		if(n==0 || m ==0)return 0;
		if(x.charAt(n-1)==y.charAt(m-1))
			return 1+solve(x,y,n-1,m-1);
		else return solve(x,y,n-1,m);
	}
	
	static int maxSubsequenceSubString(String X, String Y, int n, int m) {
		System.out.println(n+" <-N M-> "+m);

// Base Case
		if (n == 0 || m == 0)
			return 0;

// Calls on smaller inputs

// if the last char of both Strings are equal
		if (X.charAt(n - 1) == Y.charAt(m - 1)) {
			return 1 + maxSubsequenceSubString(X, Y, n - 1, m - 1);
		}

// if the last char of both Strings are not equal
		else {
			return maxSubsequenceSubString(X, Y, n - 1, m);
		}
	}

	
	

}
