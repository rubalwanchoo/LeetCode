package LeetCode.Helper;

public class RandomListNode {
	public int label;
	public RandomListNode next;
	public RandomListNode random;
	public RandomListNode(int x) { this.label = x; }
	
	public String toString() {
		String ret = "";
		RandomListNode node = this;
		while(node!=null) {
		 ret = ret+ node.label+"->";
		 node= node.next;
		}
		
		ret = ret.substring(0,ret.length()-2);
		return ret;
	}
}
