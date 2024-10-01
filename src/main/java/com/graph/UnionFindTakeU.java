package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class UnionFindTakeU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }
	//G-51 
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
                ans.add(cnt);//just to store ans of already visited node in case of duplicate query 
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
                    if (vis[adjr][adjc] == 1) { //means its iceland already
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
    
    
    //827. Making A Large Island
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }

    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n * n);
        // step - 1  done connecting components as is
        for (int row = 0; row < n ; row++) {
            for (int col = 0; col < n ; col++) {
                if (grid[row][col] == 0) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo, adjNodeNo);
                    }
                }
            }
        }
        // step 2 trverse every 0 and convert it to 1 and check size
        int mx = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) continue;
                int dr[] = { -1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                for (int ind = 0; ind < 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if (grid[newr][newc] == 1) {
                            components.add(ds.findUPar(newr * n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for (Integer parents : components) {
                    sizeTotal += ds.size.get(parents);
                }
                mx = Math.max(mx, sizeTotal + 1);
            }
        }
        //check to find if all are 1 in grid in that case ulp will be the maximum
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            mx = Math.max(mx, ds.size.get(ds.findUPar(cellNo)));
        }
        return mx;
    }
    
    //1202. Smallest String With Swaps https://www.youtube.com/watch?v=O3jr8HOpkUU
    /**         01234
	    Example edabc [0,2][0,3][1,4];
	    first we group all list in to uniot find which results
	    0->0 parent
	    2->0
	    3->0  so [0,2,3] is in one group chars for these is [e,a,b]
	    similierly 1->1 and 4->1 so [1,4] in one group [d,c]
	    we sort chars from these groups and form our ans 
	    we iterate input chars and if index is 0,2,3 we pick sorted chars from first group 
	    and if index is 1,4 we pick chars from secound group so ans = adbec
	*/
	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		int n = s.length();
		DisjointSet ds = new DisjointSet(n);
		for (List<Integer> pair : pairs) {
			ds.unionBySize(pair.get(0), pair.get(1));
		}
		HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int parent = ds.findUPar(i);
			PriorityQueue<Character> pq = map.getOrDefault(parent, new PriorityQueue<>());
			pq.offer(s.charAt(i));
			map.putIfAbsent(parent, pq);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			int parent = ds.findUPar(i);
			PriorityQueue<Character> pq = map.get(parent);
			sb.append(pq.poll());
		}
		return sb.toString();

	}

}


