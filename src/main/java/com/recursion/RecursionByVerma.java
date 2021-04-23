
package com.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class RecursionByVerma {
	//FIRST THINK IN TERMS OF DECISION IF NOT THEN GO FOR INPUT SMALL (IBH)
	//IF CHOICES/DECISION is clear go for Recursive Tree ,else go for IBH method
	public static void main(String[] args) {
	//1) Print 1 to N in reverse and normal
		print(10);
		System.out.println();

	//2) sort and array using recursion
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(3);
		list.add(1);
		System.out.println("2) BEFORE "+list);
		sortArraList(list);
		System.out.println("2) AFTER SORT LIST"+list);
	//3) Height of Tree
		/**@link RecurssionKthPathSumV5toV10.java*/
		
	//4)sort an stack
		Stack<Integer> st=new Stack<>();
		st.add(5);
		st.add(1);
		st.add(3);
		st.add(4);
		System.out.println("4) BEFORE "+st);
		sortStack(st);
		System.out.println("4) AFTER SORT STACK"+st);
	//5)sort an stack
		reverseStack(st);
		System.out.println("5) AFTER REVERSE STACK "+st);
	//6)delete in middle in stack
		deleteMiddleStack(st,2);
		System.out.println("6) AFTER DELETE MIDDLE STACK "+st);
	//7)Kth SYMBOL GRAMMER :- Two int given N,K generate grammer from this with below condition 1)if N=1 & K=1 then return 0 else to generate for N look for N-1 such that 
		//if  N-1 =0 then 01 if 1 then 10 ,you need to return digit in N Row and K col 
		System.out.println("7)Kth SYMBOL GRAMMER "+kthSymbolGrammer(4,6));
		
   //8)TOWER OF HANOI:-
		int numberOfDiskOnsource=3;
		//source ,helper ,destination
		String s="X", h="Y", d="Z";
		toh(numberOfDiskOnsource,s,d,h);
	    /****************************************IP-OP METHOD QUETIONS************************************************/
	//9)Print all subsets of inputString
		System.out.println("*****************SUBSETS*******************");
		subsets("ab","");
	//10)Print all subsets of inputString
		System.out.println("*****************UNIQUE SUBSETS*******************");
		HashSet<String> unique=new HashSet<>();
		uniqueSubsets("aab","",unique);
		System.out.println(unique);
	//11)Permutation with spaces :- in input a string given ABC so print all with space permutation
		System.out.println("*****************PERMUTATION WITH SPACES*******************");
		permutationwithSpaces("ABC","");
	//12)Permutation with CASE Change :- print with Capital and small combination
		System.out.println("*****************PERMUTATION WITH CASE CHANGE*******************");
		permutationwithCaseChange("AB","");
		System.out.println("*****************LETTER CASE PERMUTATION*******************");
	//13)LetterCase Combination:sae as above but digit also there in ip  
		letterPermutation("a1B2","");
		System.out.println("*****************BALANCE PARANTHESIS*******************");
	//14)Balance Parenthesis  
		balanceParanthesis(3,3,"");
		System.out.println("*****************N-bit Binary 1s>0s*******************");
	//15)N-bit Binary where 1s>0s in all its prefix :- A int n given for this in its binary representation print all prefix 1>0
		nBitBinary(3,0,0,"");
		System.out.println("*****************JOSEPHUS PROBLEM*******************");
	//16)Josephus Problem:- N is total peaple ,K is die index return last person | 1823. Find the Winner of the Circular Game
		ArrayList<Integer> totalPersons=new ArrayList<>();
		for(int i=1;i<=40;i++)
			totalPersons.add(i);
		int die=7;
		die=die-1;//array is zero base
		System.out.println("JOSEPHUS PROBLEM (24)ANS:- "+josephusProblem(totalPersons,die,0));
		
	}

	private static int josephusProblem(ArrayList<Integer> n, int k,int index) {
		if(n.size()==1) {
			return n.get(0);
		}
		index=(index+k)%n.size();
		n.remove(index);
		return josephusProblem(n, k, index);
	}

	private static void uniqueSubsets(String ip, String op,HashSet<String> unq) {
		if(ip.length()==0) {
			unq.add(op);
			return;
		}
		
		uniqueSubsets(ip.substring(1), op, unq);
		uniqueSubsets(ip.substring(1), op+ip.charAt(0), unq);
	}


	private static void sortArraList(ArrayList<Integer> list) {
		if(list.size()==1)return;
		int val=list.get(list.size()-1);
		list.remove(list.size()-1);
		sortArraList(list);
		insert(list,val);
	}
	
	public static void insert(ArrayList<Integer> list,int val) {
		if(list.isEmpty() || val>list.get(list.size()-1)) {
			list.add(val);
			return;
		}
		int temp=list.get(list.size()-1);
		list.remove(list.size()-1);
		insert(list, val);
		list.add(temp);
	}

	public static void print(int n) {
		if(n==0)
			return;
		print(n-1);
		System.out.print(n+" ");
	}
	
	private static void sortStack(Stack<Integer> st) {
		if(st.size()==1)return;
		int val=st.pop();
		sortStack(st);
		insert1(st,val);
	}


	private static void insert1(Stack<Integer> st, int val) {
		if(st.isEmpty() || st.peek()<val) {
			st.push(val);
			return;
		}
		int temp=st.pop();
		insert1(st, val);
		st.push(temp);
	}
	
	private static void reverseStack(Stack<Integer> st) {
		if(st.isEmpty())return;
		int val=st.pop();
		reverseStack(st);
		insertInReverse(st,val);
	}
	public static void insertInReverse(Stack<Integer> st,int val) {
		if(st.isEmpty()) {
			st.push(val);
			return;
		}
		int tmp=st.pop();
		insertInReverse(st,val);
		st.push(tmp);
	}
	
	private static void deleteMiddleStack(Stack<Integer> st,int pos) {
		if(pos==1) {
			st.pop();
			return;
		}
		int val=st.pop();
		deleteMiddleStack(st,pos-1);
		st.push(val);
	}
	private static int kthSymbolGrammer(int n, int k) {
		if(n==1 &&k==1)return 0;
		int mid =(int)Math.pow(2, n-1)/2;
		if(k<=mid)
			return kthSymbolGrammer(n-1, k);
		else return kthSymbolGrammer(n-1, k-mid)==1?0:1;
	}
	
	private static void toh(int n, String s, String d, String h) {
		if(n==1) {
			System.out.println("Move "+n+" :-"+s+"->"+d);
			return;
		}
		toh(n-1,s,h,d);
		System.out.println("Move "+n+" :-"+s+"->"+d);
		toh(n-1,h,d,s);
	}
	
	private static void subsets(String ip, String op) {
		if(ip.length()==0) {
			System.out.println("SUB- "+op);
			return;
		}
		String op1=op;
		String op2=op+ip.charAt(0);
		ip=ip.substring(1);
		subsets(ip,op1);
		subsets(ip, op2);
	}

	private static void permutationwithSpaces(String ip, String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		permutationwithSpaces(ip.substring(1), op+ip.charAt(0));
		if(ip.length()>1)
		permutationwithSpaces(ip.substring(1), op+ip.charAt(0)+"_");

	}

	private static void permutationwithCaseChange(String ip, String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		String op1=op+Character.toLowerCase(ip.charAt(0));
		String op2=op+Character.toUpperCase(ip.charAt(0));
		permutationwithCaseChange(ip.substring(1),op1);
		permutationwithCaseChange(ip.substring(1),op2);
	}

	private static void letterPermutation(String ip, String op) {
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}
		boolean isLetter=Character.isLetter(ip.charAt(0));
		if(isLetter){
			String op1=op+Character.toLowerCase(ip.charAt(0));
			String op2=op+Character.toUpperCase(ip.charAt(0));
			ip=ip.substring(1);
			letterPermutation(ip,op1);
			letterPermutation(ip,op2);
			
		}else {
			//single recursion in case of digit as we just need to copy in output
			String op1=op+ip.charAt(0);
			ip=ip.substring(1);
			letterPermutation(ip,op1);
			
		}

	}
	
	private static void balanceParanthesis(int open, int close, String op) {
		if(open==0 && close==0) {
			System.out.println(op);
			return;
		}
		if(open>0)
			balanceParanthesis(open-1, close, op+"(");
		if(close>open)
			balanceParanthesis(open, close-1, op+")");
		return;
	}
	
	private static void nBitBinary(int n, int one, int zero,String op) {
		if(n==0) {
			System.out.println(op);
			return;
		}
		nBitBinary(n-1, one+1, zero, op+1);
		if(one>zero)
		nBitBinary(n-1, one, zero+1, op+0);
	}
}
