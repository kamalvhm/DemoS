package com.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class TestV10Reentrant {

	//Re-entrant lock is alternative to syncronise keyword 
	public static void main(String args[]) throws InterruptedException {
		Runner r=new Runner();
		//run first Thread
		Thread t1 =new Thread(()->{
			try {
				r.firstThread();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		//run secound Thread
		Thread t2 =new Thread(()->{
			try {
				r.secoundThread();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		//run finish 

		r.finish();
	

	}
	
	


	
}
