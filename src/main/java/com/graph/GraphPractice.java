package com.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

import com.cleanup.Utils;



public class GraphPractice {
	static class Pair implements Comparable<Pair>{
		int wsf;
		String psf;
		
		public Pair(int wsf,String psf) {
			this.wsf=wsf;
			this.psf=psf;
		} 
		public int compareTo(Pair o) {
			return this.wsf=o.wsf;
		} 
	}
	static class Pair11{
		int v;
		String psf;
		int t;
		
		Pair11(int v,String psf){
			this.v=v;
			this.psf=psf;
		}
		Pair11(int v,int t){
			this.v=v;
			this.t=t;
		}
	}
	static class Pair13{
		int v;
		String psf;
		int level;
		
		Pair13(int v,String psf){
			this.v=v;
			this.psf=psf;
		}
		
		Pair13(int v,String psf,int level){
			this.v=v;
			this.psf=psf;
			this.level=level;
		}
	}
	static class Pair15 implements Comparable<Pair15>{
		int v;
		String psf;
		int wsf;
		
		Pair15(int v,String psf,int wsf){
			this.v=v;
			this.psf=psf;
			this.wsf=wsf;
		}

		@Override
		public int compareTo(Pair15 o) {
			
			return this.wsf-o.wsf;
		}
		
	}
	static class Pair16 implements Comparable<Pair16>{
		int v;
		int av;
		int wt;
		
		Pair16(int v,int av,int wt){
			this.v=v;
			this.av=av;
			this.wt=wt;
		}

		@Override
		public int compareTo(Pair16 o) {
			return this.wt-o.wt;
		}
		
	}
	
	
	static class Edge{
		int src;
		int nbr;
		int wt;
		
		
		public Edge(int src,int nbr,int wt) {
			this.src=src;
			this.nbr=nbr;
			this.wt=wt;
		}
		public Edge(int src,int nbr) {
			this.src=src;
			this.nbr=nbr;
		}
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

	public static void main(String[] args) {
		System.out.println("1) Graph Representation Adjacency list");
		int vtces=7; 
		ArrayList<Edge>[] graph=new ArrayList[vtces];
		ArrayList<Edge>[] graph4=new ArrayList[vtces];

		for(int v=0;v<vtces;v++) {
			graph[v]=new ArrayList<Edge>();
			graph4[v]=new ArrayList<Edge>();
		}
		
		graph[0].add(new Edge(0, 1, 10));
		graph[1].add(new Edge(1, 2, 10));
		graph[2].add(new Edge(2, 3, 10));
		graph[0].add(new Edge(0, 3, 10));
		graph[3].add(new Edge(3, 4, 10));
		graph[4].add(new Edge(4, 5, 10));
		graph[5].add(new Edge(5, 6, 10));
		graph[4].add(new Edge(4, 6, 10));
		int src=0;
		int dest=6;
		
		boolean[]visited=new boolean[vtces];
		System.out.println("2) Path Exist (True):- "+dfs(graph,src,dest,visited));
		boolean[]visited3=new boolean[vtces];
		System.out.println("3) Print all Path :- ");
		printAllPath(graph,src,dest,visited3,""+src);
		
		
	  	graph4[0].add(new Edge(0, 1, 10));
		graph4[1].add(new Edge(1, 2, 10));
		graph4[2].add(new Edge(2, 3, 10));
		graph4[0].add(new Edge(0, 3, 40));
		graph4[3].add(new Edge(3, 4, 2));
		graph4[4].add(new Edge(4, 5, 3));
		graph4[5].add(new Edge(5, 6, 3));
		graph4[4].add(new Edge(4, 6, 8));
		int src4=0;
		int dest4=6;
		int criteria=40;//for ceil and floor 
	    int k=3;
	      //v-4
		boolean[]visited4=new boolean[vtces];

		  System.out.println("4) Multi solver :- ");
	      multiSolver(graph4, src4, dest4,visited4,criteria,k,src4+"",0);

	      System.out.println("\t Smallest Path (0123456@38)= " + spath + "@" + spathwt);
	      System.out.println("\t Largest Path (0346@50)= " + lpath + "@" + lpathwt);
	      System.out.println("\t (03456@48) Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
	      System.out.println("\t (0123456@38) Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
	      System.out.println("\t "+k + "th largest path (012346@40)= " + pq.peek().psf + "@" + pq.peek().wsf);
	      
		  System.out.println("5) Get Connected Component of graph :- ");
			ArrayList<Edge>[] graph5=new ArrayList[vtces];
			for (int v = 0; v < vtces; v++) {
				graph5[v] = new ArrayList<Edge>();
			}

			graph5[0].add(new Edge(0, 1, 10));
			//graph5[1].add(new Edge(1, 2, 10));
			graph5[2].add(new Edge(2, 3, 10));
			graph5[4].add(new Edge(4, 5, 10));
			graph5[5].add(new Edge(5, 6, 10));
			graph5[4].add(new Edge(4, 6, 10));
			
			ArrayList<ArrayList<Integer>> components=new ArrayList<>();
			boolean[] visited5 = new boolean[vtces];

			for(int i=0;i<vtces;i++) {
				if(visited5[i]==false) {
					ArrayList<Integer> comp=new ArrayList<>();
					component(graph5,i,visited5,comp);
					components.add(comp);
				}
			}
			System.out.println("\t Components [[0, 1], [2, 3], [4, 5, 6]] :- "+components);
			System.out.println("6) Is graph Connected  false:- "+(components.size()==1));
			
			System.out.println("7) Count No. of icelands:- ");
			int [][] grid= {{1,0,0},
							{1,1,1},  //0s are land and 1 is water 
							{0,0,1}};
			int count=0; 
			int h=grid.length,w=grid[0].length;
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(grid[i][j]==0) {
						island(grid,i,j);
						count++;
					}
				}
			}
			System.out.println("\t Iceland (2) "+count);
			
			System.out.println("8) Perfect Friends (16):- ");
			ArrayList<Edge>[] graph6=new ArrayList[vtces];
			for(int v=0;v<vtces;v++) {
				graph6[v]=new ArrayList<Edge>();
			}
			
			graph6[0].add(new Edge(0, 1));
			graph6[2].add(new Edge(2, 3));
			graph6[4].add(new Edge(4, 5));
			graph6[5].add(new Edge(5, 6));
			graph6[4].add(new Edge(4, 6));
			
			graph6[1].add(new Edge(1, 0));
			graph6[3].add(new Edge(3, 2));
			graph6[5].add(new Edge(5, 4));
			graph6[6].add(new Edge(6, 5));
			graph6[6].add(new Edge(6, 4));

			ArrayList<ArrayList<Integer>> comp6=new ArrayList<>();
			boolean[]visited6=new boolean[vtces];
			for(int v=0;v<vtces;v++) {
				if(visited6[v]==false) {
					ArrayList<Integer> cmp=new ArrayList<>();
					perfect(graph6,v,visited6,cmp);
					comp6.add(cmp);
				}
			}

			int count6=0;
			for(int i=0;i<comp6.size();i++) {
				for(int j=i+1;j<comp6.size();j++) {
					count6+=comp6.get(i).size()*comp6.get(j).size();
				}
			}

			System.out.println("\t "+count6);
			
			System.out.println("9) Hamiltonion Path and cycle :- ");
			ArrayList<Edge>[] graph9=new ArrayList[vtces];
			for(int v=0;v<vtces;v++) {
				graph9[v]=new ArrayList<Edge>();
			}
			
			graph9[0].add(new Edge(0, 1, 10));
			graph9[1].add(new Edge(1, 2, 10));
			graph9[2].add(new Edge(2, 3, 10));
			graph9[0].add(new Edge(0, 3, 10));
			graph9[3].add(new Edge(3, 4, 10));
			graph9[4].add(new Edge(4, 5, 10));
			graph9[5].add(new Edge(5, 6, 10));
			graph9[4].add(new Edge(4, 6, 10));
			graph9[2].add(new Edge(2, 5, 10));
			graph9[1].add(new Edge(1, 0, 10));
			graph9[2].add(new Edge(2, 1, 10));
			graph9[3].add(new Edge(3, 2, 10));
			graph9[3].add(new Edge(3, 0, 10));
			graph9[4].add(new Edge(4, 3, 10));
			graph9[5].add(new Edge(5, 4, 10));
			graph9[6].add(new Edge(6, 5, 10));
			graph9[6].add(new Edge(6, 4, 10));
			graph9[5].add(new Edge(5, 2, 10));

			HashSet<Integer> visited9=new HashSet<>();
			hamiltonian(graph9,src,visited9,""+src,src);
			
			System.out.println("10) Knight Tour :- ");
			int [][] chess =new int [5][5];
		    printKnightsTour(chess,3,3,1);
		    
			System.out.println("11) Breath First Search :- ");
			boolean[] visited11=new boolean[vtces];
			ArrayList<Edge>[] graph11=new ArrayList[vtces];

			for(int v=0;v<vtces;v++) {
				graph11[v]=new ArrayList<Edge>();
			}
			
			graph11[0].add(new Edge(0, 1, 10));
			graph11[1].add(new Edge(1, 0, 10));
			graph11[1].add(new Edge(1, 2, 10));
			graph11[2].add(new Edge(2, 1, 10));
			graph11[2].add(new Edge(2, 3, 10));
			graph11[3].add(new Edge(3, 2, 10));
			graph11[0].add(new Edge(0, 3, 10));
			graph11[3].add(new Edge(3, 0, 10));
			graph11[3].add(new Edge(3, 4, 10));
			graph11[4].add(new Edge(4, 3, 10));
			graph11[4].add(new Edge(4, 5, 10));
			graph11[5].add(new Edge(5, 4, 10));
			graph11[5].add(new Edge(5, 6, 10));
			graph11[6].add(new Edge(6, 5, 10));
			graph11[4].add(new Edge(4, 6, 10));
			graph11[6].add(new Edge(6, 4, 10));

			bfs(graph11,2,visited11);
			
			System.out.println("12) Is graph Cyclic :- ");
			boolean[] visited12=new boolean[vtces];
			for(int v=0;v<vtces;v++) {
				if(visited12[v]==false) {
					//boolean cycle=cycles(graph,v,visited12);
					boolean cycle=dfsCycle(graph,v,visited,-1);
					if(cycle) {
						System.out.println("\t Cycle true");
						break;
					}
				}
			}
			
			System.out.println("13) Is graph Bipartite :- ");
			ArrayList<Edge>[] graph13=new ArrayList[vtces];
			for(int v=0;v<4;v++) {
				graph13[v]=new ArrayList<Edge>();
			}
			graph13[0].add(new Edge(0, 1, 10));
			graph13[1].add(new Edge(1, 2, 10));
			graph13[2].add(new Edge(2, 3, 10));
			graph13[0].add(new Edge(0, 3, 10));
			graph13[1].add(new Edge(1, 0, 10));
			graph13[2].add(new Edge(2, 1, 10));
			graph13[3].add(new Edge(3, 2, 10));
			graph13[3].add(new Edge(3, 0, 10));
			int [] visited13=new int [4];
			Arrays.fill(visited13, -1);
			for(int v=0;v<4;v++) {
				if(visited13[v]==-1) {
					boolean bipartite=bipartite(graph13,v,visited13);
					if(bipartite==false) {
						System.out.println("\t bipartite false");
					} 
				}
			}
			System.out.println("\t bipartite true");

			System.out.println("14) Spread Infections :- ");//6 is infected at t1 time you need to tell which nodes are infected at t=3 time
			int visited14[]=new int[vtces];
			infection(graph11,6,visited14);
			
			System.out.println("15) Dijkstra  Single Source Shortest Path in Weights ");
			ArrayList<Edge>[] graph15=new ArrayList[vtces];

			for(int v=0;v<vtces;v++) {
				graph15[v]=new ArrayList<Edge>();
			}
			
			graph15[0].add(new Edge(0, 1, 10));
			graph15[1].add(new Edge(1, 0, 10));
			graph15[1].add(new Edge(1, 2, 10));
			graph15[2].add(new Edge(2, 1, 10));
			graph15[2].add(new Edge(2, 3, 10));
			graph15[3].add(new Edge(3, 2, 10));
			graph15[0].add(new Edge(0, 3, 40));
			graph15[3].add(new Edge(3, 0, 40));
			graph15[3].add(new Edge(3, 4, 2));
			graph15[4].add(new Edge(4, 3, 2));
			graph15[4].add(new Edge(4, 5, 3));
			graph15[5].add(new Edge(5, 4, 3));
			graph15[5].add(new Edge(5, 6, 3));
			graph15[6].add(new Edge(6, 5, 3));
			graph15[4].add(new Edge(4, 6, 8));
			graph15[6].add(new Edge(6, 4, 8));
			boolean []visited15=new boolean[vtces];
			digstra(graph15,0,visited15);
			
			System.out.println("16) Minimum Spanning Tree(Prim's Algorithm) ");
			boolean []visited16=new boolean[vtces];
			prims(graph15,0,visited16);
			
			System.out.println("17) Topological sort ");
			ArrayList<Edge>[] graph17=new ArrayList[vtces];

			for(int v=0;v<vtces;v++) {
				graph17[v]=new ArrayList<Edge>();
			}
			graph17[0].add(new Edge(0, 1, 10));
			graph17[0].add(new Edge(0, 3, 40));
			graph17[1].add(new Edge(1, 2, 10));
			graph17[2].add(new Edge(2, 3, 10));
			graph17[4].add(new Edge(4, 3, 2));
			graph17[4].add(new Edge(4, 5, 3));
			graph17[4].add(new Edge(4, 6, 8));
			graph17[5].add(new Edge(5, 6, 3));
			
			boolean []visited17 =new boolean[vtces];
			Stack<Integer> st=new Stack<>();
			for(int v=0;v<vtces;v++) {
				if(visited17[v]==false) {
					topoSort(graph17,v,visited17,st);
				}
			}
			
			while(st.isEmpty()==false) {
				System.out.print(st.pop()+"-");
			}
			
			System.out.println("18) DFS iterative ");
			boolean [] visited18=new boolean[vtces]; 
			dfsIterative(graph,src,dest,visited18); 
	    }
	
	private static void dfsIterative(ArrayList<Edge>[] graph, int src, int dest,boolean[] visited) {
		Stack<Pair11> st=new Stack<>();
		st.push(new Pair11(src,src+""));
		while(!st.isEmpty()) {
			Pair11 rem=st.pop(); 
			if(visited[rem.v]==true)continue;
			visited[rem.v]=true;
			
			System.out.println("\t "+rem.v+" @ "+rem.psf);
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false)
					st.push(new Pair11(e.nbr,rem.psf+e.nbr));
			}
		}
		
	}

	private static void topoSort(ArrayList<Edge>[] graph, int src, boolean[] visited,Stack<Integer> st) {
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				topoSort(graph, e.nbr, visited,st);
			}
		}
		st.push(src);
		
	}

	private static void prims(ArrayList<Edge>[] graph, int src, boolean[] visited) {
		PriorityQueue<Pair16> pq=new PriorityQueue<>();
		pq.offer(new Pair16(src,-1,0));
		while(!pq.isEmpty()) {
			Pair16 rem=pq.poll();
			if(visited[rem.v])continue;
			visited[rem.v]=true; 
			if(rem.av!=-1)
				System.out.println("\t "+rem.v+" via "+rem.av+" @ "+rem.wt);
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false) {
					pq.offer(new Pair16(e.nbr,rem.v,e.wt));
				}
			}
		}
		
	}

	private static void digstra(ArrayList<Edge>[] graph, int src, boolean[] visited) {
		PriorityQueue<Pair15> pq=new PriorityQueue<>();
		pq.offer(new Pair15(src,src+"",0));
	
		while(!pq.isEmpty()) {
			Pair15 rem=pq.poll();
			if(visited[rem.v])continue;
			visited[rem.v]=true;
			System.out.println("\t "+rem.v+" via "+rem.psf+" @ "+rem.wsf);
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false) {
					pq.offer(new Pair15(e.nbr,rem.psf+e.nbr,rem.wsf+e.wt));
				}
			}
		}
	}

	private static void infection(ArrayList<Edge>[]graph,int src,int [] visited) {
		int count=0;
		int t=3;
		ArrayDeque<Pair11> q=new ArrayDeque<>();
		q.add(new Pair11(src,1));
		while(!q.isEmpty()) {
			Pair11 rem=q.removeFirst();
			if(visited[rem.v]>0)
				continue;
			visited[rem.v]=rem.t;
			if(rem.t>t)
				break;
			count++;
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==0) {
					q.add(new Pair11(e.nbr,rem.t+1));
				}
			}
		}
		System.out.println("\t "+count);
	}
	private static boolean bipartite(ArrayList<Edge>[] graph, int v, int[] visited13) {
		ArrayDeque<Pair13> q=new ArrayDeque<>();
		q.add(new Pair13(v,v+"",0));
		while(!q.isEmpty()) {
			Pair13 rem=q.removeFirst();
			if(visited13[rem.v]!=-1) {
				if(visited13[rem.v]!=rem.level)return false;
			}
			visited13[rem.v]=rem.level;
			for(Edge e:graph[rem.v]) {
				if(visited13[e.nbr]==-1) {
					q.add(new Pair13(e.nbr,rem.psf+e.nbr,rem.level+1));
				}
			}
		}
		return true;
	}
	private static boolean dfsCycle(ArrayList<Edge>[] graph, int src, boolean[] visited, int parent) {
		
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				if(dfsCycle(graph,e.nbr,visited,src))return true;
			}else if(e.nbr!=parent){
				return true;
			}
		}
		return false;
	}
	private static boolean cycles(ArrayList<Edge>[] graph, int v, boolean[] visited) {
		ArrayDeque<Pair11> q=new ArrayDeque<>();
		q.add(new Pair11(v,v+""));
		while(!q.isEmpty()) {
			Pair11 rem=q.removeFirst();
			if(visited[rem.v])return true;
			visited[rem.v]=true;
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false) {
					q.add(new Pair11(e.nbr,rem.psf+e.nbr));
				}
			}
		}
		return false;
	}
	private static void bfs(ArrayList<Edge>[] graph,int src,boolean visited[]) {
		ArrayDeque<Pair11> q=new ArrayDeque<>();//rm*wA*
		q.add(new Pair11(src,""+src));
		while(!q.isEmpty()) {
			Pair11 rem=q.removeFirst();
			if(visited[rem.v])continue;
			visited[rem.v]=true;
			System.out.println("\t "+rem.v+"@"+rem.psf);
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false) {
					q.add(new Pair11(e.nbr,rem.psf+e.nbr));
				}
			}
		}
		
	}
	private static void printKnightsTour(int[][] chess, int i, int j, int move) {
		if(i<0 || j<0 || i>=chess.length || j>=chess.length || chess[i][j]>0)return;
		if(move==chess.length*chess.length) {
			chess[i][j]=move;
			Utils.display(chess);
			chess[i][j]=0;
			return;
		}
		chess[i][j]=move;
		printKnightsTour(chess,i-1,j-2,move+1);
		printKnightsTour(chess,i-2,j-1,move+1);
		printKnightsTour(chess,i-2,j+1,move+1);
		printKnightsTour(chess,i-1,j+2,move+1);
		printKnightsTour(chess,i+1,j+2,move+1);
		printKnightsTour(chess,i+2,j+1,move+1);
		printKnightsTour(chess,i+2,j-1,move+1);
		printKnightsTour(chess,i+1,j-2,move+1);
		chess[i][j]=0;
		
	}
	public static void hamiltonian(ArrayList<Edge>[] graph, int src,HashSet<Integer> visited, String psf, int orgSrc) {
		if(visited.size()==graph.length-1) {
			System.out.print("\t"+psf);
			boolean cycleFound=false;
			for(Edge e:graph[src])
			{
				if( e.nbr==orgSrc)
				{
					cycleFound=true;
					break;
				}
			}
			System.out.println((cycleFound==true?"*":"."));
			return;
		}
		visited.add(src);
		for(Edge e:graph[src]) {
			if(!visited.contains(e.nbr)) {
				hamiltonian(graph, e.nbr, visited,psf+e.nbr, orgSrc);
			}
		}
		visited.remove(src);
	}
	private static void perfect(ArrayList<Edge>[] graph, int v, boolean[] visited, ArrayList<Integer> cmp) {
		cmp.add(v);
		visited[v]=true;
		for(Edge e:graph[v]) {
			if(visited[e.nbr]==false) {
				perfect(graph, e.nbr, visited, cmp);
			}
		}
	}
	private static void island(int[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==1)return;
		grid[i][j]=1;
		island(grid,i-1,j);
		island(grid,i+1,j);
		island(grid,i,j-1);
		island(grid,i,j+1);
		//grid[i][j]=0;
		
	}
	private static void component(ArrayList<Edge>[] graph,int src,boolean[] visited,ArrayList<Integer> comp) {
		visited[src]=true;
		comp.add(src);
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				component(graph, e.nbr, visited, comp);
			}
		}
	}


	private static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k,
			String psf, int wsf) {
		if(src==dest) {
			if(wsf<spathwt) {
				spathwt=wsf;
				spath=psf;
			}
			if(wsf>lpathwt) {
				lpathwt=wsf;
				lpath=psf;
			}
			if(wsf<cpathwt && wsf>criteria) {
				cpathwt=wsf; 
				cpath=psf;
			}
			if(wsf<criteria && wsf>fpathwt) {
				fpathwt=wsf;
				fpath=psf;
			}
			
			if(pq.size()<k) {
				pq.offer(new Pair(wsf,psf)); 
			}else if(pq.peek().wsf<wsf) {
				pq.poll();
				pq.offer(new Pair(wsf,psf)); 

			} 
			return;
		}
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				multiSolver(graph, e.nbr, dest, visited, criteria, k, psf+e.nbr, wsf+e.wt);
			}
		}
		visited[src]=false;
		
	}


	private static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
		if(src==dest) {
			System.out.println("\t "+psf);
			return;
		}
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				printAllPath(graph,e.nbr,dest,visited,psf+e.nbr);
			} 
		}
		visited[src]=false;
	}

	private static boolean dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
		if(src==dest)return true;
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				boolean hasPath=dfs(graph,e.nbr,dest,visited);
				if(hasPath)return true;
			}
		}
		return false;
	}

}
