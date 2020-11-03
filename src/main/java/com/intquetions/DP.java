package com.intquetions;

public class DP {

	public static void main(String[] args) {

	}
	  //91. Decode Ways  https://www.youtube.com/watch?v=cQX3yHS0cLo , https://www.youtube.com/watch?v=qli-JCrSwuk
    /* A message containing letters from A-Z is being encoded to numbers using the following mapping:

   	 'A' -> 1
   	 'B' -> 2
   	 ...
   	 'Z' -> 26*/
	 public int numDecodings(String s) {
           int[] dp=new int[s.length()+1];
           dp[0]=1;
           dp[1]=s.charAt(0)=='0'? 0:1;
       
       for(int i=2;i<=s.length();i++){
           int oneDigit=Integer.valueOf(s.substring(i-1,i));
           int twoDigit=Integer.valueOf(s.substring(i-2,i));
           if(oneDigit>=1){
               dp[i]+=dp[i-1];
           }
           if(twoDigit>=10 && twoDigit<=26){
               dp[i]+=dp[i-2];
           }
           
       }
      return dp[s.length()];
   }
	 
	 //62. Unique Paths  #RECURSION
	    public int uniquePaths(int m, int n) {
	        int[][] dp = new int[m][n]; //dp 2-D memoization array to store the no of unique paths for each block
	        return uniquePaths(m-1, n-1, dp); //passing the (row, col) of the target block       
	    }
	    
	    public int uniquePaths(int row, int col, int[][] dp){   //overloaded function to make recursive calls to
	        if(row == 0 || col == 0){   //for blocks in the first row or the first column, no. of paths = 1
	            dp[row][col] = 1;
	            return dp[row][col];
	        }
	        if(dp[row][col] != 0){  //if already calculated, return the no. of paths here
	            return dp[row][col];
	        }
	        /* Recurrent relation, noOfPaths(i,j) = noOfpaths(i-1, j) + noOfPaths(i, j-1)
	        This is explained by the fact that a particular block can only be reached 
	        from the block above it or from the block to its left.*/
	        dp[row][col] = uniquePaths(row - 1, col, dp) + uniquePaths(row, col - 1, dp);  //recursive calls to the overloaded method
	        return dp[row][col];
	    }
	 
}
