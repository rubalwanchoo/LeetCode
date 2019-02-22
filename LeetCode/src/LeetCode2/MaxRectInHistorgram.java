package LeetCode2;

import java.util.Stack;

public class MaxRectInHistorgram {

	/*
	Given n non-negative integers representing the histogram's bar height 
	where the width of each bar is 1, find the area of largest rectangle in the histogram.
	
	Example:

		Input: [2,1,5,6,2,3]
		Output: 10
		
	*/	
	
	
	public static void main(String[] args) {
		
		//System.out.println(largestRectangleArea(new int[] {1,3,2,1,2}));
		//System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
		//System.out.println(largestRectangleArea(new int[] {3,6,5,7,4,8,1,0}));
		System.out.println(largestRectangleArea(new int[] {1,0,1,0,0}));
	}
	
	public static int largestRectangleArea(int[] heights) {
        Stack<Integer> pStack = new Stack<>();
        Stack<Integer> hStack = new Stack<>();
        
        int maxHeight = 0;
        
        for(int pos = 0;pos<heights.length;pos++) {
        	
        	//System.err.println("pStack "+pStack);
        	//System.err.println("hStack "+hStack);
        	
        	if(pos==0 || heights[pos]>hStack.peek()) {
        		pStack.add(pos);
        		hStack.add(heights[pos]);
        	}else if(heights[pos]<hStack.peek()){
        		
        		int tempPos = -1;
        		
        		while(!hStack.isEmpty() && heights[pos]<hStack.peek()) {
        			tempPos = pStack.peek();
        			maxHeight = Math.max(maxHeight, hStack.pop()*(pos-pStack.pop()));
        			
        		}//end while
        		
        		hStack.add(heights[pos]);
        		pStack.add(tempPos);
        	}
        	
	
        }//end for
        
        
        while(!hStack.isEmpty()) {
        	
        	maxHeight = Math.max(maxHeight, hStack.pop()*(heights.length-pStack.pop()));
        }
        
        
        return maxHeight;
    }

}
