package com.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FrectionalKnapSackGreedy {

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 }; 
        int[] val = { 60, 40, 100, 120 }; 
        int capacity = 50; 
  
        double maxValue = getMaxValue(wt, val, capacity); 
        
        // Function call 
        System.out.println("Maximum value we can obtain = "+ maxValue); 
	}
	
	private static double getMaxValue(int[] wt, int[] val, int capacity) {
		Item[] iVal = new Item[wt.length];

		for (int i = 0; i < wt.length; i++) {
			iVal[i] = new Item(wt[i], val[i], i);
		}

		// sorting items by value;
		Arrays.sort(iVal, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o2.ratio.compareTo(o1.ratio);
			}
		});

		double totalValue = 0d;

		for (Item i : iVal) {

			int curWt = (int) i.wt;
			int curVal = (int) i.val;

			if (capacity - curWt >= 0) {
				// this weight can be picked while
				capacity = capacity - curWt;
				totalValue += curVal;
			} else {
				// item cant be picked whole
				double fraction = ((double) capacity / (double) curWt);
				totalValue += (curVal * fraction);
				capacity = (int) (capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}
	
	
	// item value class 
    static class Item  
    { 
        Double ratio; 
        double wt, val, ind; 
  
        // item value function 
        public Item(int wt, int val, int ind) 
        { 
            this.wt = wt; 
            this.val = val; 
            this.ind = ind; 
            ratio = new Double((double)val / (double)wt); //profit to weight
        } 
    } 

}
