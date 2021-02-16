package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestV3 {
	//In this we understand what is the need of synchronization  
	//we  are running thread 20000 times so count should be always 20,000 
	//so if do simple normal count ++ this will create issue <20000
	//so we have two options here to solve this either use synchronization or atomic integer 
	//atomic integer increment or decrement in single transaction 
	private int count =0;
	AtomicInteger countAtomic =new AtomicInteger(0);
	
	public synchronized void increament() {
		//if you call synchronized on any method you have to acquire intrinsic lock on object 	and only 
		//one thread can acquire at a time ,secount thread must wait until first finished;
		count++;
	}
	
	public static void main(String args[]) {
		TestV3 t=new TestV3();
		t.doWork();
	}
	
	public void doWork() {
		Thread t1=new Thread(()-> {
			for(int i=0;i<10000;i++) {
				//count++; //as count++ is not a single step first it reads then +1 and update 
				increament(); 
				countAtomic.addAndGet(1);
			}
		});
		
		Thread t2=new Thread(()-> {
			for(int i=0;i<10000;i++) {
				//count++;
				increament();
				countAtomic.addAndGet(1);

			}
		});
		
		t1.start();
		t2.start();
		//main thread joins t1 & t2
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.print("COUNT VALUE -->"+count);
		System.out.print("Atomic COUNT VALUE -->"+countAtomic.get());
		
	}
}
