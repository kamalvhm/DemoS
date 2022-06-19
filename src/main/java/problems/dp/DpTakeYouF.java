package problems.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//https://takeuforward.org/dynamic-programming/striver-dp-series-dynamic-programming-problems/
public class DpTakeYouF {

	public static void main(String[] args) {
		//System.out.println("Fibonacci "+fib(5));
		
		int a[]= {10,20,30,10};
		int dp[]=new int[5];
		Arrays.fill(dp, -1);
		//System.out.println("FrogJump "+frogJumpWithKJumps(a,a.length-1,3,dp));
		//System.out.println("FrogJump "+frogJumpWithKJumps2(a,3));
		//System.out.println("House Robber "+houseRobber(a,a.length-1,dp));
		//System.out.println("House Robber "+houseRobberSpace(a));
		int b[][]= {{10,50,1},{5,100,11}};
		System.out.println("Ninja "+ninjaTraining(b));

		
	}
	//prob 26 Print LCS 
	//prob 25
    public static int solve(String s,String t,int n,int m,int[][]dp){
        if(n<0 || m<0){
          return 0; 
        }
        if(dp[n][m]!=-1)return dp[n][m];
        if(s.charAt(n)==t.charAt(m)){
            return dp[n][m]=solve(s,t,n-1,m-1,dp)+1;
        }else return dp[n][m]=Math.max(solve(s,t,n-1,m,dp),
                             solve(s,t,n,m-1,dp)); 
        
    }

	//prob 24 
	  public static int rod(int price[],int i,int n,int dp[][]){
	        if(i==0){
	                return n*price[0]; //rod Len is 1 for i==0 so no need for division
	        }
	        if(dp[i][n]!=-1)return dp[i][n];
	        int nonTake=rod(price,i-1,n,dp);
	        int take=0;
	        int rodLen=i+1;
	        if(rodLen<=n){
	            take=rod(price,i,n-rodLen,dp)+price[i];
	        }
	        return dp[i][n]=Math.max(take,nonTake);
	    }
	  
	  public static int cutRod(int price[], int n) {
			int dp[][]=new int[n][n+1];
	          
	        for(int i=1;i<=n;i++){
	            dp[0][i]=i*price[0];
	        }
	        for(int i=1;i<n;i++){
	            for(int j=1;j<=n;j++){
	                int nonTake=dp[i-1][j];
	                int take=0;
	                int rodLen=i+1;
	                if(rodLen<=j){
	                    take=dp[i][j-rodLen]+price[i];
	                }
	                 dp[i][j]=Math.max(take,nonTake);
	            }
	        }
	        return dp[n-1][n];
		}
	
	//prob 23 
	  public static int unbounded(int[]wt,int val[],int i,int w,int [][]dp){
	        if(i==0){
	            if(wt[0]<=w)return w/wt[0]*val[0];
	            else return 0;
	        }
	        if(dp[i][w]!=-1)return dp[i][w];
	        int notTake=unbounded(wt,val,i-1,w,dp);
	        int take=Integer.MIN_VALUE;
	        if(wt[i]<=w)
	            take=val[i]+unbounded(wt,val,i,w-wt[i],dp);
	        return dp[i][w]=Math.max(take,notTake);
	    }
	  
	  public static int unboundedKnapsack(int n, int w, int[] val, int[] wt) {
	        int dp[][]=new int[n+1][w+1];

	        for(int j=0;j<=w;j++){
	            if(wt[0]<=j)
	                dp[0][j]= ((int)j/wt[0])*val[0];
	        }
	        for(int i=1;i<n;i++){
	            for(int j=0;j<=w;j++)
	            {
	                int notTake=dp[i-1][j];
	                int take=Integer.MIN_VALUE;
	                if(wt[i]<=j)
	                    take=val[i]+dp[i][j-wt[i]];
	                 dp[i][j]=Math.max(take,notTake); 
	            }
	        }
	        return dp[n-1][w];
	    }
	//prob 22
	public static long coinSum(int a[],int i,int t,long [][]dp){
        if(i==0){
            return t%a[0]==0?1:0;
        }
        if(dp[i][t]!=-1)return dp[i][t];
        long notTake=coinSum(a,i-1,t,dp);
        long take=0;
        if(a[i]<=t)
            take=coinSum(a,i,t-a[i],dp);
        return dp[i][t]=take+notTake;
    }

	public static long coinSum(int a[], int t) {
		int n = a.length;
		long dp[][] = new long[n][t + 1];

		for (int i = 0; i <= t; i++) {
			if (i % a[0] == 0)
				dp[0][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= t; j++) {
				long notTake = dp[i - 1][j];
				long take = 0;
				if (a[i] <= j)
					take = dp[i][j - a[i]];
				dp[i][j] = take + notTake;
			}
		}
		return dp[n - 1][t];
	}
	
	//Prob 21 Target Sum assign Signs 
	public static int targetSum(int n, int k, int[] num) {
   	 //int n = num.length;

       int total=0;
       for(int i:num)
           total+=i;
       if(total-k <0 || (total-k)%2==1) return 0;
       int s1=(total-k)/2;
       int dp[][]=new int[n+1][s1+1];
       for(int d[]:dp)
           Arrays.fill(d,-1);
       return findWaysUtil(num.length-1,s1,num,dp);
       
   }

	//Prob 20 Count Min Coin - countMinCoin(num,n-1,x,dp);  int dp[][]=new int[n+1][x+1];
	 public static int countMinCoin(int a[],int i,int w,int dp[][]){
	        if(i==0){
	            if(w%a[0]==0)return w/a[0];
	            else return Integer.MAX_VALUE;
	        }
	        if(dp[i][w]!=-1)return dp[i][w];
	        int notTake=countMinCoin(a,i-1,w,dp);
	        int take=Integer.MAX_VALUE;
	        if(a[i]<=w)
	            take=countMinCoin(a,i,w-a[i],dp)+1;
	        return dp[i][w]=Math.min(take,notTake);
	    }
	 
	 public static int countMinCoin(int num[], int x) {
	        int n=num.length;
	        int dp[][]=new int[n][x+1];
	        for(int j=0;j<x+1;j++){
	            if(j%num[0]==0)
	                dp[0][j]=j/num[0];
	            else dp[0][j]=Integer.MAX_VALUE-1;
	        }
	        for(int i=1;i<n;i++){
	            for(int j=0;j<x+1;j++){
	                int notTake=dp[i-1][j];
	                int take=Integer.MAX_VALUE-1;
	                if(num[i]<=j)
	                    take=dp[i][j-num[i]]+1;
	                 dp[i][j]=Math.min(take,notTake);
	            }
	        }
	        return dp[n-1][x]!=Integer.MAX_VALUE-1?dp[n-1][x]:-1;
	    }

	//prob 19  solve(weight,value,n-1,maxWeight,dp);
	static int knapsackUtil(int[] wt,int[] val, int ind, int W,int[][] dp){

	    if(ind == 0){
	        if(wt[0] <=W) return val[0];
	        else return 0;
	    }
	    
	    if(dp[ind][W]!=-1)
	        return dp[ind][W];
	        
	    int notTaken = 0 + knapsackUtil(wt,val,ind-1,W,dp);
	    
	    int taken = Integer.MIN_VALUE;
	    if(wt[ind] <= W)
	        taken = val[ind] + knapsackUtil(wt,val,ind-1,W-wt[ind],dp);
	        
	    return dp[ind][W] = Math.max(notTaken,taken);
	}

    
    static int knapsack(int[] wt, int[] val, int n, int w) {
        int dp[][]=new int[n][w+1];
      
      for(int i=wt[0];i<=w;i++)
          dp[0][i]=val[0];
      for(int i=1;i<n;i++){
          for(int j=0;j<=w;j++){
              int notTake=dp[i-1][j];
              int take=Integer.MIN_VALUE;
              if(wt[i]<=j)
                  take=dp[i-1][j-wt[i]]+val[i];
              dp[i][j]=Math.max(take,notTake);
          }
      }
      
      return dp[n-1][w];
  }
    static int knapsackSP(int[] wt, int[] val, int n, int w) {
        //int dp[][]=new int[n][w+1];
        int prev[]=new int[w+1];

        for(int i=wt[0];i<=w;i++)
            prev[i]=val[0];
        for(int i=1;i<n;i++){
             int curr[]=new int[w+1];
            for(int j=0;j<=w;j++){
                int notTake=prev[j];
                int take=Integer.MIN_VALUE;
                if(wt[i]<=j)
                    take=prev[j-wt[i]]+val[i];
                curr[j]=Math.max(take,notTake);
            }
            prev=curr;
        }
        
        return prev[w];
    }
	//prob 18
	 static int mod =(int)(Math.pow(10,9)+7);
		public static int countPartitions(int n, int d, int[] arr) {
		  int totSum = 0;
	        for(int i=0; i<n;i++){
	            totSum += arr[i];
	        }
	    
	    //Checking for edge cases
	    if(totSum-d <0 || (totSum-d)%2==1 ) return 0;
	    
	    return findWays2(arr,(totSum-d)/2);
		}
	    
	 static int findWays2(int[] num, int tar){
	     int n = num.length;

	    int dp[][] = new int[n][tar+1];
	    
	    if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
	    else dp[0][0] = 1;  // 1 case - not pick
	    
	    if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick
	    
	    for(int ind = 1; ind<n; ind++){
	        for(int target= 0; target<=tar; target++){
	            
	            int notTaken = dp[ind-1][target];
	    
	            int taken = 0;
	                if(num[ind]<=target)
	                    taken = dp[ind-1][target-num[ind]];
	        
	            dp[ind][target]= (notTaken + taken)%mod;
	        }
	    }
	    return dp[n-1][tar];
	}

	
	//prob 17  Explaination of BC https://www.youtube.com/watch?v=zoilQD1kYSg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=19
	static int findWaysUtil(int ind, int target, int[] arr,int[][] dp){
	    if(target==0)
	        return 1;
	    
	    if(ind == 0)
	        return arr[0] == target?1:0;
	    
	    //if 0 allowed in array BC 1 is removed and bc two is change
//	    if(ind==0){
//	           if(arr[0]==0 && target==0)return 2;
//	           if(arr[0]==target || target==0)return 1;
//	           return 0;
//	       }  FOR TEBULATION  
//	    if(arr[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
//	    else dp[0][0] = 1;  // 1 case - not pick
//	    
//	    if(arr[0]!=0 && arr[0]<=target) dp[0][arr[0]] = 1;  // 1 case -pick where evere we see less value then target we can pick that
	    //so we have to fill like that <= to fill entire bc we can pick
	  
	    
	    if(dp[ind][target]!=-1)
	        return dp[ind][target];
	        
	    int notTaken = findWaysUtil(ind-1,target,arr,dp);
	    
	    int taken = 0;
	    if(arr[ind]<=target)
	        taken = findWaysUtil(ind-1,target-arr[ind],arr,dp);
	        
	    return dp[ind][target]= notTaken + taken;
	}
	
	static int findWays(int[] num, int k){
	    int n = num.length;

	    int[][] dp=new int[n][k+1];
	    
	    for(int i=0; i<n; i++){
	        dp[i][0] = 1;
	    }
	    
	    if(num[0]<=k)
	        dp[0][num[0]] = 1;
	    
	    for(int ind = 1; ind<n; ind++){
	        for(int target= 1; target<=k; target++){
	  
	            int notTaken = dp[ind-1][target];
	    
	            int taken = 0;
	                if(num[ind]<=target)
	                    taken = dp[ind-1][target-num[ind]];
	        
	            dp[ind][target]= notTaken + taken;
	        }
	    }
       return dp[n-1][k];

	}
	
	//prob 16
	public static int minSubsetSumDifference(int[] arr, int n) {
		int total=0;
        for(int i:arr)
            total+=i;
        int min=Integer.MAX_VALUE;
//        boolean []dp=subsetSumToKSPace(arr.length,total+1,arr);
//        for(int i=0;i<=total/2;i++){
//            if(dp[i]){
//                int s1=i;
//                int s2=total-i;
//                min=Math.min(min,Math.abs(s2-s1));
//            }
//            }
           return min==Integer.MAX_VALUE?0:min;
	}
    
	//prob 14 https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/
	 public static boolean solve(int a[],int m,int n,int [][]dp){
	        if(m==0)return true;
	        if(n==0)return false; //check notes for this condition
	        if(dp[n][m]!=-1)return dp[n][m]==1?true:false;
	        boolean flag=false;
	        if(a[n-1]<=m)
	            flag=(solve(a,m-a[n-1],n-1,dp) || solve(a,m,n-1,dp));
	        else   flag=solve(a,m,n-1,dp);
	        dp[n][m]=flag?1:0;
	        return flag;
	    }
	 
	 static boolean subsetSumToKDP(int n, int k,int[] arr){
		    
		    
		    boolean dp[][]= new boolean[n][k+1];
		    
		    for(int i=0; i<n; i++){
		        dp[i][0] = true;
		    }
		    
		    if(arr[0]<=k)
		        dp[0][arr[0]] = true;
		    
		    for(int ind = 1; ind<n; ind++){
		        for(int target= 1; target<=k; target++){
		            
		            boolean notTaken = dp[ind-1][target];
		    
		            boolean taken = false;
		                if(arr[ind]<=target)
		                    taken = dp[ind-1][target-arr[ind]];
		        
		            dp[ind][target]= notTaken||taken;
		        }
		    }
		    
		    return dp[n-1][k];
		}
	 static boolean subsetSumToK(int n, int k,int[] arr){
		    boolean prev[]= new boolean[k+1];
		    
		    prev[0] = true;
		    
		    if(arr[0]<=k) //if last element is less then only we can consider 
		        prev[arr[0]] = true;
		    
		    for(int ind = 1; ind<n; ind++){
		        boolean cur[]=new boolean[k+1];
		        cur[0] = true;
		        for(int target= 1; target<=k; target++){
		            boolean notTaken = prev[target];
		    
		            boolean taken = false;
		                if(arr[ind]<=target)
		                    taken = prev[target-arr[ind]];
		        
		            cur[target]= notTaken||taken;
		        }
		        prev=cur;
		      
		    }
		    
		    return prev[k];
		}
	 public static boolean subsetSumToKSPace(int n, int k, int arr[]){
	       boolean prev[]=new boolean[k+1];
	       prev[0]=true;

	        for(int i=1;i<n+1;i++){
	               boolean curr[]=new boolean[k+1];
	               curr[0]=true;
	            for(int j=1;j<k+1;j++){
	                if(arr[i-1]<=j)
	                    curr[j]=prev[j-arr[i-1]] || prev[j];
	                else curr[j]=prev[j];
	            }
	             prev=curr;
	        }
	        return prev[k];
	    }
	    
	//prob 13 int dp[][][] = new int[n][m][m]; CALL  maxChocoUtil(0, 0, m - 1, n, m, grid, dp);
	static int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid, 
			  int[][][] dp) {
			    if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
			      return (int)(Math.pow(-10, 9));

			    if (i == n - 1) {
			      if (j1 == j2) //reach at common cell so return one
			        return grid[i][j1];
			      else
			        return grid[i][j1] + grid[i][j2]; //two diffrent cells for alice and bob
			    }

			    if (dp[i][j1][j2] != -1)
			      return dp[i][j1][j2];

			    int maxi = Integer.MIN_VALUE;
			    for (int di = -1; di <= 1; di++) {  //explore all for alice 3 moves
			      for (int dj = -1; dj <= 1; dj++) { //for each of alice bob's 3 move 
			        int ans;
			        if (j1 == j2) //if moved and reached to common 
			          ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
			        else
			          ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj,n,
			          m, grid, dp);
			        maxi = Math.max(maxi, ans);
			      }
			    }
			    return dp[i][j1][j2] = maxi;
		}
	
	 static int maximumChocolates(int n, int m, int[][] grid) {

		    int dp[][][] = new int[n][m][m];

		    for (int j1 = 0; j1 < m; j1++) {
		      for (int j2 = 0; j2 < m; j2++) {
		        if (j1 == j2)
		          dp[n - 1][j1][j2] = grid[n - 1][j1];
		        else
		          dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
		      }
		    }

		    //Outer Nested Loops for travering DP Array
		    for (int i = n - 2; i >= 0; i--) {
		      for (int j1 = 0; j1 < m; j1++) {
		        for (int j2 = 0; j2 < m; j2++) {

		          int maxi = Integer.MIN_VALUE;

		          //Inner nested loops to try out 9 options
		          for (int di = -1; di <= 1; di++) {
		            for (int dj = -1; dj <= 1; dj++) {

		              int ans;

		              if (j1 == j2)
		                ans = grid[i][j1];
		              else
		                ans = grid[i][j1] + grid[i][j2];

		              if ((j1 + di < 0 || j1 + di >= m) ||
		                (j2 + dj < 0 || j2 + dj >= m))

		                ans += (int) Math.pow(-10, 9);
		              else
		                ans += dp[i + 1][j1 + di][j2 + dj];

		              maxi = Math.max(ans, maxi);
		            }
		          }
		          dp[i][j1][j2] = maxi;
		        }
		      }
		    }

		    return dp[0][0][m - 1];
	}

	
	//prob 12 https://leetcode.com/problems/minimum-falling-path-sum/submissions/
	 public int minFallingPathSum(int[][] matrix) {
	        int n=matrix.length;
	        int min=Integer.MAX_VALUE;
	        
	        int dp[][]=new int[n][n];
	            for(int []d:dp)
	                Arrays.fill(d,-1);
	        
	        for(int j=0;j<n;j++){//Over Lapping subproblems will be in these loop calls so maintain dp outside
	            min=Math.min(min,minFallingPathSum(matrix,n-1,j,dp));
	        }
	        return min;
	    }
	    
	    public int minFallingPathSum(int[][] matrix,int i,int j,int[][] dp){
	        if(j < 0 || j>=matrix.length)return Integer.MAX_VALUE;
	        if(i==0)return matrix[i][j];
	        if(dp[i][j]!=-1)return dp[i][j];
	        int val=Math.min(minFallingPathSum(matrix,i-1,j-1,dp),minFallingPathSum(matrix,i-1,j,dp));
	        return dp[i][j]=Math.min(val,minFallingPathSum(matrix,i-1,j+1,dp))+matrix[i][j];
	    }
	    public int minFallingPathSum2(int[][] matrix) {
	        int n=matrix.length;
	        int dp[][]=new int[n][n];
	        for(int j=0;j<n;j++){
	            dp[0][j]=matrix[0][j];
	        }
	        for(int i=1;i<n;i++){
	            for(int j=0;j<n;j++){//as posible column values start from 0 
	                int ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
	                int up=dp[i-1][j];
	                if(j-1>=0)
	                ld=dp[i-1][j-1];
	                if(j+1<n)
	                  rd=dp[i-1][j+1];
	                dp[i][j]=Math.min(Math.min(up,ld),
	                                 rd)+matrix[i][j];
	            }
	        }
	         int mini=dp[n-1][0];
	         for(int j=1;j<n;j++)
	             mini=Math.min(mini,dp[n-1][j]);
	         return mini;
	     }
	    
	    public int minFallingPathSumSPace(int[][] matrix) {
	        int n=matrix.length;
	         //int dp[][]=new int[n][n];
	         int prev[]=new int[n];

	        for(int j=0;j<n;j++){
	            prev[j]=matrix[0][j];
	        }
	        for(int i=1;i<n;i++){
	           int curr[]=new int[n];

	            for(int j=0;j<n;j++){//as posible column values start from 0 
	                int ld=Integer.MAX_VALUE,rd=Integer.MAX_VALUE;
	                int up=prev[j];
	                if(j-1>=0)
	                 ld=prev[j-1];
	                if(j+1<n)
	                 rd=prev[j+1];
	                curr[j]=Math.min(Math.min(up,ld),
	                                 rd)+matrix[i][j];
	            }
	            prev=curr;

	        }
	         int mini=prev[0];
	         for(int j=1;j<n;j++)
	             mini=Math.min(mini,prev[j]);
	         return mini;
	     }
	//prob 11 n is 'tri.size()' https://leetcode.com/problems/triangle/submissions/ 
	  public int solveTriangle(List<List<Integer>> tri,int i,int j,int n){
	        if(i==n-1)return tri.get(i).get(j);//if reached last row that means we already selected last row col so return same 
	        return Math.min(solveTriangle(tri,i+1,j,n),solveTriangle(tri,i+1,j+1,n))+tri.get(i).get(j);
	  }
	  public int solveTriangle(List<List<Integer>> triangle) {
	        int n=triangle.size();
	        int dp[][]=new int[n][n];
	        //Bc can be four as for i==n-1 j can be 0 to 3
	        for(int j=0;j<n;j++)
	            dp[n-1][j]=triangle.get(n-1).get(j);
	        for(int i=n-2;i>=0;i--){
	            for(int j=i;j>=0;j--){//every ith row will have o to ith columns 
	                dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
	            }
	        }
	        return dp[0][0];
	    }
	  //Space Optimized but not running well
	   public int minimumTotal(List<List<Integer>> triangle) {
	        int n=triangle.size();
	         int front[] = new int[n];
	     int cur[] = new int[n];
	    
	    for(int j=0;j<n;j++){
	        front[j] = triangle.get(n-1).get(j);
	    }
	    
	    for(int i=n-2; i>=0; i--){
	        for(int j=i; j>=0; j--){
	            
	            
	            cur[j] = Math.min(front[j], front[j+1])+triangle.get(i).get(j);
	        }
	        front=cur;
	    }
	    
	        return front[0];
	    }
	//prob 10 https://leetcode.com/problems/minimum-path-sum/
	 public int minPathSum(int[][] grid) {
	        int n=grid.length;
	        int m=grid[0].length;
	        int dp[][]=new int[n+1][m+1];
	        
	        for(int i=0;i<n+1;i++)
	            dp[i][0]=Integer.MAX_VALUE;
	        for(int j=0;j<m+1;j++)
	           dp[0][j]=Integer.MAX_VALUE;
	        
	        //dp[0][0]=grid[0][0];
	        for(int i=1;i<n+1;i++){
	            for(int j=1;j<m+1;j++){
	                if(i==1 && j==1)dp[i][j]=grid[i-1][j-1];
	                else dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
	            }
	        }
	        return dp[n][m];
	        
	        // for(int[] d:dp)
	        //     Arrays.fill(d,-1);
	        // return solve(grid,n-1,m-1,dp);
	    }
	    
	    public int solve(int [][]grid,int i,int j,int[][] dp){
	        if(i==0 && j==0)return grid[i][j];
	        if(i<0 || j<0)return Integer.MAX_VALUE;
	        if(dp[i][j]!=-1)return dp[i][j];
	        return dp[i][j]=Math.min(solve(grid,i-1,j,dp),solve(grid,i,j-1,dp))+grid[i][j];
	    }
	//prob 9 https://leetcode.com/problems/unique-paths-ii/	
	static int mazeObstaclesUtil(int i, int j, int[][] maze, int[][] dp) {
		  if(i>0 && j>0 && maze[i][j]==-1) return 0; 
		  if(i==0 && j == 0)
		    return 1;
		  if(i<0 || j<0)
		    return 0;
		  if(dp[i][j]!=-1) return dp[i][j];
		    
		  int up = mazeObstaclesUtil(i-1,j,maze,dp);
		  int left = mazeObstaclesUtil(i,j-1,maze,dp);
		  
		  return dp[i][j] = up+left;
		  
		}
	
	 public int uniquePathsWithObstacles(int[][] grid) {
         int m = grid.length; 
		 int n = grid[0].length;
        //one length bigger so that 0 row col repesent out of boud conditions 
         int dp[][]=new int [m+1][n+1];
	      //row 0 and col 0 represent if(m<0 || n<0)return 0; case and 1 represents if(m==0 && n==0)return 1; case in dp array

          for(int i=1;i<m+1;i++){
	            for(int j=1;j<n+1;j++){
                    if(grid[i-1][j-1]==1)dp[i][j]=0;//bc one
                    else if(i==1 && j==1)dp[i][j]=1;//bc two 
	                else dp[i][j]=dp[i-1][j]+dp[i][j-1];//bc there is already zero in dp array so no need
	            }
	        }
        return dp[m][n];
    }

	//prob 8 
	 public static int uniquePaths(int m,int n,int [][]dp){
	        if(m==0 && n==0)return 1;
	        if(m<0 || n<0)return 0;
	        if(dp[m][n]!=-1)return dp[m][n];
	       return dp[m][n]=uniquePaths(m-1,n,dp)+uniquePaths(m,n-1,dp);
	 }
	  public int uniquePaths(int m, int n) {
	        int dp[][]=new int[m+1][n+1];
	    
	        //row 0 and col 0 represent if(m<0 || n<0)return 0; case and 1 represents if(m==0 && n==0)return 1; case in dp array
	        for(int i=1;i<m+1;i++){
	            for(int j=1;j<n+1;j++){
	                if(i==1 && j==1)dp[i][j]=1; 
	                else dp[i][j]=dp[i-1][j]+dp[i][j-1];
	            }
	        }
	        return dp[m][n];
	    }
	 
	 static int uniquePathsSpace(int m, int n){
		    int prev[]=new int[n];
		    for(int i=0; i<m; i++){
		        int temp[]=new int[n];
		        for(int j=0; j<n; j++){
		            if(i==0 && j==0){
		                temp[j]=1;
		                continue;
		            }
		            int up=0;
		            int left =0;
		            
		            if(i>0)
		                up = prev[j];
		            if(j>0)
		                left = temp[j-1];
		                
		            temp[j] = up + left;
		        }
		        prev = temp;
		    }
		    
		    return prev[n-1];
		    
		}
	 
	//prob 7 (CHECK TUF.JAVA )https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
	public static int ninjaTraining(int task[][], int day, int last, HashMap<String, Integer> map) {
		if (day == 0) {
			int max = 0;
			for (int c = 0; c < task[day].length; c++) {
				if (c != last)
					max = Math.max(max, task[0][c]);
			}
			return max;
		}
		String key = 	 day+ "-" + last;
		if (map.containsKey(key))
			return map.get(key);
		int max = Integer.MIN_VALUE;
		for (int c = 0; c < task[day].length; c++) {
			if (c != last) {
				int points = task[day][c] + ninjaTraining(task, day - 1, c, map);
				max = Math.max(max, points);
			}
		}
		map.put(key, max);
		return max;

	}
	  public static int ninjaTraining(int[][] points){
		  int n=points.length;
		  int[][] dp = new int[n][4];
	        dp[0][0] = Math.max(points[0][1], points[0][2]);
	        dp[0][1] = Math.max(points[0][0], points[0][2]);
	        dp[0][2] = Math.max(points[0][0], points[0][1]);
	        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

	        for (int day = 1; day < n; day++) {
	            for (int last = 0; last < 4; last++) {
	                dp[day][last] = 0;
	                for (int task = 0; task <= 2; task++) {
	                    if (task != last) {
	                        int activity = points[day][task] + dp[day - 1][task];
	                        dp[day][last] = Math.max(dp[day][last], activity);
	                    }
	                }
	            }

	        }

	        return dp[n - 1][3];
	    }
	//prob 6 circler houses
	  public int CirculerRob(int[] nums) {
	        if(nums.length==0)return 0;
	        if(nums.length==1)return nums[0];
	        int n=nums.length-1;
	        int[] temp1=new int[n];
	        int[] temp2=new int[n];
	        for(int i=1;i<nums.length;i++){
	            temp1[i-1]=nums[i];
	        }
	         for(int i=0;i<nums.length-1;i++){
	            temp2[i]=nums[i];

	        }
	        return Math.max(houseRobber2(temp1),houseRobber2(temp2));
	    }
	//prob 5
	private static int houseRobber(int[] a, int i,int [] dp) {
		if(i==0)return a[0];
		if(i<0)return 0;
		if(dp[i]!=-1)return dp[i];
		return dp[i]=Math.max(houseRobber(a, i-2,dp)+a[i], houseRobber(a, i-1,dp));
	}
	private static int houseRobber2(int[] a) {
		int n=a.length-1;
		int dp[]=new int[a.length];
		dp[0]=a[0];
		for(int i=1;i<=n;i++) {
			int take=a[i]+(i>1?dp[i-2]:0);
			int nontake=dp[i-1];
			dp[i]=Math.max(take,nontake);
		}
		return dp[n];      
	}
	
	private static int houseRobberSpace(int[] a) {
		int n=a.length-1;
		int prev=a[0],prev2=0;
		for(int i=1;i<n;i++) {
			int take=a[i]+(i>1?prev2:0);
			int nonTake=prev;
			int curr=Math.max(take, nonTake);
			prev2=prev;
			prev=curr;
		}
		return prev;
	}

	
	//Prob 4
	private static int frogJumpWithKJumps(int[] a, int i,int k, int[] dp) {
		if(i<=0)return 0;
		if(dp[i]!=-1)return dp[i];
		int n=a.length;
		int min=Integer.MAX_VALUE;
		int cost=0;
		for(int j=1;j<=k;j++) {
			//if(i>j-1)//based on prev quetion condition
			 if(i-j>=0)
				cost=frogJumpWithKJumps(a, i-j, k,dp)+Math.abs(a[i]-a[i-j]);
			min=Math.min(cost, min);
		}
		return dp[i]=min;
	}
	private static int frogJumpWithKJumps2(int[] a,int k) {
		int n=a.length;
		int dp[]=new int[n]; //Step 1 create a dp array
		dp[0]=0;
		for(int i=1;i<n;i++) { //both above subclass will run from n==1 to <n
			int cost=Integer.MAX_VALUE;
			for(int j=1;j<=k;j++) {
				int jump=0;
				if(i-j>=0)
					jump=dp[i-j]+Math.abs(a[i]-a[i-j]);
				cost=Math.min(jump,cost);
			}
			dp[i]=cost;
		}
		return dp[n-1];
	}
	//Prob 3
	private static int frogJump(int []a,int i,int[] dp) {
		if(i==0)return 0;
		if(dp[i]!=-1)return dp[i];
		int one=0,two=Integer.MAX_VALUE;
		 one=frogJump(a, i-1,dp)+Math.abs(a[i]-a[i-1]);
		 if(i>1)
		 two=frogJump(a, i-2,dp)+Math.abs(a[i]-a[i-2]);
		return dp[i]=Math.min(one, two);
	}
	
	private static int frogJump2(int []a) {
	/**	
	 	int n=a.length;
		int dp[] = new int[n];
		dp[0] = 0;
		for (int i = 1; i < n; i++) {
			int val1 = dp[i - 1] + Math.abs(a[i] - a[i - 1]);
			int val2 = Integer.MAX_VALUE;
			if (i > 1)
				val2 = dp[i - 2] + Math.abs(a[i] - a[i - 2]);
			dp[i] = Math.min(val1, val2);
		}
		return dp[a.length-1];
	*/
		
		/********Space Optimization*********/
		int n=a.length;
		int dp[] = new int[n];
		int prev = 0;
		int prev2=0;
		for (int i = 1; i < n; i++) {
			int val1 = prev + Math.abs(a[i] - a[i - 1]);
			int val2 = Integer.MAX_VALUE;
			if (i > 1)
				val2 = prev2 + Math.abs(a[i] - a[i - 2]);
			int curri = Math.min(val1, val2);
			prev2=prev;
			prev=curri;	
		}
		return prev;
	}
	
//	  int dp[]=new int[n+1];
//      dp[0]=dp[1]=1;
//      for(int i=2;i<=n;i++){
//          dp[i]=dp[i-1]+dp[i-2];
//      }
//      return dp[n];
	  public int stairs(int n,int dp[]){
	       if(n<=1)return 1;
	       if(dp[n]!=-1)return dp[n];
	       else return dp[n]=stairs(n-1,dp)+stairs(n-2,dp);
	    }

	public static int fib(int n) {
		int dp[]=new int[n+1];
		int prev2=0,prev=1;
		for(int i=2;i<=n;i++) {
			int curri=prev+prev2;
			prev2=prev;
			prev=curri;
		}
		return prev;
	}
	
	

}
