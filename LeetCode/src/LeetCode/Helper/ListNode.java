package LeetCode.Helper;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	public ListNode() {};
	
	public String toString() {
		String ret = "";
		ListNode node = this;
		while(node!=null) {
		 ret = ret+ node.val+"->";
		 node= node.next;
		}
		
		ret = ret.substring(0,ret.length()-2);
		return ret;
	}
	
	public static ListNode CreateLinkedList(int[] arr) {
		
		ListNode head = null;
		ListNode node = null;

		
		
		for(int i=0;i<arr.length;i++) {
			
			ListNode temp = new ListNode(arr[i]);
			
			if(head==null) {
				head = temp;
				node = head;
			}else {
				node.next = temp;
				node = node.next;
			}

			
		}//end for
		
		return head;
	}
}
