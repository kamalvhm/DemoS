package com.thread;

import java.util.concurrent.Semaphore;

public class Connections {
	
	public static Connections instance=new Connections();
	/**semaphore is an object that maintains a count and we refer to count as available permit in 
		semaphore (you can get available permit by calling 'sem.avaiablePermit()')
		sem.release() will release permit so if initial 0 after release it will be 1
		sem.aquire() will decrement permit if no permit available it will wait until there is a permit 
	 *  semaphore is used to control the access to some resource in this case connection (its like counting semaphore)
	 */
	private Semaphore sem=new Semaphore(10);//new Semaphore(10,true); true is fairness parameter it will give FIFO permits
	private int connections=0;//this will maintain current connection count
	
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
	//faulty code if middle code throws exception then its issue so above is good
/*	public void connect2() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized (this) {
			connections++;
			System.out.println("Current coonections "+connections);
		}
		
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			
		}
		
		synchronized (this) {
			connections--;
		}
			sem.release();
	}*/

}
