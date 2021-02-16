package com.dp;

import java.util.Arrays;

/**RELATED Problems LCS | https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22
 * 1)Longest common subString [v-22] |
 * 2)print  LCS [v-23]|
 * 3)Shortest common superSequence [v-24]
 * 4)print SCS [v-29] | 1092. https://leetcode.com/problems/shortest-common-supersequence/
 * 5)Min # insertion and deletion a->b
 * 6)Longest repeating subSequence
 * 7)Length of longest subsequence of a which is substring in b
 * 8)subsequence pattern Matching | 392. Is Subsequence
 * 9)count how many times a appear as subsequence in b
 * 10)Longest palindromic sub sequence [v-26] |516. Longest palindromic Subsequence https://leetcode.com/problems/longest-palindromic-subsequence/
 * 11)Longest palindromic substring  https://leetcode.com/problems/longest-palindromic-substring/
 * TODO 12)count of palindromic substring
 * 13)Min no of deletion in a string to make it palindromic 
 * 14)Min no of insertion in a string to make it palindromic 
 * 15)Edit Distance
 * 16)Distinct Subsequences
 * 17)Minimum ASCII Delete Sum for Two Strings
 * 18)Longest Increasing Subsequences
 * 19)44. Wildcard Matching  (10. Regular Expression Matching)| https://leetcode.com/problems/wildcard-matching/
 */

public class LongestCommanSubSequece3 {
	static int dp[][]=new int[8][7];//m+1 n+1
	static {
		for(int[] a:dp)
			Arrays.fill(a, -1);
	}
	
	public static void main(String[] args) {
		String x="abcdgh",y="abedfhr"; //common in both is abdh so 4 is ans
		System.out.println("LCS Length ANS:-"+LCS_TopDown(x,y,x.length(),y.length())); //1143. Longest Common Subsequence
		String a="abcde",b="abfce";  //ANS 2 longest continues common string is 'ab' so 2
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
		// No of deletion will be 1 of g  that will make abcba ( to make it palindromic)
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
		
		String e3="rabbbit";
		String e4="rabbit";//there are 3 ways you can generate "rabbit" from e3.
		System.out.println("16)Distinct Subsequences :-"+DistinctSubsequencesR(e3,e4,e3.length(),e4.length()));
		
		String s4="babad";
		System.out.println("11)Longest palindromic substring :-"+longestPalindromicSubString(s4));
		
		String s5 = "sea", s6 = "eat";
		/**
		 * 	Output: 231
			Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
			Deleting "t" from "eat" adds 116 to the sum.
			At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
		 */
		System.out.println("17)Minimum ASCII Delete Sum for Two Strings :-"+minimumDeleteSum(s5,s6,s5.length(),s6.length()));
		String s7 = "ABCD", s8 = "BACDBDCD";//Output : 3 "ACD" is longest subsequence of X which is substring of Y.
		System.out.println("7)Length of longest subsequence of a which is substring in b :-"+longestOfAinB(s7,s8,s7.length(),s8.length()));
		String s9 = "GeeksforGeeks", s10 = "Gks";//find the number of times the second string occurs in the first string, whether continuous or discontinuous.
		System.out.println("9)count how many times a appear as subsequence in b :-"+stringASubSequenceInB(s9,s10,s9.length(),s10.length()));
		int [] nums = {10,9,2,5,3,7,101,18};
		System.out.println("18)LIS :-"+lengthOfLIS(nums));
		

		
	}
	
	//FIRST STEP :return comman letter length from both strings x = abc ,y= bcdc then return 3 as abc is common in both
	public static int LCS_Simple_recursive_Code(String x,String y,int n,int m) {
		if(n==0 || m==0)return 0;
		if(x.charAt(n-1)==y.charAt(m-1)) return 1+LCS_Simple_recursive_Code(x, y, n-1, m-1); 
		else return Math.max(LCS_Simple_recursive_Code(x, y, n, m-1), LCS_Simple_recursive_Code(x, y, n-1, m));
	}
	//SECOUND STEP
	public static int LCS_BottomUp_Memoized(String x,String y,int n,int m) {
		if(n==0 || m==0)return 0;
		if(dp[m][n]!=-1)return dp[m][n];
		if(x.charAt(n-1)==y.charAt(m-1)) return dp[m][n]=1+LCS_Simple_recursive_Code(x, y, n-1, m-1); 
		else return dp[m][n]=Math.max(LCS_Simple_recursive_Code(x, y, n, m-1), LCS_Simple_recursive_Code(x, y, n-1, m));
	}
	
	//THIRD STEP
	public static int LCS_TopDown(String x,String y,int n,int m) {
		int t[][]=new int [m+1][n+1];  //Make n and then m to make similar with KS  
		
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 || j==0)
					t[i][j]=0;
			}
		}
		
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(y.charAt(i-1)==x.charAt(j-1)) {   //remember y is i and x is j in above table
					t[i][j]=1+t[i-1][j-1];
				}else {
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		
		return t[m][n];
	}
	
	public static int LongestCommonSubString(String x,String y,int n,int m) {
		int t[][]=new int [m+1][n+1];   
		
		for(int i=0;i<m+1;i++) {
			for(int j=0;j<n+1;j++) {
				if(i==0 || j==0)
					t[i][j]=0;
			}
		}
		int max=0;  //!!!Second CHANGE!!!
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(y.charAt(i-1)==x.charAt(j-1)) {   
					t[i][j]=1+t[i-1][j-1];
					if(1+t[i-1][j-1]>max)
						max=1+t[i-1][j-1];
				}else {
					t[i][j]=0;// because its discontinues string so we are putting 0 !!! CHANGE!!!
				}
			}
		}
		
		return max;
	}
	
	
	public static String printLCS_String(String a,String b,int n, int m) {
		int t[][] =new int[n+1][m+1];
		
		
		for(int i=0;i<n+1;i++) {
			for(int j=0;j<m+1;j++) {
				if(i==0 || j==0)
					t[i][j]=0;
			}
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(a.charAt(i-1)==b.charAt(j-1))
					t[i][j]=1+t[i-1][j-1];
				else 
					t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
			}
		}
		//start from last value t[n][m] and check following  !!!THIS STEP CAN BE OPTIMIZED (String can be formed while making table above)!!!! 
		//Now print logic if both are equal add string in response and move i-- ,j-- if not equal move to maximum from both
		int i=n,j=m; StringBuffer res=new StringBuffer();
		while(i > 0 && j > 0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				res.insert(0,a.charAt(i-1));
				i--;
				j--;
			}else if(t[i][j-1]>t[i-1][j])
				j--;
			else i--;
		}
		return res.toString();
	}
	
	
	 public static String shortestCommonSupersequence(String str1, String str2) {
	        
			// Part 1: Similar to Longest Common Subsequence problem => gives us "Memorization Table"
	        int m = str1.length();
	        int n = str2.length();
	        int[][] t = new int[m+1][n+1];

	        for (int i = 1; i<=m; i++){
	            for (int j = 1; j<=n; j++){
	                if (i == 0 || j == 0){
	                    t[i][j] = 0;
	                }
	                if (str1.charAt(i-1) == str2.charAt(j-1)){
	                    t[i][j] = 1 + t[i-1][j-1];
	                }
	                else{
	                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
	                }
	            }
	        }
	        
			// Part 2: iterate through the memo table and construct the answer while iterating
	        int i=m;
			int j=n;
	        StringBuffer result = new StringBuffer();
	        
			while(i>0 && j>0){
	            if(str1.charAt(i-1)==str2.charAt(j-1)){
	                result.append(str1.charAt(i-1));
	                i--;
	                j--;
	            }
	            else{
	                if(t[i][j-1]>t[i-1][j]){
	                    result.append(str2.charAt(j-1));
	                    j--;
	                }
	                else{
	                    result.append(str1.charAt(i-1));
	                    i--;
	                }
	            }
	        }
			
			// append the left over characters of each string
	        while(i>0){
	            result.append(str1.charAt(i-1));
	            i--;
	        }
	        while(j>0){
	            result.append(str2.charAt(j-1));
	            j--;
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
	 //https://www.youtube.com/watch?v=XJ6e4BQYJ24
	 public static int editDistance(String x,String y,int n,int m){
	        int t[][]=new int [n+1][m+1];
	        
	          for(int i=0;i<n+1;i++){
	            for(int j=0;j<m+1;j++){
	                if(i==0)
	                    t[i][j]=j;  //if any string is empty then cost will be to add all other chars
	                if(j==0)
	                    t[i][j]=i;
	               
	            }
	        }
	        
	        for(int i=1;i<n+1;i++){
	            for(int j=1;j<m+1;j++){
	                if(x.charAt(i-1)!=y.charAt(j-1)){ //if both are not equal then choose min from add + delete and replace
	                    t[i][j]=1+Math.min(Math.min(t[i][j-1],t[i-1][j]),t[i-1][j-1]);//+1 is constant cost of add replace and delete
	                }else t[i][j]=t[i-1][j-1]; //if both are equal then no cost 
	            }
	        }
	        return t[n][m];
	    }
	 //115. Distinct Subsequences | https://www.youtube.com/watch?v=HtLVAvIGikU  
	 public static int DistinctSubsequencesR(String s ,String t,int n,int m){
         if(m==0)// we have traversed t and found all char so count 1 subsequence for that
            return 1;
         if(n==0)//we have traversed whole s and still not found all t chars so 0
            return 0;
        else if(s.charAt(n-1)!=t.charAt(m-1))// if last char not equal then exclude that char from s and look again
            return DistinctSubsequencesR(s,t,n-1,m);
        else return DistinctSubsequencesR(s,t,n-1,m-1)+DistinctSubsequencesR(s,t,n-1,m);//if both char mathes then add seletion and not seletion 
    }
	 
	public static int DistinctSubsequences(String s ,String t,int n,int m){
	        int dp[][]=new int [n+1][m+1];
	        
	        for(int i=0;i<n+1;i++){
	            dp[i][0]=1;// we have traversed t and found all char so count 1 subsequence for that
	        }
	        
	        for(int i=1;i<n+1;i++){
	            for(int j=1;j<m+1;j++){
	                if(s.charAt(i-1)!=t.charAt(j-1)) // if last char not equal then exclude that char from s and look again
	                    dp[i][j]=dp[i-1][j];
	                else dp[i][j]=dp[i-1][j-1]+dp[i-1][j];//if both char mathes then add seletion and not seletion 
	            }
	        }
	         
	      return dp[n][m];
	    }
	//https://www.youtube.com/watch?v=5SrTJ4D9hKw&t=399s | Prior -https://www.youtube.com/watch?v=OjaUemQyDmw
	private static String longestPalindromicSubString(String e) {
		int n=e.length();
		int dp[][]=new int[n+1][n+1];//ith index is length and j th is end index
		String res="";
		int resE=1,resL=1;//length and end index of palindrom
		if(n==0)return res;
		
		for(int i=0;i<=n;i++) dp[0][i]=dp[1][i]=1;//add 1 for empty and one length Strings 
		
		for(int i=2;i<=n;i++) {
			for(int j=i;j<=n;j++) {
				if(e.charAt(j-1)==e.charAt(j-i) && dp[i-2][j-1]==1) { //first and last chars are same and remaining middle is also same [i-2][j-1] is Because i represent length of 
						//String and j represent end index of string. so length will be of middle is -2 and end indx is -1
					dp[i][j] = 1;
					resL = i;
					resE = j;
				}
				else dp[i][j]=0;
			}
		}
		/*StringBuffer sb=new StringBuffer();
		for(int i=resE-resL+1;i<=resE;i++) {
			sb.append(e.charAt(i-1));
			}
		return sb.toString();*/
		return e.substring(resE-resL,resE);
	}
	//CODE SAME AS LCS JUST ADD ANSCII AT EVERY STEP
	public static int minimumDeleteSum(String s1,String s2,int n,int m){
        int t[][]=new int [n+1][m+1];
        
     /*   for(int i = 1;i < m+1;i++)
            t[0][i] += (t[0][i-1] + (int)s2.charAt(i-1));
        for(int i = 1;i < n+1;i++)
            t[i][0] += (t[i-1][0] + (int)s1.charAt(i-1));*/
        for(int i=1;i<n+1;i++) {
        	t[i][0]=t[i-1][0]+(int)s1.charAt(i-1);
        }
        for(int j=1;j<m+1;j++) {
        	t[0][j]=t[0][j-1]+(int)s2.charAt(j-1);
    	}
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                {
                    t[i][j]=t[i-1][j-1];
                }else t[i][j]=Math.min(t[i][j-1]+(int)s2.charAt(j-1), t[i-1][j]+(int)s1.charAt(i-1));
            }
        }
        return t[n][m];
    }
	//https://www.geeksforgeeks.org/find-length-longest-subsequence-one-string-substring-another-string/
	public static int longestOfAinB(String x,String y,int n,int m) {
		int t[][]=new int [m+1][n+1];  
		int max=0;
		for(int i=1;i<m+1;i++) {
			for(int j=1;j<n+1;j++) {
				if(y.charAt(i-1)==x.charAt(j-1)) {   
					t[i][j]=1+t[i-1][j-1];
					max=Math.max(max, t[i][j]);
				}else {
					// Else copy the previous value in the 
					t[i][j]=t[i][j-1]; //Only change from LCS (As we need subString from x so only one condition applied here )
				}
			}
		}
		
		return max;
	}
	//https://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
	public static int stringASubSequenceInB(String x,String y,int n,int m) {
		//return count(x,y,n,m); //for recursive code 
		return countBottomUp(x,y,n,m); //for bottomUp code 

	}

	public static int count(String a, String b, int n, int m) {
		// If both first and second string is empty, or if second string is empty,return 1
		if ((n == 0 && m== 0) || m == 0)
			return 1;

		// If only first string is empty and second string is not empty, return 0
		if (n == 0)
			return 0;

		// If last characters are same Recur for remaining strings by 
		//1. considering last characters of both strings
		//2. ignoring last character of first string
		if (a.charAt(n - 1) == b.charAt(m - 1))
			return count(a, b, n - 1, m - 1) + count(a, b, n - 1, m);
		else
			// If last characters are different,ignore last char of first string and recur for remaining string
			return count(a, b, n - 1, m);
	} 
	public static int countBottomUp(String x, String y, int n, int m) {
		int t[][] = new int[n + 1][m + 1];
		// If first string is empty
		for (int i = 0; i <= m; ++i)
			t[0][i] = 0;

		// If second string is empty
		for (int i = 0; i <= n; ++i)
			t[i][0] = 1;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (x.charAt(i - 1) == y.charAt(j - 1))
					t[i][j] = t[i - 1][j - 1] + t[i - 1][j];
				else
					t[i][j] = t[i - 1][j];
			}
		}
		return t[n][m];
	}
	//300. Longest Increasing Subsequence -https://www.youtube.com/watch?v=aPQY__2H3tE&t=417s
	public static int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int max = 1;
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(1+dp[j], dp[i]);
                    max = Math.max(max,dp[i]);
                }
            }
        }
        return max;
    }
	//Wildcard Matching
	public boolean isMatch(String s, String p) {
        // corner case
        if (s == null || p == null)
            return false;

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // 1. dp[0][0] = true, since empty string matches empty pattern
        dp[0][0] = true;

        // 2. dp[0][i] = false
        // since empty pattern cannot match non-empty string

        // 3. dp[j][0]
        // for any continuative '*' will match empty string
        // e.g s='aasffdasda' p='*'/'**'/'***'....
        for (int j = 1; j < n + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j][0] = dp[j - 1][0];
            }
        }

        // 1. if p.charAt(j) == s.charAt(i), match single character
        // =>>> dp[i][j] = dp[i - 1][j - 1]
        // 2. if p.charAt(j) == '?', '?' match single character
        // =>>> dp[i][j] = dp[i - 1][j - 1]

        // 3. if p.charAt(j) == '*', dp[i][j]=dp[i-1][j]||dp[i][j-1]
        // =>>> a. '*' match empty: dp[i][j]=dp[i-1][j]
        // =>>> b. '*' match multiple characters: dp[i][j]=dp[i][j-1]

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                char charS = s.charAt(i - 1);
                char charP = p.charAt(j - 1);
                if (charS == charP || charP == '?')
                    dp[j][i] = dp[j - 1][i - 1];
                else if (charP == '*')
                    dp[j][i] = dp[j - 1][i] || dp[j][i - 1];

            }
        }

        return dp[n][m];
    }
	//Wildcard Matching recusrsive 
	 public static int solve(String s, String p,int i,int j,int[][]dp){
	        if(dp[i][j]!=-1) return dp[i][j];
	        if(i==s.length() && j==p.length())return 1;
	        
	        if(i==s.length() && j<p.length()){
	            for(int k=j;k<p.length();k++){
	                if(p.charAt(k)!='*')
	                    return 0;
	            }
	            return 1;
	        }
	        if(j==p.length() && i<s.length())
	            return 0;
	        
	        if(p.charAt(j)!='*'){
	        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
	            return dp[i][j]=solve(s,p,i+1,j+1,dp);
	        }else {
	            return dp[i][j]=(solve(s,p,i+1,j,dp)==1 || solve(s,p,i,j+1,dp)==1)?1:0;
	        }
	        return 0;
	    }
	
}
