package LeetCode2;


import LeetCode.Helper.*;

public class MaxDepthBinTree {

	public static void main(String[] args) {
		
		TreeNode root = TreeNode.createTree(new Integer[] {3,9,20,null,null,15,7});
		System.out.println(maxDepth(root));
	}
	
	public static int maxDepth(TreeNode root) {
		
		if(root==null) return 0;
        
		if(root.left==null && root.right==null) return 1;
		
		
		return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
