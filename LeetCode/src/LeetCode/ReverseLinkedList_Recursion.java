package LeetCode;



public class ReverseLinkedList_Recursion {

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
			
			ListNode node2 = new ListNode(2);
			ListNode node3 = new ListNode(3);
			ListNode node4 = new ListNode(4);
			ListNode node5 = new ListNode(5);
			
			node1.next = node2;
			node2.next = node3;
			node3.next = node4;
			node4.next = node5;
			
			
			displayList(reverseList(node1));
			
			
		}
		
		
		
		public static ListNode reverseList(ListNode head) {
			
			if(head.next==null) {
				return head;
			}
			
			
			ListNode p = reverseList(head.next);
			head.next.next = head;
			head.next = null;
			
			return p;
	    }
		
		
		
		
		public static void displayList(ListNode head) {
			ListNode node = head;
			
			while(node!=null) {
				System.out.println(node.val);
				node = node.next;
			}
		}

	
}
