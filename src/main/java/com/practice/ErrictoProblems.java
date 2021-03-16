package com.practice;

public class ErrictoProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//1314. Matrix Block Sum  | check concept in Notes | https://www.youtube.com/watch?v=bKjOs1JxdZg
	 public int[][] matrixBlockSum(int[][] mat, int k) {
	        int h=mat.length;
	        int w=mat[0].length;
	        
	        int [][] pref=new int[h][w];
	         for(int r=0;r<h;r++){
	            for(int c=0;c<w;c++){
	                //in every column ,prefix sum  added down ward for every column
	                pref[r][c]=mat[r][c]+(r>0?pref[r-1][c]:0);
	            }
	         }
	           for(int r=0;r<h;r++){
	            for(int c=0;c<w;c++){ 
	                pref[r][c]=pref[r][c]+(c>0?pref[r][c-1]:0);//added right ward for every row 
	            }
	         }
	        int [][] ans=new int[h][w];
	        for(int r=0;r<h;++r){
	            for(int c=0;c<w;++c){
	                int r1=Math.max(0,r-k);// get top row considering out of matrix to 0;
	                int r2=Math.min(h-1,r+k);//get bottom row considering out of matrix to w-1;

	                int c1=Math.max(0,c-k);
	                int c2=Math.min(w-1,c+k);
	                
	              ans[r][c]=  pref[r2][c2]-(c1>0?pref[r2][c1-1]:0)-(r1>0?pref[r1-1][c2]:0)
	                    +(r1>0 && c1>0 ? pref[r1-1][c1-1]:0);


	            }
	        }
	        return ans;
	    }
	 //Above problem brute force
	public int[][] matrixBlockSum2(int[][] mat, int K) {
		int m = mat.length;
		int n = mat[0].length;
		int[][] arr = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				int sum = 0;
				for (int r = Math.max(0, i - K); r <= i + K && r < m; r++) {
					for (int c = Math.max(0, j - K); c <= j + K && c < n; c++) {
						
						sum = sum + mat[r][c];
					}
				}
				arr[i][j] = sum;
			}
		}
		return arr;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
