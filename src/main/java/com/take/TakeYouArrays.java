package com.take;

import java.util.HashMap;
import java.util.Map;

public class TakeYouArrays {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//A2Z series Array Easy Problems 'Longest subarray with given sum K(positives)'
	 public static int getLongestSubarray(int []a, long k) {
	        int n = a.length; // size of the array.

	        Map<Long, Integer> preSumMap = new HashMap<>();
	        long sum = 0;
	        int maxLen = 0;
	        for (int i = 0; i < n; i++) {
	            //calculate the prefix sum till index i:
	            sum += a[i];

	            // if the sum = k, update the maxLen:
	            if (sum == k) {
	                maxLen = Math.max(maxLen, i + 1);
	            }

	            // calculate the sum of remaining part i.e. x-k:
	            long rem = sum - k;

	            //Calculate the length and update maxLen:
	            if (preSumMap.containsKey(rem)) {
	                int len = i - preSumMap.get(rem);
	                maxLen = Math.max(maxLen, len);
	            }

	            //Finally, update the map checking the conditions:
	            if (!preSumMap.containsKey(sum)) {
	                preSumMap.put(sum, i);
	            }
	        }

	        return maxLen;
	    }


}
