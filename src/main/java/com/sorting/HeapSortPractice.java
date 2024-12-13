package com.sorting;

import java.util.ArrayList;
import java.util.List;

public class HeapSortPractice<T extends Comparable<T>>{
	
	private List<T> heap;
	
	public HeapSortPractice(T[] elem) {
		int heapSize=elem.length;
		heap=new ArrayList<>(heapSize);
		for(T e:elem)
			heap.add(e);
		
		for(int i=Math.max(0, (heapSize-1)/2);i>=0;i--)
			sink(i,heapSize);
		
//	    The current code stops after the heapify step. Without the extraction phase, the elements remain in heap order, not sorted order. For example:
//		    	Given [5, 3, 8, 4, 1, 7, 2], the heapified array might look like [1, 3, 2, 4, 5, 7, 8] (Min-Heap), but this is not sorted.
//		    	Sorting requires repeatedly extracting the minimum and placing it in its correct position. so next step is for same
		//Basically pick one by one from MAX/MIN heap and move it to end and reduce heapsize again call sink
		for(int i=heapSize-1;i>0;i--) {
			swap(0,i); // Move maximum to the end of the list
			heapSize--; //reduce heapSize
			sink(0,heapSize); // Restore the heap property for the remaining elements
		}
	}
	
	private boolean less(int i,int j) {
		T ith_node=heap.get(i);
		T jth_node=heap.get(j);
		return ith_node.compareTo(jth_node)<0; //Change for Min Heap
	} 
	
	private void sink(int k,int heapSize) {
		while(true) {
			int left=2*k+1;
			int right=2*k+2;
			int largest=left;
			
			if(right<heapSize && less(left,right))
				largest=right;
			if(left>=heapSize || less(largest,k))break;
			swap(k,largest);
			k=largest;
			
		}
	}

	private void swap(int i, int j) {
		T ith_node=heap.get(i);
		T jth_node=heap.get(j);
		heap.set(i, jth_node);
		heap.set(j, ith_node);
	}
	
	
	public static void main(String args[]) {
		Integer [] arr= {5,2,6,1,3,4};
		HeapSortPractice sorter=new HeapSortPractice(arr);
		System.out.println("After Sorting:-- "+sorter.heap);
		
		
	}

}
