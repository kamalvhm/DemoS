package com.acrossPart;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private Node head;
	private int nodeCount;
	private class Node{
		T data;
		Node left,right;
		Node(Node left,Node right,T data){
			this.left=left;
			this.right=right;
			this.data=data;
		}
	}
	
	public boolean isEmpty() {return size()==0;}
	
	public int size() {return nodeCount;}
	
	public boolean add(T elem) {
		if(contains(elem))return false;
		else {
			add(head,elem);
			nodeCount++;
			return true;
		}
	}
	
	private Node add(Node node,T elem) {
		if(node==null)
			node=new Node(null,null,elem);
		else {
			if(elem.compareTo(node.data)<0)
				node.left=add(node.left,elem);
			else node.right=add(node.right,elem);
		}
		return node;
	}
	
	private boolean remove(T elem) {
		if(contains(elem)) {
			remove(head,elem);
			return true;
		}else return false;
	}
	private Node remove(Node node,T elem) {
		if(contains(elem))return null;
		int cmp=elem.compareTo(node.data);
		if(cmp<0)
			node.left=remove(node.left,elem);
		else if(cmp>0)
				node.right=remove(node.right,elem);
		else {
			if(node.left==null) {
				Node rightChild=node.right;
				node.data=null;
				node=null;
				return rightChild;
			}
			else if(node.right==null) {
				Node leftChild=node.left;
				node.data=null;
				node=null;
				return leftChild;
			}else {
				Node tmp=digLeft(node.right);
				node.data=tmp.data;
				node.right=remove(node.right,tmp.data);
			}
		}
		return node;
	}
	
	private Node digLeft(Node node) {
		Node curr=node;
		while(curr.left!=null) {
			curr=curr.left;
		}
		return curr;
	}
	
	public boolean contains(T elem) {
		return contains(head,elem);
	}
	private boolean contains(Node node,T elem) {
		if(node==null)return false;
		int cmp=elem.compareTo(node.data);	
		if(cmp<0)
			return contains(node.left,elem);
		else if(cmp>0)
			return contains(node.right,elem);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
