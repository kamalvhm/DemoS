package com.dp;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;

public class DpOnTrees4 {
	/**
	 * General Syntax
	 * How Dp can be appilied on trees (Identification)
	 * 1)Diameter of binary tree
	 * 2)Maximum Path Sum from any node to any node 
	 * 3)Maximum path sum from leaf to leaf https://www.codingninjas.com/studio/problems/maximum-path-sum-between-two-leaves_794950
	 * 4)Diameter of N-ary tree
	 * 
	 * 
	 * 
	 */
	 
	public static void main(String[] args) {
		//1)Diameter of binary tree	:- longest path between two leafs
		DpOnTrees4 d=new DpOnTrees4();

		int [] a= {1,2,3,4,5,6,7,8,9,10,11};
		TreeNode tree =d.buildBstFromArray(a, 0, a.length-1);
		System.out.print(TreePrinter.getTreeDisplay(tree));
		
		System.out.println("diameterOfBinaryTree  :-"+d.diameterOfBinaryTree(tree));
		System.out.println("Binary Tree Maximum Path Sum :-"+d.maxPathSum(tree));

		
	}
	//543. Diameter of Binary Tree | https://leetcode.com/problems/diameter-of-binary-tree/
	//Pass res by refrence check leet 
	public   int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        In res=new In();
        solve(root,res);
        return res.i>0?res.i-1:0;
        
    }
    
    public static int solve(TreeNode root, In res){
        
        if(root==null) return 0;
        
        int l=solve(root.left,res);
        int r=solve(root.right,res);
        
        int temp=Math.max(l,r)+1;
        int ans=Math.max(temp,1+l+r);
        
        res.i=Math.max(res.i,ans);
        
        return temp;
    }
/*	public static int solve(TreeNode root,Integer res) {
		if(root==null) return 0;
		int l=solve(root.left,res);
		int r=solve(root.right,res);
		
		int temp=Math.max(l, r)+1;
		int ans=Math.max(temp, l+r+1);
		res=Math.max(res, ans);
		return temp;
	}*/
	//124. Binary Tree Maximum Path Sum
	 public class In{
		 In(){}
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
	 //To build BST from array values recursivly
	 public TreeNode buildBstFromArray(int a[] ,int start,int end) {
		 if(start>end)
			 return null;
		 int mid=(start+end)/2;
		 TreeNode<Integer> node=new TreeNode<>(a[mid]);
		 node.left=buildBstFromArray(a,start,mid-1);
		 node.right=buildBstFromArray(a, mid+1, end);
		 return node ;
	 }
	 
	 //-------------------------------------PRACTICE----------------------------------
	 public static int solve3(TreeNode root,In res) {
		 if(root==null) return 0;
		 int l=solve3(root.left, res);
		 int r=solve3(root.right, res);
		 int temp=Math.max(l, r)+(int)root.val;
		 if(root.left==null && root.right==null)
			 temp=Math.max(temp,(int)root.val);
		 int ans=Math.max(temp, (int)root.val+l+r);
		 res.i=Math.max(res.i, ans);
		 return temp;
		 
	 }
	 
	 
	 //Max Path sum from leaf to leaf  https://www.codingninjas.com/studio/problems/maximum-path-sum-between-two-leaves_794950?leftPanelTabValue=SUBMISSION
	 class Number{
		    long num;
		    Number(long num)
		    {
		        this.num = num;
		    }
		}

		public class Solution {
			public  long findMaxSumPathHelper(TreeNode root, Number maxPathSum) {
				if (root == null) {
					return -1;
				}
				if (root.left == null && root.right == null) {
					return root.data;
				}

				/* 
					Variable to store the maximum sum of the path from the current node to leaf
				 	in the left subtree.
				*/
				long maxSumLeftPath = findMaxSumPathHelper(root.left, maxPathSum);

				/*
					Variable to store the maximum sum of the path from the current node to leaf
				 	in the right subtree.
				*/
				long maxSumRightPath = findMaxSumPathHelper(root.right, maxPathSum);

				// If the current node has both children, update the value of maxPathSum.
				if (root.left != null && root.right != null) {

					maxPathSum.num = Math.max(maxPathSum.num, maxSumLeftPath + maxSumRightPath + root.data);
					return Math.max(maxSumLeftPath, maxSumRightPath) + root.data;

				} else if (root.left == null) {

					return maxSumRightPath + root.data;

				} else {

					return maxSumLeftPath + root.data;

				}
			}

			public  long findMaxSumPath(TreeNode root) {
				// Variable to store the maximum sum of path between two leaves for the given tree.
				Number maxPathSum = new Number(-1L);
				findMaxSumPathHelper(root, maxPathSum);
				return maxPathSum.num;
			}
}
		
		
		//ALTERNATIVE SIMPLIFIED VERSION FOR ABOVE 
//		public static class In{
//			 In(){}
//		        long i=-1L;
//		    }
//		    
//		
//		
//		public static long findMaxSumPath(TreeNode root) {
//			In result=new In();
//			solve(root,result);
//			return result.i;
//		}
//
//		public static long solve(TreeNode root,In result){
//			if(root==null)return 0;
//			if(root.left==null && root.right==null)return root.data;
//			long left=solve(root.left,result);
//			long right=solve(root.right,result);
//			if(root.left!=null && root.right!=null){
//				long temp=Math.max(left,right)+root.data;
//				long ans=Math.max(temp,left+right+root.data);
//				result.i=Math.max(result.i,ans);
//				return temp;
//			}else if(root.left==null)
//					return right+root.data;
//			else return left+root.data;
//		
//		}
}
