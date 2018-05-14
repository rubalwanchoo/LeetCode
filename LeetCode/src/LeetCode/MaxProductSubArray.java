package LeetCode;

public class MaxProductSubArray {
	
	/*
	 Given an integer array nums, find the contiguous subarray within an array (containing at least one number) 
	 which has the largest product.

		Example 1:
		
		Input: [2,3,-2,4]
		Output: 6
		Explanation: [2,3] has the largest product 6.
		Example 2:
		
		Input: [-2,0,-1]
		Output: 0
		Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

	 */
	
	
	public static void main(String args[]) {
		System.out.println(maxProduct(new int[] {-2,3,-2,4}));
		//System.out.println(maxProduct(new int[] {0,2}));
	}
	
	public static int maxProduct(int[] nums) {
		int totalMax = nums[0];
		int currMin = nums[0];
		int currMax = nums[0];
		
		for(int i = 1;i<nums.length;i++) {
			
			if(nums[i]>0) {
				currMin = Math.min(nums[i], currMin * nums[i]);
				currMax = Math.max(nums[i], currMax * nums[i]);
			}else {
				
				int temp = currMin;
				currMin = Math.min(nums[i], currMax * nums[i]) ;
				currMax = Math.max(nums[i], temp*nums[i]);
			}
			
			totalMax = Math.max(totalMax,currMax);
		}
		
		
		
		return totalMax;
		
	}

}
