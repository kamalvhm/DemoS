package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Processor2 implements Runnable{
	private int id;
	
	Processor2(int id){
		this.id=id;
	}
	@Override
	public void run() {
		System.out.println("Starting :"+id);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Finished :"+id);

	}
	
}


public class TestV5ExecutorFr {

	
	public static void main(String args[]) {
		
		ExecutorService e=Executors.newFixedThreadPool(2);
		for(int i=0;i<10;i++) {
			e.submit(new Processor2(i));

		}
		e.shutdown();
		
		System.out.println("SUBMITTED!!!!!");

		
		try {
			e.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Finished!!!!!");

	}
}
