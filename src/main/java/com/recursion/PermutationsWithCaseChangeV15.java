package com.recursion;

public class PermutationsWithCaseChangeV15 {

	public static void main(String[] args) {
		//printPermutations("abc","");
		letterCasePermutations("a1B2","");
	}
	
	public static void printPermutations(String ip,String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		String op1=op+ip.charAt(0)+"";
		String op2=op+Character.toUpperCase(ip.charAt(0))+"";
		ip=ip.substring(1);
		printPermutations(ip,op1);
		printPermutations(ip,op2);
		return;
	}
	
	public static void letterCasePermutations(String ip,String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		boolean isLetter=Character.isLetter(ip.charAt(0));
		if(isLetter){
			String op1=op+Character.toLowerCase(ip.charAt(0));
			String op2=op+Character.toUpperCase(ip.charAt(0));
			ip=ip.substring(1);
			letterCasePermutations(ip,op1);
			letterCasePermutations(ip,op2);
			
		}else {
			//single recursion in case of digit as we just need to copy in output
			String op1=op+ip.charAt(0);
			ip=ip.substring(1);
			letterCasePermutations(ip,op1);
			
		}
		return;
	}
	

}
