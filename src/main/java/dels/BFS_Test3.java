package dels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

public class BFS_Test3 {
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
	static class Pair implements Comparable<Pair>{
		String psf;
		int wsf;
		
		Pair(String psf,int wsf){
			this.psf=psf;
			this.wsf=wsf;
		}
		
		

		@Override
		public int compareTo(Pair o) {
			return this.wsf-o.wsf;
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
		
		String filePath="src/graph/graph3.txt";
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
		//int dest=Integer.parseInt(fr.readLine());
		//System.out.println("\t Source:- "+src+" Destination:- "+dest);
		HashSet<Integer> visited=new HashSet<>();
		dfs(graph,src,visited,src+"", src);
		
		

		
	}
	
	public static void dfs(ArrayList<Edge>[]graph,int src,HashSet<Integer> visited,String psf,int orgSrc) {
		if(visited.size()==graph.length-1) {
			boolean cycle=false;
			for(Edge e:graph[src]) {
				if(e.nbr==orgSrc) {
					cycle=true;
					break;
				}
			}
			System.out.println("Himiltonian :- "+psf+(cycle?"*":"."));
			return;
		}
		visited.add(src);
		for(Edge e:graph[src]) {
			if(!visited.contains(e.nbr)) {
				dfs(graph,e.nbr,visited,psf+e.nbr,orgSrc);
			}
		}
		visited.remove(src);
	}

}
