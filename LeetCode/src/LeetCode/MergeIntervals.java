package LeetCode;

import LeetCode.Helper.*;
import jdk.dynalink.linker.ConversionComparator;
import jdk.dynalink.linker.ConversionComparator.Comparison;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Stack;

public class MergeIntervals {

	
	/*
	 	Given a collection of intervals, merge all overlapping intervals.

		Example 1:
		
		Input: [[1,3],[2,6],[8,10],[15,18]]
		Output: [[1,6],[8,10],[15,18]]
		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
		Example 2:
		
		Input: [[1,4],[4,5]]
		Output: [[1,5]]
		Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
		
		public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  	}
	  	
	 */
	
	
	public static void main(String args[]) {

		List<Interval> intList = new ArrayList<Interval>();
		intList.add(new Interval(2,6));
		intList.add(new Interval(1,3));
		intList.add(new Interval(8,10));
		intList.add(new Interval(15,18));
		
		displayList(merge(intList));
		
		
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		
		
		
		if(intervals.size()==0) {
			return intervals;
		}

		
		//Sort the List based on starting time of the interval
		//Collections.sort(intervals);// Can be replaced with comparator like below
		
		Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
			
			
		});
		
		Interval[] intervalArray = new Interval[intervals.size()];
		intervalArray = intervals.toArray(intervalArray);
		
		Stack<Interval> st = new Stack<Interval>();
		st.push(intervalArray[0]);
		
		for(int i = 1;i<intervalArray.length;i++) {
			
			
			//Compare if the interval at i can merge with interval at i-1
			if(st.peek().end>=intervalArray[i].start) {//Intervals merge
				Interval intvl = new Interval();

				intvl.start = Math.min(intervalArray[i].start, st.peek().start);
				intvl.end = Math.max(intervalArray[i].end, st.peek().end);
				
				st.pop();
				st.push(intvl);
			}
			else {//Intervals don't merge
				st.push(intervalArray[i]);
			}
		}
		
		return new ArrayList<Interval>(st);
		
		
        
    }
	
	public static void displayList(List<Interval> list) {
		
		Iterator<Interval> it = list.iterator();
		
		while(it.hasNext()) {
			Interval intvl = it.next();
			System.out.println(intvl.start+"-"+intvl.end);
		}
	}
	
	
	
}

