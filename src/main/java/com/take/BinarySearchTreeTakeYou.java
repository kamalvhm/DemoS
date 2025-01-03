package com.take;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;

public class BinarySearchTreeTakeYou {
	//Add other if needed questions not availabe are added so far
	public static void main(String[] args) {
		
		TreeNode<Integer> tree = new TreeNode(1); // 1
		tree.left = new TreeNode(2); // 2 3
		tree.right = new TreeNode(7); // 4 5
		tree.left.left = new TreeNode(3);
		tree.left.left.right=new TreeNode(4);
		tree.left.left.right.left = new TreeNode(5);
		tree.left.left.right.right = new TreeNode(6);
		tree.right.right= new TreeNode(8);
		tree.right.right.left= new TreeNode(9);
		tree.right.right.left.left= new TreeNode(10);
		tree.right.right.left.right= new TreeNode(11);
		System.out.print(TreePrinter.getTreeDisplay(tree));
		
		System.out.println("1)Boundary Traversal in Binary Tree 1,2,3,4,5,6,10,11,9,8,7");
		BoudaryTraversal(tree);
	}
	
	    public static void BoudaryTraversal(TreeNode root){
	       ArrayList<Integer> trav=new ArrayList<>();
	       traverseLeft(root,trav);
	       inorder(root,trav);
	       traverseRightReverse(root,trav);
	       System.out.println(trav);
	    }
	    
	    public static void traverseLeft(TreeNode root,ArrayList<Integer> trav) {
//	    	if(root==null)return;
//	    	if(root.left==null && root.right==null)return;
//	    	trav.add((Integer)root.val);
//	    	if(root.left!=null)
//	    		traverseLeft(root.left,trav);
//	    	else traverseLeft(root.right,trav);
	    	TreeNode curr=root;
	    	while(curr!=null) {
	    		if(!isLeaf(curr))trav.add((Integer)curr.val);
	    		if(curr.left!=null)
	    			curr=curr.left;
	    		else curr=curr.right;
	    	}
	    }
	    
	    public static void inorder(TreeNode root,ArrayList<Integer> trav) {
	    	if(root==null)return;
	    	inorder(root.left,trav);
	    		if(root.left==null && root.right==null)
		    		trav.add((Integer)root.val);
	    	inorder(root.right,trav);
	    }

	    public static void traverseRightReverse(TreeNode root,ArrayList<Integer> trav) {
	    	TreeNode curr=root.right;
	    	Stack<Integer> st=new Stack<>();
	    	
	    	while(curr!=null) {
	    		if(!isLeaf(curr))st.push((Integer)curr.val); 
	    		if(curr.left!=null)
	    			curr=curr.left;
	    		else curr=curr.right;
	    	}
	    	
	    	while(!st.isEmpty()) {
	    		trav.add(st.pop());
	    	}
	    	
	    }
	    
	    public static boolean isLeaf(TreeNode root) {
	    	return root.left==null && root.right==null;
	    }
	   
	    static ArrayList<Integer> topView(TreeNode root) {
	        // code here
	        ArrayList<Integer> ans=new ArrayList<>();
	        TreeMap<Integer,Integer> map=new TreeMap<>();
	        Queue<Pair> q=new LinkedList<>();
	        q.offer(new Pair(root,0));
	        while(!q.isEmpty()){
	            Pair tuple=q.poll();
	            TreeNode node=tuple.node; 
	            int line=tuple.line;

	            if(!map.containsKey(line)){
	                map.put(line,(int) node.data);
	            }
	         
	            if(node.left!=null)
	                q.offer(new Pair(node.left,line-1));
	                
	            if(node.right!=null)
	                q.offer(new Pair(node.right,line+1));
	        }
	        
	        for(Integer node:map.values()){
	            ans.add(node);
	        }
	        return ans;
	        
	        
	        
	    }
	    
	    static class Pair{
	    	TreeNode node;
	        int line;
	        Pair(TreeNode node,int line){
	            this.node=node;
	            this.line=line;
	        }
	    }
	    
	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        Queue<Tuple> q=new LinkedList<>();
	         TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
	         q.offer(new Tuple(root,0,0));
	         while(!q.isEmpty()){
	             Tuple tuple=q.poll();
	             TreeNode node=tuple.node;
	             int x=tuple.row;
	             int y=tuple.col;

	             if(!map.containsKey(x)){
	                 map.put(x,new TreeMap<>());
	             }
	             if(!map.get(x).containsKey(y)){
	                 map.get(x).put(y,new PriorityQueue<>());
	             }
	             map.get(x).get(y).offer((int)node.val);
	             if(node.left!=null)
	                 q.offer(new Tuple(node.left,x-1,y+1));
	             if(node.right!=null)
	                 q.offer(new Tuple(node.right,x+1,y+1));
	         }
	         List<List<Integer>> list=new ArrayList<>();
	         for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
	             list.add(new ArrayList<>());//vertical
	             for(PriorityQueue<Integer> nodes:ys.values()){ //level
	                 while(!nodes.isEmpty()){ //nodes
	                     list.get(list.size()-1).add(nodes.poll());
	                 }
	             }
	         }
	         return list;
	     }

	     class Tuple{
	         TreeNode node;
	         int row;
	         int col;
	         Tuple(TreeNode node,int row,int col){
	             this.node=node;
	             this.row=row;
	             this.col=col;
	         }
	     }
	     
	     public List<Integer> rightSideView(TreeNode root) {
	         List<Integer> ans=new ArrayList<>();
	         if(root==null)return ans;
	         Queue<TreeNode> q=new LinkedList<>();
	         TreeNode current=root;
	         q.offer(root);
	         while(!q.isEmpty()){
	             int size=q.size();
	             for(int i=0;i<size;i++){
	                 current=q.poll();
	                 if(i==size-1 && current!=null)
	                     ans.add((int)current.val);
	                 if(current.left!=null)
	                     q.offer(current.left);
	                 if(current.right!=null)
	                     q.offer(current.right);
	             }
	         }
	         return ans;
	     }
}
