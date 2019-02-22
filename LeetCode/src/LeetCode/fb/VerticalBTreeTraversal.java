package LeetCode.fb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;


import LeetCode.Helper.TreeNode;

public class VerticalBTreeTraversal {
	
	/*
	 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

		If two nodes are in the same row and column, the order should be from left to right.
		
		Examples 1:
		
		Input: [3,9,20,null,null,15,7]
		
		   3
		  /\
		 /  \
		 9  20
		    /\
		   /  \
		  15   7 
		
		Output:
		
		[
		  [9],
		  [3,15],
		  [20],
		  [7]
		]
	 */
	static List<List<Integer>> myList = new ArrayList<List<Integer>>();
	static SortedMap<Integer,List<Integer>> myMap = new TreeMap<>(); 
	
	public static void main(String[] args) {
		
		
		
	}
	
	public static List<List<Integer>> verticalOrder(TreeNode root) {
		
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		q1.add(root);
		q2.add(0);
		
		while(!q1.isEmpty()) {
			
			TreeNode node = q1.poll();
			Integer level = q2.poll();
			
			if(myMap.containsKey(level)){
				
				List<Integer> list = myMap.get(level);
				list.add(node.val);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(node.val);
				myMap.put(level, list);
			}
			
			if(node.left!=null) {
				q1.add(node.left);
				q2.add(level-1);
				
			}
			
			if(node.right!=null) {
				q1.add(node.right);
				q2.add(level+1);
			}
			
		}
		
		
		for(Map.Entry<Integer, List<Integer>> entry:myMap.entrySet()) {
			
			myList.add(entry.getValue());
		}
		
		
		return myList;
	}
	
	
	
	
	/*Depth first approach
	public static List<List<Integer>> verticalOrder(TreeNode root) {
        
		verticalTraverse(root,0);
		
		for(Map.Entry<Integer, List<Integer>> entry:myMap.entrySet()) {
			
			myList.add(entry.getValue());
		}
		
		return myList;
    }
	
	public static void verticalTraverse(TreeNode root,int horizontalLevel) {
		
		if(root==null) return;
		
		if(myMap.containsKey(horizontalLevel)){
			
			List<Integer> list = myMap.get(horizontalLevel);
			list.add(root.val);
		}else {
			List<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			myMap.put(horizontalLevel, list);
		}
		
		verticalTraverse(root.left,horizontalLevel-1);
		verticalTraverse(root.right,horizontalLevel+1);
		
		
		
		
	}
	*/
}
