package com.recursion;

import java.util.ArrayList;

import org.apache.spark.sql.catalyst.expressions.Substring;
//https://www.pepcoding.com/resources/online-java-foundation/introduction-to-recursion
//#123456789
public class Pepcoding {
	//EUlar Path explained :-https://www.youtube.com/watch?v=R7qja_gZrvI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=10
	//Two Types of Recursion
	//1)Faith and Expectation
	//2)Levels and Options:-https://www.youtube.com/watch?v=HVCajDe2Uus (Print Keypad Combination) and 
	//	Print Stair Paths - Solution
	//https://www.youtube.com/watch?v=QDBrZFROuA0&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=12
	//https://www.youtube.com/watch?v=K5xJXbnYMBc&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=42
	//https://www.youtube.com/watch?v=NEuYcztalew (37)

	public static void main(String[] args) {
		
		System.out.println("1) power(x,n) ans (16):- "+power(2,4));
		
		
		int [] c= {2,3,6,9,8,3,2,6,3,4};
		//System.out.print(firstOccurence(c,0,8));
	/*	int []arr=allIndices(c,3,0,0);
		for(int a:arr)
			System.out.print(a+" ");
		
		System.out.print(printSubSeq("abc",0,"",new ArrayList<String>()));
		System.out.print(getKPC("678"));
		//System.out.print(getMazePaths(1,1,3,3));
		printKPC("678","");
		printpermutation("abc","");*/
		
		display(c, c.length-1);

	}
	public static void display(int [] arr,int idx) {
		if(idx==0)return;
		System.out.println(arr[idx]);
		display(arr, idx-1);
	}
	
	private static int  power(int x, int n) {
		if(n==0)return 1;
		int val=power(x,n/2);
		val=val*val;
		if(n%2!=0)val=val*x;//if odd
		return val;
	}

	public static ArrayList<String> printSubSeq(String s,int indx,String op,ArrayList<String> out) {
		if(indx==s.length()) {
			out.add(op);
			return out;
		}
		printSubSeq(s, indx+1, op+s.charAt(indx),out);
		printSubSeq(s, indx+1, op,out);
		return out;
	}

	//24 :https://www.youtube.com/watch?v=Sa5PmCFF_zI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=25
	public static int[] allIndices(int []arr,int x,int idx,int fsf) {
		if(idx==arr.length) {
			return new int[fsf];
		}
		if(arr[idx]==x) {
			int [] a=allIndices(arr, x, idx+1, fsf+1);
			a[fsf]=idx;
			return a;
			
		}else {
			int [] a=allIndices(arr, x, idx+1, fsf);
			return a;
		}
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
	
	public static void printMazePath(int sr,int sc,int dr,int dc,String psf){
		if(sr>dr && sc>dc) {	
			return;
		}
		if(sr==dr && sc==dc) {	
			System.out.print(psf);
			return;
		}
		printMazePath(sr, sc+1, dr, dc,psf);
		printMazePath(sr+1, sc, dr, dc,psf);
	}
	
	
	public static void printMazePathsWithJumps(int sr,int sc,int dr,int dc,String psf){
		if(sr==dr && sc==dc) {
			System.out.print(psf);
			return;
		}
		
		for(int ms=1;ms<dc-sc;ms++) {
			printMazePathsWithJumps(sr,sc+ms,dr,dc,psf+"h"+ms);
		}
		for(int ms=1;ms<dr-sr;ms++) {
			printMazePathsWithJumps(sr+ms,sc,dr,dc,psf+"h"+ms);
		}
		for(int ms=1;ms<dc-sc;ms++) {
			printMazePathsWithJumps(sr,sc+ms,dr,dc,psf+"v"+ms);
		}
		for(int ms=1;ms<dc-sc && ms<dr-sr;ms++) {
			printMazePathsWithJumps(sr+ms,sc+ms,dr,dc,psf+"d"+ms);
		}
	}
	
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
		public static String[] codes = {"","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
		public static ArrayList<String> getKPC(String str){
			if(str.length()==0) {
				ArrayList<String> bres=new ArrayList<>();
				bres.add("");
				return bres;
			}
			//573
			char cd =str.charAt(0);//5
			String ros=str.substring(1);//73
			
			ArrayList<String> rres=getKPC(ros);//this will give ans for 73
			ArrayList<String> mres=new ArrayList<>(); //Now add 5 chars with each of these 73 ans to form complete
			for(char c:codes[cd-'0'].toCharArray()) {
				for(String s :rres)
					mres.add(c+s);
			}
			return mres;
		}
		//V-29
		public static ArrayList<String> getStairPaths(int n) {
	        if(n==0){
	            ArrayList<String> list=new ArrayList<String>();
	            list.add("");
	            return list;
	        }
	        if(n<0){
	            ArrayList<String> list=new ArrayList<>();
	            return list;
	        }
	        ArrayList<String> m1=getStairPaths(n-1);
	        ArrayList<String> m2=getStairPaths(n-2);
	        ArrayList<String> m3=getStairPaths(n-3);
	        ArrayList<String> res=new ArrayList<String>();
	        for(String s:m1)
	            res.add(1+s);
	        for(String s:m2)
	            res.add(2+s);
	        for(String s:m3)
	            res.add(3+s);
	        

	        return res;
	    }
		//V-28
		 public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		        if(sr==dr && sc==dc){
		            ArrayList<String> list=new ArrayList<>();
		            list.add("");
		            return list;
		        }
		        if(sr>dr || sc>dc)
		            return new ArrayList<String>();
		        ArrayList<String> vRes=getMazePaths(sr+1,sc,dr,dc);
		        ArrayList<String> hRes=getMazePaths(sr,sc+1,dr,dc);
		        ArrayList<String> res=new ArrayList<>();
		        for(String s:hRes)
		            res.add("h"+s);
		        for(String s:vRes)
		            res.add("v"+s);
		      
		        return res;
		    }
		 
		   //V-33
		 public static ArrayList<String> getMazePathsWithJumps(int sr,int sc,int dr,int dc){
				if(sr > dr || sc > dc){
		            return new ArrayList<>();
		        }

		        if(sr == dr && sc == dc){
		            ArrayList<String> bres = new ArrayList<>();
		            bres.add("");
		            return bres;
		        }

		        ArrayList<String> paths = new ArrayList<>();
		        for(int move = 1; move <= dc - sc; move++){
		            ArrayList<String> hpaths = getMazePathsWithJumps(sr, sc + move, dr, dc);
		            for(String hpath: hpaths){
		                paths.add("h" + move + hpath);
		            }
		        }
		        
		        for(int move = 1; move <= dr - sr; move++){
		            ArrayList<String> vpaths = getMazePathsWithJumps(sr + move, sc, dr, dc);
		            for(String vpath: vpaths){
		                paths.add("v" + move + vpath);
		            }
		        }

		        for(int move = 1; move <= dc - sc && move <= dr - sr; move++){
		            ArrayList<String> dpaths = getMazePathsWithJumps(sr + move, sc + move, dr, dc);
		            for(String dpath: dpaths){
		                paths.add("d" + move + dpath);
		            }
		        }

		        return paths;
			}
			//v-35
		 public static void printSS(String ip, String op) {
		        if(ip.length()==0){
		            System.out.println(op);
		            return;
		        }
		        printSS(ip.substring(1),op+ip.charAt(0));
		        printSS(ip.substring(1),op);

		    }
		 //V-36
		 public static void printKPC(String que,String ans){
				if(que.length()==0) {
					System.out.println(ans);
					return;
				}
				
				char ch=que.charAt(0);
				String roq=que.substring(1);
				String codeForCh=codes[ch-'0'];
				
				for(int i=0;i<codeForCh.length();i++) {
					char cho=codeForCh.charAt(i);
					printKPC(roq,ans+cho);
				}
			}
		 //V-37 
		  public static void printStairPaths(int n, String path) {
		        if(n==0){
		            System.out.println(path);
		            return;
		        }
		        if(n<0)
		            return;
		        printStairPaths(n-1,path+1);
		        printStairPaths(n-2,path+2);
		        printStairPaths(n-3,path+3);

		    }
		  //V-38
		    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		        if(sr==dr && sc==dc){
		            System.out.println(psf);
		            return;
		        }
		        if(sr>dr || sc>dc)return;
		        printMazePaths(sr,sc+1,dr,dc,psf+"h");
		        printMazePaths(sr+1,sc,dr,dc,psf+"v");

		    }
		    
		    //V-39
		    public static void printMazePaths2(int sr, int sc, int dr, int dc, String psf) {
		        if(sr>dr || sc>dc)return;
		        
		        if(sr==dr && sc==dc){
		            System.out.println(psf);
		            return;
		        }
		        
		    for(int i=1;i<dc;i++)
		    	printMazePaths2(sr,sc+i,dr,dc,psf+"h"+i);
		            
		    for(int i=1;i<dr;i++)
		    	printMazePaths2(sr+i,sc,dr,dc,psf+"v"+i);
		    for(int i=1;i<dc && i<dr;i++)
		    	printMazePaths2(sr+i,sc+i,dr,dc,psf+"d"+i);
		    }
		    
		    
		    //V40
		    public static void printPermutations(String str, String asf) {
		        if(str.length()==0){
		            System.out.println(asf);
		            return;
		        }
		        
		        for(int i=0;i<str.length();i++){
		            char c=str.charAt(i);
		            String left=str.substring(0,i);
		            String right=str.substring(i+1);
		            printPermutations(left+right,asf+c);
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
		            System.out.println(asf);
		            return;
		        }
		        maze[sr][sc]=1;
		        floodfill(maze,sr-1,sc,asf+'t');
		        floodfill(maze,sr,sc-1,asf+"l");
		        floodfill(maze,sr+1,sc,asf+"d");
		        floodfill(maze,sr,sc+1,asf+"r");
		        maze[sr][sc]=0;
		    }
		    
		    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
		        if(idx==arr.length){
		            if(sos==tar){
		                System.out.println(set+".");
		            }
		            return;
		        }
		        printTargetSumSubsets(arr,idx+1,set+arr[idx]+", ",sos+arr[idx],tar);
		        printTargetSumSubsets(arr,idx+1,set,sos,tar);

		    }
		    
		    public static void printNQueens(int[][] chess, String qsf, int r) {
		        if(r==chess.length){
		            System.out.println(qsf+".");
		            return;
		        }
		        
		        for(int c=0;c<chess[0].length;c++){
		            if(isSafe(chess,r,c)){
		                chess[r][c]=1;
		                printNQueens(chess,qsf+r+"-"+c+", ",r+1);
		                chess[r][c]=0;
		            }
		        }
		    }
		    
		    public static boolean isSafe(int grid[][],int r,int c){
		        for(int i=r-1,j=c;i>=0;i--)
		            {
		                if(grid[i][j]==1)return false;
		            }
		            
		          for(int i=r-1,j=c-1;i>=0 && j>=0;i--,j--)
		        {
		                if(grid[i][j]==1)return false;
		        }
		        
		           for(int i=r-1,j=c+1;i>=0 && j<grid.length;i--,j++)
		        {
		                if(grid[i][j]==1)return false;
		        }
		        return true;
		    }
		    
		    public static void printKnightsTour(int[][] chess, int r, int c, int move) {
		        int h=chess.length;
		        int w=chess[0].length;
		        if(r<0 || c<0 || r>=h || c>=w || chess[r][c]>0)return;
		        if(move==chess.length*chess.length){
		            chess[r][c]=move;
		            //displayBoard(chess);
		            chess[r][c]=0;
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
			
	
}
