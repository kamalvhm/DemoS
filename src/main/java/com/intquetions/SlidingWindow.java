package com.intquetions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SlidingWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Minimum Size Subarray Sum   get minimun no of element which is greater than s;
	 public static int minSubArrayLen(int s, int[] nums) {
	        int n = nums.length;
	        int ans = n+1;
	        int left = 0, right = 0;
	        int sum = 0;
	        while(right<n) {
	            sum+=nums[right++];
	            while(sum>=s) {
	                sum-=nums[left++];
	                ans = Math.min(ans,right-left+1);
	            }
	        }
	        return (ans==n+1)?0:ans;
	    }
	 
	 //Minimum Window Substring get substring from s which contains all char from t min length
	 public String minWindow(String s, String t) {
		    Map<Character, Integer> countMap = new HashMap<>();
				for(char c :t.toCharArray()) {
					countMap.put(c, countMap.getOrDefault(c, 0)+1);
				}
				int currentLength = t.length() ;
				int minWindow = Integer.MAX_VALUE ;
				int right = 0 ;
				int left = 0 ;
				int minleft = 0 ;
				while(right < s.length()) {
					char c = s.charAt(right);
					if(countMap.containsKey(c)) {
						countMap.put(c, countMap.get(c)-1);
					}
					if(Objects.nonNull(countMap.get(c)) && countMap.get(c)>=0) {
						currentLength-- ;
					}
					while(currentLength == 0) {
						if(minWindow > right-left+1) {
							minWindow = right-left+1;
							minleft = left ;
						}
						/**
						 * Moving left towards i. And further reducing minimum window.
						 * e.g if s="ADOBECODEBANC" and t = "ABC" 
						 * minWindow can be found in "ADOBEC" and "ODEBANC". and left will be at position 0 i.e. A. 
						 * As soon as code reaches "A" in String "ODEBANC" we will left moving left. 
						 * And left will reach "ADOBEC" of "ADOBEC". reducing minimum window.
						 * After reaching "C" in "ADOBEC" again left will left reducing and will reach to B in "ODEBANC"
						 */
						Integer leftValue = countMap.get(s.charAt(left));
						if(Objects.nonNull(leftValue)) {
							if(leftValue == 0) {
								break ;
							}
							countMap.put(s.charAt(left), leftValue+1);
						}
						left++;
					}
					right++;
				}
				return minWindow != Integer.MAX_VALUE ? s.substring(minleft, minleft+minWindow) : "";  
		    }
	 
	 
	 
	 public String minWindow2(String s, String t) {
	        HashMap<Character, Integer> map = new HashMap<>();
	        for (char c : t.toCharArray())
	            map.put(c, map.getOrDefault(c, 0) + 1);
	        
	        int totalFnd = t.length();
	        String res = "";
	        int len = Integer.MAX_VALUE;
	        int left = 0;
	        for (int right = 0; right < s.length(); right++) {
	            char c = s.charAt(right);
	            if (map.containsKey(c)) {
	                int numChar = map.get(c) - 1;
	                map.put(c, numChar);
	                
	                if (numChar >= 0)
	                    totalFnd--;
	            }
	            
	            while (totalFnd == 0) {
	                if (right- left + 1 < len) {
	                    res = s.substring(left, right + 1);
	                    len = right - left + 1; 
	                }

	                char jChar = s.charAt(left);
	                if (map.containsKey(jChar)) {
	                    int numJChar = map.get(jChar) + 1;
	                    map.put(jChar, numJChar);

	                    if (numJChar > 0)
	                        totalFnd++;
	                }
	                left++;
	            }
	        }
	        
	        return res;
	    }
}
