package com.dp;
//https://www.youtube.com/watch?v=oPrpoVdRLtg  BY ERRICTO
public class LargestSubMatrix {
//https://www.techiedelight.com/find-size-largest-square-sub-matrix-1s-present-given-binary-matrix/
	public static void main(String[] args) {//221. Maximal Square ||https://leetcode.com/problems/maximal-square/
		// TODO Auto-generated method stub
		// input boolean matrix
        int mat[][] =
        {
            { 0, 0, 1, 0, 1, 1 },
            { 0, 1, 1, 1, 0, 0 },
            { 0, 0, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1 }
        };
 
        System.out.print("The size of largest square submatrix of 1's is " +
                findLargestSquare(mat));

	}
	
	  //221. Maximal Square
    public int maximalSquare(char[][] matrix) {
        int h =matrix.length;
        int w =matrix[0].length;
        int t[][]=new int[h][w];
        int max=0;
        
        for(int r=0;r<h;r++){
            for(int c=0;c<w;c++){
                if(matrix[r][c]=='1'){
                     t[r][c]=1;//or matrix[r][c] by default what ever value in matrix in this case always 1
                
                if(r>0 && c>0){ //can select Min square only if row and col > 0 
                    t[r][c]=Math.min(Math.min(t[r-1][c],t[r][c-1]), t[r-1][c-1])+1;//minimum of last square + me 
                }
                    max=Math.max(max,t[r][c]);
                }
               
            }
        }
        return max*max;
    }
	
	   public static int minimum (int x, int y, int z) {
	        return Integer.min(Integer.min(x, y), z);
	    }
	 
	    // Function to find the size of the largest square submatrix of 1's
	    // present in a given binary matrix
	    public static int findLargestSquare(int[][] M)
	    {
	        // `T[i][j]` stores the size of maximum square
	        // submatrix ending at `M[i][j]`
	        int[][] T = new int[M.length][M[0].length];
	 
	        // `max` stores the size of the largest square submatrix of 1's
	        int max = 0;
	 
	        // fill in a bottom-up manner
	        for (int i = 0; i < M.length; i++)
	        {
	            for (int j = 0; j < M[0].length; j++)
	            {
	                T[i][j] = M[i][j];
	 
	                // if we are not at the first row or first column and the
	                // current cell has value 1
	                if (i > 0 && j > 0 && M[i][j] == 1)
	                {
	                    // the largest square submatrix ending at `M[i][j]` will be
	                    // 1 plus minimum of largest square submatrix
	                    // ending at `M[i][j-1]`, `M[i-1][j]` and `M[i-1][j-1]`
	 
	                    T[i][j] = minimum(T[i][j - 1], T[i - 1][j],
	                                    T[i - 1][j - 1]) + 1;
	                }
	 
	                // update maximum size found so far
	                if (max < T[i][j]) {
	                    max = T[i][j];
	                }
	            }
	        }
	 
	        // return size of the largest square matrix
	        return max;
	    }
	    
	  

}
