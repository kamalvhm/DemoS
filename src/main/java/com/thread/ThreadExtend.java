package com.thread;

import org.apache.commons.net.PrintCommandListener;

public class ThreadExtend extends Thread {
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("hello!! "+i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
