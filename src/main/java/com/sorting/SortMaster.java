package com.sorting;

import java.util.Arrays;
import java.util.Random;

import com.beans.ListNode;

//https://www.youtube.com/watch?v=pkkFqlG0Hds&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=1
public class SortMaster {
	/**
	 * 1)148. Sort List (sort a Linked list check in   {@link com.datastructure.MyLinkList.#sortList(ListNode)})
	 *  @see com.datastructure.MyLinkedList
	 * CHECK @HeapSortPractice for HeapSort Practice 
	 */
	private static void selectionSort(int[] arr) {
		if(arr==null) return;
		for(int i=0;i<arr.length;i++) {
			int swapIndex=i;
			for(int j=i+1;j<arr.length;j++) {//finding min from rest of array and swapping 
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
	
	private static void quickSort(int[] ar, int start, int end) {
	      if(start>=end)return;
	      //int pivot = partition(ar, start, end);
	      int pivot=randomisedPartition(ar,start,end);
	      quickSort(ar, start, pivot-1);
	      quickSort(ar, pivot + 1, end);
	  }
	 public static int partition(int[] ar, int start, int end) {
		  int pivot =ar[end];
		  //partitionIndex
		  int pIndex=start;
		  //Pivot is fixed at end so end-1 times 
		  for(int i=start;i<end;i++) {
			  if(ar[i]<=pivot) {
				  swap(ar,i,pIndex);
				  pIndex++;
			  }
		  }
		  swap(ar,end,pIndex); //at last swapping pivot withPartition index
		  return pIndex;
	  }
	 
	 public static int randomisedPartition(int[] ar, int start, int end) {
		 Random r=new Random();
		 int pivot=r.nextInt(end-start)+start;//getting random pivot with in range start to end (exclusive)
		 swap(ar, pivot, end);
		 return partition(ar, start, end);
	 }
	private static void swap(int [] arr,int i,int j) {
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}

	public static void main(String[] args) {
		//int[] array = {10, 4, 6, 8, 13, 2, 3};
		SortMaster sort=new SortMaster();
		int[] array = {5,4,2,1,3};
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
	//https://www.youtube.com/watch?v=a5e7RgCdel0
	private void redixSort(int[] array) {
		int max=Integer.MIN_VALUE;
		for(int i:array)
			max=Math.max(max, i);
		
		int exp=1;
		while(exp<=max) {
			countVariationForRedix(array, exp);
			exp=exp*10;
		}
	}
	private static void countVariationForRedix(int[] a,int exp) {
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int i:a) {               
			min =Math.min(min, i);
			max=Math.max(max, i);
		}
		int frq[]=new int[10];   //Change 1:- frq can be of size 10 as we are sorting digit wise in redix at a time
		//Change 2 Min will be zero as digit can very from 0 to 9 
		//change 3 :- where ever you are using a[i] now you have to get the digit from a[i] using exp so =a[i]/exp%10
		for(int i=0;i<a.length;i++) {
			frq[a[i]/exp%10]++;
		}
		
		for(int i=1;i<frq.length;i++) {
			frq[i]=frq[i-1]+frq[i];
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
	//Check In Recursion notes :- https://www.youtube.com/watch?v=p-OyKUgIrx4
	private static void countSort(int[] a) {
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int i:a) {               //Step1:-compute min and max
			min =Math.min(min, i);
			max=Math.max(max, i);
		}
		int frq[]=new int[(max-min)+1];   //Step2:- compute Frq Array
		for(int i=0;i<a.length;i++) {
			frq[a[i]-min]++;
		}
		//Step2:-creating prefix array
		for(int i=1;i<frq.length;i++) {
			frq[i]=frq[i-1]+frq[i];
		}
		int ans[]=new int[a.length];
		//iterate original array from last and fill positions in ans 
		for(int i=a.length-1;i>=0;i--) {
			int index=frq[a[i]-min]-1; 
			ans[index]=a[i];
			frq[a[i]-min]--;
		}
		// Now fill all values back into original array
		for(int i=0;i<ans.length;i++)
			a[i]=ans[i];
	}
	
	public static void sort(int a[],int b[]) {
		int j=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>b[j]) {//if array a ith element is bigger then b 0 th element then swap them and in b array use some 
				//isertion logic to insert that swaped elemnt to its ocrrect pos; 
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
