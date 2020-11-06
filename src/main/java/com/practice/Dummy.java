package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;



public class Dummy {

	public static void main(String[] args) {
		TreeNode<Integer> tree = new TreeNode(1); // 1
		tree.left = new TreeNode(2); // 2 3
		tree.right = new TreeNode(3); // 4 5
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		
		System.out.print(TreePrinter.getTreeDisplay(tree));
		/**
		 * (a) Inorder (Left, Root, Right) 	 : 4 2 5 1 3
		 * (b) Preorder (Root, Left,Right) 	 : 1 2 4 5 3 
		 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
		 */
	
		System.out.println("IN");
		inorder(tree);
		System.out.println("");
		inorderWithout(tree);
		System.out.println("THIS:---->" + inorder2(tree));

	/*	System.out.println("PRE");
		preorder(tree);
		System.out.println("");
		preorderWithout(tree);*/

		System.out.println("POST");
		postorder(tree);
		System.out.println("");
		postOrderWithoutRecursion(tree);

		/*System.out.println("");
		bfs(tree);
		System.out.print(levelOrder(tree));*/
	
		/*int [] a= {5,7,7,8,8,8,10};
		System.out.println(search(a,8));*/
		
	      char [][] islandGrid = new char[][] {
              {'1', '1', '1', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '0', '0', '1'}};
              
        System.out.println("No of Islands: " + numIslandsIterativeDFS(islandGrid));
               
      /*  System.out.println(Pow(2,2));*/

	}
	
	private static String inorder2(TreeNode tree) {
		return "";
	}

	private static int Pow(int base, int pow) {
		if(pow==0) return 1;
		else {
			int half=Pow(base,pow/2);
			int full=half*half;
			if(pow%2==1)
				full=full*base;
			return full;
		}
		
	}

	public static int numIslands(char[][] grid) {
		
		return -1;
	}
    private static void DFS(char[][] grid, int row, int col) {
    	

	}

	public static int numIslandsIterativeDFS(char[][] grid) {
    	
		
    	
    	
    	
    	return -1;
    }
    
    public static int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};

	private static int search(int[] a, int target) {
		
		
		return -1;
	}

	private static void bfs(TreeNode tree) {
		
		
	}
	
	 public static List<List<Integer>> levelOrder(TreeNode root){
		 
			return null;
	 }

	private static void inorderWithout(TreeNode tree) {
		
		
	}
	
	private static void preorderWithout(TreeNode tree) {
		
	}
	
	private static void postOrderWithoutRecursion(TreeNode tree) {
		
	}

	private static void postorder(TreeNode tree) {
		
	}

	private static void preorder(TreeNode tree) {
		
	}

	private static void inorder(TreeNode tree) {
		
	}


}
