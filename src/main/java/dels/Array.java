package dels;

import java.util.Iterator;

public class Array<T> implements Iterable<T> {
	
	private T[] arr;
	int len;
	int capacity;
	
	public Array() {
		this(16);
	}
	
	public Array(int cap) {
		if(cap<0)throw new IllegalArgumentException("Capacity should be > 0");
		this.capacity=cap; 
		arr=(T[]) new Object[capacity];
		len=0;
		
	}
	
	public int size() {return this.len;}
	
	public boolean isEmpty() {return size()==0;}
	
	public T get(int index) {return arr[index];}
	
	public void set(int index,T a) {arr[index]=a;}
	
	public void clean() {
		for(int i=0;i<size();i++)
				arr[i]=null;
		len=0;
	}
	
	public void add(T a) {
		if(len+1>=capacity) {
			if(capacity==0) capacity=1;
			capacity*=2;
			T [] newArr=(T[]) new Object[capacity];
			for(int i=0;i<size();i++) {
				newArr[i]=arr[i];
			}
			arr=newArr;
		}
		arr[len++]= a;

	}
	
	
	
	
	
	public T remove(int index) {
		if(index<0 || index>=len)throw new IllegalArgumentException("Capacity should be > 0");
		
		T obj=arr[index];
		
		T[] newArr=(T[]) new Object[len-1];
		for(int i=0,j=0;i<len;i++,j++) {
			if(index==i)j--;
			else
			newArr[j]=arr[i];
			
		}
		arr=newArr;
		capacity=--len;
		return obj;
	}

	@Override
	public java.util.Iterator<T> iterator() {
		return new java.util.Iterator<T>() {
			int index=0;
			@Override
			public boolean hasNext() {
				return index<len;
			}

			@Override
			public T next() {
				return arr[index++];
			}
			
		};
	}
	
	
	

}
