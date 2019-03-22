package LeetCode2;

public class GameOfLife {
	
	//https://leetcode.com/problems/game-of-life/

	public static void main(String[] args) {
		
		gameOfLife(new int[][] {
			{0,1,0},
			{0,0,1},
			{1,1,1},
			{0,0,0}
			
		});

	}
	
	public static void gameOfLife(int[][] board) {
        
		int[][] board2 = new int[board.length][board[0].length];
		
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[0].length;col++) {
				
				int neighborSum = 0;
				
				//left
				neighborSum += col-1>-1?board[row][col-1]:0;
				
				//right
				neighborSum += col+1<board[0].length?board[row][col+1]:0;
				
				//up
				neighborSum += row-1>-1?board[row-1][col]:0;
				
				//down
				neighborSum += row+1<board.length?board[row+1][col]:0;
				
				//top left
				neighborSum += row-1>-1&&col-1>-1?board[row-1][col-1]:0;
				
				//top right
				neighborSum += row-1>-1&&col+1<board[0].length?board[row-1][col+1]:0;
				
				//bottom left
				neighborSum += row+1<board.length&&col-1>-1?board[row+1][col-1]:0;
				
				//bottom right
				neighborSum += row+1<board.length&&col+1<board[0].length?board[row+1][col+1]:0;
				
				System.out.println("row "+row+" col "+col+" neighborSum "+neighborSum);
				
				if(board[row][col]==0) {
					if(neighborSum==3) board2[row][col] =1;
				}else {
					
					if(neighborSum<2) board2[row][col]=0;
					else if(neighborSum==2||neighborSum==3) board2[row][col]=1;
					else if(neighborSum>3) board2[row][col]=0;
				}
				
			}//end row
		}//end col
		
		
		board =board2;
		print2DArray(board);
    }
	
	public static void print2DArray(int[][] board) {
		
		for(int row=0;row<board.length;row++) {
			
			for(int col = 0;col<board[0].length;col++) {
				System.out.print(board[row][col]+" ");
				
			}//end for
			
			System.out.println();
		}//end for
	}

}
