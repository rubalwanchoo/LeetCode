package LeetCode.fb;

import java.util.HashMap;

public class MaxSizeSubArraySumK {

	/*
	  	Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
	  	If there isn't one, return 0 instead.

		Note:
		The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
		
		Example 1:
		
		Input: nums = [1, -1, 5, -2, 3], k = 3
		Output: 4 
		Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
		Example 2:
		
		Input: nums = [-2, -1, 2, 1], k = 1
		Output: 2 
		Explanation: The subarray [-1, 2] sums to 1 and is the longest.
		Follow Up:
		Can you do it in O(n) time?
	 */
	public static void main(String[] args) {
		//System.out.println(maxSubArrayLen(new int[] {-2,-1,2,1},1));
		System.out.println(maxSubArrayLen(new int[] {1,-1,5,-2,3},3));

	}
	
	public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
		int maxLen = 0;
		HashMap<Integer,Integer> myMap = new HashMap<>();
		
		
		myMap.put(0,-1);
		for(int i = 0;i<nums.length;i++) {
			
			sum = sum + nums[i];
			
			if(!myMap.containsKey(sum))
				myMap.put(sum, i);
			
			if(myMap.containsKey(sum-k)) 
				maxLen = Math.max(maxLen,i-myMap.get(sum-k));
				
			
			
		}
		
		
		
		return maxLen; 
		
    }

}
