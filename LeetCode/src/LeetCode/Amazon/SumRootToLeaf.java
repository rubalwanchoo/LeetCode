package LeetCode.Amazon;

import LeetCode.Helper.TreeNode;

public class SumRootToLeaf {
	
	/*
	 	Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

		An example is the root-to-leaf path 1->2->3 which represents the number 123.
		
		Find the total sum of all root-to-leaf numbers.
		
		Note: A leaf is a node with no children.
		
		Example:
		
		Input: [1,2,3]
		    1
		   / \
		  2   3
		Output: 25
		Explanation:
		The root-to-leaf path 1->2 represents the number 12.
		The root-to-leaf path 1->3 represents the number 13.
		Therefore, sum = 12 + 13 = 25.
		Example 2:
		
		Input: [4,9,0,5,1]
		    4
		   / \
		  9   0
		 / \
		5   1
		Output: 1026
		Explanation:
		The root-to-leaf path 4->9->5 represents the number 495.
		The root-to-leaf path 4->9->1 represents the number 491.
		The root-to-leaf path 4->0 represents the number 40.
		Therefore, sum = 495 + 491 + 40 = 1026.
	 */

	static String str = "";
	static int sum = 0 ;
	
	public static void main(String[] args) {
		
		//TreeNode root = TreeNode.createTree(new Integer[] {4,9,0,5,1});
		TreeNode root = TreeNode.createTree(new Integer[] {1,2,3});
		//TreeNode.displayTree(root);
		
		System.out.println(sumNumbers(root));

	}
	
	public static int sumNumbers(TreeNode root) {
		
		if(root == null) return 0;
		
		sum = calculateSum(root);
        
		System.out.println("sum "+sum);
        return sum;
    }
	
	public static int calculateSum(TreeNode root) {
		
		if(root.left == null && root.right == null) {
			str += root.val;
			System.out.println("str1 "+str);
			
			sum += Integer.parseInt(str);

		}else {
			
			
			str += root.val;
			
			if(root.left!=null) {
				calculateSum(root.left);
				str = str.substring(0, str.length()-1);
				System.out.println("str2 "+str);
				
			}
			
			if(root.right!=null) {
				calculateSum(root.right);
				str = str.substring(0, str.length()-1);
				System.out.println("str3 "+str);
			}

		}
		
		return sum;
		
		
	}

}
