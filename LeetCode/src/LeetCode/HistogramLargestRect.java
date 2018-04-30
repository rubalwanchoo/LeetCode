package LeetCode;

import java.util.Stack;

public class HistogramLargestRect {
	
	/*
	 * from leet code
	 * 
	 	Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
	 	find the area of largest rectangle in the histogram.
		Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
		https://leetcode.com/static/images/problemset/histogram.png

		The largest rectangle is shown in the shaded area, which has area = 10 unit.
		https://leetcode.com/static/images/problemset/histogram_area.png
		 
		Example:
		
		Input: [2,1,5,6,2,3]
		Output: 10
	 */

	public static void main(String args[]) {
		System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));//10
		System.out.println(largestRectangleArea(new int[] {1,1}));//2
		System.out.println(largestRectangleArea(new int[] {2,1,2}));//3
	}
	
	public static int largestRectangleArea(int[] heights) {
		int maxArea = -1;
		
		Stack<Integer> pStack = new Stack<Integer>();
		Stack<Integer> hStack = new Stack<Integer>();
		
		int i = 0;
		while(i<heights.length) {
			
			if(pStack.isEmpty() || heights[i]>=hStack.peek()) {
				pStack.add(i);
				hStack.add(heights[i]);
				i++;
			}
			else if (heights[i]<hStack.peek()) {
				
				while(!hStack.isEmpty() && hStack.peek()>heights[i]) {
					maxArea = calculateMaxArea(hStack.peek(),i-pStack.peek(),maxArea);
					hStack.pop();
					pStack.pop();
				}
				pStack.push(pStack.isEmpty()?0:pStack.peek()+1);
				hStack.push(heights[i]);
			}
		}
		
		
		while(!pStack.isEmpty()) {
			maxArea = calculateMaxArea(hStack.peek(),i-pStack.peek(),maxArea);
			hStack.pop();
			pStack.pop();
			
		}
		
		return maxArea;
    }
	
	public static int calculateMaxArea(int height, int width, int maxArea) {
		
		int tempArea = height*width;
		if(tempArea>maxArea) {
			maxArea = tempArea;
		}
		return maxArea;
	}

	
}
