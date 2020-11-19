package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	    
}
