package com.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectedCmpnt_V5 {

	 static class Edge {
	      int src;
	      int nbr;
	      int wt;

	      Edge(int src, int nbr, int wt) {
	         this.src = src;
	         this.nbr = nbr;
	         this.wt = wt;
	      }
	   }

	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int vtces = Integer.parseInt(br.readLine());
	      ArrayList<Edge>[] graph = new ArrayList[vtces];
	      for (int i = 0; i < vtces; i++) {
	         graph[i] = new ArrayList<>();
	      }

	      int edges = Integer.parseInt(br.readLine());
	      for (int i = 0; i < edges; i++) {
	         String[] parts = br.readLine().split(" ");
	         int v1 = Integer.parseInt(parts[0]);
	         int v2 = Integer.parseInt(parts[1]);
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
	      
	      // write your code here
	      //checking every vertexs with DFS as graph is disconnected
	      boolean[] visited=new boolean[vtces];
	      for(int v=0;v<vtces;v++) {
	    	  if(visited[v]==false) {
	    		 ArrayList<Integer> comp=new ArrayList<>();
	    		 drawTreeAndGenerateComp(graph, v,comp,visited);
	    		 comps.add(comp);
	    	  }
	      }

	      System.out.println(comps);
	      //connected graphs only have single component
	      System.out.println("Is graph Connected "+(comps.size()==1));
	      
	      //V-7 This is reverse 0 is land and 1 is water
	      int[][] grid = new int[][] {
	           {1, 1, 0, 0, 0},
	           {1, 1, 0, 0, 0},
	           {0, 0, 1, 0, 0},
	           {0, 0, 0, 1, 1}};
	           
	           boolean [][] visited2=new boolean[grid.length][grid[0].length];
	           int count=0;
	           for(int i=0;i<grid.length;i++) {
	        	   for(int j=0;j<grid[i].length;j++) {
	        		   if(grid[i][j]==0 && !visited2[i][j]) {
	        			   island(grid,i,j,visited2);
	        			   count++;
	        		   }
	        	   }
	           }
	           System.out.print(count);
	          
	     
	   }
	  
	//DFS algo V-5 and V-6
	   public static void drawTreeAndGenerateComp(ArrayList<Edge>[] graph,int src, ArrayList<Integer> comp,boolean[] visited) {
		   visited[src]=true;
		   comp.add(src);
		   for(Edge e:graph[src]) {
			   if(!visited[e.nbr]) {
				   drawTreeAndGenerateComp(graph, e.nbr, comp, visited);
			   }
		   }
	   }
	   
	   private static void island(int[][] grid, int i, int j, boolean[][] visited) {
		   if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1 || visited[i][j])
			   return;
		  visited[i][j]=true;
		  island(grid,i-1,j,visited);
		  island(grid,i+1,j,visited);
		  island(grid,i,j-1,visited);
		  island(grid,i,j+1,visited);
	   }
	   
	   
	   

}
