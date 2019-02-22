package LeetCode.fb;

import LeetCode.Helper.*;

public class RemoveNthNodeFromEndOfList {

	/*
	 Given a linked list, remove the n-th node from the end of list and return its head.

		Example:
		
		Given linked list: 1->2->3->4->5, and n = 2.
		
		After removing the second node from the end, the linked list becomes 1->2->3->5.
		Note:
		
		Given n will always be valid.
		
		Follow up:
		
		Could you do this in one pass?
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode node6 = new ListNode(1);
		
		ListNode node7 = new ListNode(1);
		ListNode node8 = new ListNode(2);
		
		node7.next=node8;
		
		
		//System.out.println(removeNthFromEnd(node1,2));
		//System.out.println(removeNthFromEnd(node6,1));
		System.out.println(removeNthFromEnd(node7,2));
	}

	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        
		if(head==null) return head;
		
		int counter = 1;
		ListNode p1 = head;
		ListNode p2 = head;
		
		while(counter<n) {
			
			p2=p2.next;
			counter++;
		}
		
		ListNode parent = null;
		
		while(p2.next != null) {
			parent = p1;
			p1=p1.next;
			p2=p2.next;
		}
		
		System.out.println("p1 "+p1.val+" p2 "+p2.val+" parent "+(parent==null?"null":parent.val));
		
		
		if(parent!=null) {
			parent.next = p1.next;
		}else {
			head = p1.next;
		}
		
		p1.next=null;
		
		
		
		
		return head;
    }
}
