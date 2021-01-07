package com.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.beans.ListNode;


public class Dummy2 {
	
	public static void main(String args[]) {
		 lcs("se","e",2,1);
		ListNode l1 =new ListNode(7,new ListNode(2,new ListNode(4,new ListNode(3,null))));
		ListNode l2 =new ListNode(5,new ListNode(6,new ListNode(4,null)));
		
		//addTwoNumbers2(l1,l2);
		//maxLengthBetweenEqualCharacters("cbzxy");
		//findAnagrams("cbaeabc", "abc"); Last 10 first 7
		/*int[] a= {3,4,5,6};
		triplet(a,3,15).stream().forEach(r->System.out.print("["+r[0]+","+r[1]+","+r[2]+"]"));*/
		int[] a= {2,5,1,8,2,9,1};
		//Maxtriplet(a,3).stream().forEach(r->System.out.print("["+r[0]+","+r[1]+","+r[2]+"]"));
		
		int[] A = { 2, 6, 0, 9, 7, 3, 1, 4, 1, 10 };
		int sum = 15;
		//findSubarray(A,sum);
		
		int b[]= {1,2,3,4};
		//maxSlidingWindow(b,2);
		
		char[][] board=	{{'A','B','C','E'},
						 {'S','F','C','S'},
						 {'A','D','E','E'}};
		
		Set<Integer> set=new HashSet<Integer>();
		new ArrayList(set);
		
		int [] arr= {3,2,2,4,1,4};
		//shipWithinDays(arr,3);
		
		
	}
	 public static int lcs(String s1,String s2,int n,int m){
	        int t[][]=new int [n+1][m+1];
	        
	         for(int i=0;i<n+1;i++){
	            for(int j=0;j<m+1;j++){
	                if(i==0 && j>0)
	                    t[i][j]=s2.charAt(j-1)-'0';
	                if(j==0 && i>0)
	                    t[i][j]=s1.charAt(i-1)-'0';

	            }
	         }
	        
	        StringBuffer sb=new StringBuffer();
	        for(int i=1;i<n+1;i++){
	            for(int j=1;j<m+1;j++){
	                if(s1.charAt(i-1)==s2.charAt(j-1))
	                {
	                    t[i][j]=t[i-1][j];
	                }else t[i][j]=t[i-1][j]+t[i][j-1];
	            }
	        }
	        
	   
	        
	        return t[n][m];
	    }
	
    	
	
	
	 public static int shipWithinDays(int[] weights, int D) {
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
    
    public static boolean isValid(int[] w,int m,int d){
        int sum=0;
        int current=0;
        for(int i:w){
            sum+=i;
            
            if(sum>=m) {
            	sum=sum%m;
                current++;
            }
            if(current>d)
                return false;
        }
        return true;
    }
	
	  
	
	public static void findSubarray(int[] a, int sum)
	{
		int left=0,right=0;
		int currentSum=0;
		while(right<a.length) {
			currentSum+=a[right];
			
			while(currentSum>=sum) { 
				if(currentSum==sum)
				System.out.printf("Subarray found [%d-%d]", left, right );
				
				currentSum-=a[left];
				left++;
				
			}
			right++;
		}
	}

	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        if(l1.next==null && l2.next==null) return new ListNode(l1.val+l2.val);
        
        else {
            int val1=l1.val;
            int val2=l2.val;
            return new ListNode(val1+val2).next=addTwoNumbers(l1.next,l2.next);
        }
         
    }
    
    public static int maxLengthBetweenEqualCharacters(String s) {
        int maxLen=-1;
        int length=s.length();
       for(int i=0;i<length;i++){
           for(int j=length;j>i;j--){
                String substr=s.substring(i,j);
               
               if(substr.length()>1 && substr.charAt(0)==substr.charAt(substr.length()-1)){
                   if(maxLen==-1) maxLen=0;
                   int len=substr.length()-2;
                   if(len>maxLen)
                       maxLen=len;
               }
            }
       }
        return maxLen;
        
    }
    
   
    
    public static List<int[]> triplet(int[] n,int winS,int target) {   //## #WINDOW SIZE  KNOWN ###
		int right=0,left=0;
		int sum =0;
		List<int[]> list=new ArrayList<>();
			int currentSum=0;
		while(right<n.length) {
			
			currentSum+=n[right];
			
			if(right-left+1<winS) {
				right++;
			}
			
			else if(right-left+1==winS) {   
				if(currentSum==target) {
					int i=left,k=0;
					int a[]=new int[right-left+1];
					while(i<=right)
						a[k++]=n[i++];
					list.add(a);		
				}
				currentSum-=n[left];
				left++;
				right++;
			} 
		}
		
		
		return list;
	}
    
    public static List<int[]> Maxtriplet(int[] n,int winS) {   //## #WINDOW SIZE  KNOWN ###
		int right=0,left=0;
		int sum =0;
		List<int[]> list=new ArrayList<>();
			int currentSum=0;
			int maxSum=0;
		while(right<n.length) {
			
			currentSum+=n[right];
			
			if(right-left+1<winS) {
				right++;
			}
			
			else if(right-left+1==winS) {   
				
					int i=left,k=0;
					int a[]=new int[right-left+1];
					while(i<=right)
						a[k++]=n[i++];
					if(maxSum<currentSum) {
						maxSum=currentSum;
						list.clear();
						list.add(0,a);		

					}
				
				currentSum-=n[left];
				left++;
				right++;
			} 
		}
		
		
		return list;
	}
    
/*    public static int[] maxSlidingWindow(int[] nums, int k) {
        int right=0,left=0;
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);
         int [] out =new int [nums.length-(k-1)];
         int index=0;
          while(right<nums.length){
             q.add(nums[right]);
             if(right-left+1<k){
                 right++;
             }else if(right-left+1==k){
                 out[index++]=q.peek();
                 q.remove(nums[left]);
                 left++;
                 right++;
             }
         }
         
         return out;
     }
    */
   
    //https://www.youtube.com/watch?v=5VDQxLAlfu0
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return nums;
    
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
    
        for (int i = 0; i < nums.length; i++) {
            while (q.size() > 0 && nums[i] >= nums[q.getLast()]){
			    q.removeLast();
			}
            q.addLast(i);
            if (i - k + 1 >= 0) ans[i - k + 1] = nums[q.getFirst()];
        
            //finally remove max which is out of range
            if (i - k + 1 == q.getFirst()) q.removeFirst();
        }
             
        return ans;
    }
   
   
}
