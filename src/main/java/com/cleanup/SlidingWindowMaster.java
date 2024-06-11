package com.cleanup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import scala.xml.dtd.impl.WordExp.Letter;

public class SlidingWindowMaster {

	public static void main(String[] args) {
		//1)Return Maximum sum of subArray element of size 3 from below array;
			int [] arr1= {2,3,5,9,7,1};
			System.out.println("1)Max in SubArray(21):- "+maxInSubArray(arr1,3));
		//2)First Negative no in subArray of size K
			int [] arr2={ 12, -1, -7, 8, -15, 30, 16, 28 };
			System.out.print("2)First Negative in SubArray (-1-1-7-15-15):- ");
			firstNegative(arr2,3);
			System.out.println();
	    //3)Count Occurrence of Anagrams abc anagram are { cba, bca,acb,...} (always should be 3 chars in any order) 
			System.out.println("3)Count Occurrence of Anagrams [0,6]:-"+findAnagrams("cbaebabacd", "abc"));
		//4) Maximum of All SubArray of Size k :-return max value present in each window of size 3
			int arr3[] =  { 1, 3, -1, -3, 5, 3, 6, 7 };
			System.out.println("4) Maximum of All SubArray [3, 3, 5, 5, 6, 7] :-"+maximumInWindow(arr3,3));
			
		/****************************************VARIABLE SIZE*****************************************/
		//5) Longest Sub Array Of Sum K :-return longest subArray wich form SUM K
			int arr4[]= {4,1,1,1,2,3,5};
			System.out.println("5) Longest Sub Array Of Sum K (4):- "+longestSubArray(arr4,5));
		//6)Largest SubString with K unique Characters
			String str="aabacbebebe";
			System.out.println("6) Largest SubString with K unique Characters (cbebebe) Or (7):- "+largestSubStringWithKUnique(str,3));
			
		//7)Largest SubString without Repeating Character
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
	


	private static int firstNegative(int[] arr, int window) {
		int i=0,j=0;
		List<Integer> negatives=new ArrayList<>();
		while(j<arr.length) {
			if(arr[j]<0)
				negatives.add(arr[j]);
			if(j-i+1<window)
				j++;
			else if(j-i+1==window) {
				if(!negatives.isEmpty())
					System.out.print(negatives.get(0));
				if(negatives.contains(arr[i]))
					//negatives.remove(Integer.valueOf(arr[i]));
					negatives.remove(0);
				i++;
				j++;
			}
		}
		return 1;
	}
	
	private static int maxInSubArray(int[] arr, int window) {
		int max=0;
		int i=0,j=0;
		int currentSum=0;
		while(j<arr.length) {
			currentSum+=arr[j];
			if(j-i+1<window)
				j++;
			else if(j-i+1==window) {
				max=Math.max(max, currentSum);
				currentSum-=arr[i];
				i++;
				j++;
			}
		}
		return max;
	}

	//https://leetcode.com/problems/find-all-anagrams-in-a-string/
	  public static List<Integer> findAnagrams(String s, String p) {
	         List<Integer> ans = new ArrayList<>();
		     if(s.length() < p.length()) return ans;
	        
	        HashMap<Character,Integer> map=new HashMap<>();
	        for(char c:p.toCharArray())
	            map.put(c,map.getOrDefault(c,0)+1);
	        int count =map.size();//This is distinct letter count 
	        int left=0,right=0;
	        
	        int window=p.length();
	        while(right<s.length()){
	            char rightChar=s.charAt(right);
	            
	            if(map.containsKey(rightChar)){
	                int val=map.get(rightChar);
	                map.put(rightChar,--val);
	                if(val==0)
	                    count--;
	            }
	            
	            if(right-left+1<window)
	                right++;
	            else if(right-left+1==window){
	                if(count==0)
	                    ans.add(left);
	                
	                char leftChar=s.charAt(left);
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
//https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
	  private static int longestSubArray(int[] arr, int sum) {
			int i=0,j=0;
			int currentSum=0;
			int max =0;
			while(j<arr.length) {
				currentSum+=arr[j];
				if(currentSum<sum)
					j++;
				else if(currentSum==sum) {
					max=Math.max(max, j-i+1);
					j++;
				}else if(currentSum>sum) {
					while(currentSum>sum) {
						currentSum-=arr[i++];
						
					}
					if(currentSum==sum) //just in case we match sum while reducing window 
						max=Math.max(max, j-i+1);
					j++;
				}
			}
			return max;
		}

		private static List<Integer> maximumInWindow(int a[],int window){
			List<Integer> ans =new ArrayList<>();
			int left=0,right=0;
			int max=Integer.MIN_VALUE;
			
			PriorityQueue<Integer> pq=new PriorityQueue<>((b,c)->c-b);
			
			while(right<a.length) {
//				if(!pq.isEmpty() && a[right]>pq.peek()) {
//	        		while(!pq.isEmpty() &&  a[right]>pq.peek())
//	        			pq.poll();
//	        	}
				pq.add(a[right]);
				
				if(right -left+1<window)
					right++;
				else if(right-left+1==window) {

					if(!pq.isEmpty())
						ans.add(pq.peek());
					
					
					if(pq.contains(a[left])) {
						pq.remove(Integer.valueOf(a[left]));
						
					}
					left++;
					right++;
				}
			}
			return ans;
		}

		private static String largestSubStringWithKUnique(String s, int k) {
			int i=0,j=0;
			HashMap<Character,Integer> map=new HashMap<>();
			int max=0;
			String maxStr="";
			while(j<s.length()) { 
				char c=s.charAt(j);
				map.put(c, map.getOrDefault(c, 0)+1);
				
				if(map.size()<k)
					j++;
				else if(map.size()==k) {
					//max=Math.max(max, j-i+1);
					if(max<j-i+1) {
						max=j-i+1;
						maxStr=s.substring(i,j+1);
					}
					j++;
				}
				else if(map.size()>k) {
					while(map.size()>k) {
						char leftChar=s.charAt(i);
						int val=map.get(leftChar);
						if(--val==0)
							map.remove(leftChar);
						else map.put(leftChar, val);
						i++;
					}
					j++;
				}
			}
			//return max;
			return maxStr;
		}
		
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
		
		public static int LongestSubStringWithAllUniqueBKP(String s) {
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

}
