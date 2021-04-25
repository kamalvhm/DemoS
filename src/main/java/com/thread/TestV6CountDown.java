package com.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
//It lets one or more thread wait until latch reaches to 0 once iits zero one or more thread can resume 
//it a way of inter thread communication
class Processor3 implements Runnable{
	CountDownLatch latch;
	
	Processor3(CountDownLatch latch){
		this.latch=latch;
	}

	@Override
	public void run() {
	
			System.out.println("Started!! ");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	latch.countDown();
	System.out.println("COUNT DWON!! ");

	}
	
}

public class TestV6CountDown {

	
	public static void main(String args[]) {
		
	CountDownLatch latch =new CountDownLatch(3);
	ExecutorService e=Executors.newFixedThreadPool(3);
	
	for(int i=0;i<3;i++) {
		e.submit(new Processor3(latch));
		
	}
	try {
		latch.await();//once coundown reach to zero awaits finally return and FINISHED!! will be printed
	} catch (InterruptedException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	System.out.println("FINISHED!! ");

	
	

	}

	
}
