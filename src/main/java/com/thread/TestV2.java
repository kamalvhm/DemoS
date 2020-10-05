package com.thread;

import java.util.Scanner;

class Processor extends Thread {
	
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

public class TestV2 {

	public static void main(String args[]) {
		
		Processor p=new Processor();
		p.start();
		System.out.println("Press Return");

		Scanner sc=new Scanner(System.in);
		sc.nextLine();
		
		p.shutdown();
		
		
		
	}

}
