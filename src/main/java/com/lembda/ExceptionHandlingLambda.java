package com.lembda;

import java.util.function.BiConsumer;

public class ExceptionHandlingLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] someNumbers= {1,2,3,4};
		//As key is zero and operation is devide ,it will produce divide by zero exception
		int key =0;
		//here we are passing operation in third arg which take two inputs
		//STEP -1:- one way to handle is here but it mess cleaness of lambda
		/*process(someNumbers,key,(v,k)->{
			try {
				System.out.println(v/k);

			}catch(ArithmeticException e) {
				System.out.println("An Exception happended!!!");

			}
			});*/
		//STEP-2:We can externalize try catch into a saperate lambda and wrap SOP lambda with that new lambda
		process(someNumbers,key,(v,k)->System.out.println(v/k));

	}
	//BiConsumer take two input and return void 
	//we can't handle (add try catch) in this function as operation could be any thing and it will have long list of catchs
	private static void process(int[] someNumbers, int key,BiConsumer<Integer, Integer> consumer) {
		// TODO Auto-generated method stub
		for(int i:someNumbers) {
			consumer.accept(i, key);
		}
	}
	//STEP-3 : handling it here
	private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v,k)->{
			try {
				consumer.accept(v, k);
			}catch(ArithmeticException e) {
				System.out.println("Eception caught in wrapper");
			}
		};
	}

}
