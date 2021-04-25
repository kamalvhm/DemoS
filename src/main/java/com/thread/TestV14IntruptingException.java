package com.thread;

import java.util.Random;

public class TestV14IntruptingException {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting");
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run() {
				Random ran=new Random();
				
				for(int i=0;i<1E8;i++) {//for some intensive work
					/*try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println("We have been intrupted!!!");
						break;
					}*/
					if(Thread.currentThread().isInterrupted()) { 
						System.out.println("We have been intrupted!!!");
						break;
					}
					Math.sin(ran.nextDouble());
				}
			}
		});
		t.start();
		Thread.sleep(500);
		
		t.interrupt();//it does't stop the thread ,but set a flag of intrupt and if thread have any method that 
		//throw intrupt exception that will be catched just like sleep method catches this intrupt after 5 sec or you 
		//can use isInterrupted() method
		
		t.join();
		System.out.println("finished");

	}

}
