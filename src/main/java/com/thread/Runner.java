package com.thread;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Runner {
	
	private int count=0;
	private Lock lock=new ReentrantLock();
	private Condition cond=lock.newCondition();
	
	public void increament() {
		for(int i=0;i<10000;i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		// TODO Auto-generated method stub
		lock.lock();
		//same as wait
		cond.await();
		System.out.println("Woken up !!");

		try {
			increament();
		}finally {
			lock.unlock();

		}
	}

	
	
	public void secoundThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();
		System.out.println("Press Return key !!");

		new Scanner(System.in).nextLine();
		//same as notify
		cond.signal();
		try {
			increament();
		}finally {
			lock.unlock();

		}

	}
	
	




	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("Count is :- " +count);

	}
}
