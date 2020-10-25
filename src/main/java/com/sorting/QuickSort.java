package com.sorting;
public class QuickSort implements InplaceSort {

  @Override
  public void sort(int[] values) {
    QuickSort.quicksort(values);
  }

  public static void quicksort(int[] ar) {
    if (ar == null) return;
    quicksort(ar, 0, ar.length - 1);
  }

 
  //https://www.youtube.com/watch?v=COk73cpQbFQ&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=7
  private static void quicksort(int[] ar, int start, int end) {
	    if (start < end) {
	      int splitPoint = pertition2(ar, start, end);
	      quicksort(ar, start, splitPoint-1);
	      quicksort(ar, splitPoint + 1, end);
	    }
	  }
  
  public static int pertition2(int[] ar, int start, int end) {
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
	  swap(ar,end,pIndex);
	  return pIndex;
  }

  // Swap two elements
  private static void swap(int[] ar, int i, int j) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }

  public static void main(String[] args) {
    InplaceSort sorter = new QuickSort();
    int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
    sorter.sort(array);
    // Prints:
    // [-13, 2, 3, 4, 4, 6, 8, 10]
    System.out.println(java.util.Arrays.toString(array));
  }
}