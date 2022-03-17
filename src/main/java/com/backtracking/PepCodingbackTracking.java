package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import javax.xml.stream.events.Characters;

public class PepCodingbackTracking {
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking 
//https://nados.io/content/recursion-and-backtracking-329
//https://www.youtube.com/watch?v=LliQjLnbhx8&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=1
	public static void main(String[] args) {
			
		 	int n=5;
	        int[][] chess = new int[n][n];
	      //  knightTour(chess,2,2,1);
	        
	        //Sudoku
	        int [][] grid={
	        		{3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	                {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	                {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
	                {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
	                {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	                {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	                {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
	                {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
	        
	char [][] sud=
		   {{'5','3','.','.','7','.','.','.','.'},
	        {'6','.','.','1','9','5','.','.','.'},
	        {'.','9','8','.','.','.','.','6','.'},
	        {'8','.','.','.','6','.','.','.','3'},
	        {'4','.','.','8','.','3','.','.','1'},
	        {'7','.','.','.','2','.','.','.','6'}, 
	        {'.','6','.','.','.','.','2','8','.'}, 
	        {'.','.','.','4','1','9','.','.','5'},
	        {'.','.','.','.','8','.','.','7','9'}};
	       // solveSudoku(grid, 0, 0);
			//isValidSudoku(sud);
	        //abbreviation("pep", 0, "", 0);
	/*ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	for(int i=0;i<3;i++)
		ans.add(new ArrayList<>());
		//divide 4 no in to 3 partitions
		KSubsets(1,4,3,0,ans);*/
/*	String str="aabbccc";
	HashMap<Character,Integer> fmap=new HashMap<>();
	for(char c:str.toCharArray())
		fmap.put(c, fmap.getOrDefault(c, 0)+1);
	 Character odd=null;
	 int odds=0;
	 int len=0;
	for(char c:fmap.keySet()) {
		int freq=fmap.get(c);
		if(freq%2==1) {
			odd=c;
			odds++;
		}
		fmap.put(c, freq/2);
		len+=freq/2;
	}
		generatePerm(1,len,fmap,odd,"");*/
	
	//wordPattern("graphtreegraph", "pep", new HashMap<>(), "pep");

	/*String str="()())()";
	int minRem=getMin(str);
	RemoveInvalidParanthesis(str,minRem,new HashSet<>());*/
/*	int []boxes=new int[4];
	printPermutation(boxes, 1, 2);*/
	/*int nBoxes=4,rItems=2;
	
	combination(1, nBoxes, 0, rItems, "");*/
/*	HashMap<Character,Integer> map=new HashMap<>();
	map.put('a', 2);
	map.put('b', 2);
	generateWords(0,4,map,"");*/
	
	int [] coins= {2,3,5,6,7};
	coinChange(coins, 12, 0, "");
	}
	
	

	public static void knightTour(int [][] chess,int r,int c,int move) {
		if(r<0 || c<0 || r>=chess.length || c>=chess[0].length || chess[r][c]>0)
			return;
		else if(move==chess.length*chess.length) {
			chess[r][c]=move;
			displayBoard(chess,true);
			chess[r][c]=0;
			return;
		}
		chess[r][c]=move;
		knightTour(chess,r-2,c+1,move+1);
		knightTour(chess,r-1,c+2,move+1);
		knightTour(chess,r+1,c+2,move+1);
		knightTour(chess,r+2,c+1,move+1);
		knightTour(chess,r+2,c-1,move+1);
		knightTour(chess,r+1,c-2,move+1);
		knightTour(chess,r-1,c-2,move+1);
		knightTour(chess,r-2,c-1,move+1);
		chess[r][c]=0;
	}
	
	public static void displayBoard(int [][] chess,boolean mode) {
		for(int i=0;i<chess.length;i++) {
			for(int j=0;j<chess[0].length;j++) {
				int p=chess[i][j];
				String o=p+"";
				if(p<10 && mode)
					o=0+o;
				System.out.print(o+" ");
			}
			System.out.println();
		}
		System.out.println();

	}
//https://www.youtube.com/watch?v=uyetDh-DyDg&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0
	public static void solveSudoku(int [][]board,int i,int j) {
		if(i==board.length)
		{
			displayBoard(board,false);
			return;
		}
		//next row and column
		int ni=0;
		int nj=0;
		
		if(j==board[0].length-1) {
			ni=i+1;//if column is last then update row and column will be reset
			nj=0;
		}else {
			ni=i;
			nj=j+1;
		}
		if(board[i][j]!=0) {
			solveSudoku(board,ni,nj);
		}else {
			for(int po=1;po<=9;po++) {
				if(isValid(board,i,j,po)==true) {
					board[i][j]=po;
					solveSudoku(board,ni,nj);
					board[i][j]=0;
				}
			}
		}
	}

private static boolean isValid(int[][] board, int x, int y, int val) {
	//vertically checks
	for(int i=0;i<board.length;i++) {
		if(board[i][y]==val)
			return false;
	}
	//horizontal checks 
	for(int j=0;j<board[0].length;j++) {
		if(board[x][j]==val)
			return false;
	}
	//sub-matrix checks  to get submaric start point divide current row/col by 3 and multiple by 3
	// X 1 2  in every sub matrix out start point will be this X and we are will find this and start loop from this point in every sub matrix  
	// 0 0 3  to calculate this X = 3*i/3,[3*j/3] where i ,j are row and col  
	// 0 0 5
	int smi=x/3 *3;
	int smj=y/3 *3;
	for(int i=0;i<3;i++) {
		for(int j=0;j<3;j++) {
			if(board[smi+i][smj+j]==val)
				return false;
		}
	}
	return true;
}
//36. Valid Sudoku
public static boolean isValidSudoku(char[][] board) {
		HashSet<String> hs = new HashSet<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char current_val = board[i][j];
				if (current_val != '.') {
					if (!hs.add(current_val + " found in row " + i) || !hs.add(current_val + " found in column " + j)
							|| hs.add(current_val + " found in sub box " + i / 3 + "-" + j / 3))// this will give sub
																								// box no of i and j
					{
						return false;
					}

				}
			}
		}

    return true;  
}

public static void abbreviation(String ip,int idx,String op ,int count) {
	if(idx==ip.length()) {
		if(count==0)
			System.out.println(op);
		else System.out.println(op+count);
		return;
	}
	if(count>0)
		abbreviation(ip,idx+1, op+count+ip.charAt(idx), 0);
	else 
		abbreviation(ip,idx+1, op+ip.charAt(idx), 0);

	abbreviation(ip,idx+1, op, count+1);

}
//386. Lexicographical Numbers
public List<Integer> lexicalOrder(int n) {
    List<Integer> results=new ArrayList<>();
     for(int i=1;i<=9;i++){
         dfs(i,n,results);
     }
     return results;
 }
 
 public static void dfs(int i,int n,List<Integer> results){
     if(i>n)
         return;
     results.add(i);
     for(int j=0;j<10;j++){
         dfs(10*i+j,n,results);
     }
 }
 //https://www.youtube.com/watch?v=lNwXq3Ki32I&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=7
 public int getMaximumGold(int[][] grid) {
     int h=grid.length;
     int l=grid[0].length;
     int max=Integer.MIN_VALUE;
       boolean[][] visited=new boolean[h][l];
     for(int i=0;i<h;i++){
         for(int j=0;j<l;j++){
          if(grid[i][j]!=0 && visited[i][j]==false){
              ArrayList<Integer> bag=new ArrayList<>();
             dfs(grid,i,j,bag,visited);

              int val=0;
              for(int k:bag)
                  val+=k;
              max=Math.max(max,val);
          }
         }
     }
       return max;
   }
   
   public static void dfs(int[][] grid,int r,int c,ArrayList<Integer> bag,boolean[][] visited){
     int h=grid.length;
     int l=grid[0].length;
    if(r<0 || c<0 || r>=h || c>=l || grid[r][c]==0 || visited[r][c]==true)return ;
       visited[r][c]=true;
       bag.add(grid[r][c]);
       dfs(grid,r+1,c,bag,visited);
       dfs(grid,r-1,c,bag,visited);
       dfs(grid,r,c+1,bag,visited);
       dfs(grid,r,c-1,bag,visited);

   }
   

   
   		//Friends Pairing using Backtracking
   public static void friendsPairr(int i,int n ,boolean[] used,String asf) {
	   if(i>n) {
		   System.out.print(asf);
		   return;
	   }
	   if(used[i]) {
		   friendsPairr(i+1,n,used,asf);
	   }else {
		   used[i]=true;
		   friendsPairr(i+1,n,used,asf+"("+i+")");
		   for(int j=i+1;j<=n;j++) {
			   if(used[j]==false) {
				   used[j]=true;
				   friendsPairr(i+1,n,used,asf+"("+i+j+")");
				   used[j]=false; 
			   }
		   }
		   used[i]=false;
	   }
   }
   
   //Partition in K Subsets
   public static void KSubsets(int i,int n,int k,int nos,ArrayList<ArrayList<Integer>> ans) {
	   if(i>n) {
		   if(nos==k) {
			   for(ArrayList<Integer> set:ans)
			      System.out.print(set);
			   System.out.println("");
		   }
		   return;
	   }
	   
	   for(int j=0;j<ans.size();j++) {
		   if(ans.get(j).size()>0) { //go with existing non emty set
			   ans.get(j).add(i);
			   KSubsets(i+1, n, k, nos, ans);
			   ans.get(j).remove(ans.get(j).size()-1);
		   }else { //or create a new set of its own
			   ans.get(j).add(i);
			   KSubsets(i+1, n, k, nos+1, ans); //no of subset increased
			   ans.get(j).remove(ans.get(j).size()-1); 
			   break; //breaking after as repetition not allowed
		   } 
	   }
   }

public static void generatePerm(int cs ,int ts,HashMap<Character,Integer> fmap,Character oddc,String asf) {
	if(cs>ts) {
		String rev="";
		for(int i=asf.length()-1;i>=0;i--)
			rev+=asf.charAt(i);
		System.out.println(asf+oddc+rev);
		return;
	}
	
	for(char ch:fmap.keySet()) {
		int freq=fmap.get(ch);
		if(freq>0) {
			fmap.put(ch, freq-1);
			generatePerm(cs+1,ts,fmap,oddc,asf+ch);
			fmap.put(ch, freq);
		}
	}
}
//Equal Sum Subsets Partition same as KSubsets
public static void equalSubsetsPartition(int []arr,int vidx,int n,int k,int [] subsetSum,int ssssf,ArrayList<ArrayList<Integer>> ans) {
	   if(vidx>n) {
		   if(ssssf==k) {
			 boolean flag =true;
			 for(int i=0;i<subsetSum.length-1;i++) { //checking if all set are equal
				 if(subsetSum[i]!=subsetSum[i+1]) {
					 flag=false;
					 break;
				 }
			 }
			 if(flag) {
				 for(ArrayList<Integer> set:ans)
				      System.out.print(set);
				   System.out.println("");
			 }
		   }
		   return;
	   }
	   
	   for(int j=0;j<ans.size();j++) {
		   if(ans.get(j).size()>0) { //go with existing non emty set
			   ans.get(j).add(vidx);
			   subsetSum[j]+=arr[vidx];
			   equalSubsetsPartition(arr,vidx+1, n, k,subsetSum, ssssf, ans);
			   subsetSum[j]-=arr[vidx];
			   ans.get(j).remove(ans.get(j).size()-1);
		   }else { //or create a new set of its own
			   ans.get(j).add(vidx);
			   subsetSum[j]+=arr[vidx];
			   equalSubsetsPartition(arr,vidx+1, n, k,subsetSum, ssssf+1, ans);
			   subsetSum[j]-=arr[vidx];
			   ans.get(j).remove(ans.get(j).size()-1);
			   break;
		   } 
	   }
}
//https://www.youtube.com/watch?v=aVMyXDuSLNM&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=15
public static void wordPattern(String str,String pattern,HashMap<Character,String> map,String op) {
	if(pattern.length()==0) {
		if(str.length()==0) {
			HashSet<Character> alreadyPrinted=new HashSet<>();
			for(int i=0;i<op.length();i++) {
				char ch=op.charAt(i);
				if(!alreadyPrinted.contains(ch)) {
					System.out.print(ch+"->"+map.get(ch)+", ");
					alreadyPrinted.add(ch);
				}
			}
		}
		return;
	}
	  
	char ch=pattern.charAt(0);
	String rop=pattern.substring(1);
	if(map.containsKey(ch)) {//check if we already formed pattern 
		String previousMapping=map.get(ch);
		if(str.length()>=previousMapping.length()) {
			String leftPart=str.substring(0,previousMapping.length());
			String rightPart=str.substring(previousMapping.length());
			if(previousMapping.endsWith(leftPart)) {
				wordPattern(rightPart, rop, map, op);
			}
		}
	}else { //if already not mapped the nmap with all prefixs 
		for(int i=0;i<str.length();i++) {
			String leftPart=str.substring(0,i+1);
			String rightPart=str.substring(i+1);
			map.put(ch, leftPart);
			wordPattern(rightPart, rop, map, op);
			map.remove(ch);
		}
	}
}
//Word Break
public static void wordBreak(String str,String ans,HashSet<String> dict) {
	if(str.length()==0) {
		System.out.print(ans);
		return;
	}
	for(int i=0;i<str.length();i++) {
		String left=str.substring(0,i+1);
		if(dict.contains(left)) {
			String right=str.substring(i+1);
			wordBreak(right, ans+=left+" ", dict);
		}
	}
}

//Remove Invalid Parentheses |301. Remove Invalid Parentheses
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
	static int minDiff=Integer.MAX_VALUE;
	static String ans="";

  //Minimum Subset Sum difference | https://www.youtube.com/watch?v=Q1fLW_zQr3M&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=18
	//divide array elements in two equal (1 vary in case of odd length) and print ans which have min diffrence between them
	public static void tugOfWar(int[] arr, int idx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
		if (idx == arr.length) {
			int delta = Math.abs(soset1 - soset2);
			if (delta < minDiff) { // this is to find min diffrence of both set and that will be in ans at the end
				minDiff = delta;
				ans = set1 + " " + set2;
			}
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
	/**------PERMUTATION COMBINATION STARTS----*/
	//Item are ditinct{1,2,3}
	// ARRAGE total item (r) int n boxes where ci is current item |https://www.youtube.com/watch?v=QKkHCS5bq0I&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=19
	public static void printPermutation(int []boxes,int ci,int ti) {
		if(ci>ti) {
			for(int i=0;i<boxes.length;i++)
				System.out.print(boxes[i]);
			System.out.println("");
			return;
		}
		
		for(int i=0;i<boxes.length;i++) { //Boxes are OPTION Here and ITEM are LEVELS
			if(boxes[i]==0) {
				boxes[i]=ci;
				printPermutation(boxes, ci+1, ti);
				boxes[i]=0;
			}
		}
		
	}
	//cb=currentBoxs tb=totalBoxes,ssf=selectionSofar ,ts =total seletions
	public static void combination(int cb, int tb,int ssf,int ts,String asf) {
		if(cb>tb) {
			if(ssf==ts) {
				System.out.println(asf);
			}
			return;
		}
		combination(cb+1,tb,ssf+1,ts,asf+"i");//yes call
		combination(cb+1,tb,ssf,ts,asf+"-");//no call
	}	
	//https://www.youtube.com/watch?v=NWFpebVkmTI&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=21
	//ts is means how many items are there ||PERMUTATION FROM COMBINATION||||
	public static void permutationUsingCombination(int cb, int tb,int []items,int ssf,int ts,String asf) {
		if(cb>tb) {
			if(ssf==ts) {
				System.out.println(asf);
			}
			return;
		}
		for(int i=0;i<ts;i++) { //ITEMs Are Option here and BOXES are on levels
			if(items[i]==0) {
				items[i]=1;// 1 means items is used Items are tells which item is used 
				permutationUsingCombination(cb+1, tb, items, ssf+1, ts, asf+(i+1));//increase current box one selected so ssf+1
				items[i]=0;
			}
		}
		permutationUsingCombination(cb+1, tb, items, ssf, ts, asf+0);//Box is not letting sit anyone  asf+0 means no one sitting on spot

	}
	//In this code we are making combination from permutaion code by eliminating extra branches of tree (criteria is to eliminate which is having non increasing order)
	public static void combinationUsingPermutation(boolean [] boxes,int ci,int ti,int lb) {//lb is lastbox pos
		
		if(ci>ti) {
			for(int i=0;i<boxes.length;i++) {
				if(boxes[i])
					System.out.print("i");
				else System.out.print("-");
			}
			System.out.println("");
			return;
		}
		for(int b=lb+1;b<boxes.length;b++) { //Boxes are on option  || To maintain increasing order lb+1 
			if(!boxes[b]) {
				boxes[b]=true;
				combinationUsingPermutation(boxes, ci+1, ti, b);
				boxes[b]=false;
			}
		}
	}
	//Generate No from aabb Box are on level
	private static void generateWords(int cs,int ts,HashMap<Character,Integer> map,String asf) {
		if(cs>ts) {
			System.out.print(asf);
			return;
		}
		for(char ch:map.keySet()) {
			int val=map.get(ch);
			if(val>0) {
				map.put(ch, --val);
				generateWords(cs+1,ts,map,asf+ch);
				map.put(ch, val+1);
			}
		}
		
	}
	//item On level  
	private static void generateWords2(int cc,String str,Character[]  spots,HashMap<Character,Integer> lastOccurentce) {
		if(cc==str.length()) {
			for(int i=0;i<spots.length;i++) {
				System.out.print(spots[i]);
			}
			return;
		}
		
		char ch =str.charAt(cc);
		int lo=lastOccurentce.get(ch); //its because to avoid duplicate so new a will occur only after 
		for(int i =lo+1;i<spots.length;i++) {
			if(spots[i]==null) {
				spots[i]=ch;
				lastOccurentce.put(ch, i);
				generateWords2(cc+1, str, spots, lastOccurentce);
				spots[i]=null;
				lastOccurentce.put(ch, lo);
			}
		}
	}
	//https://leetcode.com/problems/maximum-swap/
	static String max;
	private static void largestNoAfterKSwap(String str,int k) {
		if(Integer.parseInt(str)>Integer.parseInt(max))
			max=str;
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
	//Q. in "aabbbccdde" print all ways you can select distinct char from ip string create distinct chars in hashmap and str
	public static void WordsKSelection(int cb,int ssf,int ts,String asf,String str) {
		if(cb==str.length()) {
			if(ssf==ts) {
				System.out.println(asf);
			}

			return;
		}
		WordsKSelection(cb+1, ssf+0, ts, asf+"", str);
		WordsKSelection(cb+1, ssf+1, ts, asf+str.charAt(cb),str);
	}
	//Items on level str will contain all uniq chars cs =1,ts=2,lc =-1
	public static void WordsKSelection2(String str,int cs,int ts,int lc,String asf) {
		if(cs>ts) {
			System.out.print(asf);
			return;
		}
		
		for(int b=lc+1;b<str.length();b++) {
			char ch =str.charAt(b);
			WordsKSelection2(str, cs+1, ts, b, asf+ch);
		}
	}
	//str have uniq chars 
	public static void kLengthWord(int cc,String  str,int ssf,int ts,Character []spots) {
		if(cc==str.length()) {
			if(ssf==ts) {
				for(char c:spots)
					System.out.print(c);
				System.out.println();

			}
			return;
		}
		
		char ch=str.charAt(cc);
		for(int i=0;i<spots.length;i++) {
			if(spots[i]==null) {
				spots[i]=ch;
				kLengthWord(cc+1, str, ssf+1, ts, spots);
				spots[i]=null;
			}
		}
		kLengthWord(cc+1, str, ssf, ts, spots);
	}
	
	public static void kLengthWord2(int cs,int ts,String str,HashSet<Character> used,String asf) {
		if(cs>ts) {
			System.out.print(asf);
			return;
		}
		
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(!used.contains(ch)) {
				used.add(ch);
				kLengthWord2(cs+1, ts, str, used, asf+ch);
				used.remove(ch);
			}
		}
	}
	//Combination Approach BOX on LEVEL
	public static void queenCombination(int qpsf,int tq,int row,int col,String asf) {
		if(row==tq) {
			if(qpsf==tq)
			 System.out.println(asf);
			return;
		}
		int nr=0;
		int nc=0;
		String yasf="";//yes ans so far 
		String nasf="";//no ans so far 
		if(col==tq-1) {
			nr=row+1;
			nc=0;
			yasf=asf+"q\n";
			nasf=asf+"-\n";
		}else {
			nr=row;
			nc=col+1;
			yasf=asf+"q";
			nasf=asf+"-";
		}
		queenCombination(qpsf+1,tq,nr,nc,yasf);
		queenCombination(qpsf+0,tq,nr,nc,nasf);
	}
	
	//V-31 here QUEEN ON LEVEL AND CHESS BOARD(BOX) ON OPTION
	public static void queenPermutation(int qpsf,int tq,int [][] chess) {
		if(qpsf==tq) {
			for(int i=0;i<chess.length;i++) {
				for(int j=0;j<chess[0].length;j++) {
					System.out.print(chess[i][j]+"\t");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int i=0;i<chess.length;i++) {
			for(int j=0;j<chess[0].length;j++) {
				if(chess[i][j]==0) {
					chess[i][j]=qpsf+1;
					queenPermutation(qpsf+1, tq, chess);
					chess[i][j]=0;
				}
			}
		}
	}
	//V-32 Here BOARD(BOX) ON LEVEL and QUEEN Is OPTION
	public static void queenPermutation2(int qsf,int tq,int row,int col,String asf,boolean [] queens) {
		if(row==tq) {
			if(qsf==tq) {
				System.out.print(asf);
			}
			return;
		} 
		int nr=0;
		int nc=0;
		
		if(col==tq-1) {
			nr=row+1;
			nc=0;
		}else {
			nr=row;
			nc=col+1;
		}
				
		
		for(int i=0;i<queens.length;i++) {
			if(!queens[i]) {
				queens[i]=true;
				queenPermutation2(qsf+1, tq, nr, nc, asf+"q"+i+1, queens);
				queens[i]=false;
			}
		}
		queenPermutation2(qsf+0, tq, nr, nc, asf+"q-", queens);

	}
	//i =0 and j=-1 BOX(Chess) is OPTION and Queens are on Level (OPTION DIVIDED IN TWO PARTS BUT FOR CURRENT ROW (partially filled) and ALL OTHER ROWS)
	public static void queenCombination2(int qpsf,int tq,boolean [][] chess,int i,int j) {
		if(qpsf>tq) {
			for(int row=0;row<chess.length;row++) {
				for(int col=0;col<chess[i].length;col++) {
					System.out.print(chess[row][col]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int col=j+1;col<chess.length;col++) {//loop for current row
			chess[i][col]=true;
			queenCombination2(qpsf+1, tq, chess, i,col);
			chess[i][col]=false;
		}
		for(int row=i+1;row<chess.length;row++) {//loop for rest all row
			for(int col=0;col<chess[i].length;col++) {
				chess[row][col]=true;
				queenCombination2(qpsf+1, tq, chess, row,col);
				chess[row][col]=false;
			}
		}
	}
	//V-34/V-35(with uncomment) 2D to 1D array CHECK NOTES (TWO SIMPLIFY TWO PARTS ABOVE WE CAN TREET 2D AS 1D)
	public static void queenCombination3(int qpsf,int tq,boolean [][] chess,int lcno) {
		if(qpsf>tq) {
			for(int row=0;row<chess.length;row++) {
				for(int col=0;col<chess[row].length;col++) {
					System.out.print(chess[row][col]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for(int cell=lcno+1;cell<chess.length*chess.length;cell++) {
			int row=cell/chess.length;//from 1D to 2D row call formula is row=cell/length col = cell%length 
			int col=cell%chess.length;//if beck 2D to 1D cellNo= row*length+col;	
			//isQueenSafe for V-35
			chess[row][col]=true;
			queenCombination3(qpsf+1,tq,chess,cell);
			chess[row][col]=false;

		}
	}
	public static boolean isQueenSafe(boolean[][] chess,int  row,int col) {
		for(int i=row,j=col;i>=0;i--)
		{
			if(chess[i][j])
				return false;
		}
		for(int i=row,j=col; j>=0;j--)
		{
			if(chess[i][j])
				return false;
		}
		for(int i=row,j=col;i>=0 && j>=0;i--,j--)
		{
			if(chess[i][j])
				return false;
		}
		
		for(int i=row,j=col;i>=0 && j<chess.length;i--,j++)
		{
			if(chess[i][j])
				return false;
		}
		return true;
	}
	public static boolean isQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        int[][] dir={{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        for(int k=0;k<dir.length;k++){
            int i=row;
            int j=col;
            while(i>=0 && j>=0 && j<chess.length && i<chess.length){
                if(chess[i][j]!=0){
                    return false;
                }
                j+=dir[k][1];
                i+=dir[k][0];
            }
        }
        return true;
    }
	
	//V-36
	public static void NqueenPermutation(int qpsf, int tq, int[][] chess) {
		if (qpsf == tq) {
			for (int row = 0; row < chess.length; row++) {
				for (int col = 0; col < chess[row].length; col++) {
					System.out.print(chess[row][col]);
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		for (int cell = 0; cell < chess.length * chess.length; cell++) {
			int row = cell / chess.length;
			int col = cell % chess.length;
			if (chess[row][col] == 0 && isQueenSafe(chess, row, col)) {
				chess[row][col] = qpsf + 1;
				NqueenPermutation(qpsf + 1, tq, chess);
				chess[row][col] = 0;

			}
		}
	}
	
	
	public static void nknight(int kpsf,int tk,boolean[][]chess,int lcno) {
		if(kpsf>tk) {
			for(int row=0;row<chess.length;row++) {
				for(int col=0;col<chess.length;col++){
					System.out.print(chess[row][col]?"k\t":"-\t");
				}
				System.out.println("");
			}
			System.out.println("");	
			return;
		}
		
		for(int i=lcno+1;i<chess.length*chess.length;i++) {
			int row=i/chess.length;
			int col=i%chess.length;
			if(chess[row][col]==false && isKnightSafe(chess,row,col)) {
				chess[row][col]=true;
				nknight(kpsf+1, tk, chess, row*chess.length+col);
				chess[row][col]=false;
			}
		}
	}

	
	private static boolean isKnightSafe(boolean[][] chess, int i, int j) {
		if(i-1>=0 && j-2>=0 && chess[i-1][j-2])
			return false;
		if(i-2>=0 && j-1>=0 && chess[i-2][j-1])
			return false;
		if(i-2>=0 && j+1<chess.length && chess[i-2][j+1])
			return false;
		if(i-1>=0 && j+2<chess.length && chess[i-1][j+2])
			return false;
		return true;
	}
	//Combination appraoch(as ans 5-7 and 7-5 is considered same so combination) no duplicacy in coins
	public static void coinChange(int [] arr,int sum,int index,String asf) {
		if(index==arr.length)
		{	
			if(sum==0)
			System.out.println(asf);
			return;
		}
		coinChange(arr, sum-arr[index], index+1,asf+"-"+arr[index]);
		coinChange(arr, sum, index+1,asf);

	}
	//same coin can be taken more then once same combination approch
	public static void coinChange2(int i,int [] coins,int amtsf,int tamt,String asf) {
		if(i==coins.length)
		{	
			if(amtsf==tamt)
			System.out.println(asf);
			return;
		}
		for(int j=tamt/coins[i];j>=1;j--) {
			String part="";
			for(int k=0;k<j;j++) {
				part+=coins[i]+"-";
			}
			coinChange2(i+1, coins, amtsf+coins[i]*j, tamt, asf+part);
		}
		coinChange2(i+1, coins, amtsf, tamt, asf);

	}

}
