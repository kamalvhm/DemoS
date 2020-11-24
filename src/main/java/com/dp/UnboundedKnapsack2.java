package com.dp;
/**https://www.youtube.com/watch?v=aycn9KO8_Ls&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=13
 * 	Related problems | Leetcode 
 * 1)Rod Cutting Problem (#SAME CODE AS UNBOUNDED KNAPSACK#)  |
 * 2)coin change (Max no. of ways)| (518. Coin Change 2) https://leetcode.com/problems/coin-change-2/
 * 3)coin change 2 (Min No of coins)|  (322. Coin Change) https://leetcode.com/problems/coin-change/submissions/
 * 4)Maximum Ribbon cut |
 */
public class UnboundedKnapsack2 {
	//If selected then multiple Occurences are allowed of same item and if not selected
	//then its processed then we can't select again 
	public static void main(String args[]) {
		//Rod Cutting Problem :- cut rod such that price is maximum  
		int [] length= {1,2,3,4,5,6,7,8}; //some time legth[] array not given so loop from 1 to n to create 
		int [] price= {1,5,8,9,10,17,17,20};
		int n=8;
		//Running same code as its same where length[] ==wt[] and price == val[] and n==w;
		System.out.println("1)Rod Cutting :-"+unboundedKnapsack(length,price,n,length.length));
		
		int [] coin= {1,2,3};
		//returns total No of ways a given sum can be formed by these coins
		System.out.println("2)coin change I :-"+coinChangeI(coin,5,coin.length));
		//Return Min no of coin to create given sum
		System.out.println("3)coin change II :-"+coinChangeII(coin,5,coin.length));

	}

	public static int unboundedKnapsack(int [] wt,int [] val,int w,int n) {
		int[][] top=new int [n+1][w+1];
		//Initialization 
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<w+1;j++) {
				if(i==0 || j==0)
					top[i][j]=0;
			}
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				if(wt[i-1]<=j) {
					//Only change from 0/1 Knapsack is top[i] instead of top[i-1] because we can select multiple of same item 
					top[i][j]=Math.max(val[i-1]+top[i][j-wt[i-1]], 
							top[i-1][j]);
				}else {
					top[i][j]=top[i-1][j];
				}
			}
		}
		return top[n][w];
		
	} 
	
	public static int coinChangeI(int[] coin,int sum ,int n) {
		int t[][]=new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {     
				if(i==0)
					t[i][j]=0;
				if(j==0)
					t[i][j]=1;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(coin[i-1]<=j) {  //in question if max/count is asked then add all choices so +
					t[i][j]=t[i-1][j]+t[i][j-coin[i-1]];
				}else
					t[i][j]=t[i-1][j];
			}
		}
		return t[n][sum];
	}
	//return min no of coins to form :-https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
	private static int coinChangeII(int[] coin, int sum, int n) {
		int t[][] =new int [n+1][sum+1];
		//check notes for initailization details 
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(j==0) //where sum is 0 so no coin needed
					t[i][j]=0;
				if(i==0) //where coin is null and sum is given setting MAX-1
					t[i][j]=Integer.MAX_VALUE-1; // -1 is Because we are adding 1 later in code so to avoid overflow for boundry
			}
		}
		
		//To fill/Initailize secound row 
		for(int j=1;j<sum+1;j++) {
			if(j%coin[0]==0) //if we can create sum from first coin for example we can't create sum=4 from coin value 3 even if we choose multiple 
				t[1][j]=j/coin[0]; 
			else t[1][j]=Integer.MAX_VALUE-1;
		}
		//starting i from two as for 1 we already filled above
		for(int i=2;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(coin[i-1]<=j) {
					//Adding 1 in case of selection to count coins
					t[i][j]=Math.min(1+t[i][j-coin[i-1]], t[i-1][j]);
				}else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		
		return t[n][sum];
	}
	
	//Variation without secound row initailization
	  public int coinChangeII(int[] coin, int sum) {  
	        int n=coin.length;
	        int t[][] =new int[n+1][sum+1];
	        
	        for(int i=0;i<n+1;i++)  //where sum is 0 so no coin needed
	            t[i][0]=0;
	        for(int j=0;j<sum+1;j++)  //where coin is null and sum is given setting MAX-1
	            t[0][j]=Integer.MAX_VALUE-1;
	        
	        for(int i=1;i<n+1;i++){
	            for(int j=1;j<sum+1;j++){
	                if(coin[i-1]<=j){
	                    t[i][j]=Math.min(t[i-1][j],1+t[i][j-coin[i-1]]); //Adding 1 in case of selection to count coins
	                }else 
	                    t[i][j]=t[i-1][j];
	            }
	        }
	        
	     return t[n][sum]!=Integer.MAX_VALUE-1 ? t[n][sum]:-1; 

	    }

}
