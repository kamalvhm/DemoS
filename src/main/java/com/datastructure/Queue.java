package com.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

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

}
