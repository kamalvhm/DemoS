package com.recursion;

import org.apache.spark.sql.catalyst.expressions.Reverse;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;

public class Practice {

	public static void main(String[] args) {
		//1) Print No from 7 to 1 and reverse 
		print(7);
		
		TreeNode<Integer> tree = new TreeNode(1); // 1
		tree.left = new TreeNode(2); // 2 3
		tree.right = new TreeNode(3); // 4 5
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		//2)Write function to return height of given tree
		//System.out.print(TreePrinter.getTreeDisplay(tree));
		//System.out.print("Height:-"+height(tree));
		
		int [] a= {4,6,2,1,3};
		//3)sort a given array
		char c []= {'h','e'};
		reversee(c,c.length-1,0);
		System.out.print(c);
					
	}

	private static void print(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
	private static int height(TreeNode root) {
		if(root==null)return 0;
		else return Math.max(height(root.left), height(root.right))+1;
	}
	
	
	 public static void reversee(char[] s ,int pos,int start){
	        if(pos<0)return;
	        char c=s[pos];
	        reversee(s,pos-1,start+1);
	        s[start]=c;
	        return;
	    }

}
