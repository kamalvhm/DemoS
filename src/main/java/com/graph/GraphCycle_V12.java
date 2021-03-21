package com.graph;
import java.io.*;
import java.util.*;
//directed Cycles coloring:-https://www.youtube.com/watch?v=a4hXpeHZ_-c   (10 min onward)
public class GraphCycle_V12 {
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
       Pair(int v,String psf){
           this.v=v;
           this.psf=psf;
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

      // write your code here
      boolean[] visited=new boolean [vtces];
      
      //in case graph is disconnected so running Bfs on every vertex
      for(int v=0;v<vtces;v++){
          if(visited[v]==false){
              //traverse
              boolean cycle=isCyclic(graph,v,visited);
              // boolean cycle=dfs(graph,v,visited,-1); // uncomment for DFS solution
              if(cycle){
                  System.out.print(true);
                  return;
              }
          }
      }
    System.out.print(false);

      
   }
   //BFS way
   public static boolean isCyclic(ArrayList<Edge>[] graph,int src, boolean[] visited){
       ArrayDeque<Pair> q=new ArrayDeque<>();
       q.add(new Pair(src,src+""));
       while(q.size()>0){
           Pair rem=q.removeFirst();
           //found cycle 
           if(visited[rem.v]==true)
            return true;
            
            visited[rem.v]=true;
            
            for(Edge e:graph[rem.v]){
                if(visited[e.nbr]==false){
                    q.add(new Pair(e.nbr,rem.psf+e.nbr));
                }
            }
            
       }
       return false;
   }
   //DFS way for undirected graph || https://www.techiedelight.com/check-undirected-graph-contains-cycle-not/
   public static boolean dfs(ArrayList<Edge>[] graph,int src,boolean visited[],int parent)  
   { 
       visited[src]=true;
       for(Edge e:graph[src]){
           if(visited[e.nbr]==false){//if `nbr` is not visited already
               if(dfs(graph,e.nbr,visited,src))
                return true;
                
           }
        // if `nbr` is visited already, and `nbr` is not a parent
           else if (e.nbr != parent) //this means where i came from (parent) and my nbr is same so cycle (THIS CONDITION FOR DIRECTED NOT TRUE FOR THIS -ABOVE is GOOD)
                return true; // we found a back-edge (cycle)
       }
       return false;
   }
   /********************!!!!!!!!!!!DIRECTED GRAPH CYCLY DETECTION !!!!!!!!*********************/
   //207. Course Schedule  Check notes and https://www.youtube.com/watch?v=a4hXpeHZ_-c
   public boolean canFinish(int numCourses, int[][] prerequisites) {
	      HashMap<Integer,ArrayList<Integer>> map =new HashMap<>();
	      for(int [] a:prerequisites)
	      {
	          ArrayList<Integer> list=map.getOrDefault(a[0],new ArrayList<Integer>());
	          list.add(a[1]);
	          map.put(a[0],list);
	      }
	        
	      int [] visited=new int[numCourses];
	      
	      for(int v=0;v<numCourses;v++){
	          //false if cycle found
	          if(!dfs(map,v,visited))
	              return false;
	      }
	      return true;
	    }
	    
	   //graph coloring algo 0=unvisited ,-1 =visiting , 1 =visited
	   public static boolean dfs(HashMap<Integer,ArrayList<Integer>> map,int src,int[] visited)
	  {     //if we ran into node that we saw eirlier in this CURRENT dfs,Its a cycle
	     if(visited[src]==-1)
	         return false;
	       //if we ran into a node that we saw in saperate ealiar dfs,then it no problem
	     if(visited[src]==1)
	         return true;
	      //mark current node as -1; 
	        visited[src]=-1;
	         if(map.containsKey(src)){
	             //get all neighbors and return false if cyle was found
	             for(int j:map.get(src)){
	                 if(!dfs(map,j,visited))
	                     return false;
	             }
	         }
	       //if all its neighbars were visited and there are no issues
	       //we're done with this and we mark it as 1 (done visiting)
	       visited[src]=1;
	       return true;
	    
	  }   
   
   
   
}