package com.thread;

import java.util.concurrent.Semaphore;

public class Connections {
	
	public static Connections instance=new Connections();
	private Semaphore sem=new Semaphore(10);
	private int connections=0;
	
	private Connections() {}
	
	public Connections getInstance() {
		return instance;
	}
	
	public void doConnect() {
		synchronized (this) {
			connections++;
			System.out.println("No of connections "+connections);

		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;

		}
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			doConnect();
		}finally {
			sem.release();

		}
	}

}
