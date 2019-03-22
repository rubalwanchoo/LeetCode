package LeetCode.Helper;

public class SBSTNode {
	//Self balancing Binary search tree
	
	SBSTNode left,right;
		
	int val;
	int height;
	
	public SBSTNode() {
		this.left=null;
		this.right=null;
		this.val = 0;
		this.height = 0;
				
	}
	
	public SBSTNode(int n) {
		this.left = null;
		this.right = null;
		this.val = n;
		this.height = 0;
	}
}
