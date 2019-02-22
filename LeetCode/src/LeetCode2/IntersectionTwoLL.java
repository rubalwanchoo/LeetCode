package LeetCode2;

import java.util.*;
import LeetCode.Helper.*;

public class IntersectionTwoLL {
	
	//https://leetcode.com/problems/intersection-of-two-linked-lists/

	public static void main(String[] args) {
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(8);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(0);
		ListNode node8 = new ListNode(1);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node6.next=node7;
		node7.next=node8;
		node8.next=node3;
		
		ListNode ret = getIntersectionNode(node1,node6);
		
		System.out.println(ret.val);

	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		ListNode p1 = headA;
		ListNode p2 = headB;
		
		int aCount = 0;
		int bCount = 0;
		
		while(p1!=null)
		{
			aCount++;
			p1=p1.next;
		}
		System.out.println("aCount "+aCount);
		
		while(p2!=null)
		{
			bCount++;
			p2=p2.next;
		}
		
		System.out.println("bCount "+bCount);
		
		//Assuming p2 is longer
		int diff = aCount-bCount;
		
		if(diff>0) {
			p2=headA;
			p1=headB;
		}else {
			p1=headA;
			p2=headB;
		}
		
		System.out.println("p1 after count "+p1.val+" ,p2 after count "+p2.val);
		
		
		for(int i=0;i<Math.abs(diff);i++) {
			p2=p2.next;
		}
		
		System.out.println("p2 after covering diff "+p2.val);
		
		while(p1!=null) {
			
			System.out.println("p1 "+p1.val+" p2 "+p2.val);
			
			if(p1==p2) break;
			
			p1=p1.next;
			p2=p2.next;
		}
		
		
		return p1;
    }

}
