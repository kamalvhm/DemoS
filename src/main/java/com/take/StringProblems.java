package com.take;

import java.util.ArrayList;
import java.util.List;



public class StringProblems {

	public static void main(String[] args) {
		 // Create object of Solution class
		StringProblems sol = new StringProblems();

        // Define text and pattern
        String text = "ababcababcabc";
        String pattern = "abc";

        // Call the KMP function
        List<Integer> matches = sol.KMP(text, pattern);

        // Print the result
        System.out.println("Pattern found at indices: " + matches);
	}
	
	
	 // Function to compute the LPS (Longest Prefix which is also Suffix) array
    public int[] computeLPS(String s) {
    	 int n=s.length();
         if(n==0 || n==1)return new int[] {0};
         int lps[]=new int[n];
         int pre=0,suf=1;
         while(suf<n){
             if(s.charAt(pre)==s.charAt(suf)){ // if both characters are equal
                 lps[suf]=pre+1;
                 pre++;
                 suf++;
             }else {  //both not equal
                 if(pre==0){  // pre is already at zero
                     lps[suf]=0;
                     suf++;
                 }else { //if non zero check previous and goto that index
                     pre=lps[pre-1];
                 }
                 
             }
         }
         return lps;
    }

    // Function to perform KMP pattern searching
    public List<Integer> KMP(String text, String pattern) {

        // Preprocess the pattern to get LPS array
        int[] lps = computeLPS(pattern);

        // Result list to store indices where pattern is found
        List<Integer> result = new ArrayList<>();

        // Indices for text and pattern
        int first = 0, second = 0;

        // Traverse the entire text
        while (first < text.length()) {

            // If characters match, increment both pointers
            if (text.charAt(first) == pattern.charAt(second)) {
            	first++;
            	second++;
            }

            // If full pattern matched
            if (second == pattern.length()) {
                result.add(first - second);
                second = lps[second - 1];
            }

            // If mismatch occurs after some matches
            else if (first < text.length() && text.charAt(first) != pattern.charAt(second)) {
                // Use LPS to skip unnecessary comparisons
                if (second == 0) {
                	first++;
                } else {
                	second = lps[second - 1];
                }
            }
        }

        // Return the list of matching indices
        return result;
    }


}
