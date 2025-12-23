package dels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class DFS_Test {
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
	     int v;
		int wsf;
		
		Pair(String psf,int wsf){
			this.psf=psf;
			this.wsf=wsf;
		}
		Pair(int v,String psf){
			this.psf=psf;
			this.v=v;
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
		//src\main\resources\graph\graph1.txt
		String filePath="src/main/resources/graph/graph1.txt";
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
		
		boolean [] visited=new boolean[vtces];
		System.out.println("1) Has Path -"+dfs(graph,src,dest,visited));
		visited=new boolean[vtces];
		System.out.println("2) Print All Path -");
		dfs(graph,src,dest,visited,""+src);
		
	    int criteria=40;//for ceil and floor 
	    int k=3;
		visited=new boolean[vtces];
		multisolver(graph,src,dest,visited,""+src,0,criteria,k);
		System.out.println("3) Multipath ...");
		System.out.println("\t i) Smallest Path (0123456@36)=" + spath + "@" + spathwt);
		System.out.println("\t ii) Largest Path (0346@50)= " + lpath + "@" + lpathwt);
		System.out.println("\t iii) (03456@48) Just Larger Path than   " + criteria + " = " + cpath + "@" + cpathwt);
		System.out.println("\t iv) (0123456@38)Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
		System.out.println("\t v) "+k + "th largest path (012346@40) = " + pq.peek().psf + "@" + pq.peek().wsf);
		
		Stack<Pair> st=new Stack<>();
		visited=new boolean[vtces];
		st.push(new Pair(src,src+""));
		
		while(!st.isEmpty()) {
			Pair rem=st.pop();
			if(visited[rem.v])continue; 
			visited[rem.v]=true;
			System.out.println(rem.v+" @ "+rem.psf);
			for(Edge e:graph[rem.v]) {
				if(visited[e.nbr]==false) {
					st.push(new Pair(e.nbr,rem.psf+e.nbr));
				}
			}
		}

		
	}
	static PriorityQueue<Pair> pq=new PriorityQueue<>();
	static String spath="";
	static String lpath="";
	static String cpath="";
	static String fpath="";
	static Integer spathwt = Integer.MAX_VALUE;
    static Integer lpathwt = Integer.MIN_VALUE;
    static Integer cpathwt = Integer.MAX_VALUE;
    static Integer fpathwt = Integer.MAX_VALUE;

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
	
	private static void dfs(ArrayList<Edge>[] graph,int src,int dest,boolean visited[],String psf) {
		if(src==dest) {
			System.out.println("\t Path:- "+psf);
			return;
		}
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				dfs(graph,e.nbr,dest,visited,psf+e.nbr);
			}
		}
		visited[src]=false;
	}
	
	private static void multisolver(ArrayList<Edge>[]graph,int src,int dest,boolean[] visited,String psf,int wsf,int criteria,int k) {
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
			if(wsf>fpathwt && wsf<criteria) {
				fpathwt=wsf;
				fpath=psf;
			}
			
			if(pq.size()<k)
					pq.offer(new Pair(psf,wsf));
				else {
					if(wsf>pq.peek().wsf) {
						pq.poll();
						pq.offer(new Pair(psf,wsf));
					}
				}
			
			
			return;
		}
		visited[src]=true;
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				multisolver(graph,e.nbr,dest,visited,psf+e.nbr,wsf+e.wt,criteria,k);
			}
		}
		visited[src]=false;
	}
}
