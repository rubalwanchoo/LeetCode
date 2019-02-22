package LeetCode2;

import java.util.Arrays;

public class MinPathSum {
	
	/*
	Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right 
	which minimizes the sum of all numbers along its path.

	Note: You can only move either down or right at any point in time.

	Example:

	Input:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	Output: 7
	Explanation: Because the path 1→3→1→1→1 minimizes the sum.
	
	*/

	static int globalMin = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,9,1},{4,2,1}};
		//int[][] grid = {{1}};
		
		
		System.out.println(minPathSum(grid));

	}
	
	public static int minPathSum(int[][] grid) {
		
		//calPathSum(grid,0,0,0);
		int[][] dpGrid = new int[grid.length][grid[0].length];
		
		
		for(int row = 0;row<grid.length;row++)
		{
			for(int col = 0;col<grid[0].length;col++) {
				
				int x = 0;
				
				if(row ==0 && col==0) x=0;
				else if(row >0 && col==0) x = dpGrid[row-1][col];
				else if(row==0 && col>0) x = dpGrid[row][col-1];
				else x = Math.min(dpGrid[row-1][col], dpGrid[row][col-1]);
				
				
				dpGrid[row][col] = grid[row][col] + x;
			}
		}
        
		//return globalMin;
		
		print2DArray(dpGrid);
		return dpGrid[dpGrid.length-1][dpGrid[0].length-1];
    }
	
	
	
	public static void print2DArray(int[][] grid) {
		
		
		for(int row = 0;row<grid.length;row++)
		{
			for(int col = 0;col<grid[0].length;col++) {
				
				System.out.print(grid[row][col]+" ");
			}
			System.out.println();
		}
        
	}
	
	
	public static void calPathSum(int[][] grid, int row, int col, int sum) {
		
		System.out.println("row -"+row+" col-"+col+" value-"+grid[row][col]);
		
		if(globalMin!=Integer.MAX_VALUE && (sum+grid[row][col])>globalMin) {//no need to go further
			System.out.println("returning from 1");
			return;
		}
		
		
		
		
		if(row==grid.length-1 && col==grid[0].length-1) {//exit condition
			globalMin = Math.min(globalMin, sum+grid[row][col]);
			System.out.println("setting global min as "+globalMin);
		}
				
		
		if(row+1<grid.length) {//bottom row exists
			calPathSum(grid,row+1,col,sum+grid[row][col]);
		}
		
		if(col+1<grid[0].length) {//go right
			calPathSum(grid,row,col+1,sum+grid[row][col]);
		}
	}

}
