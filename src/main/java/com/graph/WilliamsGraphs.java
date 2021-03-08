package com.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class WilliamsGraphs {
	//https://www.youtube.com/watch?v=eQA-m22wjTQ&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=2
	public static void main(String[] args) {
		// . is Empty S= start E=end ,# is rock 
		char[][] Grid = new char[][] {
            {'S', '.', '.', '.', '.'},
            {'.', '#', '.', '.', '.'},
            {'.', '#', '.', '.', '#'},
            {'#', 'E', '.', '.', '#'}};
	}
	
	//V-6:-https://www.youtube.com/watch?v=KiCBXu4P-2Y&list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P&index=6
	public static boolean isExist(char[][] m ,int sr,int sc,boolean [][] visited,int node_in_next_layer) {
		ArrayDeque<Integer> rowQueue=new ArrayDeque<>();
		ArrayDeque<Integer> colQueue=new ArrayDeque<>();
		rowQueue.add(sr);
		colQueue.add(sc);
		visited[sr][sc]=true;
		while(!rowQueue.isEmpty())//or colQueue
		{
			int r=rowQueue.removeFirst();
			int c=colQueue.removeFirst();
			
			if(m[r][c]=='E')
				return true;
			
			for(int i=0;i<4;i++) {
				int rr=r+dr[i];
				int cc=c+dc[i];
				
				if(rr<0 || cc<0 || r>=m.length || c>=m[0].length)
					continue;
				
				if(visited[rr][cc])
					continue;
				
				if(m[rr][cc]=='#')
					continue;
				
					rowQueue.add(rr);
					colQueue.add(cc);
				
					visited[rr][cc]=true;
					node_in_next_layer++;
			}
			node_in_next_layer--;
			if(node_in_next_layer==0) {
				
			}
		}
		return false;
	
	}
  static int dr[] = {-1,1,0,0};
  static int dc[] = {0,0,-1,1};
  
  
  //797. All Paths From Source to Target
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
      List<List<Integer>> result=new ArrayList<>();
      int n=graph.length;
      boolean [] visited=new boolean[n];
      ArrayList<Integer> path=new ArrayList<Integer>();
      path.add(0);
      dfs(graph,0,n-1,visited,result,path);
      return result;
  }
  
  public static void dfs(int[][] graph,int src,int dest,boolean visited[],List<List<Integer>> result,List<Integer> path){
      if(src==dest){
          List<Integer> list=new ArrayList<>(path);
          result.add(list);
          return;
      }
      visited[src]=true; //Node Pre
      for(int e :graph[src]){
          if(!visited[e]){
              path.add(e);//Edge Pre
              dfs(graph,e,dest,visited,result,path);
              path.remove(path.size()-1);//edge post
          }
      }
      visited[src]=false;//node post
  }
}
