package com.lembda;

public class TypeInferenceExampleV10 {
//Compiler is inferring a lot of things here 
	public static void main(String[] args) {
		// String and () removed from this as variable type is already in interface (String s)->s.length()	
		StringLengthLambda mylam=s->s.length();
		
		System.out.print(mylam.getLength("Hello!!!"));
		
		//Also made a method to call lebda directly
		
		printLambda(s->s.length());
		
	}
	public static void printLambda(StringLengthLambda s) {
		System.out.print(s.getLength("Hello!!!!"));
	}
	
	interface StringLengthLambda{
		int getLength(String s);
	}

}
