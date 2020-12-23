package com.recursion;

public class Binary1sGreaterThen0sV18 {

	public static void main(String[] args) {
		solve(3,0,0,"");
	}
	
	public static void solve(int n,int one,int zero,String op) {
		if(n==0) {
			System.out.println(op);
			return;
		}
		String op1=op+"1";
		solve(n-1,one+1,zero,op1);
		if(one>zero) {
			solve(n-1,one,zero+1,op+"0");
		}
		return;
	}

}
