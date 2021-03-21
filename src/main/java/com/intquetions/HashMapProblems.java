package com.intquetions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> map =new HashMap<Integer,String>();
		int [] arr= {60,60,60};
		numPairsDivisibleBy60(arr);
		

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
	  //Brute force
	  public int numPairsDivisibleBy602(int[] time) {
	        int count = 0, n = time.length;
	        for (int i = 0; i < n; i++) {
	            // j starts with i+1 so that i is always to the left of j
	            // to avoid repetitive counting
	            for (int j = i + 1; j < n; j++) {
	                if ((time[i] + time[j]) % 60 == 0) {
	                    count++;
	                }
	            }
	        }
	        return count;
	    }
	  
	  //It select pairs of two no which total to 60 multiple and returns the count of such pairs  
	 // 1010. Pairs of Songs With Total Durations Divisible by 60
	public static int numPairsDivisibleBy60(int[] time) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int t : time) {
			if (map.containsKey(((60 - t % 60)) % 60)) {  //double % is to handle [60,60,60] zero case 60-60%60 is 60 but we need to look for zero as its already 60 so double % is there 
				count += map.get((60 - t % 60) % 60);
			}
			map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
		}
		return count;
	}

}
