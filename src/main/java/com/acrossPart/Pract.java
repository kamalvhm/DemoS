package com.acrossPart;

import java.util.Collections;
import java.util.PriorityQueue;

public class Pract {
	
	public static void main(String args []) {
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		//PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
		//PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b.compareTo(a));
		
		 pq.add(10); 
		 pq.add(20); 
		 pq.add(15); 
		 
	        // Printing the top element of PriorityQueue 
	        System.out.println(pq); 
	  
	        // Printing the top element and removing it 
	        // from the PriorityQueue container 
	        System.out.println(pq.poll()); 
	  
	        // Printing the top element again 
	        System.out.println(pq.peek());

	} 
	
	

}
