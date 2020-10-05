package com.lembda;

public class RunnableExmple {

	public static void main(String[] args) {
		Thread myThread=new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.print("Printed inside Runnable!!!");
			}
			
		});
		
		myThread.run();
		
		
		//Doing same with Lambda here labda gives backword compatibility as Runnable in older class so we can use it for older APIs also 
		
		Thread myLambdaThread=new Thread(()->System.out.print("Printed Lambda Runnable!!!"));
		
		myLambdaThread.run();
		
		
		
		
	}

}
