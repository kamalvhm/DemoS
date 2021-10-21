package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.spi.CurrencyNameProvider;

import org.apache.commons.math3.ode.nonstiff.GillIntegrator;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;
import org.apache.hadoop.fs.DF;
import org.apache.ivy.core.cache.CacheUtil;
import org.apache.spark.sql.catalyst.expressions.CurrentRow;
import org.apache.spark.sql.streaming.StreamingQueryListener.QueryStartedEvent;
import org.apache.spark.sql.types.StructType;
import org.w3c.dom.ls.LSInput;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;
import com.dp.DpOnTrees4.In;

import io.netty.handler.codec.ByteToMessageDecoder.Cumulator;
import scala.reflect.io.Directory;
import scala.sys.process.ProcessBuilderImpl.Simple;



public class Dummy {

	public static void main(String[] args) {
		TreeNode<Integer> tree = new TreeNode(1); // 1
		tree.left = new TreeNode(2); // 2 3
		tree.right = new TreeNode(3); // 4 5
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		System.out.print(sumLeaf(tree));
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
              
        System.out.println("No of Islands:(4) " + numIslandsIterativeDFS(islandGrid));
               
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
		
		return count;

	}
    private static void DFS(char[][] grid, int r, int c) {
    
	}

	public static int numIslandsIterativeDFS(char[][] grid) {
		int count = 0;	
		
		return count;
	}
    
    public static int[][] direction= {{1,0},{-1,0},{0,1},{0,-1}};


	private static void bfs(TreeNode tree) {
		
		System.out.println();
	}
	
	 public static List<List<Integer>> levelOrder(TreeNode tree){
		List<List<Integer>> result=new ArrayList<>();	
		
		return result;
	 }
	 //TC:-O(n) for all and SC:- average O(log n) height of tree in worst O(N) 
	private static void inorderWithout(TreeNode tree) {
		//System.out.println();
		
	}
	
	private static void preorderWithout(TreeNode tree) {
		
		//System.out.println();
	}
	
	private static void postOrderWithoutRecursion(TreeNode tree) {
	
		
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

}
