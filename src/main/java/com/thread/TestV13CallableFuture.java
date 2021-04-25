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

public class TestV13CallableFuture {
	/*********************************
	 * Future:-Future is parameterized it shows the return value type
	 * Callable:-Runnable can't return any value Callable on the other hand return future obj ,its a parameter 
	 * class Callable<Integer> it shows the return type
	 * 
	 * 
	 * 
	 * 
	 *********************************/

	public static void main(String args[]) throws InterruptedException {

		ExecutorService e = Executors.newCachedThreadPool();

			Future<Integer> future =e.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					
					Random r=new Random();
					int duration =r.nextInt(4000);
					
					if(duration>2000) { // we can also throw exception and future.get will throw ExecutionException for this 
						//that ExecutionException will have this exception in cause 
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
					return duration;//we are returning duration 
				}
			});
		

		e.shutdown();
		
		try {//get will block untill the thread associated with this future completes  so ExecutionException and usual 
			//InterruptedException above declaired 
			System.out.println("Result is "+future.get()); //future.get will give result it throws two exception
		} catch (ExecutionException e1) {
			IOException ioe=(IOException) e1.getCause();//this will give original IO exception 
		System.out.println(e1);
		}

	}

}
