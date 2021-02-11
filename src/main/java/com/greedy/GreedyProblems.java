package com.greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class GreedyProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
	Output: 9
	Explanation: The subset chosen is the first, third, and fifth item.
	 */
	//1090. Largest Values From Labels
	   public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
		      
	        PriorityQueue<Item> pq=new PriorityQueue<>((Item a,Item b)->b.value-a.value);
	         for(int i=0;i<values.length;i++)
	            pq.offer(new Item(values[i],labels[i]));
	        
	        HashMap<Integer,Integer> map =new HashMap<>();
	        int val=0;
	        while(!pq.isEmpty() && num_wanted>0){
	            Item current =pq.remove();
	            map.put(current.label,map.getOrDefault(current.label,0)+1);
	            
	            if(map.get(current.label)<=use_limit){
	                val+=current.value;
	                num_wanted--;
	            }
	        }
	        
	        return val;
	    }
	    
	     class Item{
	        int value;
	        int label;
	    
	        Item(int v,int l){
	             value=v;
	             label=l;
	            }
	    }
}
