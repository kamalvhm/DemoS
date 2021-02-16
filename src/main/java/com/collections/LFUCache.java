package com.collections;

import java.util.HashMap;
import java.util.Map;
//460. LFU Cache
//https://www.dineshonjava.com/least-frequently-used-lfu-cache-implementation/
public class LFUCache {
	private class Node {
		
		long key;
		long value;
		int frequency;
		Node prev;
		Node next;
	 
	    public Node(long key, long value, int frequency){
	        this.key   = key;
	        this.value = value;
	        this.frequency = frequency;
	    }
	}
	/**************LFU***************/
	Node head;
	Node tail;
	Map<Long, Node> map = null;
	int capacity = 0;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
	}

	public long get(long key) {

		if (map.get(key) == null) {
			return -1;
		}

		Node item = map.get(key);
		// move to right position according to frequency
		removeNode(item);
		item.frequency = item.frequency+1;
		addNodeWithUpdatedFrequency(item);

		return item.value;
	}

	public void put(Long key, int value) {

		if (map.containsKey(key)) {
			Node item = map.get(key);
			item.value = value;
			item.frequency = item.frequency + 1;
			// move to right position according to frequency
			removeNode(item);
			addNodeWithUpdatedFrequency(item);
		} else {
			if (map.size() >= capacity) {
				// delete head with least frequency and least recently used
				map.remove(head.key);
				removeNode(head);
			}

			// move to right position according to frequency
			Node node = new Node(key, value, 1);
			addNodeWithUpdatedFrequency(node);
			map.put(key, node);
		}
	}

	private void removeNode(Node node) {

		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			head = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			tail = node.prev;
		}
	}

	private void addNodeWithUpdatedFrequency(Node node) {
        
		if (tail != null && head != null) {
			Node temp = head;
			while(temp != null) {
				if(temp.frequency > node.frequency) {
					if(temp == head) {
						node.next = temp;
						temp.prev = node;
						head = node;
						break;
					}else {
						node.next = temp;
						node.prev = temp.prev;
						temp.prev.next = node;
						node.prev = temp.prev;
						break;
					}
				}else {
					temp = temp.next;
					if(temp == null) {
						tail.next = node;
						node.prev = tail;
						node.next = null;
						tail = node;
						break;
					}
				}
			}
		} else {
			tail = node;
			head = tail;
		}
	}
	/**************TEST***************/
	public static void main(String[] args) {
		
		System.out.println("Going to test the LFU Cache Implementation"); 
		
		LFUCache cache = new LFUCache(5);
		
		//Storing first value 10 with key (1) in the cache with default frequency. 
        cache.put(1l, 10);  
        
      //Storing second value 20 with key (2) in the cache with default frequency. 
        cache.put(2l, 20);
        
      //Storing third value 30 with key (3) in the cache with default frequency. 
        cache.put(3l, 30);
        
      //Storing fourth value 40 with key (4) in the cache with default frequency. 
        cache.put(4l, 40);
        
      //Storing fifth value 50 with key (5) in the cache with default frequency. 
        cache.put(5l, 50);
        
        
        System.out.println("Value for the key: 1 is " +  
                           cache.get(1)); // returns 10 and increased frequency
  
      // evicts key 2 and store a key (6) with value 60 in the cache  with default frequency. 
        cache.put(6l, 60);  
  
        System.out.println("Value for the key: 2 is " +  
                cache.get(2)); // returns -1 (not found) 
  
        //evicts key 3 and store a key (7) with value 70 in the cache with default frequency. 
        cache.put(7l, 70); 
        
        System.out.println("Value for the key: 3 is " + 
               cache.get(3)); // returns -1 (not found) 
        
        System.out.println("Value for the key: 4 is " +  
                           cache.get(4)); // returns 40 
        
        System.out.println("Value for the key: 5 is " + 
                           cache.get(5)); // return 50 
		
	}

}

 
