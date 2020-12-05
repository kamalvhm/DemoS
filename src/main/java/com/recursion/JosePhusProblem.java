package com.recursion;

import java.util.ArrayList;

public class JosePhusProblem {
	  // Suppose there are n people in a circle and person
	  // 0 kill the k'th person, then the k'th person kills
	  // the 2k'th person and so on until only one person remains.
	  // The question is who lives?
	  // Let n be the number of people and k the hop size
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number_of_person=40; //40 persons in circle counting one by one 7 person will die 
		int die_index=7;
		
		ArrayList<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<=number_of_person;i++)
			list.add(i);
		//array is zero indexed so -1  
		die_index=die_index-1;
		System.out.print(solve(list,die_index,0));
	}
	
	public static int solve(ArrayList<Integer> list,int k,int index) {
		if(list.size()==1) {
			return list.get(0);
		}else {
			index=(index+k)%list.size();
			list.remove(index);
			return solve(list,k,index);		
		}
	}
	

}
