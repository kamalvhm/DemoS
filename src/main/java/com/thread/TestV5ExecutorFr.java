package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
//Thread Pools are way to manage lots of threads at same time and we can reuse those  
class Processor2 implements Runnable{
	private int id;
	
	Processor2(int id){
		this.id=id;
	}
	@Override
	public void run() {
		System.out.println("Starting :"+id);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		System.out.println("Finished :"+id);

	}
	
}


public class TestV5ExecutorFr {

	
	public static void main(String args[]) {
		//Thread Pool is like having no of workers in factory we can assign tasks to these workers once one task finish 
		//take another task here 2 workers with 10 tasks
		ExecutorService e=Executors.newFixedThreadPool(2);
		for(int i=0;i<10;i++) {
			e.submit(new Processor2(i)); //submit returns future object where execute directly starts 

		}
		e.shutdown();//after this executor service won't accept new tasks and shutdown once done
		
		System.out.println("ALL TASKS SUBMITTED!!!!!");

		
		try {
			e.awaitTermination(1, TimeUnit.HOURS);//to wait for all task to complete in service wait for one Hour
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Finished!!!!!");

	}
}
