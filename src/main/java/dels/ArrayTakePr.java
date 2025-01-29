package dels;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import org.apache.zookeeper.server.quorum.Leader;

public class ArrayTakePr { 

	public static void main(String[] args) {
		
		int [] qA1= {1,2,4,7,7,5}; 
		System.out.println("1) Secound largest element without sort [5] :- "+secoundLargest(qA1));
		
		System.out.println("2) is Array sorted [false] :- "+isSorted(qA1));
		
		int [] qA2= {1,1,2,2,3,3}; 
		System.out.print("3) Remove duplicate from sorted "+Arrays.toString(qA2)+" array [3] :- "+removeDuplicate(qA2));
		System.out.println(" Array Now:- "+Arrays.toString(qA2));	

		int [] qA4= {1,2,3,4,5}; //For Right Rotation check leet code question
		System.out.print("4) Left Rotate "+Arrays.toString(qA4)+" Array  [3,4,5,1,2] :- ");
		rotate(qA4,2);
		System.out.println(" Array Now:- "+Arrays.toString(qA4));
		
		int [] qA5= {1,2,0,0,3,4}; 
		System.out.print("5) Moving zeros to end of "+Arrays.toString(qA5)+" array  [1,2,3,4,0,0] :- ");
		moveZeros(qA5);
		System.out.println(" Array Now:- "+Arrays.toString(qA5));
		
		int [] qA61= {1,3,5};  int [] qA62= {2,4};
		System.out.print("6) Union of Arrays  [1,2,3][4,5] :- ");
		unionTwoArray(qA61,qA62);
		
		int [] qA71= {1,3,5};  int [] qA72= {3,5,6};
		System.out.print("7) IntegerSection (common in both)  [3,5] :- ");
		intersectionTwoArray(qA71,qA72);
		
		int [] qA8= {3,0,1};
		System.out.println("8) Missing No  [2] :- "+missingNo(qA8));
		
		int [] qA9= {1,1,0,1,1,1};
		System.out.println("9) Count Max no of consecutive 1s  [3] :- "+ConsecutiveOnce(qA9));
		
		int [] qA10= {1,1,2,3,3,2,5};
		System.out.println("10) Find No Apear once in array [5] :- "+noApearOnce(qA10));
		
		int [] qA11= {1,2,3,1,1,1,4,2,3};//i=3 j=5
		System.out.println("11) Longest SubArray length with Sum K=3 [3] :- "+longestSubArray(qA11, 3));
		
		int [] qA12= {2,7,11,15};
		System.out.println("12) Two Sum [0,1] :- "+Arrays.toString(twoSum(qA12, 9)));
		
		int [] qA13= {2,0,2,1,1,0};
		System.out.println("13) Sort an array of 0's 1's and 2's [0,0,1,1,2,2] :- "+Arrays.toString(sortColors(qA13)));
		
		int [] qA14= {3,2,3};
		System.out.println("14) Majority Element (>n/2 times) [3] :- "+majorityElement(qA14));
		
		int [] qA15= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("15) Kadane's Algorithm, maximum subarray sum  [6] :- "+maxSubArray(qA15));
		
		System.out.print("16) Kadane's Algorithm, maximum subarray print sum [4,-1,2,1] :- ");
		maxSubArrayPrint(qA15);
		
		int [] qA17= {7,1,5,3,6,4};
		System.out.println("17) Stock Buy and Sell [5] :- "+maxProfit(qA17));
		
		int [] qA18= {3,1,-2,-5,2,-4};
		System.out.println("18) Rearrange Array Elements by Sign [3,-2,1,-5,2,-4] :- "+Arrays.toString(rearrangeArray(qA18)));
		
		int [] qA19= {1,2,3};
		System.out.println("19) Next Permutation [1,3,2] :- "+Arrays.toString(nextPermutation(qA19)));

		int [] qA20= {16, 17, 4, 3, 5, 2}; //An element is considered a leader if it is greater than or equal to all elements to its right.
		System.out.println("20) Leaders in an Array  [17, 5, 2] :- "+leaders(qA20));
		
		int [] qA21= {100,4,200,1,3,2}; //The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4. .
		System.out.println("21) Longest Consecutive Sequence in an Array  [4] :- "+longestConsecutive(qA21));
		
		int [][] qA22= {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("22) Rotate Matrix by 90 degrees  [[7,4,1],[8,5,2],[9,6,3]] :- ");
		rotate(qA22);
		
		System.out.println("23) Print the matrix in spiral manner  [1,2,3,6,9,8,7,4,5] :- "+spiralOrder(qA22));
		
		int [] qA24= {1,2,3,-3,1,1,1,4,2,-3};
		System.out.println("24) Count SubArray with Sum k=3  [8] :- "+subarraySum(qA24,3));
		/**PREFIX SUM */
		int [] qA24a= {1,3,5};//prefixSum add on question https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
		System.out.println("24) count of subarrays with an odd sum [4] [[1],[3],[5],[1,3,5]] :- "+countOddSumSubarrays(qA24a));

		//Variation 1 :- for r=6 and c=3 find element nCr(5,2) //called by n-1 and c-1 if nCr was given
		System.out.println("25) Paskal's Triangle print row  [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] :- "+generate(5));
		
		int [] qA26= {3,2,3};
		System.out.println("26) Majority Element II (>n/3 times) [3] :- "+majorityElementII(qA26));
		int [] qA27= {3,2,3,-5,-3};
		System.out.println("27) 3 SUM :- "+threeSum(qA27));
		
		int [] qA28= {3,2,3,1,5};
		System.out.println("28) 4-Sum Problem :- "+fourSum(qA28,13));
		/**PREFIX SUM */
		int [] qA29= {15 ,-2, 2, -8, 1, 7, 10, 23};
		System.out.println("29) Largest subarray with sum 0 [5]:- "+maxLen(qA29));
		/**PREFIX SUM */
		int [] qA30= {4, 2, 2, 6, 4};
		ArrayList<Integer> list=new ArrayList<>();
		for(int i:qA30)list.add(i);
		System.out.println("30) Count Subarray with given XOR [4] :- "+subArrayXor(list,6));
		
		int [][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		System.out.println("31) Merge Intervals [[1,6],[8,10],[15,18]] :- "+twoDArrayToString(merge(intervals)));
		
		int qA32a[]= {1,2,3,0,0} ,qA32b[]= {2,5};
		System.out.print("32) Merge two sorted arrays without extra space :- ");
		merge(qA32a,qA32a.length,qA32b,qA32b.length);
		System.out.println(">>"+Arrays.toString(qA32a)+"- And- "+Arrays.toString(qA32b));

		int [] qA33= {4,3,6,2,1,1};
		System.out.println("33) Find the repeating and missing number  [1, 5]:- "+findTwoElement(qA33));
		
		long [] qA34= {2, 4, 1, 3, 5};
		System.out.println("34) Count Inversions [3]:- "+inversionCount(qA34));
		
		int [] qA35= {1,3,2,3,1};
		System.out.println("35) Reverse Pairs [2]:- "+reversePairs(qA35));
		
		int [] qA36= {2,3,-2,4};
		System.out.println("36) Maximum Product Subarray [6]:- "+maxProduct(qA36));
		
		// To prectice concept check if given no is palindrom https://leetcode.com/problems/palindrome-number/
		System.out.println("1441:- "+isPalindorm(1441));
		System.out.println("121:- "+isPalindorm(121));
		System.out.println("14431:- "+isPalindorm(14431));

	}
	 public static String twoDArrayToString(int[][] arr) {
	        StringBuilder sb = new StringBuilder();
	        sb.append("["); // Start with an opening bracket

	        for (int i = 0; i < arr.length; i++) {
	            sb.append("").append(Arrays.toString(arr[i])); // Convert row to String
	            if (i < arr.length - 1) {
	                sb.append(","); // Add a newline except for the last row
	            }
	        }

	        sb.append("]");
	        return sb.toString();
	    }
	private static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans=new ArrayList<>();
		
		return ans;
	}

	public static boolean isPalindorm(int nums)
	{
		return false;
	}
	
	  public static int maxProduct(int[] nums) {

	        int n=nums.length;
	        int max=Integer.MIN_VALUE;
	       
	       
	        return max;
	    }

	
	    public static int reversePairs(int[] nums) {
	         cnt=0;
	         mergeSort(nums);
	         return (int)cnt;
	    }
	    public static int[] mergeSort(int a[]){
	        int n=a.length;
	        if(n<=1)return a;
	        int left[]=mergeSort(Arrays.copyOfRange(a,0,n/2));
	        int right[]=mergeSort(Arrays.copyOfRange(a,n/2,n));
	        countPair(left,right);
	        return merge(left,right,a);
	    }
	    
	    public static int[] merge(int left[],int right[],int[] a){
	        int i=0,j=0,k=0;
	      
	       
	        return a;
	    }

	    public static void countPair(int left[],int right[]){
	        int nL=left.length;
	        int nR=right.length;
	        int j=0;
	        for(int i=0;i<nL;i++){ //traversing left arr
	            while(j<nR && left[i]>(2*(double)right[j]))
	                j++;
	            cnt+=j;
	        }
	    }
	    
	 
    static long cnt=0;
    static long inversionCount(long arr[]) {
        cnt=0;
         mergeSort(arr);
         return cnt;
    }
    
    public static long[] mergeSort(long a[]){
        int n=a.length;
        if(n<=1)return a;
        long left[]=mergeSort(Arrays.copyOfRange(a,0,n/2));
        long right[]=mergeSort(Arrays.copyOfRange(a,n/2,n));
        return merge(left,right,a);
    }
    
    public static long[] merge(long left[],long right[],long[] a){
        int i=0,j=0,k=0;
       
        return a;
    }
    
	 public static int countOddSumSubarrays(int[] arr) {
		 	int n=arr.length;
		 	int count=0;
		 	
		    return count;
	    }
	  public static  void merge(int[] arr1, int n, int[] arr2, int m) {
		
	    }
	  static ArrayList<Integer> findTwoElement(int nums[]) {
	        int n=nums.length;
	        ArrayList<Integer> ans=new ArrayList<>();
	        int xr=0;
	        for(int i=0;i<nums.length;i++) {
	        	xr^=nums[i];
	        	xr^=(i+1);
	        }
	        int bitNo=0;
	        while(true) {
	        	if((xr & (1<<bitNo))!=0)break;
	        	bitNo++;
	        }

	        int zero=0,one=0;
	        for(int i=0;i<nums.length;i++) {
	        	if((nums[i] & (1<<bitNo))==0) {
	        		one^=nums[i];
	        	}
	        	else {
	        		zero^=nums[i];
	        	}
	        }
	      

	        for(int i=1;i<=n;i++) {
	        	if((i & (1<<bitNo))==0) {
	        		one^=i;
	        	}
	        	else {
	        		zero^=i;
	        	}
	        }
	        ans.add(zero);
	        ans.add(one);
	        return ans;
	    }
	
	 public static int[][] merge(int[][] intervals) {
	        ArrayList<int[]> ans=new ArrayList<>();
	      
	        return ans.toArray(new int[ans.size()][]);
	    }
	
	 public static int subArrayXor(ArrayList<Integer> A, int B) {
		 int count=0;
		
		 return count;
	  }
	static int maxLen(int arr[]) {
		int len=0;
		int n=arr.length;
		
        return len;
	  }
	 public static  List<List<Integer>> threeSum(int[] nums) {
		 	List<List<Integer>> ans=new ArrayList<>();
		
	        return ans;
	    }
	
	
	 public static List<Integer> majorityElementII(int[] nums) {
	        List<Integer> ans=new ArrayList<>();
	     
	        return ans;
	  }
		

	  public static List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> ans=new ArrayList<>();
	       
	        return ans;
	    }

	     public static List<Integer> generateRow(int r){
	       List<Integer> rowList=new ArrayList<>();
	     
	       return rowList;
	   }
	
	 public static long nCr(int n, int r) {
	        long res = 1;

	     
	        return res;
	    }
	public static int subarraySum(int[] nums, int k) {
		int n=nums.length;int cnt=0;
		
		return cnt;
    }
	
	 public static  List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result=new ArrayList<>();
	        int n=matrix.length;
	        int m=matrix[0].length;
	       
	        return result;
	    }
	public static void rotate(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        
        
//        for(int i=0;i<n;i++) {
//        	for(int j=0;j<m;j++) {
//        		System.out.print(matrix[i][j]+", ");
//        	}
//        	System.out.println();
//        }
    }
	
	  public static int longestConsecutive(int[] nums) {
		 int n=nums.length;
		 int largest=0;
		
		 return largest;
	  }
	
    private static boolean search(int[] nums,int k) {
		for(int i=0;i<nums.length;i++)
			if(nums[i]==k)return true;
		return false;
	}

	static ArrayList<Integer> leaders(int a[]) {
    	ArrayList<Integer> ans=new ArrayList<>();
    	
    	return ans;
    }
	
	 public static int [] nextPermutation(int[] nums) {
		 int n =nums.length;
	     return nums;
	  }
	 public static int[] rearrangeArray(int[] nums) {
	        int n=nums.length;
	        int ans[]=new int[n];
	      
	        return ans;
	 }
	
	public static int maxProfit(int[] prices) {
     int profit=0;
     
     return profit;

 }
	public static void maxSubArrayPrint(int[] nums) {
	
		 	System.out.println("");
	    }
	
	 public static int maxSubArray(int[] nums) {
		 	int globalMax=nums[0],sum=0;
		 	
		 	return globalMax;
	    }
	
	 public static int majorityElement(int[] nums) {
		 	int n=nums.length;
		 	
	        return -1;
	    }
	
	public static int[] sortColors(int[] nums) {
        int n=nums.length;
       
        return nums;
    }

	 public static int[] twoSum(int[] nums, int target) {
		 	int ans[]=new int[2];
		 	
	        return new int[]{-1,-1};
	    }

	private static int longestSubArray(int[] a,int k) {
		int n=a.length;
		int len=0;
		
		return len;
	}

	private static int noApearOnce(int[] a) {
		int xor=0;
		
		return xor;
	}
	

	private static int ConsecutiveOnce(int[] a) {
		int count=0;
		
		
		return count;
	}



	private static int missingNo(int[] a) {
		int n=a.length; 
		
		return -1;
	}



	private static void intersectionTwoArray(int[] a, int[] b) {
		ArrayList<Integer> intersection=new ArrayList<>();
		
		System.out.println(intersection);
	}
	

	
	public static int bs(int a[],int target) {
		int l=0,r=a.length-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if(a[mid]==target)return mid;
			else if(a[mid]<target)
				l=mid+1;
			else r=mid-1;
		}
		return -1;
	}

	private static void unionTwoArray(int[] a, int[] b) {
		ArrayList<Integer> union=new ArrayList<>();
		
		System.out.println(union);
	}
	
	

	private static void moveZeros(int[] a) {
		int n=a.length;
		
	}
	
	private static void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j]; 
		a[j]=temp;
	} 
	
	private static void rotate(int[] a,int k) { //1,2,3,4,5
												// 0 1 2 3 4  k=2
		int n=a.length; 

		
	}
		
		private static void reverse(int a[],int i,int j) {
			while(i<j) {
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
			
		}
	
	private static int removeDuplicate(int[] a) {
		int i=0;
		
		return i;
	}

	private static boolean isSorted(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(i>0 && a[i-1]>a[i])return false;
		}
		return true;
	}

	public static int secoundLargest(int[] a) {
		int largest=0,secound=0;
		
		return secound;
    }

}
