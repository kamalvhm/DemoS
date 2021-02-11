package com.thread;

public class Test {

	public static void main(String[] args) {
		
		//Below are two ways to create Thread in java 
		//1)extending Thread Class 
		//2)implement Runnable Interface (Required Thread class instance)
		ThreadExtend t1=new ThreadExtend();
		t1.start();
		
		RunnableImplement r=new RunnableImplement();
		Thread t2=new Thread(r);
		t2.start();

	}

}
