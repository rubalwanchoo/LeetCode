package LeetCode2;

import java.util.Arrays;

public class FirstLastPosInSortedArr {

	/*
	 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

		Your algorithm's runtime complexity must be in the order of O(log n).
		
		If the target is not found in the array, return [-1, -1].
		
		Example 1:
		
		Input: nums = [5,7,7,8,8,10], target = 8
		Output: [3,4]
		Example 2:
		
		Input: nums = [5,7,7,8,8,10], target = 6
		Output: [-1,-1]
	 */
	
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(searchRange(new int[] {1,1,2,2,3,3,4,4,4,4,4,5,5,5,5,5,5,6,6,7},5)));
		//System.out.println(Arrays.toString(searchRange(new int[] {1,4},4)));

	}
	
	
	public static int[] searchRange(int[] nums, int target) {
		
		if(nums.length==0) return new int[] {-1,-1};
		
		int[] res = new int[2];
		
		res = search(nums, 0,nums.length-1,target);
		
		return res;
		
    }
	
	public static int[] search(int[] nums, int left, int right, int target) {
		
		System.out.println("left "+left+" right "+right);

		int[] res = new int[2];
		
		int mid = (left+right)/2;
		System.out.println("mid "+mid);
		
		int i = mid;
		int j = mid;
		
		while(i>-1 && nums[i]==nums[mid]) {
			i--;
		}
		i++;
		
		while(j<nums.length && nums[j]==nums[mid]) {
			j++;
		}
		j--;

		
		if(target == nums[mid]) {
			System.out.println("in condition 1");
			
			res[0] = i;
			res[1] = j;
			
			return res;
			
		}else {
			
			System.out.println("in condition 2");

			if(right-left>0) {
				int[] resLeft = search(nums,left,i,target);
				if(resLeft[0]!=-1) {
					res = resLeft;
					return res;					
				}

			}
			
			if(right-left>0) {
				int[] resRight = search(nums,j+1,right,target);
				if(resRight[0]!=-1) {
					res = resRight;
					return res;
					
				}
			}
					
			return new int[] {-1,-1};
		}
		

		
	}
	
}
