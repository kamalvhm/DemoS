package com.intquetions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringStoringPositionsOffirstandLast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*      Input: s = "abca"
			Output: 2
			Explanation: The optimal substring here is "bc".*/
	//1624. Largest Substring Between Two Equal Characters
	 public int maxLengthBetweenEqualCharacters(String s) {
	        int[] array = new int[26];
	        Arrays.fill(array, -1);
	        char c[] = s.toCharArray();
	        int result = -1;
	        for(int i=0;i<c.length;i++){
	            int val = c[i]-'a';
	            if( array[val] == -1){
	                array[val] = i;
	            }
	            else{
	                result = Math.max(result,i-array[val]-1);
	            }
	                
	        }
	        return result;
	        
	    }
	 
	 public int maxLengthBetweenEqualCharacters2(String s) {
	        int ans = -1;
	        Map<Character, Integer> map = new HashMap<>();
	        for (int i = 0; i < s.length(); i++) {
	            char ch  = s.charAt(i);
	            if (map.containsKey(ch)) {
	                ans = Math.max(ans, i - 1 - map.get(ch));
	            }
	            else {
	                map.put(ch, i);
	            }
	        }
	        return ans;
	    }

}
