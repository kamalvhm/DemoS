package com.intquetions;

public class StringProblems {
	public static void main(String[] args) {
		String s="ABRACADABRA";
		//all sub strings
		for(int i=0;i<s.length();i++) {
			 for (int j =s.length(); j > i; j--) {
				 System.out.println((s.substring(i,j)));
			}
		}

		//convert to ancii
		int ascii = (int) s.charAt(0);
		
		Character.isLetterOrDigit(s.charAt(0));		
	}
	
	//125. Valid Palindrome
	  public boolean isPalindrome(String str) {
	        int i=0,j=str.length()-1;
	        boolean isPalindrom=false;
	        while(i<j){
	            while(i<j && !Character.isLetterOrDigit(str.charAt(i))){
	                i++;
	            }
	             while(i<j && !Character.isLetterOrDigit(str.charAt(j))){
	                j--;
	            }
	            if(i<j && Character.toLowerCase(str.charAt(i++))!=Character.toLowerCase(str.charAt(j--))){
	               return false;
	            }
	        }
	               return true;
	    }
}
