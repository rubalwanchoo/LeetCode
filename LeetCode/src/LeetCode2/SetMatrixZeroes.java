package LeetCode2;

import java.util.Arrays;

public class SetMatrixZeroes {
	
	/*
	  Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

		Example 1:
		
		Input: 
		[
		  [1,1,1],
		  [1,0,1],
		  [1,1,1]
		]
		Output: 
		[
		  [1,0,1],
		  [0,0,0],
		  [1,0,1]
		]
		Example 2:
		
		Input: 
		[
		  [0,1,2,0],
		  [3,4,5,2],
		  [1,3,1,5]
		]
		Output: 
		[
		  [0,0,0,0],
		  [0,4,5,0],
		  [0,3,1,0]
		]
		Follow up:
		
		A straight forward solution using O(mn) space is probably a bad idea.
		A simple improvement uses O(m + n) space, but still not the best solution.
		Could you devise a constant space solution?
	 */

	public static void main(String[] args) {
		
		setZeroes(new int[][]{{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}});


	}
	
	public static void setZeroes(int[][] matrix) {

        
		//Go through first column, record if there exist any zeroes
		boolean firstColHasZero = false;
		
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				firstColHasZero = true;
				break;
			}
		}//end for
		
		
		//Go through all the other columns, where a zero is found, mark the first column and the current whole column as zero
		boolean colHasZero = false;

		for(int i=1;i<matrix[0].length;i++) {//column
			colHasZero = false;
			for(int j=0;j<matrix.length;j++) {//row
				
				if(matrix[j][i]==0) {
					matrix[j][0] = 0;
					colHasZero = true;
				}
	
			}//end for
			
			if(colHasZero) {
				for(int k=0;k<matrix.length;k++) {
					matrix[k][i] = 0;
				}
				
				
			}
		}
		
		
		//Go through first column, if zero, mark the whole row zero
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]==0) {
				for(int j=0;j<matrix[i].length;j++) {
					matrix[i][j]=0;
				}
			}
		}//end for
		
		//Mark column 1 as zero if firstColHasZero
		if(firstColHasZero) {
			for(int i=0;i<matrix.length;i++) {
				matrix[i][0]=0;
			}
		}
	
		print2DArray(matrix);
    }
	
	public static void print2DArray(int[][] matrix) {
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
