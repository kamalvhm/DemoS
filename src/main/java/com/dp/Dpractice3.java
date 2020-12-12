package com.dp;

import java.util.Arrays;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

/**RELATED Preblems LCS | https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
 * 1)Longest common subString [v-22] |
 * 2)print  LCS [v-23]|
 * 3)Shortest common superSequence [v-24]
 * 4)print SCS [v-29] | 1092. https://leetcode.com/problems/shortest-common-supersequence/
 * 5)Min # insertion and deletion a->b
 * 6)Longest repeating subSequence
 * 7)Length of longest subsequence of a which is substring in b
 * 8)subsequence pattern Matching
 * 9)count how many times a appear as subsequence in b
 * 10)Longest palindromic sub sequence [v-26] |516. Longest Palindromic Subsequence https://leetcode.com/problems/longest-palindromic-subsequence/
 * 11)Longest palindromic substring
 * 12)count of palindromic substring
 * 13)Min no of deletion in a string to make it palindromic 
 * 14)Min no of insertion in a string to make it palindromic
 */

public class Dpractice3 {
	static int dp[][]=new int[20][20];//m+1 n+1
	static {
		for(int[] a:dp)
			Arrays.fill(a, -1);
	}
	
	public static void main(String[] args) {
		String x="abcdgh",y="abedfhr"; //common in both is abdh so 4 is ans
		System.out.println("LCS Length ANS:-"+LCS_BottomUp_Memoized(x,y,x.length(),y.length())); //1143. Longest Common Subsequence
		String a="abcde",b="abfce";  //ANS 2 longest countinues common string is 'ab' so 2
		System.out.println("1) Longest common subString ANS:-"+LongestCommonSubString(a,b,a.length(),b.length()));
		System.out.println("2)print  LCS ANS :-"+printLCS_String(x,y,x.length(),y.length())); //ANS abdh
		String a1="AGGTAB" ,b1="GXTXAVB"; //Merged Sortest will be AGGXTXAYB to find length = (length of a1 + length of b1) - LCS of both strings (ANS :-(6+7)-4=9)
		System.out.println("3)Shortest common super sequence ANS :-"+((a1.length()+b1.length())-LCS_TopDown(a1, b1, a1.length(), b1.length()))); //return length of shortest string which contains both string sequence 
		System.out.println("4)print SCS ANS :-"+shortestCommonSupersequence("abac","cab")); //return  shortest string which contains both string sequence  ANS :-"cabac"
		String a2="heap",b2="pea";
		int lcs=LCS_TopDown(a2,b2,a2.length(),b2.length());
		System.out.println("5) Min # insertion and deletion a->b ANS Deletion:-"+(a2.length()-lcs)+" Insertion "+(b2.length()-lcs)); //return min insertion and deletion to form String a to b  ANS :-"cabac"
		String s="agbcba";
		StringBuffer sb=new StringBuffer(s); //We are using b string as reverse of a to find palindromic string {In ip only one string given}
		System.out.println("10)Longest palindromic sub sequence ANS:-"+LCS_TopDown(s,sb.reverse().toString(),s.length(),s.length())); //return longest palindromic subsequnce length 
		// No of deletion will be 1 of g  that will make abcba 
		String s1="agbcba";
		StringBuffer sb1=new StringBuffer(s);
		int lps=LCS_TopDown(s1,sb1.reverse().toString(),s1.length(),sb1.length()); //No of deletion is inversely  proportion to LPS so computing LPS
		System.out.println("13)Min no of deletion in a string to make it palindrom  ANS:-"+(s1.length()-lps)); //return longest palindromic subsequnce length 
		String s2="AABEBCDD"; //Pass same string twice and compute LCS where i!=j
		System.out.println("6)Longest repeating subSequence ANS:-"+LongestRepeatingSubSequence(s2, s2)); //print length of subsequence which repeat it self in string ip=aabebdd for this return 3 (abd appear twice in subsequence)
		String a3="AXY",b3="ADXCPY";//return true if string a3 is subsequence of string b3 (compute lcs and compare length with string a)
		System.out.println("8)subsequence pattern Matching ANS:-"+(a3.length()==LCS_TopDown(a3, b3,a3.length(),b3.length()))); 
		String s3="aebcbda";
		StringBuffer sb3=new StringBuffer(s3);
		lps=LCS_TopDown(s3,sb3.reverse().toString(),s3.length(),sb3.length()); //Same as No of deletion because if we insert same deleted chars we can make them pairs in this case D and E
		System.out.println("14)Min no of insertion in a string to make it palindromic  ANS:-"+(s3.length()-lps)); //return Min no of insersion count to make it palindrom


		
	}
	//FIRST STEP :return comman letter length from both strings x = abc ,y= bcdc then return 3 as abc is common in both
	public static int LCS_Simple_recursive_Code(String x,String y,int n,int m) {
		if(m==0 || n==0 )return 0;
		if(x.charAt(n-1)==y.charAt(m-1))
			return 1+LCS_Simple_recursive_Code(x,y,n-1,m-1);
		else return Math.max(LCS_Simple_recursive_Code(x, y,n-1,m),LCS_Simple_recursive_Code(x,y,n,m-1));
	}
	//SECOUND STEP
	public static int LCS_BottomUp_Memoized(String x,String y,int n,int m) {
		if(m==0 || n==0 )return 0;
		if(dp[n][m]!=-1)return dp[n][m];
		if(x.charAt(n-1)==y.charAt(m-1))
			return dp[n][m]=1+LCS_Simple_recursive_Code(x,y,n-1,m-1);
		else return dp[n][m]=Math.max(LCS_Simple_recursive_Code(x, y,n-1,m),LCS_Simple_recursive_Code(x,y,n,m-1));
	}
	
	//THIRD STEP
	public static int LCS_TopDown(String x,String y,int n,int m) {
		int t[][]=new int [m+1][n+1];  //Make n and then m to make similar with KS  
		
	
		
		return t[m][n];
	}
	
	public static int LongestCommonSubString(String x,String y,int n,int m) {
		int t[][]=new int [m+1][n+1];  
		int max=0;
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 || j==0)
					t[i][j]=0;
				else if(x.charAt(j-1)==y.charAt(i-1)) {
					t[i][j]=1+t[i-1][j-1];
					if(t[i][j]>max)
						max=t[i][j];
				}
			}
		}
		
		return max;
	}
	
	
	public static String printLCS_String(String a,String b,int n, int m) {
		int t[][] =new int[n+1][m+1];
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0||j==0)
					t[i][j]=0;
				else if(a.charAt(i-1)==b.charAt(j-1)) {
					t[i][j]=1+t[i-1][j-1];
				}else
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		int i=n,j=m;
		while(i>0 && j>0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				sb.append(a.charAt(i-1));
				i--;
				j--;
			}else if(t[i-1][j]>t[i][j-1]) {
				i--;
			}else j--;
		}
		
		return sb.reverse().toString();
	}
	
	
	 public static String shortestCommonSupersequence(String str1, String str2) {
	        
			// Part 1: Similar to Longest Common Subsequence problem => gives us "Memorization Table"
	        int m = str1.length();
	        int n = str2.length();
	        int[][] t = new int[m+1][n+1];

	        for(int i=0;i<m+1;i++) {
	        	for(int j=0;j<n+1;j++) {
	        		if(i==0 || j==0) {
	        			t[i][j]=0;
	        		}else if(str1.charAt(i-1)==str2.charAt(j-1)) 
	        			t[i][j]=1+t[i-1][j-1];
	        		else
	        			t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
	        	}
	        }
	        StringBuffer result=new StringBuffer();

	        int i=m,j=n;
	        while(i>0 && j>0) {
	        	if(str1.charAt(i-1)==str2.charAt(j-1))
	        	{
	        		result.append(str1.charAt(i-1));
	        		i--;
	        		j--;
	        	}else if(t[i-1][j]>t[i][j-1]) {
	        		result.append(str1.charAt(--i));
	        	}else 
	     	       result.append(str2.charAt(--j));
	     	        
	        	
	        }
	        
	        while(i>0) {
	        	result.append(str1.charAt(--i));
	        }
	        while(j>0) {
	        	result.append(str2.charAt(--j));
	        }
	        
	        
	        result.reverse();
	        return result.toString();
	    }
	 
	 public static int LongestRepeatingSubSequence(String x,String y) {
		    int m=x.length(),n=y.length();
			int t[][]=new int [m+1][n+1]; 
			
			for(int i=0;i<m+1;i++) {
				for(int j=0;j<n+1;j++) {
					if(i==0 || j==0)
						t[i][j]=0;
				}
			}
			
			for(int i=1;i<m+1;i++) {
				for(int j=1;j<n+1;j++) {
					//Only CHANGE FROM LCS i!=j
					if(y.charAt(i-1)==x.charAt(j-1) && i!=j) {   
						t[i][j]=1+t[i-1][j-1];
					}else {
						t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
					}
				}
			}
			
			return t[m][n];
		}
	
}
