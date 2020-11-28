package com.cleanup;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(isPalindrom("Nitin"));
	}
	//return true if string is palindrom
	public static boolean isPalindrom(String s) {
		if(s.length()==1)return true;
		
		if(s.charAt(0)==s.charAt(s.length()-1))
			return isPalindrom(s.substring(1,s.length()-1));
		else 
			return false;
	}

}
