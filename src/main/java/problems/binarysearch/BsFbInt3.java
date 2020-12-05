package problems.binarysearch;
//ALLOCATE PAGE OF BOOKS //In this type array given may not be necessorily sorted
public class BsFbInt3 {
	//https://www.youtube.com/watch?v=2JSQIhPcHQg&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=21
	public static void main(String[] args) {
		//values represent book pages and index represnt books we have to destribute books like that 
		//1)every student must get atleast one and 2)[book is a unit not divisible]
		//3)we can only distribute in countinues manner eg. Ist student :- 10,20 (10,30 is wrong)
		//II :- 30,40 (20 ,40 is not countinues so wrong)
		// BY this MINIMIZE MAX NO OF PAGES THAT ONE STUDENT READ.
		int arr[]= {10,20,30,40}; 
		
		
		
		
		//zero start range can be updated from max in array 
		//0	min								  75  		100
		//|-----------------------50-----------|----------|
		//So in initial iteration we decided no student will read more then 50 page to accomodate 
		//this condition we need atleast 3 student 1) 10+20 2)30 3)40 as student is given as 2 so we 
		//compute mid once again 50+100/2 =75 new mid now allocate once again the pages 
		System.out.println(allocatePagesOfbooks(arr,2));// we have 2 students here 
		
	}
	//it will return max no of pages any student get |similer 1011. Capacity To Ship Packages Within D Days
	public static int allocatePagesOfbooks(int arr[] ,int k) {
		int len=arr.length;
		int start=arr[len-1];//we are starting with max value in array 40 because for optimal ans we can provide 40 to one student and rest to other 
		int end=0;//sum of all element 
		for(int a:arr)
			end+=a;
		int result=-1;
			
		//no apply binarySearch
		while(start<=end) {
			int mid=start+(end-start)/2;
			
			if(isValid(arr,len,k,mid)) {
				result=mid;
				end=mid-1;  // if found 75 then move left to find if min then 75 is possible 
			}else {
				start =mid+1;
			}
			
		}
		
		return result;
		
	}
	//this function will return if this mid (max) is valid for k student or not 
	private static boolean isValid(int[] arr, int len, int k,int max) {
		int student =1;
		int sum =0;
		
		for(int i=0;i<len;i++) {
			sum+=arr[i];
			if(sum>max)
				student++;
			if(student>k)
				return false;
		}
		return true;
	}
	
	
	//1011. Capacity To Ship Packages Within D Days
	 public int shipWithinDays(int[] weights, int D) {
	        int l=weights.length;
	        int start =weights[l-1];
	        int end =0;
	        int result = Integer.MAX_VALUE;
	        for(int i:weights)
	            end+=i;
	        while(start<=end){
	            int mid=start+(end-start)/2;
	            
	            if(isValid(weights,mid,D)){
	               result=Math.min(mid,result);
	                end=mid-1;
	            }else {
	                start=mid+1;
	            }
	        }
	        return result;
	    }
	    
	   public boolean isValid(int[] w, int mid, int d) {
	        int limit = 1;
	        int curr = 0;
	        for (int i = 0; i < w.length; i++) {
	            if (w[i] > mid) {
	                return false;
	            }
	            if (w[i] + curr > mid) {
	                curr = w[i];
	                limit++;
	                if (limit > d) {
	                    return false;
	                }
	            } else {
	                curr += w[i]; 
	            }
	            
	        }
	        return true;
	    }

}
