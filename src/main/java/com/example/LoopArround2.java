package com.example;

import java.util.ArrayList;
import java.util.ListIterator;

public class LoopArround2 {

	public static void main(String[] args) throws Exception{
	int[] arr=new int[24];
	ArrayList<Integer> arra=new ArrayList<Integer>();

	
	for(int i=1;i<=24;i++)
		arra.add(1);
	
/*	for(Integer d:arra)
		System.out.println("IN:----> "+d);*/
	
	double[] out=calcAlpUsageforHour(arra);
	
	for(double d:out)
		System.out.println("OUT:----> "+d);
		
	
	
	}
	
	private static double[] calcAlpUsageforHour(ArrayList<Integer> rec) {
	      double[] alpUsageHour = new double[24];
	      double alpUsage = 0.0;
	      for(int index=1; index<= rec.size();index++) {
	          alpUsage += rec.get(index-1);
	          if(index%4 == 0) {
	            alpUsageHour[(index/4)-1]= alpUsage;
	            alpUsage=0.0;
	          }
	      }
	      return alpUsageHour;
	   }
	
	
	

}
