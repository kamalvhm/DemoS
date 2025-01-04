package dels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Bipartite_Test5 {
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
		int level;
		
		Pair(int v,String psf,int level){
			this.psf=psf;
			this.v=v;
			this.level=level;
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
		
		String filePath="src/graph/bipertite.txt";
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
		
//		int src=Integer.parseInt(fr.readLine());
//		int dest=Integer.parseInt(fr.readLine());
//		System.out.println("\t Source:- "+src+" Destination:- "+dest);
		int []visited=new int[vtces];
		Arrays.fill(visited,-1);
		for(int v=0;v<vtces;v++) {
			if(visited[v]==-1) {
				boolean bipartite=bfs(graph,v,visited);
				if(bipartite==false) {
					System.out.println("Graph is Not Bipartite!!");
					return ;
				}
			}
		}
		System.out.println("Graph is Bipartite!!");

	}
	
	private static boolean bfs(ArrayList<Edge> graph[],int src,int [] visited) {
		ArrayDeque<Pair> q=new ArrayDeque<>();
		q.offer(new Pair(src,src+"",0));
		while(!q.isEmpty()) {
			Pair rem=q.removeFirst();
			
			if(visited[rem.v]!=-1) {
				if(visited[rem.v]!=rem.level)return false;
			}
			visited[rem.v]=rem.level;
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==-1) {
					q.offer(new Pair(e.nbr,rem.psf+e.nbr,rem.level+1));
				}
			}
		}
		return true;
	}
	

}
