package com.collections;

public class LRUCacheExamples {
	//https://www.geeksforgeeks.org/design-a-data-structure-for-lru-cache/
	//Also bit complex :-https://www.geeksforgeeks.org/lru-cache-implementation/
	public static void main(String[] args) {
		//Brute force :- we can have a array of Node(key,value,time_stamp) to get we can traverse and compare key and return O(n) 
		//to set we if array is full we can check least time_stamp and replace that element if not full we can add at the end O(n) to set also
		
		//Optimized :-using a double linked list which enables us to quickly move nodes The LRU cache is a hash map of keys and
		// double linked nodes The hash map makes the time of get() to be O(1). 
		//The list of double linked nodes make the nodes adding/removal operations O(1).
		/*************** Using LinkedHashMap**********************/

		LRUCache cache2 = new LRUCache(2);

		// it will store a key (1) with value
		// 10 in the cache.
		cache2.set(1, 10);

		// it will store a key (1) with value 10 in the
		// cache.
		cache2.set(2, 20);
		System.out.println("Value for the key: 1 is " + cache2.get(1)); // returns 10

		// evicts key 2 and store a key (3) with
		// value 30 in the cache.
		cache2.set(3, 30);

		System.out.println("Value for the key: 2 is " + cache2.get(2)); // returns -1 (not found)

		// evicts key 1 and store a key (4) with
		// value 40 in the cache.
		cache2.set(4, 40);
		System.out.println("Value for the key: 1 is " + cache2.get(1)); // returns -1 (not found)
		System.out.println("Value for the key: 3 is " + cache2.get(3)); // returns 30
		System.out.println("Value for the key: 4 is " + cache2.get(4)); // return 40
        
		/*************** Using LinkedHashMap**********************/

        System.out.println("Going to test the LRU "+ 
                           " Cache Implementation");
        LRUCacheLinked cache = new LRUCacheLinked(2);
  
        // it will store a key (1) with value 
        // 10 in the cache.
        cache.set(1, 10); 
 
        // it will store a key (1) with value 10 in the cache.
        cache.set(2, 20); 
        System.out.println("Value for the key: 1 is " + 
                           cache.get(1)); // returns 10
 
        // evicts key 2 and store a key (3) with
        // value 30 in the cache.
        cache.set(3, 30); 
 
        System.out.println("Value for the key: 2 is " + 
                cache.get(2)); // returns -1 (not found)
 
        // evicts key 1 and store a key (4) with
        // value 40 in the cache.
        cache.set(4, 40); 
        System.out.println("Value for the key: 1 is " +
               cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " + 
                           cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                           cache.get(4)); // return 40
        
        System.out.println("Going to test the LRU "
                + " Cache Implementation");
	}

}
