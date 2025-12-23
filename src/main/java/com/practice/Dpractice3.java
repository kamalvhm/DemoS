package com.practice;

import java.util.Arrays;

import scala.sys.process.ProcessBuilderImpl.Simple;


/** @link LongestCommanSubSequece3.class 
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
15) Edit Distance :-5
16)Distinct Subsequences :-3
11)Longest palindromic substring :-aba
17)Minimum ASCII Delete Sum for Two Strings :-231
7)Length of longest subsequence of a which is substring in b :-3
9)count how many times a appear as subsequence in b :-4
18)LIS :-4
 */
public class Dpractice3 {
	static int dp[][]=new int[20][20];//m+1 n+1
	static {
		for(int[] a:dp)
			Arrays.fill(a, -1);
	}
	//#@link LongestCommanSubSequece3.java
	public static void main(String[] args) {
		String x="abcdgh",y="abedfhr"; //common in both is abdh so 4 is ans
		System.out.println("LCS Length (4) ANS:- "+LCS_TopDown(x,y,x.length(),y.length())); //1143. Longest Common Subsequence
		String a="abcde",b="abfce";  /**ANS  2 */ // 2 longest countinues common string is 'ab' so 2
		System.out.println("1) Longest common subString (2)ANS:-"+LongestCommonSubString(a,b,a.length(),b.length()));
/*		String a10="intention",b10="execution"; 
		System.out.println("2)print  LCS ANS :-"+printLCS_String(a10,b10,a10.length(),b10.length()));*/ //ANS abdh
		System.out.println("2)print  LCS ANS (abdh):-"+printLCS_String(x,y,x.length(),y.length())); //ANS abdh
		String a1="AGGTAB" ,b1="GXTXAVB"; //Merged Shortest will be AGGXTXAYB to find length = (length of a1 + length of b1) - LCS of both strings (ANS :-(6+7)-4=9)
		System.out.println("3)Shortest common super sequence ANS (9) :-"+((a1.length()+b1.length())-LCS_TopDown(a1, b1, a1.length(), b1.length()))); //return length of shortest string which contains both string sequence 
		System.out.println("4)print SCS ANS (cabac) :-"+shortestCommonSupersequence("abac","cab")); //return  shortest string which contains both string sequence  ANS :-"cabac"
		String a2="heap",b2="pea";
		int lcs=LCS_TopDown(a2,b2,a2.length(),b2.length());
		System.out.println("5) Min # insertion and deletion a->b ANS Deletion (Deletion:-2 Insertion 1):-"+(a2.length()-lcs)+" Insertion "+(b2.length()-lcs)); //return min insertion and deletion to form String a to b  ANS :-"cabac"
		String s="agbcba";
		StringBuffer sb=new StringBuffer(s); //We are using b string as reverse of a to find palindromic string {In ip only one string given}
		System.out.println("10)Longest palindromic sub sequence ANS (5):-"+LCS_TopDown(s,sb.reverse().toString(),s.length(),s.length())); //return longest palindromic subsequnce length 
		// No of deletion in string to make it palindromic
		String s1="agbcba";
		StringBuffer sb1=new StringBuffer(s);
		int lps=LCS_TopDown(s1,sb1.reverse().toString(),s1.length(),sb1.length()); //No of deletion is inversely  proportion to LPS so computing LPS
		System.out.println("13)Min no of deletion in a string to make it palindrom  ANS:-"+(s1.length()-lps)); //return longest palindromic subsequnce length 
		//print length of subsequence which repeat it self in string ip=aabebdd for this return 3 (abd appear twice in subsequence)
		String s2="AABEBCDD"; //Pass same string twice and compute LCS where i!=j
		System.out.println("6)Longest repeating subSequence (3) ANS:-"+LongestRepeatingSubSequence(s2, s2)); 
		String a3="AXY",b3="ADXCPY";//return true if string a3 is subsequence of string b3 (compute lcs and compare length with string a)
		System.out.println("8)subsequence pattern Matching ANS:-"+(a3.length()==LCS_TopDown(a3, b3,a3.length(),b3.length()))); 
		String s3="aebcbda";
		StringBuffer sb3=new StringBuffer(s3);
		lps=LCS_TopDown(s3,sb3.reverse().toString(),s3.length(),sb3.length()); //Same as No of deletion because if we insert same deleted chars we can make them pairs in this case D and E
		System.out.println("14)Min no of insertion in a string to make it palindromic  ANS:-"+(s3.length()-lps)); //return Min no of insersion count to make it palindrom

		//print cost of converting string e1 to e2 by considering insert ,delete,and replace operations  ||72. Edit Distance
		String e1="intention";
		String e2="execution";//Ans will be 5
		System.out.println("15) Edit Distance (5):-"+editDistance(e1,e2,e1.length(),e2.length()));
		

		String e3="rabbbit";
		String e4="rabbit";//there are 3 ways you can generate "rabbit" from e3.so return 3
		System.out.println("16)Distinct Subsequences (3):-"+DistinctSubsequences(e3,e4,e3.length(),e4.length()));
		
		String s4="babad"; //Ans :-aba
		System.out.println("11)Longest palindromic substring (aba):-"+longestPalindromicSubString(s4));
		
		String s5 = "sea", s6 = "eat";
		/** so to make them equal what is the minimum ancii sum
		 * 	Output: 231
			Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
			Deleting "t" from "eat" adds 116 to the sum.
			At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
		 */
		System.out.println("17)Minimum ASCII Delete Sum for Two Strings (231) :-"+minimumDeleteSum(s5,s6,s5.length(),s6.length()));
		String s7 = "ABCD", s8 = "BACDBDCD";//Output : 3 "ACD" is longest subsequence of s7 which is substring of s8.
		System.out.println("7)Length of longest subsequence of a which is substring in b :-"+longestOfAinB(s7,s8,s7.length(),s8.length()));
		String s9 = "GeeksforGeeks", s10 = "Gks";//find the number of times the second string occurs in the first string, whether continuous or discontinuous.
		//SAME AS DistinctSubsequences
		System.out.println("9)count how many times a appear as subsequence in b (4) :-"+DistinctSubsequences(s9,s10,s9.length(),s10.length()));
		int [] nums = {10,9,2,5,3,7,101,18};
		System.out.println("18)LIS (4):-"+lengthOfLIS(nums));
		
	}
	//FIRST STEP :return comman letter length from both strings x = abc ,y= bcdc then return 3 as abc is common in both
	public static int LCS_Simple_recursive_Code(String x,String y,int n,int m) {
		if(n==0 || m==0)return 0;
		if(dp[n][m]!=-1)return dp[n][m];
		if(x.charAt(n-1)==y.charAt(m-1))
			return dp[n][m]=1+LCS_Simple_recursive_Code(x,y,n-1,m-1);
		return dp[n][m]=Math.max(LCS_Simple_recursive_Code(x, y,n-1,m),LCS_Simple_recursive_Code(x,y,n,m-1));
	}
	
	
	//THIRD STEP
	public static int LCS_TopDown(String x,String y,int n,int m) {
		int t[][] =new int [n+1][m+1];
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(x.charAt(i-1)==y.charAt(j-1))
						t[i][j]=1+t[i-1][j-1];
				else t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		return t[n][m];
	}
	
	public static int LongestCommonSubString(String x,String y,int n,int m) {
		int t[][]=new int[n+1][m+1];
		int max =0;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(x.charAt(i-1)==y.charAt(j-1))
					t[i][j]=1+t[i-1][j-1];
				else t[i][j]=0;
				max=Math.max(max, t[i][j]);
			}
		}
		return max;
	}
	
	
	public static String printLCS_String(String x,String y,int n, int m) {		
		int t[][]=new int [n+1][m+1];  //Make n and then m to make similar with KS
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(x.charAt(i-1)==y.charAt(j-1))
					t[i][j]=1+t[i-1][j-1];
				else t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
		StringBuffer sb=new StringBuffer();
		int i=n,j=m;
		while(i>0 && j>0) {
			if(x.charAt(i-1)==y.charAt(j-1)) {
				sb.insert(0, x.charAt(i-1));
				i--;
				j--;
			}else if(t[i-1][j]>t[i][j-1])
				i--;
			else j--;
		}
		return sb.toString();
	}
	
	
	 public static String shortestCommonSupersequence(String x, String y) {
		 	int n= x.length();
	        int m = y.length();
	        int[][] t = new int[n+1][m+1];
	        for(int i=1;i<n+1;i++) {
	        	for(int j=1;j<m+1;j++) {
	        		if(x.charAt(i-1)==y.charAt(j-1))
	        			t[i][j]=1+t[i-1][j-1];
	        		else t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
	        	}
	        }
	        
	        StringBuffer sb=new StringBuffer();
	        int i=n,j=m;
	        while(i>0 && j>0) {
	        	if(x.charAt(i-1)==y.charAt(j-1)) {
	        		sb.insert(0, x.charAt(i-1));
	        		i--;
	        		j--;
	        	}else if(t[i-1][j]>t[i][j-1]) {
	        		sb.insert(0, x.charAt(i-1));
	        		i--;
	        	}
	        	else {
	        		sb.insert(0, y.charAt(j-1));

	        		j--;
	        	}
	        }
	       
	        while(i>0) {
	        	sb.insert(0, x.charAt(i-1));
	        	i--;
	        }
	        
	        while(j>0) {
	        	sb.insert(0, y.charAt(j-1));
	        	j--;
	        }
	        return sb.toString();
	    }
	 
	 public static int LongestRepeatingSubSequence(String x,String y) {
		    int n=x.length(),m=y.length();
			int t[][]=new int[n+1][m+1];
			for(int i=1;i<n+1;i++) {
				for(int j=1;j<m+1;j++) {
					if(x.charAt(i-1)==y.charAt(j-1) && i!=j)
						t[i][j]=1+t[i-1][j-1];
					else t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
				}
			}
			return t[n][m];
		}
	
	 public static int editDistance(String x,String y,int n,int m){
	        int t[][]=new int [n+1][m+1];
	        for(int i=0;i<n+1;i++)
	        	t[i][0]=i;
	        for(int j=0;j<m+1;j++)
	        	t[0][j]=j;
	        
	        for(int i=1;i<n+1;i++) {
	        	for(int j=1;j<m+1;j++) {
	        		if(x.charAt(i-1)==y.charAt(j-1))
	        				t[i][j]=t[i-1][j-1];
	        		else t[i][j]=Math.min(t[i-1][j], Math.min(t[i][j-1], t[i-1][j-1]))+1;
	        	}
	        }
	       
	        return t[n][m];
	    }
	 
	//115. Distinct Subsequences | https://www.youtube.com/watch?v=HtLVAvIGikU  
		 public static int DistinctSubsequencesR(String s ,String t,int n,int m){
			 if(m==0)return 1;
			 if(n==0)return 0;
			 if(s.charAt(n-1)==t.charAt(m-1))
				 return DistinctSubsequencesR(s,t,n-1,m-1) + DistinctSubsequencesR(s,t,n-1,m);
			 else 
			return DistinctSubsequencesR(s,t,n-1,m);
	    }
		 
		public static int DistinctSubsequences(String x ,String y,int n,int m){
		      int t[][]=new int [n+1][m+1];
		      for(int i=0;i<n+1;i++)
		    	  t[i][0]=1;
		      for(int i=1;i<n+1;i++) {
		    	  for(int j=1;j<m+1;j++) {
		    		  if(x.charAt(i-1)==y.charAt(j-1))
		    			  t[i][j]=t[i-1][j-1]+t[i-1][j];
		    		  else t[i][j]=t[i-1][j];
		    	  }
		      }
		    
		      return t[n][m];
		    }
		//https://www.youtube.com/watch?v=5SrTJ4D9hKw&t=399s | Prior -https://www.youtube.com/watch?v=OjaUemQyDmw
		private static String longestPalindromicSubString(String e) {
			int n=e.length();
			int t[][]=new int[n+1][n+1];
			int dp[][]=new int[n+1][n+1];//i th index is length and j th is end index
			String res="";
			int resE=1,resL=1;//length and end index of palindrom
			if(n==0)return res;
			
			for(int i=0;i<n+1;i++) {
				dp[0][i]=1;
				dp[1][i]=1;
			}
			for(int i=2;i<n+1;i++) { //len
				for(int j=i;j<n+1;j++) { //end index
					if(e.charAt(j-1)==e.charAt(j-i) && dp[i-2][j-1]==1) {
						dp[i][j]=1;
						resL=i;
						resE=j;
					}else dp[i][j]=0;
				}
			}
			return e.substring(resE-resL,resE);
		}
		
		//CODE SAME AS LCS JUST ADD ANSCII AT EVERY STEP
		public static int minimumDeleteSum(String s1,String s2,int n,int m){
	        int t[][]=new int [n+1][m+1];
	       
	        for(int i=1;i<n+1;i++) 
	        	t[i][0]=t[i-1][0]+(int)s1.charAt(i-1);
	        for(int j=1;j<m+1;j++) 
	        	t[0][j]=t[0][j-1]+(int)s2.charAt(j-1);
	        
	        for(int i=1;i<n+1;i++) {
	        	for(int j=1;j<m+1;j++) {
	        		if(s1.charAt(i-1)==s2.charAt(j-1))
	        			t[i][j]=t[i-1][j-1];
	        		else t[i][j]=Math.min(t[i-1][j]+(int)s1.charAt(i-1), t[i][j-1]+(int)s2.charAt(j-1));
	        	}
	        }
	        
	        return t[n][m];
	    }
		public static int longestOfAinR(String x,String y,int n,int m) {
			int t[][]=new int [n+1][m+1];  
			int max=0;
			
			return max;
		}
		//https://www.geeksforgeeks.org/find-length-longest-subsequence-one-string-substring-another-string/
		public static int longestOfAinB(String x,String y,int n,int m) {
			int t[][]=new int [n+1][m+1];  
			int max=0;
			
			
			return max;
		}
		//https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
		public static int stringASubSequenceInB(String x,String y,int n,int m) {
			//return count(x,y,n,m); //for recursive code 
			return countBottomUp(x,y,n,m); //for bottomUp code 

		}

		public static int count(String a, String b, int n, int m) {
			return 1;
		} 
		public static int countBottomUp(String x, String y, int n, int m) {
			int t[][] = new int[n + 1][m + 1];
			// If first string is empty
			
			return t[n][m];
		}
		//300. Longest Increasing Subsequence -https://www.youtube.com/watch?v=aPQY__2H3tE&t=417s
		public static int lengthOfLIS(int[] nums) {
	        if(nums.length==0) return 0;
	        int dp [] =new int[nums.length];
	        int max=1;
	        Arrays.fill(dp, 1);
	        for(int i=0;i<nums.length;i++) {
	        	for(int j=0;j<i;j++) {
	        		if(nums[j]<nums[i] && dp[i]<dp[j]+1) {
	        			dp[i]=dp[j]+1;
	        		}
	        		max=Math.max(max, dp[i]);
	        	}
	        }
	        return max;
	    }
}
