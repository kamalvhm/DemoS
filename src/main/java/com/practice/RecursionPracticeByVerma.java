package com.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
/**CHECK CORRECTNESS In @link RecursionByVerma.java*/
public class RecursionPracticeByVerma {
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
		System.out.println("2) LIST  AFTER SORT [1, 3, 4, 6] :- "+list);
	//3) Height of Tree
		/**@link RecurssionKthPathSumV5toV10.java*/
		
	//4)sort an stack
		Stack<Integer> st=new Stack<>();
		st.add(5);
		st.add(1);
		st.add(3);
		st.add(4);
		//System.out.println("4) BEFORE "+st);
		sortStack(st);
		System.out.println("4) STACK AFTER SORT  [1, 3, 4, 5] :-"+st);
	//5)sort an stack
		reverseStack(st);
		System.out.println("5) AFTER REVERSE STACK [5, 4, 3, 1] :-"+st);
	//6)delete in middle in stack
		deleteMiddleStack(st,2);
		System.out.println("6) AFTER DELETE MIDDLE STACK [5, 4, 1] :-"+st);
	//7)Kth SYMBOL GRAMMER :- Two int given N,K generate grammer from this with below condition 1)if N=1 & K=1 then return 0 else to generate for N look for N-1 such that 
		//if  N-1 =0 then 01 if 1 then 10 ,you need to return digit in N Row and K col 
		System.out.println("7)Kth SYMBOL GRAMMER (0) :-"+kthSymbolGrammer(4,6));
		
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
	//11)Permutation with spaces :- in input a string given ABC so print all with space permutation {ABC, AB_C, A_BC, A_B_C}
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
	//16)Josephus Problem:- N is total peaple ,K is die index return last person
		ArrayList<Integer> totalPersons=new ArrayList<>();
		for(int i=1;i<=40;i++)
			totalPersons.add(i);
		int die=7;
		die=die-1;//array is zero base
		System.out.println("JOSEPHUS PROBLEM (24)ANS:- "+josephusProblem(totalPersons,die,0));
		
	}

	public static void print(int n) {
		
	}

	private static void sortArraList(ArrayList<Integer> list) {
		
	}
	
	public static void insert(ArrayList<Integer> arr,int val) {
		
	}

	
	
	private static void sortStack(Stack<Integer> st) {
		
	}


	private static void insert1(Stack<Integer> st, int val) {
		
	}
	
	private static void reverseStack(Stack<Integer> st) {
		
	}
	public static void insertInReverse(Stack<Integer> st,int val) {
	
	}
	
	private static void deleteMiddleStack(Stack<Integer> st,int pos) {
	}
	private static int kthSymbolGrammer(int n, int k) {
		return 1;
	}
	
	private static void toh(int n, String s, String d, String h) {
		
	}
	
	private static void subsets(String ip, String op) {
		

	}
	private static void uniqueSubsets(String ip, String op,HashSet<String> unq) {
		

	}

	private static void permutationwithSpaces(String ip, String op) {
	

	}

	private static void permutationwithCaseChange(String ip, String op) {
		

	}

	private static void letterPermutation(String ip, String op) {
		

	}
	
	private static void balanceParanthesis(int open, int close, String op) {
		
	}
	
	private static void nBitBinary(int n, int one, int zero,String op) {
	
	}
	
	private static int josephusProblem(ArrayList<Integer> list, int k,int index) {
		return 1;
	}
}
