package com.intquetions;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class ArrayProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
       int [] a= {4,3,2,7,8,2,3,1};
       System.out.println(largestValueInArrayWITHDEVIDEANDCONQUER(a,0,a.length-1));
       /*
    	int n = a.length;
    	   
    	int[] left =Arrays.copyOfRange(a, 0, n / 2);
    	int j=Arrays.binarySearch(a, 4);
       System.out.println(findDisappearedNumbers(a));*/
       
       int[][] b={{0,0,0}};
       flipAndInvertImage(b);
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
		
		//26. Remove Duplicates from Sorted Array #*E
		 public int removeDuplicates(int[] nums) {
		       int index=1;
		        for(int i=0;i<nums.length-1;i++){
		            if(nums[i]!=nums[i+1]){
		                nums[index++]=nums[i+1];
		            }
		        }
		        return index;
		    }
		 
		 //832. Flipping an Image
		 public static int[][] flipAndInvertImage(int[][] A) {
		        int h=A.length;
		        int l=A[0].length;
		        int B[][]=new int [h][l];
		        
		        for(int i=0;i<h;i++){
		             for(int j=0;j<l;j++){
		                B[i][j]=toggle(A[i][(l-1)-j]);
		            }
		        }
		        return B;
		    }
		    public static int toggle(int a){
		        if(a==0)return 1;
		            else return 0;
		    }
		    
		    public static int largestValueInArray(int [] a,int arraysize) {
		    	if(arraysize==1) return a[0];
		    	else {
		    		int max=largestValueInArray(a,arraysize-1);
		    		if(max>a[arraysize-1]) return max;
		    		else return a[arraysize-1];
		    	}
		    	
		    } 
		    public static int largestValueInArrayWITHDEVIDEANDCONQUER(int [] a,int start,int end) {
		    	if(start==end) return a[start];
		    	else {
		    		int half=(start+end)/2;
		    		int left=largestValueInArrayWITHDEVIDEANDCONQUER(a,start,half);
		    		int right=largestValueInArrayWITHDEVIDEANDCONQUER(a,half+1,end);

		    		if(left>right)return left;
		    		else return right;
		    	}
		    	
		    } 
		    
		    //215. Kth Largest Element in an Array          !!!MEDIUM!!!    #*        HINT:- if Largest or smallest mentioned in problem use heaps
		    public int findKthLargest(int[] nums, int k) {
		        PriorityQueue<Integer> q=new PriorityQueue<Integer>();//min heap only kth lagest will remian at root rest mins will be removed as its min heap
		         for(int i:nums){
		             q.add(i);
		             if(q.size()>k)
		                 q.remove();
		         }
		         return q.remove();
		     }
		    
		    
}
