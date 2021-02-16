package com.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.beans.TreeNode;


//Hint in quetion:- top to bottom.
public class BFSTraversals {

	public static void main(String args[]) {
		Nodee tree = new Nodee(1); 						// 1
		tree.left = new Nodee(2); 				   	// 2	 3
		tree.right = new Nodee(3);                 // 4 5
		tree.left.left = new Nodee(4);
		tree.left.right = new Nodee(5);

	
		bfsTraversal(tree);
		System.out.println();
		printLevelOrder(tree);
	}
	
	public static void bfsTraversal(Nodee root) {
		Queue<Nodee> queue = new ArrayDeque<Nodee>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Nodee currentNode =queue.poll();
			System.out.print(currentNode.val+", ");
			
			if(currentNode.left!=null)
				queue.offer(currentNode.left);
			
			if(currentNode.right!=null)
				queue.offer(currentNode.right);
			
			
			
		}
		
	}

	
	/* function to print level order traversal of tree*/
    static void printLevelOrder(Nodee root) 
    { 
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(root, i); 
    } 
    
    /* Print nodes at the given level */
    static void printGivenLevel (Nodee root ,int level) 
    { 
        if (root == null) 
            return; 
        if (level == 1) 
            System.out.print(root.val + " "); 
        else if (level > 1) 
        { 
            printGivenLevel(root.left, level-1); 
            printGivenLevel(root.right, level-1); 
        } 
    } 
  
    /* Compute the "height" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/
    static int height(Nodee root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
            /* use the larger one */
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    } 
  

      
    //199. Binary Tree Right Side View   #*
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues=new ArrayList<>();
        if(root==null) return visibleValues;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root); 
        
        while(!q.isEmpty()){
            int qSize=q.size();
            for(int i=0;i<qSize;i++)
            {
                TreeNode current=q.poll();
                if(i==qSize-1)
                    visibleValues.add((int)current.val);
                
                if(current.left!=null)
                    q.offer(current.left);
                     
                if(current.right!=null)
                    q.offer(current.right);
            }
        }
        return visibleValues;
    }
    
    //102. Binary Tree Level Order Traversal  !!!MEDIUM!!!  #*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int qSize=queue.size();
            List<Integer> currentLevel=new ArrayList<>();
            
          for(int i=0;i<qSize;i++){
                  TreeNode  current =queue.poll();
                  currentLevel.add((int)current.val);
                
            if(current.left!=null){
                queue.offer(current.left);
                }
            if(current.right!=null){
                queue.offer(current.right);
                }
            }
            
            result.add(currentLevel);
        }
        return result;
    }
    
    //301. Remove Invalid Parentheses | BFS solution
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans =new ArrayList<>();
        if(s==null) return ans;
        Queue<String> queue=new LinkedList<>();
        Set<String> set=new HashSet<>();
        boolean found=false;
        queue.add(s);
        set.add(s);
        while(!queue.isEmpty()){
            String current=queue.poll();
            if(isValid(current)){
                found=true;
                ans.add(current);
            }
            if(found)continue;
            
            for(int i=0;i<current.length();i++){
                if(current.charAt(i)!='(' && current.charAt(i)!=')')continue;
                String temp=current.substring(0,i)+current.substring(i+1);
                if(!set.contains(temp)){
                    queue.add(temp);
                    set.add(temp);
                }
            }
        }
        return ans;
    }
    //checking if all paranthesis is valid 
    public boolean isValid(String s){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                count++;
            if(s.charAt(i)==')' && count--==0)
                return false;
                
        }
        return count==0;
    }
    
    //1091. Shortest Path in Binary Matrix
    public int shortestPathBinaryMatrix(int[][] grid) {
        int h=grid.length-1;
        int l=grid[0].length-1;
        if(grid[0][0]==1 || grid[h][l]==1)return -1;

        Queue<Point> q=new LinkedList();
        q.add(new Point(0,0));
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Point head=q.poll();
                int x=head.x;
                int y=head.y;
                
                if(x==h && y==l){
                    return level+1;
                }
                if(x<0 || y<0 || x>h || y>l || grid[x][y]>=1)
                    continue;
                grid[x][y]=2;
                q.offer(new Point(x-1,y));
                q.offer(new Point(x+1,y));
                q.offer(new Point(x,y-1));
                q.offer(new Point(x,y+1));
                    
                q.offer(new Point(x-1,y-1));
                q.offer(new Point(x-1,y+1));
                q.offer(new Point(x+1,y-1));
                q.offer(new Point(x+1,y+1));

            }
            level++;
        }
        return -1; 
    }
    


public class Point{
    int x,y;

    public Point(int x ,int y){
        this.x=x;
        this.y=y;
    }
}

//Same Above  | https://www.youtube.com/watch?v=nmzxJDqgabg&list=PL1MJrDFRFiKbU7XYNy5WMU2Ci_x3Gbt2S&index=8 | check video for levelby loop
public int shortestPathBinaryMatrix2(int[][] grid) {
    int h=grid.length;
    int l=grid[0].length;
    if(grid[0][0]==1 || grid[h-1][l-1]==1)return -1;
    int level=1;
    Queue<int[]> q=new LinkedList<>();
    q.offer(new int[]{0,0});
    while(!q.isEmpty()){
      int levelSize = q.size();
	for (int i = 0; i < levelSize; i++) { //levelby loop
        int []cur =q.poll();
        
        if(cur[0]==h-1 && cur[1]==l-1)
            return level;
        
        for(int []dir:directions){
            int r=cur[0]+dir[0];
            int c=cur[1]+dir[1];
            
            if(r>=0 && c>=0 && r<h && c<l && grid[r][c]==0){
                grid[r][c]=1;
                q.offer(new int[]{r,c});
            }
        }
    }
    level++;
    }
    
  return -1;  
}

public static final int[][] directions ={{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};

}
