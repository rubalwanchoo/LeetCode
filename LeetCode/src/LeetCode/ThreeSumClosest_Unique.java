package LeetCode;

import java.util.Arrays;

public class ThreeSumClosest_Unique {
	
	/*
	 Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

		Example:
		Given array nums = [-1, 2, 1, -4], and target = 1.
		
		The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

	 */
	
	
	public static void main(String args[]) {
		
		//System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
		//System.out.println(threeSumClosest(new int[]{1,1,1,0},-100));
		//System.out.println(threeSumClosest(new int[]{0,2,1,-3},1));
		//System.out.println(threeSumClosest(new int[]{1,1,-1,-1,3},-1));
		//System.out.println(threeSumClosest(new int[]{0,2,1,-3},1));
		System.out.println(threeSumClosest(new int[]{1,2,4,8,16,32,64,128},82));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
        int closestSum = 0;
        int diff = Integer.MAX_VALUE;
	
		Arrays.sort(nums);
		if(nums.length == 3) {
			return nums[0]+nums[1]+nums[2];
		}
		
		
		for(int i=0;i<nums.length-2;i++) {
					
			int lo = i+1;
			int hi = nums.length-1;
			
			while(lo<hi) {
				int sum = nums[i]+nums[lo]+nums[hi];
				int currDiff = Math.abs(target-sum);
				System.out.println("nums[i]="+nums[i]+",nums[lo]="+nums[lo]+",nums[hi]="+nums[hi]+",sum="+sum+",currDiff="+currDiff);
				
				if(currDiff<diff) {
					diff=currDiff;
					closestSum = sum;
				}
				
				if(sum<target) {	lo++;}
				else if(sum>=target) {hi--;}
				
				
				
			}
				
			
		}
		
		
		return closestSum;
    }

}
