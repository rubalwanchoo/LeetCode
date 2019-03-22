package LeetCode2;

import java.util.*;

//https://leetcode.com/problems/jump-game/

public class JumpGame {

	public static Map<Integer, Boolean> myMap = new HashMap<>();
	
	public static void main(String[] args) {
		//System.out.println(canJump(new int[] {2,3,1,1,4}));
		System.out.println(canJump(new int[] {3,2,1,0,4}));
		
	}
	
	public static boolean canJump(int[] nums) {
        return dp(nums,0);
    }
	
	public static boolean dp(int[] nums, int currIdx) {
		
		if(currIdx == nums.length-1) return true;
		
		if(myMap.containsKey(currIdx)) return myMap.get(currIdx);
		
		
		boolean resp = false;
		
		for(int i=currIdx;i<currIdx+nums[currIdx] && i<nums.length;i++) {
			
			
			resp = resp||dp(nums,i+1);
			
			if(resp) break;
			
		}
		
		myMap.put(currIdx, resp);
		
		return resp;
	}
}
