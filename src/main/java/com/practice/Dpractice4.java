package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.cleanup.Utils;

import scala.Array;
import com.dp.BooleanParenthesization;
import com.dp.DpOnTrees4.In;
import com.dp.DynamicPrograming;

/** ##{@link #com.dp.MatrixChainMultiplication()}
 * 1)MCM ##{@link #solveMCM()}
 * 2)Printing MCM 
 * 3)Evaluate Expression to true / boolean parenthesization
 * 4)Min/Max value of an Expr.
 * 5)Palindrom Partitioning |132. Palindrome Partitioning II, https://leetcode.com/problems/palindrome-partitioning-ii/
 * 6)Scramble String | 87. Scramble String https://leetcode.com/problems/scramble-string/
 * 7)Egg Dropping Problem |887. Super Egg Drop https://leetcode.com/problems/super-egg-drop/
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
	###########ANS#############
1)MCM ans 26000
5)Palindrom Partitioning ans:- 4
3)Evaluate Expression to true ans:- 2
6)Scramble String ans:- true
7)Egg Dropping Problem ans:- 3
 *
 */

public class Dpractice4 extends DynamicPrograming{
	static int dp[][]=new int [100][100];//size depends on max constraints 
	static int p[][]=new int [100][100];
	static int egg[][]=new int [100][100];

	static {for(int []t:dp)
			Arrays.fill(t, -1);
			for(int []t:p)
				Arrays.fill(t, -1);
			for(int []t:egg)
				Arrays.fill(t, -1);}
	
	static Map<String,Integer> map=new HashMap<>(); 
    private static final String EMPTY_STRING = "";
    
	static Map<String,Boolean> scramblemap=new HashMap<>(); 


	public static void main(String[] args) {
			//We are given a array which contains a matrix dimension we have to return minimum cost(multiplication) of these matrix 
			//for example if we have A1,A2,A3,A4 one we can (A1*A2)*(A3*A4) like that we have other option out of which minimum cost 
			//we have to return [to multiple any matrix of a*b and c*d we must have b==c]
			//Dimension Ai=arr[i-1]*arr[i]; 
			int arr[] = {40,20,30,10,30}; //These are dimensions of 4 matrix (size-1) for example for a1 matrix dimension will be 40*20
			
			//Step 1 find i& j :select i and j (usually i at left end and j at right ) so we can select i at 0 position because then dimension will require -1
			//so i is 1 and j =size-1;
			System.out.println("1)MCM ans (26000) "+solveMCM_BottomUp(arr,1,arr.length-1));
			
			String s="coder"; //PS:-we are given a string we need to partition it such that all resultant Strings are palindrom and minimize no. of partion
			System.out.println("5)Palindrom Partitioning ans (4):- "+palindrom_partitioning_recursive(s,0,s.length()-1)); //in this case we can place i at 0 because no dimetios are here 
			String s1="T^F&T";
			//PS:-Input String given Output -No. of ways it eval to true, add bracket to string such that it evaluate to true  eg: ((T^F)&T) 
			//String may consist of T=True ,F=False, | =Or, & =And ,^=XOR
			System.out.println("3)Evaluate Expression to true ans (2):- "+evalExTRecursive(s1,0,s1.length()-1,true)); 
			String a="great",b="rgeat"; //two String given you can create binary tree and swap non leaf nodes child if by doing this its equal to secound string it return true else false
			System.out.println("6)Scramble String (true) ans:- "+scrambledStringRecursie(a,b)); 
			int eggs=3,floor=5; //IP:-Eggs and floor given we need to identify threshold floor from which if we throw egg it will not break 
			//we have to apply best technique in worst case to minimize no of attempts to find threshold floor
			System.out.println("7)Egg Dropping Problem (3) ans:- "+eggDropRecursive(eggs,floor)); 
			
			  int mat[][] =
			        {
			            { 0, 0, 1, 0, 1, 1 },
			            { 0, 1, 1, 1, 0, 0 },
			            { 0, 0, 1, 1, 1, 1 },
			            { 1, 1, 0, 1, 1, 1 },
			            { 1, 1, 1, 1, 1, 1 },
			            { 1, 1, 0, 1, 1, 1 },
			            { 1, 0, 1, 1, 1, 1 },
			            { 1, 1, 1, 0, 1, 1 }
			        };
			 
			        System.out.print("The size of largest square submatrix of 1's is (3) " +
			                findLargestSquare(mat));

	}

	
	
	



	public static int solveMCM_BottomUp(int arr[],int i,int j) {
		return 0;
		
	}

	private static int palindrom_partitioning_recursive(String s, int i, int j) {
;
		int min=Integer.MAX_VALUE;
		
		return min;
	}

	private static boolean isPalindrom(String s, int i, int j) {
		while(i<j) {
			if(s.charAt(i++)!=s.charAt(j--))return false;
		}
		return true;
	}

	//V-37
	private static int palindrom_partitioningBottomUp(String s, int i, int j) {
		
		return dp[i][j];
	}
	//CHECK PROBLEM SOLUTION IN PARENT CLASS
	//V-38 To optimize further we can check "palindrom_partitioningBottomUp(s,i,k)+palindrom_partitioningBottomUp(s, k+1, j);" function in the matrix 
	private static int palindrom_partitioningBottomUpOptimized(String s, int i, int j) {
		return -1;
	}
	/**V-39 (CHECK ##BooleanParenthesization()) :-https://www.youtube.com/watch?v=pGVguAcWX4g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=39
	 * 
	 */
	public static int evalExTRecursive(String s ,int i,int j,boolean isTrue) {
		return 0;
		
	} 
	
	
	public static boolean scrambledStringRecursie(String a ,String b) {
		if(a.length()!=b.length())return false;
		if(a.isEmpty() && b.isEmpty())return true;
		return scrambledSolve(a,b);
	} 
	
	public static boolean scrambledSolve(String a ,String b) {
		return true;
		
	} 
	
	 public static boolean scrambledMemoized(String a, String b) {
	       
	        return false;
	    }
	 
	 
		private static int eggDropRecursive(int e, int f) {
			
			int min=Integer.MAX_VALUE;
			
			return min;
		}
		
		private static int eggDropMemoized(int e, int f) {
			
			
			int min=Integer.MAX_VALUE;
			
		
			return min;
		}
		

		private static int findLargestSquare(int[][] matrix) {
		    int h =matrix.length;
	        int w =matrix[0].length;
	        int t[][]=new int[h][w];
	        int max=0;
	        
	        for(int i=0;i<h;i++) {
	        	for(int j=0;j<w;j++) {
	        		if(matrix[i][j]==1) {
	        			t[i][j]=1;
	        			if(i>0 && j>0) {
	        				t[i][j]=Math.min(Math.min(t[i-1][j-1], t[i-1][j]), t[i][j-1])+1;
	        			}
	        			max=Math.max(max, t[i][j]);
	        		}
	        	}
	        }

			return max;
		}
}
