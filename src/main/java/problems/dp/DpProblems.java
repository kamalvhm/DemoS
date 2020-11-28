package problems.dp;

import java.util.HashMap;
import java.util.Map;

public class DpProblems {

	//198. House Robber
    public int rob(int[] nums) {
        
        return helper(nums, 0);
    }
    
    private int helper(int[] nums, int index) {
        if (index >= nums.length) return 0;
        
        return Math.max(nums[index] + helper(nums, index + 2), helper(nums, index + 1));
    }
       //With Memoization
    public int rob2(int[] nums) {
        
        // HashMap used for Memoization
        Map<Integer, Integer> map = new HashMap<>();
        
        return helper2(nums, 0, map);
    }
    
    private int helper2(int[] nums, int index, Map<Integer, Integer> map) {
        if (index >= nums.length) return 0;
        
        if (map.get(index) != null) return map.get(index); 
        
        int v1 = nums[index] + helper2(nums, index + 2, map); 
        int v2 = helper2(nums, index + 1, map);
        int val = Math.max(v1, v2);
        map.put(index, val);
        
        return val;
    }
    
    //70. Climbing Stairs
    public int helper(int n,HashMap<Integer,Integer> map){
        if(n<=0)
            return 1;
        else if(map.containsKey(n))return map.get(n);
        int val1=0,val2=0;
        if(n>=2){
           val1= helper(n-2,map);
        }
         if(n>=1){
              val2= helper(n-1,map);
        }
        map.put(n,(val1+val2));
        return map.get(n);
    }
}
