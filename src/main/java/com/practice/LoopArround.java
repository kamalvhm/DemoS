package com.practice;

import java.util.ArrayList;
import java.util.ListIterator;

public class LoopArround {

	public static void main(String[] args) throws Exception{
	int[] arr=new int[24];
	ArrayList<Integer> arra=new ArrayList<Integer>();

	ArrayList<String> arrb=new ArrayList<String>();
	
	for(int i=1;i<=24;i++)
		arr[i-1]=i;
	
	for(int i=1;i<=24;i++)
		arra.add(i);
	
	for(int i=1;i<=96;i++)
		arrb.add("B"+i);
	
	ListIterator<Integer> listIt1=arra.listIterator();
	ListIterator<String> listIt2=arrb.listIterator();
	
	Integer firstVal=0;
	int index=0;
	while(listIt2.hasNext()) {
		if(index%4==0 && listIt1.hasNext())
		firstVal=listIt1.next();
			System.out.println("FISRT:- "+firstVal+" | SECOUND:-"+listIt2.next()+ " | Third :-"+arr[(index/4)]);
		
		index++;
	}
	
	double[] alpUsageHour = new double[24];
	System.out.println("PRINTS");

	for(double d:alpUsageHour)
		System.out.println("--->"+d);
	
	
	
	
	
	
	
	
	}
	
	

}
