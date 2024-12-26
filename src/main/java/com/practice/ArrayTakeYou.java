package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ArrayTakeYou {

	public static void main(String[] args) {
		
		int [] qA1= {1,2,4,7,7,5}; 
		System.out.println("1) Secound largest element without sort [5] :- "+secoundLargest(qA1));
		
		System.out.println("2) is Array sorted [false] :- "+isSorted(qA1));
		
		int [] qA2= {1,1,2,2,3,3}; 
		System.out.print("3) Remove duplicate from "+Arrays.toString(qA2)+" sorted array [3] :- "+removeDuplicate(qA2));
		System.out.println(" Array Now:- "+Arrays.toString(qA2));	
		
		int [] qA4= {1,2,3,4}; //For Right Rotation check leet code question https://leetcode.com/problems/rotate-array/
		System.out.print("4) Left Rotate "+Arrays.toString(qA4)+" Array  [3,4,1,2] :- ");
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
		
		int [] qA11= {1,2,3,1,1,1,4,2,3};
		System.out.println("11) Longest SubArray with Sum K=3 [3] :- "+longestSubArray(qA11, 3));
		
		int [] qA12= {2,7,11,15};
		System.out.println("12) Two Sum [0,1] :- "+Arrays.toString(twoSum(qA12, 9)));
		
		int [] qA13= {2,0,2,1,1,0};
		System.out.println("13) Sort an array of 0's 1's and 2's [0,0,1,1,2,2] :- "+Arrays.toString(sortColors(qA13)));
		
		int [] qA14= {3,2,3};
		System.out.println("14) Majority Element (>n/2 times) [3] :- "+majorityElement(qA14));
		
		int [] qA15= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("15) Kadane's Algorithm, maximum subarray sum [ 6] :- "+maxSubArray(qA15));
		
		System.out.print("16) Kadane's Algorithm, maximum subarray print sum [4,-1,2,1] :- ");
		maxSubArrayPrint(qA15);
		
		int [] qA17= {7,1,5,3,6,4};
		System.out.println("17) Stock Buy and Sell [ 6] :- "+maxProfit(qA17));
		
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
		
		Integer [] qA30= {4, 2, 2, 6, 4};
		System.out.println("30) Count Subarray with given XOR [4] :- "+subArrayXor((ArrayList<Integer>) Arrays.asList(qA30),6));
	}
	
	 public static int subArrayXor(ArrayList<Integer> A, int B) {
//		 int count=0;
//	        int n=A.size();
//	        for(int i=0;i<n;i++){
//	            int xor=0;
//	            for(int j=i;j<n;j++){
//	                xor^=A.get(j);
//	                if(xor==B)count++;
//	            }
//	        }
//	    return count;
	        int xor=0,cnt=0;
	        HashMap<Integer,Integer> hm=new HashMap<>();
	        hm.put(0,1);
	        for(int i=0;i<A.size();i++){
	            xor=xor^A.get(i);
	            int x=xor^B;
	            if(hm.containsKey(x)){
	                cnt+=hm.get(x);
	            }
	            hm.put(xor,hm.getOrDefault(xor,0)+1);
	        }
	        return cnt;
	    }
	static int maxLen(int arr[]) {
//	       int len=0;
	       int n=arr.length;
//	       for(int i=0;i<n;i++){
//	           int sum=0;
//	           for(int j=i;j<n;j++){
//	               sum+=arr[j];
//	               if(sum==0){
//	                   len=Math.max(len,j-i+1);
//	               }
//	           }
//	       }
//	       return len;
		HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0,max=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==0){
                max=i+1;
            }else if(hm.containsKey(sum)){
                max=Math.max(max,i-hm.get(sum));
            }else hm.put(sum,i);
        }
        return max;
	    }
	 public static  List<List<Integer>> threeSum(int[] nums) {
//		  int n=nums.length;
//	        HashSet<List<Integer>> hs=new HashSet<>();
//	        for(int i=0;i<n;i++){
//	            for(int j=i+1;j<n;j++){
//	                for(int k=j+1;k<n;k++){
//	                    int val=nums[i]+nums[j]+nums[k];
//	                    if(val==0){
//	                        List<Integer> triplet=Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]});
//	                        Collections.sort(triplet);
//	                        hs.add(triplet);
//	                    } 
//	                }
//	            }
//	        }
//	        return new ArrayList<>(hs);
	        List<List<Integer>> ans=new ArrayList<>();
	        Arrays.sort(nums);
	        for(int i=0;i<nums.length;i++){
	            if(i>0 && nums[i]==nums[i-1])continue;
	            int lo=i+1,hi=nums.length-1;
	            while(lo<hi){
	                int val=nums[i]+nums[lo]+nums[hi];
	                if(val==0){
	                    ans.add(Arrays.asList(new Integer[]{nums[i],nums[lo],nums[hi]}));
	                    lo++;
	                    while(lo<hi && nums[lo]==nums[lo-1])
	                        lo++;
	                    hi--;
	                    while(lo<hi && nums[hi]==nums[hi+1])
	                        hi--;
	                }else if(val<0)
	                    lo++;
	                else hi--;
	            }
	        }
	        return ans;
	    }
	
	 public static List<Integer> majorityElementII(int[] nums) {
//		   List<Integer> list=new ArrayList<>();
//	        for(int i=0;i<nums.length;i++){
//	            if(list.size()==0 || list.contains(nums[i])==false){
//	                int cnt=0;
//	                for(int j=0;j<nums.length;j++){
//	                    if(nums[i]==nums[j])
//	                        cnt++;
//	                    if(cnt>Math.floor(nums.length/3)){
//	                        list.add(nums[i]);
//	                        break;
//	                    }
//	                        
//	                }
//	            }
//	            if(list.size()==2)break;
//	        }
//	        return list;
//		  List<Integer> ans=new ArrayList<>();
//	        HashMap<Integer,Integer> hm=new HashMap<>();
//	        int n=nums.length;
//	        int treshold=(int)Math.floor(n/3);
//
//	        for(int i=0;i<n;i++){
//	            int val=nums[i];
//	            hm.put(val,hm.getOrDefault(val,0)+1);
//
//	            if(hm.get(val)>treshold && ans.contains(val)==false)
//	                ans.add(val);
//	            if(ans.size()==2)break;
//
//	        }
//	        return ans;
	        List<Integer> ans=new ArrayList<>();
	        int n=nums.length;
	        int floor=(int)Math.floor(n/3);
	        int cnt1=0,cnt2=0;
	        int el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
	        for(int i=0;i<nums.length;i++){
	            if(cnt1==0 && nums[i]!=el2){ 
	                cnt1=1;
	                el1=nums[i];
	            }else if(cnt2==0 && nums[i]!=el1){
	                
	                cnt2=1;
	                el2=nums[i];
	            }else if(nums[i]==el1 )
	                    cnt1++;
	            else if(nums[i]==el2 )
	                    cnt2++;
	            else {
	                cnt1--;
	                cnt2--;
	            } 
	        }

	        if(cnt1>0 || cnt2>0){
	            int el1cnt=0,el2cnt=0;
	            for(int i=0;i<n;i++){
	                if(nums[i]==el1)
	                    el1cnt++;
	                 if(nums[i]==el2)
	                    el2cnt++;
	            }

	            if(el1cnt>floor)
	                ans.add(el1);
	            if(el2cnt>floor)
	                ans.add(el2);
	        } 
	        return ans;
	    }
		
//	   public List<List<Integer>> generate(int numRows) {
//	        List<List<Integer>> ans=new ArrayList<>();
//	        for(int row=1;row<=numRows;row++){
//	            List<Integer> temp=new ArrayList<>();
//	            for(int col=1;col<=row;col++){
//	                temp.add(combination(row-1,col-1));
//	            }
//	            ans.add(temp);
//	        }
//	        return ans;
//	    }
//
//	    public static int combination(int n,int r){
//	        int res=1;
//	        for(int i=0;i<r;i++){
//	            res=res*(n-i);
//	            res=res/(i+1);
//	        }
//	        return res;
//	    }
	  public static List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> ans=new ArrayList<>();
	        for(int row=1;row<=numRows;row++){
	            ans.add(generateRow(row)); 
	        }
	        return ans;
	    }

	     public static List<Integer> generateRow(int r){
	       List<Integer> rowList=new ArrayList<>();
	       int ans=1;
	       rowList.add(ans);
	       for(int c=1;c<r;c++){
	        ans=ans*(r-c);
	        ans=ans/c;
	        rowList.add(ans);
	       }
	       return rowList;
	   }
	
	 public static long nCr(int n, int r) {
	        long res = 1;

	        // calculating nCr:
	        for (int i = 0; i < r; i++) {
	            res = res * (n - i);
	            res = res / (i + 1);
	        }
	        return res;
	    }
	 
	 public static int countOddSumSubarrays(int[] arr) {
		 	int n=arr.length;
	        int count = 0;
	        int oddPrefixSumCount = 0;
	        int evenPrefixSumCount = 1; // Initialize with 1 for the empty subarray
	        int prefixSum = 0;

	        for (int i = 0; i < n; i++) {
	            prefixSum += arr[i];

	            if (prefixSum % 2 == 0) {
	                count += oddPrefixSumCount;
	                evenPrefixSumCount++;
	            } else {
	                count += evenPrefixSumCount;
	                oddPrefixSumCount++;
	            }
	        }

	        return count;
	    }
	public static int subarraySum(int[] nums, int k) {
//		 int cnt=0;
//	        int n=nums.length;
//	        for(int i=0;i<n;i++){
//	            int sum=0;
//	            for(int j=i;j<n;j++){
//	                sum+=nums[j];
//	                if(sum==k)cnt++;
//	            }
//	        }
//	        return cnt;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
            int delta=prefixSum-k;
            if(hm.containsKey(delta)){
                count+=hm.get(delta);
            }
            hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
	
	 public static  List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result=new ArrayList<>();
	        int m=matrix.length; 
	        int n=matrix[0].length;
	        int left=0,top=0;
	        int right=n-1;
	        int bottom=m-1;

	        while(result.size()<m*n){
	            for(int i=left;i<=right && result.size()<m*n;i++){
	                result.add(matrix[top][i]);
	            }
	            top++;
	            for(int i=top;i<=bottom && result.size()<m*n;i++){
	                result.add(matrix[i][right]);
	            }
	            right--;
	            for(int i=right;i>=left && result.size()<m*n;i--){
	                result.add(matrix[bottom][i]);
	            }
	            bottom--;
	            for(int i=bottom;i>=top && result.size()<m*n;i--){
	                result.add(matrix[i][left]);
	            }
	            left++;
	        }
	        return result;
	    }
	 
	public static void rotate(int[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        //transpose 
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                 int temp=matrix[i][j];
                 matrix[i][j]=matrix[j][i];
                 matrix[j][i]=temp;
            }
        } 

         for(int i=0;i<n;i++){
           int l=0,r=m-1;
           while(l<r){
               int temp=matrix[i][l];
               matrix[i][l]=matrix[i][r];
               matrix[i][r]=temp;
               l++;
               r--;
           }
        } 


    }
	
	  public static int longestConsecutive(int[] nums) {
//	        int n=nums.length;
//		  int max=0;
//			 for(int i=0;i<n;i++) {
//				 int count=1;
//				 int x=nums[i];
//				 while(search(nums,x+1)) {
//					 count++;
//					 x=x+1;
//				 }
//				 max=Math.max(max, count);
//			 }
//			 return max;
		  
//	        if(n==0)return 0;
//	        Arrays.sort(nums);
//	        int countCurr=0,lastSmaller=Integer.MIN_VALUE,longest=1;
//	        for(int i=0;i<n;i++){
//	            if(nums[i]-1==lastSmaller){
//	                lastSmaller=nums[i];
//	                countCurr++;
//	            }else if(nums[i]!=lastSmaller){
//	                lastSmaller=nums[i];
//	                countCurr=1;
//	            }
//	            longest=Math.max(longest,countCurr);
//	        }
//	        return longest;
		  int n=nums.length;
	        if(n==0)return 0;
	        int max=1;
	        HashSet<Integer> hs=new HashSet<>();
	        for(int i:nums)
	            hs.add(i);

	        for(int val:hs){
	            if(hs.contains(val-1)==false){ // if hs does not have any starting element that means its a start
	                int count=0; 
	                while(hs.contains(val++))
	                    count++;
	                max=Math.max(count,max);
	            }
	        }
	        return max;
	    }
	
    static ArrayList<Integer> leaders(int arr[]) {
    	ArrayList<Integer> leaders=new ArrayList<>();
    	int n=arr.length;
//    	for(int i=0;i<n;i++) {
//    		boolean leader=true;
//    		for(int j=i+1;j<n;j++) {
//    			if(arr[j]>arr[i]) {
//    				leader=false;
//    				break; 
//    			}
//    		}
//    		if(leader)
//    			leaders.add(arr[i]);
//    	}
    	int max=-1;
    	for(int i=n-1;i>=0;i--) {
    		if(arr[i]>max) {
    			leaders.add(arr[i]);
    			max=arr[i];
    		}
    	}
    	return leaders;
    }
	 public static int [] nextPermutation(int[] nums) {
	        int ind=-1;
	        int n=nums.length;
	        for(int i=n-2;i>=0;i--){
	            if(nums[i+1]>nums[i]){
	                ind=i;
	                break;
	            }
	        }
	        if(ind==-1){
	            reverse(nums,0,n-1);
	        }else {
	            for(int i=n-1;i>ind;i--){
	                if(nums[i]>nums[ind]){
	                    int temp=nums[ind];
	                    nums[ind]=nums[i];
	                    nums[i]=temp;
	                    break;
	                }
	            }
	            reverse(nums,ind+1,n-1);
	        }
	        return nums;
	    }
	 public static int[] rearrangeArray(int[] nums) {
	        int n=nums.length;
//	        int pos[]=new int[n/2];
//	        int neg[]=new int[n/2];
//	        int j=0,k=0;
//	        for(int i=0;i<nums.length;i++){
//	            if(nums[i]>=0)
//	                pos[j++]=nums[i];
//	            else neg[k++]=nums[i];
//	        }
//
//	        for(int i=0;i<n/2;i++){
//	            nums[i*2]=pos[i];
//	            nums[i*2+1]=neg[i];
//	        }
	        int ans[]=new int[n];
	        int pos=0;
	        int neg=1;
	        for(int i=0;i<nums.length;i++){
	            int val=nums[i];
	            if(val>0){
	                ans[pos]=val;
	                pos+=2;
	            }else {
	                ans[neg]=val;
	                neg+=2;
	            }
	        }
	       
	        return ans;

	    }
	
	public static int maxProfit(int[] prices) {
        int profit=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min)
                min=prices[i];
            else profit=Math.max(profit,prices[i]-min);
        }
        return profit;

    }
	public static void maxSubArrayPrint(int[] nums) {
			int start=-1,end=-1;
	        int globalMaximum=nums[0];
	        int currentMax=0;
	        for(int i=0;i<nums.length;i++){
	            currentMax+=nums[i];
	           if(globalMaximum<currentMax) {
	        	   end=i;
	        	   globalMaximum=currentMax;
	           }
	            if(currentMax<0) {
	            	currentMax=0;
	            	start=i;
	            }
	                
	        } 
	        if(start!=-1 && end!=-1) {
	        	for(int i=start+1;i<=end;i++)
	        		System.out.print(nums[i]+", ");
	        }
	        System.out.println();
	    }
	
	
	 public static int maxSubArray(int[] nums) {
//		 int max=0;
//	        int n=nums.length;
//	        for(int i=0;i<n;i++){
//	            int sum=0;
//	            for(int j=i;j<n;j++){
//	                sum+=nums[j];
//	                if(sum>max)
//	                    max=sum;
//	            }
//	             
//	        }
//	        return max;
	        int globalMaximum=nums[0];
	        int currentMax=0;
	        for(int i=0;i<nums.length;i++){
	            currentMax+=nums[i];
	            globalMaximum=Math.max(globalMaximum,currentMax);
	            if(currentMax<0)
	                currentMax=0;
	        } 
	        return globalMaximum;
	    }
	
	 public static int majorityElement(int[] nums) {
//		 int n=nums.length;
//	        HashMap<Integer,Integer> map=new HashMap<>();
//	        for(int i:nums)
//	            map.put(i,map.getOrDefault(i,0)+1);
//
//	        for(Integer key:map.keySet()){
//	            int frq=map.get(key);
//	            if(frq>n/2)return key;
//	        }
//	        return -1;
	        int ele=-1,cnt=0;
	        for(int i=0;i<nums.length;i++){
	            if(cnt==0){
	                ele=nums[i];
	                cnt++;
	            }else if(ele==nums[i])cnt++;
	            else cnt--;
	        }
	        if(cnt>0){
	            int majorityCount=0;
	            for(int i=0;i<nums.length;i++){
	                if(nums[i]==ele){
	                    majorityCount++;
	                }
	            }
	            if(majorityCount>nums.length/2)return ele;
	        }
	        return -1;
	    }
	
	public static int[] sortColors(int[] nums) {
        int n=nums.length;
        int lo=0,mid=0,hi=n-1;
        while(mid<=hi){
            int val=nums[mid];
            if(val==0)
                swap(nums,lo++,mid++);
            else if(val==1)
                mid++;
            else if(val==2)
                swap(nums,mid,hi--); 
        }
        return nums;
    }

	 public static int[] twoSum(int[] nums, int target) {
	        HashMap<Integer,Integer> hm=new HashMap<>();
	        int ans[]=new int[2];
	        for(int i=0;i<nums.length;i++){
	            int delta=target-nums[i];
	            if(hm.containsKey(delta)){
	                ans[0]=hm.get(delta);
	                ans[1]=i;
	                return ans;
	            }else {
	                hm.put(nums[i],i);
	            } 
	        }
	        return new int[]{-1,-1};
	    }
	private static int longestSubArray(int[] a,int k) {
		HashMap<Integer,Integer> hm=new HashMap<>();
		int sum=0,maxlen=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
			if(sum==k) {
				maxlen=Math.max(maxlen, i+1);
			}
			int rem=sum-k;
			if(hm.containsKey(rem)) {
				int len=i-hm.get(rem);
				maxlen=Math.max(maxlen, len);
			}
		if(hm.containsKey(sum)==false)
			hm.put(sum,i);
		}
		return maxlen;
	}

	private static int noApearOnce(int[] a) {
		int xor=0;
		for(int i:a)
			xor^=i;
		return xor;
	}

	private static int ConsecutiveOnce(int[] a) {
		int max=0,count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]==1)count++;
			max=Math.max(max, count);
			if(a[i]==0)count=0;
		}
		return max;
	}

	
	private static int missingNo(int[] a) {
	   int n=a.length;
//	        int sum=(n*(n+1))/2;
//	        int arrSum=0;
//	        for(int i=0;i<a.length;i++)
//	            arrSum+=a[i];
//	        return Math.abs(sum-arrSum);
		int xor1=0,xor2=0;
		for(int i=0;i<a.length;i++) {
			xor2^=a[i];
			xor1^=(i+1);
		}
		return xor1^xor2;
	}
	

	private static void intersectionTwoArray(int[] a, int[] b) {
		
		ArrayList<Integer> intersection=new ArrayList<>();
//		boolean []visited=new boolean[b.length];
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<b.length;j++) {
//				if(a[i]==b[j] && visited[j]==false) {
//					intersection.add(a[i]);
//					visited[j]=true;
//					break;
//				}
//				if(b[j]>a[i])break;
//			}
//			
//		}
 //USING Binery Search
//		boolean []visited=new boolean[b.length];
//		for(int i=0;i<a.length;i++) {
//			int found=bs(b,a[i]);
//			if(found!=-1 && visited[found]==false) {
//				intersection.add(a[i]);
//				visited[found]=true;
//			}
//			
//		}
		/**OPTIMAL */
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]<b[j])
				i++;
			if(a[i]>b[j])
				j++;
			else {
				intersection.add(a[i]);
				i++;
				j++;
			}
		}
		
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
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]<b[j]) {
				if(union.isEmpty() || union.get(union.size()-1)!=a[i])
					union.add(a[i]);
				i++;
			} else {
				if(union.isEmpty() || union.get(union.size()-1)!=b[j])
					union.add(b[j]);
				j++;
			}
		}
		while(i<a.length) {
			if(union.isEmpty() || union.get(union.size()-1)!=a[i])
				union.add(a[i]);
			i++;
		}
		while(j<b.length) {
			if(union.isEmpty() || union.get(union.size()-1)!=b[j])
				union.add(b[j]);
			j++;
		}
		System.out.println(union);
	}

	
	private static void moveZeros(int[] a) {
		int n=a.length;
		int j=-1;
		for(int i=0;i<n;i++) {
			if(a[i]==0) {
				j=i;
				break;
			}
		}
		if(j==-1)return; 
		for(int i=j+1;i<n;i++) {
			if(a[i]!=0)
				swap(a,i,j++);
		}
		
	}
	
	private static void swap(int a[],int i,int j) {
		int temp=a[i];
		a[i]=a[j]; 
		a[j]=temp;
	} 

	private static void rotate(int[] a,int k) {
//		int temp=a[0]; //if one place
		int n=a.length;
//		for(int i=1;i<n;i++)
//			a[i-1]=a[i];
//		a[n-1]=temp;
		if(k>n)k=k%n;
		int temp[]=new int[k];
//		for(int i=0;i<k;i++)  //left rotation brute
//			temp[i]=a[i];
//		for(int i=k;i<n;i++)
//			a[i-k]=a[i];
//		int j=0;
//		for(int i=n-k;i<n;i++)
//			a[i]=temp[i-(n-k)];
//		for(int i=n-k;i<n;i++) //right rotation
//			temp[i-(n-k)]=a[i];
//		for(int i=n-k-1;i>=0;i--)
//			a[i+k]=a[i];
//		for(int i=0;i<k;i++)
//			a[i]=temp[i];
		
		reverse(a,0,k-1);
		reverse(a, k, n-1);
		reverse(a, 0, n-1);
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
//		HashSet<Integer> hs=new HashSet<>();
//		for(int i:a)
//			hs.add(i);
//		int index=0;
//		for(int i:hs)
//			a[index++]=i;
//		return index;
		int i=0;
		for(int j=1;j<a.length;j++) {
			if(a[i]!=a[j]) {
				a[i+1]=a[j];
				i++;
			}
		}
		return i;
		
	}

	private static boolean isSorted(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(i>0 && a[i]<a[i-1])return false;
		}
		return true;
	}

	public static int secoundLargest(int[] arr) {
        int largest=arr[0],seound=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>largest){
            	seound=largest;
                largest=arr[i];
            }
            else if(arr[i]>seound && arr[i]!=largest){
            	seound=arr[i];
            } 
        }
        return seound;
    }

}
