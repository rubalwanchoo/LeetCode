package LeetCode2;

import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
	
	/*
	 	Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

		Each row must contain the digits 1-9 without repetition.
		Each column must contain the digits 1-9 without repetition.
		Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
		
		Input:
		[
		  ["5","3",".",".","7",".",".",".","."],
		  ["6",".",".","1","9","5",".",".","."],
		  [".","9","8",".",".",".",".","6","."],
		  ["8",".",".",".","6",".",".",".","3"],
		  ["4",".",".","8",".","3",".",".","1"],
		  ["7",".",".",".","2",".",".",".","6"],
		  [".","6",".",".",".",".","2","8","."],
		  [".",".",".","4","1","9",".",".","5"],
		  [".",".",".",".","8",".",".","7","9"]
		]
		Output: true
	 */
	
	public static Set<Integer> validRows= new HashSet<>();
	public static Set<Integer> validCols= new HashSet<>();
	public static Set<String> validBoxes= new HashSet<>();

	public static void main(String[] args) {
		char[][] board = {
							{'5','3','.','.','7','.','.','.','.'},
							{'6','.','.','1','9','5','.','.','.'},
							{'.','9','8','.','.','.','.','6','.'},
							{'8','.','.','.','6','.','.','.','3'},
							{'4','.','.','8','.','3','.','.','1'},
							{'7','.','.','.','2','.','.','.','6'},
							{'.','6','.','.','.','.','2','8','.'},
							{'.','.','.','4','1','6','.','.','5'},
							{'.','.','.','.','8','.','.','7','9'}
		        		 };

		
		System.out.println(isValidSudoku(board));
	}
	
	
	public static boolean isValidSudoku(char[][] board) {
		
		boolean resp = true;
		
		//Iterate through each available integer
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				
				if(board[i][j]=='.') continue;
				else {
					System.out.println("Evaluatin row "+i+" col "+j);
					resp = isCurrentRowValid(board,i) && isCurrentColumnValid(board,j) && isCurrentBoxValid (board,i,j);
				}
					 
				
				
				if(!resp) return false;
				
				
			}//end for j
		}//end for i
		
		return true;
    }
	
	
	public static boolean isCurrentRowValid(char[][] board,int row) {
		
		if(validRows.contains(row)) return true;
		
		Set<Integer> visited = new HashSet<>();
		
		for(int i=0;i<9;i++) {
			
			if(board[row][i]=='.') continue;
			
			if(visited.contains(Integer.valueOf(board[row][i]))) {
				System.out.println("isCurrentRowValid "+row+" false");
				return false;
			}
			else
				visited.add(Integer.valueOf(board[row][i]));
			
		}//end for
		
		System.out.println("isCurrentRowValid "+row+" true");
		validRows.add(row);
		return true;
	}
	
	public static boolean isCurrentColumnValid(char[][] board,int col) {
		
		if(validCols.contains(col)) return true;
		
		Set<Integer> visited = new HashSet<>();
		
		for(int i=0;i<9;i++) {
			
			if(board[i][col]=='.') continue;
			
			if(visited.contains(Integer.valueOf(board[i][col]))) {
				System.out.println("isCurrentColumnValid "+col+" false");
				return false;
			}
			else
				visited.add(Integer.valueOf(board[i][col]));
			
		}//end for
		
		System.out.println("isCurrentColumnValid "+col+" true");
		validCols.add(col);
		return true;
	}

	public static boolean isCurrentBoxValid(char[][] board,int row,int col) {
		
		int rowMin = row - row%3;
		int colMin = col - col%3;
		
		if(validBoxes.contains(""+rowMin+colMin)) return true;
		
		Set<Integer> visited = new HashSet<>();
		
		for(int i = rowMin;i<rowMin+3;i++) {
			for(int j = colMin;j<colMin+3;j++) {
				
				if(board[i][j]=='.') continue;
				
				if(visited.contains(Integer.valueOf(board[i][j]))) {
					System.out.println("isCurrentBoxValid "+row+" row "+col+" col "+" false");
					return false;
				}
				else
					visited.add(Integer.valueOf(board[i][j]));
			}//end for j
		}//end for i
		
		System.out.println("isCurrentBoxValid "+row+" row "+col+" col "+" true");
		validBoxes.add(""+rowMin+colMin);
		return true;
		
	}

}
