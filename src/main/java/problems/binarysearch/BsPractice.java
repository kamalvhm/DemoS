package problems.binarysearch;

public class BsPractice {

	public static void main(String[] args) {
		//Simple binary search + variation of first and last 
		int [] h= {5,7,7,8,8,8,8,8,10};
		System.out.println(searchRange(h,8));
		
		int [] f= {1,2,3,4,5,6,1,2,3,4,5};
		System.out.println("PEAK-> "+findPeakElement(f));
				
		//Binary search in 2D array
		
		int arr[][]= {{10,20,30,40},
					  {15,25,35,45},
					  {27,29,37,48},
					  {32,33,39,50}};
		//1-2 should be retured;
		System.out.print(Search2DArray(arr,29));
		
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
		int [] k= {1,2,3,4,5,6,7,8,9,10,11};
		System.out.print(bsInfiniteArray(k, 7));
		
		
	}

	private static int searchRange(int[] a, int i) {
		int l=0,r=a.length-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			if((mid==r || a[mid+1]>i) && a[mid]==i)return mid;
			else if(i>a[mid])
				l=mid+1;
			else r=mid-1;
		}
		return -1;
	}
	
	
	
	public static int bsInfiniteArray(int[] a, int target) {
		int start=0,end=1;
		
		return -1;
		
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
	
	public static int findElemntinRotatedArray(int [] a,int target) {
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
	 
	 public static int findPeakElement(int[] a) {
	        int left=0,right=a.length-1;
	        while(left<=right) {
	        	int mid=left+(right-left)/2;
	        	
	        	if((mid==0 || a[mid-1]<a[mid]) && (mid==right || a[mid+1]<a[mid]))
	        		return a[mid];
	        	else if(a[mid]<a[mid+1])
	        		left=mid+1;
	        	else
	        		right=mid-1;
	        }
	        return -1;
	      }
	 

}
