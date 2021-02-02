package com.recursion;

import java.util.ArrayList;

import org.apache.spark.sql.catalyst.expressions.Substring;

public class Pepcoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] c= {2,3,6,9,8,3,2,6,3,4};
		//System.out.print(firstOccurence(c,0,8));
		/*int []arr=allIndices(c,3,0,0);
		for(int a:arr)
			System.out.print(a+" ");*/
		
		//System.out.print(printSubSeq("abc",0,"",new ArrayList<String>()));
		//System.out.print(getKPC("678"));
		//System.out.print(getMazePaths(1,1,3,3));
		//printKPC("678","");
		//printpermutation("abc","");

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
	
	public static String[] codes = {"","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	public static ArrayList<String> getKPC(String str){
		if(str.length()==0) {
			ArrayList<String> bres=new ArrayList<>();
			bres.add("");
			return bres;
		}
		char cd =str.charAt(0);
		String ros=str.substring(1);
		
		ArrayList<String> rres=getKPC(ros);
		ArrayList<String> mres=new ArrayList<>();
		for(char c:codes[cd-'0'].toCharArray()) {
			for(String s :rres)
				mres.add(c+s);
		}
		return mres;
	}
	
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
		if(sc<dc)
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
	
	public static ArrayList<String> getMazePathsWithJumps(int sr,int sc,int dr,int dc){
		if(sr==dr && sc==dc) {
			ArrayList<String> bres=new ArrayList<>();
			bres.add("");
			return bres;
		}
		ArrayList<String> paths=new ArrayList<>();
		//horizontal
		for(int ms=1;ms<dc-sc;ms++) {
			ArrayList<String> hpaths=getMazePathsWithJumps(sr,sc+ms,dr,dc);
			for(String path:hpaths)
				paths.add("h"+ms+hpaths);

		}
		//vertical
		for(int ms=1;ms<dr-sr;ms++) {
			ArrayList<String> vpaths=getMazePathsWithJumps(sr+ms,sc,dr,dc);
			for(String path:vpaths)
				paths.add("v"+ms+vpaths);

		}
		
		for(int ms=1;ms<dc-sc && ms<dr-sr ;ms++) {
			ArrayList<String> dpaths=getMazePathsWithJumps(sr+ms,sc+ms,dr,dc);
			for(String path:dpaths)
				paths.add("d"+ms+dpaths);
		}
		return paths;
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
			if(ch=='0')
				return;
			else {
				int chv=ch-'0';
				char code=(char)('a'+chv-1);
				printEncodings(ros,op+code);
			}
			String ch12=ip.substring(0,2);
			String roq=ip.substring(2);
			
			int ch12v=Integer.parseInt(ch12);
			if(ch12v<26) {
				char code = (char)('a'+ch12v-1);
				printEncodings(roq,op+code);
			}
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
	
	
}
