package com.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


 class Processor6{
	 //implementing Producer consumer Patter using Low level Syncronisation 
	private  LinkedList<Integer> list= new LinkedList<Integer>(); //shared data will be stored in this with limit 
	private final int LIMIT=10;
	
	private Object lock =new Object();//lock 
	//add value in list 
	public  void producer() throws InterruptedException{
		int value=0;
		while(true) {
			synchronized (lock) {
				while(list.size()==LIMIT) { //good practice to check condition in loop if this still apply or not
					  lock.wait(); //wait if the list is full 
				}
				list.add(value++); //shared data within lock
				lock.notify();
			}
		}
	}
	//remove from list 
	public  void consumer() throws InterruptedException{
		Random r=new Random();
		while(true) {
			synchronized (lock) {
				
				while(list.size()==0) {//if empty wait until added 
					  lock.wait();
				}
				
				System.out.print("List size : "+list.size());
				int val =list.removeFirst();
				System.out.println(" Value : "+val);
				lock.notify(); //after remove notify producer
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
