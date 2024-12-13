package com.sorting;
import java.util.*;

public class Heapsort implements InplaceSort {

  @Override
  public void sort(int[] values) {
    Heapsort.heapsort(values);
  }

  private static void heapsort(int[] ar) {
    if (ar == null) return;
    int n = ar.length;

    // Heapify, converts array into binary heap O(n), see:
    // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
    for (int i = Math.max(0, (n / 2) - 1); i >= 0; i--) {
      sink(ar, n, i);
    }
//    The current code stops after the heapify step. Without the extraction phase, the elements remain in heap order, not sorted order. For example:
//
//    	Given [5, 3, 8, 4, 1, 7, 2], the heapified array might look like [1, 3, 2, 4, 5, 7, 8] (Min-Heap), but this is not sorted.
//    	Sorting requires repeatedly extracting the minimum and placing it in its correct position. so next step is for same

    // Sorting bit
    for (int i = n - 1; i >= 0; i--) {
      swap(ar, 0, i);
      sink(ar, i, 0);
    }
  }

  private static void sink(int[] ar, int n, int i) {
    while (true) {
      int left = 2 * i + 1; // Left  node
      int right = 2 * i + 2; // Right node
      int largest = i;

      // Right child is larger than parent
      if (right < n && ar[right] > ar[largest]) largest = right;

      // Left child is larger than parent
      if (left < n && ar[left] > ar[largest]) largest = left;

      // Move down the tree following the largest node
      if (largest != i) {
        swap(ar, largest, i);
        i = largest;
      } else break;
    }
  }

  private static void swap(int[] ar, int i, int j) {
    int tmp = ar[i];
    ar[i] = ar[j];
    ar[j] = tmp;
  }

  /* TESTING */

  public static void main(String[] args) {
    Heapsort sorter = new Heapsort();
    int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
    sorter.sort(array);
    // Prints:
    // [-13, 2, 3, 4, 4, 6, 8, 10]
    System.out.println(java.util.Arrays.toString(array));
  }
}