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
    
    //32. Longest Valid Parentheses | https://www.youtube.com/watch?v=Y70Vtbf2A-U
    public int longestValidParentheses(String s) {
        int maxans = 0;
       int dp[] = new int[s.length()];  //Step 1:-Create a dp array of same size where we will keep value pairs until that index mean at index 4 how many pars are there 
       //from 0 to 4 
       for (int i = 1; i < s.length(); i++) {
           if (s.charAt(i) == ')') { //Step 2:if its closing then only we can check for pairs so ignore ( (for this we need to check below two condition)
               if (s.charAt(i - 1) == '(') { //Step 3:if its closing above then check if i-1 just before is (
                   dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
               } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') { //if just before is not opening then check before pairs 
                   dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
               }
               maxans = Math.max(maxans, dp[i]);
           }
       }
       return maxans;
   }
    
    //53. Maximum Sub array  Easy
    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int max=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>0)nums[i]+=nums[i-1];
            if(nums[i]>max)
                max=nums[i];
        }
        return max;
    }
    
    
    //413. Arithmetic Slices
    public int numberOfArithmeticSlices(int[] A) {
        int total=0;
        int dp[] =new int [A.length];
        for(int i=2;i<A.length;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2])
                dp[i]=dp[i-1]+1;
            else dp[i]=0;
            
            total+=dp[i];
        }
        return total;
    }
    
    //55. Jump Game | https://www.youtube.com/watch?v=0RHXjBKY9EM&t=260s
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int can_reach= 0;
        for(int i=0;i<=can_reach;i++){
            if(i==n-1)
                return true;
            can_reach=Math.max(can_reach,i+nums[i]);
        }
        return false;
        
    }
}
