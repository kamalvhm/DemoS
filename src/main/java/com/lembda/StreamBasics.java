package com.lembda;

import java.util.Arrays;
import java.util.List;

public class StreamBasics {

	public static void main(String[] args) {
		List<BeanClass> list = Arrays.asList(
				new BeanClass(1,"kamal"),
				new BeanClass(2,"Ram"),
				new BeanClass(3,"Shyam"),
				new BeanClass(4,"Amit")
			);
		
		list.stream().filter(p->p.getName().contains("a")).forEach(System.out::println);

	}

}
