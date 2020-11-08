package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.beans.ListNode;


public class Dummy2 {
	
	public static void main(String args[]) {
		ListNode l1 =new ListNode(7,new ListNode(2,new ListNode(4,new ListNode(3,null))));
		ListNode l2 =new ListNode(5,new ListNode(6,new ListNode(4,null)));
		
		//addTwoNumbers2(l1,l2);
		//maxLengthBetweenEqualCharacters("cbzxy");
		//findAnagrams("cbaeabc", "abc");
		//int[] a= {1,2,3,4,5,6,7,8,1,1,13};
		/*int[] a= {3,4,5,6};
		triplet(a,3,15).stream().forEach(r->System.out.print("["+r[0]+","+r[1]+","+r[2]+"]"));*/
		int[] a= {2,5,1,8,2,9,1};
		Maxtriplet(a,3).stream().forEach(r->System.out.print("["+r[0]+","+r[1]+","+r[2]+"]"));
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
    
    
    
   
}
