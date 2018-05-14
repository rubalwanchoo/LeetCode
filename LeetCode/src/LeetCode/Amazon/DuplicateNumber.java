package LeetCode.Amazon;

import java.util.Arrays;

public class DuplicateNumber {
	
	/*
	 	Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

		Example 1:
		
		Input: [1,3,4,2,2]
		Output: 2
		Example 2:
		
		Input: [3,1,3,4,2]
		Output: 3
		Note:
		
		You must not modify the array (assume the array is read only).
		You must use only constant, O(1) extra space.
		Your runtime complexity should be less than O(n2).
		There is only one duplicate number in the array, but it could be repeated more than once.
	 */

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] {3,1,3,4,2}));

	}
	
	public static int findDuplicate(int[] nums) {
		int returnVal = 0;
		Arrays.sort(nums);
		
		int prev = nums[0];
		for(int i=1;i<nums.length;i++) {
			if(nums[i] == prev) {
				returnVal = nums[i];
				break;
			}
			
			prev = nums[i];
		}
		
		
		return returnVal;
    }

}
