package com.thread;

import java.util.Scanner;

public class Processor5 {

	

	
	
	public  void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running ....");
			wait();
			System.out.println(" Resumed ....");

		}
	}
	
	
	
	public  void consumer() throws InterruptedException{
		Scanner sc =new Scanner(System.in);
		Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for return key ....");
			sc.nextLine();
			System.out.println(" Pressed ....");
			notify();
		}
	}
}
