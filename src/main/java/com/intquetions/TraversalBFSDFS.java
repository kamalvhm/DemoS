package com.intquetions;

import java.util.ArrayDeque;
import java.util.List;

//https://www.baeldung.com/java-depth-first-search

class Node2 {
    public int val;
    public List<Node2> children;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }
}

public class TraversalBFSDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//559. Maximum Depth of N-ary Tree   (BFS)
	  public int maxDepth(Node2 root) {
	        if(root==null) return 0;
	        int max=0;
	       ArrayDeque<Node2> st=new ArrayDeque<Node2>();
	        
	        st.add(root);
	        
	        while(!st.isEmpty()){
	             max++;
	            
	            int curQueueSize = st.size();
	            while(curQueueSize>0){
	                curQueueSize--;
	                Node2 node= st.remove();
				    if (node.children != null)
					node.children.forEach(x -> st.add(x));
	                
	            }   
	               
	            
	        }
	        return max;
	    }
	    
	  //559 DFS SOLUTION FOR SAME
	  public static int helper(Node2 node){
	        if(node==null) return 0;
	        int max=0;
	        
	        for(Node2 n:node.children){
	            max=Math.max(max,helper(n));
	        }
	        
	        return max+1;
	    }
	  
	 
	    
}
