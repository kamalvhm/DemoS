package com.recursion;

import java.util.ArrayList;
import java.util.List;

 import com.datastructure.TreePrinter;

class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int item) {
		val = item;
		left = right = null;
	}
}
//STUDY:-https://www.youtube.com/watch?v=kHi1DUhp9kM&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
//https://www.youtube.com/watch?v=kHi1DUhp9kM&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class TreeRecursion {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1); // 1
		tree.left = new TreeNode(2); // 2 3
		tree.right = new TreeNode(3); // 4 5
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		//System.out.print(sumLeaf(tree));
		//System.out.print(TreePrinter.getTreeDisplay(tree));
	}
	//	100	Same Tree
	 public boolean isSameTree(TreeNode p, TreeNode q) {
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
    	  //checking if both are on right 
         if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
         //checking if both are on left 
         if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left , p, q);
         //this means one is on left and one is on right
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
     
   //98. Validate Binary Search Tree CALL:-validate(root,null,null);
     public static boolean validate(TreeNode root ,Integer max,Integer min){
         if(root==null) return true;
         if(max!=null && root.val>=max || min!=null && root.val<=min) return false;
         else return validate(root.left,root.val,min) && validate(root.right,max,root.val);
     }
     
     //404. Sum of Left Leaves
     public static int leftSum(TreeNode root,int sum,boolean isleft){
         if(root==null) return 0;
         if(root.left==null && root.right==null && isleft) return root.val;
         if(root.left!=null)
             sum+=leftSum(root.left,0,true);
         if(root!=null)
             sum+=leftSum(root.right,0,false);
         return sum;
     } 
     
     
     //894. All Possible Full Binary Trees       (check DS NOTES)                    ##Medium##   #*
     public List<TreeNode> allPossibleFBT(int N) {
 		List<TreeNode> ans=new ArrayList<>();
 		if(N%2==0){
 			return ans;            
 		}if(N==1){
 			TreeNode root=new TreeNode(0);
 			ans.add(root);
 		}
 		//for odd loop
 		for(int i=1;i<N;i+=2){
 			//in left we are assigning 1,3,5
 			for(TreeNode left : allPossibleFBT(i)){
 				//we are assigning same in reverse order for right
 				for(TreeNode right : allPossibleFBT(N-i-1)){
 					TreeNode root=new TreeNode(0);
 					root.left=left;
 					root.right=right;
 					ans.add(root);                    
 				}
 			}
 		}
 		return ans;        
 	}
     //40. Combination Sum II
     
     
}
