package dels;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.io.*;
import java.util.*;
public class RecurrBack {
	  static int counter = 1;

	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String str = br.readLine();
	    int k = Integer.parseInt(br.readLine());

	    HashSet<Character> unique = new HashSet<>();
	    String ustr = "";
	    for (char ch : str.toCharArray()) {
	      if (unique.contains(ch) == false) {
	        unique.add(ch);
	        ustr += ch;
	      }
	    }

	    boolean []marked=new boolean[ustr.length()];
	    solve(ustr,0,k,"",marked);
	}
	 public static void solve(String str,int cs,int ts,String asf,boolean marked[]){
	      if(cs==ts){
	          System.out.println(asf);
	          return;
	      }
	      for(int i=0;i<str.length();i++){
	          if(marked[i]==false){
	              marked[i]=true;
	              solve(str,cs+1,ts,asf+str.charAt(i),marked);
	              marked[i]=false;
	          }
	      }
	  }
	
	 public static void solve(int idx,String str,int ssf,Character [] spot){
	      if(idx==str.length()){
	          if(ssf==spot.length){
	              for(char ch:spot)
	                System.out.print(ch);
	              System.out.println();
	          }
	          return;
	      }
	      
	      char ch=str.charAt(idx);
	      for(int i=0;i<spot.length;i++){
	          if(spot[i]==null){
	              spot[i]=ch;
	              solve(idx+1,str,ssf+1,spot);
	              spot[i]=null;
	          }
	      }
	      solve(idx+1,str,ssf,spot);

	  }
	public static void solve(int cs,int ts,int i,String s,String asf){
	      if(cs==ts){
	          System.out.println(asf);
	          return;
	      } 
	      for(int k=i+1;k<s.length();k++){
	          solve(cs+1,ts,k,s,asf+s.charAt(k));
	      }
	  }
	 public static void combination(int i, String ustr, int ssf, int ts, String asf ) {
	        if(i==ustr.length()){
	            if(ssf==ts)
	                System.out.println(asf);
	            return;
	        }
	        
	        char ch=ustr.charAt(i);
	        combination(i+1,ustr,ssf+1,ts,asf+ch);
	        combination(i+1,ustr,ssf,ts,asf);
	  }

	public static void generateWords(int cc, String str, Character[] spots, HashMap<Character, Integer> lastOccurence) {

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
	
	 public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
		    if(cs>ts){
		        System.out.println(asf);
		        return;
		    }
		    
		    for(char ch:fmap.keySet()){
		        int frq=fmap.get(ch);
		        if(frq>0){
		            fmap.put(ch,frq-1);
		            generateWords(cs+1,ts,fmap,asf+ch);
		            fmap.put(ch,frq);
		        } 
		    }
		  }
	 
	public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
	       if(i==coins.length){
	           if(amtsf==tamt)
	             System.out.println(asf);
	           return;
	       }
	       
	       
	       for(int j=tamt/coins[i];j>=1;j--){
	           String part="";
	           for(int k=0;k<j;k++)
	                part+=coins[i]+"-";
	            coinChange(i+1,coins,amtsf+coins[i]*j,tamt,asf+part);
	       }
	       coinChange(i+1,coins,amtsf,tamt,asf);
	    }
	
	public static void coinChange2(int i, int[] coins, int amtsf, int tamt, String asf){
        if(i==coins.length){
            if(amtsf==tamt)
                System.out.println(asf+"."); 
            return;
        }
        coinChange2(i+1,coins,amtsf+coins[i],tamt,asf+coins[i]+"-");
        coinChange2(i+1,coins,amtsf,tamt,asf);
        
    }
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
         for(int i=row,j=col;i<chess.length;i++){
            if(chess[i][j]>0)return false;
        }
            for(int i=row,j=col;i<chess.length && j>=0;i++,j--){
            if(chess[i][j]>0)return false;
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if(qpsf==tq){
            for(int i=0;i<chess.length;i++){
                for(int j=0;j<chess[0].length;j++){
                    System.out.print(chess[i][j]>0?"q"+chess[i][j]+"\t":"-\t");
                }
                System.out.println();
            }
            System.out.println();

            return;
        }
        for(int cell=0;cell<chess.length*chess.length;cell++){
            int r=cell/chess.length;
            int c=cell%chess.length;
            if(IsQueenSafe(chess,r,c)){
                chess[r][c]=qpsf+1;
                nqueens(qpsf+1,tq,chess);
                chess[r][c]=0;
            }
            
        }
    }
	 public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
		 if(tq==qpsf){
             for(int r=0;r<chess.length;r++){
                 for(int c=0;c<chess.length;c++){
                     System.out.print(chess[r][c]?"q\t":"-\t");
                 }
                 System.out.println();
             }
             System.out.println();
             return;
         }
	       
	       for(int cell=lcno+1;cell<chess.length*chess.length;cell++){
	           int r=cell/chess.length;
	           int c=cell%chess.length;
	           chess[r][c]=true;
	           queensCombinations(qpsf+1,tq,chess,cell);
	           chess[r][c]=false;
	       }
	      
	    }
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
       
            if(tq==qpsf){
                for(int r=0;r<chess.length;r++){
                    for(int c=0;c<chess.length;c++){
                        System.out.print(chess[r][c]?"q\t":"-\t");
                    }
                    System.out.println();
                }
                System.out.println();
                return;
            }
                               

        
        for(int c=j+1;c<chess.length;c++){
            chess[i][c]=true;
            queensCombinations(qpsf+1,tq,chess,i,c);
            chess[i][c]=false;
        }
        for(int r=i+1;r<chess.length;r++){
            for(int c=0;c<chess.length;c++){
                chess[r][c]=true;
                queensCombinations(qpsf+1,tq,chess,r,c);
                chess[r][c]=false;

            }
        }
    }
	  public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
	        if(row==tq){
	            if(qpsf==tq)
	                System.out.println(asf);
	            return;
	        }
	         int nr=row,nc=col;
	         String sep="";
	         if(col==tq-1){
	             nr=row+1;
	             nc=0;
	             sep="\n";
	         }else {
	             nr=row;
	             nc=col+1;
	             sep="\t";
	         }
	         for(int i=0;i<queens.length;i++){
	             if(!queens[i]){
	                 queens[i]=true;
	                 queensPermutations(qpsf+1,tq,nr,nc,asf+"q"+(i+1)+sep,queens);
	                 queens[i]=false;
	             }
	         }
	         queensPermutations(qpsf,tq,nr,nc,asf+"-"+sep,queens);

	    }

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        if(qpsf==tq){
             for(int i=0;i<chess.length;i++){
                 for(int j=0;j<chess[i].length;j++){
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
             for(int j=0;j<chess[i].length;j++){
                 if(chess[i][j]==0){
                     chess[i][j]=qpsf+1;
                     queensPermutations(qpsf+1,tq,chess);
                     chess[i][j]=0;
                 }
             }
         } 
     }
	public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
           if(row==tq) {
        	   if(qpsf==tq){
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
	       } else {
	           nr=row;
	           nc=col+1;
	           sep="";
	       }
	       queensCombinations(qpsf+1,tq,nr,nc,asf+"q"+sep); 

	       queensCombinations(qpsf,tq,nr,nc,asf+"-"+sep);

	    }
	 public static void combinations(int[] boxes, int ci, int ti, int lb){
	        if(ci>ti){
	            for(int i:boxes)
	                System.out.print((i>0?"i":"-"));
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
	  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){
		    if(cb>tb){
		        if(ssf==ts){
		            System.out.println(asf);
		        }
		        return;
		    } 
		    for(int i=0;i<items.length;i++){
		        if(items[i]==0){
		            items[i]=(i+1);
		           permutations(cb+1,tb,items,ssf+1,ts,asf+(i+1)); 
		           items[i]=0;
		        }
		    }
		    permutations(cb+1,tb,items,ssf,ts,asf+"0");

		  }
	
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
	  public static void permutations(int[] boxes, int ci, int ti){
		    if(ci>ti){
		        for(int i:boxes)
		            System.out.print(i);
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
	static int mindiff = Integer.MAX_VALUE;
	static String ans = "";

	public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1,
			int soset2) {
	    if(vidx==arr.length){
	        if(mindiff>Math.abs(soset1-soset2)){
	        	mindiff=Math.abs(soset1-soset2);
	            ans=set1+"-"+set2;
	        }
	 
	        return;
	    }
		
        if(set1.size()<(arr.length+1)/2){
            set1.add(arr[vidx]);
            solve(arr,vidx+1,set1,set2,soset1+arr[vidx],soset2);
            set1.remove(set1.size()-1);
        }
        
         if(set2.size()<(arr.length+1)/2){
            set2.add(arr[vidx]);
            solve(arr,vidx+1,set1,set2,soset1,soset2+arr[vidx]);
            set2.remove(set2.size()-1);
        }
	}
	static String max;
	public static void findMaximum(String str, int k) {
	    if(Integer.parseInt(max)<Integer.parseInt(str))
	        max=str;
	    if(k==0)return;
	    for(int i=0;i<str.length();i++){
	        for(int j=i+1;j<str.length();j++){
	            String swapped=swap(str,i,j);
	            findMaximum(swapped,k-1);
	        }
	    }
	    
		
	}
	
	public static String swap(String s,int i,int j){
	    String left=s.substring(0,i);
	    String middle=s.substring(i+1,j);
	    String right=s.substring(j+1);
	    return left+s.charAt(j)+middle+s.charAt(i)+right;
	}
	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		if(minRemoval==0){
		    if(getMin(str)==0)
		        System.out.println(str);
		    return;
		}
		for(int i=0;i<str.length();i++){
		   String left=str.substring(0,i); 
		   String right=str.substring(i+1);
		   if(minRemoval>0){
		       solution(left+right,minRemoval-1,ans);
		   }
		}
	}

	public static int getMin(String str){
	    Stack<Character> st=new Stack<>();
	    for(char ch:str.toCharArray()){
	      if(ch=='(')
	            st.push(ch); 
	       else {
	           if(st.isEmpty())st.push(ch);
	           else if(st.peek()==')')st.push(ch);
	           else if(st.peek()=='(')st.pop();
	       }
	    }
		return st.size();
	}
	public static void wordBreak(String str, String ans, HashSet<String> dict){
		if(str.isEmpty()){
		    System.out.println(ans);
		    return;
		} 
		
		for(int i=0;i<str.length();i++){
		    String left=str.substring(0,i+1);
		    String right=str.substring(i+1);
		    if(dict.contains(left)){
		        dict.remove(left);
		        wordBreak(right,ans+left+" ",dict);
		        dict.add(left);
		    }
		    
		}
	}
	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
        if(pattern.length()==0){
        	if(str.length()==0){
            for(char ch:op.toCharArray()){
                if(map.containsKey(ch))
                    System.out.print(ch+"-> "+map.get(ch)+"  ");
            }
        	}
            return;
        }
        char pch=pattern.charAt(0);
        String rop=pattern.substring(1);
        if(map.containsKey(pch)){
            String existingPattern=map.get(pch);
            if(str.length()>=existingPattern.length()){
            	String left=str.substring(0,existingPattern.length());
				String right=str.substring(existingPattern.length());
				if(existingPattern.equals(left))
					solution(right,rop,map,op);
            } 
        }else {
            for(int i=0;i<str.length();i++){
                String prefix=str.substring(0,i+1);
                String ros=str.substring(i+1);
                map.put(pch,prefix);
                solution(ros,rop,map,op);
                map.remove(pch);
            }
            
        }
	}
	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) {
		if(vidx==arr.length){
		    if(ssssf==k){
		    	int first=subsetSum[0];
		    	boolean flag=true;
		    	for(int i=1;i<subsetSum.length;i++) {
		    		if(first!=subsetSum[i])flag=false; 
		    	}
		    	if(flag) 
		        System.out.println(ans);
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
		    }else {
		        ans.get(i).add(arr[vidx]);
		        subsetSum[i]+=arr[vidx];
		        solution(arr,vidx+1,n,k,subsetSum,ssssf+1,ans);
		        ans.get(i).remove(ans.get(i).size()-1);
		        subsetSum[i]-=arr[vidx];
		        break;
		    }
		}
	}
	
	public static void solution(String str, String asf) {
	    if(str.isEmpty()){
	        System.out.println(asf);
	        return;
	    }
	    for(int i=0;i<str.length();i++){
	        String prefix=str.substring(0,i+1);
	        if(isPalindrom(prefix)){
		        String ros=str.substring(i+1);
	            solution(ros,asf+"("+prefix+")");
	        }
	    }	
	}
	
	public static boolean isPalindrom(String s){
	    int i=0,j=s.length()-1;
	    while(i<j){
	        if(s.charAt(i++)!=s.charAt(j--))return false;
	    }
	    return true;
	}
	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if(cs>ts){
            String rev="";
            for(int i=asf.length()-1;i>=0;i--)
                rev+=asf.charAt(i);
            if(oddc!=null)
                asf+=oddc;
            asf+=rev;
            System.out.println(asf);
            return;
        }
	
	    for(char ch:fmap.keySet()){
	          if(fmap.get(ch)>0){
	              fmap.put(ch,fmap.get(ch)-1);
	              generatepw(cs+1,ts,fmap,oddc,asf+ch);
	              fmap.put(ch,fmap.get(ch)+1);
	          }
	    }
}

	
	 	static int count=1;
		public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
			if(i>n){
				if(rssf==k) {
					 System.out.print(count+".");
					    for(ArrayList<Integer> list:ans)
					        System.out.print(list);
					    System.out.println();
					    count++;
				}
			    return;
			}
			for(int j=0;j<k;j++){
			    if(ans.get(j).size()>0){
			        ans.get(j).add(i);
			        solution(i+1,n,k,rssf,ans);
			        ans.get(j).remove(ans.get(j).size()-1);
			    }else {
			        ans.get(j).add(i);
			        solution(i+1,n,k,rssf+1,ans);
			        ans.get(j).remove(ans.get(j).size()-1);
			        break;
			    }
			} 
		}
		
	public static void solution(int i, int n, boolean[] used, String asf) {
	    if(i>n){
	        System.out.println(counter+"."+asf);
	        counter++;
	        return;
	    }
	    if(used[i]==true)
	    	solution(i+1, n,used,asf);
	    else {
	        used[i]=true;
	        solution(i+1,n,used,asf+"("+i+")");
	    
	    
	    for(int j=i+1;j<=n;j++){
	        if(used[j]==false){
	            used[j]=true;
	            solution(i+1,n,used,asf+"("+i+","+j+")");
	            used[j]=false;
	        }
	    }
        used[i]=false;
	    }

	  }
	
	public static void solution(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNumbers,
			String s1, String s2, String s3) {
		if (idx == unique.length()) {
			int sum1 = getSum(s1, charIntMap);
			int sum2 = getSum(s2, charIntMap);
			int sum3 = getSum(s3, charIntMap);
			if ((sum1 + sum2) == sum3) {
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
			if (!usedNumbers[i]) {
				usedNumbers[i] = true;
				charIntMap.put(ch, i);
				solution(unique, idx + 1, charIntMap, usedNumbers, s1, s2, s3);
				usedNumbers[i] = false;
				charIntMap.put(ch, -1);

			}
		}

	}

	public static int getSum(String s, HashMap<Character, Integer> map) {
		String sum="";
		for (char ch : s.toCharArray()) {
			sum += map.get(ch);
		}
		return Integer.parseInt(sum);
	}
	 public static void solution(char[][] arr, String[] words, int vidx) {
		    if(vidx==words.length){
		        print(arr);
		        return;
		    }
		    String word=words[vidx];
		    for(int i=0;i<arr.length;i++){
		        for(int j=0;j<arr[0].length;j++){
		            if(arr[i][j]=='-' || arr[i][j]==word.charAt(0)){
		                if(canPlaceHorizontally(arr,i,j,word)){
		                    boolean wePlaced[]=placeHorizontally(arr,i,j,word);
		                    solution(arr,words,vidx+1);
		                    unplaceHorizontally(arr,i,j,wePlaced);
		                }
		                 if(canPlaceVertically(arr,i,j,word)){
		                    boolean wePlaced[]=placeVertically(arr,i,j,word);
		                    solution(arr,words,vidx+1);
		                    unplaceVertically(arr,i,j,wePlaced);
		                }
		            }
		        }
		    }
		  }
		  
		  public static boolean canPlaceHorizontally(char [][] grid,int i,int j,String word){
		      if(j-1>=0 && grid[i][j-1]!='+')return false;
		      if(j+word.length()<grid[0].length && grid[i][j+word.length()]!='+')return false;
		      for(int jj=0;jj<word.length();jj++){
		          if(j+jj>=grid[0].length)return false;
		          if(grid[i][j+jj]=='-' || grid[i][j+jj]==word.charAt(jj))continue;
		          else return false;
		      }
		      return true;
		  }
		  
		  public static boolean [] placeHorizontally(char [][] grid,int i,int j,String word){
		      boolean []wePlace=new boolean[word.length()];
		      for(int jj=0;jj<word.length();jj++){
		          if(grid[i][j+jj]=='-'){
		              wePlace[jj]=true;
		              grid[i][j+jj]=word.charAt(jj);
		          }
		      }
		      return wePlace;
		  }
		  
		  public static void unplaceHorizontally(char [][]grid,int i,int j,boolean wePlaced[]){
		      for(int jj=0;jj<wePlaced.length;jj++){
		          if(wePlaced[jj])
		                grid[i][j+jj]='-';
		      }
		  }
		  
		   public static boolean canPlaceVertically(char [][] grid,int i,int j,String word){
		      if(i-1>=0 && grid[i-1][j]!='+')return false;
		      if(i+word.length()<grid.length && grid[i+word.length()][j]!='+')return false;
		      for(int ii=0;ii<word.length();ii++){
		          if(i+ii>=grid.length)return false;
		          if(grid[i+ii][j]=='-' || grid[i+ii][j]==word.charAt(ii))continue;
		          else return false;
		      }
		      return true;
		  }
		  
		  public static boolean [] placeVertically(char [][] grid,int i,int j,String word){
		      boolean []wePlace=new boolean[word.length()];
		      for(int ii=0;ii<word.length();ii++){
		          if(grid[i+ii][j]=='-'){
		              wePlace[ii]=true;
		              grid[i+ii][j]=word.charAt(ii);
		          }
		      }
		      return wePlace;
		  }
		  
		  public static void unplaceVertically(char [][]grid,int i,int j,boolean wePlaced[]){
		      for(int ii=0;ii<wePlaced.length;ii++){
		          if(wePlaced[ii])
		                grid[i+ii][j]='-';
		      }
		  }


		  public static void print(char[][] arr) {
		    for (int i = 0 ; i < arr.length; i++) {
		      for (int j = 0 ; j < arr.length; j++) {
		        System.out.print(arr[i][j]);
		      }
		      System.out.println();
		    }

		  }
	
	  public static void display(int[][] board){
		    for(int i = 0; i < board.length; i++){
		      for(int j = 0; j < board[0].length; j++){
		        System.out.print(board[i][j] + " ");
		      }
		      System.out.println();
		    }
		  }

		  public static void solveSudoku(int[][] board, int i, int j) {
		    if(i==board.length){
		        display(board);
		        return;
		    }
		   
		     int nr=0;
		     int nc=0;
		     if(j==board.length-1){
		         nr=i+1;
		         nc=0;
		     }else {
		         nr=i;
		         nc=j+1;
		     }
		     if(board[i][j]>0){
		         solveSudoku(board,nr,nc);
		     }else {
		         for(int po=1;po<10;po++){
		             if(isPossible(board,i,j,po)){
		                 board[i][j]=po;
		                 solveSudoku(board,nr,nc);
		                 board[i][j]=0;
		             }
		         }
		     }
		  }
		  public static boolean isPossible(int[][] board,int r,int c,int po){
		      for(int j=0;j<board[0].length;j++){
		          if(board[r][j]==po)return false;
		      }
		      for(int i=0;i<board.length;i++){
		          if(board[i][c]==po)return false;
		      }
		      int smi=(r/3)*3;
		      int smj=(c/3)*3;
		      for(int ii=0;ii<3;ii++){
		          for(int jj=0;jj<3;jj++){
		              if(board[smi+ii][smj+jj]==po)return false;
		          }
		      }
		      return true;
		  }
	public static int dfs(int [][]grid,int r,int c){
	    if(r<0 || c<0 || r>=grid.length | c>=grid[0].length || grid[r][c]==0)return 0;
	    int gold=grid[r][c];
	    grid[r][c]=0;
	    int maxOne=Math.max(dfs(grid,r+1,c),dfs(grid,r-1,c));
	    int maxTwo=Math.max(dfs(grid,r,c+1),dfs(grid,r,c-1));
	    grid[r][c]=gold;
        return Math.max(maxOne,maxTwo)+gold;
	}
	
	public static void solve(int i,int n){
	    if(i>n)return; 
	    System.out.println(i);
	    for(int j=0;j<10;j++){
	        solve(i*10+j,n);
	    }
	}
	  public static int solution(int n, int k){
		    if(n==1)return 0;
		    int i=solution(n-1,k);
		    i=(i+k)%n;
		    return i;
		  }
	
	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		if(idx==words.length){
		    
		    return 0;
		}
		String word=words[idx];
		int sno=0+solution(words,farr,score,idx+1);
		int yscore=0;
		boolean flag=true;
		for(int i=0;i<word.length();i++){
		    char ch=word.charAt(i);
		    farr[ch-'a']--;
		    if(farr[ch-'a']<0)
		        flag=false;
		    yscore+=score[ch-'a'];
		}
		int yno=0;
		if(flag)
		    yno=yscore+solution(words,farr,score,idx+1);
	    for(int i=0;i<word.length();i++){
		    char ch=word.charAt(i);
		    farr[ch-'a']++;
		}
		return Math.max(sno,yno);
	}
		  
		  
		  public static void solve(boolean [][]board,int r,boolean [] col,boolean []ndia,boolean rdia[]){
		      if(r==board.length){
		          for(int i=0;i<board.length;i++){
		              for(int j=0;j<board.length;j++){
		                  if(board[i][j])
		                        System.out.print(i+"-"+j+",");
		                   
		              }
		          }
	              System.out.println(".");

		          return;
		      } 
		      
		      for(int c=0;c<board.length;c++){
		          if(!col[c] && !ndia[r+c] && !rdia[r-c+board.length-1]){
		              col[c]=true;
		              ndia[r+c]=true;
		              rdia[r-c+board.length-1]=true;
		              board[r][c]=true;
		              solve(board,r+1,col,ndia,rdia);
		              col[c]=false;
		              ndia[r+c]=false;
		              rdia[r-c+board.length-1]=false;
		              board[r][c]=false;

		          }
		      }
		  }
	  public static void solution(String str, String asf,int count, int pos){
	        if(pos==str.length()){
	            if(count>0)
	                asf+=count;
	            System.out.println(asf);
	            return;
	        }
	        
	        char ch=str.charAt(pos);
	        if(count>0)
	            solution(str,asf+count+ch,0,pos+1);
	        else 
	            solution(str,asf+ch,count,pos+1);
	        solution(str,asf,count+1,pos+1);



	    }
	
	 public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
	        
	        if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]!=0)return;
	        if(upcomingMove==chess.length*chess.length){
	            chess[r][c]=upcomingMove;
	            displayBoard(chess);
	            chess[r][c]=0;
	        }
	        
	        chess[r][c]=upcomingMove;
	  
	        printKnightsTour(chess,r-2,c+1,upcomingMove+1);
	        printKnightsTour(chess,r-1,c+2,upcomingMove+1);
	        printKnightsTour(chess,r+1,c+2,upcomingMove+1);
	        printKnightsTour(chess,r+2,c+1,upcomingMove+1);
	        printKnightsTour(chess,r+2,c-1,upcomingMove+1);
	        printKnightsTour(chess,r+1,c-2,upcomingMove+1);
	        printKnightsTour(chess,r-1,c-2,upcomingMove+1);
	        printKnightsTour(chess,r-2,c-1,upcomingMove+1);
	        chess[r][c]=0;

	    }

	    public static void displayBoard(int[][] chess){
	        for(int i = 0; i < chess.length; i++){
	            for(int j = 0; j < chess[0].length; j++){
	                System.out.print(chess[i][j] + " ");
	            }
	            System.out.println();
	        }

	        System.out.println();
	    }
	
	 public static void printNQueens(int[][] chess, String qsf, int row) {
	        if(row==chess.length){
	            System.out.println(qsf+". ");
	            return;
	        }
	        for(int col=0;col<chess.length;col++){
	            if(isSafe(chess,row,col)){
	                chess[row][col]=1;
	                printNQueens(chess,qsf+row+"-"+col+", ",row+1);
	                chess[row][col]=0;
	            }
	        }
	        
	    }
	    
	    public static boolean isSafe(int chess[][],int r,int c){
	        
	        for(int i=r,j=c;j>=0;j--){
	            if(chess[i][j]==1)return false;
	        }
	         for(int i=r,j=c;i>=0 && j>=0;i--,j--){
	            if(chess[i][j]==1)return false;
	        }
	         for(int i=r,j=c;i>=0;i--){
	            if(chess[i][j]==1)return false;
	        }
	         for(int i=r,j=c;i>=0 && j<chess.length;i--,j++){
	            if(chess[i][j]==1)return false;
	        }
	        return true;
	    }
	
	 public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
	        if(idx==arr.length){
	            if(sos==tar)
	                System.out.println(set+".");
	            return;
	        }
	        
	        printTargetSumSubsets(arr,idx+1,set+arr[idx]+", ",sos+arr[idx],tar);
	        printTargetSumSubsets(arr,idx+1,set,sos,tar);

	        
	    }

	
	  public static void floodfill(int[][] maze, int r, int c, String asf) {
	        if(r<0 || c<0 || r>=maze.length || c>=maze[r].length || maze[r][c]==1)return;
	        if(r==maze.length-1 && c==maze[0].length-1){
	            System.out.println(asf);
	            return;
	        }
	        maze[r][c]=1;
	        floodfill(maze,r,c+1,asf+"r"); 
	        floodfill(maze,r+1,c,asf+"d"); 
	        floodfill(maze,r-1,c,asf+"t"); 
	        floodfill(maze,r,c-1,asf+"l"); 
	        maze[r][c]=0;
	    }
    public static void printPermutations(String str, String asf) {
        if(str.isEmpty()){
            System.out.println(asf);
            return;
        }
        
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String ros=str.substring(0,i)+str.substring(i+1);
            printPermutations(ros,asf+ch);
        }
        
    }
	 public static void printMazePaths3(int sr, int sc, int dr, int dc, String psf) {
	        if(sc==dc && sr==dr){
	            System.out.println(psf);
	            return;
	        }
	        
	        for(int mv=1;mv<=dc-sc;mv++){
	        	printMazePaths3(sr,sc+mv,dr,dc,psf+"h"+mv);
	        }
	        for(int mv=1;mv<=dr-sr;mv++){
	        	printMazePaths3(sr+mv,sc,dr,dc,psf+"v"+mv);
	        }
	         for(int mv=1;mv<=dc-sc && mv<=dr-sr;mv++){
	        	 printMazePaths3(sr+mv,sc+mv,dr,dc,psf+"d"+mv);
	        }
	        
	    }
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(dr==sr && dc==sc){
            System.out.println(psf);
            return;
        }
        if(sc>dr || sr>dc)return;
        
        printMazePaths(sr,sc+1,dr,dc,psf+"h");
        printMazePaths(sr+1,sc,dr,dc,psf+"v");

    }
	
	  public static void printStairPaths(int n, String path) {
	        if(n==0){
	            System.out.println(path);
	            return;
	        }
	        if(n<0)return;
	        
	        printStairPaths(n-1,path+1);
	        printStairPaths(n-2,path+2);
	        printStairPaths(n-3,path+3);

	    }
    public static void printKPC(String str, String asf) {
        if(str.isEmpty()){
            System.out.println(asf);
            return;
        }
        
        for(char ch:codes[str.charAt(0)-'0'].toCharArray()){
            printKPC(str.substring(1),asf+ch);
        }
         
     } 
	  public static void printSS(String str, String ans) {
	        if(str.isEmpty()){
	            System.out.println(ans);
	            return;
	        }
	        printSS(str.substring(1),ans+str.charAt(0));
	        printSS(str.substring(1),ans);
	    }
	
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		if (sr > dr || sc > dc)
			return new ArrayList<>();
		if (sr == dr && sc == dc) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		ArrayList<String> res = new ArrayList<>();
		for (int mv = 1; mv <= dc - sc; mv++) {
			ArrayList<String> hres = getMazePaths(sr, sc + mv, dr, dc);
			for (String s : hres)
				res.add("h" + mv + s);
		}

		for (int mv = 1; mv <= dr - sr; mv++) {
			ArrayList<String> vres = getMazePaths(sr + mv, sc, dr, dc);
			for (String s : vres)
				res.add("v" + mv + s);
		}
		for (int mv = 1; mv <= dc - sc && mv <= dr - sr; mv++) {
			ArrayList<String> dres = getMazePaths(sr+mv, sc + mv, dr, dc);
			for (String s : dres)
				res.add("d" + mv + s);
		}
		return res;
	}

    public static ArrayList<String> getMazePaths1(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc){
            ArrayList<String> res=new ArrayList<>();
            res.add("");
            return res;
        }
        if(sr>dr || sc>dc)return new ArrayList<>();
        
        ArrayList<String> hres=getMazePaths1(sr,sc+1,dr,dc);
        ArrayList<String> vres=getMazePaths1(sr+1,sc,dr,dc);
        ArrayList<String> res=new ArrayList<>();
        for(String s:hres)
            res.add("h"+s);
        for(String s:vres)
            res.add("v"+s);
        return res;
    }
	
	public static ArrayList<String> getStairPaths(int n) {
        if(n==0){
            ArrayList<String> res=new ArrayList<>();
            res.add("");
            return res;
        }
        if(n<0)return new ArrayList<>();
        ArrayList<String> one=getStairPaths(n-1);
        ArrayList<String> two=getStairPaths(n-2);
        ArrayList<String> three=getStairPaths(n-3);
        ArrayList<String> res=new ArrayList<>();
        for(String s:one)
            res.add('1'+s);
        for(String s:two)
            res.add('2'+s);
        for(String s:three)
            res.add('3'+s);
        return res;
    }
	
	
	public static String[] codes = {"","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};


    public static ArrayList<String> getKPC(String str) {
        if(str.isEmpty()){
            ArrayList<String> res=new ArrayList<>();
            res.add("");
            return res;
        }
        
        ArrayList<String> mres=getKPC(str.substring(1));
        ArrayList<String> res=new ArrayList<>();
       
            for(char ch:codes[str.charAt(0)-'0'].toCharArray()){
            	 for(String s:mres){
                res.add(ch+s);
            }
        }
        return res;
    }
	 public static ArrayList<String> gss(String str) {
	        if(str.length()==0){
	            ArrayList<String> res=new ArrayList<>();
	            res.add("");
	            return res;
	        }
	        char ch=str.charAt(0);
	        ArrayList<String> mres=gss(str.substring(1));
	        ArrayList<String> res=new ArrayList<>(mres);
	        for(String s:mres)
	            res.add(ch+s);
	        return res;
	    }

}
