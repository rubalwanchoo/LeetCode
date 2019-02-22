package LeetCode.fb;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	/*
	 Given a set of distinct integers, nums, return all possible subsets (the power set).

	Note: The solution set must not contain duplicate subsets.
	
	Example:
	
	Input: nums = [1,2,3]
	Output:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
	 */
	
	public static void main(String[] args) {
		System.out.println(subsets(new int[] {1,2,3}));
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> myList = new ArrayList<List<Integer>>();
		
		for(int i=0;i<Math.pow(2, nums.length);i++) {
			
			String bString = Integer.toBinaryString(i);
			System.out.println("bString "+bString);
			
			List<Integer> list1 = new ArrayList<>();
			
			for(int j=bString.length()-1;j>-1;j--) {
				
				if(bString.charAt(j)=='1') {
					list1.add(nums[bString.length()-j-1]);
				}
			}
			
			myList.add(list1);
		}
		
		return myList;
    }
}
