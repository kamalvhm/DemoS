package com.intquetions;

public class MissingNumInN {
	//268. Missing Number
	public int missingNumber(int[] nums) {

		// Naive Approach
		// Sort
		// Find out where our index is not matching with the value
		// O(n log n)

		// Efficient (Maths)
		// Sum of natural numbers with n-1
		// sum the actual numbers
		// Based on both these difference, devise an equation to find out which one is missing.
		// O(n)
	/*        int n = nums.length - 1;
		int sum = (n * (n + 1)) / 2;
		int arraySum = 0;
		for (int val : nums) {
			arraySum += val;
		}
		return nums.length - (arraySum - sum);*/


		// Bit Manipulation Approach
		// XOR operation is its own inverse
		// That means when we do XOR operation on same number, that evaluates to 0. Eg: 2^2 = 0
		// When one number misses, the maximum value in the array can be nums.length
		// we do XOR operation between nums.length and eachIndex ^ Value
		// The value, which is missing, will be left out since there is XOR operation for the missing value
		int missingNumber = nums.length;
		for (int i = 0; i < nums.length; i++) {
			missingNumber ^= i ^ nums[i];
		}
		return missingNumber;


		// HashSet Approach
		// add all the elements of array to a HashSet
		// iterate over 0 to nums.length-1 values
		// check whether the hashset contains iterated values
		// If it doesn't contain, that is our missing number.

	}
}
