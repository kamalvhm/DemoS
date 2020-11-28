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
	}

	//THIRD STEP
	public static int LCS(String x, String y, int n, int m) {
		int t[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++)
			t[i][0] = 0;
		for (int j = 0; j < m + 1; j++)
			t[0][j] = 0;
		StringBuffer sb=new StringBuffer();

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if(x.charAt(i-1)==y.charAt(j-1)) {
					sb.append(x.charAt(i-1));
					t[i][j]=1+t[i-1][j-1];
				}else t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
			}
		}
		
	
		System.out.println(sb.toString());
		return t[n][m];
	}

}
