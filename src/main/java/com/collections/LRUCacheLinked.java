package com.collections;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCacheLinked {
	//removeEldestEntry() is overridden to impose a policy for removing old mappings when size goes beyond capacity.

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCacheLinked(int capacity)
	{
		CAPACITY = capacity;
		map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) { //access order is true 
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > CAPACITY;
			}
		};
	}
 
    // This method works in O(1)
    public int get(int key)
    {
        System.out.println("Going to get the value " + 
                               "for the key : " + key);
        return map.getOrDefault(key, -1);
    }
 
    // This method works in O(1)
    public void set(int key, int value)
    {
        System.out.println("Going to set the (key, " + 
             "value) : (" + key + ", " + value + ")");
        map.put(key, value);
    }
}