package LeetCode2;

import java.util.Arrays;

public class MyHeap {
	
	int size = -1; //holds the length of populated values in heap
	int capacity = 0; // holds the length of total heap
	int[] heap;
	
	public MyHeap(int capacity) {
		
		this.capacity = capacity;
		heap = new int[capacity+1];
		heap[++size] = Integer.MIN_VALUE;
		
	}
	
	private int parent(int pos) {
		return pos/2;
	}
	
	private int leftChild(int pos) {
		return 2*pos;
	}
	
	private int rightChild(int pos) {
		return 2*pos+1;
	}
	
	private boolean isLeaf(int pos) {
		
		if(pos>(this.size/2) && pos<=size) return true;
		else 
			return false;
	}
	
	private void swap(int fPos, int sPos) {
		
		int tmp;
		tmp = heap[fPos];
		heap[fPos] = heap[sPos];
		heap[sPos] = tmp;
	}
	
	protected void insert(int element) {//this function does the sift up
			
		//check and double size
		if(size==capacity) {
			heap = Arrays.copyOf(heap, capacity*2);
			capacity *= 2;
		}
		
		heap[++size] = element;
		
		int current = size;
		while(heap[current]<heap[parent(current)])
		{
			swap(current,parent(current));
			current = parent(current);
		}
		
		
	}
	
	private void minHeapify(int pos) {//this function does the sift down
		
		
		if(!isLeaf(pos)) {
			if(heap[pos]>heap[leftChild(pos)] || heap[pos]>heap[rightChild(pos)]) {
				
				
				if(heap[leftChild(pos)]<heap[rightChild(pos)]) {
					swap(pos,leftChild(pos));
					minHeapify(leftChild(pos));
				}else {
					swap(pos,rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
		
	}
	
	
	public void convertMaxHeap() {
		
		for(int pos = size/2;pos>=1;pos--) {
			System.out.println("calling maxHeapify for pos "+pos);
			maxHeapify(pos);
		}
	}
	
	private void maxHeapify(int pos) {
		
		System.out.println("maxHeapify at pos "+pos);
		
		if(!isLeaf(pos) && heap[pos]<heap[leftChild(pos)] || heap[pos]<heap[rightChild(pos)]) {
			
			int swapPos = heap[leftChild(pos)]>heap[rightChild(pos)]?leftChild(pos):rightChild(pos);
			swap(pos,swapPos);
			
			if(!isLeaf(swapPos)) maxHeapify(swapPos);
			
		}
		
		
	}
	
	protected int remove() {
		int popped = heap[1];
		heap[1] = heap[size--];
		minHeapify(1);
		return popped;
	}
	
	public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print(" PARENT : " + heap[i] 
                     + " LEFT CHILD : " + heap[2 * i] 
                   + " RIGHT CHILD :" + heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
}
