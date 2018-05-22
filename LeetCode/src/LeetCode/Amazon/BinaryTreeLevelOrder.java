package LeetCode.Amazon;

import LeetCode.Helper.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;


public class BinaryTreeLevelOrder {
	/*
	 	Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

		For example:
		Given binary tree [3,9,20,null,null,15,7],
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]
	 */

	public static void main(String[] args) {
		
		TreeNode root = TreeNode.createTree(new Integer[] {3,9,20,-1,-1,15,7});
		
		//TreeNode.displayTree(root);
		
		System.out.println(levelOrder(root));

	}
	
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> mList = new ArrayList<List<Integer>>();
		
		if(root==null)return mList;
		
		Queue<Object[]> q = new LinkedList<Object[]>();
		//storing object[] as a tuple in the queue where item0 stores the treenode and item1 stores the level
		int level = 0;
		List<Integer> myList = new ArrayList<Integer>();
		
		
		q.add(new Object[] {root,0});
		
		
		while(!q.isEmpty()) {
			
			Object[] dq = q.poll();
			
			System.out.println("object dq[0] "+((TreeNode)dq[0]).val+", dq[1] "+(Integer)dq[1]);
			
			if((Integer)dq[1]!=level) {
				mList.add(myList);
				myList = new ArrayList<Integer>();
				level = (Integer)dq[1];
			}
			
			if(((TreeNode)dq[0]).val!=null) myList.add(((TreeNode)dq[0]).val);//in leet code remove .val in the null check 
			
			TreeNode temp = (TreeNode)dq[0];
			
			if(temp.left!=null) q.add(new Object[] {temp.left,(Integer)dq[1]+1});
			if(temp.right!=null) q.add(new Object[] {temp.right,(Integer)dq[1]+1});
			
		}
		mList.add(myList);
		
		return mList;
        
    }
	
	
    
}
