package dels;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.spark.sql.catalyst.analysis.EliminateEventTimeWatermark;


public class HashMap<K,V>{
	
	class Entry<K,V> {
		K key;
		V value;
		int hash;
		Entry(K k,V v){
			this.key=k;
			this.value=v;
			hash=key.hashCode();
		}
		
		public boolean equals(Entry<K,V> o) {
			if(this.hash!=o.hash)return false;
			return this.key.equals(o.key);
		}
	}
	
	private int capacity=0,threshold=0,size=0;
	private LinkedList<Entry> [] table;
	
	HashMap(){
		capacity=16;
		threshold=(int)(capacity*0.75f);
		table=new LinkedList[capacity];
		size=0;
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size()==0;}
	
	private int getbucketIndex(K key) {return key.hashCode()%capacity;}
	
	public void put(K key,V value) {
		if(key==null)throw new IllegalArgumentException("null key");
		int bucketIndex=getbucketIndex(key);
		Entry<K,V> e=new Entry<>(key,value);
		insertbucketEntry(bucketIndex,e);
	}
	
	public V get(K key) {
		if(key==null)throw new IllegalArgumentException("null key");
		int bucketIndex=getbucketIndex(key);
		Entry<K,V> entry=seekBucketEntry(bucketIndex,key);
		if(entry!=null)
			return entry.value;
		return null;
	}
	
	public void remove(K key) {
		if(key==null)throw new IllegalArgumentException("null key");
		int bucketIndex=getbucketIndex(key);
		Entry<K,V> entry=seekBucketEntry(bucketIndex,key);
		if(entry!=null) {
			LinkedList<Entry> list=table[bucketIndex];
			list.remove(entry);
			size--;
		}
	}
	
	

	private void insertbucketEntry(int bucketIndex, Entry<K, V> entry) {
		LinkedList<Entry> bucket=table[bucketIndex];
		if(bucket==null)table[bucketIndex]=bucket=new LinkedList<>();
		Entry<K,V> existing=seekBucketEntry(bucketIndex, entry.key);
		if(existing==null) {
			bucket.add(entry);
			if(size++>threshold)resize();
		}
		else {
			existing.value=entry.value;
		}
	}
	private Entry<K, V> seekBucketEntry(int bucketIndex, K key) {
		if(key==null)throw new IllegalArgumentException("null key");
		LinkedList<Entry> list=table[bucketIndex];
		if(list!=null)for(Entry e:list) if(e.key.equals(key))return e;
		return null;
	}
	
	
	private void resize() {
		capacity*=2;
		threshold=(int)(capacity*0.75f);
		LinkedList<Entry>[] newTable=new LinkedList[capacity];
		
		for(int i=0;i<table.length;i++) {
			if(table[i]!=null) {
				for(Entry<K,V> entry:table[i]) {
					int bucketIndex=getbucketIndex(entry.key);
					LinkedList<Entry> bucket=newTable[i];
					if(bucket==null) bucket=newTable[i]=new LinkedList<>();
					bucket.add(entry);
				}
				table[i].clear();
				table[i]=null;
			}
		}
		table=newTable;
		
	}
	
}
