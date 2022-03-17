package com.practice;

import java.util.Iterator;

import javax.management.RuntimeErrorException;

public class DoublyLinkedP<T> implements Iterator<T> {
	
	private int size=0;
	Node<T> head,tail;
	
	public void clear() {
		Node trav=head;
		while(trav!=null) {
			Node temp=trav.next;
			trav.prev=trav.next=null;
			trav.data=null;
			trav=temp;
		}
		head=tail=trav=null;
		size=0;
	}
	
	public int size() {return size;}

	public boolean isEmpty() {return size==0;}
	
	public void add(T elem) {
		addLast(elem);
	}
	
	public void addFirst(T elem) {
		if(isEmpty())
			head=tail=new Node(elem,null,null);
		else {
		    head.prev=new Node(elem,null,head);
		    head=head.prev;
		}
		size++;
	}
	
	public void addLast(T elem) {
		if(isEmpty())
			head=tail=new Node(elem,null,null);
		else {
		    tail.next=new Node(elem,tail,null);
		    tail=tail.next;
		}
		size++;
	}
	
	public T peekFirst() {
		return head.data;
	}
	
	public T peekLast() {
		return tail.data;
	}
	
	public T removeFirst() {
		if(isEmpty())  throw new RuntimeException("Empty!!");
		
		T data=head.data;
		head=head.next;
		size--;
		
		if(isEmpty())tail=null;
		else head.prev=null;
		
		return data;

		
	}
	
	public T removeLast() {
		if(isEmpty())  throw new RuntimeException("Empty!!");
		
		T data=tail.data;
		tail=tail.prev;
		size--;
		
		if(isEmpty())head=null;
		else tail.next=null;
		
		return data;
		
		
	}
	
	public T remove(Node<T> node) {
		if(node.prev==null) removeFirst();
		if(node.next==null) removeLast();
		
	    node.next.prev=node.prev;
	    node.prev.next=node.next;
	    
	    T data=node.data;
	    node.data=null;
	    node.prev=node.next=null;
	    size--;
	    return data;
	}


	
	
	private class Node<T>{
		 T data;
		 Node prev,next;
		 
		 Node(T data,Node<T> prev,Node<T> next){
			 this.data=data;
			 this.prev=prev;
			 this.next=next;
		 }
		 
		 public String toString() {return data.toString();}
		
	}




	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}




	

}
