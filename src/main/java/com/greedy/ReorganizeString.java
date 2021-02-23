package com.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	   //767. Reorganize String
    public String reorganizeString(String S) {
        
        // step 1:
        // build a hashmap to store characters and its frequencies:
        Map<Character, Integer> freq_map = new HashMap<>();
        for (char c: S.toCharArray()) {
            freq_map.put(c, freq_map.getOrDefault(c, 0) + 1);
        }
        // step 2:
        // put the char of freq_map into the maxheap with sorting the frequencies by large->small
        PriorityQueue<Character> maxheap = new PriorityQueue<>(
            (a, b) -> freq_map.get(b) - freq_map.get(a)
        );
        // addAll() is adding more then one element to heap
        maxheap.addAll(freq_map.keySet());  
        
        // now maxheap has the most frequent character on the top
        
        // step 3:
        // obtain the character 2 by 2 from the maxheap to put in the result sb
        // until there is only one element(character) left in the maxheap
        // create a stringbuilder to build the result result
        StringBuilder sb = new StringBuilder();
        while (maxheap.size() > 1) {
            char first = maxheap.poll();
            char second = maxheap.poll();
            sb.append(first);
            sb.append(second);
            freq_map.put(first, freq_map.get(first) - 1);
            freq_map.put(second, freq_map.get(second) - 1);
            // insert the character back to the freq_map if the count in 
            // hashmap of these two character are still > 0
            // then the heap will heapify itself..
            // add() comes from Collection.
            // offer() comes from Queue.
            // For a capacity-constrained queue, the difference is that add() always             // returns true and throws an exception if it can't add the element,                 // whereas offer() is allowed to return false if it can't add the                   // element.
            if (freq_map.get(first) > 0) {
                maxheap.offer(first);
            }
            if (freq_map.get(second) > 0) {
                maxheap.offer(second);
            }
        }
        
        if (!maxheap.isEmpty()) {
            // when there is only 1 element left in the maxheap
            // check the count, it should not be greater than 1
            // otherwise it would be impossible and should return ""
            if (freq_map.get(maxheap.peek()) > 1) {
                return "";
            }
            else {
                sb.append(maxheap.poll());
            }
        }
        
        return sb.toString();
        

        
    }
    
    
    public String reorganizeString2(String S) {
        HashMap<Character,Integer> counts=new HashMap<>();
        for(char c:S.toCharArray())
            counts.put(c,counts.getOrDefault(c,0)+1);
        
        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->counts.get(b).compareTo(counts.get(a)));
        maxHeap.addAll(counts.keySet());
        StringBuilder sb=new StringBuilder();                                                    
        while(maxHeap.size()>1){
            char current=maxHeap.remove();
            char next=maxHeap.remove();
            sb.append(current);
            sb.append(next);
            counts.put(current,counts.get(current)-1);
            counts.put(next,counts.get(next)-1);
            if(counts.get(current)>0){
                maxHeap.add(current);
            }
             if(counts.get(next)>0){
                maxHeap.add(next);
            }
        }
        if(!maxHeap.isEmpty())
        {
            char last=maxHeap.remove();  
            if(counts.get(last)>1){
                return "";
            }
            sb.append(last);
         }
        return sb.toString();
    }
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
	