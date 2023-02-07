package problems.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
		//System.out.println("Ninja "+ninjaTraining(b));
		
		String aa[]= {"a","abc","ab"};
	    Arrays.sort(aa,new Comparator<String>() {
	
				@Override
				public int compare(String o1, String o2) {
					if(o1.length()>o2.length())return -1;
					else if (o2.length()>o1.length()) return 1;
					return o1.compareTo(o2);
				}
			});
		
		System.out.print(Arrays.toString(aa));	
	}
	//prob 57
	public static int countSquares(int n, int m, int[][] arr) {
		int dp[][]=new int[n][m];
        int total=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0)
                    dp[i][j]=arr[i][j];
                else if(arr[i][j]==1){
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j])
                                      ,dp[i-1][j-1])+1;
                }
                total+=dp[i][j];
            }
        }
        return total;
        
	}
	//prob 56
	 public int maximalRectangle(char[][] matrix) {
	        int maxArea=0;
	        int n=matrix.length;
	        int m=matrix[0].length;
	        int heights[]=new int[m]; 
	        
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(matrix[i][j]=='1')
	                    heights[j]++;
	                else heights[j]=0;
	            }
	            //int area=largestRectangleArea(heights); uncomment and use largestRectangleArea this from Stack.java
	            //maxArea=Math.max(area,maxArea);
	        }
	        return maxArea;
	    }
	//Prob 53
	public static int palindromePartitioning(String str) {
        int dp[][]=new int[str.length()][str.length()];
        int n=str.length();

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i>=j || isPalindrom(str,i,j)) continue;
                 int min=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        int part=dp[i][k]+dp[k+1][j]+1;
                        min=Math.min(min,part);
                    }
                dp[i][j]=min;
            }
        }
        return dp[0][n-1];
    }
	 public static boolean isPalindrom(String s,int i,int j){
	        while(i<j){
	            if(s.charAt(i++)!=s.charAt(j--))return false;
	        }
	        return true;
	    }
	//prob 52 skip 
	//prob 51 Balloons
	 public static int maxCoins(int nums[]) {
	        int n=nums.length;
	        int coinsNew[] = new int[n + 2];
	       
	        coinsNew[0]=coinsNew[n+1]=1;
	        int index = 1;
	        for(int coin: nums)
	            coinsNew[index++] = coin;
	        
	        //n = coinsNew.length;
	        int dp[][]=new int [n+1][n+1];
	        for(int [] d:dp)
	            Arrays.fill(d,-1);
	           
	        
	        return solv(coinsNew,1,n,dp);
	    }
	    public static  int solv(int a[],int i,int j,int dp[][]){
	            if(i>j)return 0;
	            if(dp[i][j]!=-1)return dp[i][j];
	            int max=Integer.MIN_VALUE;
	            for(int k=i;k<=j;k++){
	                int cost=a[i-1]*a[k]*a[j+1]+solv(a,i,k-1,dp)+
	                    solv(a,k+1,j,dp);
	                max=Math.max(max,cost);
	            }
	        dp[i][j]=max;
	        return max;
	    }
	    //Tabulation 
	    public int maxCoins2(int[] nums) {
	        int n=nums.length;
	         int coinsNew[] = new int[n + 2];
	        
	         coinsNew[0]=coinsNew[n+1]=1;
	         int index = 1;
	         for(int coin: nums)
	             coinsNew[index++] = coin;
	         
	         int dp[][]=new int [n+2][n+2];
	         
	         for(int i=n;i>=1;i--){
	             for(int j=1;j<=n;j++){
	                 if(i>j)continue;
	                  int max=Integer.MIN_VALUE;
	                     for(int k=i;k<=j;k++){
	                         int cost=coinsNew[i-1]*coinsNew[k]*coinsNew[j+1]
	                             +dp[i][k-1]+
	                             dp[k+1][j];
	                         max=Math.max(max,cost);
	                     }
	                     dp[i][j]=max;
	             }
	         }
	            
	         return dp[1][n];
	     }
	//Prob 50 MIn cost to cut stick 
	 public static int cost(int n, int c, int cuts[]) {
	        HashMap<String ,Integer> dp=new HashMap<>();
	        ArrayList<Integer> arr=new ArrayList<>();
	        arr.add(0);
	        for(int i=0;i<cuts.length;i++)
	            arr.add(cuts[i]);
	        arr.add(n);
	        Collections.sort(arr);
	        return minCost(arr,1,c,dp);
	    }
	    
	     //Assuming cuts are sorted
	    public static int minCost(ArrayList<Integer> cuts,int i,int j,HashMap<String,Integer> dp){
	        if(i>j)return 0;
	        String key=i+"-"+j;
	        if(dp.containsKey(key))return dp.get(key);
	        int min=Integer.MAX_VALUE;
	        for(int k=i;k<=j;k++){
	            int cost=minCost(cuts,i,k-1,dp)+minCost(cuts,k+1,j,dp)
	                +cuts.get(j+1)-cuts.get(i-1);
	            min=Math.min(min,cost);
	        }
	        dp.put(key,min);
	        return min;
	    }
	    
	    //Tabulation 
	    public static int cost2(int n, int c, int cuts[]) {
	        ArrayList<Integer> arr=new ArrayList<>();
	        arr.add(0);  //added boundries
	        for(int i=0;i<cuts.length;i++)
	            arr.add(cuts[i]);
	        arr.add(n);
	        Collections.sort(arr);
	        int dp[][]=new int[c+2][c+2];
	        for(int i=c;i>=1;i--){
	            for(int j=1;j<=c;j++){
	                if(i>j)continue;
	                int min=Integer.MAX_VALUE;
	                for(int k=i;k<=j;k++){
	                int cost=dp[i][k-1]+dp[k+1][j]
	                    +arr.get(j+1)-arr.get(i-1);
	                min=Math.min(min,cost);
	                }
	              dp[i][j]=min;
	            }
	        }
	        return dp[1][c];
	    }
	//prob 48 MCM Tabulation 
	public static int matrixMultiplication(int[] arr , int N) {
		//skip BC as its already 0 in dp array
        int dp[][]=new int[N+1][N+1];
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                 int ans=Integer.MAX_VALUE;
                 for(int k=i;k<j;k++){
                    int temp=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    ans=Math.min(ans,temp);
                }
                dp[i][j]=ans;
            }
        }
        return dp[1][N-1];
	}
	//Prob 47 MCM skip ans 
	//prob 46
	public static int findNumberOfLIS(int n, int[] arr) {
		int dp[]=new int [n]; 
        int count[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        int max=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                    //inherit
                    count[i]=count[j];
                }else if(arr[j]<arr[i] && dp[j]+1==dp[i])
                       count[i]+=count[j];
            }
            max=Math.max(max,dp[i]);
        }
        //System.out.println("MAX D "+max);
       // System.out.println("HELLO D "+Arrays.toString(dp));
        //System.out.println("HELLO "+Arrays.toString(count));

        int nos=1;
        for(int i=0;i<n;i++){
            if(dp[i]==max)
                nos+=count[i];
        }
        return nos;
	}
	//prob 45
	public static int longestBitonicSequence(int[] arr, int n) {
           int dp1[]=new int[n];
           int dp2[]=new int[n];
          //LIS from left
          for(int i=0;i<n;i++){
              dp1[i]=1;
              for(int j=0;j<i;j++){
                  if(arr[j]<arr[i]){
                      dp1[i]=Math.max(dp1[i],dp1[j]+1);
                  }
              }
          } 
        //LIS from right
            for(int i=n-1;i>=0;i--){
              dp2[i]=1;
              for(int j=n-1;j>i;j--){
                  if(arr[j]<arr[i]){
                      dp2[i]=Math.max(dp2[i],dp2[j]+1);
                  }
              }
          } 
        int max=1;
        //adding both left and right -1 for common value
        for(int i=0;i<n;i++)
        {
            int bitonic=dp1[i]+dp2[i]-1;
            max=Math.max(max,bitonic);
        }
        return max;
    }
	//prob 44 NOT WORKING NEEDS RE EVAL
	public static int longestStrChain(int n, String[] arr) {
		int dp[]=new int[n];
        Arrays.sort(arr,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length())return -1;
                else if (o2.length()>o1.length()) return 1;
                return o1.compareTo(o2);
            }
        });
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(possible(arr[i],arr[j])){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                   
                } 
            }
             maxi=Math.max(dp[i],maxi);
        }
        return maxi;
	}
    public static boolean possible(String s1,String s2){
        if(s1.length()!=s2.length()+1)return false;
        int first=0;
        int secound=0;
        while(first<s1.length()){//s1 is bigger by then
            if(secound<s2.length() && s1.charAt(first)==s2.charAt(secound)){
                first++;
                secound++;
            }else {
                first++;
            }
        }
        if(first==s1.length() && secound==s2.length())return true;
        else return false;
    }
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int dp[]=new int[n];
        int hash[]=new int[n];
         //Arrays.fill(dp,1);
         //Arrays.fill(hash,1);
        int maxi=1;
        int lastIndex=0;
         for(int i=0; i<n; i++){
	        
	        hash[i] = i; // initializing with current index
	        for(int prev_index = 0; prev_index <i; prev_index ++){
	            if(nums[i]%nums[prev_index]==0 && (1 + dp[prev_index]) > dp[i]){
	                dp[i] = 1 + dp[prev_index];
	                hash[i] = prev_index;
	            }
	        }
             if(dp[i]>=maxi){
                 maxi=dp[i];
                 lastIndex=i;
             }
	    }
        List<Integer> ans=new ArrayList<>();
        ans.add(nums[lastIndex]);
        
        while(hash[lastIndex]!=lastIndex){
            lastIndex=hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        return ans;
    }
	////prob 43 LIC bineary search which will only give max length not complete LIS
	public static int longestIncreasingSubsequence(int arr[]) {
		ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[0]);
        int len=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>temp.get(temp.size()-1)){//if current is greater then last in array then simply add it
                  temp.add(arr[i]);
                  len++;
            }
            else { //else store it in its lower bound currect possition
                int ind=lowerBound(temp,arr[i]);
                temp.set(ind,arr[i]);
            }
        }
        return temp.size();
	}
    
    public static int lowerBound(ArrayList<Integer> a,int t){
        int i=0,j=a.size()-1; 
        int index=-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(a.get(mid)>=t){
                index=mid;
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return index;
    }
	
	//prob 42
	static int longestIncreasingSubsequence(int arr[], int n){
	    int dp[][]=new int[n+1][n+1];
	    for(int ind = n-1; ind>=0; ind --){
	        for (int prev_index = ind-1; prev_index >=-1; prev_index --){
	            int notTake = 0 + dp[ind+1][prev_index +1];
	            int take = 0;
	            if(prev_index == -1 || arr[ind] > arr[prev_index]){
	                take = 1 + dp[ind+1][ind+1];
	            }
	            dp[ind][prev_index+1] = Math.max(notTake,take);
	        }
	    }
	    return dp[0][0];
	}

	static int longestIncreasingSubsequence2(int arr[], int n){
	    int next[]=new int[n+1];
	    int cur[]=new int[n+1];
	    for(int ind = n-1; ind>=0; ind --){
	        for (int prev_index = ind-1; prev_index >=-1; prev_index --){
	            int notTake = 0 + next[prev_index +1];
	            int take = 0;
	            if(prev_index == -1 || arr[ind] > arr[prev_index]){
	                take = 1 + next[ind+1];
	            }
	            cur[prev_index+1] = Math.max(notTake,take);
	        }
	        next = cur.clone();
	    }
	    return cur[0];
	}
	//Printing LIS TC:-O(n2) SC:-O(N)
	static int longestIncreasingSubsequence3(int arr[], int n){
	    
	    int[] dp=new int[n];
	    Arrays.fill(dp,1);
	    int[] hash=new int[n];
	    Arrays.fill(hash,1);
	    
	    for(int i=0; i<=n-1; i++){
	        
	        hash[i] = i; // initializing with current index
	        for(int prev_index = 0; prev_index <=i-1; prev_index ++){
	            
	            if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
	                dp[i] = 1 + dp[prev_index];
	                hash[i] = prev_index;
	            }
	        }
	    }
	    
	    int ans = -1;
	    int lastIndex =-1;
	    
	    for(int i=0; i<=n-1; i++){
	        if(dp[i]> ans){
	            ans = dp[i];
	            lastIndex = i;
	        }
	    }
	    
	    ArrayList<Integer> temp=new ArrayList<>();
	    temp.add(arr[lastIndex]);
	    
	    while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
	        lastIndex = hash[lastIndex];
	        temp.add(arr[lastIndex]);    
	    }
	    
	    // reverse the array 
	    
	    System.out.print("The subsequence elements are ");
	    
	    for(int i=temp.size()-1; i>=0; i--){
	        System.out.print(temp.get(i)+" ");
	    }
	    System.out.println();
	    
	    return ans;
	}
	//prob 41
	static int getAns(int arr[], int n,  int ind, int prev_index,int[][] dp){
	    
	    // base condition
	    if(ind == n)
	        return 0;
	        
	    if(dp[ind][prev_index+1]!=-1)
	        return dp[ind][prev_index+1];
	    
	    int notTake = 0 + getAns(arr,n,ind+1,prev_index,dp);
	    
	    int take = 0;
	    
	    if(prev_index == -1 || arr[ind] > arr[prev_index]){
	        take = 1 + getAns(arr,n,ind+1,ind,dp);
	    }
	    
	    return dp[ind][prev_index+1] = Math.max(notTake,take);
	}
	//Tabulation of LIS
	  public int lengthOfLIS(int[] nums) {
	        int n=nums.length;
	        int dp[][]=new int[n+1][n+1];

	        for(int ind=n-1;ind>=0;ind--){
	            for(int prev=ind-1;prev>=-1;prev--){
	                    int len=dp[ind+1][prev+1];//due to cordinate shift +1 for prev
	                    if(prev==-1 || nums[ind]>nums[prev])//don't do the cordinate shif here !!!
	                        len=Math.max(len,1+dp[ind+1][ind+1]);
	                     dp[ind][prev+1]=len;
	            }
	        }
	        return dp[0][0];
	    }
	//prob 40
	static int getAns(int[] Arr, int ind, int buy, int n, int fee, int[][] dp ){
	    if(ind==n) return 0; //base case
	    if(dp[ind][buy]!=-1)
	        return dp[ind][buy];
	        
	    int profit=0;
	    if(buy==0){// We can buy the stock
	        profit = Math.max(0+getAns(Arr,ind+1,0,n,fee,dp), -Arr[ind] + getAns(Arr,ind+1,1,n,fee,dp));
	    }
	    
	    if(buy==1){// We can sell the stock
	        profit = Math.max(0+getAns(Arr,ind+1,1,n,fee,dp), Arr[ind] -fee + getAns(Arr,ind+1,0,n,fee,dp));
	    }
	    
	    return dp[ind][buy] = profit;
	}

	public static int maximumProfit(int n, int fee, int[] prices) {

		int dp[][] = new int[n + 1][2];
		for (int i = n - 1; i >= 0; i--) {
			for (int buy = 0; buy < 2; buy++) {
				if (buy == 1)
					dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
				else
					dp[i][buy] = Math.max(prices[i] - fee + dp[i + 1][1], dp[i + 1][0]);
			}
		}
		return dp[0][1];
		// return solve(prices,0,1,fee,dp);
	}
	//prob 39 
	 public static int solve2(int []prices,int i,int buy,int [][]dp){
	        if(i>=prices.length)return 0;
	        if(dp[i][buy]!=-1)return dp[i][buy];
	        
	        if(buy==1){
	            return dp[i][buy]=Math.max(-prices[i]+solve2(prices,i+1,0,dp),
	                              solve2(prices,i+1,1,dp));
	        }else {
	            return dp[i][buy]=Math.max(prices[i]+solve2(prices,i+2,1,dp),
	            		solve2(prices,i+1,0,dp));
	        }
	    }
	 public static int stockProfit(int[] prices) {
	        int n=prices.length;
			int dp[][]=new int [n+2][2];
	        
	        for(int i=n-1;i>=0;i--){
	            for(int buy=0;buy<2;buy++){
	                 if(buy==1){
	                     dp[i][buy]=Math.max(-prices[i]+dp[i+1][0],
	                                  dp[i+1][1]);
	        }    else {
	                 dp[i][buy]=Math.max(prices[i]+dp[i+2][1],
	                               dp[i+1][0]);
	                    } 
	          }
	        }
	        return dp[0][1];
		}
	 public static int stockProfit2(int[] prices) {
	        int n=prices.length;
	        int front1[]=new int [2];
	        int front2[]=new int [2];
	        int curr[]=new int[2];
	        for(int i=n-1;i>=0;i--){
	           
	            //inner loop can be removed as one after another both below will execute
	                curr[1]=Math.max(-prices[i]+front1[0],
	                                  front1[1]);
	          
	                 curr[0]=Math.max(prices[i]+front2[1],
	                               front1[0]);
	                    
	          
	            front2=(int[])(front1.clone());;
	            front1=(int[])(curr.clone());;
	        
	        }
	        return curr[1];
		}
	//prob 37/38 also
	public static int solve(ArrayList<Integer> prices, int i, int buy, int cap, int[][][] dp) {
		if (cap == 0)
			return 0;
		if (i == prices.size()) {
			return 0;
		}
		if (dp[i][buy][cap] != -1)
			return dp[i][buy][cap];

		if (buy == 1)
			return dp[i][buy][cap] = Math.max(-prices.get(i) + solve(prices, i + 1, 0, cap, dp),
					solve(prices, i + 1, 1, cap, dp));
		else {
			return dp[i][buy][cap] = Math.max(prices.get(i) + solve(prices, i + 1, 1, cap - 1, dp),
					solve(prices, i + 1, 0, cap, dp));
		}
	}
	
	public static int maxProfit(ArrayList<Integer> prices, int n) {
		int dp[][][]=new int[n+1][2][3];
		//base case can be ignored as those are already zero in array
     
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                  for(int cap=1;cap<3;cap++){
                      if(buy==1)
             dp[i][buy][cap]=Math.max(-prices.get(i)+dp[i+1][0][cap],
                           dp[i+1][1][cap]);
        else {
             dp[i][buy][cap]=Math.max(prices.get(i)+dp[i+1][1][cap-1],
                           dp[i+1][0][cap]);
                }
            }
        }
        }
        return dp[0][1][2];
          
	}
	
	//Alternate solution 
	 public int maxProfit(int k, int[] prices) {
	        int n=prices.length;
	       //return solve(prices,0,0,k); 
	        int dp[][]=new int[n+1][2*k+1];
	        for(int i=n-1;i>=0;i--){
	            for(int transNum=2*k-1;transNum>=0;transNum--){
	                if(transNum%2==0)
	                    dp[i][transNum]=Math.max(-prices[i]+dp[i+1][transNum+1],
	                                   dp[i+1][transNum]);
	                else  dp[i][transNum]=Math.max(prices[i]+dp[i+1][transNum+1],
	                                    dp[i+1][transNum]);
	          }
	        }
	        return dp[0][0];
	    }
	//prob 36 
	 public int fn(int index,int buy,int[] p,int[][] dp){
	        if(index==p.length){
	            return 0;
	        }
	        if(dp[index][buy]!=-1) return dp[index][buy];
	        int profit=0;
	        if(buy==1){
	            profit=Math.max((-p[index]+fn(index+1,0,p,dp)),(0+fn(index+1,1,p,dp))); //buy case
	        }
	        //sell case
	        else{
	            profit=Math.max((p[index]+fn(index+1,1,p,dp)),(0+fn(index+1,0,p,dp)));
	        }
	        return dp[index][buy]=profit;
	    }
	    
	    
	//Tabulation
	public int maxProfit2(int[] p) {
	    int[][] dp=new int[p.length+1][2];
	    dp[p.length][0]=0;
	    dp[p.length][1]=0;

	    for(int index=p.length-1;index>=0;index--){
	        for(int buy=0;buy<=1;buy++){//sell and buy cases in this loop 
	        int profit=0;
	         if(buy==1){
	            profit=Math.max((-p[index]+dp[index+1][0]),dp[index+1][1]); //buy case
	         }
	        //sell case
	         else{
	            profit=Math.max((p[index]+dp[index+1][1]),dp[index+1][0]);
	         }
	             dp[index][buy]=profit;
	     }
	 
	   }
	      return dp[0][1];
	  }
	    
	//prob 35
public static boolean wildcardMatching2(String p, String s) {
		
        int n=s.length();
        int m=p.length();
        boolean dp[][]=new boolean [n+1][m+1];
        dp[0][0]=true;
        
        for(int i=1;i<n+1;i++){
                dp[i][0]=false;
        }
        for(int j=1;j<m+1;j++){
            boolean flag=true;
              for(int k=1;k<=j;k++){
                  if(p.charAt(k-1)!='*'){
                    flag=false;
                    break;
                } 
              }
            dp[0][j]=flag;
        }  
        
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                 char charS = s.charAt(i - 1);
                    char charP = p.charAt(j - 1);
                    if(charS==charP || charP=='?')
                        dp[i][j]=dp[i-1][j-1];
                    else if(charP=='*'){
                        dp[i][j]=dp[i-1][j] || dp[i][j-1];
                    }
            }
        }
        return dp[n][m];
        
	}
	 static boolean isAllStars(String S1, int i) {
		    for (int j = 0; j <= i; j++) {
		      if (S1.charAt(j) != '*')
		        return false;
		    }
		    return true;
		  }

		  static int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {

		    //Base Conditions
		    if (i < 0 && j < 0)
		      return 1;
		    if (i < 0 && j >= 0)
		      return 0;
		    if (j < 0 && i >= 0)
		      return isAllStars(S1, i) ? 1 : 0;

		    if (dp[i][j] != -1) return dp[i][j];

		    if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
		      return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

		    else {
		      if (S1.charAt(i) == '*')
		        return (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1 || wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
		      else return 0;
		    }
		  }

		  static int wildcardMatching(String S1, String S2) {

		    int n = S1.length();
		    int m = S2.length();

		    int dp[][] = new int[n][m];
		    for (int row[]: dp)
		      Arrays.fill(row, -1);
		    return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);

		  }
	//prob 34
	  public static int editDistance(String s1, String s2) {
	        int n=s1.length();
	        int m=s2.length();
	        int prev[]=new int[m+1];
	        int curr[]=new int[m+1];

	        for(int j=0;j<m+1;j++)
	            prev[j]=j;
	        
	        for(int i=1;i<n+1;i++){
	            curr[0]=i;
	            for(int j=1;j<m+1;j++){
	                if(s1.charAt(i-1)==s2.charAt(j-1))
	                   curr[j]=prev[j-1];
	                else curr[j]=Math.min(Math.min(prev[j],curr[j-1]),
	                                     prev[j-1])+1;
	            }
	             prev = (int[])(curr.clone());
	        }
	        return prev[m];
	    }
	  public static int solve4(String s,String t,int n,int m,int [][]dp){
	        if(m==0)return n;//no of char remaining in s 
	        if(n==0)return m;//Similarly no of char remaining in t 
	        if(dp[n][m]!=-1)return dp[n][m];
	        if(s.charAt(n-1)==t.charAt(m-1))
	            return dp[n][m]=solve4(s,t,n-1,m-1,dp);
	        else return dp[n][m]=Math.min(Math.min(solve4(s,t,n-1,m,dp),solve4(s,t,n,m-1,dp)),
	                            solve(s,t,n-1,m-1,dp))+1;
	    }
	//prob 26 Print LCS SKIP 26 to 33
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

		    return dp[0][0][m - 1];//0th row alice starts from 0 and bob witn m-1
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
	    
//	    public static int getMaxPathSum(int[][] matrix) {
//	        int n=matrix.length;
//	        int m=matrix[0].length;
//			int max=Integer.MIN_VALUE;
//	        int dp[][]=new int[n][m];
//	        for(int d[]:dp)
//	            Arrays.fill(d,-1);
//	        for(int i=0;i<m;i++){
//	            max=Math.max(max,solve2(matrix,n-1,i,dp));
//	        }
//	        return max;
//		}
//	    public static int solve2(int [][]a,int i,int j,int dp[][]){
//	        if(j<0 || j>=a[0].length)return (int)Math.pow(-10,9);;
//	        if(i==0)return a[0][j];
//	        if(dp[i][j]!=-1)return dp[i][j];
//	        int topLeft=solve2(a,i-1,j-1,dp)+a[i][j];
//	        int top=solve2(a,i-1,j,dp)+a[i][j];
//	        int topRight=solve2(a,i-1,j+1,dp)+a[i][j];
//	        return dp[i][j]=Math.max(topLeft,Math.max(top,topRight));
//	    }
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
//	   public static int minimumPathSum(int[][] triangle, int n) {
//	       int m=triangle[n-1].length;
//	       int dp[][]=new int [n][m];
//	        for(int i=n-1;i>=0;i--){
//	            for(int j=triangle[i].length-1;j>=0;j--){
//	                if(i==n-1){
//	                    dp[i][j]=triangle[i][j];
//	                }else {
//	                      int down=triangle[i][j]+dp[i+1][j];
//	                      int dia=triangle[i][j]+dp[i+1][j+1];
//	                      dp[i][j]=Math.min(down,dia);
//	                }
//	            }
//	        }
//	        return dp[0][0];
//	    }
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
	
//	 static int paths(int i, int j, ArrayList<ArrayList<Integer>> mat, int n, int m) {
//	        // Base case of first cell.
//	        if (i == 0 && j == 0) {
//	            return 1;
//	        }
//	        // If the cell is onvalid return 0.
//	        if (i < 0 || j < 0 || j >= m || i >= n || mat.get(i).get(j) == -1) {
//	            return 0;
//	        }
//	        int mod = 1000000007;
//	        // Recursively call the function for previous cells.
//	        return (paths(i - 1, j, mat, n, m) + paths(i, j - 1, mat, n, m)) % mod;
//	    }
	
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
	        //OR THIS BELOW ONE WHERE WE TAKE CARE OF BC IN LOOP IT SELF
//	        for(int i=0;i<m;i++){
//	            for(int j=0;j<n;j++){
//	                if(i==0 && j==0) dp[i][j]=1;
//	                else {
//	                    int val1=i-1>=0?dp[i-1][j]:0;
//	                     int val2=j-1>=0?dp[i][j-1]:0;
//	                     dp[i][j]=val1+val2;
//	                 }
//	                 
//	            }
//	        } 
//	        return dp[m-1][n-1];
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
	  //This version is for when BC is idx<0 then return 0; so idx/day loop runs from 0 to n-1
	  public static int ninjaTraining(int n, int points[][]) {
	      int dp[][]=new int[n][4];

	        for(int idx=0;idx<n;idx++){
	            for(int last=0;last<=3;last++){
	                    int max=0;
	                    for(int i=0;i<3;i++){
	                        if(last!=i){
	                                int point=points[idx][i]+(idx-1>=0?dp[idx-1][i]:0);
	                                max=Math.max(max,point);

	                        }
	                    }
	                     dp[idx][last]=max;
	            }
	        }
	        return dp[n-1][3];
	   
	    }
	  public static int ninjaTrainingSpaceOPT(int n, int points[][]) {
	        int prev[]=new int[4];
	        for(int idx=0;idx<n;idx++){
	            int temp[]=new int[4];
	            for(int last=0;last<=3;last++){
	                    for(int i=0;i<3;i++){
	                        if(last!=i){
	                                int point=points[idx][i]+(idx-1>=0?prev[i]:0);
	                                temp[last]=Math.max(temp[last],point);
	                        }
	                    }
	            }
	            prev=temp;
	        }
	        return prev[3];
	    }
//	Call from main :-=  for(int i=0;i<m;i++){
//          max=Math.max(max,solve(matrix,n-1,i,dp));
//      }
	  public static int solve2(int [][]a,int i,int j,int dp[][]){
	        if(j<0 || j>=a[0].length)return (int)Math.pow(-10,9);;
	        if(i==0)return a[0][j];
	        if(dp[i][j]!=-1)return dp[i][j];
	        int topLeft=solve2(a,i-1,j-1,dp)+a[i][j];
	        int top=solve2(a,i-1,j,dp)+a[i][j];
	        int topRight=solve2(a,i-1,j+1,dp)+a[i][j];
	        return dp[i][j]=Math.max(topLeft,Math.max(top,topRight));
	    }
	  public static int getMaxPathSum(int[][] matrix) {
			int n=matrix.length;
			int m=matrix[0].length;
			int prev[]=new int[m+1];

			for(int i=0;i<m;i++){
				prev[i]=matrix[0][i];
			}

				int max=Integer.MIN_VALUE;
				for(int r=1;r<n;r++){
					int curr[]=new int[m+1];
					for(int c=0;c<m;c++){
						int down=prev[c];
						int left=c-1>=0?prev[c-1]:Integer.MIN_VALUE;
						int right=c+1<m?prev[c+1]:Integer.MIN_VALUE;
						curr[c]=Math.max(Math.max(down,right),left)+matrix[r][c];
					}
					prev=curr;
				}
				for(int i=0;i<m;i++){
			 		max=Math.max(max,prev[i]);
				}
				
			return max;	
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
	
	 public static int solve(ArrayList<Integer> nums,int i,int dp[]){
	        if(i<0)return 0;
	        if(dp[i]!=-1)return dp[i];
	        int pick=nums.get(i)+solve(nums,i-2,dp);
	        int nonPick=solve(nums,i-1,dp);
	        return dp[i]=Math.max(pick,nonPick);
	    }
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n=nums.size();
        int dp[]=new int[n+1];
        dp[0]=nums.get(0);
        for(int i=1;i<n;i++){
            int   pick=nums.get(i)+((i>1)?dp[i-2]:0);
            int nonPick=dp[i-1];
            dp[i]=Math.max(pick,nonPick);
        }
        return dp[n-1];
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
