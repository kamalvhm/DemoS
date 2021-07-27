package com.datastructure;

import com.beans.TreeNode;

public class BinaryTreeRelated<T extends Comparable<T>> {

	private int node_count = 0;

	private Node root;

	private class Node {
		private T data;
		private Node left, right;

		Node(Node left, Node right, T elem) {
			this.left = left;
			this.right = right;
			data = elem;
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private int size() {
		return node_count;
	}

	public boolean add(T elem) {
		if (contains(elem))
			return false;
		else {
			root = add(root, elem);
			node_count++;
			return false;
		}

	}

	private Node add(Node node, T elem) {
		if (root == null) {
			return new Node(null, null, elem);
		} else {
			if (elem.compareTo(root.data) < 0) {
				node.left = add(node.left, elem);
			} else {
				node.right = add(node.right, elem);
			}
		}
		return node;
	}

	private boolean contains(T elem) {
		return contains(root, elem);
	}

	private boolean contains(Node root, T elem) {
		if (root == null)
			return false;
		int cmp = elem.compareTo(root.data);

		if (cmp < 0) {
			return contains(root.left,elem);	
		}else if  (cmp > 0) {
			return contains(root.right,elem);	
		}
		return true;
	}
	
	public boolean remove(T elem) {
		if(contains(elem)) {
			root=remove(root,elem);
			node_count--;
			return true;
		}
		else return false;
	}

	private Node remove(Node node, T elem) {
			if(node==null)return null;
			
			int cmp=elem.compareTo(root.data);
			
			if(cmp<0) {
				node.left=remove(node.left,elem);
			}else if (cmp>0) {
				node.right=remove(node.right,elem);
			}else {
				
				if(node.left == null) return node.right;
				else if(node.right == null) return node.left;
				
				else {
					Node tmp =findMin(node.right);
					node.data = tmp.data;
					node.right = remove(node.right, tmp.data);
				}
			}return node;
	}

	private Node findMin(Node node) {
		while (node.left != null) node = node.left;
	    return node;
	}
	
	

}
