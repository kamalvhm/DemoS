package com.graph;
import java.io.*;
import java.util.*;

public class PerFactFriendV8 {
    static class Edge {
	      int v;
	      int n;

	      Edge(int src, int nbr) {
	         this.v = src;
	         this.n = nbr;
	      }
	   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
        ArrayList<Edge>[] grp=new ArrayList[n]; 
	      for(int v=0;v<n;v++) {
	    	  grp[v]=new ArrayList<>();
	      }
	      for(int e=0;e<k;e++) {
	    	  String line=br.readLine();
	    	  int v1=Integer.parseInt(line.split(" ")[0]);
	    	  int v2=Integer.parseInt(line.split(" ")[1]);
	    	  
	    	  grp[v1].add(new Edge(v1,v2));
	    	  grp[v2].add(new Edge(v2,v1));
	      }
	      
	      //getting connected Component
	      ArrayList<ArrayList<Integer>> comps =new ArrayList<>();
	      boolean[] visited=new boolean[n]; 
	      for(int i=0;i<n;i++){
	          if(visited[i]==false){
	              ArrayList<Integer> list=new ArrayList<>();
	              getComponent(grp,i,visited,list);
	              comps.add(list);
	          }
	      }
	      
	      //no solving so loop for combination
	      int pairs=0;
	      //if 3 component is there C1,C2,C3 then combination will be C1C2,C1C3 & C2C3 so both loop to select component 
	      for(int i=0;i<comps.size();i++){
	          for(int j=i+1;j<comps.size();j++){
	              int count=comps.get(i).size()*comps.get(j).size();
	              pairs+=count;
	          }
	      }
	      System.out.println(pairs);
	      
   }
   public static void getComponent( ArrayList<Edge>[] grp,int src,boolean[] visited,ArrayList<Integer> list){
       visited[src]=true;
       list.add(src);
       for(Edge e:grp[src]){
           if(visited[e.n]==false){
               getComponent(grp,e.n,visited,list);
           }
       }
   }

}