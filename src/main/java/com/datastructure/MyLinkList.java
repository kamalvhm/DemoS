package com.datastructure;

import com.beans.ListNode;
import com.beans.Node;

public class MyLinkList<T> {
	//eXERSISE
	//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem?h_r=internal-search
	//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem

	
	private Node<T> st_node;
	private int size;
	

	public MyLinkList(){
		st_node=new Node<T>();
		size=0;
	}
	
	
	public void add(T t) {
		if(st_node.next_node==null && st_node.getT()==null) {
			st_node.setT(t);
			size++;
			return;
		}
		Node<T> tempNode=st_node;
		//traversing untill we found end of list
		while(tempNode.next_node!=null) {
			tempNode=tempNode.next_node;
		}
		Node n = new Node(t,null,tempNode);
		tempNode.next_node=n;
		size++;
		
	}
	
	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		String s ="";
		Node<T> tempNode=st_node;
		for(int i=0;i<size;i++) {
			s=s+tempNode.getT()+", ";
			tempNode=tempNode.next_node;
		}
		
		return "MyLinkList [" + s + "]";
	}
	
	public void delete(int i) {
		if(i>size)return;
		Node<T> tempNode=st_node;
		int index=0;
		while(index<i) {
			tempNode=tempNode.next_node;
			index++;
		}
		tempNode.previous_node.next_node=tempNode.next_node;
		if(tempNode.next_node.previous_node!=null)
		tempNode.next_node.previous_node=tempNode.previous_node;
		
		size--;
		
		
	}
	//to reverse a singly linked list | https://leetcode.com/problems/reverse-linked-list/
	public void reverse() {
		Node previous=null;
		Node current=st_node;
		Node next=null;
		
		while(current!=null) {
			next=current.next_node;
			current.next_node=previous;
			previous=current;
			current=next;
		}
		
		st_node = previous; 
       
	}
	//recursive
	public Node reverseList(Node head) {
			if(head == null || head.next_node == null){
		          return head;
		     }
			 Node newRoot = reverseList(head.next_node);// find the new root - last element of the linked list
		     head.next_node.next_node = head; // add new element at end
		     head.next_node = null; // new start tail
		     return newRoot;
	}
	
	//141. Linked List Cycle | https://leetcode.com/problems/linked-list-cycle/
		public boolean hasCycle(ListNode head) {
			if (head == null || head.next == null) {
				return false;
			}
			ListNode slow = head;
			ListNode fast = head.next;
			while (fast != null && fast.next != null) {
				if (slow == fast)
					return true;
				slow = slow.next;
				fast = fast.next.next;
			}
			return false;
		}
		
		//876. Middle of the Linked List | https://leetcode.com/problems/middle-of-the-linked-list/
		public Node findMid() {
			Node slow=st_node;
			Node fast=st_node;
			 
		    while (fast != null && fast.next_node != null) {
		            slow = slow.next_node;
		            fast = fast.next_node.next_node;
		        }
		        return slow;
		}
		
	
	//1669. Merge In Between Linked Lists
	public static void mergeInbetween(String s ,MyLinkList list1,MyLinkList list2) {
		String str[]=s.split(",");
		int st=Integer.parseInt(str[0]);
		int end=Integer.parseInt(str[1]);
		
		if(list1.size<st || list1.size<end)return;
		
		Node st_split=list1.st_node;
		Node en_split=list1.st_node;
		
		while((Integer.parseInt((String) st_split.getT())!=st)) {
			st_split=st_split.next_node;
		}
		while( Integer.parseInt((String)en_split.getT())!=end)
			en_split=en_split.next_node;
		
		st_split.next_node=list2.st_node;
		
		while(st_split.next_node!=null)
			st_split=st_split.next_node;
		
		st_split.next_node=en_split;
		
		list1.size=list1.size+list2.size;

	}
	
	//https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
	public Node deleteInPosRecursive(Node head,int p) {
		if(p==0)return head.next_node;
		head.next_node=deleteInPosRecursive(head.next_node,p-1);
		return head;
		
	}
	//21 Merge Two Sorted Lists | merge both of these list in sorted order 
	public static Node mergeInsortedOrder(Node head1,Node head2) {
		if(head1==null)return head2;
		if(head2==null)return head1;
		
		else if((int)head1.getT()<(int)head2.getT()) {
			head1.next_node=mergeInsortedOrder(head1.next_node,head2);
			return head1;		
		}else {
			head2.next_node=mergeInsortedOrder(head1,head2.next_node);
			return head2;		
		}
			
	}
	//https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
	 static void reversePrint(Node head) {
	        if(head==null)return;
	        reversePrint(head.next_node);
	        System.out.println(head.getT());

	    }
		
		//83. Remove Duplicates from Sorted List
		 public ListNode deleteDuplicates(ListNode head) {
	         if (head == null) {
	            return null;
	        }
	        
	        ListNode finger = head;
	        while (finger.next != null){
	            if (finger.val == finger.next.val){
	                finger.next = finger.next.next;
	            } else{
	                finger = finger.next;
	            }
	        }
	        return head;
	    }
		 
		//445. Add Two Numbers II   #@ MEDIUM
		 public static  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		        Stack<Integer> s1=new Stack<>();
		        Stack<Integer> s2=new Stack<>();
		          ListNode l=null,p=null;
		          
		          while(l1!=null){
		              s1.push(l1.val);
		              l1=l1.next;
		          }
		          
		           while(l2!=null){
		              s2.push(l2.val);
		              l2=l2.next;
		          }
		            int sum=0;
		            ListNode res=new ListNode(0);
		           while(!s1.isEmpty() || !s2.isEmpty()){
		                if(!s1.isEmpty())
		                    sum+=s1.pop();
		                
		                if(!s2.isEmpty())
		                    sum+=s2.pop();
		                
		               res.val=sum%10;
		               ListNode head=new ListNode(sum/10);
		               head.next=res;
		               res=head;
		               //carry handled in sum
		                sum/=10;
		           }
		          //if first value is zero then there was no carry 
		        return res.val==0 ? res.next : res;
		      
		    }
		 
		 public static void main(String args[]) {
			 /*Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
			   Output: 7 -> 8 -> 0 -> 7*/
				ListNode l1 =new ListNode(7,new ListNode(2,new ListNode(4,new ListNode(3,null))));
				ListNode l2 =new ListNode(5,new ListNode(6,new ListNode(4,null)));
				
				addTwoNumbers(l1,l2);
			}
		 
	
	
	//24. Swap Nodes in Pairs  #RECURSION
   public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
      ListNode oldHead = head, newHead = head.next;
      oldHead.next = swapPairs(newHead.next);
      newHead.next = oldHead;
      return newHead;
  }
   //206. Reverse Linked List  #RECURSION
//   public ListNode reverseList(ListNode head) {
//		if(head==null)return head;
//		return reverse(head,null);
//
//	}
//	public ListNode reverse(ListNode head,ListNode prev){
//	   ListNode curr = head.next;
//	   head.next = prev;
//		if(curr!= null) return reverse(curr,head);
//		return head;
//	}
   public ListNode reverseList(ListNode head) {
       if(head==null || head.next==null)return head;
       
       ListNode node=reverseList(head.next);
       head.next.next=head;
       head.next=null;
       return node;
   }
	
	//23. Merge k Sorted Lists | https://www.youtube.com/watch?v=3yvecsuv3iQ
	 public ListNode mergeKLists(ListNode[] lists) {
	     if(lists == null || lists.length == 0) return null;
	        int interval = 1;
	        //this loop will merge in intervals and everytime increase interval
	        while(interval < lists.length){
	            for(int i=0;i<lists.length-interval; i += interval*2){
	                lists[i] = merge(lists[i], lists[i+interval]);
	            }
	            interval *= 2; 
	        }
	        
	        return lists[0];
	    }
	    
	    ListNode merge(ListNode a, ListNode b){
	        if(a == null) return b;
	        if(b == null) return a;
	        
	        if(a.val <= b.val){
	            a.next = merge(a.next,b);
	            return a;
	        }
	        else{
	            b.next = merge(a,b.next);
	            return b;
	        }
	    }
	    
	    //FAANG  | 138. Copy List with Random Pointer |https://www.youtube.com/watch?v=u0ICrnHaSg4 | https://github.com/Sunchit/Coding-Decoded/blob/master/February2021/CopyListwithRandomPointer.java
	   /* public Node copyRandomList(Node head) {
	        if(head==null) return null; 
	        //Step 1:- Duplicate all nodes 1->1 
	            Node temp=head;
	           while(temp!=null){
	               Node nextOfTemp=temp.next;
	               Node duplicate=new Node(temp.val);
	               duplicate.next=temp.next;                        
	               temp.next=duplicate;
	               temp=nextOfTemp;
	           }
	        //Step 2:-point duplicate random to actual nodes randoms duplicate 
	        temp=head;
	        Node newTemp=temp.next;
	        Node newHead=head.next;
	        while(temp!=null){
	        if(temp.random!=null)
	            newTemp.random=temp.random.next;
	            
	            temp=newTemp.next;
	        if(temp!=null)
	            newTemp=temp.next;
	        }
	        //Step 3:-create two linkList by seperating duplicate with actuals list
	        temp=head;
	        newTemp=temp.next;
	        while(temp!=null){
	            temp.next=newTemp.next;
	            temp=temp.next;
	            if(temp!=null){
	                newTemp.next= temp.next;
	                newTemp=temp.next;  
	            }
	        
	        }
	        return newHead;
	    }
	    
	    class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
	    */
	    
	    //160. Intersection of Two Linked Lists   
	    //TC: O(l1+l2)
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        int lenA=getLength(headA);
	        int lenB=getLength(headB);
	        
	        for(int i=0;i<lenA-lenB;i++)
	            headA=headA.next;
	        //in both one will execute and after this both will be of equal distance
	        for(int i=0;i<lenB-lenA;i++)
	            headB=headB.next;
	        
	        while(headA!=null && headB!=null){
	            if(headA==headB)
	                return headA;
	            headA=headA.next;
	            headB=headB.next;
	        }
	        return null;
	    }
	    
	    public static int getLength(ListNode head){
	        int len=0;
	        while(head!=null){
	            head=head.next;
	            len++;
	        }
	        return len;
	    }
	    
	    
	    //Two Diffrent length Linkedlists find cooman node  point if any 
	    //SAME WITH OTHER APPROACH -Check Notes first pages
	    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	        ListNode a=headA;
	        ListNode b=headB;
	        while(a!=b){
	            if(a==null)
	                a=headB;
	            else a=a.next;
	            if(b==null)
	                b=headA;
	            else b=b.next;
	        }
	        return a;
	    }
	    
	    //148. Sort List
	    public ListNode sortList(ListNode head) {
	        if(head==null || head.next==null)return head;
	        
	        ListNode temp=head;
	        ListNode slow=head;
	        ListNode fast=head;
	        
	        //dividing list in two halfs 
	        while(fast!=null && fast.next!=null){
	            temp=slow;
	            slow=slow.next;
	            fast=fast.next.next;
	        }
	        
	        temp.next=null;
	        ListNode left=sortList(head);
	        ListNode right=sortList(slow);
	      return  merge2(left,right);
	    }
	    
	    public ListNode merge2(ListNode l1,ListNode l2){
	        ListNode tempHead=new ListNode(0);
	        ListNode current=tempHead;
	        
	        while(l1!=null && l2!=null){
	            if(l1.val<l2.val){
	                current.next=l1;
	                l1=l1.next;
	            }else {
	                current.next=l2;
	                l2=l2.next;
	            }
	            current=current.next;
	        }
	        
	        if(l1!=null) // no while loop as its LL
	        {
	            current.next=l1;
	            l1=l1.next;

	        }
	        
	        if(l2!=null){
	            current.next=l2;
	            l2=l2.next;
	        }
	        return tempHead.next;
	    }
	    
	    
}


 
 
 
 
