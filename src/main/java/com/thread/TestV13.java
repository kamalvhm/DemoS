package com.thread;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestV13 {

	public static void main(String args[]) throws InterruptedException {

		ExecutorService e = Executors.newCachedThreadPool();

			Future<Integer> future =e.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					
					Random r=new Random();
					int duration =r.nextInt(4000);
					
					if(duration>2000) {
						throw new IOException("sleeping to long");
					}
					
					System.out.println("starting");
					try {
						Thread.sleep(duration);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("Finish");
					return duration;
				}
			});
		

		e.shutdown();
		
		try {
			System.out.println("Result is "+future.get());
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			IOException ioe=(IOException) e1.getCause();
		System.out.println(e1);
		}

	}

}
