package problems.binarysearch;

import java.util.Arrays;

public class BasicBSProblems1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {20,17,15,14,12,10,8,2,1};
		System.out.print(searchBsInDescArray(a,2));
		//order agnostic array;
		int [] b= {1,2,3,4,5,5,5,6,7,8};
		System.out.print(bslast(b,6)-bsfirst(b,5));
		
		//Problem 1:- how many times a sorted array is rotated  ANS to below is 4
		//	Index  0  1  2   3 4 5 6 7   no of rotation = min value (pivot) index 
		int [] c= {11,12,15,18,2,5,6,8};
		System.out.print(arrayRotatedcount(c));

		//Problem 2:- find element in rotated array after we get min index from below we can apply binary search with 
		//index to get result
		//int minIndex=arrayRotatedcount(c);
		//floor of 5
		int [] d= {1,2,3,4,8,9,10,10,12};
		System.out.print(bsfloorofTarget(d,5));
		//NEXT Greater elemtn than target
		char [] e= {'a','b','e','g'};
		System.out.print(nextGreaterElement(e,'f'));
		
		//find element in infinite array  consider below as infinate 
		int [] f= {1,2,3,4,5,6,7,8,9,10,11};
		System.out.print(bsInfiniteArray(f, 7));
		
		

	}
	
	public static int searchBsInDescArray(int [] a,int target) {
		int left=0,right=a.length-1;
		while(left<right) {
			int mid =left+(right-left)/2;
			
			if(a[mid]==target) {
				return mid;
			}else if(target>a[mid]) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return -1;
	}
	
	public static int bsfirst(int [] a,int target) {
		int left=0,right=a.length-1;
		while(left<=right) {
			int mid =left+(right-left)/2;
			
			if((mid==0 || a[mid-1]<target) && a[mid]==target) {
				return mid;
			}else if(target>a[mid]) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return -1;
	}
	
	public static int bslast(int [] a,int target) {
		int left=0,right=a.length-1;
		while(left<=right) {
			int mid =left+right-left/2;
			int v =a[mid];
			if((mid==right || target<a[mid+1]) && v==target) {
				return mid;
			}else if(target<v) {
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
		return -1;
	}
	
	
	public static int arrayRotatedcount(int [] a) {
		int left=0,right=a.length-1;
		int n=a.length-1;
		while(left<=right) {
			int mid =left+(right-left)/2;
			int v =a[mid];
			//this % is for rotation
			int next=(mid+1)%n;
			//to avoid out of bound
			int pre=(mid+n-1)%n;
			
			if(a[mid]<=a[next] && a[mid]<=a[pre]) {
				return mid;
			}else if(a[left]<=a[mid]) {
				left=mid+1;
			}else if(a[mid]<=a[right]){
				right=mid-1;
			}
		}
		return -1;
	}
	//https://leetcode.com/problems/search-in-rotated-sorted-array/ |33. Search in Rotated Sorted Array
	public static int findElemntinRotatedArray(int [] a,int target) {
		int left=0,right=a.length-1;
		int n=a.length-1;
		while(left<=right) {
			if (a[left] <= a[right]) // array is sorted -> so return first ele.
				return a[left];
			int mid =left+(right-left)/2;
			int v =a[mid];
			//this % is for rotation
			int next=(mid+1)%n;
			//to avoid out of bound
			int pre=(mid+n-1)%n;
			
			if(a[mid]<=a[next] && a[mid]<=a[pre]) {
				return mid;
			}else if(a[left]<=a[mid]) {
				left=mid+1;
			}else if(a[mid]<=a[right]){
				right=mid-1;
			}
		}
		return -1;
	}
	
	//floor =greatest element less then target if taget not present
	public static int bsfloorofTarget(int [] a,int target) {
		int left=0,right=a.length-1;
		int res=-1;
		while(left<=right) {
			int mid =left+(right-left)/2;
			int v =a[mid];
			if(v==target) {
				return a[mid];
			}
			else if(v<target) {
				res= a[mid];
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return res;
	}
	
	public static char nextGreaterElement(char[] a, char target) {
		int start=0,end=a.length-1;
		char res='#';
		while(start<=end) {
			int mid=start+(end-start)/2;
			int v=a[mid]-'0';
			if(target-'0'<v) {
				res=a[mid];
				end=mid-1;
			}else {
				start=mid+1;
			}
			
		}
		return res;
		
	} 
	// we can give start as 0 but for to find out high we start with one and check with target if not enclosed within high and 
	//low we multiple hign by 2 ; 
	public static int bsInfiniteArray(int[] a, int target) {
		int start=0,end=1;
		//we are finding end first in infinite array
		while( a[end]<target && end<a.length ) {
			start=end;
			end=end*2;
		}
		
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target==a[mid]) {
				return mid;
			}
			else if(target>a[mid]) {
				start=mid+1;
			} else {
				end=mid-1;
			} 
			
		}
		return -1;
		
	} 
	
	
	
	

}
