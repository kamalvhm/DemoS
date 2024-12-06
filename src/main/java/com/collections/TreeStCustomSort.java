package com.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class TreeStCustomSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> t1=new TreeSet<>(new MyComparator());
		//TreeSet<Integer> t1=new TreeSet<>();
		t1.add(10);
		t1.add(0);
		t1.add(15);
		t1.add(20);
		t1.add(20);
		
		System.out.println(t1);

		
		
		TreeSet<String> t2=new TreeSet<String>(new MyComp());
		t2.add("kamal");
		t2.add("amit");
		t2.add("kapil");
		t2.add("bikoy");
		t2.add("roli");

		System.out.println(t2);
		
		
		TreeSet<StringBuffer> t3=new TreeSet<StringBuffer>(new Comparator<StringBuffer>() {

			@Override
			public int compare(StringBuffer o1, StringBuffer o2) {
				String s1= o1.toString();
				String s2= o2.toString();
				
				return -s1.compareTo(s2);
			}
		});
		t3.add(new StringBuffer("kamal"));
		t3.add(new StringBuffer("amit"));
		t3.add(new StringBuffer("kapil"));
		t3.add(new StringBuffer("bikoy"));
		t3.add(new StringBuffer("roli"));
		System.out.println(t3);
		
		//PriorityQueue Also can be used
		PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int val1=o1.length();
				int val2=o2.length();
				if(val1>val2)
					return -1;
				if(val2>val1)
					return 1;
				else return o1.compareTo(o2);
			}
		});
		
		 
	}
	


}
