package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetProblemV12 {
//78. Subsets | https://leetcode.com/problems/subsets/
	public static void main(String[] args) {
		//print all subsets of given string 
		
		printSubsets("abcd","");

	}

	private static void printSubsets(String  input, String output) {
			if(input.length()==0) {
				System.out.println(output);
				return;
			}
			//one with selected and one with not
			String op1=output;
			String op2=output;
			
			op2=op2+input.charAt(0);
			input=input.substring(1);
			 printSubsets(input, op2);
			 printSubsets(input, op1);
			 return;
			
			
	}
	
	//LEetcode solution || 78. Subsets
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        solve(nums,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void solve(int[] arr,int pos,ArrayList<Integer> op,List<List<Integer>> result){
        if(pos==(arr.length)){
            result.add(op);
            return;
        }
     
        ArrayList<Integer> op1=new ArrayList<>();
        op1.addAll(op);
        op1.add(arr[pos]);
        solve(arr,pos+1,op1,result);
        solve(arr,pos+1,op,result);
        return;

    }
	

}
