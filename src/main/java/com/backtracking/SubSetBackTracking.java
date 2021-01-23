package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
//SUbsets can have Less elments also 
//but permutations will always have all but order may vary
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
	
	/**					below Recursion goes like
	 * 						 [1,2,3]
	 * 					/1      |2	  3\
	 * 				   /        |		\
	 Then again we [1,2,3]   [1,2,3]	 [1,2,3]  have same choices at every stage until either target is 0 or <0
	 */
	 //46. Permutations  A BACKTRACKING APPROACH
	 public static void solve(int nums[] ,int pos,List<Integer> curr,List<List<Integer>> result){
	        if(pos==nums.length){
	            result.add(new ArrayList<>(curr));
	            return;
	        }
	        for(int i=0;i<nums.length;i++){
	             if(curr.contains(nums[i])){  //skip if already added
	                continue;
	            }
	            
	            curr.add(nums[i]);
	            solve(nums,pos+1,curr,result);
	            curr.remove(curr.size()-1);
	        }
	        return;
	    }
	 
	 //47. Permutations II
	 public static void solve(int nums[] ,int pos,List<Integer> curr,HashSet<List<Integer>> result,boolean [] seen){
         if(pos==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){   
            if(!seen[i]){
                seen[i]=true;
                curr.add(nums[i]);
                solve(nums,pos+1,curr,result,seen);
                curr.remove(curr.size()-1);
                seen[i]=false;
            }
        
        }
        return;
    }

}