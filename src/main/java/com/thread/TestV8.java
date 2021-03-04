package com.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestV8 {
	//In this we will imlment same producer consumer patter with low level syncronization
	private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
	
	public static void main(String args[]) throws InterruptedException {
		Processor5 proc=new Processor5();
		//Producer Thread
		Thread t1 =new Thread(()->{
			try {
				proc.producer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		//Consumer Thread
		Thread t2 =new Thread(()->{
			try {
				proc.consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	
	

	}

	


	
}
