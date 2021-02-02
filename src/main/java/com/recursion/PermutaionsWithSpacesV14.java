package com.recursion;

public class PermutaionsWithSpacesV14 {

	public static void main(String[] args) {
		solve("ABC", "");
		//solve2("BC", "A");
		

	}
	
	public static void solve(String ip,String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		else {
			solve(ip.substring(1),op+ip.charAt(0));
			if(ip.length()>1)
			solve(ip.substring(1),op+ip.charAt(0)+"_");
			return;
		}
		
		
	}
	
	
	public static void solve2(String ip,String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		else {
			String op1=op+ip.charAt(0);
			String op2=op+ip.charAt(0)+"_";
			ip=ip.substring(1);
			solve2(ip,op1);
			solve2(ip,op2);
			return;
		}
		
		
	}
	
	//Another option explore method 
	public static void printpermutation(String ip,String op) {
		if(ip.length()==0)
		{
			System.out.println(op);
			return;
		}
		for(int i=0;i<ip.length();i++) {
			char c=ip.charAt(i);
			String opLeftPart=ip.substring(0,i);
			String opRightPart=ip.substring(i+1);
			String rip=opLeftPart+opRightPart;
			printpermutation(rip, op+c);

		}
	}
		

}
