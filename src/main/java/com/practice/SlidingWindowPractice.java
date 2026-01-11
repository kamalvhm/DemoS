package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import scala.xml.dtd.impl.WordExp.Letter;

public class SlidingWindowPractice {
	//@link{com.cleanup.SlidingWindowMaster}
	//https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
	public static void main(String[] args) {
		//1)Return Maximum sum of subArray element of size 3 from below array;
			int [] arr1= {2,3,5,9,7,1};
			System.out.println("1)Max in SubArray(21):- "+maxInSubArray(arr1,3));
		//2)First Negative no in subArray of size K
			int [] arr2={ 12, -1, -7, 8, -15, 30, 16, 28 };
			System.out.print("2)First Negative in SubArray (-1-1-7-15-15):- ");
			firstNegative(arr2,3);
			System.out.println();
	    //3)Count Occurrence of Anagrams abc anagram are { cba, bca,acb,...} (always should be 3 chars in any order can't bee more than 3 chars) 
			System.out.println("3)Count Occurrence of Anagrams [0,6]:-"+findAnagrams("cbaebabacd", "abc"));
		//4) Maximum of All SubArray of Size k :-return max value present in each window of size 3
			int arr3[] =  { 1, 3, -1, -3, 5, 3, 6, 7 };
			System.out.println("4) Maximum of All SubArray [3, 3, 5, 5, 6, 7] :-"+maximumInWindow(arr3,3));
			
		/****************************************VARIABLE SIZE*****************************************/
		//5) Longest Sub Array Of Sum K :-return longest subArray size which form SUM K
			int arr4[]= {4,1,1,1,2,3,5};
			System.out.println("5) Longest Sub Array Of Sum K (4):- "+longestSubArray(arr4,5));
		//6)Largest SubString with K unique Characters
			String str="aabacbebebe";
			System.out.println("6) Largest SubString with K unique Characters (cbebebe) Or (7):- "+largestSubStringWithKUnique(str,3));
			
		//7)Largest SubString without Repeating Character ans will be 3 as KEW with all unique
			String str2="bwwkew";
			System.out.println("7) Largest SubString without Repeating Character(3):- "+LongestSubStringWithAllUnique(str2));
			
	
		//8)PickToys Rule 1:- pick continues from Rack ,Rule 2 :-Can only pick two types of toys
			String s2="abaccab";
			System.out.println("12) Pick Toys (4):-"+pickToys(s2));
		//9)Minimum Window SubString
			String s3="TOTMTAPTAT";
			String t="TTA";//return subString size minwindow which contain all letters of t string(atleast) no matter continues or discontinues;
			System.out.println("9)Minimum Window SubString (6):-"+minWindowSubString(s3,t));
		 
			
	}
	//https://leetcode.com/problems/sliding-window-maximum/ or
	private static int maxInSubArray(int[] arr, int window) {
		int i=0,j=0;
		int currentSum=0;
		int max=0;
		while(j<arr.length) {
			currentSum+=arr[j];
			if(j-i+1<window)
				j++;
			else if(j-i+1==window) {
				max=Math.max(currentSum, max);
				currentSum-=arr[i];
				i++;
				j++;
			}
		}
		return max;
	}
	//Brute
//	public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
//        ArrayList<Integer> ans=new ArrayList<>();
//        int n=arr.length;
//		for(int i=0;i<=n-k;i++) {
//			int max=0;
//			for(int j=i;j<i+k;j++) {
//				max=Math.max(max, arr[j]);
//			}
//			ans.add(max);
//		}
//		return ans;
//    }
	//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1  or https://www.naukri.com/code360/problems/first-negative-integer-in-every-window-of-size-k_1164406
	private static int firstNegative(int[] arr, int window) {
		int i=0,j=0;
		List<Integer> neg=new ArrayList<>();
		while(j<arr.length) {
			if(arr[j]<0) {
				neg.add(arr[j]);
			}
			if(j-i+1<window)
				j++;
			else if(j-i+1==window) {
			if(!neg.isEmpty())
				System.out.print(neg.get(0)+"");
				if(neg.contains(arr[i])) {
					neg.remove(0);
				}
				i++;
				j++;
			}
		}
		return 1;
	}

	//https://leetcode.com/problems/find-all-anagrams-in-a-string/
	  public static List<Integer> findAnagrams(String s, String p) {
			List<Integer> ans=new ArrayList<>();
		  	int i=0,j=0;
		  	HashMap<Character,Integer> hm=new HashMap<>();
		  	for(char ch:p.toCharArray())
		  		hm.put(ch, hm.getOrDefault(ch, 0)+1);
		  	int count=hm.size();
		  	while(j<s.length()) {
		  		char ch=s.charAt(j);
		  		if(hm.containsKey(ch)) {
		  			int val=hm.get(ch);
		  			hm.put(ch, --val);
		  			if(val==0) 
		  				count--;
		  		}
		  		if(j-i+1<p.length()) //window size should be fixed so can't check with count ,from count we will check only ans
		  			j++;
		  		
		  		else if(j-i+1==p.length()) {
		  			if(count==0)
		  				ans.add(i);
		  			char lch=s.charAt(i);
		  			if(hm.containsKey(lch)) {
		  				int val=hm.get(lch);
		  				if(val==0)
		  					count++;
		  				hm.put(lch, ++val);

		  			}
		  			i++;
		  			j++;
		  			
		  		}
		  	}
		  		
		  	return ans;
	    }
	  //anagram alternate 
	  int search(String pat, String txt) {
	        int cnt=0,l=0;
	        HashMap<Character,Integer> map=new HashMap<>();
	        for(char ch:pat.toCharArray()){
	            map.put(ch,map.getOrDefault(ch,0)+1);
	        }
	        int count=map.size();
	        for(int r=0;r<txt.length();r++){
	            char chr=txt.charAt(r);
	            if(map.containsKey(chr)){
	                map.put(chr,map.get(chr)-1);
	                if(map.get(chr)==0)count--;
	            }
	            if(r-l+1==pat.length()){
	                if(count==0)
	                    cnt++;
	                char chl=txt.charAt(l);
	                if(map.containsKey(chl)){
	                    map.put(chl,map.get(chl)+1);
	                    if(map.get(chl)==1)count++;
	                }
	                l++;
	            }
	        }
	        
	        return cnt;
	        
	    }
	  
		private static List<Integer> maximumInWindow(int nums[],int k){
	        ArrayList<Integer> ans=new ArrayList<>();
	        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
	        int i=0,j=0;
	        while(j<nums.length) {
	        	pq.offer(nums[j]);
	        	if(j-i+1<k)
	        		j++;
	        	else if(j-i+1==k) {
	        		if(pq.size()>0) {
	        			ans.add(pq.peek());
	        		}
	        		int val=nums[i];
	        		if(pq.contains(val)) {
	        			pq.remove(val);
	        		}
	        		i++;
	        		j++;
	        	}
	        	
	        }
			return ans;
		}


	  private static int longestSubArray(int[] arr, int k) {
			int max=0;
			int sum=0;
			int i=0,j=0;
			while(j<arr.length) {
				sum+=arr[j];
				if(sum<k)
					j++;
				else if(sum>=k) {
					if(sum==k)
						max=Math.max(max, j-i+1);
					while(sum>k) {
						sum-=arr[i];
						i++;
					}
					j++;
				}
			}
			return max;
		}

	
	private static String largestSubStringWithKUnique(String s, int k) {
			String res="";
			HashMap<Character,Integer> hm=new HashMap<>();
			int i=0,j=0;
			int max=0;
			while(j<s.length()) {
				char ch=s.charAt(j);
				hm.put(ch, hm.getOrDefault(ch, 0)+1);
				if(hm.size()<k)
					j++;
				else if(hm.size()==k) {
					if(j-i+1>max) {
						max=j-i+1;
						res=s.substring(i,j+1);
					}
					j++;
				}else if(hm.size()>k) {
					while(hm.size()>k) {
						char lch=s.charAt(i);
						if(hm.containsKey(lch)) {
							int val=hm.get(lch);
							if(--val==0)
								hm.remove(lch);
							else hm.put(lch, val);
						}
						i++;
					}
					j++;
				}
			}
			return res;
	}
		
	//Optimized version
	 public int longestKSubstr(String s, int k) {
			int max=-1,l=0;
			HashMap<Character,Integer> map=new HashMap<>();
			for(int r=0;r<s.length();r++) {
				char chr=s.charAt(r);
				map.put(chr, map.getOrDefault(chr, 0)+1);
				if(map.size()>k){
				    char chl=s.charAt(l);
				    if(map.containsKey(chl)){
				        map.put(chl,map.get(chl)-1);
				        if(map.get(chl)==0)map.remove(chl);
				    }
				    l++;
				}
				if(map.size()==k)
				    max=Math.max(max,r-l+1);
			}
			return max;
     
     
 }
	public static int LongestSubStringWithAllUnique(String s) {
		int i=0,j=0;
		HashMap<Character,Integer> map=new HashMap<>();
		int max=0;
		while(j<s.length()) {
			char ch=s.charAt(j);
			map.put(ch, map.getOrDefault(ch, 0)+1);
			if(map.size()<j-i+1) {
				while(map.size()<j-i+1) {
					char lch=s.charAt(i);
					int val=map.get(lch);
					if(--val==0)
						map.remove(lch);
					else map.put(lch, val);
					i++;
				}
				j++;
			}
			else if(map.size()==j-i+1) {
				max=Math.max(max,j-i+1);
				j++;
			}
		}
		return max;
	}
		public static int pickToys(String s) {
			HashMap<Character,Integer> map=new HashMap<>();
			int i=0,j=0;
			int max=0;
			while(j<s.length()) {
				char rch=s.charAt(j);
				map.put(rch, map.getOrDefault(rch, 0)+1);
				if(map.size()<2)
					j++;
				else if(map.size()==2) {
					max=Math.max(max, j-i+1);
					j++;
				}
				else if(map.size()>2) {
					while(map.size()>2) {
						char lch=s.charAt(i);
						int val=map.get(lch);
						if(--val==0)
							map.remove(lch);
						else map.put(lch, val);
						i++;
					}
					j++;
				}
			}
			return max;
		}
		//https://www.youtube.com/watch?v=iwv1llyN6mo
		private static int minWindowSubString(String s, String t) {
			HashMap<Character,Integer> map=new HashMap<>();
			for(char ch:t.toCharArray()) {
				map.put(ch, map.getOrDefault(ch, 0)+1);
			}
			int count=map.size();
			int i=0,j=0;
			int min=Integer.MAX_VALUE;
			while(j<s.length()) {
				char rch=s.charAt(j);
				if(map.containsKey(rch)) {
					int val=map.get(rch);
					if(--val==0) {
						count--;
					}
					map.put(rch, val);
				}
				if(count>0)
					j++;
				else if(count==0) {
					min=Math.min(min, j-i+1);
					while(count==0) {
						char lch=s.charAt(i);
						if(map.containsKey(lch)) {
							int val=map.get(lch);
							if(val==0) {
								count++;
							}
							map.put(lch, ++val);
						}
						i++;
					}
					j++;
				}
			}
			return min;
		}
		
		
		private static String largestSubStringWithKUniqueBKP(String s, int k) {
			int max=0;
			int i=0,j=0;
			String res="";
			HashMap<Character,Integer> map=new HashMap<>();
			while(j<s.length()) {
				char c=s.charAt(j);
				map.put(c, map.getOrDefault(c, 0)+1);
				if(map.size()<k)
					j++;
				else if(map.size()==k) {
					if(j-i+1>max) {
						max=j-i+1;
						res=s.substring(i,j+1);
					}
					j++;
				}else if(map.size()>k) {
					while(map.size()>k) {
						char lc=s.charAt(i);
						if(map.containsKey(lc)) {
							int val=map.get(lc);
							val=val-1;
							if(val==0)
								map.remove(lc);
							else map.put(lc, val);
						}
						i++;
					}
					j++;
				}
			}
			return res;
		}
		
		public static int LongestSubStringWithAllUniqueBKP(String s) {
			int i=0,j=0;
			HashMap<Character,Integer> map=new HashMap<>();
			int max=0;
			while(j<s.length()) {
				char c=s.charAt(j);
				map.put(c, map.getOrDefault(c, 0)+1);
				 if(map.size()==j-i+1) {
					max=Math.max(max, j-i+1);
					j++;
				}else if(map.size()<j-i+1) {
					while(map.size()<j-i+1) {
						char cl=s.charAt(i);
						int val=map.get(cl);
						if(--val==0)
							map.remove(cl);
						else map.put(cl, val);
						i++;
					}
					j++;
				}
				
			}
			return max;
		}
		
		public static int pickToysBKp(String s) {
			//USE CODE OR CALL COMMENTED METHOD
			//return kUniqueSubString(s,2);
			int i=0,j=0;
			final int MAX_TYPE=2;//types of toys allowed 
			HashMap<Character,Integer> map=new HashMap<>();
			int max=0;
			while(j<s.length()) {
				char rc=s.charAt(j);
				map.put(rc, map.getOrDefault(rc, 0)+1);
				
				if(map.size()<MAX_TYPE) {
					j++;
				}else if(map.size()==MAX_TYPE) {
					max=Math.max(max, j-i+1);
					j++;
				}else if(map.size()>MAX_TYPE) {
					while(map.size()>MAX_TYPE) {
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
			return max;
		}

		private static int minWindowSubStringBKP(String s, String t) {
			HashMap<Character,Integer> map=new HashMap<>();
			for(char c :t.toCharArray())
				map.put(c, map.getOrDefault(c, 0)+1);
			int count=map.size();
			int i=0,j=0;
			int min=Integer.MAX_VALUE;
			while(j<s.length()) {
				char lc=s.charAt(j);
				if(map.containsKey(lc)) {
					int val=map.get(lc);
					if(--val==0)
						count--;
					map.put(lc, val);
				}
				if(count>0)
					j++;
				else if(count==0) {
					min=Math.min(min, j-i+1);
					while(count==0) {
						char rc=s.charAt(i);
						if(map.containsKey(rc)) {
							int val=map.get(rc);
							if(++val==0)
								count++;
							map.put(rc, val);
						}
						i++;
					}
					j++;
				}
			}
			return min;
		}
}
