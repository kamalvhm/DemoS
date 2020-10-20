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
     //235. Lowest Common Ancestor of a Binary Search Tree
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
         if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left , p, q);
         return root;
     }
     //572. Subtree of Another Tree
     public boolean isSubtree(TreeNode s, TreeNode t) {
         if(s==null){
            return false; 
         }
         else if(isItentical(s,t)){
            return true; 
         } 
         else{
             return isSubtree(s.left,t) || isSubtree(s.right,t);
         }
     }
     
     public static boolean isItentical(TreeNode s, TreeNode t){
   /* 	  if(s==null && t==null)return true;
          if(s==null || t==null) return false; THIS CAN BE WRITTEN AS BELOW*/
        if(s==null || t==null) return s==null && t==null;
        else if(s.val==t.val){
             return isItentical(s.left,t.left) && isItentical(s.right,t.right);
         }else{
           return false;  
         }
     }
     
     //112. Path Sum
     public boolean hasPathSum(TreeNode root, int sum) {
         if(root==null) return false;
         if(sum-root.val==0 && root.left==null && root.right==null) return true;
         else return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
     }
     
   
     
     
     
     
}
