package LeetCode.Helper;

public class TreeNode {
	 public Integer val;
	 public TreeNode left;
	 public TreeNode right;
	 public TreeNode() {  }
	 public TreeNode(int x) { val = x; }
	 
	 
	 
	 public static TreeNode createTree(Integer[] arr) {
		 
		 TreeNode root = new TreeNode(); 
		 
		 root = createNodes(root, 0,arr);

		 return root;
	 }
	 
	 public static TreeNode createNodes(TreeNode root, int pIdx,Integer[] arr) {
		 
		 
		 if(pIdx<arr.length) {
			 
			 TreeNode temp = (arr[pIdx]==null)?null:new TreeNode(arr[pIdx]);
			 
			 root= temp;
			 //System.out.println("returning root value "+root.val);
		
			//Insert left child
			 if(root!=null) root.left = createNodes(root.left,2*pIdx+1,arr);
			 
			//Insert right child
			 if(root!=null) root.right = createNodes(root.right,2*pIdx+2,arr);
				 
		 }
		
		return root;
	 }
	 
	 public static void displayTree(TreeNode node) {
		
		  
		 if(node != null) {
			 
			 System.out.println(node.val);
			 displayTree(node.left);
			 displayTree(node.right);
		 }
		 
		 
	 }
	 
	 public static TreeNode findTreeNode(TreeNode root, int x) {
		 
		 System.out.println("findTreeNode "+root.val);
		 
		TreeNode node = root;
		TreeNode result = null;
		
		if(node.val == x) return node;
		
		//Cant go any further
		if(node.left==null && node.right==null) return null;
		
		//Go Left
		result = findTreeNode(node.left,x);
		
		//Check the node
		if(result!=null && result.val == x) return result;
		
		//if not found on left, do the same on right
		return findTreeNode(node.right,x);
		 
	 }
	 
}



