package LeetCode2;

import LeetCode.Helper.ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;
		
		System.out.println(reverse(n1));

	}
	
	
	public static ListNode reverse(ListNode root) {

		
		ListNode prev = null;
		ListNode curr = root;
		ListNode next = null;
		
		while(curr!=null) {
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		

		return prev;
	}

}
