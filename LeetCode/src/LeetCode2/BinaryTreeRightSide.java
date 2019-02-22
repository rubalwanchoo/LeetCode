package LeetCode2;

import java.util.*;
import LeetCode.Helper.*;

public class BinaryTreeRightSide {

	/*
	Given a binary tree, imagine yourself standing on the right side of it, 
	return the values of the nodes you can see ordered from top to bottom.

			Example:

			Input: [1,2,3,null,5,null,4]
			Output: [1, 3, 4]
			Explanation:

			   1            <---
			 /   \
			2     3         <---
			 \     \
			  5     4       <---

	*/
	
	public static void main(String[] args) {
		
		//Integer[] arr = new Integer[] {1,2,3,null,5,null,4};
		
		Integer[] arr = new Integer[] {};
		TreeNode myBTree = TreeNode.createTree(arr);
		TreeNode.displayTree(myBTree);
		
		System.out.println(rightSideView(myBTree));
		

	}
	
	public static List<Integer> rightSideView(TreeNode root) {
        
		
		Queue<TreeNode> q1 = new LinkedList<>();
		Map<TreeNode,Integer> levelMap = new HashMap<>();
		List<Integer> resp = new ArrayList<>();
		
		
		if(root!=null) {
			q1.add(root);
			levelMap.put(root, 0);
		}
		
		while(!q1.isEmpty()) {
			
			
			TreeNode node = q1.poll();
			
			if(q1.isEmpty() || levelMap.get(q1.peek())>levelMap.get(node)) {//last element at this level
				resp.add(node.val);
			}
			
			if(node.left!=null)  {
				q1.add(node.left);
				levelMap.put(node.left, levelMap.get(node)+1);
				
			}
			if(node.right!=null) {
				q1.add(node.right);
				levelMap.put(node.right, levelMap.get(node)+1);
				
			}
			
		}//end while
		
		return resp;
		
    }
}
