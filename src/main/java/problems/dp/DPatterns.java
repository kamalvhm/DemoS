package problems.dp;

import java.util.HashMap;

/** PATTERNS 
 * 1) Grid Traveler :-63 Unique Paths 2, 64. Minimum Path Sum
 * 
 * @author z00427hs
 *
 */

public class DPatterns {
	static HashMap<String, Integer> map2 = new HashMap<String, Integer>();
	public static void main(String[] args) {

	}
	  
	 
	 public static int gridTraveler(int a, int b) {
			
			if (a == 0 || b == 0)
				return 0;
			if (a == 1 && b == 1)
				return 1;
			
			return gridTraveler(a - 1, b) + gridTraveler(a, b - 1);

		}
		//64. Minimum Path Sum  VARIATION CHECK CODE ONLINE 
		public static int gridTraveler1(int a, int b) {
			String key=a+"-"+b;
			if(map2.containsKey(key))return map2.get(key);
			if (a == 0 || b == 0)
				return 0;
			if (a == 1 && b == 1)
				return 1;
			map2.put(key, gridTraveler(a - 1, b) + gridTraveler(a, b - 1));
			return map2.get(key);

		}
	//63. Unique Paths II | https://leetcode.com/problems/unique-paths-ii/
		public static int gridTraveler2(int a, int b) {
			int dp[][] = new int[a + 1][b + 1];

			for (int i = 1; i < a + 1; i++) {
				for (int j = 1; j < b + 1; j++) {
					if (i == 1 || j == 1) {
						dp[i][j]=1;
					} else
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

				}
			}
			return dp[a][b];
		}
	 //based on GridTraveller Pattern 
	 //62. Unique Paths  #RECURSION  // check Grid Traveler problem in DPFreeCodeCamp.java
	    public int uniquePaths(int m, int n) {
	        int[][] dp = new int[m][n]; //dp 2-D memorization array to store the no of unique paths for each block
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
	    
	    //746. Min Cost Climbing Stairs
	    public static int solve(int [] c,int n,HashMap<Integer,Integer> map){
	        if(n==0 || n==1)return 0;
	        if(map.containsKey(n))return map.get(n);
	        else {
	            int val=Math.min(c[n-1]+solve(c,n-1,map),c[n-2]+solve(c,n-2,map));
	            map.put(n,val);
	            return val;
	        }
	    }
	    //746 Same as above Bottom up
	    public static int solve(int [] c,int n){
	        int dp[]=new int [n+1]; 
	        for(int i=2;i<=n;i++){
	            dp[i]=Math.min(c[i-1]+dp[i-1],c[i-2]+dp[i-2]);
	        }
	        return dp[n];
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
}
