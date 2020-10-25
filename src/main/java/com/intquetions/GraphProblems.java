/**
 * 
 */
package com.intquetions;


public class GraphProblems {

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
