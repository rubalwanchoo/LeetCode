package LeetCode.Amazon;

import LeetCode.Helper.TreeNode;

public class SubtreeOfAnotherTree {
	
	/*
	 	Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

		Example 1:
		Given tree s:
		
		     3
		    / \
		   4   5
		  / \
		 1   2
		Given tree t:
		   4 
		  / \
		 1   2
		Return true, because t has the same structure and node values with a subtree of s.
		Example 2:
		Given tree s:
		
		     3
		    / \
		   4   5
		  / \
		 1   2
		    /
		   0
		Given tree t:
		   4
		  / \
		 1   2
		Return false.
	 */
	

	public static void main(String[] args) {
		//Tree t
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(2);
		TreeNode node9 = new TreeNode(0);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node9;
		
		
		//Tree s
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(1);
		TreeNode node8 = new TreeNode(2);
		
		node6.left = node7;
		node6.right = node8;
		
		System.out.println(isSubtree(node1,node6));
		

	}

	
	 public static boolean isSubtree(TreeNode s, TreeNode t) {
		 
		 if(t==null) return true;
		 if(s==null) return false;
		 
		 if(isValidSubTree(s,t)) {
			 return true;
		 }
		 
		 return isSubtree(s.left,t) || isSubtree(s.right,t);
	        
	 }
	 
	 public static boolean isValidSubTree(TreeNode s, TreeNode t) {
		 
		 if(t==null && s==null) return true;
		 if(t==null || s==null) return false;
		 
		 
		 return (t.val==s.val)&& isValidSubTree(t.left,s.left) && isValidSubTree(t.right,s.right);
	 }
	
}
