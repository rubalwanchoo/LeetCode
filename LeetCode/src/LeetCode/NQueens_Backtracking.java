package LeetCode;

import java.util.List;
import java.util.ArrayList;


public class NQueens_Backtracking {

	/*	https://leetcode.com/problems/n-queens/description
	
	 	Given an integer n, return all distinct solutions to the n-queens puzzle.
		Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' 
		both indicate a queen and an empty space respectively.
		
		Example:

		Input: 4
		Output: [
		 [".Q..",  // Solution 1
		  "...Q",
		  "Q...",
		  "..Q."],
		
		 ["..Q.",  // Solution 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]
		Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.

	 */
	
	static List<List<String>> nQueens;
	
	public static void main(String args[]){
		nQueens = new ArrayList<List<String>>();	
		
	}
	
	public static List<List<String>> solveNQueens(int n) {
        
		
		int i = 0;
		while(i<n){//run for all queens/columns
			
			placeQueen(i,0);
			
		}
		
    }
	
	public static boolean placeQueen(int column, int row){
		List<String> rowList = new ArrayList<String>();
		
	}
}
