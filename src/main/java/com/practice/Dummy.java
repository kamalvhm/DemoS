package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.spi.CurrencyNameProvider;

import org.apache.commons.math3.ode.nonstiff.GillIntegrator;

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
		System.out.println("");
		System.out.println("T>" + inorder2(tree));

		System.out.println("PRE");
		preorder(tree);
		System.out.println("");
		preorderWithout(tree);

		System.out.println("POST");
		postorder(tree);
		System.out.println("");
		postOrderWithoutRecursion(tree);

		System.out.println("");
		bfs(tree);
		System.out.print(levelOrder(tree));
	
		int [] a= {5,7,7,8,8,8,10};
		//System.out.println(search(a,8));
		
	      char [][] islandGrid = new char[][] {
              {'1', '1', '1', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '1', '0', '1'}};
              
        System.out.println("No of Islands: " + numIslandsIterativeDFS(islandGrid));
               
      /*  System.out.println(Pow(2,2));*/

	}
	
	private static String inorder2(TreeNode tree) {
	return "";
	
	}
//50. Pow(x, n)
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
		int h=grid.length;
		int l=grid[0].length;
		int count=0;
		for(int i=0;i<h;i++) {
			for(int j=0;j<l;j++) {
				if(grid[i][j]=='1') {
					DFS(grid,i,j);
					count++;
				}
			}
		}
		return count;
		
	}
    private static void DFS(char[][] grid, int row, int col) {
    	


	}

	public static int numIslandsIterativeDFS(char[][] grid) {
		int count=0;
		Stack<int[]> st=new Stack<>();
		int h=grid.length;
		int l=grid[0].length;
		for(int i=0;i<h;i++) {
			for(int j=0;j<l;j++) {
				if(grid[i][j]=='1') {
					st.push(new int[]{i,j});
					grid[i][j]='0';
					
					while(!st.isEmpty()) {
						int[] cur=st.pop();
						for(int [] dir:direction) {
							int r=cur[0]+dir[0];
							int c=cur[1]+dir[1];
							
							if(r>=0 && c>=0 && r<h && c<l && grid[r][c]=='1') {
								st.push(new int[] {r,c});
								grid[r][c]='0';
							}

						}
					}
					count++;
				}
			}
		}
			
		return count;

	}
    
    public static int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};


	private static void bfs(TreeNode tree) {
		
	}
	
	 public static List<List<Integer>> levelOrder(TreeNode tree){
		 List<List<Integer>> result=new ArrayList<>();
		
			return result;
	 }

	private static void inorderWithout(TreeNode tree) {
		
	}
	
	private static void preorderWithout(TreeNode tree) {
		
	}
	
	private static void postOrderWithoutRecursion(TreeNode tree) {
		
	}

	private static void postorder(TreeNode tree) {
		if(tree!=null) {
			postorder(tree.left);
			postorder(tree.right);
			System.out.print(tree.val+", ");
		}
	}

	private static void preorder(TreeNode tree) {
		if(tree!=null) {
			System.out.print(tree.val+", ");
			preorder(tree.left);
			preorder(tree.right);
		}
	}

	private static void inorder(TreeNode tree) {
		if(tree!=null) {
			inorder(tree.left);
			System.out.print(tree.val+", ");
			inorder(tree.right);
		}
	}


}
