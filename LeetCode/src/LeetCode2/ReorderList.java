package LeetCode2;

import java.util.Stack;

import LeetCode.Helper.ListNode;

public class ReorderList {

	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		
		
		n1.next=n2;
		n2.next=n3;
		
		
		
		reorderList(n1);

	}

	
	
	public static void reorderList(ListNode head) {
	    
		System.out.println("Input "+head);
		
		ListNode n1 = head;
		ListNode n2 = head;
		ListNode n3 = head;
		ListNode n4 = null;
		int count = 1;

		
		
		
		//Take n2 to the last node
		while(n2.next!=null) {
			
			n2=n2.next;
			count++;
		}
		
		int mid = count/2;
		
		for(int i=0;i<mid;i++) {
			
			n3=n3.next;
		}
		
		n4=n3;
		
		
		//Populate Stack to store reverse list
		Stack<ListNode> nodeSt = new Stack<>();
		
		while(n4.next!=null) {
			nodeSt.push(n4);
			n4=n4.next;
			
		}
		
		//Push Last Item into stack
		nodeSt.push(n4);
		n4=n4.next;
		
		System.out.println("Stack contents "+nodeSt);

		//Reorder
		while(!nodeSt.isEmpty()) {
			
			System.out.println("currentListItem "+n1.val);
			
			ListNode curr = nodeSt.pop();
			System.out.println("stackTop "+curr.val);
			
			if((curr==n1.next && count%2==0) || (curr==n1 && count%2!=0) ||n1.next==null) {
				if(count%2==0) 
					n1.next.next = null;
				else n1.next=null;
				
				break;
			}
			                                   
			
			ListNode temp = n1.next;
			System.out.println("nextListItem "+((n1.next==null)?"null":n1.next.val));
		
			
			n1.next = curr;
			curr.next = temp;
			n1=temp;
			
			
		}
	    
		
		System.out.println("Output "+head);
	}
}
