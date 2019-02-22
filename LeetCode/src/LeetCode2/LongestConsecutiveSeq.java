package LeetCode2;

import java.util.*;

public class LongestConsecutiveSeq {
	
	/*
	Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

	Your algorithm should run in O(n) complexity.

	Example:

	Input: [100, 4, 200, 1, 3, 2]
	Output: 4
	Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

	*/
	
	public static void main(String[] args) {
		
		System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));

	}
	
	public static int longestConsecutive(int[] nums) {
        
		//Store elements in a hash set uniquely
		Set<Integer> numSet = new HashSet<>();
		
		for(int item:nums) {
			numSet.add(item);
		}
		
		System.out.println("set "+numSet);
		
		int count = 1;
		int longCons = 0;
		
		for(int item:numSet) {
			
			int curr = item;
			int prev = item-1;
			int next = item+1;
			count = 1;
			
			while(numSet.contains(prev)) {
				count++;
				prev--;
			}
			
			while(numSet.contains(next)) {
				count++;
				next++;
			}
			
			longCons = Math.max(count, longCons);
		}
		
		return longCons;
    }

}
