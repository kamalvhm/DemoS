package com.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.beans.TreeNode;


//Hint in quetion:- top to bottom.
public class BFSTraversals {

	public static void main(String args[]) {
		Nodee tree = new Nodee(1); 						// 1
		tree.left = new Nodee(2); 				   	// 2	 3
		tree.right = new Nodee(3);                 // 4 5
		tree.left.left = new Nodee(4);
		tree.left.right = new Nodee(5);

	
		bfsTraversal(tree);
		System.out.println();
		printLevelOrder(tree);
	}
	
	public static void bfsTraversal(Nodee root) {
		Queue<Nodee> queue = new ArrayDeque<Nodee>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Nodee currentNode =queue.poll();
			System.out.print(currentNode.val+", ");
			
			if(currentNode.left!=null)
				queue.offer(currentNode.left);
			
			if(currentNode.right!=null)
				queue.offer(currentNode.right);
			
			
			
		}
		
	}

	
	/* function to print level order traversal of tree*/
    static void printLevelOrder(Nodee root) 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
    
    /* Print nodes at the given level */
    static void printGivenLevel (Nodee root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.val + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
  
    /* Compute the "height" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/
    static int height(Nodee root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
            /* use the larger one */
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    } 
  

      
    //199. Binary Tree Right Side View   #*
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues=new ArrayList<>();
        if(root==null) return visibleValues;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root); 
        
        while(!q.isEmpty()){
            int qSize=q.size();
            for(int i=0;i<qSize;i++)
            {
                TreeNode current=q.poll();
                if(i==qSize-1)
                    visibleValues.add((int)current.val);
                
                if(current.left!=null)
                    q.offer(current.left);
                     
                if(current.right!=null)
                    q.offer(current.right);
            }
        }
        return visibleValues;
    }
    
    //102. Binary Tree Level Order Traversal  !!!MEDIUM!!!  #*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int qSize=queue.size();
            List<Integer> currentLevel=new ArrayList<>();
            
          for(int i=0;i<qSize;i++){
                  TreeNode  current =queue.poll();
                  currentLevel.add((int)current.val);
                
            if(current.left!=null){
                queue.offer(current.left);
                }
            if(current.right!=null){
                queue.offer(current.right);
                }
            }
            
            result.add(currentLevel);
        }
        return result;
    }
}
