package com.thread;

import java.util.Scanner;

class Processor extends Thread {
	//volatile keyword make sure another thread gets correct value of running not the cached one 
	private volatile boolean running =true;
	
	public void run() {
		while(running) {
			System.out.println("hello");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void shutdown() {
		running=false;
	}
}

public class TestV2Volatile {

	public static void main(String args[]) {
		
		Processor p=new Processor();
		p.start();
		System.out.println("Press Return");

		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		//so main thread changing this variable on Press of Enter but thread might cached that variable so volatile is used 
		p.shutdown();
		
		
		
	}

}
