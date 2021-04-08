package com.intquetions;
/*
  Video Explanation (O(1) Space): https://youtu.be/WmxDyiXlsAE
*/

// O(n) Time
// O(1) Space
//169. Majority Element
class  MajorityElement{
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    
    
    public int majorityElementFaster(int[] nums) {
        int count = 1;
        int majElem = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(majElem==nums[i])
            {
                count++;
            }
            else{
                count--;
                if(count==0){
                    majElem = nums[i];
                    count=1;
                }
            } 
        } 
        return majElem;
    }
  
    
    //122. Best Time to Buy and Sell Stock II
/*    Input: [7,1,5,3,6,4]
    		Output: 7
    		Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
    		             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.*/
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        
        
        int profit=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                profit+=prices[i+1]-prices[i];
            }
        }
        return profit;
        
    }
}