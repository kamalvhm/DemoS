package com.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//https://www.youtube.com/watch?v=GHnC5qHexsk&list=PL-Jc9J83PIiHfqDcLZMcO9SsUDY4S3a-v&index=11
public class BreathFirstSearchInGraphsV11 {

	   static class Edge {
	      int src;
	      int nbr;

	      Edge(int src, int nbr) {
	         this.src = src;
	         this.nbr = nbr;
	      }
	   }
	   static class Pair {
	       int v;
	       String psf;
	       
	       Pair(int v,String psf){
	           this.v=v;
	           this.psf=psf;
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
	         graph[v1].add(new Edge(v1, v2));
	         graph[v2].add(new Edge(v2, v1));
	      }

	      int src = Integer.parseInt(br.readLine());

	      // write your code here  
	      ArrayDeque<Pair> queue=new ArrayDeque<>();
	      queue.add(new Pair(src,src+""));
	      boolean [] visited=new boolean[vtces];
	      while(queue.size()>0){
	          //r m* w a*
	          Pair rem=queue.removeFirst();
	          if(visited[rem.v]==true){//if aldeardy visited then do nothing
	              continue;
	          }
	          //mark * 
	          visited[rem.v]=true;
	          //work
	          System.out.println(rem.v+"@"+rem.psf);
	          //add* unvisited nbr
	          for(Edge e:graph[rem.v]){
	              if(visited[e.nbr]==false){
	                  queue.add(new Pair(e.nbr,rem.psf+e.nbr));
	              }
	          }
	      }
	   }
	   /***QUESTIONS***/
	   //433. Minimum Genetic Mutation https://www.youtube.com/watch?v=wIsJ6G5qXkI
	   //https://leetcode.com/problems/minimum-genetic-mutation/
	   /**
	   		In below problem we need minimum Mutation which is mutation is represented by edges so min distance to end so thans why BFS is suited here 
	    */
		public int minMutation(String startGene, String endGene, String[] bank) {
			char mutation[] = { 'A', 'C', 'G', 'T' };
			List<String> bankList = Arrays.asList(bank);

			HashSet<String> visited = new HashSet<>();
			Queue<String> q = new LinkedList<>();
			q.offer(startGene);

			int count = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int level = 0; level < size; level++) { // this level loop is just to count how many level mutation
																// we have done so far from original string in other
																// words just to count  THIS LOOP CAN BE AVOIDED BY STORING LEVEL IN PAIR CLASS 
					String s = q.poll();

					if (visited.contains(s))
						continue;

					visited.add(s);

					if (s.equals(endGene))
						return count;

					for (int i = 0; i < s.length(); i++) {
						for (char ch : mutation) {
							String converted = s.substring(0, i) + ch + s.substring(i + 1);
							if (bankList.contains(converted)) {
								q.offer(converted);

							}
						}
					}
				}
				count++;

			}
			return -1;
		}
		
		
//		 public int minMutation(String startGene, String endGene, String[] bank) {
//		        char mutation[]={'A','C','G','T'};
//		        List<String> bankList=Arrays.asList(bank);
//		        
//		        
//		        HashSet<String> visited=new HashSet<>();
//		        Queue<Pair> q=new LinkedList<>();
//		        q.offer(new Pair(startGene,0));
//		        
//		    while(!q.isEmpty()){
//		            Pair rem=q.poll();
//		            String s=rem.s;
//		            if(visited.contains(s))
//		                continue;
//		            
//		            visited.add(s);
//		            
//		             if(s.equals(endGene))
//		                return rem.level;
//		            
//		            for(int i=0;i<s.length();i++){
//		                for(char ch:mutation){
//		                    String converted=s.substring(0,i)+ch+s.substring(i+1);
//		                    if(bankList.contains(converted)){
//		                        q.offer(new Pair(converted,rem.level+1));
//		                       
//		                    }
//		                }
//		            }
//		        
//		            
//		        }
//		        return -1;
//		    }
	 
}


