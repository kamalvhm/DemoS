package com.practice;

import java.util.Arrays;
import java.util.Random;

public class SortMasterPr {

	private static void selectionSort(int[] a) 	{
	 int n=a.length;
	 for(int i=0;i<n;i++) {
		 int swapIndex=i;
		 for(int j=i+1;j<n;j++) {
			 if(a[j]<a[swapIndex])
				 swapIndex=j;
		 }
		 swap(a, i, swapIndex);
	 }
	 
	}
	private static void bubbleSort(int[] a) {
		int n=a.length;
		for(int k=1;k<n;k++) {
			boolean flag=true;
			for(int i=0;i<n-k;i++) {
				if(a[i]>a[i+1]) {
					swap(a, i, i+1);
					flag=false;
				}
			}
			if(flag)
				break;
		}
	}
	private static void insertionSort(int[] a) { //1 4 5 7
		int n=a.length;
		for(int i=0;i<n;i++) {
			int val=a[i];
			int hole=i;
			while(hole>0 && a[hole-1]>val) {
				a[hole]=a[hole-1];
				hole--;
			}
			a[hole]=val;
		}
	}
	
	private static int[] mergeSort(int[] a) {
		int n=a.length;
		if(n<=1)return a;
		int[] left=mergeSort(Arrays.copyOfRange(a, 0, n/2));
		int[] right=mergeSort(Arrays.copyOfRange(a, n/2, n));
		return merge(left, right, a);
	}
	
	private static int[] merge(int[] left, int[] right,int [] a) {
		int nL=left.length,nR=right.length;
		int i=0,j=0,k=0;
		while(i<nL && j<nR) {
			if(left[i]<right[j])
				a[k++]=left[i++];
			else a[k++]=right[j++];
		}
		while(i<nL)
			a[k++]=left[i++];
		while(j<nR)
			a[k++]=right[j++];
		return a;
	}
	
	private static void quickSort(int[] a, int start, int end) {
		if(start>=end)return;
		int pivot=partition(a, start, end);
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
		swap(a, pIndex, end);
		return pIndex;
	}
	private static int randomized(int[] a, int start, int end) {
		
		
		return -1;
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
		}
	}
	
	public static void sort(int a[],int b[]) {
	  int j=0;
	  for(int i=0;i<a.length;i++) {
		  if(a[i]>b[j]) {
			  swapAndInsersion(a, b, i, j);
		  }
	  }
	}
	
	public static void swapAndInsersion(int a[],int b[],int i,int j) {
		int value=a[i];
		a[i]=b[j];
		b[j]=value;
		int hole=j;
		while(hole<b.length-1 && b[hole+1]<value) {
			b[hole]=b[hole+1];
			hole++;
		}
		b[hole]=value;
		
	}
	
}
