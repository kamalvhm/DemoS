package com.graph;

import java.util.ArrayList;

import java.util.List;

import com.graph.FindPathDFS_V2_4.Edge;
//Check youTube :-
//Kenny Talks Code
//Practice :-https://www.pepcoding.com/resources/online-java-foundation/graphs (yahoo/#1to9)
//https://www.youtube.com/watch?v=nUgp0RG57wQ&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=9
public class GraphRepresentation {
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

	public static void main(String[] args) {
		//adjcency List 
		int vtces=7;//0,1,2,3,4,5,6
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for(int i=0;i<vtces;i++) {
			graph[i]=new ArrayList<Edge>();
		}
		
		//adding Edges 
		graph[0].add(new Edge(0, 3, 40));
		graph[0].add(new Edge(0, 1, 10));

		
	
	}

}
