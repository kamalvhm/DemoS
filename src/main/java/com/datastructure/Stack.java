package com.datastructure;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable {

	private LinkedList<T> list =new LinkedList<>();

	public Stack(){}
	
	public Stack(T firstElem){
		push(firstElem);
	}
	
	public int size() {
		return list.size();
	}

	public void push(T firstElem) {
		list.addFirst(firstElem);
	}
	
	
	public T pop() {
		if(isEmpty()) throw new EmptyStackException();
		return list.removeFirst();
	}
	
	public T peek() {
		if(isEmpty())throw new EmptyStackException();
		return list.peekLast();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	

	@Override
	public Iterator iterator() {
		return list.iterator();
	}

}
