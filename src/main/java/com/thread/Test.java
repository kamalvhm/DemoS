package com.thread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadExtend t1=new ThreadExtend();
		t1.start();
		
		RunnableImplement r=new RunnableImplement();
		Thread t2=new Thread(r);
		t2.start();

	}

}
