package com.practice;

import java.util.Arrays;
import java.util.Random;

import org.apache.spark.util.collection.PartitionedAppendOnlyMap;

import scala.annotation.bridge;

public class SortMasterPr {

	private static void selectionSort(int[] a) 	{
		int n=a.length;
		
	}
	private static void bubbleSort(int[] a) {
		int n=a.length;
		
		
	}
	private static void insertionSort(int[] a) { //1 4 5 7
		int n=a.length;
		
	}
	
	private static int[] mergeSort(int[] a) {
		int n=a.length;
		return a;
	}
	
	private static int[] merge(int[] left, int[] right,int [] a) {
		
		return a;
	}
	
	private static void quickSort(int[] a, int start, int end) {
		if(start>=end)return ;
		int pivot=partition(a,start,end);
		quickSort(a, start, pivot-1);
		quickSort(a, pivot+1, end);
	}
	
	private static int partition(int[] a, int start, int end) {
		int pivot=a[end];
		int pIndex=start;
		for(int i=start;i<end;i++) {
			if(a[i]<pivot) {
				swap(a, pIndex, i);
				pIndex++;
			}
		}
		swap(a, end, pIndex);
		return pIndex;
	}
	private static int randomized(int[] a, int start, int end) {
		return -1;
	}
	
	private static void countSort(int[] a) {
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int i:a) {
			min =Math.min(min, i);
			max=Math.max(max, i);
		}
		int frq[]=new int[(max-min)+1];
		for(int i:a) {
			frq[i-min]++;
		}
		//creating prefix array
		for(int i=1;i<frq.length;i++) {
			frq[i]=frq[i-1]+frq[i];
		}
		int ans[]=new int[a.length];
		//iterate original array from last and fill positions 
		for(int i=a.length-1;i>=0;i--) {
			int val=a[i];
			int index=frq[val-min]-1; 
			ans[index]=val;
			frq[val-min]--;
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
		int[] array5 = {5,4,2,1,3,5,3,2,2};
		sort.sort(array5,5);
		System.out.println(java.util.Arrays.toString(array5));
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
