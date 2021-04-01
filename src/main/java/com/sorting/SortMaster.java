package com.sorting;

import java.util.Arrays;

public class SortMaster {

	private static void selectionSort(int[] arr) {
		if(arr==null) return;
		for(int i=0;i<arr.length;i++) {
			int swapIndex=i;
			for(int j=i+1;j<arr.length;j++) {//finding min from rest of array and swaping 
				if(arr[j]<arr[swapIndex]) {
					swapIndex=j;
				}
			}
			swap(arr,i,swapIndex);
		}
		
	}
	private static void bubbleSort(int[] arr) {
		if(arr==null) return;
		int n=arr.length;
		for(int k=1;k<n;k++) {
			boolean flag=true;
			for(int i=0;i<=n-k-1;i++) {
				if(arr[i]>arr[i+1]) {
					swap(arr, i, i+1);
					flag=false;
				}
			}
			if(flag)
				break;
		}
		
	}
	private static void insertionSort(int[] arr) {
		if(arr==null) return;
		int n=arr.length;
		for(int i=1;i<n;i++) {
			int value=arr[i];
			int hole=i;
			while(hole>0 && arr[hole-1]>value) {
				arr[hole]=arr[hole-1];
				hole=hole-1;
			}
			arr[hole]=value;
		}
	}
	
	private static int[] mergeSort(int[] ar) {
		int n=ar.length;
		if(n<=1)return ar;
		int[] left=mergeSort(Arrays.copyOfRange(ar, 0, n/2));
		int[] right=mergeSort(Arrays.copyOfRange(ar, n/2, n));
		return merge(left,right, ar);
		
	}
	
	private static int[] merge(int[] left, int[] right,int [] a) {
		int nL=left.length,nR=right.length;
		int n=nL+nR;
		int i=0,j=0,k=0;
		
		while(i<nL && j<nR) {
			if(left[i]<=right[j]) {
				a[k++]=left[i++];
			}else a[k++]=right[j++];
		}
		
		while(i<nL) {
			a[k++]=left[i++];
		}
		
		while(j<nR) {
			a[k++]=right[j++];
		}
		return a;
	}
	private static void swap(int [] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

	public static void main(String[] args) {
		int[] array = {10, 4, 6, 8, 13, 2, 3};
		SortMaster sort=new SortMaster();
		sort.sort(array,3);
		System.out.println(java.util.Arrays.toString(array));
	}

	private void sort(int[] array, int i) {
		switch(i) {
		case 0:selectionSort(array);
		case 1:bubbleSort(array);
		case 2:insertionSort(array);
		case 3:mergeSort(array);

		}
	}
	
}
