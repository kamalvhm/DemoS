package com.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.cleanup.SlidingOlder;
//Normally Array or  String Questions and sasking for sub-array or sub-string 
public class SlidingWindow extends SlidingOlder {   /***********ALSO SEE IN PARENT CLASS******/
	/** Aditya verma  https://www.youtube.com/watch?v=EHCGAZBbB88&t=3s |
	 *  FOR BASIC PATTERN WITH CODE:-https://www.youtube.com/watch?v=KtpqeN0Goro&t=915s
	 * BOTH SLIDING WINDOWS HAVE THREE OPRATIONS -1.Raise THe window to the size 
	 * 2.CHECK if meets target 
	 * 3.THen finally reduce or increament
	 * @param args MORE PROBLEMS:-https://www.techiedelight.com/sliding-window-problems/ 
	 */
	//https://tinyfool.org/2019/04/the-sliding-window-algorithm/
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,8,1,1,13};
		
	//	System.out.print(triplet(a,3,15));
		
				// array of positive integers  find consucutive positions which is having sum
				int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
				int sum = 15;

				findSubarray(A, sum);
				
				int B[]= {12,-1,-7,8,-15,30,16,28};
				
				//printFirstNeg(B,3);
				
				//System.out.print(findAnagrams2("cbaeabc", "abc"));
				
	}
	
	  public static List<int[]> triplet(int[] n,int winS,int target) {   //## #WINDOW SIZE  KNOWN ###
			int right=0,left=0;
			int sum =0;
			List<int[]> list=new ArrayList<>();
				int currentSum=0;
			while(right<n.length) {
				
				currentSum+=n[right];    //STEP 1:CALCULATION
				
				if(right-left+1<winS) {  //STEP 2:
					right++;
				}
				
				else if(right-left+1==winS) {   //STEP 3 see in below example with fixed size
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
	
	
	 	 
		// Function to print sub-array having given sum using   		 ###WINDOW SIZE NOT KNOWN###
		// sliding window technique
			public static void findSubarray(int[] a, int sum)
			{
				
				int left=0,right=0;
				int currentSum=0;
				while(right<a.length) {
					currentSum+=a[right];   //STEP 1: calculations
					
					while(currentSum>=sum) {   //Step 2 :- check if the window size reaches equal or greater 
						if(currentSum==sum)    //if equal extract answer 
						System.out.printf("Subarray found [%d-%d]", left, right );
						
						currentSum-=a[left];  //slide window 
						left++;
						
					}
					right++;   
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
	 //76. Minimum Window Substring   ALSO SEE IN PARENT CLASS
	 public String minWindow3(String s, String t) {
	        int minLen = Integer.MAX_VALUE; String ans = "";
	        int count = 0; // counts how many t char's we've seen
	        Map<Character, Integer> map = new HashMap<>(); // char from t-> how often that char appears in window
	        // Put all t chars into map
	        for (char c : t.toCharArray()) {
	            map.put(c, map.getOrDefault(c, 0)+1);
	        }
	        
	        int r = 0; int l = 0;
	        while (r < s.length()) {
	            char rc = s.charAt(r);      //STEP 1:-CALCULATIONS
	            if (map.containsKey(rc)) { // contains letter in t
	                 map.put(rc, map.get(rc)-1);
	                if (map.get(rc) >= 0) count++;
	            }
	            
	            while (count == t.length()) {   //STEP 2 :- if equal extract answer and slide
	                // Update result
	                if (r-l+1 < minLen) { // look for a shorter window
	                    minLen = r-l+1;
	                    ans = s.substring(l, r+1);
	                }
	                
	                char lc = s.charAt(l);
	                if (map.containsKey(lc)) {
	                    map.put(lc, map.get(lc)+1);
	                    if (map.get(lc) > 0) count--;
	                }
	                l++;
	            }
	            r++;   //STEP 3:- RAISE WINDOW 
	        }
	        
	        return ans;
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