package problems.binarysearch;

import java.util.Arrays;

public class BasicBSProblems1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a= {20,17,15,14,12,10,8,2,1};
		System.out.println(searchBsInDescArray(a,2));
		//order agnostic array;
		int [] b= {1,2,3,4,5,5,5,6,7,8};
		System.out.println(bslast(b,6)-bsfirst(b,5));
		
		//Problem 1:- how many times a sorted array is rotated  ANS to below is 4
		//	Index  0  1  2   3 4 5 6 7   no of rotation = min value (pivot) index 
		int [] c= {11,12,15,18,2,5,6,8};
		System.out.println(arrayRotatedcount(c));

		//Problem 2:- find element in rotated array after we get min index from below we can apply binary search with 
		//index to get result
		//int minIndex=arrayRotatedcount(c);
		//floor of 5
		int [] d= {1,2,3,4,8,9,10,10,12};
		System.out.println(bsfloorofTarget(d,5));
		//NEXT Greater elemtn than target
		char [] e= {'a','b','e','g'};
		System.out.println(nextGreaterElement(e,'f'));
		
		//find element in infinite array  consider below as infinate 
		int [] f= {1,2,3,4,5,6,7,8,9,10,11};
		System.out.println(bsInfiniteArray(f, 7));
		
		

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
	//USE BInarySearch Methods for first nad last
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
	//153. Find Minimum in Rotated Sorted Array || also check for different solution for hard 154.
	/* public static int arrayRotatedcount(int[] nums) {
			int n = nums.length;
			
			int l = 0, r = n - 1;
			while (l <= r) {
				if (nums[l] <= nums[r]) // array is sorted -> so return first ele.
					return nums[l];
				int mid = l + (r - l) / 2;

				int next = (mid + 1) % n;
				int prev = (mid + n - 1) % n;

				if ((nums[mid] <= nums[next]) && (nums[mid] <= nums[prev]))
					return mid;
				else if (nums[l] <= nums[mid])
					l = mid + 1;
				else if (nums[mid] <= nums[r])
					r = mid - 1;
			}
			return -1;
		}*/
	 
	 //Templet 2 :- target not given and we have to compare imidiet right or last element
//	 public static int arrayRotatedcount(int[] nums) {
//		 	int left = 0, right = nums.length - 1;
//	        while (left < right) {
//	            int mid = left + (right - left)/2;
//	            if (nums[mid] > nums[nums.length - 1]) {
//	                left = mid + 1;
//	            } else {
//	                right = mid;
//	            }
//	        }
//	        return nums[left];
//	}
	//Erricto Code for rotated array ,as array is rotated so we identify condition by comparing with either first or last 
	// values we have to omit with first as (value>=first) in this case if array is not rotated then we won't have false 
	//so compare should be mid>last
	 public static int arrayRotatedcount(int[] nums) {
	        int l=0,r=nums.length-1;
	        int ans=-1;
	        while(l<=r){
	            int mid=l+(r-l)/2;
	            if(nums[mid]>nums[nums.length-1]){
	                l=mid+1;
	            }
	            else {
	                ans=nums[mid];
	                r=mid-1;
	            }
	        }
	        return ans;
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
	//https://www.youtube.com/watch?v=84a8fQp5hJA
	public static int findElemntinRotatedErricto(int [] nums,int target) {
		 int n=nums.length;
	        if(n==0)
	            return -1;
	        int low=0,high=n-1;
	        int first=nums[0];
	        while(low<=high){
	            int mid=low+(high-low)/2;
	            int value=nums[mid];
	            if(value==target)
	                return mid;
	            boolean im_big=value>=first;
	            boolean target_big=target>=first;
	            if(im_big==target_big){//this mean both value and target in same side
	                if(value<target)
	                    low=mid+1;
	                else high=mid-1;
	            }else {
	                if(im_big){
	                    low=mid+1;
	                }else high=mid-1;
	            }
	            
	        }
	        return -1;
	}
	//ALWAYs think about condition by putting MID in True element (where condition satisfy) then think where to go from there left or right
	//floor =greatest element less then target if target not present
	public static int bsfloorofTarget(int [] a,int target) {
		int left=0,right=a.length-1;
		int res=-1;
		while(left<=right) {
			int mid =left+(right-left)/2;
			int v =a[mid];
			if(v==target) {
				return a[mid];
			}
			else if(v<target) { //IN LOWER/UPPER BOUND PROBLEM this condition try to think to include potential ans
				//for example in arr 1 2 3 4 8 10 10 12 19 mid is 8  so target 5 is smaller then 8 but for lowerbound we are 
				//finding last value from left True if target is not there so think apporching this condition from left 
				// which is what if value is smaller then target then it potential and we have to look for right side for next best
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
