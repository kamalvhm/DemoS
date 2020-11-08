package com.intquetions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
//Normally Array or  String Questions and sasking for sub-array or sub-string 
public class SlidingWindow {
	/** Aditya verma  https://www.youtube.com/watch?v=EHCGAZBbB88&t=3s
	 * BOTH SLIDING WINDOWS HAVE THREE OPRATIONS -1.Raise THe window to the size 
	 * 2.CHECK if meets target 
	 * 3.THen finally reduce or increament
	 * @param args
	 */
	//https://tinyfool.org/2019/04/the-sliding-window-algorithm/
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,8,1,1,13};
		
	//	System.out.print(triplet(a,3,15));
		
				// array of positive integers  find consucutive positions which is having sum
				int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
				int sum = 15;

				//findSubarray(A, sum);
				
				int B[]= {12,-1,-7,8,-15,30,16,28};
				
				//printFirstNeg(B,3);
				
				System.out.print(findAnagrams2("cbaeabc", "abc"));
				
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
	 //***The question of sliding window
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
	 /*****************************************ADITYA BELOW*********************************/
	 //438. Find All Anagrams in a String
	 public List<Integer> findAnagrams(String s, String p) {
	        int[] map = new int[26];
	        List<Integer> ans = new ArrayList<>();
	        if(s.length() < p.length()) return ans;
			//initialize map
	        for(int i = 0; i < p.length(); i++){
	            map[p.charAt(i) - 'a']++;
	            map[s.charAt(i) - 'a']--;
	        }
	        for(int i = 0, j = i + p.length();; i++,j++){
	            Boolean isAna = true;
	            for(int n : map){
	                if(n != 0) {
	                    isAna = false;
	                    break;
	                }
	            }
	            if(isAna) ans.add(i);
	            if(j >= s.length()) break;
	            map[s.charAt(i) - 'a']++;
	            map[s.charAt(j) - 'a']--;
	        }
	        return ans;
	    }
	 
	 //COMMON PATTERN FOR ALL FIXED SIZE WINDOW PROBLEMS CHECK STEPS 
	 //print first -Ve no in every window size k  in given array |  https://www.youtube.com/watch?v=uUXXEgK2Jh8      ADITYA 
	 public static void printFirstNeg(int[] arr, int window) {
		int left=0;
		int right=0;
		List<Integer> negatives=new ArrayList<>();
		
		while(right<arr.length) {
			//STEP 1:-calculations  for Details of Fixed sized example check the NoteBook
			if(arr[right]<0)
				negatives.add(arr[right]);
			//STEP 2 :- if window is less increase window size 
			if(right-left+1<window) {
				right++;
			}
			//STEP3:- if window size matches do following its inside same loop ****VERY IMPORTANT*****
			if(right-left+1==window) {
				//SUB STEP 3.1 get the answer 
				if(!negatives.isEmpty())
				System.out.print(negatives.get(0)+", ");
				else System.out.print("0, ");
			
			//SUB STEP 3.2 slide window
			if(negatives.contains(arr[left])) {
				negatives.remove(0);
				}
			left++;
			}
		}
	 }
	 //Count Occurrences Of Anagrams | Sliding Window | https://www.youtube.com/watch?v=MW4lJ8Y0xXk
	 public static List<Integer> findAnagrams2(String s, String p) {     //## #WINDOW SIZE  KNOWN ###
	        List<Integer> ans = new ArrayList<>();
	        if(s.length() < p.length()) return ans;
	        
	        HashMap<Character,Integer> map=new HashMap<>();
	        for(char c : p.toCharArray()) {
	        	map.put(c, map.getOrDefault(c,0)+1);
	        }
	        //variable so that we don't have to hit map many times 
	        int count=map.size();
	        int right=0,left=0;
	        int windowSize=p.length();
	    	while(right<s.length()) {
	    		char key=s.charAt(right);
	    		
	    		 if(map.containsKey(key)){
	                   int val=map.get(key);
	                
	                	   map.put(key, --val);
	                       if(val==0)
	                           count--;
	                   
	               }
	    		 
	    		 if(right-left+1<windowSize) {
	 				right++;
	 			}
	    		 
	    		 else if(right-left+1==windowSize){  // ##########THIS ELSE IF IMPORTANT**************************
	    			 if(count==0) {
	    				 ans.add(left);
	    			 }
	                 char leftChar = s.charAt(left);
	                 if(map.containsKey(leftChar)){
	                     int val=map.get(leftChar);
	                     if(val==0)
	                         count++;
	                     map.put(leftChar,++val);
	                 }
	    			 
	                 left++;
	                 right++;
	             }
	    		
	    	}
	    	return ans;
	 }
	 
	 public static List<int[]> triplet2(int[] n,int winS,int target) {   //## #WINDOW SIZE  KNOWN ###
			int right=0,left=0;
			int sum =0;
			List<int[]> list=new ArrayList<>();
				int currentSum=0;
			while(right<n.length) {
				
				currentSum+=n[right];   //STEP 1
				
				if(right-left+1<winS) {  //STEP 2
					right++;
				}
				
				else if(right-left+1==winS) {    //STEP 3   ##########THIS ELSE IF IMPORTANT**************************
					if(currentSum==target) {
						int i=left,k=0;
						int a[]=new int[right-left+1];
						while(i<=right)
							a[k++]=n[i++];
						list.add(a);		
					}
					currentSum-=n[left];
					left++;
					right++;
				} 
			}
			
			
			return list;
		}
}
