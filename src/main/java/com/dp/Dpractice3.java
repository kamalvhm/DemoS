package com.dp;

import java.util.Arrays;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

/** 
 LCS Length ANS:-4
1) Longest common subString ANS:-2
2)print  LCS ANS :-abdh
3)Shortest common super sequence ANS :-9
4)print SCS ANS :-cabac
5) Min # insertion and deletion a->b ANS Deletion:-2 Insertion 1
10)Longest palindromic sub sequence ANS:-5
13)Min no of deletion in a string to make it palindrom  ANS:-1
6)Longest repeating subSequence ANS:-3
8)subsequence pattern Matching ANS:-true
14)Min no of insertion in a string to make it palindromic  ANS:-2
 */
public class Dpractice3 {
	static int dp[][]=new int[20][20];//m+1 n+1
	static {
		for(int[] a:dp)
			Arrays.fill(a, -1);
	}
	
	public static void main(String[] args) {
		String x="abcdgh",y="abedfhr"; //common in both is abdh so 4 is ans
		System.out.println("LCS Length ANS:-"+LCS_TopDown(x,y,x.length(),y.length())); //1143. Longest Common Subsequence
		String a="abcde",b="abfce";  /**ANS  2 */ // 2 longest countinues common string is 'ab' so 2
		System.out.println("1) Longest common subString ANS:-"+LongestCommonSubString(a,b,a.length(),b.length()));
		/*String a10="intention",b10="execution"; 
		System.out.println("2)print  LCS ANS :-"+printLCS_String(a10,b10,a10.length(),b10.length())); //ANS abdh
*/		System.out.println("2)print  LCS ANS :-"+printLCS_String(x,y,x.length(),y.length())); //ANS abdh
		String a1="AGGTAB" ,b1="GXTXAVB"; //Merged Sortest will be AGGXTXAYB to find length = (length of a1 + length of b1) - LCS of both strings (ANS :-(6+7)-4=9)
		System.out.println("3)Shortest common super sequence ANS :-"+((a1.length()+b1.length())-LCS_TopDown(a1, b1, a1.length(), b1.length()))); //return length of shortest string which contains both string sequence 
		System.out.println("4)print SCS ANS :-"+shortestCommonSupersequence("abac","cab")); //return  shortest string which contains both string sequence  ANS :-"cabac"
		String a2="heap",b2="pea";
		int lcs=LCS_TopDown(a2,b2,a2.length(),b2.length());
		System.out.println("5) Min # insertion and deletion a->b ANS Deletion:-"+(a2.length()-lcs)+" Insertion "+(b2.length()-lcs)); //return min insertion and deletion to form String a to b  ANS :-"cabac"
		String s="agbcba";
		StringBuffer sb=new StringBuffer(s); //We are using b string as reverse of a to find palindromic string {In ip only one string given}
		System.out.println("10)Longest palindromic sub sequence ANS:-"+LCS_TopDown(s,sb.reverse().toString(),s.length(),s.length())); //return longest palindromic subsequnce length 
		// No of deletion in string to make it palindromic
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

				//print cost of converting string e1 to e2 by considering insert ,delete,and replace operations  ||72. Edit Distance
				String e1="intention";
				String e2="execution";//Ans will be 5
				System.out.println("15) Edit Distance :-"+editDistance(e1,e2,e1.length(),e2.length()));
		
	}
	//FIRST STEP :return comman letter length from both strings x = abc ,y= bcdc then return 3 as abc is common in both
	public static int LCS_Simple_recursive_Code(String x,String y,int n,int m) {
		return 1;
	}
	//SECOUND STEP
	public static int LCS_BottomUp_Memoized(String x,String y,int n,int m) {
		return 1;
	}
	
	//THIRD STEP
	public static int LCS_TopDown(String x,String y,int n,int m) {
		int t[][]=new int [n+1][m+1];  //Make n and then m to make similar with KS  
	
		
		return t[n][m];
	}
	
	public static int LongestCommonSubString(String x,String y,int n,int m) {
		int t[][]=new int [n+1][m+1];  
		
		
		return -1;
	}
	
	
	public static String printLCS_String(String x,String y,int n, int m) {		
		int t[][]=new int [n+1][m+1];  //Make n and then m to make similar with KS  
		
		
		StringBuffer sb=new StringBuffer();
	
		
		return sb.toString();
	}
	
	
	 public static String shortestCommonSupersequence(String x, String y) {
		 int m=y.length(),n=x.length();
		 int t[][]=new int [n+1][m+1];  //Make n and then m to make similar with KS  
			
			StringBuffer sb=new StringBuffer();

			return sb.toString();
	    }
	 
	 public static int LongestRepeatingSubSequence(String x,String y) {
		    int m=x.length(),n=y.length();
		    int t[][]=new int [n+1][m+1];  //Make n and then m to make similar with KS  
			
			
			
			return t[n][m];
		}
	
	 public static int editDistance(String x,String y,int n,int m){
	        int t[][]=new int [n+1][m+1];
	        
	        return t[n][m];
	    }
}
