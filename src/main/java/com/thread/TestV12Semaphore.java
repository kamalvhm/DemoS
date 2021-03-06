package com.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;



public class TestV12Semaphore {

	
	public static void main(String args[]) throws InterruptedException {
		
		ExecutorService e =Executors.newCachedThreadPool();
		
		for(int i=0;i<200;i++) { //we are creating 200 connection here 
			e.submit(()->{
				Connections.instance.connect();
			});
		}
		
		
		e.shutdown();
		e.awaitTermination(1, TimeUnit.HOURS); //main thread will wait 
	}
	
	


	
}
