package com.intquetions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinarySearch {
	//00000011111 first one is bad version so its sorted applying binary search;
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
}
