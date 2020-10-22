package com.sorting;
public class InsertionSort implements InplaceSort {

  @Override
  public void sort(int[] values) {
    InsertionSort.insertionSort2(values);
  }

  // Sort the given array using insertion sort. The idea behind
  // insertion sort is that at the array is already sorted from
  // [0, i] and you want to add the element at position i+1, so
  // you 'insert' it at the appropriate location.
  private static void insertionSort(int[] ar) {
    if (ar == null) {
      return;
    }

    for (int i = 1; i < ar.length; i++) {
      for (int j = i; j > 0 && ar[j] < ar[j - 1]; j--) {
        swap(ar, j - 1, j);
      }
    }
  }
  //https://www.youtube.com/watch?v=i-SKeOcBwko&t=526s
  private static void insertionSort2(int[] ar) {
	    if (ar == null) {
	      return;
	    }

	    for (int i = 1; i < ar.length; i++) {
	     int value=ar[i];
	     int hole=i;
	     while(hole>0 && ar[hole-1]>value) {
	    	 ar[hole]=ar[hole-1];
	    	 hole--;
	     }
	     ar[hole]=value;
	    }
	  }

  private static void swap(int[] ar, int i, int j) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }

  public static void main(String[] args) {
    InplaceSort sorter = new InsertionSort();
    int[] array = {10, 4, 6, 8, 13, 2, 3};
    sorter.sort(array);
    // Prints:
    // [2, 3, 4, 6, 8, 10, 13]
    System.out.println(java.util.Arrays.toString(array));
  }
}