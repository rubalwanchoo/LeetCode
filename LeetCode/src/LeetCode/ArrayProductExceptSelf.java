package LeetCode;

import java.util.Arrays;

public class ArrayProductExceptSelf {

	
	/*	https://www.youtube.com/watch?v=vB-81TB6GUc
	 	Given an array of n integers where n > 1, nums, 
	 	return an array output such that output[i] is equal to the product of all the 
	 	elements of nums except nums[i].

		Solve it without division and in O(n).

		For example, given [1,2,3,4], return [24,12,8,6].

		Follow up:
		Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
	 */
	
	
	public static void main(String args[]) {
		displayArray(productExceptSelf(new int[] {1,2,3,4}));
	}
	
	
	public static int[] productExceptSelf(int[] nums) {
		int[] outputArray = new int[nums.length];
        
		//Multiply items from left
		int leftMultiply = 1;
		
		for(int i=0;i<nums.length;i++) {
			leftMultiply = leftMultiply*(i-1<0?1:nums[i-1]);
			outputArray[i] =leftMultiply;
		}
		
		displayArray(outputArray);
		
		
		//Multiply items from right
		int rightMultiply = 1;
		
		for(int i=nums.length;i>0;i--) {
			rightMultiply = rightMultiply*(i>=nums.length?1:nums[i]);
			outputArray[i-1] =outputArray[i-1]*rightMultiply;
		}
		
		displayArray(outputArray);
		
		return outputArray;
    }
	
	
	public static void displayArray(int[] array) {
		
		for(int item:array) {
			System.out.print(item+",");
			
		}
		System.out.println();
	}
}
