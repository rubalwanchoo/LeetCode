package LeetCode2;

public class IncreasingTripSubSeq {

	
	/*
	 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

	Formally the function should:
	
	Return true if there exists i, j, k 
	such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
	Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
	
	Example 1:
	
	Input: [1,2,3,4,5]
	Output: true
	Example 2:
	
	Input: [5,4,3,2,1]
	Output: false
	  
	  
	 */
	public static void main(String[] args) {
		
		System.out.println(increasingTriplet(new int[] {1,2,3,4,5}));
		System.out.println(increasingTriplet(new int[] {5,4,3,2,1}));
		System.out.println(increasingTriplet(new int[] {6,5,4,21,25,8,18,29}));
		System.out.println(increasingTriplet(new int[] {1,1,1,1,}));
		System.out.println(increasingTriplet(new int[] {1,2,2,1,}));

	}
	
	public static boolean increasingTriplet(int[] nums) {
		
		int small = Integer.MAX_VALUE;
		int big = Integer.MAX_VALUE;
		
		for(int curr:nums) {
			
			if(curr<=small) {
				small = curr;
			}else if(curr<=big) {
				big = curr;
			}else {
				return true;
			}
			
			
		}
		
		return false;
		
		
    }

}
