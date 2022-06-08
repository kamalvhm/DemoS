package problems.dp;

import java.util.Arrays;
import java.util.HashMap;

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
	//prob 10
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
		
		/********Space Optimisation*********/
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
