package com.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


 class Processor6{
	private  LinkedList<Integer> list= new LinkedList<Integer>();
	private final int LIMIT=10;
	
	private Object lock =new Object();
	
	public  void producer() throws InterruptedException{
		int value=0;
		while(true) {
			synchronized (lock) {
				while(list.size()==LIMIT) {
					  lock.wait();
				}
				list.add(value++);
				lock.notify();
			}
		}
	}

	public  void consumer() throws InterruptedException{
		Random r=new Random();
		while(true) {
			synchronized (lock) {
				
				while(list.size()==0) {
					  lock.wait();
				}
				
				System.out.print("List size : "+list.size());
				int val =list.removeFirst();
				System.out.println(" Value : "+val);
				lock.notify();
			}
			
			Thread.sleep(r.nextInt(1000));
		}
	}
}

public class TestV9 {

	
	public static void main(String args[]) throws InterruptedException {
		Processor6 proc=new Processor6();
		
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
