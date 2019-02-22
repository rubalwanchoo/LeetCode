package LeetCode.fb;

public class SearchInRotatedArray {
	
	/*
	 	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
		
		(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
		
		You are given a target value to search. If found in the array return true, otherwise return false.
		
		Example 1:
		
		Input: nums = [2,5,6,0,0,1,2], target = 0
		Output: true
		Example 2:
		
		Input: nums = [2,5,6,0,0,1,2], target = 3
		Output: false
		Follow up:
		
		This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
		Would this affect the run-time complexity? How and why?
	 */

	public static void main(String[] args) {
		//System.out.println(search(new int[] {2,5,6,0,0,1,2},0));
		//System.out.println(search(new int[] {2,5,6,0,0,1,2},3));
		//System.out.println(search(new int[] {1,1},2));
		//System.out.println(search(new int[] {1,1},1));
		//System.out.println(search(new int[] {1,3},0));
		//System.out.println(search(new int[] {5,1,3},5));
		//System.out.println(search(new int[] {3,1,1,1,1},3));
		//System.out.println(search(new int[] {1,1},0));
		System.out.println(search(new int[] {1,3,1,1,1},3));

	}
	
	
	public static boolean search(int[] nums, int target) {
		boolean resp = false;
		
		if(nums.length==0) return false;
		if(nums.length==1) return nums[0]==target;

		
        //find pivot using binary search
        int pivot = binarySearchPivot(0,nums.length-1,nums);
       
        System.out.println("pivot "+pivot);
        
        //then look for target in left vs right arrays using binary search
        
        resp = pivot==-1?(binarySearch(0,nums.length-1,nums,target)>=0):(binarySearch(0,pivot-1,nums,target)>=0 || binarySearch(pivot,nums.length-1,nums,target)>=0);
		
        
        return resp;
    }
	
	public static int binarySearchPivot(int startIdx, int endIdx, int[] nums) {
		System.out.println("in binarySearchPivot startIdx "+startIdx+", endIdx "+endIdx);
		
		
		int mid = (startIdx+endIdx)/2;
		
		if(startIdx>endIdx) return -1;
		if((mid+1)>nums.length-1) return -1;
		
		if(nums[mid] > nums[mid+1]) return mid+1;
		else if(nums[startIdx]<nums[mid]) return binarySearchPivot(mid+1,endIdx, nums);
		else if(nums[startIdx]>=nums[mid])return binarySearchPivot(startIdx,mid-1,nums);
		else return -1;
		
	}
	
	public static int binarySearch(int startIdx, int endIdx, int[] nums, int target) {
		System.out.println("in binarySearch startIdx "+startIdx+", endIdx "+endIdx);
		
		
		if(startIdx>endIdx) return -1;
		
		int mid = (startIdx+endIdx)/2;
		
		if(target == nums[mid]) return mid;
		else if (target<=nums[mid]) return binarySearch(startIdx, mid-1,nums, target);
		else return binarySearch(mid+1, endIdx, nums, target);
		
	}
}
