package com.backtracking;

public class DevideAndConquer {

	//https://www.youtube.com/watch?v=eTKZKZV1Zp0
	public static void main(String args[]) {
		//395. Longest Substring with At Least K Repeating Characters
	}
	
	
	 public static int devideAndConquer(int start,int end,String s,int k){
	        int charCount[]=new int[26];
	        
	        for(int i=start;i<end;i++){
	            charCount[s.charAt(i)-'a']++;
	        }
	        
	        for(int j=start;j<end;j++){
	            int count=charCount[s.charAt(j)-'a'];
	            
	            if(count>0 && count<k){
	                int leftSide=devideAndConquer(start,j,s,k);
	                int rightSide=devideAndConquer(j+1,end,s,k);
	                return Math.max(leftSide,rightSide);
	            }
	        }
	        return end-start;
	    }
}
