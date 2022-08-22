package com.lembda;

public class LambdaArroundV9 {
	
	public static void main(String args[]) {
		
		
		//Via annonymous inner class so we can think it as lambda but it have some diffrence
		Greet lembda=new Greet() {

			@Override
			public void perform() {
				System.out.print("hello!!!");
			}
			
		};
		
		lembda.perform();
		
		
		Greet gr=()->System.out.print("hello!!!");
		gr.perform();
		
		
	}
	
	

}
