package LeetCode.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	
	/*
	 * https://www.youtube.com/watch?v=irFtGMLbf-s
	 * 
	 Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

		The same repeated number may be chosen from candidates unlimited number of times.
		
		Note:
		
		All numbers (including target) will be positive integers.
		The solution set must not contain duplicate combinations.
		Example 1:
		
		Input: candidates = [2,3,6,7], target = 7,
		A solution set is:
		[
		  [7],
		  [2,2,3]
		]
		Example 2:
		
		Input: candidates = [2,3,5], target = 8,
		A solution set is:
		[
		  [2,2,2,2],
		  [2,3,3],
		  [3,5]
		]
	 */
	
	public static List<List<Integer>> retList = new ArrayList<List<Integer>>();
	
	public static void main(String[] args) {
		
		System.out.println(combinationSum(new int[] {1,2,3},7));

	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		Arrays.sort(candidates);
		
		
		findCombinationToSum(candidates,target,0,new ArrayList<>());
		
		return retList;
    }
	
	public static void findCombinationToSum(int[] candidates,int targetSum,int currIdx,List<Integer> combList) {
		
		if(targetSum == 0) {
			retList.add(new ArrayList<>(combList));
		}
		
		for(int i=currIdx;i<candidates.length;i++) {
			
			if(candidates[i]>targetSum) {
				break;
			}
			
			combList.add(candidates[i]);
			findCombinationToSum(candidates,targetSum-candidates[i],i,new ArrayList<Integer>(combList));
			combList.remove(combList.size()-1);
		}
		
	}
	
	
	

}
