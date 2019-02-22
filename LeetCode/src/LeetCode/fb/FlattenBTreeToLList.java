package LeetCode.fb;

import LeetCode.Helper.*;

public class FlattenBTreeToLList {

	
	/*
	 * Given a binary tree, flatten it to a linked list in-place.

		For example, given the following tree:
		
		    1
		   / \
		  2   5
		 / \   \
		3   4   6
		The flattened tree should look like:
		
		1
		 \
		  2
		   \
		    3
		     \
		      4
		       \
		        5
		         \
		          6
	 */

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node1.left = node2;
		node1.right = node5;
		
		node2.left = node3;
		node2.right = node4;
		
		node5.right = node6;
		
		
		
		/*
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node3;
		node1.right = node4;
		node4.left = node2;
		node2.right = node5;
		*/
		
		flatten(node1);
		
		TreeNode.displayTree(node1);
		
	}

	
	public static void flatten(TreeNode root) {
		System.out.println("node val "+root.val);
        
		TreeNode node = root;
		
		if(node.left!=null) {
			System.out.println("going to node.left "+node.left.val);
			flatten(node.left);
		}
		
		
		if(node.left != null && node.left.left == null) {
			System.out.println("inside condition for node "+node.val);
			
			TreeNode temp = node.right;
			node.right = node.left;
			
			node.left = null;
			
			TreeNode t = node.right;
			while(t.right!=null) {
				t=t.right;
			}
			t.right = temp;
			
			System.out.println("new node.left "+ (node.left==null?"null":node.left.val));
			System.out.println("new node.right "+ (node.right==null?"null":node.right.val));
			System.out.println("new node.right.right "+ (node.right.right==null?"null":node.right.right.val));
		}
		
		
		if(node.right!=null) {
			System.out.println("going to node.right "+node.right.val);
			flatten(node.right);
		}
		
    }
	
	
}
