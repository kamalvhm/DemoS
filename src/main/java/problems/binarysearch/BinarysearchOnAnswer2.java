/**
 * 
 */
package problems.binarysearch;

/**
 * Problems where we can apply binary search on unsorted array also !!!! for example findPeak problem
 *
 */
public class BinarysearchOnAnswer2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Peek is 6 at pos = 5
		int [] f= {1,2,3,4,5,6,1,2,3,4,5};
		System.out.println(findPeakElement(f));
		
		int [] a= {1,2,3,4,5,6,1,2,3,4,5};
		
		//Binary search in 2D array
		
		int arr[][]= {{10,20,30,40},
					  {15,25,35,45},
					  {27,29,37,48},
					  {32,33,39,50}};
		//1-2 should be retured;
		System.out.print(Search2DArray(arr,29));
	}
	//Also known as max in BITONIC ARRAY (monotonically increaing then decreasing so only one peek in array 162. Find Peak Element)
/*	CHECK BELOW SOLUTION public static int findPeakElement(int[] a) {
	        int left=0;
	        int right=a.length-1;
	          
	          while(left<right){
	              int mid=left+(right-left)/2;
	              
	              if((mid==0 || a[mid-1]<a[mid]) && (mid==right || a[mid+1]<a[mid])) {
	            	  return mid;
	              }
	               if(a[mid]<a[mid+1])
	                  left=mid+1;
	              else 
	                  right=mid-1;
	          }
	          return left;
	      }*/
	
    public static int findPeakElement(int[] nums) {
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
	 
	 
	 public static int findSearchInBiotonicArray(int[] a,int target) {
	        int left=0;
	        int right=a.length-1;
	          
	          while(left<right){
	              int mid=left+(right-left)/2;
	              
	              if((mid==0 || a[mid-1]<a[mid]) && (mid==right || a[mid+1]<a[mid])) {
	            	  return mid;
	              }
	               if(a[mid]<a[mid+1])
	                  left=mid+1;
	              else 
	                  right=mid-1;
	          }
	          return left;
	      }
	 //https://www.youtube.com/watch?v=VS0BcOiKaGI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=20
	 //74. Search a 2D Matrix
	 public static String Search2DArray(int[][] a,int target) {
		 	int h=a.length;
		 	int l=a[0].length;
		 	int res=-1;
		 	int j=l-1;
		 	int i=0;  
		 	
		 	while(j<l && j>=0 && i>=0 && i<h) {
		 		int val=a[i][j];
		 		if(target==val) return i+"-"+j;
		 		else if(val>target) {
		 			j--;
		 		}else if(val<target) {
		 			i++;
		 		}
		 	}
		 	
		 	return res+"";
		 	
	      }

}
