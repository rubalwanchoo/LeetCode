package LeetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


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
	static String[][] nQueensArray;
	
	
	public static void main(String args[]){
		int n = 5;
		
		System.out.println(solveNQueens(n));
	}
	
	
	public static List<List<String>> solveNQueens(int n) {
		nQueens = new ArrayList<List<String>>();//Globally declared nQueens ArrayList
		nQueensArray = new String[n][n];
		
		
		int i = 0;
		while(i<n) {
			
			resetQueenArray();
			nQueensArray[0][i] = "Q"; //Push Queen to row,column
			if(placeQueen(1,n)) {
				//displayArray(nQueensArray);
				
				nQueens = addToList(nQueens,nQueensArray);
				
			}
			i++;
			
		}
		
		return nQueens;
		
    }
	
	
	
	public static boolean placeQueen(int row,int n){
		//System.out.println("placeQueen row-"+row);
		
		int column = 0;
		
	
		while(column<n) {//loop for each row
			
			//System.out.println("row-"+row+"column-"+column);
			if(row == n) {
				return true;
			}
			
			nQueensArray[row][column] = "Q";
			
			if(isQueenSafe(row,column) && placeQueen(row+1,n)) {
		
				return true;
			}
			

			nQueensArray[row][column] = "."; //Pop Queen from row,column
			
			column++;
			//System.out.println("column++-"+column);
			
		}//end while
		
		//System.out.println("backtracking");
		return false;
		
	}
	
	
	
	public static boolean isQueenSafe(int row, int column) {
		
		for(int i=0;i<row;i++) {//loop for row
			for(int j=0;j<nQueensArray[i].length;j++) {//loop for column, j loop could run till n also
				
				if(nQueensArray[i][j].equals("Q") && (j==column||Math.abs(column-j)==Math.abs(row-i))) {
					//System.out.println("Queen Safe false");
					return false;
				}
				
			}
		}
		
		//System.out.println("Queen Safe true");
		return true;
	}
	
	public static void displayArray(String[][] array) {
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	public static void resetQueenArray() {
		for(int i=0;i<nQueensArray.length;i++) {
			for(int j=0;j<nQueensArray[i].length;j++) {
				nQueensArray[i][j] = ".";
			}
			
		}
	}
	
	public static List<List<String>> addToList(List<List<String>> nQueens,String[][] nQueensArray) {
		
		String listItem = ""; 
		List<String> queenRow = new ArrayList<String>();
		
		for(int i=0;i<nQueensArray.length;i++) {
			listItem = "";
			for(int j=0;j<nQueensArray[i].length;j++) {
				listItem+=nQueensArray[i][j];
			}
			listItem+="\n";
			queenRow.add(listItem);
			
		}
		
		nQueens.add(queenRow);
		
		
		
		return nQueens;
	}
}
