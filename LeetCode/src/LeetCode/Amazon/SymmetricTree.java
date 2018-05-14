package LeetCode.Amazon;

import LeetCode.Helper.*;

public class SymmetricTree {
	
	/*
	 	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

		For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
		
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		But the following [1,2,2,null,3,null,3] is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3
		Note:
		Bonus points if you could solve it both recursively and iteratively.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isSymmetric(TreeNode root) {
		
		if(root == null) return true;
		
		if(isMirrorImage(root.left,root.right)) {
			return true;
		}
        
		return false;
    }
	
	public static boolean isMirrorImage(TreeNode l,TreeNode r) {
		
		if(l==null && r==null) return true;
		if(l==null || r==null) return false;
		
		return (l.val==r.val) && isMirrorImage(l.left,r.right) && isMirrorImage(l.right,r.left); 
	}

}
