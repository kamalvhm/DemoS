package com.beans;

import com.datastructure.TreePrinter.PrintableNode;

public class TreeNode<T> implements PrintableNode{
    public T val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(T val) { this.val = val; }
    public TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    @Override
	public PrintableNode getLeft() {
		return this.left;
	}

	@Override
	public PrintableNode getRight() {
		return this.right;
	}

	@Override
	public String getText() {
		return val.toString();
	}
}