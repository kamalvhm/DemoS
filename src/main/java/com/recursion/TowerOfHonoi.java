package com.recursion;

public class TowerOfHonoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numberOfDiskOnsource=3;
		//source ,helper ,destination
		String s="X";
		String h="Y";
		String d="Z";
		
		solve(numberOfDiskOnsource,s,d,h);
		
	}

	private static void solve(int n, String s, String d, String h) {
		//if its a single disk Base condi.
		if(n==1) {
			System.out.println("Move "+n+" :-"+s+"->"+d);
			return;
		}
		//if not move n-1 to helper
		solve(n-1, s, h, d);
		//then move nth to destination
		System.out.println("Move "+n+" :-"+s+"->"+d);
		//now put n-1 to d
		solve(n-1,h,d,s);
		return;
		
	}

}
