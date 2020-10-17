package com.datastructure;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;



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
      

}
