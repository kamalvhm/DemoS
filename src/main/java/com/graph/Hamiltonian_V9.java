package com.graph;
import java.io.*;
import java.util.*;
//https://nados.io/question/hamiltonian-path-and-cycle?zen=true
public class Hamiltonian_V9 {
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

      int src = Integer.parseInt(br.readLine());
      //It will be easy to check if all visited in hashset
      HashSet<Integer> visited=new HashSet<Integer>();
      // write all your codes here
      hamiltonian(graph,src,visited,src+"",src);
   }
   //normal dfs traversal
   public static void hamiltonian(ArrayList<Edge>[] graph,int src,HashSet<Integer> visited,String psf,int orgSrc){
      //here visited is one step behind then psf so it signify how many visited before you so -1 for    //that 
      if(visited.size()==graph.length-1){
          boolean cycleFound=false;
          for(Edge e:graph[src])
          {
              if(e.nbr==orgSrc)
                {
                    cycleFound=true;
                    break;
                }
          }
         System.out.println(psf+(cycleFound==true?"*":"."));

          return;
      }
      visited.add(src);
      for(Edge e:graph[src]){
          if(!visited.contains(e.nbr)){
             hamiltonian(graph,e.nbr,visited,psf+e.nbr,orgSrc); 
          }
      }
      visited.remove(src);
      
   }

   /**********************************************************************DIFFRENT VERSION8**/
   public static void hamiltonianCycle(int N, int[][] graph) {
       boolean[] visited = new boolean[graph.length];
       visited[0] = true;
       System.out.println(cycle(graph, visited, 0, 0, 0));
   }

   private static boolean cycle(int[][] graph, boolean[] visited, int src, int osrc, int pos) {
       if (pos == graph.length-1) {
           if (graph[src][osrc] == 1) {
               return true;
           }
           return false;
       }

       for (int i = 0; i < graph[0].length; i++) {
           if (visited[i] == false && graph[src][i] == 1) {
               visited[i] = true;
               boolean ans = cycle(graph, visited, i, osrc, pos + 1);
               if (ans == true) {
                   return true;
               }
               visited[i] = false;
           }
       }
       return false;
   }

   public static void main2(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int M = sc.nextInt();
       int[] edges = new int[2 * M];
       for (int i = 0; i < edges.length; i++) {
           edges[i] = sc.nextInt();
       }
	 int[][] graph = new int[N][N];
       for (int i = 0; i < M; i++) {
	     graph[edges[2 * i + 1]-1][edges[2 * i]-1] = 1;
           graph[edges[2 * i]-1][edges[2 * i + 1]-1] = 1;
       }
       hamiltonianCycle(N, graph);
   }
   
   

}