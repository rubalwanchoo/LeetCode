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
			 
			 TreeNode temp = (arr[pIdx]==-1)?new TreeNode():new TreeNode(arr[pIdx]);
	
			 root= temp;
			 System.out.println("returning root value "+root.val);
			 
			 //Insert left child
			 root.left = createNodes(root.left,2*pIdx+1,arr);
			 
			//Insert right child
			 root.right = createNodes(root.right,2*pIdx+2,arr);
			 
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
	 
}



