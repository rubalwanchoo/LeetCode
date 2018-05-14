package LeetCode.Amazon;

import LeetCode.Helper.*;

public class ValidateBinarySearchTree {
	
	/*
	 	Given a binary tree, determine if it is a valid binary search tree (BST).

		Assume a BST is defined as follows:
		
		The left subtree of a node contains only nodes with keys less than the node's key.
		The right subtree of a node contains only nodes with keys greater than the node's key.
		Both the left and right subtrees must also be binary search trees.
		Example 1:
		
		Input:
		    2
		   / \
		  1   3
		Output: true
		Example 2:
		
		    5
		   / \
		  1   4
		     / \
		    3   6
		Output: false
		Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
		             is 5 but its right child's value is 4.
	 */
	
	
	public static void main(String args[]) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(6);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		//System.out.println(isValidBST(node1));
		
		TreeNode node6 = new TreeNode(-2147483648);
		TreeNode node7 = new TreeNode(-2147483648);
		
		node6.left = node7;
		
		System.out.println(isValidBST(node6));
	}
	
	
	public static boolean isValidBST(TreeNode root) {

        return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

    }
	
	public static boolean isBST(TreeNode root,int min, int max) {

		System.out.println("min "+min+",max "+max);
		
		if(root == null ) {
			System.out.println("in 1");
			return true;
		}
		if((root.left!=null && root.val<=root.left.val) || (root.right!=null && root.val>=root.right.val)) {
			return false;
		}
		if(root.val<min || root.val>max) {
			System.out.println("in 2");
			return false;
		}
		
		return isBST(root.left,min,root.val-1) && isBST(root.right,root.val+1,max);
	}

}
