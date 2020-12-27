package com.dp;

import java.util.Arrays;

import org.apache.hadoop.fs.shell.Count;

import scala.math.Integral;

/**
 * 1)subset sum ANS:- true 
 * 2)equal sum partition ANS:- true 
 * 3)count of subset
 * sum ANS:- 3 
 * 4)Minimum subset sum difference ANS:- 4 
 * 6)No of subset for given d/f ANS:- 3 
 * 5)Target sum ANS:- 3 
 * 1)Rod Cutting :-22 
 * 2)coin change I :-5
 * 3)coin change II :-2
 */

public class DPractice {
	static int dp[][] = new int[10][10];
	static {
		for (int[] t : dp)
			Arrays.fill(t, -1);
	}

	public static void main(String[] args) {
		// input : two arrays wt, val and one capacity is given return maximum profit
		// which satisfy this capacity
		int[] wt = { 1, 3, 4, 5 };
		int[] val = { 1, 4, 5, 7 };
		// ANS:- 9 //Return Maximum Profit
		System.out.println("KnapSack ANS:- " + knapsack(wt, val, 7, val.length));

		int[] arr = { 2, 3, 7, 8, 10 };
		// return true if given sum can be formed by subset
		System.out.println("1)subset sum  ANS:- " + subsetSum(arr, 11, arr.length));

		int[] arr2 = { 1, 5, 11, 5 };
		// return true if two equal sum subset is there
		System.out.println("2)equal sum partition  ANS:- " + equalSum(arr2, arr2.length));

		int[] arr3 = { 2, 3, 5, 6, 8, 10 };
		// return count of subset which having same sum Ans will be 3
		System.out.println("3)count of subset sum  ANS:- " + countSubsetSum(arr3, 10, arr3.length));

		int[] arr4 = { 1, 2, 7 };
		// return min difference of two subsets from given array will give 4 {1,2} sum is
		// 3 and {7} sum is 7 (7-3=4)
		System.out.println("4)Minimum subset sum difference  ANS:- " + minimumSubsetSumDiff(arr4, arr4.length));// --->>>>

		int[] arr5 = { 1, 1, 2, 3 };
		// return count of subset which is having given diffrence when sum is subtracted
		// (check V-11 in notes) ANS :-3
		System.out.println("6)No of subset for given d/f  ANS:- " + noOfSubsetforGivenDiff(arr5, 1, arr5.length));
		// This problem is SAME as 6)No of subset for given d/f diffrently so same
		// method call
		int[] arr6 = { 1, 1, 2, 3 };
		// return count of subset which is having given diffrence when adding +ve and
		// -ve signs to each value
		System.out.println("5)Target sum  ANS:- " + noOfSubsetforGivenDiff(arr6, 1, arr6.length));

		int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 }; // some time legth[] array not given so loop from 1 to n to create
		int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
		int n = 8;// size of rode same value in length array
		System.out.println("1)Rod Cutting :-" + unboundedKnapsack(length, price, n, length.length));
		int[] coin = { 1, 2, 3 };
		// returns total No of ways a given sum can be formed by these coins
		System.out.println("2)coin change I :-" + coinChangeI(coin, 5, coin.length));
		// Return Min no of coin to create given sum
		System.out.println("3)coin change II :-" + coinChangeII(coin, 5, coin.length));
	}
	
	private static int knapsack1(int[] wt, int[] val, int w, int n) {
		return 1;
	}

	private static int knapsack(int[] wt, int[] val, int w, int n) {
		int t[][] = new int[n + 1][w + 1];
		
		
		return t[n][w];
	}

	public static boolean subsetSum(int[] arr, int sum, int n) {
		boolean t[][] = new boolean[n + 1][sum + 1];
		
		return t[n][sum];
	}

	public static boolean equalSum(int[] arr, int n) {
		
		return false;
	}

	public static int countSubsetSum(int[] arr, int sum, int n) {
		int t[][] = new int[n + 1][sum + 1];
		
		return t[n][sum];
	}

	public static int minimumSubsetSumDiff(int[] arr, int n) {
		
		return 1;
	}

	public static boolean[][] subsetSumToReturnTable(int[] arr, int sum, int n) {
		boolean t[][] = new boolean[n + 1][sum + 1];
		
		return t;
	}

	public static int noOfSubsetforGivenDiff(int[] arr, int diff, int n) {
		
		
		return 1;
	}

	public static int unboundedKnapsack(int[] wt, int[] val, int w, int n) {
		int t[][] = new int[n + 1][w + 1];
		
		return t[n][w];

	}

	public static int coinChangeI(int[] coin, int sum, int n) {
		int t[][] = new int[n + 1][sum + 1];

	
		return t[n][sum];
	}

	// return min no of coins to form
	// :-https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
	private static int coinChangeII(int[] coin, int sum, int n) {
		int t[][] = new int[n + 1][sum + 1];
		
		
		
		return t[n][sum];
	}

}
