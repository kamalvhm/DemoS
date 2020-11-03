package com.intquetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
		Character.toUpperCase(s.charAt(0));
		
		StringBuffer sb=new StringBuffer();
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
	  
	  //67. Add Binary
	  public String addBinary(String a, String b) {
	       StringBuilder sb=new StringBuilder();
	        int i=a.length()-1;
	        int j=b.length()-1;
	        int carry=0;
	        while(i>=0 || j>=0){
	            int sum=carry;
	            if(i>=0){
	                sum+=a.charAt(i--) -'0';
	            }
	            
	             if(j>=0){
	                sum+=b.charAt(j--) -'0';
	            }
	             //we are inserting at zero position
	            sb.insert(0,sum % 2);
	            carry =sum/2;
	        }
	        if(carry>0)
	            sb.insert(0,1);
	        
	        return sb.toString();
	    }
	  
	  //415. Add Strings numbers
	   public String addStrings(String num1, String num2) {
	        int carry=0;
	        StringBuilder sb=new StringBuilder();
	        int i=num1.length()-1;
	        int j=num2.length()-1;
	        
	        while(i>=0 || j>=0 ){
	            int sum=carry;
	            
	            if(i>=0){
	                sum+=num1.charAt(i--)-'0';
	            }
	            if(j>=0){
	                sum+=num2.charAt(j--)-'0';
	            }
	            
	            sb.append(sum%10);
	            carry=sum/10;
	        }
	        if(carry>0)
	            sb.append(carry);
	        
	        return sb.reverse().toString();
	        
	    }
	   //  49. Group Anagrams 
	   public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>>  groupAnagrams =new ArrayList<List<String>>();
	        HashMap<String,List<String>> map=new HashMap<>();
	        
	        for(String s:strs){
	            char[] characters=s.toCharArray();
	            Arrays.sort(characters);
	            String sorted=new String(characters);
	            
	            if(!map.containsKey(sorted)){
	                map.put(sorted, new ArrayList());
	            }
	             
	           map.get(sorted).add(s);
	            
	        } 
	        
	        
	       
	            groupAnagrams.addAll(map.values());
	        
	        
	        return groupAnagrams;
	    }
}
