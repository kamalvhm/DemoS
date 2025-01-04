package dels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DFS_Test2 {
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
		
		String filePath="src/graph/graph2.txt";
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
		
		boolean [] visited=new boolean[vtces];
		ArrayList<ArrayList<Integer>> components=new ArrayList<>();
		System.out.println("5) Connected Componets -");
		
		for(int v=0;v<vtces;v++) {
			if(visited[v]==false) {
				ArrayList<Integer> comp=new ArrayList<>();
				dfs(graph,v,visited,comp);
				components.add(comp);
			}
		}
		
		System.out.println("1) Components:-"+components);
		System.out.println("2) is Graph Connected:- "+(components.size()==1));
		
		 int[][] grid = new int[][] {
	           {1, 1, 0, 0, 0},
	           {1, 1, 0, 0, 0},
	           {0, 0, 1, 0, 0},
	           {0, 0, 0, 1, 1}};
	           
	           boolean [][] visited2=new boolean[grid.length][grid[0].length];
	           int count=0;
	           for(int i=0;i<grid.length;i++) {
	        	   for(int j=0;j<grid[0].length;j++) {
	        		   if(grid[i][j]==1 && visited2[i][j]==false) {
	        			   dfs(grid,i,j,visited2);
	        			   count++;
	        		   }
	        	   }
	           }
	           System.out.print("3) Iceland:- "+count);
	      
	           
		visited=new boolean[vtces];
		components=new ArrayList<>();
		for(int v=0;v<vtces;v++) {
			if(visited[v]==false) {
				ArrayList<Integer> comp=new ArrayList<>();
				perfect(graph,v,visited,comp);
				components.add(comp);
			}
		}
		int total=0;
		for(int i=0;i<components.size();i++) {
			for(int j=i+1;j<components.size();j++) {
				total+=components.get(i).size()*components.get(j).size();
			}
		}
		System.out.println("Perfect Friends :- "+total);
	}
	
	public static void perfect(ArrayList<Edge>[] graph,int src,boolean [] visited,ArrayList<Integer> comp) {
		visited[src]=true;
		comp.add(src);
		for(Edge e:graph[src]) {
			if(visited[e.nbr]==false) {
				perfect(graph, e.nbr, visited, comp);
			}
		}
	}
	
	private static void dfs(ArrayList<Edge> [] graph,int v,boolean []visited,ArrayList<Integer> comp) {
		comp.add(v);
		visited[v]=true;
		for(Edge e:graph[v]) {
			if(visited[e.nbr]==false) {
				dfs(graph,e.nbr,visited,comp);
			}
		}
	}

	public static void dfs(int[][]grid,int r,int c,boolean [][]visited) {
		if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 || visited[r][c]==true)return; 
		visited[r][c]=true;
		dfs(grid,r-1,c,visited);//T
		dfs(grid,r,c-1,visited);//l
		dfs(grid,r+1,c,visited);//d
		dfs(grid,r,c+1,visited);//r

	}


}
