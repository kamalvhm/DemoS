package com.lembda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;



public class UnitOneExerciseV13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BeanClass> list = Arrays.asList(
			new BeanClass(1,"kamal"),
			new BeanClass(2,"Ram"),
			new BeanClass(3,"Shyam"),
			new BeanClass(4,"Amit")
		);
		
		
		//Step 1:- Sort the list by name
		Collections.sort(list,(b1,b2)->b1.getName().compareTo(b2.getName()));
		//Step 2:- print all
		//list.forEach(System.out::println);
		printConditionally(list,p->true);
		
		//list.stream().filter(r->r.getName().startsWith("A")).forEach(System.out::println);
		//Step3:- print all name which start from S
		printConditionally(list, (b)->b.getName().startsWith("S"));
	}
	
	public static void printConditionally(List<BeanClass> list,Predicate<BeanClass> c) {
		for(BeanClass b:list)
		{
			if(c.test(b))
				System.out.print(b);
		}
	}
/**   Doing with a confition interface 
	//Step 1:- Sort the list by name
	Collections.sort(list,(a,b)->a.getName().compareTo(b.getName()));
	//Step 2:- print all
	//list.forEach(System.out::println);
	printConditionally(list, p->true);
	
	//list.stream().filter(r->r.getName().startsWith("A")).forEach(System.out::println);
	//Step3:- print all name which start from S
	printConditionally(list,(a)->a.getName().startsWith("S"));
	public static void printConditionally(List<BeanClass> list,Condition cond) {
		for(BeanClass l:list) {
			if(cond.test(l))
				System.out.println(l);
		}
	}
	
	interface Condition{
		boolean test(BeanClass t);
	}
*/
}
