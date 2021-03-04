package com.thread;

import java.util.Scanner;

public class Processor5 {

	

	
	
	public  void producer() throws InterruptedException {
		//we are using intrinsic lock of processor class here as (this)
		synchronized (this) {
			System.out.println("Producer thread running ....");
			wait(); //every obj have this method as it comes from Object class 
			//It wait such that it does not consume lot of system resources for example if you have loop instead of this it will consume resouces
			//you can only call in sync block, after wiat this thread will lose control of lock until two thing happen -it possible to regain control 
			// other thing is another thread on same lock call notify 
			System.out.println(" Resumed ....");

		}
	}
	
	
	
	public  void consumer() throws InterruptedException{
		Scanner sc =new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) { //same obj used here 
			System.out.println("Waiting for return key ....");
			sc.nextLine();
			System.out.println(" Pressed ....");
			notify();//can only be called in synck block ,it will notify another thread that is waiting to wake up
			//as synk block end below as after calling notify you need to immediately relinquish lock other wise waited thread won't wake 
		}
	}
}
