package com.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

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
		//Max heap by deafult it min heap
		 PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b)->b-a); 
		  
	        // Adding items to the pQueue using add() 
	        pQueue.add(10); 
	        pQueue.add(20); 
	        pQueue.add(15); 
	  
	        // Printing the top element of PriorityQueue 
	       // System.out.println(pQueue.peek()); 
	  
	        // Printing the top element and removing it 
	        // from the PriorityQueue container 
	        //System.out.println(pQueue.poll()); 
	  
	        // Printing the top element again 
	        //System.out.println(pQueue.peek()); 
	        int size=pQueue.size();
        for(int i=0;i<size;i++) {
            System.out.println("Elements in Queue:"+pQueue.poll());

        }
		
		
	}

}
