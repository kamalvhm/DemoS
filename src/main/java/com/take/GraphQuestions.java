package com.take;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.graph.DisjointSet;

public class GraphQuestions {
	 private boolean isValid(int adjr, int adjc, int n, int m) {
	        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
	    }
	    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
	    	DisjointSet ds = new DisjointSet(n * m);
	        int[][] vis = new int[n][m];
	        int cnt = 0;
	        List<Integer> ans = new ArrayList<>();
	        int len = operators.length;
	        for (int i = 0; i < len ; i++) {
	            int row = operators[i][0];
	            int col = operators[i][1];
	            if (vis[row][col] == 1) {
	                ans.add(cnt);
	                continue;
	            }
	            vis[row][col] = 1;
	            cnt++;
	            // row - 1, col
	            // row , col + 1
	            // row + 1, col
	            // row, col - 1;
	            int dr[] = { -1, 0, 1, 0};
	            int dc[] = {0, 1, 0, -1};
	            for (int ind = 0; ind < 4; ind++) {
	                int adjr = row + dr[ind];
	                int adjc = col + dc[ind];
	                if (isValid(adjr, adjc, n, m)) {
	                    if (vis[adjr][adjc] == 1) { //NBR should be visitied already
	                        int nodeNo = row * m + col;
	                        int adjNodeNo = adjr * m + adjc;
	                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
	                            cnt--;
	                            ds.unionBySize(nodeNo, adjNodeNo);
	                        }
	                    }
	                }
	            }
	            ans.add(cnt);
	        }
	        return ans;
	    }

	    
	    public static void main (String[] args) {
	        int n = 4, m = 5;
	        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
	            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
	        };

	        GraphQuestions obj = new GraphQuestions();
	        List<Integer> ans = obj.numOfIslands1(n, m, operators);

	        int sz = ans.size();
	        for (int i = 0; i < sz; i++) {
	            System.out.print(ans.get(i) + " ");
	        }
	        System.out.println("");
	        
	        //Output: 1 1 2 1 1 2 2 2 3 3 1 1
	    }
	    
	    
	    public static String getAlienLanguage(String []dictionary, int k) {
	        ArrayList<ArrayList<Integer>> grp=new ArrayList<>();
	        for(int i=0;i<k;i++)grp.add(new ArrayList<>());
	        for(int i=0;i<dictionary.length-1;i++){
	            String s1=dictionary[i];
	            String s2=dictionary[i+1];
	            int len=Math.min(s1.length(),s2.length());
	            for(int j=0;j<len;j++){
	                if(s1.charAt(j)!=s2.charAt(j)){
	                    grp.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
	                    break; 
	                }
	            }
	        } 
	        Stack<Integer> st=new Stack<>();
	        boolean []vis=new boolean[k];
	        for(int i=0;i<k;i++){
	            if(vis[i]==false){
	                dfs(grp,i,vis,st);
	            }
	        }
	        StringBuffer sb=new StringBuffer();
	        while(!st.isEmpty()){
	            char ch=(char)(st.pop()+'a');
	            sb.append(ch);
	        }
	        return sb.toString();
	    }
	    public static void dfs( ArrayList<ArrayList<Integer>> grp,int src,boolean vis[],Stack<Integer> st){
	        vis[src]=true;
	        for(int nbr:grp.get(src)){
	            if(vis[nbr]==false){
	                dfs(grp,nbr,vis,st);
	            }
	        }
	        st.push(src);
	    }
	  
	    public List<Integer> numOfIslands1(int n, int m, int[][] operators) {
	    	List<Integer> ans=new ArrayList<>();
	    	int cnt=0;
	    	boolean[][]visited=new boolean[n][m];
	    	DisjointSet ds=new DisjointSet(n*m);
	    	for(int op[]:operators) {
	    		int i=op[0];
	    		int j=op[1];
	    		if(visited[i][j]) {
	    			ans.add(cnt); 
	    			continue;
	    		}
	    		visited[i][j]=true;
	    		cnt++;
	    		for(int dir[]:directions) {
	    			int r=dir[0]+i;
	    			int c=dir[1]+j;
	    			if(r>=0 && c>=0 && r<n && c<m) {
	    				if(visited[r][c]==true) {
	    					int cellNo=i*m+j;
	    					int adjCellno=r*m+c;
	    					if(ds.findUPar(cellNo)!=ds.findUPar(adjCellno)) {
	    						ds.unionByRank(cellNo,adjCellno);
	    						cnt--;
	    					}
	    				}
	    			} 
	    		}
	    		ans.add(cnt);
	    		
	    	}
	    	return ans;
	    }
	    int directions[][]={{0,1},{1,0},{0,-1},{-1,0}};
	    
	    //https://www.naukri.com/code360/problems/distinct-islands_630460?leftPanelTabValue=PROBLEM
	    /**
	     * 
		 	1 1 0 0 0 
			1 1 0 0 0
			0 0 0 1 1
			0 0 0 1 1   
			for this n this example, we have two islands and they are the same as 
			we can translate one island onto another island, so our answer should be 1.
	     */
	    public static int distinctIsland(int [][] arr, int n, int m) 
		{
			HashSet<String> unqCodes=new HashSet<>();
	        for(int i=0;i<n;i++){
	            for(int j=0;j<m;j++){
	                if(arr[i][j]==1){ //from every place where is 1 go redially level wise and store unique codes for directions
	                    unqCodes.add(bfs(arr,i,j));
	                }
	            }
	        }
	        return unqCodes.size();
		}


	    public static String bfs(int grid[][],int n,int m){
	        StringBuffer sb=new StringBuffer();
	        Queue<int[]> q=new LinkedList<>();
	        q.offer(new int[]{n,m});
	        while(!q.isEmpty()){
	            int size=q.size();
	            for(int i=0;i<size;i++){
	                int []rem=q.poll();
	                for(int dir[]:direction){
	                    int r=rem[0]+dir[0];
	                    int c=rem[1]+dir[1];
	                    if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!=1){
	                        sb.append(0); 
	                        continue;
	                    }
	                    grid[r][c]=2; // first traverse is from 0,0 so we are marking nbr to 2 so that per island we can add 
	                    q.offer(new int[]{r,c});
	                    sb.append(dir[2]);
	                }
	            }
	        }
	        return sb.toString();
	    }

	    static int direction[][]={{1,0,1},{-1,0,2},{0,1,3},{0,-1,4}}; //row column and direction code

}
