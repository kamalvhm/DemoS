package com.range;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSolution {
/**	Lets say i have below relationships 
	ralate SDP1 to METER1 on t1 time 
	ralate SDP1 to METER2 on t2 time 
	ralate SDP1 to METER3 on t3 time 
	ralate SDP1 to METER4 on t4 time 
	remove SDP1 to METER2 on t5 time 
	
	Now if i have queries like how many meters associated to SDP1 for timeRange t2 to t4 or any other queries how can i manage this kind of 
	data using efficient DS . */
	TreeMap<Integer,Set<String>> map=new TreeMap<>();//because we need time to be sorted order so thats why treeMap
	
	public void relate(int time,String meter) {
		map.putIfAbsent(time, new HashSet<>());
		map.get(time).add(meter);
	}
	
	public void remove(int time,String meter) {
		if(map.containsKey(time))map.get(time).remove(meter);
	}
	
	public Set<String> query(int t1,int t2){
		Set<String> result=new HashSet<>();
		for(int time:map.subMap(t1,true, t2,true).keySet()) {  //will return submap
			result.addAll(map.get(time));
		}
		return result;
	}
	

	public static void main(String[] args) {
		//		Insert/Delete:O(logn) 
		//		Query:O(log n+k)
		/**
		* 	Interval Tree	Best for range overlap queries
			Segment Tree	Best for fast prefix sum queries
			TreeMap	Simple, fast insert/query in small datasets
		 */
		 	TreeMapSolution solution = new TreeMapSolution();
	        solution.relate(1, "METER1");
	        solution.relate(2, "METER2");
	        solution.relate(3, "METER3");
	        solution.relate(4, "METER4");
	        solution.relate(5, "METER5");


	        System.out.println("Active meters in range [2, 4]: " + solution.query(2, 4));
	        
	        System.out.println("Active meters in upto [4]: " + solution.query(0, 4));


	}

}
