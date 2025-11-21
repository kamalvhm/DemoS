package com.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursionPepPractice {

	public static void main(String[] args) {
		System.out.println("1) print Decreasing ");
		printDecreasing(5);
		System.out.println();
		System.out.println("2) print Increasing ");
		printIncreasing(5);
		System.out.println();
		System.out.println("3) printIncreasingDecreasing ");
		printIncreasingDecreasing(5);

		System.out.println();
		System.out.println("4) factorial (120) " + factorial(5));

		System.out.println();
		System.out.println("5) power (8) " + power(2, 3));

		System.out.println();
		System.out.println("5) pzz ");
		pzz(3);
		/////////////////

		System.out.println();
		System.out.println("6) Toh ");
		toh(3, 1, 2, 3);

		int a[] = { 1, 2, 3, 4, 6, 3 };
		System.out.println();
		System.out.println("7) Max of array (6)" + maxOfArray(a, 0));

		System.out.println("8) First Pos of array (2) " + firstIndex(a, 0, 3));
		System.out.println("9) Max of array (5) " + lastIndex(a, 0, 3));
		System.out.println("10) all of array [2,5] :-" + Arrays.toString(allIndices(a, 3, 0, 0)));
		System.out.println("11) print all subsequences  [, b, a, ab]" + printSubSeq("ab", 0, "", new ArrayList<>()));
		System.out.println("12) get key pad combination [tv, uv, tw, uw, tx, ux] " + getKPC("78"));
		System.out.println("13) get stair path [111, 12, 21, 3]] " + getStairPaths(3));
		System.out.println("14) get maze path  [vvhh, vhvh, vhhv, hvvh, hvhv, hhvv]" + getMazePaths(0, 0, 2, 2));
		String mazePath = "[h1h1v1v1, h1h1v2, h1v1h1v1, h1v1v1h1, h1v1d1, h1v2h1, h1d1v1, h2v1v1, h2v2, v1h1h1v1, v1h1v1h1, v1h1d1, v1h2v1, v1v1h1h1, v1v1h2, v1d1h1, v2h1h1, v2h2, d1h1v1, d1v1h1, d1d1, d2]";
		System.out.println(
				"15) get maze path with jumps  HVD " + getMazePathsWithJumps(0, 0, 2, 2).toString().equals(mazePath));
		System.out.println("16) print SS [,b,a,ab,]");
		printSS("ab", "");
		System.out.println("17) print key pad combination");
		printKPC("78", ""); 
		System.out.println();
		
		System.out.println("18) print stair path");
		printStairPaths(3, ""); 
		System.out.println();

		System.out.println("19) print maze path");
		printMazePaths(0, 0, 2, 2, "");
		System.out.println();
		
		System.out.println("20) print maze path with Jumps");
		printMazePathsWithJumps(0, 0, 2, 2, "");
		System.out.println();

		System.out.println("22) print Permutations");
		printPermutations("ab", "");
		System.out.println();

		System.out.println("23) print Encoding [bc,w]");
		printEncodings("23", "");
		System.out.println();

		int maze[][] = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println("24) FloodFill [ddrr, rrdd]");
		floodfill(maze, 0, 0, "");
		System.out.println();

		int b[] = { 10, 20, 30, 40, 50 };// print all subsets that sum to 60
		System.out.println("25) Target Sum ");
		printTargetSumSubsets(b, 0, "", 0, 60);
		System.out.println();

		int chess[][] = new int[4][4];
		System.out.println("26) NQueens ");
		 printNQueens(chess,"",0);

		System.out.println("27) Knight ");
		// move knight as such it will visit all places once
		 printKnightsTour(new int[5][5],0,0,1);
	}

	public static void toh(int n, int s, int d, int h) {
		
	}

	// 1)
	public static void printDecreasing(int n) {
		
	}

	// 2)
	public static void printIncreasing(int n) {
		
	}

	public static void printIncreasingDecreasing(int n) {
		
	}

	public static int factorial(int n) {
		return -1;
	}

	public static int power1(int a, int n) {
		return -1;
	}

	private static int power(int x, int n) {
		return -1;
	}

	public static void pzz(int n) {
		return ;

	}

	public static void displayArrReverse(int[] arr, int idx) {

	}

	public static void display(int[] arr, int idx) {

	}

	public static int maxOfArray(int[] arr, int idx) {
		return -1;
	}

	public static int firstIndex(int[] arr, int idx, int x) {
		return -1;
	}

	public static int lastIndex(int[] arr, int idx, int x) {
		return -1;
	}

	// 24
	// :https://www.youtube.com/watch?v=Sa5PmCFF_zI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=25
	public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
		return new int[] {};
	}

	public static ArrayList<String> printSubSeq(String s, int indx, String op, ArrayList<String> out) {
		

		return out;
	}
	
	// V-26
		public static String codes[] = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static ArrayList<String> getKPC(String str) {
		ArrayList<String> res=new ArrayList<>();
		res.add("NA");
		return res;
	}
	
	// V-29
		public static ArrayList<String> getStairPaths(int n) {
		
			ArrayList<String> res=new ArrayList<>();
			
	
			return res;
		}

	// V-28
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
	
		ArrayList<String> res=new ArrayList<>();
		res.add("");
		return res;
	}


	public static ArrayList<String> getStairsPath(int n) {

		return new ArrayList<>();
	}

	public static void printStairsPath(int n, String path) {

	}

	public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) {
		return new ArrayList<>();

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

	public static void printpermutation(String ip, String op) {
		if (ip.length() == 0) {
			System.out.println(op);
			return;
		}
		for (int i = 0; i < ip.length(); i++) {
			char c = ip.charAt(i);
			String opLeftPart = ip.substring(0, i);
			String opRightPart = ip.substring(i + 1);
			String rip = opLeftPart + opRightPart;
			printpermutation(rip, op + c);

		}
	}

	// https://www.youtube.com/watch?v=R1URUB6_y2k&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=47
	public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited) {
		
	}

	public static void printTargetSum(int arr[], int idx, int target, String subset, int sofar) {
		

	}

	/************************/
	// V-25 get subsequence
	public static ArrayList<String> gss(String ip) {
		ArrayList<String> res=new ArrayList<>();
		res.add("");
		return res;
	}

	

	
	// V-33
	public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
		ArrayList<String> res=new ArrayList<>();
		res.add("");
		return res;
	}

	// v-35
	public static void printSS(String ip, String op) {
		

	}

	// V-36
	public static void printKPC(String que, String ans) {
		
	}

	// V-37
	public static void printStairPaths(int n, String path) {
		

	}

	// V-38
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		

	}

	// V-39
	public static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String psf) {
		
	}

	// V40
	public static void printPermutations(String str, String asf) {
	
	}

	// 45
	public static void printEncodings(String ip, String op) {
		if(ip.isEmpty()) {
			System.out.print(op+",");
			return;
		}else if(ip.length()==1){
			char ch=ip.charAt(0);
			if(ch=='0')return;
			else {
				int chv=ch-'0';
				char code=(char)('a'+chv-1);
				op+=code;
				System.out.print(op+", ");
				return;
			}
		} 
			char ch=ip.charAt(0);
			String ros=ip.substring(1);
			if(ch=='0')return;
			
			int chv=ch-'0';
			char code=(char)('a'+chv-1);
			printEncodings(ros,op+code);
			
			String ch12=ip.substring(0,2);
			String roq=ip.substring(2);
			int chv12=Integer.parseInt(ch12);
			if(chv12<26) {
				char code12=(char)('a'+chv12-1);
				printEncodings(roq,op+code12);

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
				String code0 = (char) ('a' + (Integer.parseInt(ch0) - 1)) + "";
				printEncodings2(roq0, ans + code0);
			}
		} else {
			if (ques.charAt(0) == '0') {
				return;
			} else {
				String ch0 = ques.substring(0, 1);
				String roq0 = ques.substring(1);
				String code0 = (char) ('a' + (Integer.parseInt(ch0) - 1)) + "";
				printEncodings2(roq0, ans + code0);

				String ch01 = ques.substring(0, 2);
				String roq01 = ques.substring(2);
				String code01 = (char) ('a' + (Integer.parseInt(ch01) - 1)) + "";

				if (Integer.parseInt(ch01) <= 26) {
					printEncodings2(roq01, ans + code01);
				}
			}
		}
	}

	public static void floodfill(int[][] maze, int sr, int sc, String asf) {
		

	}

	public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
		

	}

	public static void printNQueens(int[][] chess, String qsf, int r) {
		
	}

	public static boolean isSafe(int grid[][], int r, int c) {
		
		return true;
	}

	public static void printKnightsTour(int[][] chess, int r, int c, int move) {
		

	}

	private static void displayBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
