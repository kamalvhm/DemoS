package com.collections;

import java.util.Comparator;
import java.util.TreeSet;


public class IncreasingLengthOrder {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		
		
		TreeSet<Object> t1=new TreeSet<Object>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				String s1=o1.toString();
				String s2=o2.toString();
				
				if(s1.length() < s2.length()) return -1;
				else if (s1.length() > s2.length()) return +1;
				return 0;
			}
		});
		t1.add("B");
		t1.add("XX");
		t1.add("ABC");
		t1.add(new StringBuffer("ABC"));
		t1.add(new StringBuffer("AA"));
		t1.add(new StringBuffer("A"));
		
		System.out.print(t1);
	}

}
