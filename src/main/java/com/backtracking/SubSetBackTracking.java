package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubSetBackTracking {
	// 90. Subsets II
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		// sorting our array will allow us to skip repetitions easily
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		backtrack(nums, 0, new ArrayList<>(), res);
		return res;
	}

	private void backtrack(int[] a, int idx, List<Integer> curr, List<List<Integer>> res) {
		// Be careful to always add a copy of the list;
		// else you would essentially be changing the same list over and over again
		//res.add(List.copyOf(curr));
		res.add(new ArrayList<>(curr));
		if (idx == a.length)
			return;

		for (int i = idx; i < a.length; i++) {
			curr.add(a[i]); // make a choice (add the number at index)
			backtrack(a, i + 1, curr, res); // backtrack (generate dependent subsets)
			curr.remove(curr.size() - 1); // undo your choice (remove the number)

			// This is the tricky part; we want to skip all the repetitions of the number to
			// remove duplicate
			while (i + 1 < a.length && a[i] == a[i + 1]) {
				i += 1;
			}
		}
	}
}