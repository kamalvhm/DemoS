package com.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.cleanup.Utils;

import scala.Array;
import com.dp.BooleanParenthesization;

/** ##{@link #MatrixChainMultiplication()}
 * 1)MCM ##{@link #solveMCM()}
 * 2)Printing MCM 
 * 3)Evaluate Expression to true / boolean parenthesization
 * 4)Min/Max value of an Expr.
 * 5)Palindrom Partitioning |132. Palindrome Partitioning II, https://leetcode.com/problems/palindrome-partitioning-ii/
 * 6)Scramble String | 87. Scramble String https://leetcode.com/problems/scramble-string/
 * 7)Egg Dropping Problem |887. Super Egg Drop https://leetcode.com/problems/super-egg-drop/
 * ---------------------------GENERAL FORMAT CODE------------------
 * 	int solveMCM(int[] arr, int i, int j) {
		if (i > j)return 0;
		int finalAns;
		for (int k = i; k < j; k++) {
			// calculate Temp ans
			int tempAns = solveMCM(arr, i, k) + solveMCM(arr, k + 1, j);
			finalAns = fun(tempAns);// Apply some fun on temp and compute (Min/MAx)
		}
		return finalAns;
	}
	###########ANS#############
1)MCM ans 26000
5)Palindrom Partitioning ans:- 4
3)Evaluate Expression to true ans:- 2
6)Scramble String ans:- true
7)Egg Dropping Problem ans:- 3
 *
 */

public class Dpractice4 extends DynamicPrograming{
	static int dp[][]=new int [100][100];//size depends on max constraints 
	static int p[][]=new int [100][100];
	static int egg[][]=new int [100][100];

	static {for(int []t:dp)
			Arrays.fill(t, -1);
			for(int []t:p)
				Arrays.fill(t, -1);
			for(int []t:egg)
				Arrays.fill(t, -1);}
	
	static Map<String,Integer> map=new HashMap<>(); 
    private static final String EMPTY_STRING = "";
    
	static Map<String,Boolean> scramblemap=new HashMap<>(); 


	public static void main(String[] args) {
			//We are given a array which contains a matrix dimension we have to return minimum cost(multiplication) of these matrix 
			//for example if we have A1,A2,A3,A4 one we can (A1*A2)*(A3*A4) like that we have other option out of which minimum cost 
			//we have to return [to multiple any matrix of a*b and c*d we must have b==c]
			//Dimension Ai=arr[i-1]*arr[i]; 
			int arr[] = {40,20,30,10,30}; //These are dimensions of 4 matrix (size-1) for example for a1 matrix dimension will be 40*20
			
			//Step 1 find i& j :select i and j (usually i at left end and j at right ) so we can select i at 0 position because then dimension will require -1
			//so i is 1 and j =size-1;
			System.out.println("1)MCM ans "+solveMCM_BottomUp(arr,1,arr.length-1));
			
			String s="coder"; //PS:-we are given a string we need to partition it such that all resultant Strings are palindrom and minimize no. of partion
			System.out.println("5)Palindrom Partitioning ans:- "+palindrom_partitioningBottomUpOptimized(s,0,s.length()-1)); //in this case we can place i at 0 because no dimetios are here 
			String s1="T^F&T";
			//PS:-Input String given Output -No. of ways it eval to true, add bracket to string such that it evaluate to true  eg: ((T^F)&T) 
			//String may consist of T=True ,F=False, | =Or, & =And ,^=XOR
			System.out.println("3)Evaluate Expression to true ans:- "+evalExTBottomUp(s1,0,s1.length()-1,true)); 
			String a="great",b="rgeat"; //two String given you can create binary tree and swap non leaf nodes child if by doing this its equal to secound string it return true else false
			System.out.println("6)Scramble String ans:- "+scrambledStringRecursie(a,b)); 
			int eggs=3,floor=5; //IP:-Eggs and floor given we need to identify threshold floor from which if we throw egg it will not break 
			//we have to apply best technique in worst case to minimize no of attempts to find threshold floor
			System.out.println("7)Egg Dropping Problem ans:- "+eggDropMemoizedOptimized(eggs,floor)); 

	}

	//https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34
	public static int solveMCM(int arr[],int i,int j) {
		if(i>=j)return 0;
		int min =Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int temp=solveMCM(arr, i, k)+solveMCM(arr, k+1, j)+arr[i-1]*arr[k]*arr[j];
			
			min =Math.min(temp, min);
		}
		return min;
	}
	
	public static int solveMCM_BottomUp(int arr[],int i,int j) {
		if(i>=j)return 0;
		if(dp[i][j]!=-1)return dp[i][j];
		int min =Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int temp=solveMCM(arr, i, k)+solveMCM(arr, k+1, j)+arr[i-1]*arr[k]*arr[j];
			
			min =Math.min(temp, min);
		}
		return dp[i][j]=min;
	}

	private static int palindrom_partitioning_recursive(String s, int i, int j) {
		if(i>=j)return 0;
		if(isPalindrom(s,i,j))return 0;
		int min=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int temp =palindrom_partitioning_recursive(s,i,k) +palindrom_partitioning_recursive(s,k+1,j)+1;
			min =Math.max(min, temp);
			
		}
		return min;
	}

	private static boolean isPalindrom(String s, int i, int j) {
		if(i==j)return true;
		if(i>j)return false;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	//V-37
	private static int palindrom_partitioningBottomUp(String s, int i, int j) {
		if(i>=j)return 0;
		if(isPalindrom(s,i,j))return 0;
		if(p[i][j]!=-1)return p[i][j];
		int min=Integer.MAX_VALUE;
		for(int k=i;k<j;k++) {
			int temp =palindrom_partitioning_recursive(s,i,k) +palindrom_partitioning_recursive(s,k+1,j)+1;
			min =Math.max(min, temp);
			
		}
		return p[i][j]= min;
	}
	//CHECK PROBLEM SOLUTION IN PARENT CLASS
	//V-38 To optimize further we can check "palindrom_partitioningBottomUp(s,i,k)+palindrom_partitioningBottomUp(s, k+1, j);" function in the matrix 
	private static int palindrom_partitioningBottomUpOptimized(String s, int i, int j) {
		if(i>=j)return 0; //if single char then no partion needed
		if(Utils.isPalindrom(s,i,j))return 0; //if already palindrom then also no partion needed
		if(p[i][j]!=-1)return p[i][j]; //CHANGE 1
		int ans=Integer.MAX_VALUE;
		for(int k=i;k<=j-1;k++) {
			
			int left=0;   //check left and right first in the table if not exist then hit and put it in table
			if(p[i][k]!=-1)
				left=p[i][k];
			else {
				left=palindrom_partitioningBottomUp(s,i,k);
				p[i][k]=left;
			}
			
			int right=0;
			if(p[k+1][j]!=-1)
				right=p[k+1][j];
			else {
				right=palindrom_partitioningBottomUp(s, k+1, j);
				p[k+1][j]=right;
			}
			
			int temp=1+left+right; 
			
			ans=Math.min(ans, temp);
		}
		//CHANGE 2
		return p[i][j]=ans;
	}
	/**V-39 (CHECK ##BooleanParenthesization()) :-https://www.youtube.com/watch?v=pGVguAcWX4g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=39
	 * 
	 */
	public static int evalExTRecursive(String s ,int i,int j,boolean isTrue) {
		 if(i>j)return 0; //if its empty string 
		 if(i==j) { //is i and j at same char 
			 if(isTrue)  //if we are looking for true
				 return s.charAt(i) == 'T' ? 1 : 0; //if we isTrue(we are looking for true) and character at i is also true then return true else false; 
			 else  return s.charAt(i)== 'F' ? 1 : 0;
		 }
		 int ans=0;
		 //looping k from i+1 to j-1 with increament k+2 as k will be at any operator any time and i and j will be at T or F;
		 for(int k=i+1;k<j;k += 2) {
			 int leftTrue=evalExTRecursive(s,i,k-1,true); //This will return no. of ways we get left expression as true
			 int leftfalse=evalExTRecursive(s,i,k-1,false); //This will return no. of ways we get left expression as false
			 int rightTrue=evalExTRecursive(s,k+1,j,true);
			 int rightFalse=evalExTRecursive(s,k+1,j,false);
			 char c=s.charAt(k);
			 if(c=='&') { //now add ans according to operator
				 if(isTrue)
					 ans+=leftTrue*rightTrue;
				 else
					 ans+=leftTrue*rightFalse + leftfalse*rightTrue + leftfalse*rightFalse;
			 }
			 else if(c=='|') {
				 if(isTrue)
					 ans+=leftTrue*rightTrue + leftTrue*rightFalse + leftfalse*rightTrue;
				 else
					 ans+=leftfalse*rightFalse;
			 }
			 else if(c=='^') {
				 if(isTrue)
					 ans+=leftTrue*rightFalse + leftfalse*rightTrue;
				 else
					 ans+=leftTrue*rightTrue + leftfalse*rightFalse;
			 }

		 }
		 return ans;
	} 
	
	public static int evalExTBottomUp(String s ,int i,int j,boolean isTrue) {
		String key=EMPTY_STRING+i+j+isTrue;//Making a key for map with i j and isTrue
		 if(i>j) {
			  map.put(key, 0); //CHANGE
			 return 0; }
		 if(i==j) { 
			 if(isTrue)  {
				 map.put(key, s.charAt(i) == 'T' ? 1 : 0); //CHANGE
				 return s.charAt(i) == 'T' ? 1 : 0; 
			 }
				 
			 else {
				 map.put(key, s.charAt(i) == 'F' ? 1 : 0); //CHANGE
				 return s.charAt(i)== 'F' ? 1 : 0;
			 } 
		 }
		 int ans=0;
		 for(int k=i+1;k<j;k += 2) {
			 	String partialLeftKeyTrue = EMPTY_STRING + i + (k - 1) + "true";  //CHANGE
	            String partialLeftKeyFalse = EMPTY_STRING + i + (k - 1) + "false";
	            String partialRightKeyTrue = EMPTY_STRING + (k + 1) + j + "true";
	            String partialRightKeyFalse = EMPTY_STRING + (k + 1) + j + "false";
			 
			 int leftTrue=map.containsKey(partialLeftKeyTrue) ? map.get(partialLeftKeyTrue) :evalExTRecursive(s,i,k-1,true);//3 variable changing i ,j and isTrue
			 int leftfalse=map.containsKey(partialLeftKeyFalse) ? map.get(partialLeftKeyFalse) :evalExTRecursive(s,i,k-1,false); 
			 int rightTrue=map.containsKey(partialRightKeyTrue) ? map.get(partialRightKeyTrue) :evalExTRecursive(s,k+1,j,true);
			 int rightFalse=map.containsKey(partialRightKeyFalse) ? map.get(partialRightKeyFalse) :evalExTRecursive(s,k+1,j,false); //CHANGE
			 
			 char c=s.charAt(k);
			 if(c=='&') { 
				 if(isTrue)
					 ans+=leftTrue*rightTrue;
				 else
					 ans+=leftTrue*rightFalse + leftfalse*rightTrue + leftfalse*rightFalse;
			 }
			 else if(c=='|') {
				 if(isTrue)
					 ans+=leftTrue*rightTrue + leftTrue*rightFalse + leftfalse*rightTrue;
				 else
					 ans+=leftfalse*rightFalse;
			 }
			 else if(c=='^') {
				 if(isTrue)
					 ans+=leftTrue*rightFalse + leftfalse*rightTrue;
				 else
					 ans+=leftTrue*rightTrue + leftfalse*rightFalse;
			 }

		 }
	      map.put(key, ans); //CHANGE
		 return ans;
	} 
	
	public static boolean scrambledStringRecursie(String a ,String b) {
		if(a.length()!=b.length()) return false;
		if(a.isEmpty() && b.isEmpty())return true;
		 return scrambledMemoized(a,b);
		//return scrambledSolve(a,b);
	} 
	
	public static boolean scrambledSolve(String a ,String b) {
		if(a.compareTo(b)==0)return true;//This mean there is 0 swap in string and both are equal a&b
		if(a.length()<=1)return false;//if both are not equal above ,if Empty String is there in any a or b then return false
		int n=a.length();//both are equal by now
		boolean flag=false;
		for(int i=1;i<=n-1;i++) {
			if(scrambledSolve(a.substring(0, i), b.substring(n - i, n))  //Condition 1 where there is swapping
					&& scrambledSolve(a.substring(i, n), b.substring(0, n - i)) || 
							scrambledSolve(a.substring(0,i),b.substring(0,i)) //Condition 2 where No swapping
							&& scrambledSolve(a.substring(i,n),b.substring(i,n))) {
				flag=true;
				break;
			}
		}
		 return flag;
	} 
	
	 public static boolean scrambledMemoized(String a, String b) {
	        String key =a+"-"+b;
	        if (a.compareTo(b) == 0) return true;
	        int n = a.length();
	        if (scramblemap.containsKey(key)) {
	             return scramblemap.get(key);
	        }
	        if (n <= 1) return false;
	        for (int i = 1; i < n; i++) {
	           
	           if( scrambledMemoized(a.substring(0, i), b.substring(n - i, n)) //n - i is because we need to compare same count for both if 2 chars left then 2 chars right
	                && scrambledMemoized(a.substring(i, n), b.substring(0, n - i)) ||
	              scrambledMemoized(a.substring(0, i), b.substring(0, i)) 
	                && scrambledMemoized(a.substring(i, n), b.substring(i, n)))
	            {
	                scramblemap.put(key, true);
	                return true;
	            }
	        }
	      
	        scramblemap.put(key, false);
	        return false;
	    }
	 
	 
		private static int eggDropRecursive(int e, int f) {
			if(f==0 || f==1)return f;//if no floor or single then attempts equal to floor
			if(e==1)return f; //if single egg then we start dropping from first floor until it breaks or f ;
			int min=Integer.MAX_VALUE;
			
			for(int k=1;k<=f;k++) {
				int temp=Math.max(eggDropRecursive(e-1, k-1),eggDropRecursive(e,f-k))+1;  //+1 is for one attempt over Max is because we need to select for worst case ,One condition for break and one for not
			
				min=Math.min(min, temp);
			}
			
			return min;
		}
		
		private static int eggDropMemoized(int e, int f) {
			if(f==0 || f==1)return f;
			if(e==1)return f; 
			if(egg[e][f]!=-1)return egg[e][f]; //Change 1
			
			int min=Integer.MAX_VALUE;
			
			for(int k=1;k<=f;k++) {
				int temp=Math.max(eggDropRecursive(e-1, k-1),eggDropRecursive(e,f-k))+1;  
			
				min=Math.min(min, temp);
			}
			egg[e][f]=min; //Change 2
			return min;
		}
		
		private static int eggDropMemoizedOptimized(int e, int f) {
			if(f==0 || f==1)return f;
			if(e==1)return f; 
			if(egg[e][f]!=-1)return egg[e][f]; //Change 1
			
			int min=Integer.MAX_VALUE;
			
			for(int k=1;k<=f;k++) {
				int breaks,intact;//here we are checking those two inner calls also in matrix 
				if(egg[e-1][k-1]!=-1)  
				{
					breaks=egg[e-1][k-1];
				} 
				else {
					breaks=eggDropRecursive(e-1, k-1);
					egg[e-1][k-1]=breaks;
				}
				if(egg[e][f-k]!=-1) 
				{
					intact=egg[e][f-k];
				} 
				else {
					intact=eggDropRecursive(e,f-k);
					egg[e][f-k]=intact;
				}
				int temp=Math.max(breaks,intact)+1;  
			
				min=Math.min(min, temp);
			}
			egg[e][f]=min; //Change 2
			return min;
		}
}
