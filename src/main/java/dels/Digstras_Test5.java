package dels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Digstras_Test5 {
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
		int v;
		String psf;
		int wsf;
		
		Pair(int v,String psf,int wsf){
			this.v=v;
			this.psf=psf;
			this.wsf=wsf;
		}
		
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
		
		String filePath="src/graph/graph5.txt";
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

		PriorityQueue<Pair> q=new PriorityQueue<>();
		q.offer(new Pair(src,src+"",0));
		boolean [] visited=new boolean[vtces];
		while(!q.isEmpty()) {
			Pair rem=q.poll();
			
			if(visited[rem.v])continue;
			visited[rem.v]=true;
			System.out.println(rem.v+" via "+rem.psf+" @ "+rem.wsf);
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false) {
					q.offer(new Pair(e.nbr,rem.psf+e.nbr,rem.wsf+e.wt));
				} 
			}
		}
		
	}
	
	

}
