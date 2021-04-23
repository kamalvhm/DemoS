package com.collections;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDetails {

	public static void main(String[] args) {
		TreeMap<Integer,String> map=new TreeMap<>();
		map.put(2000,"Jhon");
		map.put(1000,"Paul");
		map.put(6000,"Jons");
		
		System.out.println(map);
		System.out.println(map.lastEntry());
		System.out.println(map.firstKey());

		Set<Integer> lessThan3K=map.headMap(3000).keySet();  //will give less then 3000 salary  (tailMap will give greater)
		System.out.println(lessThan3K);

	}

}
