package com.datastructure;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
//STUDY:-https://www.geeksforgeeks.org/queue-interface-java/
//https://www.geeksforgeeks.org/arraydeque-in-java/
//https://leetcode.com/problems/sliding-window-maximum/discuss/864529/Java-Deque-Visualization-with-code
//215. Kth Largest Element in an Array  check in arrayProblems
public class Queue<T> implements Iterable{
	
	private LinkedList<T> list =new LinkedList<>();
	
	public Queue() {}
	
	public Queue(T firstElem) {
		offer(firstElem);
	}
	
	public int size() {return list.size();}
	
	public boolean isEmpty() {return size()==0;}
	//Add last
	private void offer(T firstElem) {
		list.addLast(firstElem);
	}
	
	public T peek() {
		if(isEmpty())throw new RuntimeException("Queue Empty");
		return list.peekFirst();
	}
	//remove first 
	public T poll() {
		if(isEmpty())throw new RuntimeException("Queue Empty");
		return list.removeFirst();
	}
	

	@Override
	public Iterator iterator() {
		return list.iterator();
	}
	

	public static void main(String args[]) {
		//######################MAX HEAP IMLEMENTATION##############################
		//Method 1:
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder()); 
		//Method 2:
		PriorityQueue<Integer> maxPQ1 = new PriorityQueue<>((a,b) -> b - a); 
		//Method 3:
		PriorityQueue<Integer> maxPQ2 = new PriorityQueue<>((a,b) -> b.compareTo(a)); 
		
		//Max heap by deafult it min heap
		 PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b)->b-a); 
		 
		  
	        // Adding items to the pQueue using add() 
	        pQueue.add(10); 
	        pQueue.add(20); 
	        pQueue.add(15); 
	       
	        // Printing the top element of PriorityQueue 
	        System.out.println(pQueue.peek()); 
	  
	        // Printing the top element and removing it 
	        // from the PriorityQueue container 
	        System.out.println(pQueue.poll()); 
	  
	        // Printing the top element again 
	        System.out.println(pQueue.peek()); 
	        int size=pQueue.size();
	        
        for(int i=0;i<size;i++) {
            System.out.println("Elements in Queue:"+pQueue.poll());

        }
		
		
	}
	//451. Sort Characters By Frequency
	 public String frequencySort(String s) {
	        HashMap<Character,Integer> map=new HashMap<>();
	        for(char c:s.toCharArray())
	            map.put(c,map.getOrDefault(c,0)+1) ;
	        
	        PriorityQueue<Character> maxHeap=new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
	        maxHeap.addAll(map.keySet());
	        
	        StringBuilder result=new StringBuilder();
	        
	        while(!maxHeap.isEmpty()){
	            char c=maxHeap.poll();
	            for(int i=0;i<map.get(c);i++){
	                result.append(c);
	            }
	            
	        }
	        
	        return result.toString();
	    }
	 //Before this check in arrayProblems /215. Kth Largest Element in an Array 
	 //973. K Closest Points to Origin
	 public int[][] kClosest(int[][] points, int K) {
	        //configuring maxHeap with euclidean distance  sqrt of(x)
	        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->(b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
	                                                         
	        for(int[] a:points){
	            maxHeap.offer(a);
	            if(maxHeap.size()>K)
	                maxHeap.poll();
	        }
	                                                         
	        int[][] result=new int[K][2];
	        while(K-- > 0){
	            result[K]=maxHeap.poll();
	        }                                                 
	        return result;
	    }
	 //1046. Last Stone Weight
	  public int lastStoneWeight(int[] stones) {
	        if(stones==null) return 0;
	        if(stones.length==1) return stones[0]; 
	       PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
	        for(int i:stones)
	            pq.offer(i);
	        
	        while(!pq.isEmpty()){
	            int val1=pq.poll();
	            int val2=pq.poll();
	            
	            pq.offer(val1-val2);
	            
	            if(pq.size()==1)
	                return pq.poll();
	        }
	        
	        return 0;
	       
	    }
	  
	  //239. Sliding Window Maximum
	  public int[] maxSlidingWindow(int[] nums, int k) {
	        if (k == 0) return nums;
	    
	        int[] ans = new int[nums.length - k + 1];
	        Deque<Integer> q = new ArrayDeque<>();
	    
	        for (int i = 0; i < nums.length; i++) {
	            while (q.size() > 0 && nums[i] >= nums[q.getLast()]){
				    q.removeLast();
				}
	            q.addLast(i);
	            if (i - k + 1 >= 0) ans[i - k + 1] = nums[q.getFirst()];
	        
	            //finally remove max which is out of range
	            if (i - k + 1 == q.getFirst()) q.removeFirst();
	        }
	             
	        return ans;
	    }
	  
	  //215. Kth Largest Element in an Array          !!!MEDIUM!!!    #*        HINT:- if Largest or smallest mentioned in problem use heaps
	    public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> q=new PriorityQueue<Integer>();//min heap only kth lagest will remian at root rest mins will be removed as its min heap
	         for(int i:nums){
	             q.add(i);
	             if(q.size()>k)
	                 q.remove();
	         }
	         return q.remove();
	     }
	 
}
