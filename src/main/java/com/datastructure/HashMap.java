package com.datastructure;

import java.util.Iterator;
import java.util.LinkedList;

class Entrry<K,V>{
	 K key;
	 V value;
	 int hash;
	 
	 Entrry(K key,V value){
		 this.key=key;
		 this.value=value;
		 this.hash=key.hashCode();
	 }
	 
	 public boolean equals(Entrry elem) {
		 if(this.hash!=elem.hash) return false;
		 else return key.equals(elem.key);
	 }
	 
	  @Override
	  public String toString() {
	    return key + " => " + value;
	  }
	 
}

public class HashMap<K,V> implements Iterable<K> {
	
	private static final int DEFAULT_CAPACITY=3;
	private static final double DEFAULT_LOADFACTOR=0.75;
	
	private int capacity,threshold,size=0;
	private double max_loadfactor;
	private LinkedList<Entrry<K,V>> [] table;
	
	
	public HashMap(){
		this(DEFAULT_CAPACITY,DEFAULT_LOADFACTOR);
		}
	
	
	public HashMap(int initial_cap,double loadfactor){
		if(capacity<0) throw new IllegalArgumentException("Illegal capacity");
		if(loadfactor<=0 || Double.isNaN(loadfactor) || Double.isFinite(loadfactor)) throw 
		new IllegalArgumentException("Illegal loadfactor");
		this.capacity=initial_cap;
		this.max_loadfactor=Math.max(DEFAULT_LOADFACTOR, loadfactor);
		this.threshold=(int) (this.capacity*max_loadfactor);
		this.table=new LinkedList[this.capacity];
	}


	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
