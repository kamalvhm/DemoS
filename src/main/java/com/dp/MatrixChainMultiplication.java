package com.dp;

import java.util.Arrays;

import com.cleanup.Utils;

import scala.Array;

/** ##{@link #MatrixChainMultiplication()}
 * 1)MCM
 * 2)Printing MCM
 * 3)Evaluate Exp to true / boolean Pranter
 * 4)Min/Max value of an Expr.
 * 5)Palindrom Partitioning
 * 6)Scramble String
 * 7)Egg Dropping Problem
 * ---------------------------GENERAL FORMAT CODE------------------
 * 	int solveMCM(int[] arr, int i, int j) {
		if (i > j)return 0;
		int finalAns;
		for (int k = i; k < j; k++) {
			// calculate Temp ans
			int tempAns = solveMCM(arr, i, k) + solveMCM(arr, k + 1, j);
			finalAns = fun(tempAns);// Apply some fun on temp and compute (Min/MAx)
		}
		return finalAns;
	}
	###########GENERQAL STEPS#############
 * STEPs 1) find where to place i and j (generally i at left end and j at right)
 * 2)find Base Condi.
 * 3)find where K loop will move (To find it place k at smallest and largest pos and check if partions are valid)
 * 4)find final ANS from temporary
 *
 */

public class MatrixChainMultiplication {
	static int dp[][]=new int [10][10];//size depends on max constraints 
	static {for(int []t:dp)
			Arrays.fill(t, -1);}

	public static void main(String[] args) {
			//We are given a array which contains a matrix dimension we have to return minimum cost(multiplication) of these matrix 
			//for example if we have A1,A2,A3,A4 one we can (A1*A2)*(A3*A4) like that we have other option out of which minimum cost 
			//we have to return [to multiple any matrix of a*b and c*d we must have b==c]
			//Dimension Ai=arr[i-1]*arr[i]; 
			int arr[] = {40,20,30,10,30}; //These are dimensions of 4 matrix (size-1) for example for a1 matrix dimension will be 40*20
			
			//Step 1 find i& j :select i and j (usually i at left end and j at right ) so we can select i at 0 position because then dimension will require -1
			//so i is 1 and j =size-1;
			System.out.println("1)MCM ans "+solveMCM_BottomUp(arr,1,arr.length-1));
			
			String s="nitin"; //PS:-we are given a string we need to partition it such that all resultant Strings are palindrom and minimize no. of partion
			System.out.println("5)Palindrom Partitioning ans:- "+palindrom_partitioning_recursive(s,0,arr.length-1)); //in this case we can place i at 0 because no dimetios are here 


			
	}

	//https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34
	public static int solveMCM(int arr[],int i,int j) {
		if(i>=j)return 0; // STEP 2 (find Base cond):as we need min 2 element in array to find dimension
		int min=Integer.MAX_VALUE;
		//Step 3:-Move k from i to j :-first decide from and upto k will move by breaking matrixs on k samllest and larget value
		//after analysis k will move from i to j-1 it will not move upto k=j because in that case we will (K+1 to j) as empty and whole array 
		//will be in (i to k) 
		//Note :- To select k movement for smallest and largest value of k extract dimension with Ai=arr[i-1]*arr[i];  and check if valid 
		for(int k=i;k<=j-1;k++) {
			//check notes for this formula 
			int tempAns=solveMCM(arr,i,k)+solveMCM(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			
			//Step 4:-calculate ans from temporary ans;
			if(tempAns<min)
				min=tempAns;
		}
		return min;
	}
	
	public static int solveMCM_BottomUp(int arr[],int i,int j) {
		if(i>=j)return 0; 
		if(dp[i][j]!=-1)return dp[i][j]; //CHANGE ONE 
		
		int min=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int tempAns=solveMCM_BottomUp(arr,i,k)+solveMCM_BottomUp(arr,k+1,j)+arr[i-1]*arr[k]*arr[j];
			
			//Step 4:-calculate ans from temporary ans;
			if(tempAns<min)
				min=tempAns;
		}
		//CHANGE TWO
		return dp[i][j]=min;
	}

	private static int palindrom_partitioning_recursive(String s, int i, int j) {
		if(i>=j)return 0; //if single char then no partion needed
		if(Utils.isPalindrom(s))return 0; //if already palindrom then also no partion needed
		int ans=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			int temp=palindrom_partitioning_recursive(s,i,k)+palindrom_partitioning_recursive(s, k+1, j)+1;//solve(i to k) and solve(k+1,j) both will give min partions and as wedone already one so +1
			
			ans=Math.min(ans, temp);
		}
		return ans;
	}

}
