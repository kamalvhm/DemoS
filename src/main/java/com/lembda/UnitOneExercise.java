package com.lembda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


public class UnitOneExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BeanClass> list = Arrays.asList(
			new BeanClass(1,"kamal"),
			new BeanClass(2,"Ram"),
			new BeanClass(3,"Shyam"),
			new BeanClass(4,"Amit")
		);
		
		
		//Sort
		Collections.sort(list,(b1,b2)->b1.getName().compareTo(b2.getName()));
		//print all
		//list.forEach(System.out::println);
		printConditionally(list,p->true);
		
		//list.stream().filter(r->r.getName().startsWith("A")).forEach(System.out::println);
		
		printConditionally(list, (b)->b.getName().startsWith("S"));
	}
	
	public static void printConditionally(List<BeanClass> list,Predicate<BeanClass> c) {
		for(BeanClass b:list)
		{
			if(c.test(b))
				System.out.print(b);
		}
	}
	
	
	

}
