package com.acrossPart;

import com.beans.TreeNode;

//https://leetcode.com/problems/longest-univalue-path/solution/
class Solution {
    static int ans;
    public int longestUnivaluePath(TreeNode root) {
        
        ans = 0;
        arrowLength(root);
        return ans;
    }
    
        
     public static int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

     
     
     
     
     /***********************
      * 
      * static int ans;
    public int solution(Tree T) {
        ans=0;
        HashSet<Integer> set=new HashSet<>();
        solve(T,set);
        return ans;
    }

     public static int solve(Tree node,HashSet<Integer> set) {
        if (node == null) return 0;
        int left = solve(node.l,set);
        int right = solve(node.r,set);
        int arrowLeft = 0, arrowRight = 0;
        
        if (node.l != null && !set.contains(node.l.x)) {
            set.add(node.l.x);
            arrowLeft += left + 1;
        }
        if (node.r != null && !set.contains(node.r.x)) {
             set.add(node.r.x);
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
      */
    
}