package com.collections;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapDetails {

	public static void main(String[] args) {
		TreeMap<Integer,String> map=new TreeMap<>();
		map.put(2000,"Jhon");
		map.put(1000,"Paul");
		map.put(6000,"Jons");
		
//		System.out.println(map);
//		System.out.println(map.lastEntry());
//		System.out.println(map.firstKey());
//
//		Set<Integer> lessThan3K=map.headMap(3000).keySet();  //will give less then 3000 salary  (tailMap will give greater)
//		System.out.println(lessThan3K);
		
		
		 // Creating an empty TreeMap by 
        // declaring object of integer, string pairs 
        TreeMap<Integer, String> tree_map 
            = new TreeMap<Integer, String>(); 
  
        // Mapping string values to int keys 
        // using put() method 
        tree_map.put(10, "Geeks"); 
        tree_map.put(15, "4"); 
        tree_map.put(20, "Geeks"); 
        tree_map.put(25, "Welcomes"); 
        tree_map.put(30, "You"); 
  
        // Printing the elements of TreeMap 
        System.out.println("The original map is: "
                           + tree_map); 
  
        // Displaying the submap 
        // using subMap() method 
        System.out.println("The subMap is "
                           + tree_map.subMap(15, 30)); 

	}

}
