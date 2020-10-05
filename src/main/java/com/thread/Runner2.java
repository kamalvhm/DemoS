package com.thread;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Runner2 {
	
	
	private Account acc1=new Account();
	private Account acc2=new Account();

	private Lock lock1 =new ReentrantLock();
	private Lock lock2 =new ReentrantLock();
	
	private void acquireLocks(Lock first,Lock secound) throws InterruptedException {
		
		while(true) {
			boolean gotfirstLock = false;
			boolean gotscoundLock = false;
			
			try {
				gotfirstLock=first.tryLock();
				gotscoundLock=secound.tryLock();
			}finally {
				if(gotfirstLock && gotscoundLock)
					return;
				if(gotfirstLock)
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
		// TODO Auto-generated method stub
		System.out.println("Account 1 balance :- " +acc1.getBalance());
		System.out.println("Account 2 balance :- " +acc2.getBalance());
		System.out.println("Account Total balance :- " +(acc1.getBalance()+acc2.getBalance()));


	}
}
