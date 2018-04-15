package LeetCode;

import java.util.HashMap;

public class TwoSum {
	
	/*
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * Example:
	 * Given nums = [2, 7, 11, 15], target = 9,
	 * Because nums[0] + nums[1] = 2 + 7 = 9,
	 * return [0, 1].
	  
	 */

	/*
	 * Solution is to assign the numbers to a hash map and then run through hash map to find the complement
	 * where the indices of the two numbers in the array list are not equal
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2,7,11,15};
		int target = 9;
		
		System.out.println(twoSum(nums,target)[0]);
		System.out.println(twoSum(nums,target)[1]);

	}
	
    public static int[] twoSum(int[] nums, int target) {
    	
    		int[] returnList = new int[2];
        
        HashMap<Integer,Integer> myMap = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++){
            myMap.put(nums[i],i);    
        }
        
        for(int j=0;j<nums.length;j++){
            
            if(myMap.containsKey(target-nums[j]) && myMap.get(target-nums[j])!=j){
                returnList = new int[] {j,myMap.get(target-nums[j]).intValue()};
            }
            
        }
        
        return returnList;
        
    }

}
