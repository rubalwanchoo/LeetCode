package LeetCode.Amazon;

import LeetCode.Helper.*;

public class BinaryTreeLevelOrder {
	/*
	 	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

		For example:
		Given binary tree [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
	 */

	public static void main(String[] args) {
		
		TreeNode root = TreeNode.createTree(new Integer[] {3,9,20,-1,-1,15,7});
		
		TreeNode.displayTree(root);

	}
	
	
	//public List<List<Integer>> levelOrder(TreeNode root) {
        
    //}
    
}
