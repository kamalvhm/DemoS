package com.recursion;

import org.apache.spark.sql.catalyst.expressions.Reverse;

import com.beans.TreeNode;
import com.datastructure.TreePrinter;

public class Practice {

	public static void main(String[] args) {
		//1) Print No from 7 to 1 and reverse 
		/*print(7);
		
		TreeNode<Integer> tree = new TreeNode(1); // 1
		tree.left = new TreeNode(2); // 2 3
		tree.right = new TreeNode(3); // 4 5
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		//2)Write function to return height of given tree
		//System.out.print(TreePrinter.getTreeDisplay(tree));
		//System.out.print("Height:-"+height(tree));
		
		int [] a= {4,6,2,1,3};
		//3)sort a given array
		char c []= {'h','e'};
		reversee(c,c.length-1,0);
		System.out.print(c);
		System.out.println(power(3,2));*/
		
		//pzz(2);
		int [] b= {4,6,2,1,3};
		//System.out.print(print(b,0));
		
		int [] c= {2,3,6,9,8,3,2,6,3,4};
		//System.out.print(firstOccurence(c,0,8));
		

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
	 
	 
	 public static void pzz(int n) {
		 if(n==0)
			 return;
		 System.out.println("Pre "+n);
		 pzz(n-1);
		 System.out.println("In "+n);
		 pzz(n-1);
		 System.out.println("Post "+n);

	 }
	 
	

}
