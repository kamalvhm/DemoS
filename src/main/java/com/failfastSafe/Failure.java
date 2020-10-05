package com.failfastSafe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ConcurrentModificationException;

public class Failure {
	ArrayList<Integer> ids;
	ConcurrentHashMap<String, Integer> map;
	
	private void fastTest() {
    	System.out.println("Original size: " + ids.size());

		Iterator<Integer> iterator = ids.iterator();
		int i;
		while (iterator.hasNext()) {
			i = iterator.next();
		    if (i == 4 || i == 5) {
		    	iterator.remove();
		    	System.out.println("Removed an element by Iterator's remove() => size: " + ids.size());
		    }
		}
		 
		iterator = ids.iterator();
		try{
			while (iterator.hasNext()) {
		    	if (iterator.next() == 3) {	// Throws exception when it runs after remove() executes once.
		        	ids.remove(2); // Removes correctly once.
		        	System.out.println("Removed an element by Collection's remove() => size: " + ids.size());
				}
		    }
		}
		catch(ConcurrentModificationException e){
			System.out.println("Exception thrown because of concurrent modification!!\n");
		}
		
	}
	private void safeTest() {
		Iterator<String> iterator = map.keySet().iterator();

		int i = 0;
		try {
			while (iterator.hasNext()) {
			    String key = iterator.next();
			    if(key.equals("Third"))
			    	System.out.println("Removed element from map: " + map.remove("Third"));
			}
		}
		catch(ConcurrentModificationException e) {
			System.out.println("Exception thrown for modifying a ConcurrentHashMap");
		}
	}
	public static void main(String[] args) {
		Failure f = new Failure();
		f.fastTest();
		//f.safeTest();
	}
	Failure(){
		ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		ids.add(4);
		ids.add(5);
		
		map = new ConcurrentHashMap<>();
		map.put("First", 10);
		map.put("Second", 20);
		map.put("Third", 30);
		map.put("Fourth", 40);
	}
	
	
	
	/**						######Fail-fast######
	 *  A fail-fast iterator does not allow modifications to the Collection
	 * it traverses; this means, that it will throw out
	 * ConcurrentModificationException when such a Collection is modified while
	 * being traversed by its iterator. It is not necessary to modify and traverse
	 * the Collection using different threads to throw this exception; it will occur
	 * even if the modification and traversal are done in the same thread.
	 * 
	 * However, there is a difference between the iterator’s remove() function and
	 * the Collection’s remove() function. When the iterator’s remove() is invoked,
	 * no exception is thrown. The Collection’s remove(), on the other hand, throws
	 * this exception in case of concurrent modification.
	 * 						######Fail-safe######
	 *  A fail-safe iterator creates a copy of the Collection and then
	 * traverses it; this allows modification in the original Collection, but the
	 * changes may not be reflected during traversal. Moreover, creating a copy of a
	 * Collection is considered a waste of time and space. Therefore, when
	 * traversing a large Collection, fail-safe iterators can be a disadvantage.
	 */
}