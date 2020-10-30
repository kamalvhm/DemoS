package com.beans;

import com.datastructure.TreePrinter.PrintableNode;

public class TreeNode<T> implements PrintableNode{
    T val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(T val) { this.val = val; }
    TreeNode(T val, TreeNode left, TreeNode right) {
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