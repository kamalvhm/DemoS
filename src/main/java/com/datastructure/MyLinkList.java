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
	
	public Node findMid() {
		Node slow=st_node;
		Node fast=st_node;
		
		while(fast!=null) {
			fast =fast.next_node;
			if(fast!=null && fast.next_node!=null) {
				slow=slow.next_node;
				fast=fast.next_node;
			}
		}
		return slow;
	}
	//https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
	public Node deleteInPosRecursive(Node head,int p) {
		if(p==0)return head.next_node;
		head.next_node=deleteInPosRecursive(head.next_node,p-1);
		return head;
		
	}
	//Merge Two Sorted Lists | merge both of these list in sorted order 
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
	
	//24. Swap Nodes in Pairs  #RECURSION
   public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
      ListNode oldHead = head, newHead = head.next;
      oldHead.next = swapPairs(newHead.next);
      newHead.next = oldHead;
      return newHead;
  }
   //206. Reverse Linked List  #RECURSION
   public ListNode reverseList(ListNode head) {
		if(head==null)return head;
		return reverse(head,null);

	}
	public ListNode reverse(ListNode head,ListNode prev){
	   ListNode curr = head.next;
	   head.next = prev;
		if(curr!= null) return reverse(curr,head);
		return head;
	}
	
	
	//23. Merge k Sorted Lists
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
}


 
 
 
 
