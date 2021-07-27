package com.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.PriorityQueue;

import com.cleanup.SlidingOlder;
//Normally Array or  String Questions and asking for sub-array or sub-string 
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
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 1, 1, 13 };
		System.out.println(triplet(a, 3, 15));

		// array of positive integers find consucutive positions which is having sum
		int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
		int sum = 15;
		findSubarray(A, sum);
		
		System.out.println("FIRST NEGATIVES");

		int B[] = { 12, -1, -7, 8, -15, 30, 16, 28 };
		printFirstNeg(B,3);
		
		System.out.println(findAnagrams2("cbaeabc", "abc"));
		
		int c[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
		maximumInwindow(c, c.length, 3);
		System.out.println("");

		int d[] = { 4, 1,1,1,2,3,5 }; // given a array and sum k return max length of sub array which is having sum
		int e[] = {-5,8,-14,2,4,12 };									// k;
	//	System.out.println("V-7 Max sub array length :--> " + maxSubArrayLength(e, -5));
		
		//Return size of longest substring of S which is having exactly K unique character
		String s="aabacbebebe"; //longest with 3 unique char will be cbebebe so ans will be 7
		System.out.println("10)K unique char subString:--"+kUniqueSubString(s,3));
		
		String s1="bwwkew";  //return max string length with unique characters 
		System.out.println("11) LongestSubStringWithAllUnique:--"+LongestSubStringWithAllUnique(s));
		
		String s2="abaccab";
		System.out.println("12) Pick Toys :--"+pickToys(s2));
		
		String s3="TOTMTAPTAT";
		String t="TTA";//return subString size minwindow which contain all letters of t string(atleast) no matter countineus or discontinues;
		System.out.println("MinWindSubString:--->>"+minWindowSubString(s3,t));
		


	}


	public static List<int[]> triplet(int[] n,int winS,int target) {   //## #WINDOW SIZE  KNOWN ###
			int right=0,left=0;
			int sum =0;
			List<int[]> list=new ArrayList<>();
				int currentSum=0;
			while(right<n.length) {
				
				currentSum+=n[right];    //STEP 1:CALCULATION
				
				if(right-left+1<winS) {  //STEP 2:Raise window
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
						System.out.println( );

						currentSum-=a[left];  //slide window 
						left++;
						
					}
					right++;   
				}
			}
    //https://leetcode.com/problems/minimum-size-subarray-sum/
	// 209 Minimum Size Subarray Sum   get minimun no of element which is greater than s; ###WINDOW SIZE NOT KNOWN###
	public int minSubArrayLen(int s, int[] nums) {
			        int sum=0;
			        int n =nums.length;
			        int ans=n+1;
			        int i=0,j=0;
			        while(j<n){
			          sum+=nums[j];
			          if(sum<s)
			              j++;
			          else if(sum>=s){
			              while(sum>=s){
			                ans=Math.min(ans,j-i+1);
			                  sum-=nums[i++];

			              }
			              j++;
			          }
			        }
			        return ans==n+1 ? 0 : ans;
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
	 // 438. Find All Anagrams in a String
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
	 
	 //V-4 COMMON PATTERN FOR ALL FIXED SIZE WINDOW PROBLEMS CHECK STEPS 
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
			if(right-left+1==window) {   //IF ELSE IF NOT USED R++ is Not there if Else if there then in slid do Right ++ as well
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
	 //v-5 Count Occurrences Of Anagrams | Sliding Window | https://www.youtube.com/watch?v=MW4lJ8Y0xXk
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
	/* 239. Sliding Window Maximum int K size window  (NOTE BOOK)
		https://leetcode.com/problems/sliding-window-maximum/
	 */
	 
	  //https://www.youtube.com/watch?v=5VDQxLAlfu0
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return nums;
    
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
    
        for (int i = 0; i < nums.length; i++) {
            while (q.size() > 0 && nums[i] >= nums[q.getLast()]){
			    q.removeLast();
			}
            q.addLast(i);
            if (i - k + 1 >= 0) ans[i - k + 1] = nums[q.getFirst()];
        
            //finally remove max which is out of range
            if (i - k + 1 == q.getFirst()) q.removeFirst();
        }
             
        return ans;
    }
	//SAME AS ABOVE  https://www.youtube.com/watch?v=xFJXtB5vSmM&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=6
	public static void maximumInwindow(int [] arr,int size,int k) {
		int left=0,right=0;
		int maximum=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b.compareTo(a));
		while(right<size) {
			pq.add(arr[right]);
			
			if(right-left+1<k) {
				right++;
			}else if(right-left+1==k) {
				if(!pq.isEmpty())
					System.out.print(pq.peek()+", ");
				int leftVal=arr[left];
				if(pq.contains(leftVal))
					pq.remove(leftVal);
				
				left++;
				right++;
			}
		}
	}
	
	//(V-7)##############VARIABLE SIZE SLINDING WINDOW############################### 
	  private static int maxSubArrayLength(int[] arr, int k) {
		  int left=0,right=0;
		  int sum=0;
		  int maximum_size=0;
		  while(right<arr.length) {
			  sum+=arr[right];   //Step 1 :add sum
			  
			  if(sum<k)  //Step 2 : when inflate window until sum condition not satisfy 
				  right++;
			  else if(sum==k) //Step 3 :if sum equal exatract answer
			  { 
				  if(right-left+1>maximum_size)
					  maximum_size=right-left+1;
				  right++;
			  }
			  else if(sum>k) {//step 4 : if sum is greater then shink from left until its not (This condition we don't have in fixed size as we are always eithr less or equal never greater)
				  while(sum>k) {
					  sum-=arr[left++]; 
				  }
				  right++;// at end we have to move window 
			  }
			  
			  
		  }
			return maximum_size;
		}

	  //V-10 | https://www.youtube.com/watch?v=Lav6St0W_pQ
		private static int kUniqueSubString(String s, int k) {
			int i=0,j=0;
			HashMap<Character,Integer> map=new HashMap<>();
			int max=0;
			while(j<s.length()) {
				char c=s.charAt(j);
				map.put(c, map.getOrDefault(c, 0)+1);
				
				if(map.size()<k)
					j++;
				else if(map.size()==k) {
					max=Math.max(max, (j-i+1));
					j++;
				}else if(map.size()>k) {
					while(map.size()>k) {
						char l=s.charAt(i);
							if(map.containsKey(l))
							{
								int val=map.get(l);
								if(val>1) //remove if count turns to 0;
									map.put(l, --val);
								else map.remove(l);
								i++;

							}
						}
					j++;
				}
			}
			
		return max;
	}
		
	//V-11 | https://www.youtube.com/watch?v=L6cffskouPQ  SAME as previous ||3. Longest Substring Without Repeating Characters TESTED
	public static int LongestSubStringWithAllUnique(String s) {
			int i=0,j=0;
			HashMap<Character,Integer> map=new HashMap<>();
			int max=0;
			while(j<s.length()) {
				char c=s.charAt(j);
				map.put(c, map.getOrDefault(c, 0)+1);
				if(map.size()>(j-i+1))//comparing map size with window size as all window characters should be unique !!!!THIS CAN BE IGNORED NOT VALID !!!!
				{
					j++;
				}else if(map.size()==(j-i+1)) {
					max =Math.max(max, map.size());
					j++;
				}else if(map.size()<(j-i+1)) { // < change from last ** suppose window contains pww then map size 2 window size 3 this mean we have w repeating in map so pop from behind
					while (map.size()<(j-i+1)) {
						char l=s.charAt(i);
						if(map.containsKey(l)) {
							int val=map.get(l);
							if(val>1)
								map.put(l, --val);
							else 
								map.remove(l);
							i++;
						}
					}
					j++;
				}
				
			}
			return max;
	}
	//THIS QUETION IS ALSO CAN BE SOLVED BY CALLING "kUniqueSubString(s,2);"
	public static int pickToys(String s) {
		//USE CODE OR CALL COMMENTED METHOD
		//return kUniqueSubString(s,2);
		int i=0,j=0;
		final int MAX_TYPE=2;//types of toys allowed 
		HashMap<Character,Integer> map=new HashMap<>();
		int max=0;
		while(j<s.length()) {
			char c=s.charAt(j);
			map.put(c, map.getOrDefault(c, 0)+1);
			
			if(map.size()<MAX_TYPE) {
				j++;
			}else if(map.size()==MAX_TYPE) {
				max=Math.max(max, j-i+1);
				j++;
			}else if(map.size()>MAX_TYPE) {
				while(map.size()>MAX_TYPE) {
					char l=s.charAt(i);
					if(map.containsKey(l)) {
						int v=map.get(l);
						if(v>1)
							map.put(l, --v);
						else map.remove(l);
						i++;
					}
				}
				j++;
			}
		}
		return max;
	}
	//https://www.youtube.com/watch?v=iwv1llyN6mo
	private static int minWindowSubString(String s, String t) {
		HashMap<Character,Integer> map=new HashMap<>();
		
		for(char c:t.toCharArray()) 
			map.put(c,map.getOrDefault(c, 0)+1);
		
		int i=0,j=0;
		int count=map.size();
		int windowSize=Integer.MAX_VALUE;
		while(j<s.length()) {
			char c=s.charAt(j);
			if(map.containsKey(c)) {
				int val=map.get(c);
				map.put(c, --val);
				if(map.get(c)==0)
					count--;
			}
			if(count>0)
				j++;
			else if(count==0) {
			windowSize=Math.min(windowSize,j-i+1);
			while(count==0) {
				char ch=s.charAt(i);
				if(map.containsKey(ch)) {
					int val=map.get(c);
					map.put(c, ++val);
					if(map.get(c)>0)
						count++;
				}
				i++;
			}
				j++;
			}
		}
		
		return windowSize;
	}
	//1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
	 public int longestSubarray(int[] nums, int limit) {
	        int l=0,r=0,count=0;
	        PriorityQueue<Integer> min = new PriorityQueue<>();
	        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->Integer.compare(b,a));
	        
	        while(r<nums.length){
	            min.add(nums[r]);
	            max.add(nums[r]);
	            
	            while(Math.abs(max.peek()-min.peek())>limit){
	                min.remove(nums[l]);
	                max.remove(nums[l]);
	                l++;
	            }
	            count=Math.max(count,r-l+1);
	            r++;
	        }
	        
	        return count;
	    }
	 
	 
	 private static String largestSubStringWithKUnique(String s, int k) {
			int i=0,j=0;
			int max=0;
			String ans="";
			HashMap<Character,Integer> map=new HashMap<>();
			while(j<s.length()) {
				char rc=s.charAt(j);
				map.put(rc, map.getOrDefault(rc, 0)+1);
				if(map.size()<k)
					j++;
				else if(map.size()==k) {
					if(j-i+1>max) {
						max=j-i+1;
						ans=s.substring(i,j+1);
					}
					j++;
				}
				else if(map.size()>k) {
					 while(map.size()>k) {
						 char lc=s.charAt(i);
						 int val=map.get(lc);
						 if(--val==0)
							 map.remove(lc);
						 else map.put(lc, val);
						 i++;
					 }
					 j++;
				}
			}
			return ans;
		}
}
