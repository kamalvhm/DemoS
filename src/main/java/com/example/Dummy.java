package com.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Nodee {
	int val;
	Nodee left, right;

	Nodee(int item) {
		val = item;
		left = right = null;
	}
}

public class Dummy {

	public static void main(String[] args) {
		Nodee tree = new Nodee(1); // 1
		tree.left = new Nodee(2); // 2 3
		tree.right = new Nodee(3); // 4 5
		tree.left.left = new Nodee(4);
		tree.left.right = new Nodee(5);

		/**
		 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
		 *  (b) Preorder (Root, Left,Right):1 2 4 5 3 
		 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
		 */

		System.out.println("IN");
		inorder(tree);
		System.out.println("");
		inorderWithout(tree);
		//System.out.println("THIS:---->" + inorder2(tree));

		System.out.println("PRE");
		preorder(tree);
		System.out.println("");
		preorderWithout(tree);

		System.out.println("POST");
		postorder(tree);
		System.out.println("");
		postOrderWithoutRecursion(tree);

		
		bfs(tree);
	}

	private static void bfs(Nodee tree) {
		Queue<Nodee> q=new LinkedList<Nodee>();
		q.add(tree);
		Nodee current=tree;
		while(!q.isEmpty()) {
			current =q.poll();
			 System.out.print(current.val+", ");
			 
			 if(current.left!=null)
				 q.add(current.left);

			 
			 if(current.right!=null)
				 q.add(current.right);
		}
	}

	private static void postOrderWithoutRecursion(Nodee tree) {
		Stack<Nodee> stack=new Stack();
		Nodee current=tree;
		Nodee pre=tree;

		stack.push(current);
		
		while(!stack.isEmpty()) {
			current=stack.peek();
			
			 boolean isNochild=(current.left==null && current.right==null);
			 boolean isPreRight=(pre==current.right || (pre==current.left && current.right==null));
			 
			 if(isNochild || isPreRight) {
				 current =stack.pop();
				 System.out.print(current.val+", ");
				 pre=current;
			 }else {
				 if(current.right!= null) {
					 stack.push(current.right);
				 }
				 if(current.left!=null) {
					 stack.push(current.left);
				 }
			 }
			 
		}				
	}

	private static void inorderWithout(Nodee tree) {
		Stack<Nodee> stack=new Stack();
		Nodee current=tree;
		stack.push(current);
		
		while(!stack.isEmpty()) {
			 while(current.left!=null) {
				 current=current.left;
				 stack.push(current);
			 }
			 
			 current =stack.pop();
			 System.out.print(current.val+", ");
			 
			 while(current.right!= null) {
				 current=current.right;
				 stack.push(current);
			 }
			 
			
			
		}		
	}

	private static void preorderWithout(Nodee tree) {
		Stack<Nodee> stack=new Stack();
		Nodee current=tree;
		stack.push(current);
		
		while(!stack.isEmpty()) {
			 current =stack.pop();
			 System.out.print(current.val+", ");
			 
			 if(current.right!= null)
				 stack.push(current.right);
			 
			 if(current.left!=null)
				 stack.push(current.left);
			
		}
	}

	private static String inorder2(Nodee tree) {
		if(tree==null) {
			return "";
		}
		String l="",r="";
		if(tree.left!=null)
		l=inorder2(tree.left);
		else l="";
		if(tree.right!=null)
			r=inorder2(tree.right);
			else r="";
		
		return l+", "+tree.val+", "+r;
	}

	private static void inorder(Nodee tree) {
			if(tree!=null) {
				inorder(tree.left);
				System.out.print(tree.val+", ");
				inorder(tree.right);
			}
	}

	
	private static void preorder(Nodee tree) {
		if(tree!=null) {
			System.out.print(tree.val+", ");
			preorder(tree.left);
			preorder(tree.right);
		}
}
	
	
	private static void postorder(Nodee tree) {
		if(tree!=null) {
			postorder(tree.left);
			postorder(tree.right);
			System.out.print(tree.val+", ");
		}
	}
}
