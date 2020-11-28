package com.dp;

import java.util.Arrays;

public class DPractice {
	static int dp[][]=new int[10][10];
	static {
		for(int []t:dp)
			Arrays.fill(t, -1);
	}

	public static void main(String[] args) {
		//input : two arrays wt, val and one capacity is given return maximum profit which satisfy this capacity 
		int [] wt= {1,3,4,5};
		int [] val= {1,4,5,7};
		//ANS:- 9  //Return Maximum Profit
		System.out.println("ANS:- "+knapsack(wt,val,7,val.length));
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
		int [] arr= {2,3,7,8,10};//PS:-Given one array and sum return if sum can be formed with elemnt or not 
		System.out.println("1)subset sum  ANS:- "+subsetSum(arr,11,arr.length));
		int [] arr2= {1,5,11,5};
		System.out.println("2)equal sum partition  ANS:- "+equalSum(arr2,arr2.length));//return true if can be divided into two equal partitions 
		int [] arr3= {2,3,5,6,8,10};
		System.out.println("3)count of subset sum  ANS:- "+countSubsetSum(arr3,10,arr3.length));
		int [] arr4= {1,2,7};
		System.out.println("4)Minimum subset sum difference  ANS:- "+minimumSubsetSumDiff(arr4,arr4.length));//will give 4
		int [] arr5= {1,1,2,3};
		System.out.println("6)No of subset for given d/f  ANS:- "+noOfSubsetforGivenDiff(arr5,1,arr5.length));
		int [] arr6= {1,1,2,3};
		System.out.println("5)Target sum  ANS:- "+noOfSubsetforGivenDiff(arr6,1,arr6.length));
		int [] length= {1,2,3,4,5,6,7,8}; //some time legth[] array not given so loop from 1 to n to create 
		int [] price= {1,5,8,9,10,17,17,20};
		int n=8;
		System.out.println("1)Rod Cutting :-"+unboundedKnapsack(length,price,n,length.length));
		int [] coin= {1,2,3};
		//returns total No of ways a given sum can be formed by these coins
		System.out.println("2)coin change I :-"+coinChangeI(coin,5,coin.length));
		//Return Min no of coin to create given sum
		System.out.println("3)coin change II :-"+coinChangeII(coin,5,coin.length));
	}

	private static int knapsack(int[] wt, int[] val, int w, int n) {
		int t[][]=new int[n+1][w+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<w+1;j++) {
				if(i==0 || j==0 )
					t[i][j]=0;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				if(wt[i-1]<=j) {
					t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
				}else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
	
	public static boolean subsetSum(int[] arr , int sum, int n) {
		boolean t[][] =new boolean [n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0 )
					t[i][j]=false;
				if(j==0)
					t[i][j]=true;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
				}else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}
	
	
	public static boolean equalSum(int[] arr , int n) {
		int totalSum =0;
		for(int i:arr)
			totalSum+=i;
		if(totalSum%2!=0)return false;
		else return subsetSum(arr, totalSum/2, n);
	}
	
	public static int countSubsetSum(int[] arr , int sum, int n) {
		int t[][]=new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0)
					t[i][j]=0;
				 if(j==0)
					t[i][j]=1;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j-arr[i-1]]+t[i-1][j];
				}
				else t[i][j]=t[i-1][j];

			}
		}
		return t[n][sum];
	}
	
	
	public static int minimumSubsetSumDiff(int[] arr , int n) {
		int sum=0;
		for(int i:arr) {
			sum+=i;
		}
		
		boolean t[][]=subsetSumToReturnTable(arr, sum, n);
		int minimum =Integer.MAX_VALUE;
		for(int i=0;i<sum/2;i++) {
			if(t[arr.length-1][i]) {
				minimum=Math.min(minimum, sum-2*i);
			}
		}
		
		return minimum;
	}
	public static boolean[][] subsetSumToReturnTable(int[] arr,int sum,int n){
		boolean t[][] =new boolean [n+1][sum+1];
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0 )
					t[i][j]=false;
				if(j==0)
					t[i][j]=true;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
				}else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		return t;
	}
	
	public static int noOfSubsetforGivenDiff(int[] arr ,int diff, int n) {
		return -1;
	}
	
	public static int unboundedKnapsack(int [] wt,int [] val,int w,int n) {
		return -1;
		
	} 
	public static int coinChangeI(int[] coin,int sum ,int n) {
		int t[][]=new int[n+1][sum+1];
		
		return t[n][sum];
	}
	//return min no of coins to form :-https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
	private static int coinChangeII(int[] coin, int sum, int n) {
		int t[][] =new int [n+1][sum+1];
		
		return t[n][sum];
	}

}
