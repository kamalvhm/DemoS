package com.take;

import java.util.ArrayList;
import java.util.List;
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
	        List<Integer> ans = obj.numOfIslands(n, m, operators);

	        int sz = ans.size();
	        for (int i = 0; i < sz; i++) {
	            System.out.print(ans.get(i) + " ");
	        }
	        System.out.println("");
	        
	        //Output: 1 1 2 1 1 2 2 2 3 3 1 1
	    }
	    
	  

}
