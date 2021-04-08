package com.recursion;

import org.apache.spark.sql.catalyst.expressions.Reverse;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;

public class Practice {

	public static void main(String[] args) {
		
	}
	

	
	
	
	private static void solve(String ip, String op) {
		
		if(ip.length()==0)
		{
			System.out.println(op);
			return;
		}
		solve(ip.substring(1), op+ip.charAt(0));
		solve(ip.substring(1), op+ip.charAt(0)+"_");

	}





	public static int firstOccurence(int a[],int i,int t) {
		if(i==a.length)
			return -1;
		
		if(a[i]==t)
			return i;
		else {
			int j = firstOccurence(a, i+1, t);
			return j;
		}
	}

	private static int print(int a[] ,int i) {
		if(i==a.length-1)
			return a[a.length-1];
		return Math.max(a[i], print(a, i+1));

	}
	
	
	private static int height(TreeNode root) {
		if(root==null)return 0;
		else return Math.max(height(root.left), height(root.right))+1;
	}
	
	
	 public static void reversee(char[] s ,int pos,int start){
	        if(pos<0)return;
	        char c=s[pos];
	        reversee(s,pos-1,start+1);
	        s[start]=c;
	        return;
	    }
	 
	 public static  int power(int x ,int n ) {
		 if(n==0)
			 return 1;
		 int xnm1=power(x,n-1);
		 return x*xnm1;
	 }
	 
	 public static  int powerHalf(int x ,int n ) {
		 if(n==0)
			 return 1;
		 int xnm1=power(x,n/2);
		 int xn=xnm1*xnm1;
		 if(x%2!=0)
			 xn=xn*x;
		 return xn;
	 }
	 
	 
	
	 
	

}
