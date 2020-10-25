package com.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import org.apache.commons.math3.ode.nonstiff.GillIntegrator;

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
	/**
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

		System.out.println("");
		bfs(tree);
	*/
		/*int [] a= {5,7,7,8,8,10};
		System.out.println(search(a,8));*/
		
	      char [][] islandGrid = new char[][] {
              {'1', '1', '1', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '0', '0', '1'}};
              
               //System.out.println("No of Islands: " + numIslandsIterativeDFS(islandGrid));
               
               System.out.println(Pow(2,2));

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
		int h = grid.length;
		if(h==0)return 0;
		int l = grid[0].length;
		int count = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < l; j++) {
				if(grid[i][j]=='1') {
					DFS(grid,i,j);
					count++;
				}
			}
		}
		return count;
	}
    private static void DFS(char[][] grid, int row, int col) {
		int h=grid.length;
		int l=grid[0].length;
		
		if(row<0 ||col <0 || row >=h || col>=l || grid[row][col]!='1')return;
		grid[row][col]='0';
		DFS(grid,row+1,col);
		DFS(grid,row-1,col);
		DFS(grid,row,col+1);
		DFS(grid,row,col-1);

	}

	public static int numIslandsIterativeDFS(char[][] grid) {
    	int h=grid.length;
    	int l=grid[0].length;
    	Stack<int[]> st=new Stack<>();
    	int count=0;
    	for(int i=0;i<h;i++) {
    		for(int j=0;j<l;j++) {
        		if(grid[i][j]=='1') {
        			st.push(new int[]{i,j});
        			grid[i][j]='0';
        		
        		
        		while(!st.isEmpty()) {
        			int[] current=st.pop();
        			
        			for(int[] dir:direction) {
        				int row=current[0]+dir[0];
        				int col=current[1]+dir[1];
        				
        				if(row>=0 && row<h && col>=0 && col<l && grid[row][col]=='1') {
        					st.push(new int [] {row,col});
        					grid[row][col]='0';
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

	private static int search(int[] a, int i) {
		int low=0;
		int high=a.length-1;
		while(low<=high) {
			int mid=low+high-low/2;
			if(mid==high|| a[mid+1]>i && a[mid]==i)return mid;
			else if(i>a[mid])low=mid+1;
			else high=mid-1;
		}
		return -1;
	}

	private static void bfs(Nodee tree) {
		Nodee current =tree;
		Queue<Nodee> q=new LinkedList();
		q.offer(tree);
		
		while(!q.isEmpty()) {
			current=q.poll();
			System.out.print(current.val+" ,");
			
			if(current.left!=null) {
				q.offer(current.left);
			}
			
			if(current.right!=null) {
				q.offer(current.right);
			}
		}
		
	}

	private static void inorderWithout(Nodee tree) {
		Nodee current =tree;
		Stack<Nodee> st =new Stack<>();
		st.push(current);
		while(!st.isEmpty()) {
			while(current.left!=null) {
				current=current.left;
				st.push(current);
			}
			current=st.pop();
			System.out.print(current.val+" ,");
			
			while(current.right!=null) {
				current=current.right;
				st.push(current);
			}
			
		}
	}
	
	private static void preorderWithout(Nodee tree) {
		Nodee current =tree;
		Stack<Nodee> st =new Stack<>();
		st.push(current);
		while(!st.isEmpty()) {
			current=st.pop();
			System.out.print(current.val+" ,");
			
			if(current.right!=null) {
				st.push(current.right);
			}
			if(current.left!=null) {
				st.push(current.left);
			}
			
		}
	}
	
	private static void postOrderWithoutRecursion(Nodee tree) {
		Nodee current =tree;
		Nodee previous=tree;
		Stack<Nodee> st =new Stack<>();
		st.push(current);
		while(!st.isEmpty()) {
			current=st.peek();
			boolean isNoChild=current.left==null && current.right==null;
			boolean isPreviousRight=previous==current.right || ( previous==current.left && current.right==null);
			if(isNoChild || isPreviousRight) {
				current =st.pop();
				System.out.print(current.val+" ,");
				previous=current;
			}
			else {
				if(current.right!=null) {
					st.push(current.right);
				}
				
				if(current.left!=null) {
					st.push(current.left);
				}
			}
			
		}
	}

	private static void postorder(Nodee tree) {
		if(tree!=null) {
			postorder(tree.left);
			postorder(tree.right);
			System.out.print(tree.val+" ,");

		}				
	}

	private static void preorder(Nodee tree) {
		if(tree!=null) {
			System.out.print(tree.val+" ,");
			preorder(tree.left);
			preorder(tree.right);

		}		
	}

	private static void inorder(Nodee tree) {
		if(tree!=null) {
			inorder(tree.left);
			System.out.print(tree.val+" ,");
			inorder(tree.right);

		}
	}


}
