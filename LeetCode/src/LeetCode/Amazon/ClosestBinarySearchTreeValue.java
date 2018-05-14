package LeetCode.Amazon;

import LeetCode.Helper.*;

public class ClosestBinarySearchTreeValue {
	
	/*
	 	Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

		Note:
		
		Given target value is a floating point.
		You are guaranteed to have only one unique value in the BST that is closest to the target.
		Example:
		
		Input: root = [4,2,5,1,3], target = 3.714286
		
		    4
		   / \
		  2   5
		 / \
		1   3
		
		Output: 4
	 */

	static double diff;
	static int closestVal;
	
	
	
	public static void main(String[] args) {
		
		TreeNode root = TreeNode.createTree(new Integer[] {4,2,5,1,3});double diff = 3.714286;
		//TreeNode root = TreeNode.createTree(new Integer[] {2147483647});double diff = 0.0;
		//TreeNode root = TreeNode.createTree(new Integer[] {0});double diff = 2147483648.0;
		//TreeNode root = TreeNode.createTree(new Integer[] {1500000000,1400000000});double diff = -1500000000.0;
		
		
		TreeNode.displayTree(root);
		
		//System.out.println(closestValue(root,diff));

	}
	
	public static int closestValue(TreeNode root, double target) {
		
		if(root.left==null && root.right == null) return root.val;
		
		diff = Double.MAX_VALUE;
		closestVal = 0;
		
		return getClosest(root,target);

	}
	
	public static int getClosest(TreeNode root, double target) {
		
		if(root == null) return closestVal;
		
		double currDiff = Math.abs(target-root.val);
		System.out.println("currDiff "+currDiff);
		
		if(currDiff < diff) {
			diff = currDiff;
			closestVal = root.val;
		}
		
		closestVal = getClosest(root.left,target);
		closestVal = getClosest(root.right,target);
		
		return closestVal;
		
	}

}
