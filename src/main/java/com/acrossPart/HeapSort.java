package com.acrossPart;

import java.util.ArrayList;
import java.util.List;

public class HeapSort<T extends Comparable<T>>{
	private List<T> heap;
	
	HeapSort(T elems[]){
		int heapSize=elems.length;
		heap=new ArrayList<>(heapSize);
		
		for(T elem:elems)heap.add(elem);
		for(int i=Math.max(0, heapSize/2-1);i>=0;i--)sink(i,heapSize);
		
		for(int i=heapSize-1;i>0;i--) {
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
	
	private void swap(int i,int j) {
		T elem_i=heap.get(i);
		T elem_j=heap.get(j);
		heap.set(i, elem_j);
		heap.set(j, elem_i);
	}
	
	private void swim(int k) {
		int parent=k-1/2;
		while(k>0 && less(parent,k)) {
			swap(parent,k);
			k=parent;
			parent=k-1/2;
		}
	}
	public static void main(String[] args) {
		Integer [] arr= {5,3,4,1,2};
		HeapSort<Integer> hs=new HeapSort(arr);
		System.out.print(">>"+hs.heap);

	}

}
