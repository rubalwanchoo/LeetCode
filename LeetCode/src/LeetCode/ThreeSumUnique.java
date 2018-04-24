package LeetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ThreeSumUnique {
	
	/*
	 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

		Note:		
		The solution set must not contain duplicate triplets.
		
		Example:
		Given array nums = [-1, 0, 1, 2, -1, -4],
		
		A solution set is:
		[
		  [-1, 0, 1],
		  [-1, -1, 2]
		]

	 */

	
	public static void main(String args[]) {
		displayArrList(threeSum(new int[] {1,-1,-1,0}));
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> myList = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        //displayArray(nums);
        
        if(nums.length == 3 && nums[0]+nums[1]+nums[2]==0) {
        		myList.add(Arrays.asList(nums[0],nums[1],nums[2]));
        		return myList;
        }
        
        
        for(int i = 0;i<nums.length-2;i++) {
        		if(i==0||(i>0 && nums[i]!=nums[i-1])) {//Take the first one but avoid repeating for similar i's
        			int lo = i+1;
            		int hi = nums.length-1;
            		int tgtSum = 0-nums[i];
            		
            		System.out.println("lo "+lo+" hi "+hi+" tgtSum "+tgtSum);
            		
            		while(lo<hi) {
            			System.out.println("Comparing "+nums[i]+" "+nums[lo]+" "+nums[hi]);
            			if(nums[lo]+nums[hi] == tgtSum) {
            				
            				myList.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
            				while(lo<hi && nums[lo]==nums[lo+1]) {lo++;}
            				while(lo<hi && nums[hi]==nums[hi-1]) {hi--;}
            				lo++;
            				hi--;
            				
            			}
            			else if(nums[lo]+nums[hi]<tgtSum) {
            				lo++;
            			}
            			else {
            				hi--;
            			}
            		}
        		}
        		
        }
        
        
        return myList;
		
    }
	
	
	public static void displayArray(int[] arr) {
		
		//System.out.print("displayArray ");
		for(int k:arr) {
			System.out.print(k+" ");
		}
	}
	
	public static void displayArrList(List<List<Integer>> myList) {
		
		Iterator<List<Integer>> it1 = myList.iterator();
		
		
		while(it1.hasNext()) {
			Iterator it2 = it1.next().iterator();
			
			while(it2.hasNext()) {
				System.out.print(it2.next()+" ");
			}
			System.out.println();
			
			System.out.println();
		}
	}
}
