package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class SortAnArrayV6 {
	public static void main(String args[]) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(4);
		list.add(6);
		list.add(3);
		list.add(1);
		
		System.out.println(list);
		sortArraList(list);
		System.out.println(list);

	}
	
	public static void sortArraList(List<Integer> list) {
		if(list.size()==1) return ;
		
		int tmp=list.remove(0);
		sortArraList(list);
		insert(list,tmp);
		return ;
		
	}

	private static void insert(List<Integer> list, int tmp) {
		if(list.size()==0 || list.get(list.size()-1)<=tmp) {
			list.add(tmp);
			return;
		}
		
		int t =list.remove(list.size()-1);
		insert(list, tmp);
		list.add(t);
		return;
		
	}
}
