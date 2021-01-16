package com.intquetions;

public class GraphTraversalProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    //994. Rotting Oranges ***********************AWESOME QUESTION********************https://www.youtube.com/watch?v=TzoDDOj60zE
	 public int orangesRotting(int[][] grid) {
	       if(grid == null || grid.length == 0) return -1;
	        
	        for(int i=0; i<grid.length; i++) {
	            for(int j=0; j<grid[0].length; j++) {
	                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
	            }
	        }
	        
	        int minutes = 2;
	        for(int[] row : grid) {
	            for(int cell : row) {
	                if(cell == 1) return -1;
	                minutes = Math.max(minutes, cell);
	            }
	        }
	        
	        return minutes - 2;
	    }
	    
	    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
	        if(i < 0 || i >= grid.length /* out of bounds */
	          || j < 0 || j >= grid[0].length /* out of bounds */
	          || grid[i][j] == 0 /* empty cell */
	          || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
	          ) return;
	        else {
	            grid[i][j] = minutes;
	            rotAdjacent(grid, i - 1, j, minutes + 1);
	            rotAdjacent(grid, i + 1, j, minutes + 1);
	            rotAdjacent(grid, i, j - 1, minutes + 1);
	            rotAdjacent(grid, i, j + 1, minutes + 1);
	        }
	    }
	    
	  //419. Battleships in a Board  SAME AS ICELAND
	    public int countBattleships(char[][] board) {
	        int numBattleships=0;
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[i].length;j++){
	                    if(board[i][j]=='X'){
	                        numBattleships++;
	                        sink(board,i,j);
	                    }
	            }
	            
	        }
	        return numBattleships;
	    }
	    public void sink(char[][] board,int row,int col){
	        int h =board.length;
	        int l=board[0].length;
	        if(row<0 || row>=h || col<0 ||col>=l || board[row][col]!='X') return;
	        board[row][col]='.';
	        sink(board,row+1,col);
	        sink(board,row-1,col);
	        sink(board,row,col+1);
	        sink(board,row,col-1);
	        
	    }

}
