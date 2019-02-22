package LeetCode.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



public class Permutations {

	/*
	 * Given a collection of distinct integers, return all possible permutations.
		
		Example:
		
		Input: [1,2,3]
		Output:
		[
		  [1,2,3],
		  [1,3,2],
		  [2,1,3],
		  [2,3,1],
		  [3,1,2],
		  [3,2,1]
		]
	 */
	
	
	public static void main(String[] args) {
		System.out.println(permute(new int[] {1,2,3}).toString());
	}
	
	public static List<List<Integer>> permute(int[] nums) {
        System.out.println("calling permute with "+Arrays.toString(nums));
        
		List<List<Integer>> myList = new ArrayList<List<Integer>>();
		
		for(int i = 0;i<nums.length;i++) {
			
			if(nums.length>1) {
				
				Iterator<List<Integer>> it1 = permute(getNumsArrayExceptIdx(i,nums)).iterator();
				while(it1.hasNext()) {
					List<Integer> list = it1.next();
					list.add(nums[i]);
					myList.add(list);
				}	
			}else {
				List<Integer> list2 = new ArrayList<Integer>();
				list2.add(nums[0]);
				myList.add(list2);
			}
			
			
		}
		System.out.println("returning output "+myList.toString());
		return myList;
		
    }
	
	
	private static int[] getNumsArrayExceptIdx(int idx, int[] nums) {
		int[] res = new int[nums.length-1];
		int j = 0;
		
		for(int i= 0;i<nums.length;i++) {
			if(i == idx) continue;
			
			res[j]= nums[i];
			j++;
		}
		
		return res;
	}

}
