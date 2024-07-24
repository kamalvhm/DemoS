package com.graph;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class SpreadInfectionV14 {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
    static class Pair{
       int v;
       int time;//when it will become sick
       Pair(int v,int time){
           this.v=v;
           this.time=time;
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
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayDeque<Pair> q=new ArrayDeque<>();
      q.add(new Pair(src,1));//on t1 time src is sick
      int [] visited=new int[vtces];//o is unvisited and we will add time when that vertex get sick
      int count=0;
      while(q.size()>0){
          Pair rem=q.removeFirst();
          
          if(visited[rem.v]>0)
             continue;
          visited[rem.v]=rem.time;
          if(rem.time>t)//if time exceeds asked time then break 
            break;
          count++;//maintains count how many got sick
          
          
          
          for(Edge e:graph[rem.v]){
              if(visited[e.nbr]==0){
                  q.add(new Pair(e.nbr,rem.time+1));
              }
          }
          
          
      }
      System.out.println(count);
   }
//https://leetcode.com/problems/rotting-oranges/
   
   public int orangesRotting(int[][] grid) {
       int h=grid.length;
       int w=grid[0].length;
       boolean [][] visited=new boolean[h][w];

       ArrayDeque<Pair2> q=new ArrayDeque<>();
       int ones=0;
       for(int i=0;i<h;i++){
           for(int j=0;j<w;j++){
               if(grid[i][j]==2){
                   q.offer(new Pair2(i,j,0));
               }else if(grid[i][j]==1)
                   ones++; 
           }
       }
       int count=0;
       while(!q.isEmpty()){
           Pair2 rem=q.removeFirst();
           if(visited[rem.r][rem.c])continue;
           visited[rem.r][rem.c]=true;
           count=rem.t;
           if(rem.t>0)
               ones--;
           if(rem.r+1<grid.length && grid[rem.r+1][rem.c]==1)
               q.offer(new Pair2(rem.r+1,rem.c,rem.t+1));
           if(rem.r-1>=0 && grid[rem.r-1][rem.c]==1)
               q.offer(new Pair2(rem.r-1,rem.c,rem.t+1));
           if(rem.c+1<grid[0].length && grid[rem.r][rem.c+1]==1)
               q.offer(new Pair2(rem.r,rem.c+1,rem.t+1));
           if(rem.c-1>=0 && grid[rem.r][rem.c-1]==1)
               q.offer(new Pair2(rem.r,rem.c-1,rem.t+1));
       }

       return ones==0?count:-1;
   }

   static class Pair2{
       int r;
       int c;
       int t;
       Pair2 (int r,int c,int t){
           this.r=r;
           this.c=c;
           this.t=t;
       }
   }
}