package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cleanup.Utils;

//STUDY:-https://www.youtube.com/watch?v=nqowUJzG-iM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class DynamicPrograming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//40. Combination Sum II //https://leetcode.com/problems/combination-sum-ii/discuss/934838/DP-solution-in-Java-(with-explanation)
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	       // we need to sort candidates, to avoid duplicate combibation
	        Arrays.sort(candidates);

	        // initialize dp array
	        Set<List<Integer>>[] dp = new Set[target + 1];
	        for (int i = 0; i <= target; i++) {
	            dp[i] = new HashSet<>();
	        }

	        // base case when target is 0 and not picking first candidate
	        dp[0].add(new ArrayList<>());

	        // populate the dp array
	        for (int i = 0; i < candidates.length; i++) {
	            for (int j = target; j >= candidates[i]; j--) {
	                for (List<Integer> comb : dp[j - candidates[i]]) {
	                    List<Integer> newComb = new ArrayList<>(comb);
	                    newComb.add(candidates[i]);
	                    dp[j].add(newComb);
	                }
	            }
	        }

	        return new ArrayList<>(dp[target]);
	    }
	 
	 //132. Palindrome Partitioning II
	 class Solution {
		    public int minCut(String s) {
		        
		        int n = s.length();
		        int[][] dp = new int[n+1][n+1];
		        
		        for(int[] row : dp)
		            Arrays.fill(row,-1);
		        
		        return solve(s,0,n-1,dp);
		    }
		    
		    private int solve(String s, int i , int j, int[][] dp){
		        
		        if(dp[i][j] != -1)
		            return dp[i][j];
		        
		        if(i >= j)
		            return 0;
		        
		        if(Utils.isPalindrome(s,i,j)){
		            dp[i][j] = 0;
		            return 0;
		        }
		        
		        int ans = Integer.MAX_VALUE;
		        
		        for(int k = i; k < j; k++){
		            
		            int l,r;
		            
		            if(dp[i][k] != -1)
		                l = dp[i][k];
		            else
		            {
		                l = solve(s,i,k,dp);
		                dp[i][k]=l;
		            }
		           
		            
		            if(dp[k+1][j] != -1)
		                r = dp[k+1][j];
		            
		            else{
		                r = solve(s, k+1,j, dp);
		                 dp[k+1][j]=r;
		             }
		            
		            ans = Math.min(ans, 1+l+r);
		        }
		        
		        dp[i][j] = ans;
		        return ans;
		        
		    }
		    
		}
	    
}
