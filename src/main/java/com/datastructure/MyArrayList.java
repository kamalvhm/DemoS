package com.datastructure;

import java.util.Arrays;

public class MyArrayList<T> {
	
	private Object[] arr;
	private int index;
	private int current_capacity=10;
	
	
	MyArrayList(){
		arr=new String[current_capacity];
		index=0;
	}
	
	public void add(String a) {
		if(index==current_capacity) {
			current_capacity=current_capacity*2;
			Object[] tempArr=new Object[current_capacity];
			for(int i=0;i<arr.length;i++)
				tempArr[i]=arr[i];
			arr=tempArr;
			arr[index]=a;
			index++;		
		}else {
			arr[index]=a;
			index++;
		}
	}
	
	public boolean delete(int i) {
		if(i>index)
			return false;
			else {
				for(int j=i;j<index;j++)
					arr[j-1]=arr[j];
				arr[index-1]=null;
			}
		return true;
	}
	
	public int length() {
		return index;
	}
	
	public T get(int i) {
		return (T) arr[i];
	}
	
	@Override
	public String toString() {
		return "MyArrayList [arr=" + Arrays.toString(arr) + "]";
	}
	
	


}
