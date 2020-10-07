package com.intquetions;

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class MergeKLL {
    public static ListNode mergeKLists(ListNode[] lists) {
        int i=1;
       while(i<lists.length){
           ListNode l1=lists[i-1];
           ListNode l2=lists[i];
           lists[i]=mergeTwo(l1,l2);  
       }
        
        return lists[lists.length-1];
        
    }
    
    
    public static ListNode mergeTwo(ListNode head1,ListNode head2){
        if(head1==null)return head2;
		if(head2==null)return head1;
		
		else if((int)head1.val<(int)head2.val) {
			head1.next=mergeTwo(head1.next,head2);
			return head1;		
		}else {
			head2.next=mergeTwo(head1,head2.next);
			return head2;		
		}
    }
    
    
    public static void main(String args[]) {
      
      ListNode one=new ListNode(1, new ListNode(4,new ListNode(5,null)));
      ListNode two=new ListNode(1, new ListNode(3,new ListNode(4,null)));
      ListNode three=new ListNode(2, new ListNode(6,null));

      ListNode[] nodes= {one,two,three};
      ListNode n =mergeKLists(nodes);
    }
}