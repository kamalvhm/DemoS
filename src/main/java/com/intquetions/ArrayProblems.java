package com.intquetions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Coding Ninjas:-https://www.youtube.com/watch?v=ibf7OBHbRlI | https://dynalist.io/d/f8y9_YRZW6Kt5-hLfqkW3kDS
/**
		 * PRACTICE IN MORNING :-https://leetcode.com/problems/sort-colors/submissions/
		
		287. Find the Duplicate Number
		
		41. First Missing Positive 
		
		442. Find All Duplicates in an Array https://www.youtube.com/watch?v=iiYc32-4ZJY

 *
 */

public class ArrayProblems {

	public static void main(String[] args) {
		//CONVERSION 
		int[] nums={4,3,2,7,8,2,3,1};
		List ip= Arrays.asList(nums);
		Integer[] numsAgain=(Integer[])ip.toArray();
        
       int [] a= {4,3,2,7,8,2,3,1};
       System.out.println(largestValueInArrayWITHDEVIDEANDCONQUER(a,0,a.length-1));
       /*
    	int n = a.length;
    	   
    	int[] left =Arrays.copyOfRange(a, 0, n / 2);
    	int j=Arrays.binarySearch(a, 4);
       System.out.println(findDisappearedNumbers(a));*/
       
       int[][] b={{0,0,0}};
       flipAndInvertImage(b);
       
      int[][] matrix = {{1,2,3}
      				   ,{4,5,6}
      				   ,{7,8,9}};
      System.out.println(spiralOrder(matrix));//Printing matrix in a spiral
      
      
      //Find MISSIN and DUPLICATE nos in array;SWAP SORT NEED https://www.youtube.com/watch?v=KOsS5-1q9rU&list=PL_z_8CaSLPWdJfdZHiNYYM46tYQUjbBJx&index=2
      int ar[]= {1,4,3,4,5}; //4 is duplicate and 2 is missing
      // we need to equation here to find two variable ex .arr {a,e,b,c,d,e} and 1 to N is {a ,b ,c ,d ,e} so 1 st is 
      // sum of 1to N minus array sum that will give us b-e ,secound is Now same equal minus with squares 
      // a2 b2 c2 d2 e2 - a2 e2 b2 c2 d2 e2 will give b2-e2 by solving math of both we can solve this but here we will discuss 
      //swap sort where we will arrange array such that i index contains i+1 value  so start from 0 nd check if its on correct spot if not swap this 
      //with correct spot https://leetcode.com/problems/find-the-duplicate-number/
      System.out.print(findDupUsingSlowFast(ar));
      
      
      
      
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
		
		//448. Find All Numbers Disappeared in an Array
		  public List<Integer> findDisappearedNumbers2(int[] nums) {
		        List<Integer> result=new ArrayList<>();
		        for(int i=0;i<nums.length;i++){
		            int index=Math.abs(nums[i]);
		            if(nums[index-1]>0){
		                nums[index-1]=-nums[index-1];
		            }
		        }
		        
		         
		        for(int j=0; j<nums.length;j++){
		            if(nums[j]>0)
		                result.add(j+1);
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
		//167. Two Sum II - Input array is sorted !!TWO POINTER!!
		public int[] twoSum(int[] numbers, int target) {
		       int[] res =new int[2];
		       int i=0,j=numbers.length-1;
		        while(i<j){
		            int delta=numbers[i]+numbers[j];
		            if(delta==target){
		                res[0]=i+1;
		                res[1]=j+1;
		                return res;
		            }else if(delta>target)
		                j--;
		            else i++;
		        }
		        return new int []{-1,-1};
		    }
		//15. 3 Sum      !!TWO POINTER!!
		  public List<List<Integer>> threeSum(int[] nums) {
		        //https://www.youtube.com/watch?v=h9F6RFXdwCo&feature=youtu.be
		       List<List<Integer>> result =new ArrayList<>();
		       if(nums.length<3)return result;
		        Arrays.sort(nums);
		        for(int i=0;i<nums.length;i++){
		            if(i!=0 && nums[i]==nums[i-1])continue;//to avoid duplicate at i  [-2,0,0,2,2]  0th is i and 1th is lo and last is hi
		            int cur=nums[i];
		            int lo=i+1,hi=nums.length-1;
		            while(lo<hi){
		                int sum=cur+nums[lo]+nums[hi];
		                if(sum==0)
		                {
		                    
		                    result.add(Arrays.asList(new Integer[]{cur,nums[lo],nums[hi]}));
		                    lo++;
		                    while(lo<hi && nums[lo]==nums[lo-1])//to avoid duplicate at i se top example where next value is also 0 
		                        lo++;
		                    hi--;
		                    while(lo<hi && nums[hi]==nums[hi+1])//as we already lowerd hi so we are checking hi and hi+1
		                        hi--;
		                        
		                }else if(sum<0)
		                    lo++;
		                else hi--;
		            }
		        }
		        return result;
		    }
		  
		  //18. 4Sum
		  public List<List<Integer>> fourSum(int[] nums, int target) {
		        
		        Arrays.sort(nums);
		        
		         Set<List<Integer>> map=new HashSet<>();
		        
		        for(int i=0;i<nums.length-3;i++){
		          
		    
		            for(int j=i+1;j<nums.length-2;j++){
		               
		             int left=j+1;
		             int right=nums.length-1;
		                
		                while(left<right){
		                    
		                    int sum =nums[i]+nums[j]+nums[right]+nums[left];
		                    
		                    if(sum==target){
		                        List<Integer> l=new ArrayList<Integer>();
		                        l.add(nums[i]);
		                        l.add(nums[j]);
		                        l.add(nums[left]);
		                        l.add(nums[right]);
		                        map.add(l);
		                        left++;
		                        right--;
		                        
		                        while(left<right && nums[left]==nums[left-1])
		                            left++;
		                        
		                        while(left<right && nums[right]==nums[right+1])
		                            right--;
		                        
		                    }
		                    
		                    if(sum<target)
		                        left++;
		                    if(sum>target)
		                        right--;
		                }
		            
		         }  
		            
		        }
		        return new ArrayList(map);
		        
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
		    
		    //54. Spiral Matrix ||| ALSO 59. Spiral Matrix II Check :-https://leetcode.com/problems/spiral-matrix-ii/
		    public static List<Integer> spiralOrder(int[][] matrix) {
		        List<Integer> nums=new ArrayList<>();
		        if(matrix==null || matrix.length==0)return nums;
		        int top=0;
		        int bottom =matrix.length-1;
		        int left=0;
		        int right=matrix[0].length-1;
		        
		        int size=matrix.length*matrix[0].length;//total element in matrix
		        //when added element is less then totalelement
		        while(nums.size()<size){
		            for(int i=left;i<=right && nums.size()<size;i++){
		                nums.add(matrix[top][i]);
		            }
		            top++;
		            for(int i=top;i<=bottom && nums.size()<size;i++){
		                nums.add(matrix[i][right]);
		            }
		            right--;
		            for(int i=right;i>=left && nums.size()<size;i--){
		                nums.add(matrix[bottom][i]);
		            }
		            bottom--;
		            for(int i=bottom;i>=top && nums.size()<size;i--){
		                nums.add(matrix[i][left]);
		            }
		            left++;
		        }
		        return nums;
		    }
		    
// Keep note of the index being visited and then return if already visited ||x. Find the Duplicate Number  https://www.youtube.com/watch?v=32Ll35mhWg0
	public static int findDuplicate(int[] nums) {
		int n = nums.length;
		int duplicate = n;
		for (int i = 0; i < n; i++) {
			int x = (nums[i] > n) ? nums[i] - n : nums[i];
			if (nums[x] > n) {
				duplicate = x;
				break;
			} else
				nums[x] += n;
		}
		return duplicate;

	}
	
	 public static int findDupUsingSlowFast(int[] nums) {
		        if (nums == null || nums.length ==0) return -1;
	        
	        int slow = nums[0];
	        int fast = nums[slow];
	        while(slow != fast ) {
	            slow = nums[slow];
	            fast = nums[nums[fast]];
	        }
	        
	        slow = 0;
	        while(slow != fast) {
	            slow = nums[slow];
	            fast = nums[fast];
	        }
	        return slow;
	    }
		    
     //41. First Missing Positive  O(1) space TC is O(n). https://www.youtube.com/watch?v=-lfHWWMmXXM&t=555s
	  public int firstMissingPositive(int[] nums) {
		     for(int i=0; i<nums.length; ){
		            int indexNum = nums[i] - 1;
					
					// if number is in range and is not a duplicate (basically swap index position to place it to its correct index means 3
		            //will go to third index) if its on correct position or greater then i++
		            if(indexNum >= 0 && indexNum < nums.length && nums[i] != nums[indexNum])
		                swap(nums, i, indexNum);
		            else i++;
		        }
		        
		        for(int i=0; i < nums.length; i++){
		            if(nums[i] - 1 != i)
		                return i + 1;
		        }
		        return nums.length + 1;
		  }
		    
		    public void swap(int nums[],int i,int j){
		        int temp=nums[i];
		        nums[i]=nums[j];
		        nums[j]=temp;
		    }
		    
		    //75. Sort Colors | DUTCH NATIONAL FLAG ALGO |https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2
		    public void sortColors(int[] nums) {
		        int low=0;
		        int mid=0;
		        int high=nums.length-1;
		        while(mid<=high){
		            if(nums[mid]==0)
		                swap(nums,low++,mid++);
		            else if(nums[mid]==1)
		                mid++;
		            else {
		                swap(nums,high,mid);
		                high--;
		            }
		            
		        }
		        
		    }
		    //442. Find All Duplicates in an Array | https://www.youtube.com/watch?v=iiYc32-4ZJY
		    /**
		     *
		   	Tips for beginners : Whenever you encounter a scenario when given array values a[i] is in range [1,n] or [0,n-1] then most probabily you can achieve the O(1) solution by modifiying the values of the array.

			In this question we are modifiying the sign of the element to keep track that element is visited or not [instead of using HashSet]
		     */
		    
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]); // get the original number by removing - sign if visited
			if (nums[num - 1] > 0)
				nums[num - 1] = -nums[num - 1]; // sign change to negative (visit)
			else
				list.add(num); // if sign has been already changed(visited) then current number is duplicate
		}
		return list;
	}
	
	
	 //53. Maximum Sub array  Easy  KADANE's ALGO
	 public int maxSubArray(int[] nums) { //https://www.youtube.com/watch?v=w_KEocd__20&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5
	        int sum=0;
	        int max=nums[0];
	        for(int i=0;i<nums.length;i++){
	            sum+=nums[i];
	            max=Math.max(max,sum);
	            if(sum<0)
	                sum =0;
	        }
	        return max;
	    }
    public int maxSubArray2(int[] nums) {
        if(nums.length==1)return nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>0)nums[i]+=nums[i-1];
            if(nums[i]>max)
                max=nums[i];
        }
        return max;
    }
    //56. Merge Intervals
    public int[][] merge(int[][] intervals) {
        List<int []> result=new ArrayList<>();
        
        if(intervals==null || intervals.length==0)return result.toArray(new int[0][]);
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        int start=intervals[0][0];
        int end=intervals[0][1];
        
        for(int [] i:intervals){
            if(i[0]<=end){
                end=Math.max(end,i[1]);
            }else {
                result.add(new int[] {start,end});
                start=i[0];
                end=i[1];
            }
            
        }
        result.add(new int[] {start,end});
        return result.toArray(new int[0][]);
    }
	
    //https://www.codingninjas.com/studio/problems/number-of-inversions_6840276?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
    static int count=0; 
    public static int numberOfInversions(int []a, int n) {
        mergesort(a);
        return count;
    }

    public static int[] mergesort(int a[]){
        int n=a.length; 
        if(n<=1)return a;
        int left[]=mergesort(Arrays.copyOfRange(a, 0, n/2));
        int right[]=mergesort(Arrays.copyOfRange(a, n/2, n));
        return merge(left,right,a);
    }
    public static int[] merge(int left[],int right[],int a[]){
        int nL=left.length; 
        int nR=right.length;
        int mid=nL-1;
        int i=0,j=0,k=0;
        while(i<nL && j<nR){
            if(left[i]<=right[j]){
                a[k++]=left[i++];
            }else {
                count+=(mid-i+1);
                a[k++]=right[j++];
            }
        }

        while(i<nL)
            a[k++]=left[i++];

        while(j<nR)
            a[k++]=right[j++]; 
        return a;

    }
    

//    public static int numberOfInversions(int []a, int n) {
//       
//        return  mergesort(a);
//    }
//
//    public static int mergesort(int a[]){
//        int n=a.length; 
//        int count=0;
//        if(n<=1)return count;
//        int left[]=Arrays.copyOfRange(a, 0, n/2);
//        int right[]=Arrays.copyOfRange(a, n/2, n);
//        count+=mergesort(left);
//        count+=mergesort(right);
//        count+=merge(left,right,a);
//        return count;
//    }
//    public static int merge(int left[],int right[],int a[]){
//        int nL=left.length; 
//        int nR=right.length;
//        int mid=nL-1;
//        int i=0,j=0,k=0;
//        int count=0;
//        while(i<nL && j<nR){
//            if(left[i]<=right[j]){
//                a[k++]=left[i++];
//            }else {
//                count+=(mid-i+1);
//                a[k++]=right[j++];
//            }
//        }
//
//        while(i<nL)
//            a[k++]=left[i++];
//
//        while(j<nR)
//            a[k++]=right[j++]; 
//        
//        return count;
//    }
    
	//Reverse Pairs
    public static int mergeSort(int a[]){
        int n=a.length; 
        int count=0;
        if(n<=1)return count;
        int left[]=Arrays.copyOfRange(a, 0, n/2);
        int right[]=Arrays.copyOfRange(a, n/2, n);
        count+=mergeSort(left);
        count+=mergeSort(right);
        count+=countPairs(left,right);
        merge3(left,right,a);
        return count;
    }
    public static void merge3(int left[],int right[],int a[]){
        int nL=left.length; 
        int nR=right.length;
        int mid=nL-1;
        int i=0,j=0,k=0;

        while(i<nL && j<nR){
            if(left[i]<=right[j]){
                a[k++]=left[i++];
            }else {
                a[k++]=right[j++];
            }
        }

        while(i<nL)
            a[k++]=left[i++];

        while(j<nR)
            a[k++]=right[j++]; 
        
    }


    public static int countPairs(int[] a,int b[]) {
        int n=a.length;
        int m=b.length;
        int mid=n-1;
        int low=0;
        int right = 0;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= m-1 && a[i] > 2 * b[right]) right++;
            cnt += (right );
        }
        return cnt;
    }

}
