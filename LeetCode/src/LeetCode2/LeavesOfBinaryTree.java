package LeetCode2;

import java.util.*;
import LeetCode.Helper.*;

public class LeavesOfBinaryTree {
	
	public static Map<Integer,List<Integer>> leafMap = new HashMap<>();

	public static void main(String[] args) {
		
		TreeNode root = TreeNode.createTree(new Integer[] {1,2,3,4,5});
		
		System.out.println(findLeaves(root));

	}
	
	
	public static List<List<Integer>> findLeaves(TreeNode root) {
        
		List<List<Integer>> respList = new ArrayList<List<Integer>>();
        
        if(root==null) return respList;
        
        int i = traverseNode(root);
		
		//System.out.println(leafMap);
		

		Iterator it = leafMap.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, List<Integer>> mp = (Map.Entry)it.next();
			respList.add(mp.getValue());
		}
		
		
		return respList;
	}
	
	public static int traverseNode(TreeNode root) {
		
		int resp = Integer.MIN_VALUE;
		
		if(root.left==null & root.right==null) {
			resp = 0;
		}else {
			resp = Math.max(root.left!=null?traverseNode(root.left):Integer.MIN_VALUE, 
					root.right!=null?traverseNode(root.right):Integer.MIN_VALUE)+1;
			
		}
				
		List<Integer> leafList = leafMap.get(resp);
		
		if(leafList==null)
			leafList = new ArrayList<Integer>();
		
		leafList.add(root.val);
		leafMap.put(resp,leafList);
		
		return resp;
	}
	
	
	

}
