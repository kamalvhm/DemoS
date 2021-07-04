package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import scala.xml.dtd.impl.WordExp.Letter;

public class SlidingWindowPractice {
	//@link{com.cleanup.SlidingWindowMaster}
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
			System.out.println("12) Pick Toys (4):--"+pickToys(s2));
		//9)Minimum Window SubString
			String s3="TOTMTAPTAT";
			String t="TTA";//return subString size minwindow which contain all letters of t string(atleast) no matter continues or discontinues;
			System.out.println("9)Minimum Window SubString (6):-"+minWindowSubString(s3,t));
		 
			
	}
	
	private static int maxInSubArray(int[] arr, int window) {
		int i=0,j=0;
		int maxSum=0;
		int currentSum=0;
		while(j<arr.length) {
			currentSum+=arr[j];
			//calc
			if(j-i+1<window)
				j++;
			else if(j-i+1==window) {
				maxSum=Math.max(maxSum, currentSum);
				currentSum-=arr[i];
				i++;
				j++;
			}
		}
		return maxSum;
	}
	
	private static int firstNegative(int[] arr, int window) {
		return 1;
	}

	//https://leetcode.com/problems/find-all-anagrams-in-a-string/
	  public static List<Integer> findAnagrams(String s, String p) {
		  	int i=0,j=0;
		  
	       return new ArrayList<Integer> ();
	    }

	  private static int longestSubArray(int[] arr, int sum) {
			int i=0,j=0;
			int max=Integer.MIN_VALUE;
			int currentSum=0;
			while(j<arr.length) {
				currentSum+=arr[j];
				if(currentSum<sum)
					j++;
				else if(currentSum==sum) {
					max=Math.max(max, j-i+1);
					j++;
				}else if(currentSum>sum) {
					while(currentSum>sum) {
						currentSum-=arr[i];
						i++;
					}
					j++;
				}
			}
			return max;
		}

		private static List<Integer> maximumInWindow(int a[],int window){
			List<Integer> ans =new ArrayList<>();
			int i=0,j=0;
			PriorityQueue<Integer> maxHeap=new PriorityQueue<>((c,b)->b-c);
			while(j<a.length) {
				maxHeap.add(a[j]);
				if(j-i+1<window)
					j++;
				else if(j-i+1==window) {
					ans.add(maxHeap.peek());
					maxHeap.remove(0);
					i++;
					j++;
				}
			}
			return ans;
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
		
		public static int LongestSubStringWithAllUnique(String s) {
			int i=0,j=0;
			HashMap<Character,Integer> map=new HashMap<>();
			int max=0;
			String ans="";
			while(j<s.length()) {
				char rc=s.charAt(j);
				map.put(rc, map.getOrDefault(rc, 0)+1);
				
				if(map.size()==j-i+1) {
					if(max<j-i+1)
					{
						max=j-i+1;
						ans=s.substring(i,j+1);
					}
					j++;
				}else if(map.size()<j-i+1) {
					while(map.size()<j-i+1) {
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
		public static int pickToys(String s) {
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

}
