package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//380. Insert Delete GetRandom O(1)
//with Array + HashSet ,and Array + hashMap (Better approach) its possible because in hashset and Map random access is not there 
//HashMap of Value as key and Index in array as value
//https://www.youtube.com/watch?v=WtkwD7ikxfg
class RandomizedSet {
    Map<Integer, Integer> hash;
    ArrayList<Integer> list;
    java.util.Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hash = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        random = new java.util.Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hash.containsKey(val)) return false;
        
        hash.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hash.containsKey(val)) return false;
        
        int index = hash.get(val);////to avoid shifting we will remove last element from Array List 
        if(index < list.size() - 1) { //replace existing with last index and remove last and update in map if its not last 
            list.set(index, list.get(list.size() -1));
        }
        hash.put(list.get(list.size() - 1), index);//updating index in map for last value as its changed
        hash.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}






/**
  class RandomizedSet {
    HashSet<Integer> set;
    java.util.Random random;
    ArrayList<Integer> list;
    *//** Initialize your data structure here. *//*
    public RandomizedSet() {
        set=new HashSet<>();
        random=new Random();
        list=new ArrayList<>();
    }
    
    *//** Inserts a value to the set. Returns true if the set did not already contain the specified element. *//*
    public boolean insert(int val) {
        if(set.contains(val))return false;
        set.add(val);
        list.add(val);
        return true;
    }
    
    *//** Removes a value from the set. Returns true if the set contained the specified element. *//*
    public boolean remove(int val) {
        if(!set.contains(val))return false;
        set.remove(val);
        list.remove(Integer.valueOf(val));
        return true;
    }
    
    *//** Get a random element from the set. *//*
    public int getRandom() {
        //Integer[] temp = set.toArray(new Integer[0]);// no index in set so getting array from set
        return list.get(random.nextInt(list.size()));
    }
}*/
