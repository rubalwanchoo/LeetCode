package LeetCode.Amazon;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import LeetCode.Helper.*;

public class MaximumBinaryTree {
	
	/*
	 	Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

		The root is the maximum number in the array.
		The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
		The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
		Construct the maximum tree by the given array and output the root node of this tree.
		
		Example 1:
		Input: [3,2,1,6,0,5]
		Output: return the tree root node representing the following tree:
		
		      6
		    /   \
		   3     5
		    \    / 
		     2  0   
		       \
		        1
		Note:
		The size of the given array will be in the range [1,1000].
	 */

	public static void main(String[] args) {
		
		TreeNode.displayTree(constructMaximumBinaryTree(new int[] {3,2,1,6,0,5}));
	}
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		
		if(nums.length==0) {
			//System.out.println("returning null");
			return null;
		}
        
		int maxIdx = getMaxItem(nums);
		//System.out.println("maxIdx "+maxIdx);
		TreeNode root = new TreeNode(nums[maxIdx]);
		
		int[] leftArray = Arrays.copyOfRange(nums, 0, maxIdx);
		int[] rightArray = Arrays.copyOfRange(nums, maxIdx+1, nums.length);
		
		
		root.left = constructMaximumBinaryTree(leftArray);
		root.right = constructMaximumBinaryTree(rightArray);
		
		
		return root;
	
    }

	public static int getMaxItem(int[] nums) {//returns index of max item
		int maxIdx = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>max) {
				maxIdx = i;
				max=nums[i];
			}
		}
		
		//System.out.println("max value returned "+max);
		return maxIdx;
	}

}
