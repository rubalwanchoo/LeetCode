package LeetCode.fb;

import java.util.HashMap;

public class MinSizeSubArray {

	/*
	  Given an array of n positive integers and a positive integer k, 
	  find the minimal length of a contiguous subarray of which the sum ≥ k. 
	  If there isn't one, return 0 instead.

		Example: 
		
		Input: s = 7, nums = [2,3,1,2,4,3]
		Output: 2
		Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	 */
	
	public static void main(String[] args) {
		
		System.out.println(minSubArrayLen(7,new int[] {2,3,1,2,4,3}));
		

	}

	
	public static int minSubArrayLen(int k, int[] nums) {
		
		//s = 7, nums = [2,3,1,2,4,3]
					//	 0,1,2,3,4,5
        
        int lo = 0;
        int hi = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        
        while(lo<=hi && hi<nums.length){
        	
        	System.out.println("lo "+lo+" hi "+ hi+" minLength "+minLength);
        	
        	if(sum<k) {
        		sum += nums[hi];
        		System.out.println("sum "+sum);
        	}
        	
        	if(sum>=k) {
        		
        		minLength = Math.min(minLength, hi-lo+1);
        		System.out.println("new minLength "+minLength);
        		
        		sum -= nums[lo];
        		lo++;
        	}
        	
        	if(sum<k) {
        		hi++;
        	}
        	
            
        }
        
        if(minLength == Integer.MAX_VALUE) return 0;
        else return minLength;
        
		
	}
}
