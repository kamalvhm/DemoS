package com.datastructure;

import java.util.LinkedList;



class Entry1<K, V> {
	K key;
	V value;
	int hash;

	Entry1(K k, V v) {
		this.key = k;
		this.value = v;
		hash=key.hashCode();
	}

	public boolean equals(Entry1<K,V> other) {
		if(hash!=other.hash)return false;
		return key.equals(other.key);
	}
	@Override
	public String toString() {
		return key+"->"+value;
	}
}
public class HashMap<K,V> {
	private LinkedList<Entry1<K,V>>[] map;
	private int size=0;
	private int capacity=16;
	
	public HashMap() {
		map=new LinkedList[capacity];
	}
	
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return this.size==0;
	}
	
	
	public int getBucketIndex(int hash) {
		return hash%capacity;
	}
	
public void put(K key,V value) {
	if (key == null) throw new IllegalArgumentException("Null key");
	Entry1<K, V> newEntry1 = new Entry1<>(key, value);
	int bucketIndex = normalizeIndex(newEntry1.hash);
	insertBucket(bucketIndex,newEntry1);
}

private V insertBucket(int bucketIndex,Entry1<K,V> Entry1) {
    LinkedList<Entry1<K, V>> bucket = map[bucketIndex];
    if (bucket == null) map[bucketIndex] = bucket = new LinkedList<>();
    
    Entry1<K,V> exiting=seekEntry1(bucketIndex,Entry1.key);
    if(exiting==null) {
    	bucket.add(Entry1);
    	size++;
    	return null;
    }else {
    	 V oldVal = exiting.value;
    	 exiting.value = Entry1.value;
         return oldVal;
    }
}

private Entry1<K, V> seekEntry1(int bucketIndex, K key) {
	  if (key == null) return null;
	    LinkedList<Entry1<K, V>> bucket = map[bucketIndex];
	    if (bucket == null) return null;
	    for (Entry1<K, V> Entry1 : bucket) if (Entry1.key.equals(key)) return Entry1;
	    return null;
}


private int normalizeIndex(int hash) {
	//return (hash&0x7FFFFFFF)%capacity;
	return (hash)%capacity;

}


public Entry1<K, V> get(K key) {
	int hash =normalizeIndex(key.hashCode());
	int index =getBucketIndex(hash);
	LinkedList<Entry1<K, V>> bucket = map[index];
    if (bucket == null) return null;
    for (Entry1<K, V> Entry1 : bucket) 
    	if (Entry1.key.equals(key)) return Entry1;
	return null;
}
	

public static void main(String args[]) {
	HashMap<Integer,String> map =new HashMap<>();
	for(int i=0;i<10;i++)
		map.put(i,"a"+i);
	
	for(int i=0;i<10;i++)
	System.out.println(map.get(i).value);
}
	

}
