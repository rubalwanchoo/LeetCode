package LeetCode.Helper;

public class SelfBalancingBST {

	
	/*	Public methods
	 * 
	 * 	boolean isEmpty() 								- Function to see if tree is empty
	 * 	void clear() 									- Make the tree logically empty
	 * 	void insert(int val) 							- Function to insert data
	 * 	int countNodes() 								- Function to count number of nodes
	 * 	boolean search(int val) 						- Function to search for an element
	 * 	void inOrder() 									- Function for inOrder traversal
	 * 	void preOrder() 								- Function for preOrder traversal
	 * 	void postOrder() 								- Function for postOrder traversal
	 * 
	 * 
	 * 	Private methods
	 * 
	 * 	int height(SBSTNode t)							- Function to get height of a node
	 * 	int countNodes(SBSTNode t)						- Function to count number of nodes by traversing recursively
	 * 	SBSTNode insert(int val, SBSTNode t)			- Function to insert val by traversing recursively
	 * 	boolean search(int val, SBSTNode t)				- Function to search for node by traversing recursively
	 * 	void inOrder(SBSTNode t)						- Function to print node in inOrder by traversing recursively
	 * 	void preOrder(SBSTNode t)						- Function to print nodes in preOrder by traversing recursively
	 * 	void postOrder(SBSTNode t)						- Function to print nodes in postOrder by traversing recursively
	 * 	SBSTNode rotateWithLeftChild(SBSTNode t)		- Rotate BinaryTree Node with left child
	 * 	SBSTNode rotateWithRightChild(SBSTNode t)		- Rotate BinaryTree Node with right child
	 * 	SBSTNode doubleRotateWithLeftChild(SBSTNode t) 	- Double rotate BinaryTree Node, First left child with its right child, then Node t with new left child
	 * 	SBSTNode doubleRotateWithRightChild(SBSTNode t)	- Double rotate BinaryTree Node, First right child with its left child, then Node t with new right child
	 */
	
	
	 private SBSTNode root;
	 
	 public SelfBalancingBST() {
		 this.root = null;
	 }
	 
	 public boolean isEmpty() {
		 return root == null;
	 }
	
	 public void clear() {
		 root=null;
	 }
	 
	 public void insert(int val) {
		 root = insert(val, root);
	 }
	 
	 public int countNodes() {
		 return countNodes(root);
	 }
	 
	 public boolean search(int val) {
		 return search(val, root);
	 }
	 
	 public void inOrder() {
		 inOrder(root);
	 }
	 
	 public void preOrder() {
		 preOrder(root);
	 }
	 
	 public void postOrder() {
		 postOrder(root);
	 }
	 

	 private SBSTNode insert(int val, SBSTNode t) {
		 
		 if(t==null) {
			 t = new SBSTNode(val);
		 }
		 else if(val<t.val) {
			 
			 t.left = insert(val,t.left); //recompute the left child
			 
			 if(t.left.height-t.right.height==2) {//when there is imbalance on the left
				 
				 if(val<t.left.val)
					 t = rotateWithLeftChild(t);
				 else
					 t = doubleRotateWithLeftChild(t);
			 }
		 }
		 else if(val>t.val) {
			 
			 t.right = insert(val,t.right); // recompute the right child
			 
			 if(t.right.height-t.left.height==2) {//when there is imbalance on the right
				 
				 if(val>t.right.val)
					 t = rotateWithRightChild(t);
				 else
					 t= doubleRotateWithRightChild(t);
			 }
		}
		 else {
			 //duplicate do nothing
		 }
		 
		 t.height = Math.max(height(t.left), height(t.right))+1;
		 return t;
	 }
	 
	 private SBSTNode doubleRotateWithRightChild(SBSTNode t) {
		 t.right = rotateWithLeftChild(t.right);
		 return rotateWithLeftChild(t);
	 }
	 
	 private SBSTNode doubleRotateWithLeftChild(SBSTNode t) {
		 
		 t.left = rotateWithRightChild(t.left);
		 return rotateWithLeftChild(t);
	 }
	 
	 private SBSTNode rotateWithRightChild(SBSTNode t) {
		 SBSTNode t1 = t.right;
		 t.right = t1.left;
		 t1.left = t;
		 
		 t.height = Math.max(height(t.left), height(t.right))+1;
		 t1.height = Math.max(height(t1.left),height(t1.right))+1;
		 
		 return t1;
	 }
	 
	 private SBSTNode rotateWithLeftChild(SBSTNode t) {
		 SBSTNode t1 = t.left;
		 t.left = t1.right;
		 t1.right = t;
		 
		 t.height = Math.max(height(t.left),height(t.right))+1;
		 t1.height = Math.max(height(t1.left),height(t1.right))+1;
		 
		 return t1;
	 }
	 
	 private void postOrder(SBSTNode t) {
		 
		 if(t!=null) {

			 inOrder(t.left);
			 inOrder(t.right);
			 System.out.println(t.val +" ");
		 }
	 }
	 
	 private void preOrder(SBSTNode t) {
		 
		 if(t!=null) {
			 
			 System.out.println(t.val +" ");
			 inOrder(t.left);
			 inOrder(t.right);
		 }
	 }
	 
	 private void inOrder(SBSTNode t) {
		 
		 if(t!=null) {
			 
			 inOrder(t.left);
			 System.out.println(t.val +" ");
			 inOrder(t.right);
		 }
	 }
	 
	 private boolean search(int val, SBSTNode t) {
		 
		 
		 if(t==null) return false;
		 else if(t.val!=val) {
			 
			 if(val<t.val) return search(val,t.left);
			 else return search(val,t.right);
		 }
		 else
			 return true;
	 }
	 
	 private int height(SBSTNode t) {
		 return t==null?-1:t.height;
	 }
	 
	 private int countNodes(SBSTNode t){
		 
		 if(t==null) return 0;
		 else
		 {
			 int count = 1;
			 
			 count += countNodes(t.left);
			 count += countNodes(t.right);
			 
			 return count;
		 }
	 
	 }
}
