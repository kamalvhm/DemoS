package com.practice;

import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import org.stringtemplate.v4.ST;

import com.cleanup.Utils;

// check solutions in @PepBackTrackingSolutions
public class PepBacktrackingPractice {
	public static String max_value = "0";
	public static int minDiff = Integer.MAX_VALUE;
	public static String ans19 = "";

	public static void main(String[] args) {

		System.out.println("1) Abbreviation 3 2p 1e1 1ep p2 p1p pe1 pep ");
		solution("pep", "", 0, 0);
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("2) Nqueen Branch and bound");
		int n = 4;
		boolean[][] chess = new boolean[n][n];
		nqueen(chess, 0, new boolean[n], new boolean[2 * n - 1], new boolean[2 * n - 1]);
		System.out.println("----------------------------------------");

		System.out.println("3) Max score");
		String[] words = { "dog", "cat", "dad", "good" };// return subset of that such that char frq should match frq
															// and score is max
		char[] letters = { 'a', 'b', 'c', 'd', 'd', 'd', 'g', 'o', 'o' };
		int[] score = { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int farr[] = new int[score.length];
		for (char ch : letters)
			farr[ch - 'a']++;
		System.out.println("SCORE 23 :- " + maxscore(words, farr, score, 0));
		System.out.println("----------------------------------------");

		System.out.println("4)  Josephus problem (3) " + Josephus(5, 3));
		System.out.println("----------------------------------------");

		System.out.println("5)  Laxicographical order print for 10 and below");
		for (int i = 1; i <= 9; i++)
			dfs(i, 10);
		System.out.println("----------------------------------------");

		int[][] grid = { { 10, 2, 0 }, { 0, 0, 0 }, { 0, 6, 2 } };// small pockets of gold collect max
		boolean[][] visited = new boolean[grid.length][grid.length];
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] != 0 && visited[i][j] == false) {
					ArrayList<Integer> bag = new ArrayList<>();
					dfs(grid, i, j, visited, bag);
					int sum = 0;
					for (int b : bag)
						sum += b;
					max = Math.max(max, sum);
				}

			}
		}
		System.out.println("6)  GoldMine- (12)" + max);

		System.out.println("----------------------------------------");
		int[][] board = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
				{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
				{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		System.out.println("7)  Sudoku ");
		solveSudoku(board, 0, 0);

		System.out.println("----------------------------------------");
		char[][] arr = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
				{ '+', '-', '-', '-', '-', '-', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '-', '-', '-', '-', '-', '-', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
				{ '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' } };
		String wordsArr[] = { "DELHI", "ICELAND", "LONDON", "ANKARA" };

		System.out.println("8)  crossword puzzle ");
		solution(arr, wordsArr, 0);
		System.out.println("----------------------------------------");

		System.out.println("9)  Criptographic");// map char to numbers(0,9) such that str1+str2=str3;
		String str1 = "send", str2 = "more", str3 = "money", unique = "";
		HashMap<Character, Integer> charInMap = new HashMap<>();
		for (char ch : str1.toCharArray()) {
			if (!charInMap.containsKey(ch)) {
				charInMap.put(ch, -1);
				unique += ch;
			}
		}
		for (char ch : str2.toCharArray()) {
			if (!charInMap.containsKey(ch)) {
				charInMap.put(ch, -1);
				unique += ch;
			}
		}
		for (char ch : str3.toCharArray()) {
			if (!charInMap.containsKey(ch)) {
				charInMap.put(ch, -1);
				unique += ch;
			}
		}
		boolean usedNumbers[] = new boolean[10];
		Criptographic(unique, 0, charInMap, usedNumbers, str1, str2, str3);
		System.out.println("----------------------------------------");

		System.out.println("10)  Friends Pairing");// N no of friends given return total ways to return all subsets with
													// pairs and single
		// every friend is having two option akela ayega ya koi or no k sath pair m
		int friends = 3;
		boolean[] used = new boolean[n];
		friendsPairing(1, friends, used, "");
		System.out.println("----------------------------------------");

		System.out.println("11)  k partition ");
		// N =3 and partition them(non empty) in to 2(k) partitions
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < 2; i++)
			ans.add(new ArrayList<>());
		partitionKsubsets(1, 3, 2, 0, ans);
		System.out.println("----------------------------------------");

		System.out.println("12)  palindrom partition ");
		String input = "aaaabbbb";
		HashMap<Character, Integer> fmap = new HashMap<>();
		for(char ch:input.toCharArray()) 
			fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
		Character oddc=null;
		int len=0,oddcount=0;
		for(char ch:fmap.keySet()) {
			int frq=fmap.get(ch);
			if(frq%2==1) {
				oddc=ch;
				oddcount++;
			}
			fmap.put(ch, frq/2);
			len+=frq/2;
		}
		if(oddcount>1)return;
		
		generatepw(1, len, fmap, oddc, "");
		System.out.println("----------------------------------------");

		System.out.println("13)  palindromPartition ");

		palindromPartition("abaaba", "");
		System.out.println("----------------------------------------");

		System.out.println("14)  Equal Sum partition ");
		ArrayList<ArrayList<Integer>> ans1 = new ArrayList<>();
		int k14 = 4;
		for (int i = 0; i < k14; i++)
			ans1.add(new ArrayList<>());
		int[] arr14 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int sum = 0;
		for (int i : arr14)
			sum += i;
		int subSetSum[] = new int[k14];

		solution(arr14, 0, 8, 4, subSetSum, 0, ans1);
		System.out.println("----------------------------------------");

		System.out.println("15)  pattern Matching");

		solution("graphtreegraph", "pep", new HashMap<Character, String>(), "pep");
		System.out.println("----------------------------------------");

		System.out.println("16)   Word Break");
		HashSet<String> dict = new HashSet<>();
		dict.add("micro");
		dict.add("soft");
		dict.add("hi");
		dict.add("ring");
		dict.add("microsoft");
		wordBreak("microsofthiring", "", dict);
		System.out.println("----------------------------------------");

		System.out.println("17)   Remove Invalid Parenthesis");
		HashSet<String> hs = new HashSet<>();
		String ip = "()())()";
		int getMin = getMin(ip);

		RemoveInvalidParanthesis(ip, getMin, hs);
		System.out.println("----------------------------------------");

		System.out.println("18)  Maximum Number after K Swaps ");

		largestNoAfterKSwap("1234567", 4);
		System.out.println(" Ans:- " + max_value);
		System.out.println("----------------------------------------" + max_value);

		System.out.println("19)   Tug of War");
		int a19[] = { 6, 1, 2, 3, 4, 5 };
		tugOfWar(a19, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println("[6, 1, 3] [2, 4, 5] Ans:- " + ans19);
		System.out.println("----------------------------------------");

		System.out.println("20)   Permutation I");
		permutations(new int[3], 1, 2);// 4 boxes and 3 items
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("21)   Combination I");
		combinations(1, 3, 0, 2, "");
		System.out.println("----------------------------------------");

		System.out.println("22)   Permutation II");
		permutations(1, 3, new int[2], 0, 2, "");
		System.out.println("----------------------------------------");

		System.out.println("23)   Combination II");
		combinations(new int[3], 1, 2, -1);
		System.out.println("----------------------------------------");

		System.out.println("24)   permutation of String  (box on level) 'aabb' ");
		HashMap<Character, Integer> hm24 = new HashMap<>();
		hm24.put('a', 2);
		hm24.put('b', 2);
		generateWords(1, 4, hm24, "");
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("25)   Permutation of String  (item on level) 'aabb'");
		HashMap<Character, Integer> hm25 = new HashMap<>();
		hm25.put('a', -1);
		hm25.put('b', -1);
		generateWords(0, "aabb", new Character[4], hm25);
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("26)  Word K selection 'abcabc' select 2 (box on level 'abc' is box)");// need to create 2
																									// length word with
																									// DISTINCT chars
		// so it becomes select 2 from 'abc'
		combination(0, "abc", 0, 2, "");
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("27)   Word K selection 'abcabc' select 2 (item on level)");// spot will behave like item
		solve("abc", 1, 2, -1, "");
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("28)   K length word 1 (box on level)");
		solve(0, "abc", 0, 2, new Character[2]);
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("29)   K length word 1 (Item on level)");
		solve(0, 2, "abc", new HashSet<Character>(), "");
		System.out.println();
		System.out.println("----------------------------------------");

		System.out.println("30)   Queens Combinations I- 2d As 2d - Box Chooses");
		queensCombinations(0, 2, 0, 0, "");
		System.out.println("----------------------------------------");

		System.out.println("31)   Queens Permutation I- 2d As 2d - Queen Chooses");
		queensPermutations(0, 2, new int[2][2]);
		System.out.println("----------------------------------------");

		System.out.println("32)   Queen Permutation II- 2d As 2d Box chooses");
		queensPermutations(0, 2, 0, 0, "", new boolean[2]);
		System.out.println("----------------------------------------");

		System.out.println("33)   Queens Combinations II- 2d As 2d - Queen Chooses");
		queensCombinations(0, 2, new boolean[2][2], 0, -1);
		System.out.println("----------------------------------------");

		System.out.println("34)   Queens Combinations I- 2d As 1d - Queen Chooses");
		queensCombinations(0, 2, new boolean[2][2], -1);
		System.out.println("----------------------------------------");

		System.out.println("35)   N-Queens Combination Problem (Skip)");
		IsQueenSafe(new boolean[2][2], 0, 0);
		System.out.println("----------------------------------------");

		System.out.println("36)   N-Queens Permutation ");
		nqueens(0, 4, new int[4][4]);
		System.out.println("----------------------------------------");

		System.out.println("37)   Knight Tour (skip)");

		System.out.println("----------------------------------------");

		System.out.println("38)   Coin Change I");
		coinChange(0, new int[] { 2, 3, 5, 6, 7 }, 0, 12, "");
		System.out.println("----------------------------------------");

		System.out.println("39)   Coin Change II");
		coinChange2(0, new int[] { 2, 3, 5, 6, 7 }, 0, 12, "");
		System.out.println("----------------------------------------");
	}

	// V-1 Abbreviation
	public static void solution(String str, String asf, int count, int pos) {
		

	}

	public static void nqueen(boolean[][] board, int r, boolean[] cols, boolean[] ndia, boolean[] rdia) {

	}

	public static int maxscore(String[] words, int[] farr, int[] score, int idx) {
		return -1;
	}

	public static int Josephus(int n, int k) {
		return -1;
	}

	public static void dfs(int i, int n) {

	}

	public static void dfs(int[][] grid, int r, int c, boolean[][] visited, ArrayList<Integer> bag) {
		if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 || visited[r][c])return;
		bag.add(grid[r][c]);
		visited[r][c]=true;
		dfs(grid,r+1,c,visited,bag);
		dfs(grid,r-1,c,visited,bag);
		dfs(grid,r,c+1,visited,bag);
		dfs(grid,r,c-1,visited,bag);
		//visited[r][c]=false;
		
	}

	// v-7 Sudoku //Utils.display(board);
	public static void solveSudoku(int[][] board, int i, int j) {
		
	}

	public static boolean isValid(int[][] board, int i, int j, int po) {
		
		return true;
	}

	// V-8 crossword puzzle
	public static void solution(char[][] arr, String[] words, int vidx) {
			
	}

	public static boolean canPlaceHorizontally(char[][] arr, String word, int i, int j) {
		
		return true;
	}

	public static boolean[] placeHorizontally(char[][] arr, String word, int i, int j) {
		boolean wePlaced[]=new boolean[word.length()];
		
		return wePlaced;
	}

	public static void unplaceHorizontally(char[][] arr, boolean[] weplace, int i, int j) {
		
	}

	public static boolean canPlaceVertically(char[][] arr, String word, int i, int j) {

		
		return true;
	}

	public static boolean[] placeVertically(char[][] arr, String word, int i, int j) {
		boolean wePlaced[]=new boolean[word.length()];
				return wePlaced;
	}

	public static void unplaceVertically(char[][] arr, boolean[] weplace, int i, int j) {
		
	}

	public static void Criptographic(String unique, int idx, HashMap<Character, Integer> charIntMap,
			boolean[] usedNumbers, String s1, String s2, String s3) {
		
	}

	public static int getNum(String s, HashMap<Character, Integer> map) {
		String val = "1";
		
		return Integer.parseInt(val);
	}

	// V-10 Friends Pairing
	public static void friendsPairing(int i, int n, boolean[] used, String asf) {
		
	}

	// V-11 partition K subsets
	static int counter = 1;

	public static void partitionKsubsets(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		
	}

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
		
	}

	// V-13 Palindrom Partitioning of String
	public static void palindromPartition(String str, String asf) {
		
	}

	public static boolean isPalindrom(String s) {
		
		return true;
	}

	public static void solution(int[] arr, int vidx, int n, int k, int[] subsetSum, int ssssf,
			ArrayList<ArrayList<Integer>> ans) {
		
	}

	// V-15 pattern Matching
	public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
		
	}

	// V-16 Word Break
	public static void wordBreak(String str, String ans, HashSet<String> dict) {
		
	}

	// V-17 Remove Invalid Parenthesis
	public static void RemoveInvalidParanthesis(String str, int minRemovalAllowed, HashSet<String> ans) {
		
	}

	// return total no of removal required from string
	public static int getMin(String str) {
		Stack<Character> st = new Stack<>();
		
		return st.size();
	}

	private static void largestNoAfterKSwap(String str, int k) {
		
	}

	private static String swap(String str, int i, int j) {
		return "";
	}

	// v-19 Tug of War
	public static void tugOfWar(int[] arr, int idx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
		
		
	}

	// V-20 Permutations
	public static void permutations(int[] boxes, int ci, int ti) {
		
	}

	// V-21 Combinations
	public static void combinations(int cb, int tb, int ssf, int ts, String asf) {
		

	}

	// V-22 Permutations-2
	public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
		
	}

	// V-23 Combination-2
	public static void combinations(int[] boxes, int ci, int ti, int lb) {
		
	}

	public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
		
	}

	// V-26 permutation of String 2
	public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence) {
		
	}

	// V-27 Word selection
	public static void combination(int cc, String ustr, int ssf, int ts, String asf) {
		

	}

	public static void solve(String str, int cs, int ts, int ls, String asf) {
	
	}

	// V-29 K length word 1
	public static void solve(int cc, String str, int ssf, int ts, Character[] spots) {
		
	}

	// V-30
	public static void solve(int cs, int ts, String str, HashSet<Character> used, String asf) {
	
	}

	// V-30 Queens Combinations - 2d As 2d - Box Chooses
	public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {

	}

	// V-31 QueenPermutations Queen chooses
	public static void queensPermutations(int qpsf, int tq, int[][] chess) {
		
	}

	// V-32 Queen Permutation Box chooses
	public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
		

	}

	// V-33 Queen Combination queen Chooses
	public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j) {
	
	}

	// V-34 Queen Combination queen Chooses 2D as one D
	public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
		
	}

	// V-35 N-Queens Combination Problem
	public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
		
		return true;
	}

	// V-36 N-Queens Permutation Problem
	public static boolean IsQueenSafe(int[][] chess, int row, int col) {
		
		return true;
	}

	public static void nqueens(int qpsf, int tq, int[][] chess) {
		
	}

	// V-37 Knight Tour
	public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
		
		return true;
	}

	// V-38 Coin change 1
	public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
		if(i==coins.length) {
			if(amtsf==tamt)
				System.out.println(asf);
			return;
		}
		coinChange(i+1,coins,amtsf,tamt,asf);
		coinChange(i+1,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");

		
	}

	// V-39 Coin change 2
	public static void coinChange2(int i, int[] coins, int amtsf, int tamt, String asf) {
		if(i==coins.length) {
			if(amtsf==tamt)
				System.out.println(asf);
			return;
		}
		coinChange2(i+1,coins,amtsf,tamt,asf);
		//coinChange2(i,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");
		for(int j=tamt/coins[i];j>=1;j--) {
			String part="";
			for(int k=0;k<j;k++)
				part+=coins[i]+"-";
			coinChange2(i+1,coins,amtsf+(j*coins[i]),tamt,asf+part);

		}


	}

}
