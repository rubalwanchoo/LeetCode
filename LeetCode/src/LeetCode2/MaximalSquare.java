package LeetCode2;

public class MaximalSquare {
	
	/*
	Given a 2D binary matrix filled with 0's and 1's, 
	find the largest square containing only 1's and return its area.

	Example:

	Input: 

	1 0 1 0 0
	1 0 1 1 1
	1 1 1 1 1
	1 0 0 1 0

	Output: 4
	*/
	
	
	public static void main(String[] args) {
		
		char[][] matrix = {
							{'1','1','1','1'},
							{'1','1','1','1'},
							{'1','1','1','1'}
							};
		
		System.out.println(maximalSquare(matrix));

	}
	
	public static int maximalSquare(char[][] matrix) {
		
		if(matrix.length==0) return 0;
		
		
		int[][] matrix1 = new int[matrix.length][matrix[0].length];
		
		int max =0;
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				
				if(i==0 || j==0)
					matrix1[i][j] = Character.getNumericValue(matrix[i][j]);
				else if(matrix[i][j]=='1') 
					matrix1[i][j] = Math.min(Math.min(matrix1[i-1][j-1], matrix1[i][j-1]),matrix1[i-1][j])+1;
				else 
					matrix1[i][j] = Character.getNumericValue(matrix[i][j]);

				
				max = Math.max(matrix1[i][j], max);
				
			}
		}
		
		print2DMatrix(matrix1);
		
		return max*max;
    }
	
	public static void print2DMatrix(int[][] matrix) {
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			
			System.out.println();
		}
	}

}
