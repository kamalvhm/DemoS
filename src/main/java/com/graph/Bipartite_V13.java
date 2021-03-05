package com.graph;
import java.io.*;
import java.util.*;

public class Bipartite_V13 {
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
   static class Pair{
       int v;
       String psf;
       int level;
       Pair(int v,String psf,int level){
           this.v=v;
           this.psf=psf;
           this.level=level;
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

      //graph can be disconnected so loop ALL componect must be bipartite in disconnected 
      int [] visited=new int [vtces];//to store level where vertex visited so  we will keep int [jis level pr visit hua]
      Arrays.fill(visited,-1);//unvisited -1
      for(int v=0;v<vtces;v++){
          if(visited[v]==-1){
              boolean isCompBipartit=checkCompForBipartit(graph,v,visited);
              if(isCompBipartit==false){//if any one component is false then false
                  System.out.println(false);
                    return;
              }
          }
      }
        System.out.println(true);

   }
   //BFS 
   public static boolean checkCompForBipartit( ArrayList<Edge>[] graph,int src,int [] visited){
       ArrayDeque<Pair> q=new ArrayDeque<>();
       q.add(new Pair(src,src+"",0));//initial level is 0 
       //rM*WA*
       while(q.size()>0){
           Pair rem=q.removeFirst();
           
           if(visited[rem.v]!=-1){//if visited means cycle ,we don't know yet ODD or EVEN we will check below
               if(rem.level!=visited[rem.v]){//if current level(rem.level) and older visited level(rem.v) is not on same Level then ODD Cycle                       //then odd cycle
                   return false;
               }
           }else {
               visited[rem.v]=rem.level;//visited on 'rem.level' this level 
           }
           for(Edge e:graph[rem.v]){
               if(visited[e.nbr]==-1){
                   q.add(new Pair(e.nbr,rem.psf+e.nbr,rem.level+1));//previous level +1
               }
           }
           
       }
       return true;
   }
 
   //https://www.youtube.com/watch?v=LBgVHZb07dc
   //785. Is Graph Bipartite? || DFS way to find cycle
   public boolean isBipartit(int [][] graph) {
	   int len =graph.length;//****THIS GIVE ALL VTCES
	   int[] color=new int[len];
	   
	   Arrays.fill(color, -1);//filling with blue -1 Green is 1 and Red =0;
	   
	   for(int i=0;i<len;i++){
           if(color[i]==-1){ //if uncolored then colour and start DFS
               color[i]=1; //if uncolor (blue) then color it green and go for DFS color of nbr with Red
               if(!dfs(i,graph,color))
                   return false;
           }
       }
       return true ;
			   
   }
   private boolean dfs( int src, int[][] graph,int[] color){
       int currentColor=color[src];
        for(int connectingIndex:graph[src]){//****THIS GIVE ALL NBR OF SRC
            if(color[connectingIndex]==currentColor)//if its already equal to current 
                return false;
            if(color[connectingIndex]==-1){ //if uncolored 
                color[connectingIndex]=1-currentColor;//its to toggle color if red then green and vice versa
                // if(color[connectingIndex]==0)  //above stmnt is replacment of below commented 
                //     color[connectingIndex]=1;
                // if(color[connectingIndex]==1)
                //     color[connectingIndex]=0;
                if(!dfs(connectingIndex,graph,color))
                    return false;

            }
                
        }
        return true;
    }
   /*********************************************NOW PEP WAY TO SOLVE THIS SAME CODE AS checkCompForBipartit() **************?
    * Except graph representation all code same 
    */
   
   public boolean isBipartite(int[][] graph) {
       int len =graph.length;
       int[] visited = new int[len];

       Arrays.fill(visited,-1);
       
       for(int i=0;i<len;i++){
           if(visited[i]==-1){ 
                boolean isCompBipartit=bfs(graph,i,visited);
                if(isCompBipartit==false)
                   return false;
             
           }
       }
       return true ;
   }
  
   
  public static boolean bfs(int[][] graph,int src,int [] visited){
      ArrayDeque<Pair> q=new ArrayDeque<>();
      q.add(new Pair(src,"",0));
      //rM*WA*
      while(q.size()>0){
          Pair rem=q.removeFirst();
          
          if(visited[rem.v]!=-1){
              if(rem.level!=visited[rem.v]){
                  return false;
              }
          }else {
              visited[rem.v]=rem.level;
          }
          for(int e:graph[rem.v]){
              if(visited[e]==-1){
                  q.add(new Pair(e,"",rem.level+1));
              }
          }
          
      }
      return true;
  }
}