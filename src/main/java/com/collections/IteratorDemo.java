package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		LinkedList<String> l=new LinkedList<>();
		l.add("a");
		l.add("b");
		l.add("c");
		Iterator<String> i=l.iterator();
		while(i.hasNext()) {
            String current = i.next(); // Retrieve the current element
            if (current.equals("b")) {
                i.remove(); // Safely remove the element
            } else {
                System.out.println(current); // Print the element if not removed
            }
		}
		
		ArrayList<String> list=new ArrayList<>();
		list.add("a");	
		list.add("b");	
		list.add("c");	
		list.add("d");	
		list.add("e");	

		ListIterator<String> li=list.listIterator();
		System.out.println("####################LIST INTERATOR #################");

		while(li.hasNext()) {
			String current=li.next();
			if(current.equals("b"))li.remove();
			else System.out.println(current);

		}
		
		
	}

}
