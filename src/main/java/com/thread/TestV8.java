package com.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestV8 {

	private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
	
	public static void main(String args[]) throws InterruptedException {
		Processor5 proc=new Processor5();
		
		Thread t1 =new Thread(()->{
			try {
				proc.producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 =new Thread(()->{
			try {
				proc.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	
	

	}

	


	
}
