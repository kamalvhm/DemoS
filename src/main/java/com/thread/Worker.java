package com.thread;

import java.util.ArrayList;
import java.util.List;

import scala.util.Random;

public class Worker {
	
	private Random r=new Random();
	private List<Integer> list1=new ArrayList<>();
	private List<Integer> list2=new ArrayList<>();
	//As both stage One and two are adding to different resource we have two critical section here 
	//so adding syncronisation in method will not make both thread parallel so we have to go for 
	//syncronisation block with two separate locks
	private Object lock1=new Object();
	private Object lock2=new Object();

	//IF we add synchronized method that will solve the problem but both threads will take 4000 sec because there will be single lock
	public void stageOne() {
		synchronized (lock1) {//syncronisation code block
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(r.nextInt(100));
		}
	}

	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(r.nextInt(100));
		}
	
	}
	
	
	public void process() {
		for(int i=0;i<1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public void main () {
		System.out.println("Starting!");
		long start=System.currentTimeMillis();
		Thread t1=new Thread(()-> {
			process();
		});
		Thread t2=new Thread(()-> {
			process();
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end=System.currentTimeMillis();
		
		System.out.println("Time Taken! "+(end-start));
		System.out.println("List size 1 "+list1.size()+"  2 "+list2.size());
	
	}

}
