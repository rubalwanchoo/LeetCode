package LeetCode2;

public class Search2DMatrix2 {
	
	/*
	Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

		Integers in each row are sorted in ascending from left to right.
		Integers in each column are sorted in ascending from top to bottom.
		Example:

		Consider the following matrix:

		[
		  [1,   4,  7, 11, 15],
		  [2,   5,  8, 12, 19],
		  [3,   6,  9, 16, 22],
		  [10, 13, 14, 17, 24],
		  [18, 21, 23, 26, 30]
		]
		Given target = 5, return true.

		Given target = 20, return false.
	*/


	public static void main(String[] args) {
		
		//int matrix[][] = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int matrix[][] = {{}};
		System.out.println(searchMatrix(matrix,-10));

	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		
		
		
        int row = 0;
        int col = matrix.length>0 && matrix[0].length>0?matrix[0].length-1:0;
        
        System.out.println("starting row-"+row+" col-"+col);
        
        while(col>-1 && row<matrix.length) {
        	
        	if(matrix[row].length==0) return false;
        	
        	System.out.println("c1 evaluating row-"+row+" col-"+col+" value-"+matrix[row][col]);
        	
        	if(matrix[row][col]==target) {
        		return true;
        	}
        	
        	if(target<matrix[row][col]) {
        		col--;
        	}
        	else if(target>matrix[row][col]) {
        		row++;
        	}
        	
  
        }
        
        return false;
    }

}
