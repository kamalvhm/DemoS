package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;



public class Dummy {
	// BFSTraversals and DFSTraversals  O(V + E) for both 
	public static void main(String[] args) {
		TreeNode<Integer> tree = new TreeNode(1); // 1
		tree.left = new TreeNode(2); // 2 3
		tree.right = new TreeNode(3); // 4 5
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		System.out.println(sumLeaf(tree));
		System.out.print(TreePrinter.getTreeDisplay(tree));
		/**
		 * (a) Inorder (Left, Root, Right) 	 : 4 2 5 1 3
		 * (b) Preorder (Root, Left,Right) 	 : 1 2 4 5 3 
		 * (c) Postorder (Left, Right, Root) : 4 5 2 3 1
		 */
	
		System.out.println("IN");
		inorder(tree);
		System.out.println("-------");
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

		System.out.println("BFS");
		bfs(tree);
		System.out.print(levelOrder(tree));
	
		int [] a= {5,7,7,8,8,8,10};
		//System.out.println(search(a,8));
		
	      char [][] islandGrid = new char[][] {
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '1', '0'},
              {'1', '1', '0', '0', '0'},
              {'0', '0', '1', '0', '1'}};
          
           char [][] islandGrid2 = new char[][] {
                  {'1', '1', '0', '1', '0'},
                  {'1', '1', '0', '1', '0'},
                  {'1', '1', '0', '1', '0'},
                  {'1', '1', '0', '0', '0'},
                  {'0', '0', '1', '0', '1'}};
              
        System.out.println("No of Islands:(4) " + numIslandsIterativeDFS(islandGrid));
        System.out.println("No of Islands2:(4) " + numIslands(islandGrid2));
       
      /*  System.out.println(Pow(2,2));*/

	}
	
	private static int sumLeaf(TreeNode<Integer> root) {
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return root.val;
		int sum=sumLeaf(root.left)+sumLeaf(root.right);
		return sum;
	}
//Mathod if you need a string in return
	private static String inorder2(TreeNode tree) {
		if(tree==null)return "";
		String left="";
		String right="";
		
		if(tree.left!=null) {
			left=inorder2(tree.left);
		}else left="";
		
		if(tree.right!=null) {
			right=inorder2(tree.right);
		}else right="";
		
		return left+", "+tree.val+""+right;
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
		int count = 0;
		int h=grid.length;
		int w=grid[0].length;
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(grid[i][j]=='1') {
					DFS(grid,i,j);
					count++;
				}
			}
		}
		return count;

	}
    private static void DFS(char[][] grid, int r, int c) {
    	int h=grid.length;
		int w=grid[0].length;
		if(r<0 || c<0 || r>=h || c>=w || grid[r][c]=='0')return;
		grid[r][c]='0';
		DFS(grid,r+1,c);
		DFS(grid,r,c+1);
		DFS(grid,r-1,c);
		DFS(grid,r,c-1);

	}

	public static int numIslandsIterativeDFS(char[][] grid) {
		int count= 0;	
		int h=grid.length; 
		int w=grid[0].length;
		boolean [][]visited=new boolean[h][w];
		Stack<int[]> st=new Stack<>();
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(grid[i][j]=='1' && visited[i][j]==false) {
					st.push(new int[] {i,j});
					visited[i][j]=true;
					while(!st.isEmpty()) {
						int curr[]=st.pop();
						
						for(int dir[]:direction) {
							int r=curr[0]+dir[0];
							int c=curr[1]+dir[1];
							
							if(r>=0 && c>=0 && r<h && c<w && grid[r][c]=='1' && !visited[r][c]) {
								st.push(new int[] {r,c});
								visited[r][c]=true;
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
		Queue<TreeNode> q=new LinkedList<>();
		TreeNode current=tree;
		q.offer(current);
		while(!q.isEmpty()) {
			current=q.poll();
			System.out.print(current.val+"!, ");
			if(current.left!=null)
				q.offer(current.left);
			if(current.right!=null)
				q.offer(current.right); 
		}
		System.out.println();
	}
	
	 public static List<List<Integer>> levelOrder(TreeNode tree){
		List<List<Integer>> result=new ArrayList<>();		
		Queue<TreeNode> q=new LinkedList<>();
		TreeNode current=tree;
		q.offer(current);
		while(!q.isEmpty()) {
			int size=q.size();
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<size;i++) {
				current=q.poll();
				list.add((int)current.val);
				if(current.left!=null)
					q.offer(current.left);
				if(current.right!=null)
					q.offer(current.right); 
			}
			result.add(list);
			
		}
		return result;
	 }
	 //TC:-O(n) for all and SC:- average O(log n) height of tree in worst O(N) 
	private static void inorderWithout(TreeNode tree) {
		//System.out.println();
		Stack<TreeNode> st=new Stack<>();
		TreeNode current=tree;
		while(!st.isEmpty() || current!=null) {
			if(current!=null) {
				st.push(current);
				current=current.left;
			}else {
				TreeNode node=st.pop(); 
				System.out.print(node.val+"! ");
				current=node.right;
			}
		}
		
		
	}
	
	private static void preorderWithout(TreeNode tree) {//R0RL
		Stack<TreeNode> st=new Stack<>();
		TreeNode current=tree;
		st.push(current);
		while(!st.isEmpty()) {
			current=st.pop();
			System.out.print(current.val+"!, ");
			if(current.right!=null)
				st.push(current.right); 
			if(current.left!=null)
				st.push(current.left);
		}
 		System.out.println();

	}
	
	private static void postOrderWithoutRecursion(TreeNode tree) {
		Stack<TreeNode> st=new Stack<>();
		TreeNode current=tree;
		TreeNode prev=tree;
		st.push(current);
		
		while(!st.isEmpty()) {
			current=st.peek(); 
			boolean isLeaf=current.left==null && current.right==null;
			boolean isPrevRight=current.right==prev || (current.left==prev && current.right==null);
			if(isLeaf || isPrevRight) {
				current=st.pop();
				System.out.print(current.val+"!, ");
				prev=current;
			}else {
			
			if(current.right!=null)
				st.push(current.right); 
			if(current.left!=null)
				st.push(current.left);
			}
		}
		System.out.println();
		
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
	
	   public List<Integer> inorderTraversalMorriesOrder(TreeNode root) {
	        List<Integer> inorder=new ArrayList<>();
	        TreeNode curr=root;
	        while(curr!=null){
	            if(curr.left==null){  //case 1 :- Does not have left so print root;
	                inorder.add((int)curr.val);
	                curr=curr.right;
	            }else {
	                TreeNode prev=curr.left;  //Going to right most guy to go left 
	                while(prev.right!=null && prev.right!=curr)
	                    prev=prev.right;
	                if(prev.right==null){ //CASE 2 :- attaching thread from right most guy to root
	                    prev.right=curr;
	                    curr=curr.left;
	                }else {                 //CASE 3 already visited left so thread already there so remove and go right
	                    prev.right=null;
	                    inorder.add((int)curr.val);
	                    curr=curr.right;
	                }
	            }
	        }
	        return inorder;
	    }

}
