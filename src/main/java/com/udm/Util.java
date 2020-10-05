package com.udm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.ivy.Main;

public class Util {
	private static Set<String> boaring = new HashSet<String>();

	static {
		InputStream is = Main.class.getResourceAsStream("/boaringwords.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		br.lines().forEach(it -> boaring.add(it));
	}

	public static boolean isBoaring(String w) {
		return boaring.contains(w);
	}

	public static boolean isNotBoaring(String w) {
		return !isBoaring(w);
	}
}
