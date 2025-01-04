package dels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Cycles_Test4 {
	static class Edge{
		int src;
		int nbr;
		int wt;
		String psf;
		
		Edge(int src,int nbr,int wt){
			this.src=src;
			this.nbr=nbr;
			this.wt=wt;
		}
		
	}
	static class Pair {
		int v;
		String psf;
		
		Pair(int v,String psf){
			this.psf=psf;
			this.v=v;
		}
		
	}
	
	public static void main(String args[]) throws Exception {
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
		
		String filePath="src/graph/graph1.txt";
		BufferedReader fr=new BufferedReader(new FileReader(filePath));
		int vtces=Integer.parseInt(fr.readLine());
		
		ArrayList<Edge>[] graph=new ArrayList[vtces];
		for(int i=0;i<vtces;i++) {
			graph[i]=new ArrayList<>();
		}
		
		int n=Integer.parseInt(fr.readLine());
		for(int i=0;i<n;i++) {
			String[] splits=fr.readLine().split(" ");
			int src=Integer.parseInt(splits[0]);
			int nbr=Integer.parseInt(splits[1]);
			int wt=Integer.parseInt(splits[2]);
			
			graph[src].add(new Edge(src,nbr,wt));
			graph[nbr].add(new Edge(nbr,src,wt));
			
			//System.out.println("src-"+src+", nbr-"+nbr+", wt-"+wt);
		}
		
		int src=Integer.parseInt(fr.readLine());
		int dest=Integer.parseInt(fr.readLine());
		System.out.println("\t Source:- "+src+" Destination:- "+dest);
		boolean []visited=new boolean[vtces];
		for(int v=0;v<vtces;v++) {
			if(visited[v]==false) {
				boolean isCycle=bfs(graph,v,visited);
				if(isCycle) {
					System.out.println("Cycle Exist!!");
					return;
				}
			}
		}
		
		System.out.println("Cycle Not Found !!");

		
	}
	
	public static boolean bfs(ArrayList<Edge>[] graph,int v,boolean visited[]) {
		ArrayDeque<Pair> q=new ArrayDeque<>();
		q.offer(new Pair(v,v+""));
		while(!q.isEmpty()) {
			Pair rem=q.removeFirst();
			
			if(visited[rem.v])return true;
			visited[rem.v]=true;
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false) {
					q.offer(new Pair(e.nbr,rem.psf+e.nbr));
				} 
			}
		}
		return false; 
	}
	
	public static boolean dfs(ArrayList<Edge>[] graph,int src,boolean [] visited,int p) {
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				boolean isCycle=dfs(graph,e.nbr,visited,src);
				if(isCycle)return true;
			}else if(e.nbr!=p)return true;
		}
		
		return false;
	}
	
}
