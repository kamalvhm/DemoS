package com.practice;



public class BinarySearchTree<T extends Comparable<T>> {
	
	private int nodeCount=0;
	private Node root=null;
	
	private class Node{
		private T val;
		private Node left;
		private Node right;
		
		Node(T val,Node left,Node right){
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
	
	public int size() {return nodeCount;}
	
	public boolean isEmpty() {return size()==0;}
	
	public boolean add(T elem) {
		if(contains(elem))return false;
		else {
			root=add(root,elem);
			nodeCount++;
			return true;
		}
	}

	private Node add(Node node,T elem) {
		if(node==null)node= new Node(elem,null,null);
		int cmp=elem.compareTo(node.val);
		if(cmp<0)
			node.left=add(node.left,elem);
		else {
			node.right=add(node.right,elem);
		}
		return node;
	}
	
	public boolean remove(T elem) {
		if(contains(elem)) {
			root=remove(root,elem);
			nodeCount--;
			return true;
		}
		return false;
	}
	
	private Node remove(Node node, T elem) {
		if(node==null)return null;
		int cmp=elem.compareTo(node.val);
		if(cmp<0)
			node.left=remove(node.left,elem);
		else if(cmp>0)node.right=remove(node.right,elem);
		else {
			if(node.left==null) {
				Node rightChild=node.right;
				node.val=null;
				node=null;
				return rightChild;
			}
			else if(node.right==null) {
				Node leftChild=node.left;
				node.val=null;
				node=null;
				return leftChild;
			}
			else {
				Node tmp=digLeft(node.right);
				node.val=tmp.val;
				node.right=remove(node.right,tmp.val);
			}
		}
		return node;
		
	}

	public Node digLeft(Node node) {
		Node cur=node;
		while(cur.left!=null) {
			cur=cur.left;
		}
		return cur;
	}
			
	public boolean contains(T elem) {
		return contains(root,elem);
	}
	
	private boolean contains(Node node,T elem ) {
		if(node==null)return false;
		int cmp=elem.compareTo(node.val);
		if(cmp<0)
			return contains(node.left,elem);
		else if(cmp>0)return contains(node.right,elem);
		return true;
	}
	
	
			
		
			
	
}
