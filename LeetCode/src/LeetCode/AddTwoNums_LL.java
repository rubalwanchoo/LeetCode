package LeetCode;

import java.util.LinkedList;
import java.util.Iterator;

public class AddTwoNums_LL {

	/*
	 * You are given two non-empty linked lists representing two non-negative integers.
	 * The digits are stored in reverse order and each of their nodes contain a single digit. 
	 * Add the two numbers and return it as a linked list.
	 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

			Example

			Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
			Output: 7 -> 0 -> 8
			Explanation: 342 + 465 = 807.

	 */
	
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(9);
		ListNode node3 = new ListNode(8);
		ListNode node7 = new ListNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node7;
		
		ListNode node4 = new ListNode(9);
		ListNode node5 = new ListNode(8);
		ListNode node6 = new ListNode(7);
		

		node4.next = node5;
		node5.next = node6;

		
		
		displayList(addTwoNumbers(node1,node4));
		
	}
	
	
	public static void displayList(ListNode l3) {
		System.out.println("In displayList");
		
		while(l3!=null) {
			System.out.print(l3.val);
			l3=l3.next;
		}
	}

	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		//System.out.println("In addTwoNumbers");
		
		ListNode l3Head = new ListNode(0);
		ListNode l3Node = l3Head;
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			
			if(l1 != null && l2 !=null) {
				System.out.println("In condition1");
				
				ListNode tempNode = new ListNode(0);
				int addedValue = 0;
				
				addedValue = l1.val +l2.val +carry;
				int quotient = addedValue/10;
				int remainder = addedValue % 10;
				
				tempNode.val = remainder;
				carry = quotient;
				
				l3Node.next=tempNode;
				
				l1= l1.next;
				l2=l2.next;
				l3Node=l3Node.next;

			}			
			else if(l2!=null) {
				System.out.println("In condition2");
				
				ListNode tempNode = new ListNode(0);
				int addedValue = 0;
				
				addedValue = l2.val+carry;
				int quotient = addedValue/10;
				int remainder = addedValue % 10;
				
				tempNode.val = remainder;
				carry = quotient;

				l3Node.next=tempNode;

				l2=l2.next;
				l3Node=l3Node.next;
			}
			else if(l1!=null) {
				System.out.println("In condition2");
				
				ListNode tempNode = new ListNode(0);
				int addedValue = 0;
				
				addedValue = l1.val+carry;
				int quotient = addedValue/10;
				int remainder = addedValue % 10;
				
				tempNode.val = remainder;
				carry = quotient;

				l3Node.next=tempNode;

				l1=l1.next;
				l3Node=l3Node.next;
			}

		}
		
		if(carry!=0) {
			ListNode tempNode = new ListNode(carry);
			l3Node.next = tempNode;	
		}
		
		return l3Head.next;
		
    }
	
	
	

	

	
}
