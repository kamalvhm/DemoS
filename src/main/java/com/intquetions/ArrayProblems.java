package com.intquetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class ArrayProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
       int [] a= {4,3,2,7,8,2,3,1};
       
    	int n = a.length;
    	   
    	int[] left =Arrays.copyOfRange(a, 0, n / 2);
    	int j=Arrays.binarySearch(a, 4);
       System.out.println(findDisappearedNumbers(a));
	}
	
		//448. Find All Numbers Disappeared in an Array
		public static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] stateArray = new boolean[nums.length + 1];

          List<Integer> result = new ArrayList<>();
          for (int i = 0; i < nums.length; i++) {
              stateArray[nums[i]] = true;
          }
          for (int i = 1; i < stateArray.length; i++) {
              if (stateArray[i] != true) {
                  result.add(i);
              }
          }

          return result;
          
      }
		//11. Container With Most Water  !!TWO POINTER!!
		public int maxArea(int[] height) {
	        int maxArea=0;
	        int i = 0,j=height.length-1;
	        
	       while(i<j){
	           int minHeight=Math.min(height[i] ,height[j]);
	           int width =j-i;
	           int area =minHeight*width;
	           if(area>maxArea)
	               maxArea=area;
	           if(height[i]<height[j])
	           {
	               i++;
	           }else{
	               j--;
	           }
	       }
	        return maxArea;
	        
	    }
		
		//26. Remove Duplicates from Sorted Array #*
		 public int removeDuplicates(int[] nums) {
		       int index=1;
		        for(int i=0;i<nums.length-1;i++){
		            if(nums[i]!=nums[i+1]){
		                nums[index++]=nums[i+1];
		            }
		        }
		        return index;
		    }
}
