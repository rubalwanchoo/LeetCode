package LeetCode.Amazon;

import java.util.Arrays;

public class ProductArrayExceptSelf {

	/*
	Product of Array Except Self
	Go to Discuss
	Given an array nums of n integers where n > 1,  
	return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
	
	Example:
	
	Input:  [1,2,3,4]
	Output: [24,12,8,6]
	Note: Please solve it without division and in O(n).
	
	Follow up:
	Could you solve it with constant space complexity? 
	(The output array does not count as extra space for the purpose of space complexity analysis.)
	 */
	
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));

	}
	
	public static int[] productExceptSelf(int[] nums) {
	    int[] outputArr = new int[nums.length];
	    
	    
	    //move from left
	    int leftProd = 1;
	    for(int i=0;i<outputArr.length;i++) {
	    	
	    	leftProd = leftProd * ((i-1<0)?1:nums[i-1]);
	    	outputArr[i] = leftProd;
	    	//System.out.println(outputArr[i] +" at "+ i);
	    }
	    //[1,1,2,6]
	    
	    //move from right
	    int rightProd = 1;
	    for(int j=nums.length-1;j>-1;j--) {
	    	rightProd = rightProd * ((j+1>=nums.length)?1:nums[j+1]);
	    	outputArr[j] = outputArr[j] * rightProd;
	    	//System.out.println(outputArr[j] +" at "+ j);
	    }
	    
	    
	    
	    return outputArr;
	    
    }

}
