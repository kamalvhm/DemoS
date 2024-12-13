package com.practice;

import java.util.Arrays;
import java.util.Random;

import org.apache.spark.sql.execution.columnar.ARRAY;
import org.apache.spark.util.collection.PartitionedAppendOnlyMap;

import scala.annotation.bridge;

public class SortMasterPr {
	//TC:- O(n2) inplace ,but not stable
	private static void selectionSort(int[] a) 	{
		int n=a.length;
	
		
	
	}
	//TC:- O(n) best, O(n2) worst Inplace stable
	//execute N passes in every pass push largest elements to end of array
	private static void bubbleSort(int[] a) {
		int n=a.length;
		
	}
	//TC:- O(n) best, O(n2) worst
	//divide array in two part  5 | 4 2 3   sorted and unsorted  
	//now pick element from unsorted part and place it sorted part
	private static void insertionSort(int[] a) { //1 4 5 7
		int n=a.length;
		
		
		
	}
	//TC:- O(nlogn) stable but not inplace 
	private static int[] mergeSort(int[] a) {
		int n=a.length;
		return a;
	}
	
	private static int[] merge(int[] left, int[] right,int [] a) {	
		
		return a;
	}
	//TC:- O(nlogn) worst O(n2) In place but not stable 
	//select a pivot (can be any let say end) now arrang remaining element such that  all small goes left and all big goes right
	private static void quickSort(int[] a, int start, int end) {
		
	}
	
	private static int partition(int[] a, int start, int end) {
		
		return start;
	}
	private static int randomized(int[] a, int start, int end) {
		return -1;
	}
	
	private static void countSort(int[] a) {
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int i:a) {
			min=Math.min(min, i);
			max=Math.max(max,i);
		}
		
		int frq[]=new int[max-min+1];
		for(int i=0;i<a.length;i++){
			frq[a[i]-min]++;
		}
		for(int i=1;i<frq.length;i++) {
			frq[i]=frq[i]+frq[i-1];
		}
		int ans[]=new int[a.length];
		for(int i=a.length-1;i>=0;i--) {
			int pos=frq[a[i]-min]-1;
			ans[pos]=a[i];
			frq[a[i]-min]--;
		}
		
		for(int i=0;i<ans.length;i++)
			a[i]=ans[i];
	}
	
	private void redixSort(int[] array) {
		int max=Integer.MIN_VALUE; 
		for(int i:array)
			max=Math.max(max, i);
		int exp=1;
		while(exp<=max) {
			countVariationForRedix(array, exp);
			exp*=10;
		}
		
	}
	private static void countVariationForRedix(int[] a,int exp) {
		int max=Integer.MIN_VALUE;
		for(int i:a) {
			max=Math.max(max,i);
		}
		
		int frq[]=new int[10];
		for(int i=0;i<a.length;i++){
			frq[a[i]/exp%10]++;
		}
		for(int i=1;i<frq.length;i++) {
			frq[i]=frq[i]+frq[i-1];
		}
		int ans[]=new int[a.length];
		for(int i=a.length-1;i>=0;i--) {
			int pos=frq[a[i]/exp%10]-1;
			ans[pos]=a[i];
			frq[a[i]/exp%10]--;
		}
		
		for(int i=0;i<ans.length;i++)
			a[i]=ans[i];
		
	}
	
	
	private static void swap(int [] a,int i,int j) {
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp;
	}

	public static void main(String[] args) {
		//int[] array = {10, 4, 6, 8, 13, 2, 3};
		int[] array = {5,4,2,1,3};
		SortMasterPr sort=new SortMasterPr();
		sort.sort(array,0);
		System.out.println(java.util.Arrays.toString(array));
		int[] array1 = {5,4,2,1,3};
		sort.sort(array1,1);
		System.out.println(java.util.Arrays.toString(array1));
		int[] array2 = {5,4,2,1,3};
		sort.sort(array2,2);
		System.out.println(java.util.Arrays.toString(array2));
		int[] array3 = {5,4,2,1,3};
		sort.sort(array3,3);
		System.out.println(java.util.Arrays.toString(array3));
		int[] array4 = {5,4,2,1,3};
		sort.sort(array4,4);
		System.out.println(java.util.Arrays.toString(array4));
		//Sort these sorted arrays mutually TC:- O(n*m) where n is for traverse in array a and m is to order correct in b array
		int[] array5 = {5,4,2,3,5,3,8,2};
		sort.sort(array5,5);
		System.out.println(java.util.Arrays.toString(array5));
		int[] array6 = {213,97,718,123,3};
		sort.sort(array6,6);
		System.out.println(java.util.Arrays.toString(array6));
		
		System.out.println("Sort Two array using Insersion");
		int a[]= {1,4,7,8,10};
		int b[]= {2,3,9};
		sort(a,b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		
	}

	private void sort(int[] array, int i) {
		switch(i) {
		case 0:selectionSort(array);
		System.out.println("Selection");
				break;
		case 1:bubbleSort(array);
		System.out.println("Bubble");
				break;
		case 2:insertionSort(array);
		System.out.println("Insersion");
				break;
		case 3:mergeSort(array);
		System.out.println("Merge");
				break;
		case 4:quickSort(array,0,array.length-1);
		System.out.println("Quick");
				break;
		case 5:countSort(array);
		System.out.println("Count");
				break;
		case 6:redixSort(array);
		System.out.println("Redix");
				break;
		}
		
	}
	
	
	public static void sort(int a[],int b[]) {
		int j=0;
		for(int i=0;i<a.length;i++) {
			if(b[j]<a[i]) {
				swapAndInsersion(a, b, i, j);
			}
		}
	}
	
	public static void swapAndInsersion(int a[],int b[],int i,int j) {
	   int hole=j;
	   int val=a[i];
	   a[i]=b[j];
	   b[j]=val;
	   while(hole<b.length-1 && b[hole+1]<val) {
		   b[hole]=b[hole+1];
		   hole++;
	   }
	   b[hole]=val;
		
	}
	
}
