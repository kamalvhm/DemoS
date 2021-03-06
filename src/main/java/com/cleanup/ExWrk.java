package com.cleanup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExWrk {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// List<String> list = Arrays.asList("Geeks", "for", "Geeks", "GeeksQuiz",
		// "for", "GeeksforGeeks");

		// System.out.println("The distinct elements are :");

		// Displaying the distinct elements in the list
		// using Stream.distinct() method
		// list.stream().distinct().forEach(System.out::println);
		System.out.println(getPhone("23"));

		HashMap<Integer, String> hash_map = new HashMap<Integer, String>();

		// Mapping string values to int keys
		hash_map.put(10, "EM.ELECTRIC.KWH.1.4");
		hash_map.put(15, "EM.ELECTRIC.KWH.1.6");
		hash_map.put(20, "EM.ELECTRIC.KWH.1.4");
		hash_map.put(25, "EM.ELECTRIC.KWH.1.6");
		// hash_map.put(30, "You");

		// Displaying the HashMap
		// System.out.println("Initial Mappings are: " + hash_map);

		// Using values() to get the set view of values
		// System.out.println("The collection is: " + hash_map.values());

		// System.out.println("The set is: " + hash_map.entrySet());
	//	StringBuffer measTypeIdStr = getUniqueAggrMeasTypeUdcStrFromMap(hash_map);
		//System.out.println(measTypeIdStr.substring(0, measTypeIdStr.length() - 1));
		StringBuffer measTypeIdStr=new StringBuffer("hello");
		measTypeIdStr.insert(0, "'").insert(measTypeIdStr.length(), "'");
		
		System.out.println(measTypeIdStr);


	}
	
	
	public static List<String>  getPhone(String a) {
		HashMap<Character,String> m=new HashMap<>();
		 	m.put('2',"abc");
	        m.put('3',"def");
	        m.put('4',"ghi");
	        m.put('5',"jkl");
	        m.put('6',"mno");
	        m.put('7',"pqrs");
	        m.put('8',"tuv");
	        m.put('9',"wxyz");

		List<String> out=new ArrayList<>();
		while(a.length()>0) {
			
			
			char[] firstdigit=m.get(a.charAt(0)).toCharArray();
			a=a.substring(1);
			if(a.length()<=0) break;
			char[] secoundDigit=m.get(a.charAt(0)).toCharArray();
			a=a.substring(1);
			
			for(int i=0;i<firstdigit.length;i++) {
				char firstChar=firstdigit[i];
				for(char c:secoundDigit)
					out.add(firstChar+""+c);
			}
			
		}
		return out;
	}

	public String getUniqueAggrMeasTypeUdcIds2(HashMap<Integer, String> hash_map) {
		hash_map.values().stream().distinct().collect(Collectors.toList());
		return null;
	}

	public static StringBuffer getUniqueAggrMeasTypeUdcStrFromMap(HashMap<Integer, String> measType_map) {
		if (measType_map.isEmpty()) {
			throw new RuntimeException("measUdcIdsMap is null for usage date");
		}
		StringBuffer measTypeIdStr = new StringBuffer();
		Set<String> uniqueMeasTypes = new HashSet<>();
		uniqueMeasTypes.addAll(measType_map.values());

		for (String measUdcId : uniqueMeasTypes) {
			measTypeIdStr.append("'" + measUdcId + "',");
		}

		return measTypeIdStr;
	}

}
