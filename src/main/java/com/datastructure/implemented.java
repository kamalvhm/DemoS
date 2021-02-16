package com.datastructure;
import java.util.HashMap;

// predefined HashSet class
 class HashSet<E>
{
    // A HashMap object 
    private transient HashMap map;

    // A Dummy value(PRESENT) to associate with an Object in the Map
    private static final Object PRESENT = new Object();
    
    // default constructor of HashSet class
    // It creates a HashMap by calling 
    // default constructor of HashMap class
    public HashSet() {
        map = new HashMap<>();
    }

    // add method 
    // it calls put() method on map object
    // and then compares it's return value with null
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
 
    // Other methods in Hash Set
    
    public static void main(String args[])  
    { 
        // creating a HashSet 
        HashSet hs = new HashSet(); 
          
        // adding elements to hashset 
        // using add() method 
        boolean b1 = hs.add("Geeks"); 
        boolean b2 = hs.add("GeeksforGeeks"); 
          
        // adding duplicate element 
        boolean b3 = hs.add("Geeks"); 
          
        // printing b1, b2, b3 
        System.out.println("b1 = "+b1); 
        System.out.println("b2 = "+b2); 
        System.out.println("b3 = "+b3); 
          
        // printing all elements of hashset 
        System.out.println(hs); 
              
    } 
}