package com.practice;

public class SlidingWindowPractice {

	public static void main(String[] args) {
		//1)Return Maximum sum of subArray element of size 3 from below array;
			int [] arr1= {2,3,5,9,7,1};
			System.out.print("1)Max in SubArray():- "+maxInSubArray(arr1,3));
	}
	


	private static int maxInSubArray(int[] arr, int window) {
		int max=0;
		int i=0,j=0;
		int currentSum=0;
		while(j<arr.length) {
			currentSum+=arr[j];
			if(j-i+1<window)
				j++;
			else if(j-i+1==window) {
				max=Math.max(max, currentSum);
				currentSum-=arr[i];
				i++;
				j++;
			}
		}
		return max;
	}

}
