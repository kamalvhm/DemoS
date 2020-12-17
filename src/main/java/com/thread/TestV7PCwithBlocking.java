package com.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestV7PCwithBlocking {

	private static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
	
	public static void main(String args[]) throws InterruptedException {
		
		Thread t1 =new Thread(()->{
			try {
				producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 =new Thread(()->{
			try {
				consumer();
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

	
	public static void producer() throws InterruptedException {
		Random r=new Random();
		while(true) {
			queue.put(r.nextInt(100));
		}
	}
	
	
	
	public static void consumer() throws InterruptedException{
		Random r=new Random();
		
		while(true) {
			Thread.sleep(100);
			
			if(r.nextInt(10)==0) {
				Integer val=queue.take();
				
				System.out.println("Value :- " +val+" ; Queue Size :- "+queue.size());
			}
		}

	}
}
