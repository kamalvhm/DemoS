package com.graph;
import java.io.*;
import java.util.*;

public class TopologicalSortV17 {
    //Order Of Compilation
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
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
         graph[v1].add(new Edge(v1, v2));
      }

      // write your code here
      boolean [] visited=new boolean[vtces];
      Stack<Integer> st=new Stack<Integer>();
      //as all nodes dependency should be check before so we will call in loop
      //means if any node had dependency it should be in stack before see 3 and 4 node in example
      for(int v=0;v<vtces;v++){
          if(visited[v]==false){
              topologicalSort(graph,v,visited,st);
          }
      }
      //ORder of compilation will be reverse of topological order
      while(st.size()>0){
          System.out.println(st.pop());
      }
   }
   //same DFS algo
   public static void topologicalSort(ArrayList<Edge>[] graph,int src,boolean[] visited,Stack<Integer> st)
{
    visited[src]=true;
    for(Edge e:graph[src]){
        if(visited[e.nbr]==false){
            topologicalSort(graph,e.nbr,visited,st);
        }
    }
    st.push(src);
}   
   
   
   
    

}