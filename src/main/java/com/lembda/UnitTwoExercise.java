package com.lembda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class UnitTwoExercise {

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
		purformConditionally(list,p->true,p->System.out.println(p));
		
		//list.stream().filter(r->r.getName().startsWith("A")).forEach(System.out::println);
		
		purformConditionally(list, (b)->b.getName().startsWith("S"),p->System.out.println(p));
	}
	//Consume Takes a imput and returns void so as we need to pass SOP behaviour here so its perfect 
	public static void purformConditionally(List<BeanClass> list,Predicate<BeanClass> p,Consumer<BeanClass> c) {
		for(BeanClass b:list)
		{
			if(p.test(b))
				c.accept(b);
		}
	}
	
	
	

}
