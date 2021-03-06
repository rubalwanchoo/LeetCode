package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMax {

	/*
	Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

	Example:

	Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
	Output: [3,3,5,5,6,7] 
	Explanation: 

	Window position                Max
	---------------               -----
	[1  3  -1] -3  5  3  6  7       3
	 1 [3  -1  -3] 5  3  6  7       3
	 1  3 [-1  -3  5] 3  6  7       5
	 1  3  -1 [-3  5  3] 6  7       5
	 1  3  -1  -3 [5  3  6] 7       6
	 1  3  -1  -3  5 [3  6  7]      7
	Note: 
	You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

	Follow up:
	Could you solve it in linear time?
			
	*/
	
	public static void main(String[] args) {
		
		int[] nums = {1,3,-1,-3,5,3,6,7};
		//int[] nums = {1};
		int k = 3;
		
		int[] resp = maxSlidingWindow(nums,k);
		
		
		System.out.println(Arrays.toString(resp));

	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
		
		if(nums.length==0) return new int[]{};
		
		int[] resp = new int[nums.length-k+1];
		int idx = 0;
		
		int lo = 0;
		int hi = k-1;
		
		int max = Integer.MIN_VALUE;
		
		while(hi<nums.length) {//Iterate till the last element
			

			if(max!= Integer.MIN_VALUE && nums[lo-1]!=max && nums[hi]>max) {
				max = nums[hi];
				
			}else {
				
				max = Integer.MIN_VALUE;
				
				int start = lo;
				while(start<=hi) {//Iterate through the window
					
					max = Math.max(nums[start], max);
					start++;
					
				}
			}
			
			;
			
			resp[idx] = max;
			idx++;
			lo++;
			hi++;
			
		}
		
		
		return resp;
        
    }

}
