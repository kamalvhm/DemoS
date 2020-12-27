package problems.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.beans.TreeNode;
//https://www.bigocheatsheet.com/

//https://www.includehelp.com/algorithms/variants-of-binary-search.aspx
public class BinarySearch {
	public static void main(String args[]) {
		
		
		
		int[] a= {1,2,3,4,5,6,7,8,8,8,8,13};
		searchRange(a,8);
		System.out.println(find_first_occurrence(a, 8));
		System.out.println(find_last_occurrence(a, 8));
				
	}
    //CLASSIC BINEARY SEARCH													ONE
    private int classic(int[] nums, int target){
    	int l = 0;
    	int r = nums.length - 1;

    	while(l <= r){
    		int m = l + (r - l) / 2;
    		int v = nums[m];
    		if(v == target){
    			return m;
    		}else if(v < target){
    			l = m + 1;
    		}else{
    			r = m - 1;
    		}
    	}
    	return -1;
    }
   
    static int find_first_occurrence(int [] nums, int target)
	{	
		int N=nums.length;
        int left = 0, right =  N - 1;

	    int index =  N;
	    while (left <= right) {

	        int mid = left + (right - left) / 2;

	         if (nums[mid] >= target) {
	        	index=mid;
	            right = mid - 1;
	        }
	        else {
	            left = mid + 1;
	        }
	    }

	    return index;
	}
	
	static int find_last_occurrence(int [] nums, int target)
	{
		int N=nums.length;
        int left = 0, right =  N - 1;

	    int index =  N;
	    while (left <= right) {

	        int mid = left + (right - left) / 2;

	         if (nums[mid] <= target) {
	        	index=mid;
	        	left = mid + 1;
	           
	        }
	        else {
	        	 right = mid - 1;
	        }
	    }

	    return index;
	}
	
	//00000011111 first one is bad version so its sorted applying binary search;  ||||| Secound templet !!!!!!!!!!!
	 public int firstBadVersion(int n) {
		 //can be started with 0 also in some cases;
	      int left =1;
	      int right =n;
	        
	        while(left<right){
	            int mid=left+(right-left)/2;
	            if(!isBadVersion(mid))
	                left=mid+1;
	            else right =mid;
	        }
	        //left will always point to first 1 value 
	        return left;
	    }

	 public boolean isBadVersion(int m) {
		 
		return false; 
	 }
	 
	//TEMPLET 2 162. Find Peak Element    ||||| Secound templet !!!!!!!!!!!
	    public int findPeakElement(int[] nums) {
	        int left=0;
	        int right=nums.length-1;
	          
	          while(left<right){
	              int mid=left+(right-left)/2;
	              if(nums[mid]<nums[mid+1])
	                  left=mid+1;
	              else 
	                  right=mid;
	          }
	          return left;
	      }
	// <------------------------------------Questions from Now on----------------------------------------------->
	 /**
	  * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
		Output: [9,4]
		
	  * Each element in the result must be unique.
		The result can be in any order.
	  */
	  public int[] intersection(int[] nums1, int[] nums2) {
	        if(nums1.length==0 || nums1.length==0) return new int[0];
	        Set<Integer> set1=new HashSet<>();
	        
	        Arrays.sort(nums2);
	        
	        for(int i=0;i<nums1.length;i++){
	            int target =nums1[i];
	            
	            int res=Arrays.binarySearch(nums2,target);
	            
	            if(res>=0)
	                set1.add(nums2[res]);
	        }
	        
	        int[] result=new int[set1.size()];
	        int count=0;
	        for(int a:set1)
	           result[count++]=a;
	        
	        return result;
	        
	    }
	  
	  /**
	   * n = 5

		The coins can form the following rows:
		¤
		¤ ¤
		¤ ¤
		
		Because the 3rd row is incomplete, we return 2.
	  		n = 8

		The coins can form the following rows:
			¤
			¤ ¤
			¤ ¤ ¤
			¤ ¤

		Because the 4th row is incomplete, we return 3.
	   */
	  public int arrangeCoins(int n) {
		  /**
		   * for 1st 1 coint 2nd 2 coins and so on for k ,k coins so this is AP 1+2+3 ...k ,SUM FORMULA is [k(k+1)/2] <= n  
		   */
		  
	        long left = 0, right = n;
	        while (left <= right){
	            long mid = left + (right - left) / 2;
	            if (n >= (mid * (mid + 1) / 2)) left = mid + 1;
	            else right = mid - 1;
	        }
	        return (int)left - 1;
	    }
	  
	  /**
	   * 744. Find Smallest Letter Greater Than Target   !!!!Lower bound templete!!!!!
	   *letters = ["c", "f", "j"]
		target = "a"
		Output: "c"
	   */
	    public char nextGreatestLetter(char[] letters, char target) {
	        int left=0;
	        int right=letters.length;
	        
	   if(target >= letters[right - 1] || target < letters[0])
	            return letters[0];
	        
	        while(left<right){
	            int mid =left+(right-left)/2; 
	            
	            if(target >= letters[mid])
	                left=mid+1;
	            
	            else if(target < letters[mid]) right=mid;
	        }
	        return letters[left];
	    }
	        
/**
 * 704. Binary Search
 * 
 */
	    public static int search(int[] nums, int target) {
	        int left=0;
	        int right=nums.length-1;
	        
	        while(left<right){
	            int mid=left+(right-left)/2;
	            if(target==nums[mid])return mid;
	            if(target>nums[mid])
	                left=mid+1;
	            else if(target<nums[mid])
	                right=mid-1;
	        }
	        
	        return nums[left]==target?left:-1;
	    }
	    
	    
	    
	    //          *first  *secound-1 will be 8's last    
	    //1 2 3 4 5 8 8 8 8 9 5 6
	    //34. Find First and Last Position of Element in Sorted Array
	    public static int[] searchRange(int[] nums, int target) {
	        int[] bad = new int [] {-1,-1};
	         //first occurencen greater than target
	         int first = findFirst(nums,target);
	        // first occurence greatergreater than target+1 
	         int second = findFirst(nums,target+1) - 1;
	         if(second  >= first){
	             return new int[]{first,second};
	         }
	         
	        return bad; 
	     }
	     
	   private static int findFirst(int[]nums,int target){
	         int N = nums.length;
	         int first = N;
	         
	         int right = N  - 1;
	         int left = 0;
	         
	         while(left <= right){
	             int mid = left + (right - left)/2;
	             if(nums[mid] >= target){
	                 first = mid;
	                 right = mid - 1;
	             }else { //if(nums[mid] < target)
	                 left = mid + 1;
	             }
	         }
	        return first; 
	     }
	   
	  // 108. Convert Sorted Array to Binary Search Tree
	   //CALL         return bstRecurse(nums,0,nums.length-1);
	   public static TreeNode bstRecurse(int[] nums,int start,int end){
	        if(start>end)
	            return null;
	        int mid=start+(end-start)/2;
	        TreeNode current=new TreeNode(nums[mid]);
	        current.left=bstRecurse(nums,start,mid-1);
	        current.right=bstRecurse(nums,mid+1,end);
	        return current;
	    }
	   
	   //Leetcode templetes
	   

}

