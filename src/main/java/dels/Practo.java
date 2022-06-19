package dels;

import java.util.Arrays;

public class Practo {

	public static void main(String[] args) {
		
		int a[]= {24 ,36, 1, 3, 29, 0, 38, 17, 35, 31, 42, 30, 44, 35, 22};
		int dp[]=new int[9];
		Arrays.fill(dp,-1);
		System.out.println(countSubsetSum(a,21,a.length));

	}
	
	
	public static int countSubsetSum(int[] arr , int sum, int n) {
		int top[][] =new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0) //No subset available
					top[i][j]=0;
				if(j==0)  //Null subset {} count is 1 
					top[i][j]=1;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					top[i][j]=top[i-1][j-arr[i-1]] + top[i-1][j]; //OR will change to + as we have to add in count 
				}else top[i][j]=top[i-1][j]; 
			}
		}
		return top[n][sum];
	}
	
	
	public static int jump(int []a,int n) {
		if(n==0)return 0; 
		int val1=jump(a, n-1)+Math.abs(a[n]-a[n-1]);
		int val2=Integer.MAX_VALUE;
		if(n>1)
		 val2=jump(a, n-2)+Math.abs(a[n]-a[n-2]);
		return Math.min(val1, val2);
	}
	public static int jump(int []a) {
		int n=a.length;
		int dp[]=new int[n];
	    for(int i=1;i<n;i++) {
	    	int val1=dp[i-1]+Math.abs(a[i]-a[i-1]);
	    	int val2=Integer.MAX_VALUE;
	    	if(i>1)
	    		val2=dp[i-2]+Math.abs(a[i]-a[i-2]);
	    	dp[i]=Math.min(val1,val2);
	    }
	    return dp[n-1];
	}
	

	private static int stairs(int i,int dp[]) {
		if(i==0)return 1;
		if(i<0)return 0;
		if(dp[i]!=-1)return dp[i];
		return dp[i]=stairs(i-1,dp)+stairs(i-2,dp);
	}

	private static int stairs(int n) {
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
}
