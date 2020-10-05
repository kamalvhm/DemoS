package com.datastructure;

public class Node<T> {
	private T t;
	public Node next_node=null;
	public Node previous_node=null;
	
	
	public Node() {
		
	}

	
	public Node(T t,Node next_node,Node previous_node) {
		this .t =t;
		this.next_node=next_node;
		this.previous_node=previous_node;
	}


	public T getT() {
		return t;
	}


	@Override
	public String toString() {
		return " t ";
	}


	public void setT(T t) {
		this.t = t;
	}

}
