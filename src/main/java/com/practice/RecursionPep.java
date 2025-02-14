package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

import com.backtracking.Nqueens;


public class RecursionPep {
	
	public static void main(String[] args) {
		System.out.println("1) print Decreasing ");
		printDecreasing(5);
		System.out.println();
		System.out.println("2) printDecreasing ");
		printIncreasing(5);
		System.out.println();
		System.out.println("3) printIncreasingDecreasing ");
		printIncreasingDecreasing(5);
		
		System.out.println();
		System.out.println("4) factorial "+factorial(5));
		
		System.out.println();
		System.out.println("5) power "+power(2,3));
		
		System.out.println();
		System.out.println("5) pzz ");
		//pzz(3);
		/////////////////
		
		System.out.println();
		System.out.println("6) pzz ");
		toh(3,1,2,3);
		
		int a[]= {1,2,3,4,6,3};
		System.out.println();
		System.out.println("7) Max of array (6)"+maxOfArray(a,0));
		
		System.out.println("8) Max of array (2) "+firstIndex(a,0,3));
		System.out.println("9) Max of array (5) "+lastIndex(a,0,3));
		System.out.println("10) all of array [2,5] "+Arrays.toString(allIndices(a,3,0,0)));
		System.out.println("11) print all subsequences  [, b, a, ab]"+printSubSeq("ab",0,"",new ArrayList<>()));
		System.out.println("12) get key pad combination [tv, uv, tw, uw, tx, ux] "+getKPC("78"));
		System.out.println("13) get stair path [111, 12, 21, 3]] "+getStairPaths(3));
		System.out.println("14) get maze path  [vvhh, vhvh, vhhv, hvvh, hvhv, hhvv]"+getMazePaths(0,0,2,2));
		String mazePath="[h1h1v1v1, h1h1v2, h1v1h1v1, h1v1v1h1, h1v1d1, h1v2h1, h1d1v1, h2v1v1, h2v2, v1h1h1v1, v1h1v1h1, v1h1d1, v1h2v1, v1v1h1h1, v1v1h2, v1d1h1, v2h1h1, v2h2, d1h1v1, d1v1h1, d1d1, d2]";
		System.out.println("15) get maze path with jumps  HVD "+getMazePathsWithJumps(0,0,2,2).toString().equals(mazePath));
		System.out.println("16) print SS [,b,a,ab,]");
		printSS("ab","");
		System.out.println("17) print key pad combination");
		printKPC("78","");
		System.out.println("18) print stair path");
		printStairPaths(3,"");
		
		System.out.println("19) print maze path");
		printMazePaths(0,0,2,2,"");

		System.out.println("20) print maze path with Jumps");
		printMazePathsWithJumps(0,0,2,2,"");
		System.out.println();

		System.out.println("22) print Permutations");
		printPermutations("ab","");
		System.out.println();

		System.out.println("23) print Encoding bc,w");
		printEncodings("23","");
		System.out.println();
		
		
		int maze[][]= {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println("24) FloodFill ddrr, rrdd,");
		floodfill(maze,0,0,"");
		System.out.println();
		
		int b[]= {10,20,30,40,50};//print all subsets that sum to 60 
		System.out.println("25) Target Sum ");
		printTargetSumSubsets(b,0,"",0,60);
		System.out.println();
		
		int chess[][]=new int[4][4];
		System.out.println("26) NQueens ");
		printNQueens(chess,"",0);
		
		System.out.println("27) Knight ");
		//move knight as such it will visit all places once 
		printKnightsTour(new int[5][5],0,0,1);
	}
	
	public static void toh(int n, int s, int d, int h){
        if(n==0)return;
        toh(n-1,s,h,d);
        System.out.println("Move "+n+" from "+s+" to "+d);
        toh(n-1,h,d,s);
    }

	//1) 
	public static void printDecreasing(int n){
      if(n==0)return;
      System.out.print(n+" ");
      printDecreasing(n-1);
    }
	//2)  
	public static void printIncreasing(int n){
	  if(n==0)return;
	  printIncreasing(n-1);//123
	  System.out.print(n+" ");
	}
	
	public static void printIncreasingDecreasing(int n){
		  if(n==0)return;
		  System.out.print(n+" ");
		  printIncreasingDecreasing(n-1);
		  System.out.print(n+" ");
	}
	
	public static int factorial(int n) {
		if(n==1)return 1;
		return n*factorial(n-1);
	}
	
	public static int power1(int a,int n) {
		if(n==1)return a;
		return a*power1(a,n-1);
	}
	private static int  power(int x, int n) {
		if(n==1)return x;
		int y=power(x,n/2);
		y=y*y;
		if(n%2==1)
			y=y*x;
		return y;
	}
	
	public static void pzz(int n){
	      if(n==0)return;
	      System.out.print("Pre "+n+" ");
	      pzz(n-1);
	      System.out.print("In "+n+" ");
	      pzz(n-1);
	      System.out.print("post "+n+" ");
	    }
	 public static void displayArrReverse(int[] arr, int idx) {
	        if(idx==arr.length)return;
	        displayArrReverse(arr,idx+1); 
	                System.out.println(arr[idx]);

	    }

	public static void display(int [] arr,int idx) {
		if(idx==0)return;
		System.out.println(arr[idx]);
		display(arr, idx-1);
	}
	   public static int maxOfArray(int[] arr, int idx){
	      if(arr.length-1==idx)return arr[idx];
	      int val=maxOfArray(arr,idx+1); 
	      if(val<arr[idx])return arr[idx];
	      return val;
	    }
	
	
	
	 public static int firstIndex(int[] arr, int idx, int x){
	        if(idx==arr.length)return -1;
	        int pos =firstIndex(arr, idx+1, x);
	        if(arr[idx]==x)return idx;
	        return pos;  
	    }
	    public static int lastIndex(int[] arr, int idx, int x){
	       if(idx==arr.length )return -1;
	       int pos=lastIndex(arr, idx+1, x);
	       if(pos==-1 && arr[idx]==x)return idx;
	       else return pos;
	    }
	  //24 :https://www.youtube.com/watch?v=Sa5PmCFF_zI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=25
		public static int[] allIndices(int []arr,int x,int idx,int fsf) {
			if(arr.length==idx) {
				int res[]=new int[fsf];
				return res;
			}
			int res[];
			if(arr[idx]==x) {
				res=allIndices(arr,x,idx+1,fsf+1);
				res[fsf]=idx;
			}
			else res=allIndices(arr,x,idx+1,fsf); 
			return res;
		}

	public static ArrayList<String> printSubSeq(String s,int indx,String op,ArrayList<String> out) {
		if(indx==s.length()) {
			out.add(op);
			return out;
		}
		printSubSeq(s,indx+1,op,out);
		printSubSeq(s,indx+1,op+s.charAt(indx),out);
		return out;
	}

	
	

	
	
	
	public static ArrayList<String> getStairsPath(int n){
		if(n==0) {
			ArrayList<String> bres=new ArrayList<>();
			bres.add("");
			return bres;
		}else if(n<0) {
			ArrayList<String> bres=new ArrayList<>();
			return bres;
		}
		
		ArrayList<String> path1=getStairsPath(n-1);
		ArrayList<String> path2=getStairsPath(n-2);
		ArrayList<String> path3=getStairsPath(n-3);
		
		ArrayList<String> paths =new ArrayList<>();
		for(String path:path1)
			paths.add(1+path);
		for(String path:path2)
			paths.add(2+path);
		for(String path:path3)
			paths.add(3+path);
		return paths;
	}
	
	public static void printStairsPath(int n,String path){
		if(n<0)
			return;
		if(n==0)
		{
			System.out.println(path);
			return;
		}
		printStairsPath(n-1,path+"1");
		printStairsPath(n-2,path+"2");
		printStairsPath(n-3,path+"3");

	}
	
	public static ArrayList<String> getMazePath(int sr,int sc,int dr,int dc){
		if(sr==dr && sc==dc) {
			ArrayList<String> bres=new ArrayList<>();
			bres.add("");
			return bres;
		}
		ArrayList<String> hpaths=new ArrayList<>();
		ArrayList<String> vpaths=new ArrayList<>();
		if(sc<dc)//to check out of bound
		hpaths=getMazePath(sr, sc+1, dr, dc);
		if(sr<dr)
		 vpaths=getMazePath(sr+1, sc, dr, dc);
		ArrayList<String> paths=new ArrayList<>();
		for(String p:hpaths)
			paths.add("h"+hpaths);
		
		for(String p:vpaths)
			paths.add("v"+vpaths);
		return paths;
	}
	
//	public static void printMazePath(int sr,int sc,int dr,int dc,String psf){
//		if(sr>dr && sc>dc) {	
//			return;
//		}
//		if(sr==dr && sc==dc) {	
//			System.out.print(psf);
//			return;
//		}
//		printMazePath(sr, sc+1, dr, dc,psf);
//		printMazePath(sr+1, sc, dr, dc,psf);
//	}
	
	
//	public static void printMazePathsWithJumps(int sr,int sc,int dr,int dc,String psf){
//		if(sr==dr && sc==dc) {
//			System.out.print(psf);
//			return;
//		}
//		
//		for(int ms=1;ms<dc-sc;ms++) {
//			printMazePathsWithJumps(sr,sc+ms,dr,dc,psf+"h"+ms);
//		}
//		for(int ms=1;ms<dr-sr;ms++) {
//			printMazePathsWithJumps(sr+ms,sc,dr,dc,psf+"h"+ms);
//		}
//		for(int ms=1;ms<dc-sc;ms++) {
//			printMazePathsWithJumps(sr,sc+ms,dr,dc,psf+"v"+ms);
//		}
//		for(int ms=1;ms<dc-sc && ms<dr-sr;ms++) {
//			printMazePathsWithJumps(sr+ms,sc+ms,dr,dc,psf+"d"+ms);
//		}
//	}
	
	public static void printpermutation(String ip,String op) {
		if(ip.length()==0)
		{
			System.out.println(op);
			return;
		}
		for(int i=0;i<ip.length();i++) {
			char c=ip.charAt(i);
			String opLeftPart=ip.substring(0,i);
			String opRightPart=ip.substring(i+1);
			String rip=opLeftPart+opRightPart;
			printpermutation(rip, op+c);

		}
	}
	
	
	//https://www.youtube.com/watch?v=R1URUB6_y2k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=47
	public static void floodfill(int[][]maze,int row,int col,String psf,boolean[][] visited) {
		if(row<0 || col <0 || row==maze.length || col==maze[0].length || maze[row][col]=='1' 
				||visited[row][col]==true)
			return;
		
		if(row==maze.length-1 && col==maze[0].length-1)
		{
			System.out.println(psf);
			return ;
		}
		visited[row][col]=true;
		floodfill(maze,row-1,col,psf+"t",visited);
		floodfill(maze,row,col-1,psf+"l",visited);
		floodfill(maze,row+1,col,psf+"d",visited);
		floodfill(maze,row,col+1,psf+"r",visited);
		visited[row][col]=false;

	}
	
	public static void printTargetSum(int arr[] ,int idx,int target,String subset,int sofar) {
		if(idx==arr.length) {
			if(sofar==target)
				System.out.print(subset);
			return;
		}
		printTargetSum(arr,idx+1,target-arr[idx],subset+arr[idx],sofar+arr[idx]);
		printTargetSum(arr,idx+1,target,subset,sofar);

	}
	
	/************************/
	//V-25 get subsequence 
	  public static ArrayList<String> gss(String ip) {
	        if(ip.isEmpty()){
	            ArrayList<String> list=new ArrayList<String>();
	            list.add("");//array list size is one but the subsequence is empty in it so empty string have one subsequence that is ""
	            return list;
	        }
	        ArrayList<String> arr=gss(ip.substring(1));
	        ArrayList<String> res=new ArrayList<>();
	        for(String s:arr)
	            res.add(s);
	        for(String s:arr)
	            res.add(ip.charAt(0)+s);
	             
	        return res;
	    }
	  //V-26
	  	public static String codes[]= {"","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
		public static ArrayList<String> getKPC(String str){
			if(str.isEmpty()) {
				ArrayList<String> res=new ArrayList<>();
				res.add("");
				return res;
			}
			char code[]=codes[str.charAt(0)-'0'].toCharArray();
			ArrayList<String> mres=getKPC(str.substring(1));
			ArrayList<String> res=new ArrayList<>();
			for(String s:mres)
				for(char ch:code)
					res.add(ch+s);
			return res;
		}
		//V-29
		public static ArrayList<String> getStairPaths(int n) {
			if(n==0) {
				ArrayList<String> res=new ArrayList<>();
				res.add("");
				return res;
			}
			if(n<0)return new ArrayList<>();
			ArrayList<String> one =getStairPaths(n-1);
			ArrayList<String> two =getStairPaths(n-2);
			ArrayList<String> three =getStairPaths(n-3);
			ArrayList<String> res =new ArrayList<>();
			
			for(String o:one)
					res.add("1"+o);
			for(String t:two)
				res.add("2"+t);
			for(String th:three)
				res.add("3"+th);
			return res;

	    }
		//V-28
		 public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		       if(sr==dr && sc==dc) {
		    	   ArrayList<String> res=new ArrayList<>();
		    	   res.add("");
		    	   return res;
		       }
		       if(sr>dr || sc>dc)return new ArrayList<>();
		       
		       ArrayList<String> vres=getMazePaths(sr+1, sc, dr, dc);
		       ArrayList<String> hres=getMazePaths(sr, sc+1, dr, dc);
		       
		       ArrayList<String> res=new ArrayList<>();
		       for(String v:vres)
		    	   	res.add("v"+v);
		       for(String h:hres)
		    	   	res.add("h"+h);
		       return res;
		    }
		 
		   //V-33
		 public static ArrayList<String> getMazePathsWithJumps(int sr,int sc,int dr,int dc){
		     if(sr==dr && sc==dc) {
		    	   ArrayList<String> res=new ArrayList<>();
		    	   res.add("");
		    	   return res;
		       }
		       
		       ArrayList<String> path=new ArrayList<>();
		       
		       for(int move=1;move<=dc-sc;move++) {
			       ArrayList<String> hpaths=getMazePathsWithJumps(sr, sc+move, dr, dc);
			       	for(String hpath:hpaths)
			       		path.add("h"+move+hpath);
		       }
		       for(int move=1;move<=dr-sr;move++) {
			       ArrayList<String> vpaths=getMazePathsWithJumps(sr+move, sc, dr, dc);
			       	for(String vpath:vpaths)
			       		path.add("v"+move+vpath);
		       }
		       for(int move=1;move<=dc-sc && move<=dr-sr;move++) {
			       ArrayList<String> dpaths=getMazePathsWithJumps(sr+move, sc+move, dr, dc);
			       	for(String dpath:dpaths)
			       		path.add("d"+move+dpath);
		       }
		    	   	
		      
		       return path;
			 
			}
			//v-35
		 public static void printSS(String ip, String op) {
		       if(ip.isEmpty()) {
		    	   System.out.print(op+",");
		    	   return;
		       }
		       printSS(ip.substring(1),op);
		       printSS(ip.substring(1),op+ip.charAt(0));

		    }
		 //V-36
		 public static void printKPC(String que,String ans){
			 if(que.isEmpty()) {
				 System.out.print(ans+", ");
				 return;
			 }
			 char code[]=codes[que.charAt(0)-'0'].toCharArray();
			 for(char ch:code) {
				 printKPC(que.substring(1), ans+ch);
			 }
		}
		 //V-37 
		  public static void printStairPaths(int n, String path) {
		      if(n==0) {
		    	  System.out.print(path+", ");
		    	  return;
		      }
		      if(n<0)return;
			  printStairPaths(n-1,path+"1");
			  printStairPaths(n-2,path+"2");
			  printStairPaths(n-3,path+"3");

		    }
		  //V-38
		    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		        if(sr==dr && sc==dc) {
		        	System.out.print(psf+", ");
		        	return;
		        }
		    	if(sr>dr || sc>dc)return;
		    	printMazePaths(sr+1,sc,dr,dc,psf+"v");
		    	printMazePaths(sr,sc+1,dr,dc,psf+"h");

		    }
		    
		    //V-39
		    public static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String psf) {
		    	if(sr==dr && sc ==dc) {
		    		System.out.print(psf+" ");
		    		return;
		    	}
		    	if(sr>dr || sc>dc)return;
		    	for(int mv=1;mv<=dc-sc;mv++) {
		    		printMazePathsWithJumps(sr,sc+mv,dr,dc,psf+"h"+mv);
		    	}
		    	for(int mv=1;mv<=dr-sr;mv++) {
		    		printMazePathsWithJumps(sr+mv,sc,dr,dc,psf+"v"+mv);
		    	}
		    	for(int mv=1;mv<=dc-sc && mv<=dr-sr;mv++) {
		    		printMazePathsWithJumps(sr+mv,sc+mv,dr,dc,psf+"d"+mv);
		    	}
		    }
		    
		    
		    //V40
		    public static void printPermutations(String str, String asf) {
		    	if(str.isEmpty()) {
		    		System.out.print(asf+" ");
		    		return;
		    	}
		    	for(int i=0;i<str.length();i++) {
		    		char ch=str.charAt(i);
		    		String s=str.substring(0,i)+str.substring(i+1);
		    		printPermutations(s, asf+ch);
		    	}
		    }
		    //45
		    public static void printEncodings(String ip,String op){
				if(ip.length()==0)
				{
					System.out.print(op);
					return;
				}else if(ip.length()==1) {
					char ch=ip.charAt(0);
					if(ch=='0') 
						return;
					else {
						int chv=ch-'0'; 
						char code=(char)('a'+chv-1);
						op+=code;
						System.out.print(op);
					}
			
				}else {
					char ch=ip.charAt(0);
					String ros=ip.substring(1);
					if(ch=='0') //if single digit is zero then return
						return;
					else {
						int chv=ch-'0'; //call with single digit
						char code=(char)('a'+chv-1);
						printEncodings(ros,op+code);
					}
					String ch12=ip.substring(0,2);
					String roq=ip.substring(2);
					
					int ch12v=Integer.parseInt(ch12);
					if(ch12v<26) {
						char code = (char)('a'+ch12v-1);
						printEncodings(roq,op+code); //call with two digit
					}
				}	
			}
		    

		    
		    public static void printEncodings2(String ques, String ans) {
		        if (ques.length() == 0) {
		            System.out.println(ans);
		            return;
		        } else if (ques.length() == 1) {
		            if (ques.charAt(0) == '0') {
		                return;
		            } else {
		                String ch0 = ques.substring(0, 1);
		                String roq0 = ques.substring(1);
		                String code0 = (char)('a' + (Integer.parseInt(ch0) - 1)) + "";
		                printEncodings2(roq0, ans + code0);
		            }
		        } else {
		            if (ques.charAt(0) == '0') {
		                return;
		            } else {
		                String ch0 = ques.substring(0, 1);
		                String roq0 = ques.substring(1);
		                String code0 = (char)('a' + (Integer.parseInt(ch0) - 1)) + "";
		                printEncodings2(roq0, ans + code0);

		                String ch01 = ques.substring(0, 2);
		                String roq01 = ques.substring(2);
		                String code01 = (char)('a' + (Integer.parseInt(ch01) - 1)) + "";

		                if (Integer.parseInt(ch01) <= 26) {
		                	printEncodings2(roq01, ans + code01);
		                }
		            }
		        }
		    }
		    public static void floodfill(int[][] maze, int sr, int sc, String asf) {
		        int h=maze.length;
		        int w=maze[0].length;
		        if(sr<0 || sc<0 || sr>=h || sc>=w || maze[sr][sc]==1)return;
		        if(sr==h-1 && sc==w-1) {
		        	System.out.print(asf+", ");
		        	return;
		        }
		        maze[sr][sc]=1;
		        floodfill(maze,sr-1,sc,asf+"t");
		        floodfill(maze,sr,sc-1,asf+"l");
		        floodfill(maze,sr+1,sc,asf+"d");
		        floodfill(maze,sr,sc+1,asf+"r");
		        maze[sr][sc]=0;
		    }
		    
		    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
		       if(idx==arr.length) {
		    	   if(sos==tar) {
		    		   System.out.println(set+".");
		    	   }
		    	   return;
		       }
		       printTargetSumSubsets(arr,idx+1,set+arr[idx]+", ",sos+arr[idx],tar);
		       printTargetSumSubsets(arr,idx+1,set,sos,tar);
		    }
		    
		    public static void printNQueens(int[][] chess, String qsf, int r) {
		       if(r==chess.length) {
		    	   System.out.println(qsf+".");
		    	   return;
		       }
		    	for(int c=0;c<chess[0].length;c++) {
		    		if( isSafe(chess, r, c)) {
		    			chess[r][c]=1;
		    			printNQueens(chess, qsf+"q"+r+"-"+c+" ", r+1);
		    			chess[r][c]=0;
		    		}
		    	}
		    }
		    
		    public static boolean isSafe(int grid[][],int r,int c){

		       for(int i=r-1,j=c;i>=0;i--) {
		    	   if(grid[i][j]==1)return false;
		       }
		       for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--) {
		    	   if(grid[i][j]==1)return false;
		       }
		       for(int i=r-1,j=c+1;i>=0 && j<grid.length;i--,j++) {
		    	   if(grid[i][j]==1)return false;
		       }
		       return true;
		    }
		    
		    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
		      
		    	if(r<0 || c<0 || r>=chess.length || c>=chess[0].length || chess[r][c]>0)return;
		    	if(move==chess.length*chess.length) {
		    		chess[r][c]=move;
		    		displayBoard(chess);
		    		chess[r][c]=0;
		    		return;
		    	}
		    	
		    	chess[r][c]=move;
		    	printKnightsTour(chess,r-2,c+1,move+1);
		    	printKnightsTour(chess,r-1,c+2,move+1);
		    	printKnightsTour(chess,r+1,c+2,move+1);
		    	printKnightsTour(chess,r+2,c+1,move+1);
		    	printKnightsTour(chess,r+2,c-1,move+1);
		    	printKnightsTour(chess,r+1,c-2,move+1);
		    	printKnightsTour(chess,r-1,c-2,move+1);
		    	printKnightsTour(chess,r-2,c-1,move+1);
		    	chess[r][c]=0;

		    }

			private static void displayBoard(int[][] chess) {
				for(int i=0;i<chess.length;i++) {
					for(int j=0;j<chess[0].length;j++) {
						System.out.print(chess[i][j]+" ");
					}
					System.out.println();
				}
				System.out.println();
			}
			
	

}
