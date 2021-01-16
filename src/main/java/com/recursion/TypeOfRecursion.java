package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class TypeOfRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**					below Recusion goes like
		 * 						 [1,2,3]
		 * 					/1      |2	  3\
		 * 				   /        |		\
		 Then again we [1,2,3]   [1,2,3]	 [1,2,3]  have same choices at every stage until either target is 0 or <0
		 */
	}
	//377. Combination Sum IV  : when at every recurtion we have same choices check Problem 
	 public int combinationSum4(int[] nums,int k,int[] dp) {
	        if(k==0) return 1;
	        if(k<0) return 0;
	        if(dp[k]==-1) {
	            dp[k]=0;
	            for(int num:nums) {
	                dp[k]+=combinationSum4(nums,k-num,dp);
	            }
	        }
	        return dp[k];
	    }
	//377
	 public static  int countSubsetSum(int [] a,int sum){
	        int dp[]=new int [sum+1];
	        dp[0]=1;
	        for(int i=0;i<sum;i++){
	            for(int x:a){
	                if(i+x>sum)
	                    continue;
	                dp[i+x]+=dp[i];
	            }
	        }
	        return dp[sum];
	    }
	//377
	     public int combinationSum41(int[] nums,int k,int[] dp) {
	        if(k==0) return 1;
	        if(k<0) return 0;
	        if(dp[k]==-1) {
	            dp[k]=0;
	            for(int num:nums) {
	                dp[k]+=combinationSum4(nums,k-num,dp);
	            }
	        }
	        return dp[k];
	    }
	
}
