package LeetCode2;

import LeetCode.Helper.TreeNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class LCABinaryTree {
	
	/*
	Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
	Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

	Example 1:

	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	Output: 3
	Explanation: The LCA of nodes 5 and 1 is 3.
	Example 2:

	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
	Output: 5
	Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
	 

	Note:

	All of the nodes' values will be unique.
	p and q are different and both values will exist in the binary tree.

	*/

	
	
	public static void main(String[] args) {
		Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
		int p=5;
		int q=8;
		
		TreeNode root = TreeNode.createTree(arr);
		
		TreeNode pNode = TreeNode.findTreeNode(root, p);
		System.out.println("pNode-"+(pNode==null?"null":pNode.val));
		
		TreeNode qNode = TreeNode.findTreeNode(root, q);
		System.out.println("qNode-"+(qNode==null?"null":qNode.val));
		
		System.out.println(lowestCommonAncestor(root,pNode,qNode).val);

	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		
		Stack<TreeNode> pStack = new Stack<>();
		Stack<TreeNode> qStack = new Stack<>();
		HashSet<TreeNode> visited = new HashSet<>();
		TreeNode respNode = null;
		
		pathToX(root,p,pStack);
		pathToX(root,q,qStack);
		
		
			
			
			while(!pStack.isEmpty() || !qStack.isEmpty()) {
				
				if(!pStack.isEmpty()) {
					
					if(!visited.contains(pStack.peek())) visited.add(pStack.pop());
					else {
						
						
						respNode = pStack.pop();
						break;
					}
				}
				
				if(!qStack.isEmpty()) {
					
					if(!visited.contains(qStack.peek())) visited.add(qStack.pop());
					else {
						respNode = qStack.pop();
						break;
					}
				}
				
			}//end while
			
		
		
		
		return respNode;
		
    }
	
	public static boolean pathToX(TreeNode root, TreeNode x, Stack<TreeNode> st) {
		
		if(root==null) return false;
		
		st.add(root);
		if(root==x) return true;
		
		if(pathToX(root.left,x,st) || pathToX(root.right,x,st)) return true;
		else {
			st.pop();
			return false;
		}
		
		
	}
	
	
	
	public static void printStack(Stack<TreeNode> stack) {
		
		System.out.println("printing stack");
		
		Stack<TreeNode> st = stack;
		
		while(!st.isEmpty()) {
			System.out.println(st.pop().val);
		}
	}
	
	

}
