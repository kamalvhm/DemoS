package com.cleanup;

public class Utils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String b="bb";
		System.out.print(isPalindrom(b,0,b.length()-1));
	}
	//return true if string is palindrom
	public static boolean isPalindrom(String s) {
		if(s.length()==1)return true;
		
		if(s.charAt(0)==s.charAt(s.length()-1))
			return isPalindrom(s.substring(1,s.length()-1));
		else 
			return false;
	}

	public static boolean isPalindrom(String s,int i,int j) {
		if(i==j)return true;
		if(i>j) return true;
		
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
			return true;
	}

	public static boolean isPalindrome(String s, int i, int j) {

		while (i <= j) {

			if (s.charAt(i) != s.charAt(j))
				return false;

			i++;
			j--;

		}
		return true;
	}
	
	 public static void display(boolean [][] chess) {
		  //System.out.println("----------------------");
		   for(int i=0;i<chess.length;i++) {
			   for(int j=0;j<chess[0].length;j++) {
				   if(chess[i][j])System.out.print("Q ");
				   else System.out.print("- ");
			   }
			   System.out.println();
		   }
		   //System.out.println("----------------------");

	   }
	   public static void display(int [][] chess) {
		  // System.out.println("----------------------");
		   for(int i=0;i<chess.length;i++) {
			   if(i!=0 && i%3==0)
				   System.out.println();
			   for(int j=0;j<chess[0].length;j++) {
				    if(j%3==0)System.out.print(" ");
				    System.out.print(chess[i][j]+" ");
			   }
			   System.out.println();
			   

		   }
		   //System.out.println("----------------------");

	   }
	   public static void display(char [][] chess) {
		   //System.out.println("----------------------");
		   for(int i=0;i<chess.length;i++) {
			   for(int j=0;j<chess[0].length;j++) {
				    System.out.print(chess[i][j]+" ");
			   }
			   System.out.println();

		   }
		  // System.out.println("----------------------");
	   }
	   
	   public static void displayQueens(int [][] chess) {
			   for(int i=0;i<chess.length;i++) {
				   for(int j=0;j<chess[0].length;j++) {
					   if(chess[i][j]>0)
	                        System.out.print("q"+chess[i][j]+"\t");
	                    else System.out.print("-\t");
				   }
				   System.out.println();

			   }
			   System.out.println("----------");

		   }
}
