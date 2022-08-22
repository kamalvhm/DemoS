package com.thread;

public class TestV1TwoWays {

	public static void main(String[] args) {
		//https://www.youtube.com/watch?v=YdlnEWC-7Wo&list=PLBB24CFB073F1048E
		//Below are two ways to create Thread in java 
		//1)extending Thread Class 
		//2)implement Runnable Interface (Required Thread class instance)
		ThreadExtend t1=new ThreadExtend();
		t1.start();
		
		RunnableImplement r=new RunnableImplement();
		Thread t2=new Thread(r);//you can pass any runnable instance in thread constructer
		t2.start();

	}

}
