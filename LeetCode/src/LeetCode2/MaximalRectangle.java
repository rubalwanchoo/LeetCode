package LeetCode2;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    
    public static void main(String args[]){
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'},
        };
        
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(char[][] matrix) {
    	
    	if(matrix.length==0) return 0;
        
    	int[] myArr = new int[matrix[0].length];
    	
    	int maxArea = 0;
    	
        for(int row = 0;row<matrix.length;row++) {
        	for(int col = 0;col<matrix[0].length;col++) {
        		
        		if(matrix[row][col]=='0')
        			myArr[col] = Character.getNumericValue(matrix[row][col]);
        		
        		if(matrix[row][col]=='1')
        			myArr[col] += Character.getNumericValue(matrix[row][col]);
        	}
        	
        	System.out.println("myArr -"+Arrays.toString(myArr));
        	
        	maxArea = Math.max(maxArea, maxAreaRectInHistogram(myArr));
        }//end for
        
        
        return maxArea;
    }
    
    
    
    public static int maxAreaRectInHistogram(int[] heights) {
    	
    	Stack<Integer> pStack = new Stack<>();
    	Stack<Integer> hStack = new Stack<>();
    	
    	int maxSize = 0;
    	
    	for(int i = 0;i<heights.length;i++) {
    		
    		if(i==0 || heights[i]>hStack.peek()) {
    			pStack.add(i);
    			hStack.add(heights[i]);
    		}
    		else if (heights[i]<hStack.peek()) {
    			int temp = -1;
    			
    			while(!hStack.isEmpty() && heights[i]<hStack.peek()) {
    				temp = pStack.peek();
    				maxSize = Math.max(maxSize,hStack.pop()*(i-pStack.pop()));
    				
    			}//end while
    			
    			
    			hStack.add(heights[i]);
    			pStack.add(temp);
    				
    		}	
    	}//end for
    	
		
		while(!hStack.isEmpty()) {
			maxSize = Math.max(maxSize,hStack.pop()*(heights.length-pStack.pop()));
		}//end while
		
		
    	return maxSize;
    }
    
    public static void print2DArray(int[][] matrix){
        for(int row =0;row<matrix.length;row++){
            for(int col = 0;col<matrix[0].length;col++){
                System.out.print(matrix[row][col]+" ");
            }
            
            System.out.println();
        }
    }
}



