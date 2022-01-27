package com.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cleanup.Utils;

//STUDY:-https://www.youtube.com/watch?v=nqowUJzG-iM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go (Aditya Verma playList)
public class DynamicPrograming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="catsanddog";
		String[] dictionary=	{"cat","cats","and","sand","dog"};
		
		wordBreak(s,Arrays.asList(dictionary));
		
		int a[]= {5,8,7,1,9};// longest will be of size 3 5,8,9 or 5,7,9 all values in increasing order
		int b[]= {1,2,3,6};
		System.out.print(largestDivisibleSubset(b));

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
	 //TLE TOP DOWN
	 public int superEggDrop(int e, int f) {
	        int [][] dp = new int [e+1][f+1];
	        int result;
	        for (int i=1; i<=e; i++) {
	            dp[i][1] = 1;
	            dp[i][0] = 0;
	        }
	        for (int j=1; j<=f; j++) {
	            dp[1][j] = j;
	        }
	        for (int i=2; i<=e; i++) {
	            for (int j=2; j<=f; j++) {
	                dp[i][j] = Integer.MAX_VALUE;
	                for (int floors=1; floors<=j; floors++) {
	                    result = 1 + Math.max(dp[i-1][floors-1], dp[i][j-floors]);
	                    dp[i][j] = Math.min(result, dp[i][j]);
	                }
	            }
	        }
	        return dp[e][f];
	    }
	 
	 
	public int superEggDrop2(int e, int f) {
		int[][] dp = new int[e + 1][f + 1];

		for (int i = 0; i <= e; i++) {   
			for (int j = 0; j <= f; j++) {
				if (i == 1 || j == 1)
					dp[i][j] = j; //remember this j 
			}
		}
		for (int i = 2; i <= e; i++) {
			for (int j = 2; j <= f; j++) {

				for (int k = 1; k <= j; k++) {
					int temp = 1 + dp[i - 1][k - 1] + dp[i][j - k];
					dp[i][j] = Math.min(dp[i][j], temp);
				}
			}
		}

		return dp[e][f];
	}
	
	
	//139. Word Break
	 HashMap<String,Boolean> map;
	 public boolean possible(String s, List<String> list)
	   {
	       if(list.contains(s))
	           return true;
	           
	       if(s.length()==1)
	         return false;
	   
	       if(map.containsKey(s))
	         return map.get(s);
	   
	       boolean ans=false;
	       for(int i=0;i<s.length()-1;i++)
	       {
	          String s1=s.substring(0,i+1);
	          String s2=s.substring(i+1,s.length());
	           
	          boolean b1=possible(s1,list); 
	          boolean b2=possible(s2,list);
	           
	          if(b1 && b2)
	          { ans=true;
	             break;
	          }               
	        }
	   
	     map.put(s,ans);
	     return ans;
	}
	 
	 //140. Word Break II
	 public static List<String> wordBreak(String s, List<String> wordDict) {
	        Map<Integer, List<String>> memo = new HashMap();
	        return backtracking(0, s, wordDict, memo);
	    }
	 private static final String SPACE = " ";
	 public static List<String> backtracking(int index, String s, List<String> wordDict, Map<Integer, List<String>> memo){
	        if(index == s.length())
	            return Arrays.asList("");
	        
	        if(memo.containsKey(index)) 
	            return memo.get(index);
	        
	        List<String> res = new ArrayList();
	        
	        for(String word : wordDict){
	            if(s.indexOf(word, index) == index){
	                List<String> rest = backtracking(index + word.length(), s, wordDict, memo);
	                for(String restSentence : rest){
	                    if(restSentence.equals("")) res.add(word);
	                    else res.add(word + SPACE + restSentence);
	                }
	            }
	        }
	        memo.put(index, res);
	        return res;
	    }
	 //300. Longest Increasing Subsequence https://leetcode.com/problems/longest-increasing-subsequence/ ||https://www.youtube.com/watch?v=mouCn3CFpgg
	 public static List<Integer> longestIncreasingSubSequence(int a[]){
		 int dp[] =new int [a.length];
		 int max_index =0,max_value=0; //to store max subsequence last position 
		 
		 /* Initialize LIS values for all indexes  as by defaul one digit is increasing itself*/
         for ( int i = 0; i < a.length; i++ ) 
            dp[i] = 1; 
		 
		 for(int i=1;i<a.length;i++) {
			 for(int j=0;j<i;j++) {
				 if(a[i]>a[j] && dp[i]<=dp[j]) //in current is greater then previous and have less value in dp array
				 {
					 dp[i]=1+dp[j];
					 if(dp[i]>max_value) {// max is not necessarily at end so capture map position and value to extract all values 
						 max_value=dp[i];
						 max_index=i;
					 }
				 }
			 }
		 }
		 List<Integer> l=new ArrayList<>();
		 // now we have count of max then we can back track and add value then decrease value of max then check dp again for that value 
		 int i=max_index;
		 int cur=dp[i];
		 while(i>=0) {
			 if(dp[i]==cur) {
				l.add(a[i--]);
				cur--;
			 }else {i--;}
		 }
		 
		 return l;
	 }
	 
	 
	 //368. Largest Divisible Subset (NOT WORKING IN LEET)| https://leetcode.com/problems/largest-divisible-subset/
	 public static List<Integer> largestDivisibleSubset(int[] nums) {
	        List<Integer> result = new ArrayList<>();
	        Arrays.sort(nums);
	    
	        int[] dp = new int[nums.length];
	        
	        for (int i = 0; i < nums.length; i++) {
	            List<Integer> list = new ArrayList<>();
	            dp[i] = 1;
	            for (int j = 0; j < i; j++) {
	                if (nums[i] % nums[j] == 0) {
	                    if (dp[i] < dp[j]+1) {
	                        dp[i] = dp[j]+1;
	                        list.add(nums[j]);
	                    }
	                }
	            }
	            
	            if (result.size() <= list.size()) {
	                list.add(nums[i]);
	                result = new ArrayList<>(list);
	            }
	        }
	        
	        return result;
	        }
	    
}
