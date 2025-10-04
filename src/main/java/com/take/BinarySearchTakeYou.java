package com.take;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BinarySearchTakeYou {

	public static void main(String[] args) {
		
		
		System.out.println("1) Sqrt of a no [5] :- "+sqrt(28));
		
		System.out.println("2) Find the Nth root of a number using binary search [3]:- "+nthRoot(3,27));
		
		int qA3[]= {3,6,7,11};
		System.out.println("3) Koko Eating Bananas [4]:- "+minEatingSpeed(qA3,8));

		int qA4[]= {1,10,3,10,2};
		System.out.println("4) Minimum Number of Days to Make m Bouquets [3]:- "+minDays(qA4,3,1));
		
		int qA5[]= {1,2,5,9};
		System.out.println("5)Find the Smallest Divisor Given a Threshold [5]:- "+smallestDivisor(qA5,6));
		
		int qA6[]= {1,2,3,4,5,6,7,8,9,10};
		System.out.println("6)Find the Smallest Divisor Given a Threshold [15]:- "+shipWithinDays(qA6,5));

		int qA7[]= {2,3,4,7,11};//[1,5,6,8,9,10,12,13,...]. 
		System.out.println("7)Find the kth missing Possitive No  [9]:- "+findKthPositive(qA7,5));
		
		int qA8[]= {0,3,4,7,10,9};//Place All cows like that min distance between then is maximum
		System.out.println("8)Aggresive Cows [3]:- "+aggresiveCows(qA8,4));
		
		int qA9[]= {25,46,28,49,24};
		ArrayList<Integer> list=new ArrayList<>();
		for(int ti:qA9)list.add(ti);
		System.out.println("9)Book Allocation [71]:- "+findPages(list,4));
		
		int qA10[]= {7,2,5,10,8};
		System.out.println("10)Split Arrays [18]:- "+splitArray(qA10,2));
		
		int qA11[]= {1,2,3,4,5,6,7};
		//array reprents quardinates of gas station you need to place K new gas station such that minimize max distance between two 
		//gas stations  https://www.naukri.com/code360/problems/minimise-max-distance_7541449
		System.out.println("11) Minimize Max Distance between Gas Station [0.5]:- "+MinimiseMaxDistance(qA10,6));
		
		String [] arr= {"boo", "go", "goo", "goog", "google", "hello"};
		//sorted List given of words  and a prefix 'go' find count of all string which starts with prefix
		System.out.println("12) Count prefix in given Array:- "+countWordsWithPrefix(arr,"go"));
		
		/**  question links 
		 * 1)lower Bound https://www.naukri.com/code360/problems/lower-bound_8165382
		 * 2) upper bound https://www.naukri.com/code360/problems/implement-upper-bound_8165383
		 */
		
	}
	 public static int countWordsWithPrefix(String[] words, String prefix) {
		 int start=lowerBound(words,prefix);
		 int end=lowerBound(words,prefix+"{");// '{' is the next character after 'z' z is 122 and 123 is {
		 return end-start;
		 
	 }
	 public static int lowerBound(String words[],String prefix) {
		 int n=words.length;
		 int ans=-1;
		 int l=0,r=n-1;
		 while(l<=r) {
			 int mid=l+(r-l)/2;
			 if(words[mid].compareTo(prefix) >= 0) {
				 ans=mid;
				 r=mid-1;
			 }else l=mid+1;
		 }
		 
		 return ans;
		 
	 }
	
	    public static double MinimiseMaxDistanceOpt(int []arr, int k){
	        int n = arr.length; // size of the array
	        double low = 0;
	        double high = 0;

	        //Find the maximum distance:
	        for (int i = 0; i < n - 1; i++) {
	            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
	        }

	        //Apply Binary search:
	        double diff = 1e-6 ;
	        while (high - low > diff) {
	            double mid = (low + high) / (2.0);
	            int cnt = numberOfGasStationsRequired(mid, arr);
	            if (cnt > k) {
	                low = mid;
	            } else {
	                high = mid;
	            }
	        }
	        return high;
	    }

	     public static int numberOfGasStationsRequired(double dist, int[] arr) {
	        int n = arr.length; // size of the array
	        int cnt = 0;
	        for (int i = 1; i < n; i++) {
	            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
	            //checking exact divible then need to reduce 1 
	            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
	                numberInBetween--;
	            }
	            cnt += numberInBetween;
	        }
	        return cnt;
	    }

	//Better apporach
	 public static double MinimiseMaxDistanceBetter(int []arr, int k){
	        int n=arr.length;
	        int howMany[]=new int[n-1];
	        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
	        for(int i=0;i<n-1;i++){
	              pq.offer(new Pair(arr[i+1]-arr[i],i));
	        }
	        for(int gas=1;gas<=k;gas++){
	            Pair curr=pq.poll();
	            int index=curr.index;
	            howMany[index]++;

	            double diff=arr[index+1]-arr[index];//we didn't use diff from pq because we are putting modified len in it not the original
	            double sectionLen=diff/(howMany[index]+1);
	            pq.offer(new Pair(sectionLen,index));
	        } 
	       
	        return pq.poll().dist;
	    }


	    private static class Pair {
	        double dist;
	        int index;

	        Pair(double dist,int index){
	            this.dist=dist;
	            this.index=index;
	        }


	    }
	    public static double MinimiseMaxDistance(int []arr, int K){
	        int n=arr.length;
	        int howMany[]=new int[n-1];
	        for(int gas=1;gas<=K;gas++){
	            double maxValue=-1;
	            int maxInd=-1;
	            for(int i=0;i<n-1;i++){
	                double diff=arr[i+1]-arr[i];
	                double sectionLen=diff/((double)howMany[i]+1);
	                if(maxValue<sectionLen){
	                    maxValue=sectionLen;
	                    maxInd=i;
	                }
	            }
	            howMany[maxInd]++;
	        }

	        double maxAns=-1;  //find max distance between two now 
	        for(int i=0;i<n-1;i++){
	            double sectionLen=(arr[i+1]-arr[i])/((double)howMany[i]+1);
	            maxAns=Math.max(maxAns,sectionLen);
	        }
	        return maxAns;
	    }

	public static int splitArray(int[] nums, int k) {
	        int n=nums.length;
	        if(k>n)return -1;
	        int max=0;
	        int total=0;
	        for(int i:nums){
	            total+=i;
	            max=Math.max(max,i);
	        }
	        int l=max,r=total;
	        int ans=-1;
	        while(l<=r){
	            int mid=l+(r-l)/2;
	            int pg=allocate(nums,mid);
	            if(pg<=k){
	                ans=mid;
	                r=mid-1;
	            }else l=mid+1;
	        }
	        return ans;
	    }

	    public static int allocate(int a[],int mid){
	        int count=1,pages=0;
	        for(int i=0;i<a.length;i++){
	            if(a[i]+pages>mid){
	                count++;
	                pages=a[i];
	            }else pages+=a[i];
	        }
	        return count;
	    }
	   public static int findPages(ArrayList<Integer> arr, int m) {
		   int n=arr.size();
	       if(m>n)return -1;
	       int total=0,max=0;
	       for(int i:arr){
	           max=Math.max(max,i);
	           total+=i;
	       }
//	       for(int i=max;i<=total;i++){
//	            int students=isValid(arr,st,i);
//	            if(students<=m)return i;
//
//	        }
	       int low=max,high=total;
	       int ans=-1;
	       while(low<=high){
	           int mid=low+(high-low)/2;
	           int stdnt=fun(arr,mid);
	           if(stdnt<=m){
	               ans=mid;
	               high=mid-1; 
	           }else {
	              low=mid+1;
	           }
	       }
	       return ans;
	    }

	    public static int fun(ArrayList<Integer> arr,int pages){
	        int count=0,stdent=1;
	        for(int i=0;i<arr.size();i++){
	            if(arr.get(i)+count>pages){
	                stdent++;
	                count=arr.get(i);
	            }else count+=arr.get(i);
	        }
	        return stdent;
	    } 
	
	private static int aggresiveCows(int[] a, int cow) {
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		Arrays.sort(a);
		for(int i:a) {
			min=Math.min(min, i);
			max=Math.max(max, i);
		}

//		for(int i=1;i<=max-min;i++) {
//			if(canWePlaceCows(a,cow,i))continue;
//			else return i-1;
//		}
		int l=1,r=max-min; 
		int ans=-1;
		while(l<=r) {
			int mid=l+(r-l)/2;
			boolean canPlace= canWePlaceCows(a,cow,mid);
			if(canPlace) {
				ans=mid;
				l=mid+1;
			}else r=mid-1;
		}
		return ans;
	}


	private static boolean canWePlaceCows(int[] a, int cow, int distance) {
		int placed=1,prev=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]-a[prev]>=distance) {
				placed++;
				prev=i;
			}
		} 
		if(placed>=cow)return true;
		return false;
	}


	public static int findKthPositive(int[] arr, int k) {
//		 if(k<arr[0])return k;
//	        int val=k;
//	        for(int i=0;i<arr.length;i++){
//	            if(arr[i]<=val)val++;
//	            else break;
//	        } 
//	        if(val==k)return arr.length;
//	        return val;
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
