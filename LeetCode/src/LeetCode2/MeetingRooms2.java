package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import LeetCode.Helper.*;

public class MeetingRooms2 {
	/*
	Given an array of meeting time intervals consisting of start and end times 
	[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

	Example 1:

	Input: [[0, 30],[5, 10],[15, 20]]
	Output: 2
	Example 2:

	Input: [[7,10],[2,4]]
	Output: 1
	*/
	

	public static void main(String[] args) {
		System.out.println(minMeetingRooms(new Interval[] 
				{new Interval(0,30),new Interval(5,10),new Interval(15,20)}));
		
		System.out.println(minMeetingRooms(new Interval[] 
				{new Interval(7,10),new Interval(2,4)}));
		
		System.out.println(minMeetingRooms(new Interval[] 
				{new Interval(13,15),new Interval(1,13)}));

	}
	
	public static int minMeetingRooms(Interval[] intervals) {
        
		Arrays.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				
				return o1.start-o2.start;
			}

		});

		System.out.println(Arrays.toString(intervals));
		
		List<Integer> meetingRooms = new ArrayList<>();
		
		for(int i=0;i<intervals.length;i++) {
			
			if(i == 0) {
				meetingRooms.add(intervals[i].end);
			}else {
				boolean roomReused = false;
				for(int j=0;j<meetingRooms.size();j++) {
					if(intervals[i].start>=meetingRooms.get(j)) {
						meetingRooms.set(j, intervals[i].end);
						roomReused = true;
						break;
					}
				}
				
				if(!roomReused) {
					meetingRooms.add(intervals[i].end);
				}

			}
			
		}
		
		return meetingRooms.size();
    }
	
	
}
