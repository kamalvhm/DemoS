package com.thread;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Runner {
	
	private int count=0;
	//it means once a thread aquire this lock it can lock it again it maintains a count how many time a lock is aquired
	//then you have to unlock it same amount,Lock should be used with condition 
	private Lock lock=new ReentrantLock();
	//as every class has wait and notify method so who ever implemented Lock had to use different names await,and signal but htey are method of condition
	//you are getting condition from the lock you are locking on
	private Condition cond=lock.newCondition();
	//as both thread are increment we need synchronization here to be 20000
	public void increament() {
		for(int i=0;i<10000;i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock(); //Acquired the lock (Think of it as synk block and condition is wait and notify)
		//same as wait 
		cond.await();
		System.out.println("Woken up !!");

		try {
			increament();
		}finally {
			lock.unlock();

		}
		/*used like this with out finally ,but its worng if increamnt throw any exception then lock will not be release 
		 * lock.lock();
		increament();
		lock.unlock();*/
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
		System.out.println("Count is :- " +count);

	}
}
