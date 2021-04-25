package com.thread;

public class PrintEvenOdd {
	boolean odd=false;
	public static void main(String args[]) {
		PrintEvenOdd t=new PrintEvenOdd();
		Thread t1=new Thread(()-> {
			t.printEven(10);
		});
		t1.setName("A");
		
		Thread t2=new Thread(()-> {
			t.printodd(10);
		});
		t2.setName("B");
		t1.start();
		t2.start();
	}
	
	
	public synchronized void printEven(int n) {
		for(int i=0;i<n;i+=2) {
			while(odd) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			System.out.println(Thread.currentThread().getName()+"-"+i);
			odd=true;
			notify();
		}
	}
	public synchronized void printodd(int n) {
		for(int i=1;i<n;i+=2) {
			while(odd==false) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
			System.out.println(Thread.currentThread().getName()+"-"+i);
			odd=false;
			notify();
		}
	}

}
