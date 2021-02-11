package com.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class PepCodingbackTracking {

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

	String str="()())()";
	int minRem=getMin(str);
	RemoveInvalidParanthesis(str,minRem,new HashSet<>());
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
	

}
