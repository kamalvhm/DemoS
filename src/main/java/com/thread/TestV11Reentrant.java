package com.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;



public class TestV11Reentrant {

	
	public static void main(String args[]) throws InterruptedException {
		Runner2 r=new Runner2();
		
		Thread t1 =new Thread(()->{
			try {
				r.firstThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t2 =new Thread(()->{
			try {
				r.secoundThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		r.finish();
	

	}
	
	


	
}
