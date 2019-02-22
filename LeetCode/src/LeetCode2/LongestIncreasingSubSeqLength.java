package LeetCode2;

import java.util.Arrays;

public class LongestIncreasingSubSeqLength {
	
	/*
	Given an unsorted array of integers, find the length of longest increasing subsequence.

	Example:

	Input: [10,9,2,5,3,7,101,18]
	Output: 4 
	Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
	Note:

	There may be more than one LIS combination, it is only necessary for you to return the length.
	Your algorithm should run in O(n2) complexity.
	*/

	public static void main(String[] args) {
		
		//int[] arr = {10,9,2,5,3,7,101,18};
		int[] arr = {3,4,-1,0,6,2,3};
		
		System.out.println(lengthOfLIS(arr));

	}
	
	public static int lengthOfLIS(int[] nums) {
		
		int maxLength = 0;
		
		if(nums.length<2) 
			return nums.length;
		
		int[] resArr = new int[nums.length];
		resArr[0] = 1;
		
		int i = 0;
		int j = 1;
		
		
		while(j<nums.length) {
			
			if(resArr[j]==0) resArr[j] = 1;
			
			if(nums[j]>nums[i]) {
				resArr[j] = Math.max(resArr[j],resArr[i]+1);
				
			}
			maxLength = Math.max(resArr[j], maxLength);
			
			i++;
			
			if(i==j) {
				i=0;
				j++;
			}
		
		}//end while
		
		//System.out.println(Arrays.toString(resArr));
			
		
		
		return maxLength;
        
    }

}
