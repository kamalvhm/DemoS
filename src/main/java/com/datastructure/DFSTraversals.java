package com.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Nodee {
	int val;
	Nodee left, right;

	Nodee(int item) {
		val = item;
		left = right = null;
	}
}
//NOTE:- IN BINARY SEARCH TREE (Remmeber in BSt not in below tree) INORDER TRAVERSAL ALSWAYS GiVES SORTED ORDER
public class DFSTraversals {

	public static void main(String args[]) {
		Nodee tree = new Nodee(1); 				       // 1
		tree.left = new Nodee(2); 					// 2	 3
		tree.right = new Nodee(3); 				   // 4 5
		tree.left.left = new Nodee(4);
		tree.left.right = new Nodee(5);
		//BST
		/*Nodee tree = new Nodee(4); 					// 4
		tree.left = new Nodee(2); 					// 2	 5
		tree.right = new Nodee(5); 				   // 1 3
		tree.left.left = new Nodee(1);
		tree.left.right = new Nodee(3);*/

		/**
		 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
		 * (b) Preorder (Root, Left, Right):1 2 4 5 3 
		 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
		 */

	
		System.out.println("IN");
		inorder(tree);
		System.out.println("");
		inorderWithout(tree);
		System.out.println("THIS:---->"+inorder2(tree));

		
		System.out.println("PRE");
		preorder(tree);
		System.out.println("");
		preorderWithout(tree);
		
		System.out.println("POST");
		postorder(tree);
		System.out.println("");
		postOrderWithoutRecursion(tree);

	}

	public static void inorder(Nodee root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.val + ", ");
		inorder(root.right);

	}
	
	public static String inorder2(Nodee root) {
		if (root == null)
			return "";
			String leftS; String rightS;
		
		   if (root.left != null)
		   leftS=inorder2(root.left);
		   else leftS="";
		   
		   if (root.right != null)
		   rightS=inorder2(root.right);
		   else rightS="";
		return leftS+root.val+rightS;
	}
	//TC:-O(n) SC:-Hieght of the tree  O(log n) But in worst case (skew tree linear tree) it will be O(n)
	public static void preorder(Nodee root) {
		if (root == null)
			return;
		System.out.print(root.val + ", ");
		preorder(root.left);
		preorder(root.right);

	}

	public static void postorder(Nodee root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.val + ", ");
	}

	//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/ Tested!!!
	public static void inorderWithout(Nodee root) {
		Stack<Nodee> st = new Stack<>();
		Nodee current = root;

		while (!st.isEmpty() || current != null) {
			if (current != null) {
				st.push(current);
				current = current.left;
			} else {
				Nodee node = st.pop();
				System.out.printf("%s ", node.val);
				current = node.right;
			}

		}
	}


	/*144. Binary Tree Preorder Traversal || https://leetcode.com/problems/binary-tree-preorder-traversal/
	 * // Push root in our stack 
	 * // While stack is not empty 
	 * // Pop current node 
	 * //Visit current node 
	 * // Push right child, then left child to stack
	 */
	public static void preorderWithout(Nodee root) {
		Stack<Nodee> st = new Stack<>();
		Nodee current = root;
		st.push(current);

		while (!st.isEmpty()) {

			current = st.pop();
			System.out.print(current.val + ", ");

			if (current.right != null) {
				st.push(current.right);
			}
			if (current.left != null) {
				st.push(current.left);
			}

		}

	}
	//https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
//https://www.java67.com/2017/05/binary-tree-post-order-traversal-in-java-without-recursion.html	
//We first insert the right node because Stack is a LIFO (last in first out) data structure and as per post-order traversal 
//we need to explore the left subtree before the right subtree. If you are not familiar with Stack (LIFO) and Queue (FIFO) data
//structure which is used in level order traversal,
//!!!!!!! USE BELOW METHOD traversePostOrderWithoutRecursion!!!!!!!!
	public static void postOrderWithoutRecursion(Nodee root) {
		Stack<Nodee> nodes = new Stack<>();
		nodes.push(root);
		while (!nodes.isEmpty()) {
			Nodee current = nodes.peek();
			//print if its a leaf node
			if (current.left == null && current.right == null) {
				System.out.printf(nodes.pop().val+", ");
			} else {
				if (current.right != null) {
					nodes.push(current.right);
					//we are deleting links from current just to avoid this use below algo
					current.right = null;
				}
				if (current.left != null) {
					nodes.push(current.left);
					current.left = null;
				}
			}
		}
	}
	//https://www.baeldung.com/java-depth-first-search
	//Expaination:-  https://www.youtube.com/watch?v=kcTcfOWFizA
	public void traversePostOrderWithoutRecursion(Nodee root) {
	    Stack<Nodee> stack = new Stack<Nodee>();
	    //This is to keep last printed/poped node
	    Nodee prev = root;
	    Nodee current = root;
	    stack.push(root);
	 
	    while (!stack.isEmpty()) {
	        current = stack.peek();
	        //checking if having any child if not then can be printed
	        boolean hasChild = (current.left != null || current.right != null);
	        //This boolean is to check if last poped node is either null (previous is left and right is null) or right of current node because we can print root node after right node is printed or its null
	        boolean isPrevLastChild = (prev == current.right || 
	          (prev == current.left && current.right == null));
	 
	        if (!hasChild || isPrevLastChild) {
	            current = stack.pop();
				System.out.printf(current.val+", ");
	            prev = current;
	        } else {
	            if (current.right != null) {
	                stack.push(current.right);
	            }
	            if (current.left != null) {
	                stack.push(current.left);
	            }
	        }
	    }   
	}
	

}
