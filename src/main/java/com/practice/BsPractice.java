package com.practice;

import java.util.Arrays;
//CODE COMAPRE with in class BinarySearch,BasicBSProblems1,BinarysearchOnAnswer2
public class BsPractice {

	public static void main(String[] args) {
		//Simple binary search + variation of first and last 
		int [] h= {5,7,7,8,8,8,8,9,10};
		System.out.println("1)-(7):- "+search(h,9));
		
		int [] b= {1,2,3,4,5,5,5,6,7,8};
		//first is lower bound 
		System.out.println("2) first (4):- "+bsfirst(b,5)+"-last (6):- "+bslast(b,5));
		//ANS:-5
		int [] f= {1,2,3,4,5,6,7,4,3,2,1};
		System.out.println("3) Peak (6)-> "+findPeakElement(f));
		
		//Problem 1:- how many times a sorted array is rotated  ANS to below is 4
				//	Index  0  1  2   3 4 5 6 7   no of rotation = min value (pivot) index 
		int [] c= {11,12,15,18,2,5,6,8};
		System.out.println("4) Rotated(4)---->>> "+arrayRotatedcount(c));
		
		int d[]= {4,5,6,7,0,1,2};
		System.out.println("5) Find in Rotated(4)---->>> "+findElemntinRotatedArray(d,0));
		
		//Binary search in 2D array
		int arr[][]= {{10,20,30,40},
					  {15,25,35,45},
					  {27,29,37,48},
					  {32,33,39,50}};
		//2-1 should be retured;
		System.out.println("6) 2D-(2-1)-> "+Search2DArray(arr,29));
		
		//find element in infinite array  consider below as infinate 
		int [] k= {1,2,3,4,5,6,7,8,9,10,11};
		System.out.println("7) Infinite---(6)>>"+bsInfiniteArray(k, 7));
		
		int [] a= {20,17,15,14,12,10,8,2,1};
		System.out.println("8) Desc (7) "+searchBsInDescArray(a,2)); //ANS:-7
		//LOWER BOUND first value of x that is greater then equal to x
		int [] g= {2,3,5,6,8,10,12};
		System.out.println("Lower Bound of 4 is (5):- "+lowerBound(g,4));
		//order agnostic array;
		//floor of 5 :-last value that is smaller or equal to 5 
		int [] D= {1,2,3,4,8,9,10,10,12};//upper bound problem with variation
		System.out.println("FLOOR (4)"+bsfloorofTarget(D,5));
		//NEXT Greater element than target
		char [] e= {'a','b','e','g'};
		System.out.print("NEXT (g)"+nextGreaterElement(e,'f'));
		
		//CHECK Find Minimum in Rotated Sorted Array II
		
	}

	private static int search(int[] a, int i) {
		int l=0,r=a.length-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(a[mid]==i)return mid;
			else if(a[mid]<i)
				l=mid+1;
			else r=mid-1;
		}
				
		return -1;
	}
	
	public static int bsfirst(int [] a,int i) { 
		int l=0,r=a.length-1;
		int index=a.length-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(a[mid]>=i) {
				index=mid;
				r=mid-1;
			}else l=mid+1;
		}
		return index;
	}
	
	public static int bslast(int [] a,int i) {
		int l=0,r=a.length-1;
		int index=0;
		while(l<=r) {
			int mid=l+(r-l)/2; 
			if(a[mid]<=i) {
				index=mid;
				l=mid+1;
			}else r=mid-1;
		}
		return index;
	}
	
	public static int findPeakElement(int[] a) {
		int l=0,r=a.length-1;
		while(l<r) {
			int mid=l+(r-l)/2;
			if(a[mid]<a[mid+1])
				l=mid+1;
			else r=mid-1;
		}
		return l;
	}
	
	public static int arrayRotatedcount(int[] a) { 
		
		return -1;
	}

	public static int bsInfiniteArray(int[] a, int target) {
		int start=0;
		int end=1;
		while(a[end]<target && end<a.length) {
			start=end;
			end*=2;
		}
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(a[mid]==target)return mid;
			else if(target>a[mid])
				start=mid+1;
			else end=mid-1;
		}
		
		return -1;
	}
	
	public static int searchBsInDescArray(int [] a,int target) {
		int l=0,r=a.length-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(a[mid]==target)return mid;
			else if(a[mid]<target)
				r=mid-1;
			else l=mid+1;
		}
		return -1;
	}
	
	public static int findElemntinRotatedArray(int [] a,int target) { // 4 5 6 7 8 1 2 3 | 6
		int l=0,r=a.length-1;
		int first=a[0];
		while(l<=r) {
			int mid=l+(r-l)/2;
			int value=a[mid];
			if(value==target)return mid;
			boolean i_m_big=value>=first;
			boolean targetBig=target>=first;
			if(i_m_big==targetBig) {
				if(value<target)
					l=mid+1;
				else r=mid-1;
			} else if(i_m_big)
					l=mid+1;
			else r=mid-1;
			
		}
		return -1;
	}
	//first element that is greater then or equal to target
	public static int lowerBound(int [] a,int target) {
		int l=0,r=a.length-1;
		int ans=-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(a[mid]>=target) {
				ans=a[mid];
				r=mid-1;
			}else l=mid+1;
		}
		return ans;
	}
	
	//floor =greatest element less then target if target not present 
	public static int bsfloorofTarget(int [] a,int target) {
		int l=0,r=a.length-1;
		int ans=-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(a[mid]<=target) {
				ans=a[mid];
				l=mid+1;
			}else r=mid-1;
		}
		return ans;
	}
	
	//UPPER BOUND PROBLEM Erricto
	public static char nextGreaterElement(char[] a, char target) {
		int l=0,r=a.length-1;
		char res='#';
		while(l<=r) {
			int mid=l+(r-l)/2;
			char val=a[mid];
			if(val>=target) {
				res=val;
				r=mid-1;
			}else l=mid+1;
		}
		return res;
		
	} 
	
	 public static int findSearchInBiotonicArray(int[] a,int target) {
	        int left=0;
	      
	        return left;
	      }
	 //https://www.youtube.com/watch?v=VS0BcOiKaGI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=20
	 //74. Search a 2D Matrix
	 public static String Search2DArray(int[][] a,int target) {   
		 	int i=0,j=a[0].length-1;
		 	while(i>=0 && i<a.length && j>=0 && j<a[0].length) {
		 		int val=a[i][j];
		 		if(val==target)return i+"--"+j;
		 		else if(val<target)
		 			i++;
		 		else j--;
		 	}
		 	return " ";
	 }
	 

	 
	public int findMin(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];
		if (nums[0] <= nums[n - 1])
			return nums[0];
		int l = 0, r = n - 1;
		while (l <= r) {
			if (nums[l] <= nums[r]) // array is sorted -> so return first ele.
				return nums[l];
			int mid = l + (r - l) / 2;

			int next = (mid + 1) % n;
			int prev = (mid + n - 1) % n;

			if ((nums[mid] <= nums[next]) && (nums[mid] <= nums[prev]))
				return nums[mid];
			else if (nums[l] <= nums[mid])
				l = mid + 1;
			else if (nums[mid] <= nums[r])
				r = mid - 1;
		}
		return -1;
	}
	

	 

}
