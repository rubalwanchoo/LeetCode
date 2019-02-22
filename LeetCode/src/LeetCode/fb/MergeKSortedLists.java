package LeetCode.fb;

import LeetCode.Helper.ListNode;

public class MergeKSortedLists {
	
	/*
	 	Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

		Example:
		
		Input:
		[
		  1->4->5,
		  1->3->4,
		  2->6
		]
		Output: 1->1->2->3->4->4->5->6
		
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
 	}
	 */
	
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		node4.next = node5;
		node5.next = node6;

		ListNode node7 = new ListNode(2);
		ListNode node8 = new ListNode(6);
		node7.next = node8;
		
		System.out.println(mergeKLists(new ListNode[] {node1,node4,node7}).toString());
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		
		System.out.println("mergeKLists request");
		printList(lists);
		
		if(lists.length == 0) return null;
		
		ListNode finalListNode = null;
		boolean allNulls = false;
		
		for(ListNode item :lists) {
			if(item!=null) {
				allNulls = false;
				break;
			}else {
				allNulls = true;
			}
			
		}
		
		if(allNulls) return finalListNode;
		
		int minIdx = getIdxOfMinItemList(lists);
		ListNode node = lists[minIdx];
		finalListNode = new ListNode(node.val);
		
		node = node.next;
		lists[minIdx] = node;
		
		finalListNode.next = mergeKLists(lists); 
		
		return finalListNode;
    }
	
	
	private static int getIdxOfMinItemList(ListNode[] lists) {
		System.out.println("getIdxOfMinItemList request");
		printList(lists);
		
		int minimum = Integer.MAX_VALUE;
		int minIdx = -1;
		
		for(int i = 0;i<lists.length;i++) {
			if(lists[i]!=null) {
				ListNode listNode = lists[i];
				if(listNode.val <= minimum) {
					minimum = listNode.val;
					minIdx = i;
				}
			}
			
		}
		
		
		return minIdx;
	}
	
	private static void printList(ListNode[] lists) {
		
		for(int i = 0;i<lists.length;i++) {
			if(lists[i]!=null) {
				ListNode list = lists[i];
				System.out.println(list.toString());
			}
			
			
			
		}
	}
}
