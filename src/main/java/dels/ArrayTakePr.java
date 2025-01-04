package dels;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class ArrayTakePr { 

	public static void main(String[] args) {
		
		int [] qA1= {1,2,4,7,7,5}; 
		System.out.println("1) Secound largest element without sort [5] :- "+secoundLargest(qA1));
		
		System.out.println("2) is Array sorted [false] :- "+isSorted(qA1));
		
		int [] qA2= {1,1,2,2,3,3}; 
		System.out.print("3) Remove duplicate from "+Arrays.toString(qA2)+" array [3] :- "+removeDuplicate(qA2));
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
		System.out.println("9) Count Max no of 1s  [3] :- "+ConsecutiveOnce(qA9));
		
		
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
		
		System.out.println("23) Print the matrix in spiral manner  [[7,4,1],[8,5,2],[9,6,3]] :- "+spiralOrder(qA22));
		
		int [] qA24= {1,2,3,-3,1,1,1,4,2,-3};
		System.out.println("24) Count SubArray with Sum k=3  [8] :- "+subarraySum(qA24,3));
		/**PREFIX SUM */
		int [] qA24a= {1,3,5};//prefixSum add on question https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
		System.out.println("24) count of subarrays with an odd sum [5] [[1],[1,3],[1,3,5],[3],[3,5],[5]] :- "+countOddSumSubarrays(qA24a));

		//Variation 1 :- for r=6 and c=3 find element nCr(5,2) //called by n-1 and c-1 if nCr was given
		System.out.println("25) Paskal's Triangle print row  [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] :- "+generate(5));
		
		int [] qA26= {3,2,3};
		System.out.println("26) Majority Element II (>n/3 times) [3] :- "+majorityElementII(qA26));
		int [] qA27= {3,2,3};
		System.out.println("27) 3 SUM :- "+threeSum(qA27));
		
		int [] qA28= {3,2,3};
		System.out.println("28) 4-Sum Problem :- "+threeSum(qA27));
		
		int [] qA29= {15 ,-2, 2, -8, 1, 7, 10, 23};
		System.out.println("29) Largest subarray with 5 sum :- "+maxLen(qA29));
	
		int [] qA30= {4, 2, 2, 6, 4};
		ArrayList<Integer> list=new ArrayList<>();
		for(int i:qA30)list.add(i);
		System.out.println("30) Count Subarray with given XOR [4] :- "+subArrayXor(list,6));
		
		int [][] intervals= {{1,3},{2,6},{8,10},{15,18}};
		System.out.println("31) Merge Intervals [[1,6],[8,10],[15,18]] :- "+merge(intervals));
		
		int qA32a[]= {1,2,3,0,0} ,qA32b[]= {2,5};
		System.out.print("32) Merge two sorted arrays without extra space :- ");
		merge(qA32a,qA32a.length,qA32b,qA32b.length);
		System.out.println(""+Arrays.toString(qA32a)+"- And- "+Arrays.toString(qA32b));

	}
	 public static int countOddSumSubarrays(int[] arr) {
		 	int n=arr.length;
		 	return n;
	    }
	  public static  void merge(int[] arr1, int n, int[] arr2, int m) {
//		  int ans[]=new int[m+n];
//	        int i=0,j=0,k=0;
//	        while(i<n && j<m){
//	            if(a[i]<b[j]){
//	                ans[k++]=a[i++];
//	            }else {
//	                ans[k++]=b[j++];
//	            }
//	        }
//	        while(i<n)
//	            ans[k++]=a[i++];
//	        while(j<m)
//	            ans[k++]=b[j++];
//
//	        n=a.length;
//	        m=b.length;
//	        for(int l=0;l<ans.length;l++){
//	            if(l<n)a[l]=ans[l];
//	            else b[l-n]=ans[l];
//	        }

	         // Declare 2 pointers:
	        int left = n - 1;
	        int right = 0;

	        // Swap the elements until arr1[left] is
	        // smaller than arr2[right]:
	        while (left >= 0 && right < m) {
	            if (arr1[left] > arr2[right]) {
	                int temp = arr1[left];
	                arr1[left] = arr2[right];
	                arr2[right] = temp;
	                left--;
	                right++;
	            } else {
	                break;
	            }
	        }

	        // Sort arr1[] and arr2[] individually:
	        Arrays.sort(arr1);
	        Arrays.sort(arr2);

	    }

	
	 public static int[][] merge(int[][] intervals) {
	        ArrayList<int[]> ans=new ArrayList<>();
	    
	        return ans.toArray(new int[ans.size()][]);
	    }
	
	 public static int subArrayXor(ArrayList<Integer> A, int B) {
		 return -1;
	    }
	static int maxLen(int arr[]) {

        return -1;
	    }
	 public static  List<List<Integer>> threeSum(int[] nums) {
		 	List<List<Integer>> ans=new ArrayList<>();
		 	HashSet<List<Integer>> hs=new HashSet<>();
		 	for(int  i=0;i<nums.length;i++) {
		 		for(int j=i+1;j<nums.length;j++) {
		 			for(int k=j+1;k<nums.length;k++) {
		 				int val=nums[i]+nums[j]+nums[k];
		 				if(val==0) {
		 					List<Integer> list=Arrays.asList(new Integer[] {nums[i],nums[j],nums[k]});
		 					Collections.sort(list);
		 					hs.add(list);
		 				}
		 			}
		 		}
		 	}
	        return new ArrayList<>(hs);
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
	        
	        return result;
	    }
	public static void rotate(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
       
        
        

    }
	
	  public static int longestConsecutive(int[] nums) {
		 int n=nums.length;
		
		 return -1;
	  }
	
    private static boolean search(int[] nums,int k) {
		for(int i=0;i<nums.length;i++)
			if(nums[i]==k)return true;
		return false;
	}

	static ArrayList<Integer> leaders(int a[]) {
    	ArrayList<Integer> leaders=new ArrayList<>();
    	
    	return leaders;
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
     int min=Integer.MAX_VALUE;;
     for(int i=0;i<prices.length;i++) {
    	 if(min>prices[i])min=prices[i];
    	 else profit=Math.max(profit, prices[i]-min);
     }
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
	      
	        return new int[]{-1,-1};
	    }

	private static int longestSubArray(int[] a,int k) {
		int n=a.length;
		int len=0;
		
		return len;
	}

	private static int noApearOnce(int[] a) {
		return 1;
	}
	

	private static int ConsecutiveOnce(int[] a) {
		return 1;
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
	
	private static void rotate(int[] a,int k) {
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
