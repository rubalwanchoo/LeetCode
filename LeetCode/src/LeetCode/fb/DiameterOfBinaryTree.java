package LeetCode.fb;

import LeetCode.Helper.*;

public class DiameterOfBinaryTree {

	
	/*
	 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

		Example:
		Given a binary tree 
		          1
		         / \
		        2   3
		       / \     
		      4   5    
		Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
		
		Note: The length of path between two nodes is represented by the number of edges between them.
	 */
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		//System.out.println(heightOfBinaryTree(node2));
		System.out.println(diameterOfBinaryTree(node1));
		
	}
	
	
	public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        
        return Math.max(heightOfBinaryTree(root.left)+heightOfBinaryTree(root.right),Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)));
    }
	
	public static int heightOfBinaryTree(TreeNode root) {
		System.out.println("visiting node "+ (root==null?"null":root.val));
		
		if(root == null) {
			return 0;
		}
		
		int heightLSubTree = heightOfBinaryTree(root.left);
		int heightRSubTree = heightOfBinaryTree(root.right);
		
		return Math.max(heightLSubTree,heightRSubTree)+1;
		
		
	}
}
