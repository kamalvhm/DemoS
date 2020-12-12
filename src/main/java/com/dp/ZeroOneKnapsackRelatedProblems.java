package com.dp;

import java.util.Arrays;

/**Related Problems | leetcode similiar problems
 * 1)subset sum  
 * 2)equal sum partition | 416. Partition Equal Subset Sum (https://leetcode.com/problems/partition-equal-subset-sum/)
 * 3)count of subset sum |
 * 4)Minimum subset sum difference |
 * 5)Target sum | 494. Target Sum (https://leetcode.com/problems/target-sum/)
 * 6) No of subset for given d/f |
 * 
 */
//https://www.youtube.com/watch?v=iBnWHZmlIyY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6
public class ZeroOneKnapsackRelatedProblems {
	
	
	public static void main(String[] args) {
		int [] arr= {2,3,7,8,10};
		//return true if given sum can be formed by subset
		System.out.println("1)subset sum  ANS:- "+subsetSum(arr,11,arr.length));
		
		int [] arr2= {1,5,11,5};
		//return true if two equal sum subset is there 
		System.out.println("2)equal sum partition  ANS:- "+equalSum(arr2,arr2.length));
		
		int [] arr3= {2,3,5,6,8,10};
		//return count of subset which having same sum Ans will be 3
		System.out.println("3)count of subset sum  ANS:- "+countSubsetSum(arr3,10,arr3.length));
		
		int [] arr4= {1,2,7};
		//return min diffrence of two subsets from given array will give 4 {1,2} sum is 3 and {7} sum is 7 (7-3=4)
		System.out.println("4)Minimum subset sum difference  ANS:- "+minimumSubsetSumDiff(arr4,arr4.length));
		

		int [] arr5= {1,1,2,3};
		//return count of subset which is having given diffrence when sum is subtracted (check V-11 in notes) ANS :-3
		System.out.println("6)No of subset for given d/f  ANS:- "+noOfSubsetforGivenDiff(arr5,1,arr5.length));
		//This problem is SAME as 6)No of subset for given d/f diffrently so same method call
		int [] arr6= {1,1,2,3};
		//return count of subset which is having given diffrence when adding +ve and -ve signs to each value
		System.out.println("5)Target sum  ANS:- "+noOfSubsetforGivenDiff(arr6,1,arr6.length));

	}
	
	
	
	// * 1)subset sum   SIMILIER WITH KNAPSACK
	public static boolean subsetSum(int[] arr , int sum, int n) {
		boolean top[][] =new boolean[n+1][sum+1];
		//Wt array will change to arr and VAL array is not given ,w is changed to sum  
		//This initalisation will change check notebook diagram 
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0) // if array is given of size 0
					top[i][j]=false;
				if(j==0) //if sum is given zero
					top[i][j]=true;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					//Val array is not given so ignored and MAx makes no sense in boolean so changed to OR
					top[i][j]=top[i-1][j-arr[i-1]] || top[i-1][j];
				}else top[i][j]=top[i-1][j];
			}
		}
		return top[n][sum];
	}
	
	
	// * 2)equal sum partition | for DP approach :-https://www.youtube.com/watch?v=3N47yKRDed0
	public static boolean equalSum(int[] arr , int n) {
		int sum=0;
		for(int a:arr)
			sum+=a;
		if(sum%2!=0)return false; // if odd we can't devide in equal partitions
		else return subsetSum(arr,sum/2,arr.length);  //if even then we can partition (So extract one partition which contains sum/2) because other will always be there
	}
	//https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
	//* V-9 3)count of subset sum SIMILIER WITH  subsetSum();
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
	
	//https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
	//we need to subset s1 s2 whose diffrence should be min so we can sa these subset will be in range 0 to totalsum ,then we are calling 
	//subset sum on array 
	public static int minimumSubsetSumDiff(int[] arr , int n) {
		int range=0;
		for(int a:arr)
			range+=a;
		//last row in this matrix will represent 0 to range some so we can run loop to half way
		boolean t[][]=subsetSumToReturnTable(arr,range,arr.length);
		int minimum=Integer.MAX_VALUE;
		//to access only last row [arr.length-1] 
		for(int i=0;i<range/2;i++) { // running loop only to half way because we are keeping s1 is smaller then half 
			if(t[arr.length-1][i])//if the some can be formed (True) of last row
			minimum=Math.min(minimum, (range-2*i));  //we are finding s2-s1 minimum to be safe we are keeping s1 smaller then half in range 
			//so we can say 's2 =range-s1',so we need minimum of 'range -s1-s1' which is equal to 'range-2*s1'
		}
		return minimum;
	}
	//same as above but return whole table
	public static boolean[][] subsetSumToReturnTable(int[] arr,int sum,int n){
		boolean t[][] =new boolean[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<sum+1;j++) {
				if(i==0)
					t[i][j]=false;
				if(j==0)
					t[i][j]=true;
			}
		}
		
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(arr[i-1]<=j) {
					t[i][j]=t[i-1][j] || t[i-1][j-arr[i-1]];
				}else t[i][j]=t[i-1][j];
			}
		}
	return t;
	}
	
	public static int noOfSubsetforGivenDiff(int[] arr ,int diff, int n) {
		int arrSum=0;
		for(int a:arr)
			arrSum+=a;
		
		//Formula from note book sum(s1)=(diff+sum(arr))/2;
		int sumOfs1=(diff+arrSum)/2;
		//Now call countSubsetSum
		return countSubsetSum(arr,sumOfs1,arr.length);
	}
	
	
}
