package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import com.cleanup.Utils;

public class PepBackTrackingSolutions {
//https://nados.io/content/recursion-and-backtracking-for-intermediate-330
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking
	public static String max_value="0";
	public static int minDiff=Integer.MAX_VALUE;
	public static String ans19="";
	public static void main(String[] args) {

		System.out.println("1) Abbreviation 3 2p 1e1 1ep p2 p1p pe1 pep ");
		solution("pep","",0,0);System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("2) Nqueen Branch and bound");
		int n=4;
		boolean[][] chess=new boolean[n][n];
		nqueen(chess,0,new boolean[n],new boolean[2*n-1],new boolean[2*n-1]);
		System.out.println("----------------------------------------");
		
		System.out.println("3) Max score");
		String [] words= {"dog","cat","dad","good"};//return subset of that such that char frq should match frq and score is max
		char [] letters= {'a','b','c','d','d','d','g','o','o'};
		int [] score= {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
		int farr[]=new int[score.length];
		for(char ch:letters)
			farr[ch-'a']++;
		System.out.println("SCORE 23 :- "+maxscore(words,farr,score,0));
		System.out.println("----------------------------------------");

		System.out.println("4)  Josephus problem (3) "+Josephus(5,3));
		System.out.println("----------------------------------------");
		
		System.out.println("5)  Laxicographical order print for 10 and below");
		for(int i=1;i<=9;i++) 
			dfs(i,10);
		System.out.println("----------------------------------------");
		
		int[][]grid= {{10,2,0},{0,0,0},{0,6,2}};//small pockets of gold collect max
		boolean [][] visited=new boolean[grid.length][grid.length];
		int max=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]!=0 && visited[i][j]==false) {
					ArrayList<Integer> bag=new ArrayList<>();
					dfs(grid,i,j,visited,bag);
					int sum=0;
					for(int b:bag)
						sum+=b;
					max=Math.max(max, sum);
				}
				
			}
		}
		System.out.println("6)  GoldMine- (12)"+max);
		
		System.out.println("----------------------------------------");
		int[][] board= {{3,0,6,5,0,8,4,0,0},
						{5,2,0,0,0,0,0,0,0},
						{0,8,7,0,0,0,0,3,1},
						{0,0,3,0,1,0,0,8,0},
						{9,0,0,8,6,3,0,0,5},
						{0,5,0,0,9,0,6,0,0},
						{1,3,0,0,0,0,2,5,0},
						{0,0,0,0,0,0,0,7,4},
						{0,0,5,2,0,6,3,0,0}};
		System.out.println("7)  Sudoku ");
		solveSudoku(board, 0, 0);

		System.out.println("----------------------------------------");
		char[][] arr= {{'+','-','+','+','+','+','+','+','+','+'},
					   {'+','-','+','+','+','+','+','+','+','+'},
					   {'+','-','+','+','+','+','+','+','+','+'},
					   {'+','-','-','-','-','-','+','+','+','+'},
					   {'+','-','+','+','+','-','+','+','+','+'},
					   {'+','-','+','+','+','-','+','+','+','+'},
					   {'+','+','+','+','+','-','+','+','+','+'},
					   {'+','+','-','-','-','-','-','-','+','+'},
					   {'+','+','+','+','+','-','+','+','+','+'},
					   {'+','+','+','+','+','-','+','+','+','+'}};
		String wordsArr[]= {"DELHI","ICELAND","LONDON","ANKARA"};
		
		System.out.println("8)  crossword puzzle ");
		solution(arr, wordsArr, 0);
		System.out.println("----------------------------------------");
		
		System.out.println("9)  Criptographic");//map char to numbers(0,9) such that str1+str2=str3;
		String str1="send",str2="more",str3="money",unique="";
		HashMap<Character,Integer> charInMap=new HashMap<>();
		for(char ch:str1.toCharArray()){
			if(!charInMap.containsKey(ch)) {
				charInMap.put(ch, -1);
				unique+=ch;
			}
		}
		for(char ch:str2.toCharArray()){
			if(!charInMap.containsKey(ch)) {
				charInMap.put(ch, -1);
				unique+=ch;
			}
		}
		for(char ch:str3.toCharArray()){
			if(!charInMap.containsKey(ch)) {
				charInMap.put(ch, -1);
				unique+=ch;
			}
		}
		boolean usedNumbers[]=new boolean[10];
		Criptographic(unique,0,charInMap,usedNumbers,str1,str2,str3);
		System.out.println("----------------------------------------");
		
		System.out.println("10)  Friends Pairing");// N no of friends given return total ways to return all subsets with pairs and single 
		//every friend is having two option akela ayega ya koi or no k sath pair m 
		int friends=3;
		boolean[] used=new boolean[n];
		friendsPairing(1, friends, used, "");
		System.out.println("----------------------------------------");
		
		
		System.out.println("11)  k partition ");
		//N =3 and partition them(non empty) in to 2(k) partitions 
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		for(int i=0;i<2;i++)ans.add(new ArrayList<>());
		partitionKsubsets(1,3,2,0,ans);
		System.out.println("----------------------------------------");
		
		
		System.out.println("12)  palindrom partition ");
		String input="aaaabbbb";
		HashMap<Character,Integer> fmap=new HashMap<>();
		for(char ch:input.toCharArray())
			fmap.put(ch, fmap.getOrDefault(ch, 0)+1);
		Character oddc = null;
		int odds = 0;
		int len = 0;
		for (Character ch : fmap.keySet()) {
			int frq = fmap.get(ch);
			if (frq % 2 == 1) {
				oddc = ch;
				odds++;
			}
			fmap.put(ch, frq / 2);
			len += frq / 2;
		}
		if (odds > 1)
			return;
		generatepw(1,len,fmap,oddc,"");
		System.out.println("----------------------------------------");
		
		System.out.println("13)  palindromPartition ");
		
		palindromPartition("abaaba","");
		System.out.println("----------------------------------------");
		
		System.out.println("14)  Equal Sum partition ");
		ArrayList<ArrayList<Integer>> ans1=new ArrayList<>();
		int k14=4;
		for(int i=0;i<k14;i++)ans1.add(new ArrayList<>());
		int [] arr14= {1,2,3,4,5,6,7,8};
		int sum=0;
		for(int i:arr14)
			sum+=i;
		int subSetSum[]=new int[k14];
		
		solution(arr14,0,8,4,subSetSum,0, ans1);
		System.out.println("----------------------------------------");
		
		System.out.println("15)  pattern Matching");
		
		solution("graphtreegraph","pep",new HashMap<Character,String>(),"pep");
		System.out.println("----------------------------------------");
		
		System.out.println("16)   Word Break");
		HashSet<String> dict=new HashSet<>();
		dict.add("micro");
		dict.add("soft");
		dict.add("hi");
		dict.add("ring");
		dict.add("microsoft");
		wordBreak("microsofthiring","",dict);
		System.out.println("----------------------------------------");
		
		System.out.println("17)   Remove Invalid Parenthesis");
		HashSet<String> hs=new HashSet<>();
		String ip="()())()";
		int getMin=getMin(ip);
		
		RemoveInvalidParanthesis(ip,getMin,hs);
		System.out.println("----------------------------------------");
		
		System.out.println("18)  Maximum Number after K Swaps ");
		
		largestNoAfterKSwap("1234567",4);System.out.println(" Ans:- "+max_value);
		System.out.println("----------------------------------------"+max_value);
		
		System.out.println("19)   Tug of War");
		int a19[]= {6,1,2,3,4,5};
		tugOfWar(a19,0,new ArrayList<>(),new ArrayList<>(),0,0);System.out.println("[6, 1, 3] [2, 4, 5] Ans:- "+ans19);
		System.out.println("----------------------------------------");
		
		System.out.println("20)   Permutation I");
		permutations(new int[3], 1, 2);//4 boxes and 3 items
		System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("21)   Combination I");
		combinations(1, 3, 0, 2, "");
		System.out.println("----------------------------------------");
		
		System.out.println("22)   Permutation II");
		permutations(1,3,new int[2],0,2,"");
		System.out.println("----------------------------------------");
		
		System.out.println("23)   Combination II");
		combinations(new int[3], 1, 2, -1);
		System.out.println("----------------------------------------");
		
		System.out.println("24)   permutation of String  (box on level) 'aabb' ");
		HashMap<Character,Integer> hm24=new HashMap<>();
		hm24.put('a', 2);hm24.put('b', 2);
		generateWords(1, 4, hm24, "");System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("25)   Permutation of String  (item on level) 'aabb'");
		HashMap<Character,Integer> hm25=new HashMap<>();
		hm25.put('a', -1);hm25.put('b', -1);
		generateWords(0, "aabb",new Character[4] ,hm25);System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("26)  Word K selection 'abcabc' select 2 (box on level 'abc' is box)");//need to create 2 length word with DISTINCT chars 
		//so it becomes select 2 from 'abc'
		combination(0,"abc",0,2,"");System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("27)   Word K selection 'abcabc' select 2 (item on level)");//spot will behave like item 
		solve("abc",1,2,-1,""); System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("28)   K length word 1 (box on level)");
		solve(0,"abc",0,2,new Character[2]);System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("29)   K length word 1 (Item on level)");
		solve(0,2,"abc",new HashSet<Character>(),"");System.out.println();
		System.out.println("----------------------------------------");
		
		System.out.println("30)   Queens Combinations I- 2d As 2d - Box Chooses");
		queensCombinations(0,2,0,0,"");
		System.out.println("----------------------------------------");
		
		System.out.println("31)   Queens Permutation I- 2d As 2d - Queen Chooses");
		queensPermutations(0,2,new int[2][2]);
		System.out.println("----------------------------------------");
		
		System.out.println("32)   Queen Permutation II- 2d As 2d Box chooses");
		queensPermutations(0,2,0,0,"",new boolean[2]);
		System.out.println("----------------------------------------");
		
		System.out.println("33)   Queens Combinations II- 2d As 2d - Queen Chooses");
		queensCombinations(0,2,new boolean[2][2],0,-1);
		System.out.println("----------------------------------------");
		
		System.out.println("34)   Queens Combinations I- 2d As 1d - Queen Chooses");
		queensCombinations(0,2,new boolean[2][2],-1);
		System.out.println("----------------------------------------");
		
		System.out.println("35)   N-Queens Combination Problem (Skip)");
		IsQueenSafe(new boolean[2][2],0,0);
		System.out.println("----------------------------------------");
		
		System.out.println("36)   N-Queens Permutation ");
		nqueens(0,4,new int[4][4]);
		System.out.println("----------------------------------------");
		
		System.out.println("37)   Knight Tour (skip)");
		
		System.out.println("----------------------------------------");
		
		
		System.out.println("38)   Coin Change I");
		coinChange(0,new int[]{2,3,5,6,7},0,12,"");
		System.out.println("----------------------------------------");
		
		System.out.println("39)   Coin Change II");
		coinChange2(0,new int[]{2,3,5,6,7},0,12,"");
		System.out.println("----------------------------------------");

	}
	
	//V-1 Abbreviation
	   public static void solution(String str, String asf,int count, int pos){
	        if(pos==str.length()){
	            if(count>0)
	              asf=asf+count;
	            System.out.println(asf);
	            return;
	        }
	       if(count>0)
	        solution(str,asf+count+str.charAt(pos),0,pos+1);
	        else solution(str,asf+str.charAt(pos),count,pos+1);
	        solution(str,asf,count+1,pos+1);
	   }

	   //V-2 NQueen Branch and Bound
	   public static void nqueen(boolean[][] board,int r,boolean[]cols,boolean[]ndia,boolean[] rdia){
		      if(r==board.length){
		          for(int i=0;i<board.length;i++){
		              for(int j=0;j<board[0].length;j++){
		                  if(board[i][j])
		                    System.out.print(i+"-"+j+", ");
		              }
		          }
		         System.out.println(".");
		          return;
		      }
		      
		      for(int c=0;c<board.length;c++){
		          if(!board[r][c] && !cols[c] && !ndia[r+c] && !rdia[r-c+board.length-1]){
		              board[r][c]=true;
		              cols[c]=true;
		              ndia[r+c]=true;
		              rdia[r-c+board.length-1]=true;
		              nqueen(board,r+1,cols,ndia,rdia);
		              board[r][c]=false;
		              cols[c]=false;
		              ndia[r+c]=false;
		              rdia[r-c+board.length-1]=false;
		          }
		      }
		  }
	   
	   //V-3 Max Score 
		public static int maxscore(String[] words, int[] farr, int[] score, int idx) {
			 if(idx==words.length)return 0;

			 int sno=maxscore(words,farr,score,idx+1);
			 String word=words[idx];
			 boolean flag=true;
			 int yScore=0;
			 for(char ch:word.toCharArray()){
			     farr[ch-'a']--;
			     if(farr[ch-'a']<0)
			        flag=false;
			     yScore+=score[ch-'a'];
			 } 
			 int syes=0;
			 if(flag){
			     syes=yScore+maxscore(words,farr,score,idx+1);
			 }
			 for(char ch:word.toCharArray()){
			     farr[ch-'a']++;
			 } 
			return Math.max(sno,syes);
		}
		
		//V-4 Josephus
		 public static int Josephus(int n, int k){
			    if(n==1)return 0;
			    int x=Josephus(n-1,k);
			    int y=(x+k)%n;
			    return y;
	   }
	   //V-5 Lexico	call for(int i=1;i<=9;i++){dfs(i,n)}
	     public static void dfs(int i,int n){
			    if(i>n)return;
			    System.out.println(i);
			    for(int j=0;j<n;j++){
			        dfs(10*i+j,n);
			    }
	     }
		/*V-6 GoldMine 
		 * for(int i=0;i<h;i++){ for(int j=0;j<w;j++){ if(a[i][j]>0){
		 * max=Math.max(maxGold,dfs(a,i,j)); } } }
		 */
//	 	public static int dfs(int [][] grid,int r,int c){
//		    if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0)
//		        return 0;
//		    int count=grid[r][c];
//		    grid[r][c]=0;
//		    count+=dfs(grid,r+1,c);
//		    count+=dfs(grid,r-1,c); 
//		    count+=dfs(grid,r,c+1); 
//		    count+=dfs(grid,r,c-1); 
//		    return count;
//		}
	    
	 	
	 	public static void dfs(int [][] grid,int r,int c,boolean [][]visited,ArrayList<Integer> bag){
	 	   if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0
	 			   || visited[r][c]==false)return;
	 	   bag.add(grid[r][c]);
	 	   visited[r][c]=true;
	 	   dfs(grid,r+1,c,visited,bag);
	 	   dfs(grid,r-1,c,visited,bag);
	 	   dfs(grid,r,c+1,visited,bag);
	 	   dfs(grid,r,c-1,visited,bag);

	 	}
	 	//v-7 Sudoku 
	 	 public static void solveSudoku(int[][] board, int i, int j) {
	 	    if(i==board.length){
	 	        Utils.display(board);
	 	        return;
	 	    }
	 	    int nr=0,nc=0;
	 	    if(j==board.length-1){
	 	        nr=i+1;
	 	        nc=0;
	 	    }else {
	 	        nr=i;
	 	        nc=j+1;
	 	    }
	 	    if(board[i][j]>0)
	 	        solveSudoku(board,nr,nc);
	 	    else {
	 	        for(int po=1;po<10;po++){
	 	            if(isValid(board,i,j,po)){
	 	                board[i][j]=po;
	 	                solveSudoku(board,nr,nc);
	 	                board[i][j]=0;
	 	            }
	 	        }
	 	    } 
	 	  }
	 	  
	 	  public static boolean isValid(int [][] board,int i,int j,int po){
	 	      for(int ii=0;ii<board.length;ii++){
	 	          if(board[ii][j]==po)return false;
	 	      }
	 	      for(int jj=0;jj<board.length;jj++){
	 	          if(board[i][jj]==po)return false;
	 	      }
	 	      int smi=3*(i/3);
	 	      int smj=3*(j/3);
	 	      for(int ii=0;ii<3;ii++){
	 	          for(int jj=0;jj<3;jj++){
	 	              if(board[smi+ii][smj+jj]==po)return false;
	 	          }
	 	      }
	 	      return true;
	 	  }
	 	  //V-8 crossword puzzle
	 	 public static void solution(char[][] arr, String[] words, int vidx) {
	 		if (vidx == words.length) {
	 			//print(arr);
	 			return;
	 		}

	 		String word = words[vidx];
	 		for (int i = 0; i < arr.length; i++) {
	 			for (int j = 0; j < arr[0].length; j++) {
	 				if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
	 					if (canPlaceHorizontally(arr, word, i, j)) {
	 						boolean[] placeH = placeHorizontally(arr, word, i, j);
	 						solution(arr, words, vidx + 1);
	 						unplaceHorizontally(arr, placeH, i, j);
	 					}
	 					if (canPlaceVertically(arr, word, i, j)) {
	 						boolean[] placeV = placeVertically(arr, word, i, j);
	 						solution(arr, words, vidx + 1);
	 						unplaceVertically(arr, placeV, i, j);
	 					}
	 				}
	 			}
	 		}
	 	}
	   
	   public static boolean canPlaceHorizontally(char[][] arr, String word,int i,int j){
	       if(j-1>=0 && arr[i][j-1]!='+')return false;
	       if(j+word.length()<arr[0].length && arr[i][j+word.length()]!='+')return false;
	       for(int jj=0;jj<word.length();jj++){
	           if(j+jj>=arr[0].length)return false;
	           if(arr[i][j+jj]=='-'|| arr[i][j+jj]==word.charAt(jj))continue;
	           else return false;
	       }
	       return true;
	   }
	   public static boolean[] placeHorizontally(char[][] arr, String word,int i,int j){
	       boolean [] weplace=new boolean[word.length()];
	       for(int jj=0;jj<word.length();jj++){
	           if(arr[i][j+jj]=='-'){
	                 arr[i][j+jj]=word.charAt(jj);
	                 weplace[jj]=true;
	           }
	       }
	       return weplace;
	   }
	   
	   public static void unplaceVertically(char[][] arr, boolean[] weplace,int i,int j){
	       for(int ii=0;ii<weplace.length;ii++){
	           if(weplace[ii])
	             arr[i+ii][j]='-';
	       }
	   }
	   
	   public static boolean canPlaceVertically(char[][] arr, String word,int i,int j){
	       if(i-1>=0 && arr[i-1][j]!='+')return false;
	       if(i+word.length()<arr.length && arr[i+word.length()][j]!='+')return false;
	       for(int ii=0;ii<word.length();ii++){
	           if(i+ii>=arr.length)return false;
	           if(arr[i+ii][j]=='-'|| arr[i+ii][j]==word.charAt(ii))continue;
	           else return false;
	       }
	       return true;
	   }
	   public static boolean[] placeVertically(char[][] arr, String word,int i,int j){
	       boolean [] weplace=new boolean[word.length()];
	       for(int ii=0;ii<word.length();ii++){
	           if(arr[i+ii][j]=='-'){
	                 arr[i+ii][j]=word.charAt(ii);
	                 weplace[ii]=true;
	           }
	       }
	       return weplace;
	   }
	   
	   public static void unplaceHorizontally(char[][] arr, boolean[] weplace,int i,int j){
	       for(int jj=0;jj<weplace.length;jj++){
	           if(weplace[jj])
	             arr[i][j+jj]='-';
	       }
	   }
	   //V-9Criptographic 
		public static void Criptographic(String unique, int idx, HashMap<Character, Integer> charIntMap,
				boolean[] usedNumbers, String s1, String s2, String s3) {

			if (idx == unique.length()) {
				int num1 = getNum(s1, charIntMap);
				int num2 = getNum(s2, charIntMap);
				int num3 = getNum(s3, charIntMap);

				if ((num1 + num2) == num3) {
					for (int i = 0; i < 26; i++) {
						char ch = (char) ('a' + i);
						if (charIntMap.containsKey(ch)) {
							System.out.print(ch + "-" + charIntMap.get(ch) + " ");
						}
					}
					System.out.println();
				}

				return;
			}
			char ch = unique.charAt(idx);
			for (int i = 0; i < 10; i++) {
				if (usedNumbers[i] == false) {
					usedNumbers[i] = true;
					charIntMap.put(ch, i);
					Criptographic(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
					usedNumbers[i] = false;
					charIntMap.put(ch, -1);
				}
			}
		}

		public static int getNum(String s, HashMap<Character, Integer> map) {
			String num = "";
			for (int i = 0; i < s.length(); i++) {
				num += map.get(s.charAt(i));
			}
			return Integer.parseInt(num);
		}
	    //V-10 Friends Pairing
		  public static void friendsPairing(int i, int n, boolean[] used, String asf) {
		      if(i>n){
		          System.out.println(counter+"."+asf);
		          counter++;
		          return;
		      }
		    
		    if(used[i])
		    	friendsPairing(i+1,n,used,asf);
		    else{
		        used[i]=true;
		        friendsPairing(i+1,n,used,asf+"("+i+") ");
		        for(int j=i+1;j<=n;j++){
		            if(used[j]==false){
		                used[j]=true;
		                friendsPairing(i+1,n,used,asf+"("+i+","+j+") ");
		                used[j]=false;
		            }
		        }
		        used[i]=false;
		    }
		  }
		  //V-11 partition K subsets
		   static int counter=1;
			public static void partitionKsubsets(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
				   if(i>n){
				       if(rssf==k){
				           	 System.out.print(counter+". ");
				           for(ArrayList<Integer> l:ans)
				            System.out.print(l+" ");
				           System.out.println();
				           counter++;
				       }
				       return;
				   }
				   for(int j=0;j<ans.size();j++){
				       if(ans.get(j).size()>0){
				           ans.get(j).add(i);
				           partitionKsubsets(i+1,n,k,rssf,ans);
				           ans.get(j).remove(ans.get(j).size()-1);
				       }else {
				           ans.get(j).add(i);
				           partitionKsubsets(i+1,n,k,rssf+1,ans);
				           ans.get(j).remove(ans.get(j).size()-1);
				           break;
				       }
				   }
				}
		//V-12 Palindrom permutation of String
		/*
		 * Character oddc=null; int odds=0; int len=0; for(Character ch:fmap.keySet()){
		 * int frq=fmap.get(ch); if(frq%2==1){ oddc=ch; odds++; } fmap.put(ch,frq/2);
		 * len+=frq/2; } if(odds>1)return;
		 * 
		 * generatepw(1,len,fmap,oddc,"");
		 */
			public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
			    if(cs>ts){
			        String rev="";
			        for(int i=asf.length()-1;i>=0;i--){
			            rev+=asf.charAt(i);
			        }
			        if(oddc!=null)
			            asf+=oddc;
			        System.out.println(asf+rev);
			        return;
			    }
				for(char ch:fmap.keySet()){
				    int frq=fmap.get(ch);
				    if(frq>0){
				        fmap.put(ch,frq-1);
				        generatepw(cs+1,ts,fmap,oddc,asf+ch);
				        fmap.put(ch,frq);
				    }
				}
			}
		//V-13 Palindrom Partitioning of String
			public static void palindromPartition(String str, String asf) {
				if(str.isEmpty()){
				    System.out.println(asf);
				    return;
				}
				for(int i=0;i<str.length();i++){
				    String prefix=str.substring(0,i+1);
				    String ros=str.substring(i+1);
				    //if(isPalindrom(prefix)){
				    palindromPartition(ros,asf+"("+prefix+") ");
				    //}
				}
			}
	    //V-14 EqualSum partion
			public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) {
			    if(vidx==arr.length){
			        if(ssssf==k){
			                int first=subsetSum[0];
		        	        boolean flag=true;
		        	        for(int i=1;i<subsetSum.length;i++){
		        	            if(subsetSum[i]!=first)
		        	                flag=false;
		        	        }
		        	        if(flag){
		        	            for(ArrayList<Integer> l:ans)
		        	                System.out.print(l+" ");
		        	            System.out.println();
		        	        }
			        }
			       
			        
			        return;
			    }
				
				for(int i=0;i<ans.size();i++){
				    if(ans.get(i).size()>0){
				        ans.get(i).add(arr[vidx]);
				        subsetSum[i]+=arr[vidx];
				        solution(arr,vidx+1,n,k,subsetSum,ssssf,ans);
				        ans.get(i).remove(ans.get(i).size()-1);
				        subsetSum[i]-=arr[vidx];

				    }else{
				        ans.get(i).add(arr[vidx]);
				        subsetSum[i]+=arr[vidx];
				        solution(arr,vidx+1,n,k,subsetSum,ssssf+1,ans);
				        ans.get(i).remove(ans.get(i).size()-1);
				        subsetSum[i]-=arr[vidx];
				        break;
				    }
				}
			}
		  //V-15  pattern Matching 
			public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
				if(pattern.length()==0){
					if(str.length()==0){
						HashSet<Character> already=new HashSet<>();
						for(int i=0;i<op.length();i++){
							char ch=op.charAt(i);
							if(!already.contains(ch)){
								System.out.print(ch+" -> "+map.get(ch)+", ");
								already.add(ch);
							}
						}
						System.out.println(".");
					}
					return;
				}
				char ch=pattern.charAt(0);
				String rop=pattern.substring(1);
				if(map.containsKey(ch)){
						String pre_mapping=map.get(ch);
						if(str.length()>=pre_mapping.length()){
							String left=str.substring(0,pre_mapping.length());
							String right=str.substring(pre_mapping.length());
							if(pre_mapping.equals(left))
								solution(right,rop,map,op);
						}
					}
					else{
						for(int i=0;i<str.length();i++){
							String left=str.substring(0,i+1);
							String right=str.substring(i+1);
							map.put(ch,left);
							solution(right,rop,map,op);
							map.remove(ch);
						}
					}
			}
		  //V-16 Word Break 
			public static void wordBreak(String str, String ans, HashSet<String> dict){
			    if(str.length()==0){
			        System.out.println(ans);
			        return;
			    }
			
			    for(int i=0;i<str.length();i++){
			        String prefix=str.substring(0,i+1);
			        if(dict.contains(prefix)){
			            String ros=str.substring(i+1);
			            wordBreak(ros,ans+prefix+" ",dict);
			        }
			    }
			}
		//V-17 Remove Invalid Parenthesis
			public static void RemoveInvalidParanthesis(String str,int minRemovalAllowed,HashSet<String> ans) {
				if(minRemovalAllowed==0) {
					int mrNow=getMin(str);
					if(mrNow==0) {
						if(!ans.contains(str)) {
							System.out.println(str);
							ans.add(str);
						}
					}
					return;
				}
				for(int i=0;i<str.length();i++) {
					String left=str.substring(0,i);
					String right=str.substring(i+1);
					RemoveInvalidParanthesis(left+right, minRemovalAllowed-1, ans);
				}
			}
			//return total no of removal required from string 
			public static int getMin(String str) {
				Stack<Character> st =new Stack<>();
				for(int i=0;i<str.length();i++) {
					char ch =str.charAt(i);
					if(ch=='(')
						st.push(ch);
					else if(ch==')')
					{
						if(st.size()==0)
							st.push(ch);
						else if(st.peek()==')')
							st.push(ch);
						else if(st.peek()=='(')
							st.pop();
					}
				}
				return st.size();
			}	
			//V-18 Maximum Number after K Swaps
			private static void largestNoAfterKSwap(String str,int k) {
				//if(Integer.parseInt(str)>Integer.parseInt(max))
					//max=str;
				if(k==0) {
					return;
				}
				for(int i=0;i<str.length()-1;i++) {//not going to last as i must be always before j
					for(int j=i+1;j<str.length();j++) {
						if(str.charAt(j)>str.charAt(i)) {
							String swp=swap(str,i,j);
							largestNoAfterKSwap(swp,k-1);
							//No need to remove string as swaped str in new String original didn't change so no revert either
						}
					}
				}
			}
			
			private static String swap(String str,int i,int j) {
				char ith=str.charAt(i);
				char jth=str.charAt(j);
				String left=str.substring(0,i);
				String middle=str.substring(i+1,j);
				String right=str.substring(j+1);

				return left+jth+middle+ith+right;
			}
			//v-19 Tug of War
			public static void tugOfWar(int[] arr, int idx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
					int soset2) {
				if (idx == arr.length) {
					//int delta = Math.abs(soset1 - soset2);
//					if (delta < minDiff) { // this is to find min diffrence of both set and that will be in ans at the end
//						minDiff = delta;
//						ans = set1 + " " + set2;
//					}
					return;
				}

				if (set1.size() < (arr.length + 1) / 2) { // (arr.length+1) also handle odd no. also
					set1.add(arr[idx]);
					tugOfWar(arr, idx + 1, set1, set2, soset1 + arr[idx], soset2);
					set1.remove(set1.size() - 1);
				}

				if (set2.size() < (arr.length + 1) / 2) {
					set2.add(arr[idx]);
					tugOfWar(arr, idx + 1, set1, set2, soset1, soset2 + arr[idx]);
					set2.remove(set2.size() - 1);
				}
			}
			
			//V-20 Permutations
			 public static void permutations(int[] boxes, int ci, int ti){
				    if(ci>ti){
				        for(int b:boxes)
				            System.out.print(b);
				            System.out.println();
				        return;
				    }
				    for(int i=0;i<boxes.length;i++){
				        if(boxes[i]==0){
				            boxes[i]=ci;
				            permutations(boxes,ci+1,ti);
				            boxes[i]=0;
				        }
				    }
		    }
			//V-21 Combinations
			 public static void combinations(int cb, int tb, int ssf, int ts, String asf){
				    if(cb>tb){
				        if(ssf==ts){
				            System.out.println(asf);
				        }
				        return;
				    }
				    combinations(cb+1,tb,ssf+1,ts,asf+"i");
				    combinations(cb+1,tb,ssf,ts,asf+"-");
			}
			 
			//V-22 Permutations-2
			 public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){
				    if(cb>tb){
				        if(ssf==ts){
				            System.out.println(asf);
				        }
				        return;
				    }
				    for(int i=0;i<ts;i++){
				        if(items[i]==0){
				            items[i]=1;
				            permutations(cb+1,tb,items,ssf+1,ts,asf+(i+1));
				            items[i]=0;
				        }
				    }
				    permutations(cb+1,tb,items,ssf,ts,asf+0);
		    }
			//V-23 Combination-2
			  public static void combinations(int[] boxes, int ci, int ti, int lb){
				     if(ci>ti){
				         for(int b:boxes){
				             if(b>0){
				                System.out.print("i");
				             }else System.out.print("-");
				         }
				            
				        System.out.println();
				        return;
				     }
				     for(int i=lb+1;i<boxes.length;i++){
				        if(boxes[i]==0){
				            boxes[i]=ci;
				            combinations(boxes,ci+1,ti,i);
				            boxes[i]=0;
				        }
				     }
				}
			  //V-24 permutation of String 
			  public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
				    if(cs>ts){
				      System.out.println(asf);
				      return;
				    }
				    for(char ch:fmap.keySet()){
				      if(fmap.get(ch)>0){
				        fmap.put(ch,fmap.get(ch)-1);
				        generateWords(cs+1,ts,fmap,asf+ch);
				        fmap.put(ch,fmap.get(ch)+1);
				      }
				    }
				  }
			  //V-26 permutation of String 2
				public static void generateWords(int cc, String str, Character[] spots,
						HashMap<Character, Integer> lastOccurence) {
					if (cc == str.length()) {
						for (char ch : spots)
							System.out.print(ch);
						System.out.println();
						return;
					}
					char ch = str.charAt(cc);
					int lo = lastOccurence.get(ch);
					for (int i = lo + 1; i < spots.length; i++) {
						if (spots[i] == null) {
							spots[i] = ch;
							lastOccurence.put(ch, i);
							generateWords(cc + 1, str, spots, lastOccurence);
							spots[i] = null;
							lastOccurence.put(ch, lo);
						}
					}
				}
				
				//V-27 Word selection 
				 public static void combination(int cc, String ustr, int ssf, int ts, String asf ) {
					    if(cc==ustr.length()){
					      if(ssf==ts)
					        System.out.println(asf);
					      return;
					    }

					    char ch=ustr.charAt(cc);
					    combination(cc+1,ustr,ssf+1,ts,asf+ch);
					    combination(cc+1,ustr,ssf,ts,asf);
					  }
			  //V-28 Word selection-2
//				  HashSet<Character> uniue=new HashSet<>();
//				    String unq="";
//				    for(char ch:str.toCharArray()){
//				      if(!uniue.contains(ch)){
//				        uniue.add(ch);
//				        unq+=ch;
//				      }
//				    }

				  public static void solve(String str,int cs,int ts,int ls,String asf){
				      if(cs>ts){
				        System.out.println(asf);
				        return;
				      }
				      for(int i=ls+1;i<str.length();i++){
				        solve(str,cs+1,ts,i,asf+str.charAt(i));
				      }
				  }
				  
				  //V-29 K length word 1
				  public static void solve(int cc,String str,int ssf,int ts,Character [] spots){
					    if(cc==str.length()){
					      if(ssf==ts){
					        for(int i=0;i<spots.length;i++)
					          {
					            System.out.print(spots[i]);
					          }
					          System.out.println();
					      }
					      return; 
					    }
					    char ch=str.charAt(cc);
					    for(int i=0;i<spots.length;i++){
					      if(spots[i]==null){
					        spots[i]=ch;
					        solve(cc+1,str,ssf+1,ts,spots);
					        spots[i]=null;
					      }
					    }
					      solve(cc+1,str,ssf,ts,spots);

					  }
				  
				  //V-30 
				  public static void solve(int cs,int ts,String str,HashSet<Character> used,String asf){
				      if(cs>ts){
				        System.out.println(asf);
				        return;
				      }

				      for(int i=0;i<str.length();i++){
				        char ch=str.charAt(i);
				        if(!used.contains(ch)){
				          used.add(ch);
				          solve(cs+1,ts,str,used,asf+ch);
				          used.remove(ch);
				        }
				      }
				    }
				    

			  
			  //V-30 Queens Combinations - 2d As 2d - Box Chooses
			    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
			         if(row == tq){
			            if(qpsf == tq){
			                System.out.println(asf);
			            }
			            return;
			        }
			        int nr=0,nc=0;
			        String sep="";
			        if(col==tq-1){
			            nr=row+1;
			            nc=0;
			            sep="\n";
			        }else {
			            nr=row;
			            nc=col+1;
			            sep="";
			        }
			        queensCombinations(qpsf+1,tq,nr,nc,asf+"q"+sep);
			        queensCombinations(qpsf,tq,nr,nc,asf+"-"+sep);
			        
			    }
			    //V-31 QueenPaermutaions Queen chooses 
			    public static void queensPermutations(int qpsf, int tq, int[][] chess){
			        if(qpsf==tq){
			           for(int i=0;i<chess.length;i++){
			                for(int j=0;j<chess[0].length;j++){
			                    if(chess[i][j]>0)
			                        System.out.print("q"+chess[i][j]+"\t");
			                    else System.out.print("-\t");
			                }
			                System.out.println();
			                      
			           }
			                           System.out.println();

			            
			            return;
			        }
			        
			        for(int i=0;i<chess.length;i++){
			            for(int j=0;j<chess[0].length;j++){
			                if(chess[i][j]==0){
			                    chess[i][j]=qpsf+1;
			                    queensPermutations(qpsf+1,tq,chess);
			                    chess[i][j]=0;
			                }
			            }
			        }
			    }
			    
			    //V-32 Queen Permutation Box chooses
			    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
			        if(row==tq){
			             if(qpsf==tq){
			                 System.out.println(asf);
			                             System.out.println();

			             }
			             return;
			         }
			         
			         int nr=0,nc=0;
			         String sep="";
			         if(col==tq-1){
			             nr=row+1;
			             nc=0;
			             sep="\n";
			         }else{
			             nr=row;
			             nc=col+1;
			             sep="\t";
			         }
			         for(int i=0;i<queens.length;i++){
			             if(queens[i]==false){
			                 queens[i]=true;
			                 queensPermutations(qpsf+1,tq,nr,nc,asf+"q"+(i+1)+sep,queens);
			                 queens[i]=false;
			             }
			         }
			         queensPermutations(qpsf,tq,nr,nc,asf+"-"+sep,queens);

			     }
			    
			    //V-33 Queen Combination queen Chooses
			    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
			        if(qpsf==tq){
			            for(int r=0;r<chess.length;r++){
			                for(int c=0;c<chess[0].length;c++){
			                    if(chess[r][c])
			                        System.out.print("q\t");
			                    else System.out.print("-\t");
			                }
			                System.out.println();
			            }
			                            System.out.println();

			            return;
			        }
			        
			        for(int c=j+1;c<chess[0].length;c++){
			            chess[i][c]=true;
			            queensCombinations(qpsf+1,tq,chess,i,c);
			            chess[i][c]=false;
			        }
			        for(int r=i+1;r<chess.length;r++){
			            for(int c=0;c<chess[0].length;c++){
			                chess[r][c]=true;
			                queensCombinations(qpsf+1,tq,chess,r,c);
			                chess[r][c]=false;

			            }
			        }
			        
			    }
			    //V-34 Queen Combination queen Chooses 2D as one D
			    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
			        if(qpsf==tq){
			            for(int i=0;i<chess.length;i++){
			                for(int j=0;j<chess.length;j++){
			                    if(chess[i][j])
			                        System.out.print("q\t");
			                    else System.out.print("-\t");
			                }
			                System.out.println();
			            }
			         System.out.println();
			            return;
			        }
			        
			        for(int cell=lcno+1;cell<chess.length*chess.length;cell++){
			            int row=cell/chess.length;
			            int col=cell%chess.length;
			            chess[row][col]=true;
			            queensCombinations(qpsf+1,tq,chess,cell);
			            chess[row][col]=false;
			        }
			    }
			    //V-35 N-Queens Combination Problem
			    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
			           for(int i=row,j=col;i>=0;i--){
			            if(chess[i][j])return false;
			        }
				
			    	for(int i=row,j=col;j>=0;j--){
			            if(chess[i][j])return false;
			        }
			        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			            if(chess[i][j])return false;
			        }
			       
			        for(int i=row,j=col;i>=0 && j<chess[0].length;i--,j++){
			            if(chess[i][j])return false;
			        }
			        return true;
			    }
			    
			    
			    //V-36 N-Queens Permutation Problem
			    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
			        for(int i=row,j=col;j>=0;j--){
			            if(chess[i][j]>0)return false;
			        }
			        for(int i=row,j=col;i>=0 && j>=0;i--,j--){
			            if(chess[i][j]>0)return false;
			        }
			        for(int i=row,j=col;i>=0;i--){
			            if(chess[i][j]>0)return false;
			        }
			        for(int i=row,j=col;i>=0 && j<chess.length;i--,j++){
			            if(chess[i][j]>0)return false;
			        }
			        for(int i=row,j=col;j<chess.length;j++){
			            if(chess[i][j]>0)return false;
			        }
			        for(int i=row,j=col;i<chess.length && j<chess.length;i++,j++){
			            if(chess[i][j]>0)return false;
			        }
			        for(int i=row,j=col; i<chess.length;i++){
			            if(chess[i][j]>0)return false;
			        }
			        for(int i=row,j=col;i<chess.length && j>=0;i++,j--){
			            if(chess[i][j]>0)return false;
			        }
			        return true;
			    }

			    public static void nqueens(int qpsf, int tq, int[][] chess) {
			       if(qpsf==tq){
			            for(int r=0;r<chess.length;r++){
			                for(int c=0;c<chess.length;c++){
			                    if(chess[r][c]>0)
			                        System.out.print("q"+chess[r][c]+"\t");
			                    else System.out.print("-\t");
			                }
			                System.out.println();
			            }
			            System.out.println();
			            return;
			        }

			        for(int cell=0;cell<chess.length*chess.length;cell++){
			            int r=cell/chess.length;
			            int c=cell%chess.length;
			            if(chess[r][c]==0 && IsQueenSafe(chess,r,c)){
			                chess[r][c]=qpsf+1;
			                nqueens(qpsf+1,tq,chess);
			                chess[r][c]=0;
			            }
			        }

			    }
			    
			    //V-37 Knight Tour
			    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
			        if(i-1>=0 && j-2>=0 && chess[i-1][j-2])return false;
			        if(i-2>=0 && j-1>=0 && chess[i-2][j-1])return false;
			        if(i-2>=0 && j+1<chess.length && chess[i-2][j+1])return false;
			        if(i-1>=0 && j+2<chess.length && chess[i-1][j+2])return false;
			        if(i+1<chess.length && j+2<chess.length && chess[i+1][j+2])return false;
			        if(i+2<chess.length && j+1<chess.length && chess[i+2][j+1])return false;
			        if(i+2<chess.length && j-1>=0 && chess[i+2][j-1])return false;
			        if(i+1<chess.length && j-2>=0 && chess[i+1][j-2])return false;
			        return true;
			     }
			    //V-38 Coin change 1 
			    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
			        if(i==coins.length){
			            if(amtsf==tamt)
			                System.out.println(asf+".");
			            return;
			        }
			          coinChange(i+1,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");  
			          coinChange(i+1,coins,amtsf,tamt,asf);  

			        }
			  //V-39 Coin change 2
			    public static void coinChange2(int i, int[] coins, int amtsf, int tamt, String asf) {
			        if(i==coins.length){
			            if(amtsf==tamt){
			                System.out.println(asf+".");
			            }
			            return;
			        }
			        for(int j=tamt/coins[i];j>=1;j--){
			            String part="";
			            for(int k=0;k<j;k++)
			              part+=coins[i]+"-";
			            coinChange2(i+1,coins,amtsf+coins[i]*j,tamt,asf+part);
			        }
			        coinChange2(i+1,coins,amtsf,tamt,asf);

			      }
	 	  
}
