package com.datastructure;

public class MyLinkList<T> {
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
	
	public Node deleteInPosRecursive(Node head,int p) {
		if(p==0)return head.next_node;
		head.next_node=deleteInPosRecursive(head.next_node,p-1);
		return head;
		
	}
	//merge both of these list in sorted order 
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
	
	 static void reversePrint(Node head) {
	        if(head==null)return;
	        reversePrint(head.next_node);
	        System.out.println(head.getT());

	    }
	
	 
	 
	 public ListNode reverseList(ListNode head) {
			if(head==null)return head;
			return reverse(head,null);

		}
		public ListNode reverse(ListNode iter,ListNode prev){
		   ListNode curr = iter.next;
			iter.next = prev;
			if(curr!= null) return reverse(curr,iter);
			return iter;
		}

}

 class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
