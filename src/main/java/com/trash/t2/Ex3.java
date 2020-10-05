package com.trash.t2;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.Optional;
import org.apache.spark.sql.SparkSession;

import scala.Tuple2;

public class Ex3  implements A{

	public static void main(String[] args) throws Exception{
		A a =new Ex3();
		a.printstatus();
		a.changeGear();
		a.DefMethod();
		A.stMethod();
	}

	

	@Override
	public void changeGear() {
		// TODO Auto-generated method stub
		System.out.println("GEAR STATUS");
	}



	@Override
	public void printstatus() {
		// TODO Auto-generated method stub
		System.out.println("PRINT STATUS");

	}


}
