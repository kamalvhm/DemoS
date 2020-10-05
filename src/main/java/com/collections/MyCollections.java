package com.collections;

import java.util.Comparator;
import java.util.TreeSet;

public class MyCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<String> t =new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		t.add("c");
		t.add("a");
		t.add("b");
		t.add("d");
		
		
		System.out.println("A".compareTo("Z"));
		System.out.println("Z".compareTo("A"));
		System.out.println("A".compareTo("A"));


	}

}
