package LeetCode2;

import java.util.Arrays;

public class RotateArrayKRight {

	public static void main(String[] args) {
		//rotate(new int[] {1,2,3,4,5,6},2);
		//rotate(new int[] {1,2},2);
		//rotate(new int[] {1,2,3},2);c
		rotate(new int[] {-1},2);
		//rotate(new int[] {1,2,3,4,5,6,7},3);

	}
	
	public static void rotate(int[] nums, int k) {
        
        int count = 0;
        int currIdx = 0;
        int nextIdx = 0;
        
        for(int startIdx = 0;count<nums.length;startIdx++) {
        	
        	currIdx = startIdx;
        	
        	int temp = 0;
        	int temp1 = 0;
        	do {
        		nextIdx = (currIdx+k) % nums.length;
        		
        		if(currIdx==startIdx) {
        			temp = nums[nextIdx];
        			nums[nextIdx] = nums[currIdx];
        		}
        		else {
        			temp1 = temp;
        			temp = nums[nextIdx];
        			nums[nextIdx] = temp1;
        		}
        		
        		       		
        		
        		currIdx = (currIdx+k) % nums.length;
        		count++;
        		
        	}while(currIdx!=startIdx);
        	
        	
        	
        }//end for
		
		Arrays.toString(nums);
    }	

}
