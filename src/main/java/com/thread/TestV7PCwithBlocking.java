package com.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestV7PCwithBlocking {
	//you can simply imlement produces consumer pattern as no need to handle syncronisation is already handled in BQ
	//FIFO queue but its thread safe from concurrent package
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
			//put also wait if Q is full both put and take mathod works in synk 
			queue.put(r.nextInt(100)); /****>>>>PUT METHOD normal add won't work<<<<*****/
		}
	}
	
	
	
	public static void consumer() throws InterruptedException{
		Random r=new Random();
		
		while(true) {
			Thread.sleep(100);
			
			if(r.nextInt(10)==0) {
				//if there is nothing in queue then take will wait until there is something 
				Integer val=queue.take();/****>>>>TAKE METHOD<<<<*****/
				
				System.out.println("Value :- " +val+" ; Queue Size :- "+queue.size());
			}
		}

	}
}
