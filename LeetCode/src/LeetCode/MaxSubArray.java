package LeetCode;

public class MaxSubArray {
	
	/*
	 KEDANE's Algortihm
	 
	 	Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	 
		Example:

		Input: [-2,1,-3,4,-1,2,1,-5,4],
		Output: 6
		Explanation: [4,-1,2,1] has the largest sum = 6.
		
	*/
	
	public static void main(String args[]) {
		
		System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		//System.out.println(maxSubArray(new int[] {1}));
	}
	
	
	public static int maxSubArray(int[] nums) {
        int totalMax = nums[0];
        int currMax = nums[0];
        
        System.out.println("intial currMax " + currMax);
      
        for(int i = 1;i<nums.length;i++) {
        	
        	currMax = Math.max(currMax+nums[i],nums[i]);
        	System.out.println("currMax "+currMax);
        	
        	totalMax = Math.max(currMax,totalMax);
        	System.out.println("totalMax "+totalMax);
        	
        }
        
        
        return totalMax;
    }

}