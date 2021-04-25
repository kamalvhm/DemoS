package com.thread;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Runner2 {
	
	//if we call with locks (switched in second method 1 2 then 2 1  so we can use try lock) it will create deadLock (if not add 1 sleep)
	//dead lock can occur in nested synk blocks also so one solution is to always aquire locks in same order other we can use try lock 
	
	
	private Account acc1=new Account();
	private Account acc2=new Account();

	private Lock lock1 =new ReentrantLock();
	private Lock lock2 =new ReentrantLock();
	//this will aquire lock in such a way that deadlock won't occure no matter the order
	private void acquireLocks(Lock first,Lock secound) throws InterruptedException {
		//while true as we need the locks any way we don't want to return without locks
		while(true) {
			boolean gotfirstLock = false;
			boolean gotscoundLock = false;
			
			try {
				gotfirstLock=first.tryLock();//try lock return immediately if it got the lock then true otherwise false
				gotscoundLock=secound.tryLock();//so no blocking in try lock
			}finally {
				if(gotfirstLock && gotscoundLock) //if got both then return 
					return;
				if(gotfirstLock)//other wise release your one lock and wait for next attempt
					first.unlock();
				if(gotscoundLock)
					secound.unlock();
			}
			Thread.sleep(1);
		}
	}

	public void firstThread() throws InterruptedException {
		Random r=new Random();
		
		for(int i=0;i<10000;i++){
			acquireLocks(lock1,lock2);
			try {
				Account.transfer(acc1, acc2, r.nextInt(100));

			}finally {
				lock1.unlock();
				lock2.unlock();
			}

		}
	}

	
	
	public void secoundThread() throws InterruptedException {
		Random r=new Random();
		
		for(int i=0;i<10000;i++){
			acquireLocks(lock2,lock1);

			try {
				Account.transfer(acc2, acc1, r.nextInt(100));

			}finally {
				lock2.unlock();
				lock1.unlock();
			}

		}

	}
	
	

	public void finish() {
		System.out.println("Account 1 balance :- " +acc1.getBalance());
		System.out.println("Account 2 balance :- " +acc2.getBalance());
		System.out.println("Account Total balance :- " +(acc1.getBalance()+acc2.getBalance()));


	}
}
