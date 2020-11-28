package com.dp;

import java.util.Arrays;
//https://www.youtube.com/watch?v=iBnWHZmlIyY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6
/**Related Problems
 * 1)subset sum PS:-Given one array and sum return if sum can be formed with elemnt or not 
 * 2)equal sum partition
 * 3)count of subset sum
 * 4)Minimum subset sum difference
 * 5)Target sum 
 * 6) No of subset for given d/f
 * 
 */

public class ZeroOneKnapsack1 extends DynamicPrograming{
	//STEP 1: created a dp array to memoize for chanigning variable where size<=100 (taken 102 for safty) and capacity<=1000;
	static int[][] t=new int [102][1000];
	
	static {
		//Step 2 :-fill with -1 
		for(int [] a:t)
		Arrays.fill(a, -1);
		
	}
	
	public static void main(String[] args) {
		//input : two arrays wt, val and one capacity is given OutPut:-return maximum profit which satisfy this capacity 
		int [] wt= {1,3,4,5};
		int [] val= {1,4,5,7};
		
		System.out.println("ANS:- "+knapsack_TOP_DOWN(wt,val,7,val.length));

	}
	
	//DP version with memoization
	public static int knapsack(int [] weight,int [] value,int capacity,int size) {
		if(size==0 || capacity==0) return 0;
		
		//step 3 
		if(t[size][capacity]!=-1)return t[size][capacity];
		
		if(weight[size-1]<=capacity) {
			//step 4 added t[size][capacity]=
			return t[size][capacity]= Math.max(
					value[size-1]+knapsack(weight,value,capacity-weight[size-1],size-1),
					knapsack(weight,value,capacity,size-1)
					);
		}
		if(weight[size-1]>capacity)
		{//step 4 added t[size][capacity]=
			return t[size][capacity]= knapsack(weight,value,capacity,size-1);
		}
		return 0;
		
	}
	
	
	//Simple Recursive Code 
	public static int knapsack_simple_recursive(int [] weight,int [] value,int capacity,int size) {
		if(size==0 || capacity==0) return 0;
		
		if(weight[size-1]<=capacity) {
			return Math.max(
					value[size-1]+knapsack_simple_recursive(weight,value,capacity-weight[size-1],size-1),
					knapsack_simple_recursive(weight,value,capacity,size-1)
					);
		}
		if(weight[size-1]>capacity)
		{
			return knapsack_simple_recursive(weight,value,capacity,size-1);
		}
		return 0;
		
	}
	
	//TOP DOWN APPROACH
	public static int knapsack_TOP_DOWN(int [] wt,int [] val,int w,int n) {
		int[][] top=new int [n+1][w+1];
		//Initialization 
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<w+1;j++) {
				if(i==0 || j==0)
					top[i][j]=0;
			}
		}
		//filling rest of the array
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				if(wt[i-1]<=j) {
					top[i][j]=Math.max(val[i-1]+top[i-1][j-wt[i-1]], 
							top[i-1][j]);
				}else {
					top[i][j]=top[i-1][j];
				}
			}
		}
		return top[n][w];
		
	}
}
