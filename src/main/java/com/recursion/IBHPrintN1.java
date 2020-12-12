package com.recursion;

public class IBHPrintN1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(7);
	}
	//Hypo step 1
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

}
