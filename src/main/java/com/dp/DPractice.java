package com.dp;

public class DPractice {

	public static void main(String[] args) {
		int [] wt= {1,3,4,5};
		int [] val= {1,4,5,7};
		//ANS:- 9
		System.out.println("ANS:- "+knapsack_TOP_DOWN(wt,val,7,val.length));
		/**
		ANS:- 9
		1)subset sum  ANS:- true
		2)equal sum partition  ANS:- true
		3)count of subset sum  ANS:- 3
		4)Minimum subset sum difference  ANS:- 4
		6)No of subset for given d/f  ANS:- 3
		5)Target sum  ANS:- 3
		1)Rod Cutting :-22
		*/
		int [] arr= {2,3,7,8,10};
		System.out.println("1)subset sum  ANS:- "+subsetSum(arr,11,arr.length));
		int [] arr2= {1,5,11,5};
		System.out.println("2)equal sum partition  ANS:- "+equalSum(arr2,arr2.length));
		int [] arr3= {2,3,5,6,8,10};
		System.out.println("3)count of subset sum  ANS:- "+countSubsetSum(arr3,10,arr3.length));
		int [] arr4= {1,2,7};
		System.out.println("4)Minimum subset sum difference  ANS:- "+minimumSubsetSumDiff(arr4,arr4.length));
		int [] arr5= {1,1,2,3};
		System.out.println("6)No of subset for given d/f  ANS:- "+noOfSubsetforGivenDiff(arr5,1,arr5.length));
		int [] arr6= {1,1,2,3};
		System.out.println("5)Target sum  ANS:- "+noOfSubsetforGivenDiff(arr6,1,arr6.length));
		int [] length= {1,2,3,4,5,6,7,8}; //some time legth[] array not given so loop from 1 to n to create 
		int [] price= {1,5,8,9,10,17,17,20};
		int n=8;
		System.out.println("1)Rod Cutting :-"+unboundedKnapsack(length,price,n,length.length));
	}

	private static String knapsack_TOP_DOWN(int[] wt, int[] val, int i, int length) {
		return null;
	}
	
	public static boolean subsetSum(int[] arr , int sum, int n) {
		return false;
	}
	
	
	public static boolean equalSum(int[] arr , int n) {
		return false;
	}
	
	public static int countSubsetSum(int[] arr , int sum, int n) {
		return -1;
	}
	
	
	public static int minimumSubsetSumDiff(int[] arr , int n) {
		return -1;
	}
	public static boolean[][] subsetSumToReturnTable(int[] arr,int sum,int n){
		return new boolean[1][1];
	}
	
	public static int noOfSubsetforGivenDiff(int[] arr ,int diff, int n) {
		return -1;
	}
	
	public static int unboundedKnapsack(int [] wt,int [] val,int w,int n) {
		return -1;
		
	} 

}
