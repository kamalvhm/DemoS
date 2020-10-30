package com.recursion;

public class PermutaionsWithSpaces {

	public static void main(String[] args) {
		solve("ABC", "");
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

}
