package com.recursion;

public class IBHPrintN1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printDecreasingIncreasing(5);
	}
	//Hypothesis step 1 :-design what a function will do whats its input and output will be 
	public static void print(int n) {
		//Base cond.
		if(n==1) {
			System.out.println(1);
			return;
		}
		else {
			
			//hypo step 2
			print(n-1);
			//Induction
			System.out.println(n);
		}
	}
	
	public static void printReverse(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		printReverse(n-1);
	}
	public static void print2(int n) {
		if(n==0) {
			return;
		}
		print2(n-1);
		System.out.println(n);
	}
	
	public static void printDecreasingIncreasing(int n) {
		if(n==0)
			return;
		System.out.println(n);
		printDecreasingIncreasing(n-1);
		System.out.println(n);
		
	}
}
