package com.collections;

import java.util.Comparator;

class MyComp implements Comparator<String>{

			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
			
		}