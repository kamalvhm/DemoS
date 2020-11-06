package com.practice;

import com.beans.ListNode;


public class Dummy2 {
	
	public static void main(String args[]) {
		ListNode l1 =new ListNode(7,new ListNode(2,new ListNode(4,new ListNode(3,null))));
		ListNode l2 =new ListNode(5,new ListNode(6,new ListNode(4,null)));
		
		//addTwoNumbers2(l1,l2);
		maxLengthBetweenEqualCharacters("cbzxy");
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
    
    
   
}
