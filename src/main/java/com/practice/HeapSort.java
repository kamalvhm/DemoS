package com.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort<T extends Comparable<T>>{
	
	private List<T> heap;
	
	HeapSort(T []elems){
		int heapSize=elems.length;
		heap=new ArrayList<>(heapSize);
		for(T elem:elems)
			heap.add(elem);
		
		//heapify 
		for(int i=Math.max(0, heapSize-1/2);i>=0;i--) 
			sink(i,heapSize);
		
		//after heapifying its not sorted just heap invarient is satified so to sort 
		for(int i=heapSize-1;i>=0;i--) {
			swap(0,i);
			heapSize--;
			sink(0,heapSize); 
			
		}
	}
	
	private boolean less(int i,int j) {
		T elem_i=heap.get(i);
		T elem_j=heap.get(j);
		return elem_i.compareTo(elem_j)<0;
	}
	
	private void sink(int k, int heapSize) {
		while(true) {
			int left=2*k+1;
			int right=2*k+2;
			int largest=left;
			if(right<heapSize && less(left,right)) {
				largest=right;
			}
			if(left>=heapSize || less(largest,k))break;
			swap(largest, k);
			k=largest;
		}
		
	}



	private void swap(int i, int j) {
		T elem_i=heap.get(i);
		T elem_j=heap.get(j);
		heap.set(i, elem_j);
		heap.set(j, elem_i);		
	}

	public static void main(String args[]) {
		Integer[] arr= {5,2,1,4,3};
//		HeapSort hs=new HeapSort(arr);
//		System.out.println("Sorted Array!!!");
//		System.out.print(hs.heap);
		
		int a[]= {5,2,1,4,3,4,};
		int b[]=countSort(a);
		System.out.println("Sorted Array:--"+Arrays.toString(b));
	}

	private static int[] countSort(int[] a) {
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int i:a) {
			min=Math.min(min, i);
			max=Math.max(max,i);
		}
		
		System.out.println("MIN:- "+min+" MAX:- "+max);
		int frq[]=new int[max-min+1];
		for(int i=0;i<a.length;i++) {
			frq[a[i]-min]++;
		}
		System.out.println("frq:- "+Arrays.toString(frq) );

		
		for(int i=1;i<frq.length;i++) {
			frq[i]=frq[i]+frq[i-1];
		}
		System.out.println("frq prefix:- "+Arrays.toString(frq));

		int ans[]=new int[a.length];
		for(int i=a.length-1;i>=0;i--) {
			int pos=frq[a[i]-min]-1;
			ans[pos]=a[i];
			frq[a[i]-min]--;
		}
		
		return ans;
	} 
	
}