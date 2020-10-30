package com.lockedProblems;

import java.util.HashSet;

public class NextClosestTime {

	public static void main(String[] args) {
		//should return 19:39 which if formed amoung these four digits
		System.out.println(getNextClosestTime("19:34"));
	}
	
	public static String getNextClosestTime(String time) {
		String[] splits=time.split(":");
		int minutes=Integer.parseInt(splits[0])*60+Integer.parseInt(splits[1]);
		HashSet<Integer> digits=new HashSet<>();
		for(char c:time.toCharArray()) {
			//convert char to int;
			digits.add(c-'0');
		}
		while(true) {
			// % by 1440 
			minutes=(minutes+1)%(24*60);
			//convert it back to out older time 
			int [] nextTime = {minutes/60/10 ,minutes/60%10,minutes%60/10,minutes%60%10};
			boolean isvalid=true;
			for(int dig:nextTime) {
				if(!digits.contains(dig)) 
					isvalid=false;
			}
			
			if(isvalid)
				return String.format("%02d:%02d", minutes/60,minutes%60);
		}
		
		
	}

}
