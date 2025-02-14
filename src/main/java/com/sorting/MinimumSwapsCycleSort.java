package com.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumSwapsCycleSort {
    public static void main(String[] args) {
        int[] arr = {7, 4, 8, 3, 1};
        int swaps = minimumSwaps(arr);
        System.out.println("Minimum number of swaps: " + swaps);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    // Function to calculate minimum swaps using Cycle Sort approach and sort the array
    public static int minimumSwaps(int[] arr) {
        int n = arr.length;
        // Create an array of pairs where each pair contains element and its index
        Pair[] arrPos = new Pair[n];
        for (int i = 0; i < n; i++) {
            arrPos[i] = new Pair(arr[i], i);
        }

        // Sort the array by element values
        Arrays.sort(arrPos, Comparator.comparingInt(o -> o.value));

        // To keep track of visited elements
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        // Traverse through the elements to find cycles
        for (int i = 0; i < n; i++) {
            // If element is already in the correct place or visited, skip
            if (visited[i] || arrPos[i].index == i) {
                continue;
            }

            // Find the number of nodes in this cycle
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                // Move to the index where the current element should be
                j = arrPos[j].index;
                cycleSize++;
            }

            // If there's a cycle of size 'k', it takes (k-1) swaps
            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        // Place the elements in the sorted order in the original array
        for (int i = 0; i < n; i++) {
            arr[i] = arrPos[i].value;
        }

        return swaps;
    }

    // Helper class to hold element value and original index
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}