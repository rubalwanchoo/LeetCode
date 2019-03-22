package LeetCode2;

import java.util.*;

public class WordSearch {
	
	/*
	Given a 2D board and a word, find if the word exists in the grid.

	The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

	Example:

	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]

	Given word = "ABCCED", return true.
	Given word = "SEE", return true.
	Given word = "ABCB", return false.
	
	*/
	
	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		
		
		System.out.println(exist(board,"ABCB"));
		

	}
	
	 public static boolean exist(char[][] board, String word) {
	        
		 boolean exists = false;
		 Set<String> visited = new HashSet<>();
		 
		 
		 for(int i=0;i<board.length;i++) {
			 
			 for(int j =0;j<board[0].length;j++) {
				 
				 if(board[i][j]==word.charAt(0)) {
					 
					 System.out.println("starting idx found at row "+i+" col "+j);
					 
					 visited.add(""+i+""+j);
					exists = exists||dfs(board,word.substring(1,word.length()),visited,i,j);
					
					if(!exists) visited.remove(""+i+""+j);
					
					if(exists) break;
				 }
				 
			 }//end for
		 }//end for
		 
		 return exists;
	 }
	 
	 public static boolean dfs(char[][] board, String word, Set<String> visited, int row, int col) {
		 
		 System.out.println("searching word "+word);
		 System.out.println("visitedSet "+visited);
		 //System.out.println("at row "+row+" col "+col);
		 
		 if(word.equals("")) return true;
		 

		 boolean exists = false;
		 Set<String> lVisited = visited;
	
		 
		 if(col-1>=0 && !visited.contains(""+row+""+(col-1)) && board[row][col-1]==word.charAt(0)) {//Left col
			 
			 System.out.println("going to left col");
			 lVisited.add(""+row+""+(col-1));
			 exists = exists||dfs(board,word.substring(1, word.length()),lVisited,row,col-1);
			 
			 if(!exists) lVisited.remove(""+row+""+(col-1));
			 else return true;
		 }
		 if(col+1<board[row].length && !visited.contains(""+row+""+(col+1)) && board[row][col+1]==word.charAt(0)) {//Right col
			 
			 System.out.println("going to right col");
			 lVisited.add(""+row+""+(col+1));
			 exists = exists||dfs(board,word.substring(1, word.length()),lVisited,row,col+1);
			 
			 if(!exists) lVisited.remove(""+row+""+(col+1));
			 else return true;
		 }
		 if(row-1>=0 && !visited.contains(""+(row-1)+""+col) && board[row-1][col]==word.charAt(0)) {//Left row
			 
			 System.out.println("going to upper row");
			 lVisited.add(""+(row-1)+""+col);
			 exists = exists||dfs(board,word.substring(1, word.length()),lVisited,row-1,col);
			 
			 if(!exists) lVisited.remove(""+(row-1)+""+col);
			 else return true;
		 }
		 if(row+1<board.length && !visited.contains(""+(row+1)+""+col) && board[row+1][col]==word.charAt(0)) {//Right row
			 
			 System.out.println("going to down row");
			 lVisited.add(""+(row+1)+""+col);
			 exists = exists||dfs(board,word.substring(1, word.length()),lVisited,row+1,col);
			 
			 if(!exists) lVisited.remove(""+(row+1)+""+col);
			 else return true;
		 }
		 
		 
		 return exists;
	 }

}
