package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class TestV3 {
	private int count =0;
	AtomicInteger countAtomic =new AtomicInteger(0);
	
	public synchronized void increament() {
		count++;
	}
	
	public static void main(String args[]) {
		
		
		TestV3 t=new TestV3();
		t.doWork();
	}
	
	public void doWork() {
		Thread t1=new Thread(()-> {
			for(int i=0;i<10000;i++) {
				//count++;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.print("COUNT VALUE -->"+count);
		System.out.print("Atomic COUNT VALUE -->"+countAtomic.get());

		
		
	}
}
