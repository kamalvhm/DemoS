package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//40. Combination Sum II | https://leetcode.com/problems/combination-sum-ii/
class combinationSum {
	
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList());     	//return all solution subset that have sum as target
        return res;
    }
    
    public void dfs(int i, int [] candidates, int target, List<Integer> list){
        
        if( target == 0){
            res.add(new ArrayList(list));
            return;
        }
        
        if( target < 0 )    return;
        
        for(int j = i ; j < candidates.length ; j++ ){
            if( j == i || candidates[j] != candidates[j-1] ){
                list.add(candidates[j]);
                dfs(j+1, candidates, target - candidates[j], list );
                list.remove(list.size()-1);
            }
        }   
    }
    
    
    //39. Combination Sum
   
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
     // because we will stop searching the next possible combination if target minus the candidate is less than zero
     		// , so we need to sort the candidates to make the order by ascending
       dfs(0,candidates,target,new ArrayList<Integer>());
        return res;
    }
    
    public  void dfs(int start,int[] candidates,int target,ArrayList<Integer> temp){
        if(target==0){
            res.add(new ArrayList(temp));
            return ;
        }
        if(target<0)return;
        
        for(int i=start;i<candidates.length;i++){
            target -= candidates[i];
            		// if target minus the candidate is less than zero, then there's no need to try the rest candidates
         			// because the rest candidats are bigger than the current candidate
            if (target < 0) //bounding condition 
                break;
            temp.add(candidates[i]);
            dfs(i,candidates,target,temp);
            temp.remove(temp.size()-1);
            target += candidates[i];
        }
    }
    
    
}