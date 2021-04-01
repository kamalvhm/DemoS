package com.sorting;
public class BubbleSort implements InplaceSort {

  @Override
  public void sort(int[] values) {
   // BubbleSort.bubbleSort(values);
	  BubbleSort.bubbleSort2(values);
  }

  // Sort the array using bubble sort. The idea behind
  // bubble sort is to look for adjacent indexes which
  // are out of place and interchange their elements
  // until the entire array is sorted.  after each pass one last element 
  //will be on correct position
  private static void bubbleSort(int[] ar) {
    if (ar == null) {
      return;
    }

    boolean sorted;
    do {
      sorted = true;
      for (int i = 1; i < ar.length; i++) {
        if (ar[i] < ar[i - 1]) {
          swap(ar, i - 1, i);
          sorted = false;
        }
      }
    } while (!sorted);
  }

  private static void swap(int[] ar, int i, int j) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }

  public static void main(String[] args) {
    int[] array = {10, 4, 6, 8, 13, 2, 3};
    BubbleSort sorter = new BubbleSort();
    sorter.sort(array);
    // Prints:
    // [2, 3, 4, 6, 8, 10, 13]
    System.out.println(java.util.Arrays.toString(array));
  }
  
  private static void bubbleSort2(int [] ar ) {
	  if(ar==null) return ;
	  
	  int n=ar.length;
	  
	  for(int k=1;k<n;k++) {
		  boolean sorted=true;
		  for(int i=0;i<=n-k-1;i++) {
			  if(ar[i]>ar[i+1])
			  {
		          swap(ar, i+1, i);
		          sorted=false;
			  }
		  }
		  if(sorted)
			  break;
	  }
  }
}