package com.cleanup;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String b="bb";
		System.out.print(isPalindrom(b,0,b.length()-1));
	}
	//return true if string is palindrom
	public static boolean isPalindrom(String s) {
		if(s.length()==1)return true;
		
		if(s.charAt(0)==s.charAt(s.length()-1))
			return isPalindrom(s.substring(1,s.length()-1));
		else 
			return false;
	}

	public static boolean isPalindrom(String s,int i,int j) {
		if(i==j)return true;
		if(i>j) return true;
		
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
			return true;
	}

	public static boolean isPalindrome(String s, int i, int j) {

		while (i <= j) {

			if (s.charAt(i) != s.charAt(j))
				return false;

			i++;
			j--;

		}
		return true;
	}
}
