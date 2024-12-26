package com.practice;

public class BinarySearchTakeYou {

	public static void main(String[] args) {
		
		
		System.out.print("1) Sqrt of a no [5] :- "+sqrt(28));
		
		System.out.print("2) Find the Nth root of a number using binary search [3]:- "+nthRoot(3,27));
		
		int qA3[]= {3,6,7,11};
		System.out.print("3) Koko Eating Bananas [4]:- "+minEatingSpeed(qA3,8));

		int qA4[]= {1,10,3,10,2};
		System.out.print("4) Minimum Number of Days to Make m Bouquets [3]:- "+minDays(qA4,3,1));
		
		int qA5[]= {1,2,5,9};
		System.out.print("5)Find the Smallest Divisor Given a Threshold [5]:- "+smallestDivisor(qA5,6));
		
		int qA6[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.print("6)Find the Smallest Divisor Given a Threshold [15]:- "+shipWithinDays(qA6,5));

		int qA7[]= {2,3,4,7,11};//[1,5,6,8,9,10,12,13,...]. 
		System.out.print("7)Find the Smallest Divisor Given a Threshold [9]:- "+findKthPositive(qA7,5));
	}
	public static int findKthPositive(int[] arr, int k) {
        int l=0,r=arr.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k)
                l=mid+1;
            else r=mid-1; 
        }

        return k+l;
    }
	 public static int shipWithinDays(int[] weights, int days) {
	        int total=0,max=0;
	        for(int i:weights){
	            total+=i;
	            max=Math.max(max,i);
	        }
	        int l=max,r=total;
	        int ans=-1;
	        while(l<=r){
	            int mid=l+(r-l)/2;
	            boolean possible=possibleShip(weights, mid, days);
	            if(possible){
	                ans=mid;
	                r=mid-1;
	            }else l=mid+1;
	        }
	        return ans;
	    }

	     public static boolean possibleShip(int a[],int c,int d){
	        int sum=0, days=1;
	        for (int i=0;i<a.length;i++){
	            if(sum+a[i]>c){
	                sum=a[i];
	                days++;
	            }else sum+=a[i];
	        }
	        return days<=d;
	    }
	public static int smallestDivisor(int[] nums, int threshold) {
        if(nums.length>threshold)return -1;
        int max=Integer.MAX_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
        }
//        for(int i=1;i<=max;i++){ //brute
//            if(possible(nums,threshold,i))return i;
//        }
        int ans=-1;
        int l=1,r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            boolean possible=possibleDiv(nums,mid,threshold);
            if(possible){
                ans=mid;
                r=mid-1;
            }else l=mid+1;
        }
        return ans;
    }

    public static boolean possibleDiv(int a[],int mid,int t){
        int total=0;
        for(int i:a){
            total+=Math.ceil((double)i/(double)mid);
        }
        return total<=t;
    }
	public static int minDays(int[] bloomDay, int m, int k) {
//		int n=bloomDay.length;
//        if(m*k>n)return -1;
//        int min=Integer.MAX_VALUE,max=Integer.MAX_VALUE;
//        for(int i:bloomDay){
//            min=Math.min(min,i);
//            max=Math.max(max,i);
//        }
        // for(int i=min;i<=max;i++){
        //     if(possible(bloomDay,m,k,i))return i;
        // }
        int n=bloomDay.length;
        if((m*k)>n)return -1;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i:bloomDay){
            min=Math.min(min,i);
            max=Math.max(max,i);
        }

        int l=min,r=max;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                r=mid-1;
            }else l=mid+1;
        }
        return ans;
    }

    public static boolean possible(int a[],int day,int m,int k){
        int cnt=0,noOfBuq=0;
        for(int i=0;i<a.length;i++){
            if(a[i]<=day){
                cnt++;
            }else {
                noOfBuq+=cnt/k;
                cnt=0;
            }
        }
        noOfBuq+=cnt/k;
        if(noOfBuq>=m)return true;
        else return false;
        
    }
	 public static int minEatingSpeed(int[] piles, int h) {
//		 int max=0;
//	        for(int i:piles)
//	            max=Math.max(max,i);
//	       for(int i=1;i<=max;i++){
//	            int time=possible(piles,i);
//	            if(time<=h)return i;
//	             
//	        }
//	        return -1;
        int max=0;
        for(int i:piles)
            max=Math.max(i,max);
        int l=1,r=max;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(possible(piles,mid,h)){
                ans=mid;
                r=mid-1;
            }else l=mid+1;
        }
        return ans;
    }


    public static boolean possible(int a[],int hour,int h){
        int total=0;
        for(int i=0;i<a.length;i++){
              total+=Math.ceil((double)(a[i])/(double)(hour));
        }
        return total<=h;
    }
	
	  public static int nthRoot(int n, int m) {
//	        int ans=-1;
//	       for(int i=1;i<=m;i++){
//	           if(mutiplyTimes(i,n)<=m){
//	               ans=i;
//	           }else break;
//	       }
//	       return ans;
		  int l=1,r=m;
	        while(l<=r){
	            int mid=l+(r-l)/2;
	            double pow=Math.pow(mid,n);
	            if(pow==m)return mid;
	            if(pow<m)l=mid+1;
	            else r=mid-1;
	            
	        }
	        return -1;
	    }
	    
	    public static long mutiplyTimes(int x,int n){
	        long val=1;
	        for(int i=0;i<n;i++){
	            val*=x;
	        }
	        return val;
	    }

	private static int sqrt(int n) {
//		int ans=-1;
//		for(int i=1;i<n;i++) {
//			if(i*i<=n) {
//				ans=i;
//			}else break;
//		}
//		return ans;
		int l=1,r=n;
		int ans=-1;
		while(l<=r) {
			int mid=l+(r-l)/2;			
			if(mid*mid<=n) {
				ans=mid;
				l=mid+1;
			}else r=mid-1;
		}
		return ans;
	}

}
