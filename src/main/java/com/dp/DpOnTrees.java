package com.dp;

import com.beans.TreeNode;

public class DpOnTrees {
	/**
	 * General Syntax
	 * How Dp can be appilied on trees (Identification)
	 * 1)Diameter of binary tree
	 * 2)Maximum Path Sum from any node to any node 
	 * 3)Maximum path sum from leaf to leaf
	 * 4)Diameter of N-ary tree
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		//1)Diameter of binary tree	:- longest path between two leafs
		
	}
	//543. Diameter of Binary Tree | https://leetcode.com/problems/diameter-of-binary-tree/
	//Pass res by refrence check leet 
	public int solve(TreeNode root,Integer res) {
		if(root==null) return 0;
		int l=solve(root.left,res);
		int r=solve(root.right,res);
		
		int temp=Math.max(l, r)+1;
		int ans=Math.max(temp, l+r+1);
		res=Math.max(res, ans);
		return temp;
	}
	//124. Binary Tree Maximum Path Sum
	 public class In{
	        int i=Integer.MIN_VALUE;
	    }
	    public int maxPathSum(TreeNode root) {
	        In i=new In();//class to pass integer by reference
	        solve2(root,i);
	        return i.i==Integer.MIN_VALUE?0:i.i;
	    }
	
	 public static int solve2(TreeNode root,In res){
	        if(root==null) return 0;
	        
	        int l=solve2(root.left,res);
	        int r=solve2(root.right,res);
	        
	        int temp=Math.max(Math.max(l,r)+(int)root.val,(int)root.val);
	        int ans=Math.max(temp,l+r+(int)root.val);
	        
	        res.i=Math.max(res.i,ans);
	        
	        return temp;
	    }

}
