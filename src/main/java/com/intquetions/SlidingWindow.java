package com.intquetions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SlidingWindow {
	/**https://www.youtube.com/watch?v=MW4lJ8Y0xXk  Aditya verma
	 * BOTH SLIDING WINDOWS HAVE THREE OPRATIONS -1.Raise THe window to the size 
	 * 2.CHECK if meets target 
	 * 3.THen finally reduce or increament
	 * @param args
	 */
	//https://tinyfool.org/2019/04/the-sliding-window-algorithm/
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,8,1,1,13};
		
		System.out.print(triplet(a,3,15));
		
				// array of positive integers  find consucutive positions which is having sum
				int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
				int sum = 15;

				findSubarray(A, sum);
	}
	
	public static List<int[]> triplet(int[] n,int winS,int target) {   //## #WINDOW SIZE  KNOWN ###
		int right=0;
		int sum =0;
		List<int[]> list=new ArrayList<>();
		for(int i=0;i<=n.length-winS;i++) {
			right=i+winS-1;
			//runs for fist sum then we just need to add one pos;
			if(sum==0) {
				int count=i;
				while(count<=right) {
					sum+=n[count++];
				}
			}else {
				sum+=n[right];
			}
			//if sum equals target add it to list
			if(sum==target) {
				int c=0;
				int[] a=new int[winS];
				for(int j=i;j<=right;j++)
					a[c++]=n[j];
				list.add(a);
			}
				
			sum-=n[i];
		}
		return list;
	}
	
	
	 	//https://www.techiedelight.com/find-subarray-having-given-sum-given-array/   ###WINDOW SIZE NOT KNOWN###
		// Function to print sub-array having given sum using
		// sliding window technique
			public static void findSubarray(int[] A, int sum)
			{
				// maintains sum of current window
				int windowSum = 0;

				// maintain a window [low, high-1]
				int high = 0;

				// consider every sub-array starting from low index
				for (int low = 0; low < A.length; low++)
				{
					// if current window's sum is less than the given sum,
					// then add elements to current window from right
					while (windowSum < sum && high < A.length)
					{
						windowSum += A[high];
						high++;
					}

					// if current window's sum is equal to the given sum
					if (windowSum == sum)
					{
						System.out.printf("Subarray found [%d-%d]", low, high - 1);
						return;
					}

					// At this point the current window's sum is more than the given sum
					// remove current element (leftmost element) from the window
					windowSum -= A[low];
				}
			}

	//Minimum Size Subarray Sum   get minimun no of element which is greater than s; ###WINDOW SIZE NOT KNOWN###
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
	 //The question of sliding window
	 //Minimum Window Substring get substring from s which contains all char from t min length ###WINDOW SIZE NOT KNOWN###
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
	 //76. Minimum Window Substring
	// https://leetcode.com/problems/minimum-window-substring/
	 //Minimum Window Substring get substring from s which contains all char from t min length ###WINDOW SIZE NOT KNOWN###
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
	            //reduce left while total ==0 its matching
	            while (totalFnd == 0) {
	                if (right- left + 1 < len) {
	                    res = s.substring(left, right + 1);
	                    len = right - left + 1; 
	                }
	                //reduing widow from left
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
