package LeetCode.fb;

import java.util.LinkedList;
import java.util.Queue;

import LeetCode.Helper.TreeNode;

public class SameTree {

	
	/*
	 	Given two binary trees, write a function to check if they are the same or not.

		Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
		
		Example 1:
		
		Input:     1         1
		          / \       / \
		         2   3     2   3
		
		        [1,2,3],   [1,2,3]
		
		Output: true
		Example 2:
		
		Input:     1         1
		          /           \
		         2             2
		
		        [1,2],     [1,null,2]
		
		Output: false
	 */
	public static void main(String[] args) {
		TreeNode node1a = new TreeNode(1);
		TreeNode node2a = new TreeNode(2);
		TreeNode node3a = new TreeNode(3);
		
		node1a.left = node2a;
		node1a.right = node3a;
		
		TreeNode node1b = new TreeNode(1);
		TreeNode node2b = new TreeNode(2);
		TreeNode node3b = new TreeNode(3);
		
		node1b.left = node2b;
		node1b.right = node3b;
		
		System.out.println(isSameTree (node1a,node1b));
		
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		
		return (p.val==q.val) && (isSameTree(p.left, q.left) && isSameTree(p.right,q.right));
     }

}
