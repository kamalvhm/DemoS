package com.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import scala.collection.mutable.ArrayLike;

public class Test {

	public static void main(String[] args) {
		
		/*// TODO Auto-generated method stub
		MyArrayList<String> arr=new MyArrayList<String>();
		
		for(int i=0;i<5;i++)
		arr.add("abc"+i);
		
		//arr.delete(3);
		
		for(int i=0;i<arr.length();i++) {
			System.out.println(arr.get(i));

		}*/
		
		//LinkedList<String> larr=new LinkedList<String>();

		
		MyLinkList<String> llarr=new MyLinkList<String>();
				
				for(int i=0;i<5;i++)
					llarr.add(""+i);
				
				//llarr.delete(2);
				
				//llarr.reverse();
				
				//System.out.println(llarr);
				
				//System.out.println(llarr.getSize());
				
				//MyLinkList<String> llarr2=new MyLinkList<String>();
				
				//for(int i=5;i<7;i++)
				//	llarr2.add(""+i);
				
				//System.out.println(llarr2);
				//MyLinkList.mergeInbetween("2,3", llarr, llarr2);
				//System.out.println(llarr);
				
				System.out.println(getAnnagrams("123122"));
				
				
	}
	
	
	public static boolean isVowel(char c) {
		return (c=='a' || c=='e' ||c=='i' || c=='o'||c=='u' || 
				c=='A' || c=='E' ||c=='I' || c=='O'||c=='U');
	}
	
	
	 static String reverseVowel(String str1) { 
	        int j = 0; 
	        char[] str = str1.toCharArray(); 
	        String vowel = ""; 
	        for (int i = 0; i < str.length; i++) { 
	            if (isVowel(str[i])) { 
	                j++; 
	                vowel += str[i]; 
	            } 
	        } 
	  
	        for (int i = 0; i < str.length; i++) { 
	            if (isVowel(str[i])) { 
	                str[i] = vowel.charAt(--j); 
	            } 
	        } 
	  
	        return String.valueOf(str); 
	    } 
	 
	 
	 
	 public static int getAnnagrams(String s) {
		 char[] str= s.toCharArray();
		
		 int mid =(str.length+1)/2;
		 char[] str1 = new char[mid],  str2 = new char[mid];
		 for(int i=0;i<str.length;i++) {
			if(i<mid) 
				str1[i]=str[i];
			else str2[i-mid]=str[i];
		 }
		 int n1 = str1.length; 
	     int n2 = str2.length; 
	  
	        if (n1 != n2) 
	            return 0; 
	  
	        // Sort both strings 
	        Arrays.sort(str1); 
	        Arrays.sort(str2); 
	        int count =0;
	        for (int i = 0; i < n1; i++) 
	            if (str1[i] != str2[i])
	            	count++;
	        
	        return count;
	 }
	 
	 
	 public static int heightChecker(int[] heights) {
	        int count = 0;
	        if (heights == null || heights.length == 0) return count;
	        int len = heights.length;
	        int[] newArr = new int[heights.length];
	        System.arraycopy(heights, 0, newArr, 0, len);
	        Arrays.sort(newArr);
	        for (int i = 0; i < len; i++) {
	            if (newArr[i] != heights[i])
	                count++;
	        }
	        return count;
	    }
	

}
