package LeetCode2;

import LeetCode.Helper.ListNode;
import java.util.List;
import java.util.ArrayList;

public class AddTwoNumberII {
	
	/*
	 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
		
		Follow up:
		What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
		
		Example:
		
		Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 8 -> 0 -> 7
	 */
	
	
	public static ListNode createList(Integer[] arr) {
		ListNode n1 = null;
		ListNode n2 = null;
		
		
		for(int i = 0;i<arr.length;i++) {
			
			ListNode node = new ListNode(arr[i]);
			
			if(i==0) {
				n1 = node;
				n2 = n1;
			}
			else {
				n1.next = node;
				n1 = n1.next;
			}
		}// end for
		
		return n2;
	}

	public static void main(String[] args) {
		ListNode n1 = createList(new Integer[] {1});
		ListNode n2 = createList(new Integer[] {9,9});
	
		System.out.println(n1);
		System.out.println(n2);
		
		System.out.println(addTwoNumbers(n1,n2));
	}
	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		
		ListNode n1 = reverseLinkedList(l1);
		ListNode n2 = reverseLinkedList(l2);
		
		ListNode n3 = null;
		ListNode n4=n3;

		
		int sum = 0;
		int carry = 0;
		
		while(n1!=null || n2!=null) {
			
			int sumValue = ((n1!=null?n1.val:0) + (n2!=null?n2.val:0) + carry);
			sum = sumValue%10;
			carry = sumValue/10;
			System.out.println("sum "+sum+", carry "+carry);
			
			ListNode node = new ListNode(sum);
			
			
			if(n3==null) {
				n3 = node;
				n4 = n3;
			}
				
			else {
				n3.next=node;
				n3=n3.next;
			}
				

			//System.out.println(n4);
			
			if(n1!=null) n1=n1.next;
			if(n2!=null) n2=n2.next;
			
			
		}//end while
		
		if(carry>0) {
			//System.out.println("carry "+carry);
			ListNode node = new ListNode(carry);
			n3.next=node;
			n3=n3.next;
		}

		
		return reverseLinkedList(n4);
		
		
    }//end addTwoNumbers()
	
	public static ListNode reverseLinkedList(ListNode root) {
		
		ListNode prev = null;
		ListNode curr= root;
		ListNode next = null;
		
		while(curr!=null) {
			next=curr.next;
			
			curr.next=prev;
			prev=curr;
			curr=next;
			
		}
		
		//System.out.println(prev);
		return prev;
	}

}
