package LeetCode.fb;

import java.util.Iterator;
import java.util.Stack;



public class TrappingRainWater {

	
	/*
	 Trapping Rain Water
	  	Go to Discuss
		Given n non-negative integers representing an elevation map where the width of each bar is 1, 
		compute how much water it is able to trap after raining.
		
		The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
		In this case, 6 units of rain water (blue section) are being trapped. 
		
		
		Example:
		
		Input: [0,1,0,2,1,0,1,3,2,1,2,1]
		Output: 6
	 */
	
	
	public static void main(String[] args) {
		System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
		//System.out.println(trap(new int[] {0}));
		//System.out.println(trap(new int[] {4,2,3}));
	}
	
	public static int trap(int[] height) {
        int trapArea = 0;
        
        int lMax = 0;
        int rMax = 0;
        int left = 0;
        int right = height.length-1;
        
        while(left<right) {
        	
        	if(height[left]>height[right]) {
        		
        		if(height[right]>rMax) {
        			rMax = height[right];
        		}else {
        			trapArea += rMax - height[right];
        		}
        		
        		right--;
        		
        	}else {
        		if(height[left]>lMax) {
        			lMax = height[left];
        		}else {
        			trapArea += lMax - height[left];
        		}
        		
        		left++;
        	}
        }
        
        
        return trapArea;
	}
}
