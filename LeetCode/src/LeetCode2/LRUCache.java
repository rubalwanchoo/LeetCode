package LeetCode2;

import java.util.Map;
import java.util.HashMap;

public class LRUCache {
	
	class DLLNode{
		int key;
		int val;
		DLLNode next;
		DLLNode prev;
		
		DLLNode(int key, int val){
			this.key = key;
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}//end inner class DLLNode
	
	Map<Integer,DLLNode> cacheMap = new HashMap<>();
	int capacity;
	int currentSize;
	DLLNode startP = null;
	DLLNode endP = null;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.currentSize = 0;
	}
	
	public int get(int key) {
		if(!cacheMap.containsKey(key))
			return -1;
		else {
			//Retrieve Node
			DLLNode current = cacheMap.get(key);
			
			
			//Move it to front
			DLLNode previous = current.prev;
			DLLNode next = current.next;
			
			if(previous!=null) previous.next = next;
			if(next!=null) next.prev = previous;
			
			if(startP!=null) current.next = startP;
			startP = current;
			
			printCache();
			
			return current.val;
			
		}
	}
	
	public void put(int key, int value) {
		
		if(currentSize<capacity) {//Don't evict
			
			if(!cacheMap.containsKey(key)) {
				//Create DLLNode at the front
				DLLNode node = new DLLNode(key,value);
				
				if(startP!=null) {
					DLLNode startNode = startP;
					node.next = startNode;
					startNode.prev = node;
					
				}
				startP = node;
				
				//Add DLLNode to the map
				cacheMap.put(key, node);
				
				currentSize++;
				
				if(node.next==null) endP = node;
				
				
			}else {
				
				//Move the DLLNode to front
				DLLNode current = cacheMap.get(key);
				DLLNode previous = current.prev;
				DLLNode next = current.next;
				
				previous.next = next;
				next.prev = previous;
				
				current.next = startP;
				startP = current;
				
				current.val = value;
				
							
				if(current.next==null) endP = current;
			}
		}
		else {//size==capacity (might need to evict if new item)
			
			if(!cacheMap.containsKey(key)) {
				//Evict the least used 
				
				DLLNode secondToLast = endP.prev;
				DLLNode lastNode = endP;
				
				lastNode.prev = null;
				secondToLast.next = null;
				
				cacheMap.remove(lastNode.key);
				
				//Create new DLLNode at front
				
				DLLNode node = new DLLNode(key,value);
				DLLNode startNode = startP;
				
				node.next = startNode;
				startNode.prev = node;
				
				startP = node;
				
				//Add DLLNode to the map

				cacheMap.put(key, node);
								
				if(node.next==null) endP = node;
				
			}
			else {
				//Move the DLLNode to front
				DLLNode current = cacheMap.get(key);
				DLLNode previous = current.prev;
				DLLNode next = current.next;
				
				previous.next = next;
				next.prev = previous;
				
				current.next = startP;
				startP = current;
				
				if(current.next==null) endP = current;
				
			}
	
		}

			
			printCache();
	
		}//end put
	
		
	
	
	public void printCache() {
			System.out.println("map "+cacheMap);
			DLLNode node = this.startP;
		
			while(node!=null) {
				
				System.out.print("k "+node.key+" v "+node.val+"|");
				node=node.next;
			}
			System.out.println();
			System.out.println("currentSize "+this.currentSize);
	}//end printDDL
	
	
	
	
}
