package com.recursion;

public class SubsetProblem {
//78. Subsets | https://leetcode.com/problems/subsets/
	public static void main(String[] args) {
		//print all subsets of given string 
		

		
		printSubsets("abcd","");

	}

	private static void printSubsets(String  input, String output) {
			if(input.length()==0) {
				System.out.println(output);
				return;
			}
			//one with selected and one with not
			String op1=output;
			String op2=output;
			
			op2=op2+input.charAt(0);
			input=input.substring(1);
			 printSubsets(input, op2);
			 printSubsets(input, op1);
			 return;
			
			
	}
	
	

}
