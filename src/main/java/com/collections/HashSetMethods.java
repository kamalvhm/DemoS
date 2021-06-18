package com.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Iterables;

public class HashSetMethods {

	public static void main(String[] args) {
		
		//Set<Integer> set=new HashSet<>();
		List<Integer> set=new ArrayList<>();
		
		for(int i=0;i<45;i++)
			set.add(i);
		
		Iterables.partition(set, 10).forEach(batch->process(batch));
		

	}
	
	public static void process(Collection<Integer> batch) {
		for(int i:batch)
			System.out.print(i+" ");
		
		System.out.println("    |BATCH OVER");
	}

}
