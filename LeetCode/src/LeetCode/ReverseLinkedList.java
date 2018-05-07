package LeetCode;

public class ReverseLinkedList {
	/*
	 	Reverse a singly linked list.
	
		Example:
		
		Input: 1->2->3->4->5->NULL
		Output: 5->4->3->2->1->NULL
		Follow up:
		
		A linked list can be reversed either iteratively or recursively. Could you implement both?
		
		public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	 */
	
	public static void main (String[] args) {
		
		
		ListNode node1 = new ListNode(1);
		/*
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		*/
		
		displayList(reverseList(node1));
		
		
	}
	
	
	
	public static ListNode reverseList(ListNode head) {
        ListNode node = head;
        
        
        if(node==null || node.next==null) {
        	return node;
        }
        
        
        ListNode src = new ListNode(node.val);
        ListNode dest = null;
        
        //Iteration
        while(node!=null) {
        	
        	if(node.next!=null) {
        		dest = new ListNode(node.next.val);
            	dest.next = src;
            	src = dest;
	
        	}
        	
        	node = node.next;
        	
        }
        
        
        return dest;
    }
	
	
	
	public static void displayList(ListNode head) {
		ListNode node = head;
		
		while(node!=null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
