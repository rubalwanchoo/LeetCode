package LeetCode2;

import java.util.Arrays;

public class FindPeakElement {

	/*
	 	A peak element is an element that is greater than its neighbors.
		
		Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
		
		The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
		
		You may imagine that nums[-1] = nums[n] = -∞.
		
		Example 1:
		
		Input: nums = [1,2,3,1]
		Output: 2
		Explanation: 3 is a peak element and your function should return the index number 2.
		Example 2:
		
		Input: nums = [1,2,1,3,5,6,4]
		Output: 1 or 5 
		Explanation: Your function can return either index number 1 where the peak element is 2, 
		             or index number 5 where the peak element is 6.
		Note:
		
		Your solution should be in logarithmic complexity.
	 */
	
	public static int retIdx = -1;
	
	public static void main(String[] args) {
		
		//System.out.println(findPeakElement(new int[] {1,2,3,4,5,6,7,8,9,10,11}));
		//System.out.println(findPeakElement(new int[] {1,2,3,1}));
		//System.out.println(findPeakElement(new int[] {1,2,1,3,5,6,4}));
		//System.out.println(findPeakElement(new int[] {1,1,1,1}));
		System.out.println(findPeakElement(new int[] {1}));

	}
	
	public static int findPeakElement(int[] nums) {
		
		if(nums.length==1) return 0;
        
		boolean peakFound = false;
		int lo = 0;
		int hi = nums.length-1;
		
		while(!peakFound) {
			
			int mid = lo+(hi-lo)/2;
			
			if(checkNumsMid(nums,mid)) {
				return mid;
			}else if(mid!=0 && nums[mid-1]>nums[mid]) {
				hi = mid-1;
			}else {
				lo = mid+1;
			}
		}
		
		return nums.length-1;
    }
	
	public static boolean checkNumsMid(int[] nums, int mid) {
		
		System.out.println("checking mid "+mid);
		boolean resp = false;
		
		if(mid==0) {
			resp = nums[mid]>nums[mid+1];
		}
		else if(mid==nums.length-1) {
			resp = nums[mid-1]<nums[mid];
		}
		else {
			resp = nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1];
		}
		
		System.out.println("returning resp "+resp);
		return resp;
	}
	
	
	
	


}
