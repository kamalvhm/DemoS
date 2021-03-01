package com.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

//Practice here :-https://www.pepcoding.com/resources/online-java-foundation/graphs
public class FindPathDFS_V2_4 {
	static class Pair implements Comparable<Pair> {
	      int wsf;
	      String psf;

	      Pair(int wsf, String psf){
	         this.wsf = wsf;
	         this.psf = psf;
	      }

	      public int compareTo(Pair o){
	         return this.wsf - o.wsf;
	      }
	   }
	
	 static class Edge {
	      int src;
	      int nbr;
	      int wt;

	      Edge(int src, int nbr, int wt){
	         this.src = src;
	         this.nbr = nbr;
	         this.wt = wt;
	      }
	   }
	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      
	      /**
	       * 	7
				8
				0 1 10
				1 2 10
				2 3 10
				0 3 10
				3 4 10
				4 5 10
				5 6 10
				4 6 10
				0
				6
	       */

	      int vtces = Integer.parseInt(br.readLine());
	      ArrayList<Edge>[] graph = new ArrayList[vtces];
	      for(int i = 0; i < vtces; i++){
	         graph[i] = new ArrayList<>();
	      }

	      int edges = Integer.parseInt(br.readLine());
	      for(int i = 0; i < edges; i++){
	         String[] parts = br.readLine().split(" ");
	         int v1 = Integer.parseInt(parts[0]);
	         int v2 = Integer.parseInt(parts[1]);
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      int src = Integer.parseInt(br.readLine());
	      int dest = Integer.parseInt(br.readLine());
	      //V-2
	      // write your code here
	      boolean[] visited =new boolean[vtces];
	      boolean path=hasPath(graph, src, dest,visited);
	      System.out.println(path);
	      //V-3
	      allPath(graph, src, dest,visited,src+"");
	      
	      int criteria=40;//for ceil and floor 
	      int k=3;
	      //v-4
	      multiSolver(graph, src, dest,visited,criteria,k,src+"",0);
	      
	      System.out.println("Smallest Path = " + spath + "@" + spathwt);
	      System.out.println("Largest Path = " + lpath + "@" + lpathwt);
	      System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
	      System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
	      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
	    }
	   //Wrong Code Cycle issue without visited check notes   
	public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
		if (src == dest) {  //>>>1
			return true;
		}
		visited[src] = true;//>>>2
		for (Edge edge : graph[src]) { //>>>3 //faith is if we get nbr to destination then path exist 
			if (visited[edge.nbr] == false) {
				boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
				if (hasNbrPath) {
					return true;
				}
			}
		}

		return false;
	}
	
	//V-3   //Basic DFS traversal
	public static void allPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,String psf) {
		if (src == dest) {  //>>>1
			System.out.println(psf);
			return ;
		}
		visited[src] = true;//>>>2
		for (Edge edge : graph[src]) { //>>>3 //faith is if we get nbr to destination then path exist 
			if (visited[edge.nbr] == false) {
				 allPath(graph, edge.nbr, dest, visited,psf+edge.nbr);
				
			}
		}
		visited[src] = false; //This is the cHange Required to UNMARK 
		
	}
	
	   static String spath;
	   static Integer spathwt = Integer.MAX_VALUE;
	   static String lpath;
	   static Integer lpathwt = Integer.MIN_VALUE;
	   static String cpath;
	   static Integer cpathwt = Integer.MAX_VALUE;
	   static String fpath;
	   static Integer fpathwt = Integer.MIN_VALUE;
	   static PriorityQueue<Pair> pq = new PriorityQueue<>();
	//V-4
	public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited,int criteria,int k,String psf,int wsf) {
		if (src == dest) {  //>>>1
			if(wsf<spathwt) { //smallest
				spathwt=wsf;
				spath=psf;
			}
			if(wsf>lpathwt) { //largest
				lpathwt=wsf;
				lpath=psf;
			}
			if(wsf>criteria && wsf<cpathwt) { //ceil 40 find smaller value in greater than 40 wts (40 se bade walon m sabse chota)
				cpathwt=wsf;
				cpath=psf;
			}
			if(wsf<criteria && wsf>fpathwt) { //floor 40 find largest value in greater than 40 wts (40 se choto walon m sabse bada)
				fpathwt=wsf;
				fpath=psf;
			}
			if(pq.size()<k) //for 3rd largest 
				pq.add(new Pair(wsf,psf));
			else {
				if(wsf>pq.peek().wsf) { 
					pq.remove();
					pq.add(new Pair(wsf,psf));
				}
			}
			return ;
		}
		visited[src] = true;//>>>2
		for (Edge edge : graph[src]) { //>>>3 //faith is if we get nbr to destination then path exist 
			if (visited[edge.nbr] == false) {
				multiSolver(graph, edge.nbr, dest, visited,criteria,k,psf+edge.nbr,wsf+edge.wt);
				
			}
		}
		visited[src] = false; //This is the cHange Required to UNMARK 
	}

}
