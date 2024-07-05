package problems.dp;

public class TakeYouDp {

	public static void main(String[] args) {
		 System.out.println("1) Feb (8)"+feb(6)+" Buttom up "+feb2(6));
		 System.out.println("3) Frog Jump (20) "+frogJump(new int[] {10,20,30,10},3)+" Bottom up "+frogJumpKJumps(new int[] {10,20,30,10},3,2));
		 //System.out.println("8) Ninja Training (8)"+ninja(6));
	
	}

	private static int frogJump(int[] a, int i) {
		if(i<=0) {
			return 0;
		}
		
		int left=frogJump(a,i-1)+Math.abs(a[i]-a[i-1]);
		int right=Integer.MAX_VALUE;
		if(i-2>=0)
		 right=frogJump(a, i-2)+Math.abs(a[i]-a[i-2]);
		return Math.min(left, right);
	}

	private static int frogJumpBottom(int[] a, int i) {
		int n=a.length;
		int dp[]=new int[n+1];
		for(int j=1;j<n;j++) {
			int left=dp[j-1]+Math.abs(a[j]-a[j-1]);
			int right=Integer.MAX_VALUE;
			if(j-2>=0)
			 right=dp[j-2]+Math.abs(a[j]-a[j-2]);
			dp[j]= Math.min(left, right);
		}
		return dp[n-1];
	}
	
	private static int frogJumpBottomOpt(int[] a, int i) {
		int n=a.length;
		int prev2=0,prev1=0;
		for(int j=1;j<n;j++) {
			int left=prev1+Math.abs(a[j]-a[j-1]);
			int right=Integer.MAX_VALUE;
			if(j-2>=0)
			 right=prev2+Math.abs(a[j]-a[j-2]);
			int cur= Math.min(left, right);
			prev2=prev1;
			prev1=cur;
		}
		return prev1;
	}
	
	private static int frogJumpKJumps(int[] a, int i,int k) {
		if(i<=0) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		int val=Integer.MAX_VALUE;
		for(int j=1;j<=k;j++) {
			if(i-j>=0)
				val=frogJump(a, i-j)+Math.abs(a[i]-a[i-j]);
			min=Math.min(min, val);
		}
		
		return min;
//		int n=a.length;
//		int dp[]=new int[n];
//		for(int i=1;i<n;i++) {
//			int min=Integer.MAX_VALUE;
//			int val=Integer.MAX_VALUE;
//			for(int j=1;j<=k;j++) {
//				if(i-j>=0)
//					val=dp[i-j]+Math.abs(a[i]-a[i-j]);
//				min=Math.min(min, val);
//			}
//			dp[i]=min;
//		}
//		return dp[n-1];
	}

	private static int feb(int n) {
		if(n<=1)return n;
		else 
		return feb(n-1)+feb(n-2);
	}


	private static int feb2(int n) {
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	 public int climbStairs(int n) {
	         if(n==0)return 1;
	         if(n==1)return 1;
	         return climbStairs(n-1)+climbStairs(n-2);
	    }

	     public int climbStairsBottom(int n) {
	        int dp[]=new int[n+1];
	        dp[1]=dp[0]=1;
	        for(int i=2;i<=n;i++){
	            dp[i]=dp[i-1]+dp[i-2];
	        }
	        return dp[n];
	    }
	     
	     public static int ninja(int [][]a,int r,int last){
	         if(r==a.length)return 0;

	         int max=0;
	         for(int c=0;c<a[0].length;c++){
	             if(last==-1 || last!=c){
	                 max=Math.max(a[r][c]+ninja(a,r+1,c),max);
	             }
	         }
	         return max;
	     }
	     
	     public static int ninjaTraining(int n, int points[][]) {
	         int m=points[0].length;
	         int dp[][]=new int[n+2][m+1];
	         // for(int d[]:dp){
	         //     for(int i=0;i<d.length;i++)
	         //         d[i]=-1;
	         // }
	         // return solve(points,0,3,dp);
	         for(int r=n-1;r>=0;r--){
	             for(int last=0;last<4;last++){
	                 int max=0;
	                 for(int c=0;c<m;c++){
	                     if(last!=c){
	                         max=Math.max(points[r][c]+dp[r+1][c],max);
	                     }
	                 }
	             
	                 dp[r][last]=max;
	             }
	         }
	         
	         return dp[0][3];
	         
	        //optimized
	      // int prev[]=new int[m+1];

	         // for(int r=n-1;r>=0;r--){
	         //         int temp[]=new int[m+1];

	         //     for(int last=0;last<4;last++){
	         //         int max=0;
	         //         for(int c=0;c<m;c++){
	         //             if(last!=c){
	         //                 max=Math.max(points[r][c]+prev[c],max);
	         //             }
	         //         }
	             
	         //         temp[last]=max;
	         //     }
	         //     prev=temp;
	         // }
	         
	         // return prev[3];
	         
	     }
}
