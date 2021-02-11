package com.cleanup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueRandom {
	ArrayList<Integer> list=null;
	int index;
	
	public UniqueRandom() {
		list=new ArrayList<>(10);
		index=0;
		
		for(int i=1;i<=10;i++) {
			list.add(i);
		}
		Collections.shuffle(list);
	}
	
	public int get() {
		if(index>=10) {
			index%=10;
		}
		return list.get(index++);
	}
	
	/*public static final int SET_SIZE_REQUIRED = 10;
	public static final int NUMBER_RANGE = 100;
	public static void main(String args[]) {
		   Random random = new Random();
		   
           Set set = new HashSet<Integer>(SET_SIZE_REQUIRED);

           while(set.size()< SET_SIZE_REQUIRED) {
               while (set.add(random.nextInt(NUMBER_RANGE)) != true)
                   ;
           }
           assert set.size() == SET_SIZE_REQUIRED;
           System.out.println(set);
	}*/
}
