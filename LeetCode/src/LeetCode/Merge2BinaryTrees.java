package LeetCode;

import LeetCode.Helper.*;

public class Merge2BinaryTrees {

	
	/*
	 	Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

		You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
		
		Example 1:
		Input: 
			Tree 1                     Tree 2                  
		          1                         2                             
		         / \                       / \                            
		        3   2                     1   3                        
		       /                           \   \                      
		      5                             4   7                  
		Output: 
		Merged tree:
			     3
			    / \
			   4   5
			  / \   \ 
			 5   4   7
		Note: The merging process must start from the root nodes of both trees.
		

	 */

	public static void main(String args[]) {
		TreeNode t101 = new TreeNode(1);
		TreeNode t111= new TreeNode(3);
		TreeNode t112= new TreeNode(2);
		TreeNode t121= new TreeNode(5);
		
		t101.left = t111;
		t101.right = t112;
		t111.left = t121;
		
		TreeNode t201 = new TreeNode(2);
		TreeNode t211= new TreeNode(1);
		TreeNode t212= new TreeNode(3);
		TreeNode t221= new TreeNode(4);
		TreeNode t222= new TreeNode(7);
		
		t201.left = t211;
		t201.right = t212;
		t211.right = t221;
		t212.right = t222;
		
		TreeNode t301 = mergeTrees(t101,t201);
		
		displayTree(t301);
	}
	
	
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		if(t1==null) {
			return t2;
		}
		if(t2==null) {
			return t1;
		}

		if(t1!=null && t2!=null) {
			
			t1.val = t1.val+t2.val;
			
			t1.left = mergeTrees(t1.left,t2.left);
			t1.right = mergeTrees(t1.right,t2.right);
		}
		
		return t1;
        
    }
	
	
	public static void displayTree(TreeNode t) {
		if(t == null) return;
		
		System.out.println(t.val);
		displayTree(t.left);
		displayTree(t.right);
	}
	
}
