package LeetCode2;

import LeetCode.Helper.RandomListNode;
import java.util.Map;
import java.util.HashMap;

public class CopyListWithRandomPointer {
	
	/*
	 A linked list is given such that each node contains an additional random pointer which could 
	 point to any node in the list or null.

	Return a deep copy of the list.
	 */

	public static void main(String[] args) {
		RandomListNode n1 = createList(new Integer[]{2,5,6,7,4});
		
		System.out.println(copyRandomList(n1));

	}
	
	
	public static RandomListNode copyRandomList(RandomListNode head) {
		
        
		RandomListNode oldNode = head;
		RandomListNode newNode = null;
		RandomListNode finalNode = null;
		
		Map<RandomListNode,RandomListNode> visited = new HashMap<>();
		
		while(oldNode != null) {
			
			if(visited.containsKey(oldNode)) {
				newNode.next = visited.get(oldNode);
				visited.put(oldNode, newNode.next);
				newNode = newNode.next;
				
			}else {
				
				if(newNode == null) {
					newNode = new RandomListNode(oldNode.label);
					visited.put(oldNode, newNode);
					finalNode = newNode;
				}else {
					newNode.next = new RandomListNode(oldNode.label);
					visited.put(oldNode, newNode.next);
					newNode = newNode.next;
				}
				
			}
			
			if(visited.containsKey(oldNode.random)) {
				newNode.random = visited.get(oldNode.random);
			}else {
				newNode.random = new RandomListNode(oldNode.random.label);
				visited.put(oldNode.random,newNode.random);
			}
			
			
			oldNode = oldNode.next;
			
			
		}//end while
		
		
		
		return finalNode;
    }
	
	
	public static RandomListNode createList(Integer[] arr) {
		RandomListNode n1 = null;
		RandomListNode n2 = null;
		
		
		for(int i = 0;i<arr.length;i++) {
			
			RandomListNode node = new RandomListNode(arr[i]);
			
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

}
