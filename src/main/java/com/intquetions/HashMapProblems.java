package com.intquetions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//187. Repeated DNA Sequences | https://leetcode.com/problems/repeated-dna-sequences/
	  public List<String> findRepeatedDnaSequences(String s) {
	        List<String> result =new ArrayList<>();
	        if(s.length()==0 || s.length()<10) return result;
	        HashMap<String,Integer> seen =new HashMap<>();
	        int i=0;
	        while(i+10<=s.length()){
	            String subSeq=s.substring(i,i++ +10);
	            seen.put(subSeq,seen.getOrDefault(subSeq,0)+1);
	            
	            if(seen.get(subSeq)==2)
	                result.add(subSeq);
	        }
	        
	       return result;
	    }

}
