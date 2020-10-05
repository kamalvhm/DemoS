package com.collections;

import java.util.TreeSet;

public class CompCompDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Employee> t1=new TreeSet<Employee>();
		 t1.add(new Employee("Ram", 1));
		 t1.add(new Employee("Shyam", 2));
		 t1.add(new Employee("Amit", 3));
		 t1.add(new Employee("Mohan", 4));
		 t1.add(new Employee("bikoy", 5));
		 
		 System.out.println(t1);
		 System.out.println("********************");

		 TreeSet<Employee> t2=new TreeSet<Employee>((e1,e2)-> {
			 if(e1.id<e2.id)return +1;
			 else if (e1.id>e2.id)return -1;
			 else return 0;
		 });
		 
		 t2.add(new Employee("Ram", 1));
		 t2.add(new Employee("Shyam", 2));
		 t2.add(new Employee("Amit", 3));
		 t2.add(new Employee("Mohan", 4));
		 t2.add(new Employee("bikoy", 5));

		 System.out.println(t2);

		

	}

}
