package com.dp;

public class DPractice2 {
	/**RELATED Preblems LCS | https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
	 * 1)Longest common subString
	 * 2)print  LCS
	 * 3)Shortest common super sequence
	 * 4)print SCS
	 * 5)Min # insertion and deletion a->b
	 * 6)Longest repeating subSequence
	 * 7)Length of longest subsequence of a which is substring in b
	 * 8)subsequence pattern Matching
	 * 9)count how many times a appear as subsequence in b
	 * 10)Longest palindromic sub sequence
	 * 11)Longest palindromic substring
	 * 12)count of palindromic substring
	 * 13)Min no of deletion in a string to make it palindromic 
	 * 14)Min no of insertion in a string to make it palindromic
	 */
	public static void main(String[] args) {
		String x="abcdgh",y="abedfhr"; //common in both is abdh so 4 is ans
		System.out.println("LCS Length ANS:-"+LCS(x,y,x.length(),y.length())); 
		
		
		//We are given a array which contains a matrix dimension we have to return minimum cost(multiplication) of these matrix 
		//for example if we have A1,A2,A3,A4 one we can (A1*A2)*(A3*A4) like that we have other option out of which minimum cost 
		//we have to return [to multiple any matrix of a*b and c*d we must have b==c]
		//Dimension Ai=arr[i-1]*arr[i]; 
		int arr[] = {40,20,30,10,30}; //These are dimensions of 4 matrix (size-1) for example for a1 matrix dimension will be 40*20
		
		//Step 1 find i& j :select i and j (usually i at left end and j at right ) so we can select i at 0 position because then dimension will require -1
		//so i is 1 and j =size-1;
		System.out.println("1)MCM ans "+solveMCM_BottomUp(arr,1,arr.length-1));
	}

	//THIRD STEP
	public static int LCS(String x, String y, int n, int m) {
		int t[][] = new int[n + 1][m + 1];
		
		StringBuffer sb=new StringBuffer();

	
		
	
		System.out.println(sb.toString());
		return t[n][m];
	}
	
	
	//https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34
	public static int solveMCM(int arr[],int i,int j) {
		return -1;
	}
	
	public static int solveMCM_BottomUp(int arr[],int i,int j) {
		return -1;
	}

}
