package LeetCode.Amazon;

import LeetCode.Helper.*;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
	
	/*
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	public class BSTIterator {
	    TreeNode root ;
	    TreeNode node;
	    Queue<Integer> q
	    
	    public BSTIterator(TreeNode root) {
	        this.root = root;
	        q = new LinkedList<Integer>();
	        
	        if(root!=null){
	        	q.add(root.val);
	        	
	            if(root.right!=null) {
	            	TreeNode node = root.right;
		            while(node!=null){
		                q.add(node.val);
		                node = node.left;
		            }
	            }else {
	            	TreeNode node = root.left;
		            while(node!=null){
		                q.add(node.val);
		                node = node.right;
		            }
	            }
	            
	          
	        	   
	        }
	    }
	
	    /* @return whether we have a next smallest number */
	    public boolean hasNext() {
	        
	    	if(!q.isEmpty()) return true;
	        else return false;
	    }
	
	    /* @return the next smallest number */
	    public int next() {
	        
	        return q.poll();
	    }
	}
	
	/*
	 * Your BSTIterator will be called like this:
	 * BSTIterator i = new BSTIterator(root);
	 * while (i.hasNext()) v[f()] = i.next();
	 */