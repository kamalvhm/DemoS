package com.lockedProblems;

import java.util.Arrays;
import java.util.PriorityQueue;

class Interval{
	int start;
	int end;
	Interval(){start=0;end=0;};
	Interval(int s,int e){
		start=s;
		end=e;
	}
}
public class MeetingRoom {
	
	public static void main(String args[]) {
		//output should be 2 coz we can have 2 and 3 in one and first in other 
		Interval[] meeting= {
				new Interval(0,30),
				//this conflicting with first
				new Interval(5,10),
				
				new Interval(15,20)
		};
		
		System.out.println("can Have meeting in one room - "+canAttendMeeting(meeting));

		System.out.println("No of meeting room required:- "+minMeetingRoom(meeting));
	}
	
	
	//252,Need to figureout how many meetingrooms we need to accomodate these meetings (ASKED FB)
	
	public static int minMeetingRoom(Interval[] interval) {
		if(interval==null || interval.length==0) return 0;
		//sorting by starttime
		Arrays.sort(interval,(a,b)->a.start-b.start);
		
		PriorityQueue<Interval> minHeap=new PriorityQueue<Interval>((a,b)->a.end-b.end);
		//add first meeting as we need meeting room for first (nothing to compare yet)
		minHeap.add(interval[0]);
		for(int i=1;i<interval.length;i++) {
			
			Interval current=interval[i];
			Interval earliest=minHeap.remove();
			if(current.start>=earliest.end) {
				//so we are changing earliest end time because if no conflict then we can accomadate in the same meeting 
				earliest.end=current.end;
			}else {
				minHeap.add(current);
			}
			minHeap.add(earliest);
		}
		
		return minHeap.size();
	}
	
	//MeetingRoomOne -:https://www.youtube.com/watch?v=i2bBG7CaVxs
	public static boolean canAttendMeeting(Interval[] intervals) {
		int[] start=new int[intervals.length];
		int[] end=new int[intervals.length];
		
		for(int i=0;i<intervals.length;i++) {
			start[i]=intervals[i].start;
			end[i]=intervals[i].end;

		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		for(int i=0;i<start.length-1;i++) {
			if(start[i+1]<end[i])
				return false;
		}
		
		return true;

	}
	
	
	
}
