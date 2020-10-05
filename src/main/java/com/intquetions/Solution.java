package com.intquetions;

import java.util.HashMap;

class Solution {
	
	public static void main(String args[]) {
		twoSum(new int[] {2, 7,11,15},9);
	}
	//find tow no whoes diffrence is target 
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> deltaMap=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int delta =target-nums[i];
			if(deltaMap.containsKey(delta)) {
				int val=deltaMap.get(delta);
				return new int[]{i,val};
			}else {
				deltaMap.put(nums[i], i);
			}
		}
		return new int[] {-1,-1};
	}
	
	
	
}