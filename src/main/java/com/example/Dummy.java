package com.example;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {5,7,7,8,8,8,8,10};
		System.out.println(bsearch(a,8));
		System.out.println(bsearchlast(a,8));

	}
	
	
	public static int bsearch(int [] n,int target) {
		int left=0,right=n.length-1;
		
		while(left<right) {
				int mid =left+right-left/2;
				if((mid==0|| target>n[mid-1]) && n[mid]==target) {
					return mid;
				}else if(n[mid]<target)
					left=mid+1;
				else right=mid-1;
			}
		return -1;
	}
	
	public static int bsearchlast(int [] n,int target) {
		int left=0,right=n.length-1;
		
		while(left<right) {
				int mid =left+right-left/2;
				if((mid==right || target<n[mid+1]) && n[mid]==target) {
					return mid;
				}else if(n[mid]<target)
					left=mid+1;
				else right=mid-1;
			}
		return -1;
	}

}
