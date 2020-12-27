package com.cleanup;

public class BinarySearchCleanUp {

	public static void main(String[] args) {
		


	}
	
	 //Find first position of an element in a sorted array  						TWO
    private int first(int[] nums, int target) { 
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r){
            int m = l + (r - l) / 2;
            int v = nums[m];
            if((m == 0 || target > nums[m - 1]) && nums[m] == target) {
                return m; 
            }else if(v < target) { //In this case left condition will be up because we need to check first in left size we in else case r will move if target is equal but not first 
                l = m + 1;
            }else{
                r = m - 1;
            }
        } 
        return -1; 
    } 
    //Find last positions of an element in a sorted array				  		THREE
    private int last(int[] nums, int target) { 
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int m = l + (r - l) / 2;
            int v = nums[m];
            if(( m == r || target < nums[m + 1]) && v == target) {
                return m; 
            }else if(target < v) {
                r = m - 1;
            }else{ //this else condition is toggeled from first for same reason mentioned above
                l = m + 1;
            }
        } 
        return -1; 
    } 
	
	
	
	
}
