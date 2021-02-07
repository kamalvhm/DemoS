package com.intquetions;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//Related-463. Island Perimeter	


class Islands  {

public int numOfIcelands(int[][] grids)	{
	int h=grids.length;
	if(h==0)return 0;
	int l =grids[0].length;
	int count=0;
	for(int i=0;i<h;i++) {
		for(int j=0;j<l;j++) {
			if(grids[i][j]==1) {
				DFS2(grids, i, j);
				count++;
			}
		}
	}
	return count;
}
	
    private void DFS2(int[][] grids, int row, int col) {
    	int h=grids.length;
    	int l=grids[0].length;
    	
    	if(row<0 || col<0 || row>=h || col >=l ||grids[row][col]!=1)return;
    	
    	grids[row][col]=0;
    	
    	DFS2(grids,row+1,col);
    	DFS2(grids,row-1,col);
    	DFS2(grids,row,col+1);
    	DFS2(grids,row,col-1);

    	
}
    
 

	public int numIslands(char[][] islandGrid) {

        int h = islandGrid.length;
        if (h == 0)
            return 0;
        int l = islandGrid[0].length;
        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                if (islandGrid[i][j] == '1') {
                    DFS(islandGrid, i,  j);
                    result++;
                }
            }
        }
        return result;
    }

    public void DFS(char[][] islandGrid, int row, int col) {

        int H = islandGrid.length;
        int L = islandGrid[0].length;

        if (row < 0 || col < 0 || row >= H || col >= L || islandGrid[row][col] != '1')
            return;
        islandGrid[row][col] = '0'; //marking it visited
        DFS(islandGrid, row+ 1, col); // go right
        DFS(islandGrid, row- 1, col); //go left
        DFS(islandGrid, row, col + 1); //go down
        DFS(islandGrid, row, col - 1); // go up
    }
    
 

    public static void main(String[] args) {
    	 char [][] cc = new char[][] {
             {'O', 'O', 'O'},
             {'O', 'O', 'O'},
             {'O', 'O', 'O'}
            
            };
           
            solve(cc);

        char [][] islandGrid = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
                
        Islands noOfIslands = new Islands();
       // System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));

        islandGrid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("No of Islands: " + noOfIslands.numIslands(islandGrid));
        
        
       int[][] islandGrid2 = new int[][] {
           {1, 1, 0, 0, 0},
           {1, 1, 0, 0, 0},
           {0, 0, 1, 0, 0},
           {0, 0, 0, 1, 1}};
           
           //System.out.println("No of Islands: " + noOfIslands.numIslandsIterativeDFS(islandGrid));
           
           
          

    }
    
    private static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left

    public static int numIslandsIterativeDFS(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int counter = 0;
        //if Queue is used then BFS to get poll() to add add();
        Stack<int[]> q = new Stack<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    q.push(new int[]{i ,j});
                    grid[i][j] = '0';
                    while ( ! q.isEmpty()) {
                        int[] current = q.pop();
                        for (int[] dir : directions) {
                            int row = current[0] + dir[0];
                            int col = current[1] + dir[1];
                            if (row >= 0 && row < grid.length &&
                                    col >= 0 && col < grid[0].length &&
                                    grid[row][col] == '1') {
                                q.push(new int[]{row, col});
                                grid[row][col] = '0';
                            }
                        }
                    }
                    counter++;
                }
            }
        }

        return counter;
    }
    
    
    
    //BFS Solution
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
         int counter = 0;
        
         Queue<int[]> q=new ArrayDeque<>();
         
         for(int i=0;i<grid.length;i++)
         {
             for(int j=0;j<grid[0].length;j++)
          {
             if(grid[i][j]==1){
                 q.offer(new int[]{i,j});
                 grid[i][j]=0;
                 
                 while(!q.isEmpty()) {
                	 int [] cur=q.poll();
                	 for(int[] dir:direction) {
                		 int row=cur[0]+dir[0];
                		 int col=cur[1]+dir[1];
                		 
                		 if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]==1) {
                			 q.offer(new int[]{row,col});
                			 grid[row][col]=0;
                		 }
                	 }
                 }
                 counter++;
                 
             }
         }  
         }
         return counter;  
     }
    
    private static int[][] direction= {{-1,0},{1,0},{0,-1},{0,1}};
    
    
    
    
    
    public static void solve(char[][] board) {
        int h=board.length;
        if(h==0)return;
        int l=board[0].length;
        
        
        Queue<int[]> q=new ArrayDeque<>();
        
        
        for(int i=0;i<h;i++){
           for(int j=0;j<l;j++){
                if(board[i][j]=='O' && i>0 && j>0 && i<h-1 && j<l-1){
                    q.offer(new int[]{i,j});
                    board[i][j]='X';   
                    while(!q.isEmpty()){
                       int[] cur=q.poll();
                        for(int[] dir:directions){
                            int row=cur[0]+dir[0];
                            int col=cur[1]+dir[1];
                           if(row>0 && col>0 && row<h-1 && col<l-1 && board[i][j]=='O')
                             q.offer(new int[]{row,col});
                             board[row][col]='X';   
                            }
                    }    
                    
                }
             } 
        }
    }
    
    ///DFS solution of 559. Maximum Depth of N-ary Tree
    
    //695. Max Area of Island   (ALSO 286 walls and gates similar)
    public static int DFS(int[][] grid, int row,int col)
    {
        int h=grid.length;
        int l=grid[0].length;
        
        if(row<0 || col<0 || row>=h || col>=l || grid[row][col]!=1) return 0;
        int count=1;
        grid[row][col]=0;
         count+=DFS(grid,row-1,col);
         count+=DFS(grid,row+1,col);
         count+=DFS(grid,row,col-1);
         count+=DFS(grid,row,col+1);
        
        return count;
        
    }
    
    
    //LOCKED 286 walls and gates similiar) call DFS_WALLS(grids,i,j,0);
    public static void DFS_WALLS(int[][] grid, int row,int col,int count)
    {
        int h=grid.length;
        int l=grid[0].length;
        
        if(row<0 || col<0 || row>=h || col>=l || grid[row][col]<count) return ;
        
        grid[row][col]=count;
         DFS_WALLS(grid,row-1,col,count+1);
         DFS_WALLS(grid,row+1,col,count+1);
         DFS_WALLS(grid,row,col-1,count+1);
         DFS_WALLS(grid,row,col+1,count+1);
        
        return ;
        
    }
    
    //79. Word Search  Bit DIFFICULT   *********************************AWESOME QUESTION*************************************
    public boolean exist(char[][] board, String word) {
        int h =board.length;
        int l = board[0].length;
          for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0) && DFS(board, i, j,  word,0))
                    return true;
            }
        }
        return false;
    }
    
    public boolean DFS(char[][] board, int row,int col,String word,int len){
        if(len==word.length()) { return  true; }
    
        if(row<0 || col<0 || row>=board.length || col>=board[row].length || board[row][col]!=word.charAt(len)) { return false; }
        
        char temp=board[row][col];
        board[row][col]=' '; //setting empty space for visited
        
        boolean found=
        DFS(board,row+1,col,word,len+1) ||
        DFS(board,row-1,col,word,len+1) ||
        DFS(board,row,col+1,word,len+1) ||
        DFS(board,row,col-1,word,len+1);
        
        board[row][col]=temp; //re-setting value  after recursive calls

       return found; 
    }
    //1219. Path with Maximum Gold
    public static int dfs(int[][] grid,int r,int c){
        int h=grid.length;
        int l=grid[0].length;
       if(r<0 || c<0 || r>=h || c>=l || grid[r][c]==0)return 0;
          int count=grid[r][c];
          grid[r][c]=0;
          int val1=Math.max(dfs(grid,r+1,c),dfs(grid,r-1,c));
          int val2=Math.max(dfs(grid,r,c+1),dfs(grid,r,c-1));
          grid[r][c]=count;
          int val=Math.max(val1,val2);
          return count+val;
      }
}