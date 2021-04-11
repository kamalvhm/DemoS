package com.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import com.datastructure.TreePrinter.PrintableNode;

class Node implements PrintableNode{
	public int data;
	public Node left, right;
	
	Node( int elem) {
	/*	this.left = left;
		this.right = right;*/
		data = elem;
	}

	@Override
	public PrintableNode getLeft() {
		return this.left;
	}

	@Override
	public PrintableNode getRight() {
		return this.right;
	}

	@Override
	public String getText() {
		return data+"";
	}
}

//https://www.youtube.com/watch?v=oCcUNRMl7dA&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=8
public class RecurssionKthPathSumV5toV10 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//print1toN(7);
		
		Node tree = new Node(1); 						// 1
		tree.left = new Node(2); 				   	// 2	 3
		tree.right = new Node(3);                 // 4 5
		tree.left.left = new Node(4);
		tree.left.right = new Node(5);
		
		//System.out.print(TreePrinter.getTreeDisplay(tree));
		
		//System.out.println("HIEGHT-"+height(tree));
		
		Stack<Integer> st=new Stack<>();
		st.add(1);
		st.add(2);
		st.add(3);
		st.add(4);
		st.add(5);

		
		System.out.println(st);
		reverseStack(st);
		//deleteMiddle(st,st.size()/2+1);
		//sortStack(st);
		System.out.println(st);


	}
	
	public static void print1toN(int n) {
		if (n == 1) {
			System.out.println(1);
			return;
		}
		//System.out.println(n); // i'm printing n then give me n-1
		print1toN(n - 1); //give me n-1 first
		System.out.println(n); //so i can print n 
	}
	//video 5
	public static int height(Node root) {
		if(root==null)return 0;
		return 1+Math.max(height(root.left) , height(root.right)); 
	}
	//video 7 -6
	public static void sortStack(Stack<Integer> st) {
		if(st.size()==1)return;
		else {
			int tmp=st.pop();
			sortStack(st);
			insert(st,tmp);
			return;
		}
	}

	private static void insert(Stack<Integer> st, int tmp) {
		if(st.isEmpty() || st.peek()<=tmp) {
			st.push(tmp);
			return;
		}
		int t=st.pop();
		insert(st,tmp);
		st.push(t);
		
		return;
	}
	
	//video 8
	private static void deleteMiddle(Stack<Integer> st,int pos) {
		if(pos==1) {
			st.pop();
			return;
		}
		int tmp=st.pop();
		deleteMiddle(st,pos-1);
		st.push(tmp);
		return;
		
	}
	//video 9 
	public static void reverseStack(Stack<Integer> st) {
		if(st.size()==1) return;
		int tmp=st.pop();
		reverseStack(st);
		insert2(st,tmp);
		return;
	} 
	
	public static void insert2(Stack<Integer> st,int elem) {
		if(st.isEmpty()) {
			st.push(elem);
			return;
		}
		int tmp=st.pop();
		insert2(st,elem);
		st.push(tmp);
		return;
		
	}
	
	//V10 ||| 779. K-th Symbol in Grammar
	  public int kthGrammar(int N, int K) {
	        if(N==1 && K==1) return 0;
	        else{
	            int mid=(int)Math.pow(2,N-1)/2;
	            if(K<=mid){
	               return kthGrammar(N-1,K);
	            }else
	               return kthGrammar(N-1,K-mid)==1?0:1;
	        }
	    }
	  
	  
	//113. Path Sum II   #*Medium  IMP   -APPLY IBH VARIATION
  //	Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
		 public List<List<Integer>> pathSum(TreeNode root, int sum) {
		        List<List<Integer>> paths=new ArrayList<>();
		        findpath(root,sum,new ArrayList<Integer>(),paths);
		        return paths;
		        
		    }
		    
		    public  void findpath(TreeNode root,int sum,ArrayList<Integer> current , List<List<Integer>> paths){
		        if(root==null) return;
		        
		        current.add(root.val);
		        if(root.val==sum && root.left==null && root.right==null){
		            paths.add(current);
		        }
		        
		        findpath(root.left,sum-root.val,new ArrayList<Integer>(current),paths);
		        findpath(root.right,sum-root.val,new ArrayList<Integer>(current),paths);

		        return;
		    }
		    
		    
		    //437. Path Sum III
		    public int pathSum2(TreeNode root, int sum) {
		        List<Integer> currentPath = new LinkedList<>();
		          return countPathSum(root, sum, currentPath);
		      }
		      
		      private int countPathSum(TreeNode currentNode, int sum, List<Integer> currentPath) {
		          if (currentNode == null) {
		              return 0;
		          }
		          
		          currentPath.add(currentNode.val);
		          
		          int pathSum = 0;
		          int pathCount = 0;
		          
		          ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
		          while (pathIterator.hasPrevious()) {
		              pathSum += pathIterator.previous();
		              
		              if (pathSum == sum) {
		                  pathCount++;
		              }
		                  
		          } 
		          
		          pathCount += countPathSum(currentNode.left, sum, currentPath);
		          pathCount += countPathSum(currentNode.right, sum, currentPath);
		          currentPath.remove(currentPath.size() - 1);
		          return pathCount;
		      }
}
