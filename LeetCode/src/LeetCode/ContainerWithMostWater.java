package LeetCode;

import java.util.Stack; 

public class ContainerWithMostWater {
	/*
	 	Given n non-negative integers a1, a2, ..., an, where each represents a point 
	 	at coordinate (i, ai). n vertical lines are drawn such that the two endpoints 
	 	of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
	 	such that the container contains the most water.

		Note: You may not slant the container and n is at least 2.

	 */
	
	public static void main(String args[]) {
		System.out.println(maxArea(new int[] {2,3,5,7,6,4}));//12
		System.out.println(maxArea(new int[] {2,3,4,5,6}));//9
		System.out.println(maxArea(new int[] {1,1}));//1
		System.out.println(maxArea(new int[] {2,1}));//1
		System.out.println(maxArea(new int[] {3,2,1,3}));//9
	}
	
	
	public static int maxArea(int[] height) {
        int maxArea = 0;
		
        Stack<Integer> pStack = new Stack<Integer>();
        
        
        int i = 0;
        while(i<height.length) {
        	
        	
        	if(pStack.isEmpty() || height[i]>=height[pStack.peek()]) {
        		pStack.push(i);
        		i++;
        	}else {
        		
        		while(!pStack.isEmpty() && height[i]<height[pStack.peek()]) {
        			
        			maxArea = calculateMaxArea(height[i],i-pStack.peek(),maxArea);
            		pStack.pop();
            		
        		}
        		
        		
        		
        		if(pStack.isEmpty()) {
        			break;
        		}
        	}
        	
        }//end while
        
        i--;
        
        while(!pStack.isEmpty()) {
        	pStack.pop();
        	
        	if(!pStack.isEmpty()) {
        		maxArea = calculateMaxArea(height[pStack.peek()],i-pStack.peek(),maxArea);
        	}
        	
        }
        
        
        return maxArea;
    }
	

	
	
	public static int calculateMaxArea(int height, int width, int maxArea) {
		
		return height*width>maxArea?height*width:maxArea;
	}

}
