package com.acrossPart;

import java.util.HashSet;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		int in[] = {3 ,7, 4 ,6 ,5};
		System.out.print(solve(in, 0, 0));
		
	/*	String word1="cabbba";
		String word2="aabbss";
		Set<String> s =new HashSet<>();
		int dis=editDistance(word1,word2,word1.length(),word2.length());
		System.out.print(dis);*/
	}
	
	   public static int solve(int [] ip,int op,int index){
	        if(index==ip.length){
	            return op;
	        }
	        int op1=op;
	        int op2=op+ip[index];
	        return Math.max(solve(ip,op1,index+1),solve(ip,op2,index+1));
	    }
	
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
	 
	 public int romanToInt(String str){
	        int result = 0;
	        
	        for(int i=0;i<str.length();i++){
	            if(i>0 && getCharValue(str.charAt(i))>getCharValue(str.charAt(i-1)))
	            {
	                //if increasing then previously added value is wrong its need to be subtracted rather then 
	                //added so remove 2 times
	                result+=getCharValue(str.charAt(i))-2*getCharValue(str.charAt(i-1));
	            }else{
	                result+=getCharValue(str.charAt(i));
	            }
	        }
	       
	        
	        return result; 
	    }
	    
	     public int getCharValue(char c) {      
	        switch(c) {
	            case 'I' :
	                return 1;
	            case 'V': 
	                return 5;
	            case 'X':
	                return 10;
	             case 'L':
	                return 50;
	            case 'C':
	                return 100;
	            case 'D':
	                return 500;
	            case 'M': 
	                return 1000;
	        }
	        return 0;        
	    } 
	

}
