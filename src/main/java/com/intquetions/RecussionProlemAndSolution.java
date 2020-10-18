package com.intquetions;

class Nodee {
	int val;
	Nodee left, right;

	Nodee(int item) {
		val = item;
		left = right = null;
	}
}
public class RecussionProlemAndSolution {
	//	100	Same Tree
	 public boolean isSameTree(Nodee p, Nodee q) {
	        if(p == null && q == null) {
	            return true;
	        }
	        else if((p != null && q == null) || (p == null && q != null)) {
	            return false;
	        }
	        else if(p.val != q.val) {
	            return false;
	        }
	        
	        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	    }
	 
	 
	 //101. Symmetric Tree
     public boolean isSymmetric(TreeNode l1,TreeNode l2) {
         if(l1==null && l2==null)return true;
         if(l1==null || l2==null)return false;
          return (l1.val==l2.val && isSymmetric(l1.left,l2.right) && isSymmetric(l1.right,l2.left));
     }
     //104. Maximum Depth of Binary Tree
     public int maxDepth(TreeNode root) {
         if(root==null)return 0;
         else return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
     }
}
