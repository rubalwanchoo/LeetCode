	package LeetCode.Amazon;

public class TIcTacToe {
	
	static int[] p1Row;
	static int[] p1Col;
	static int[] p1Diag;

	static int[] p2Row;
	static int[] p2Col;
	static int[] p2Diag;

	public static void main(String[] args) {
		int n = 2;
		
		TicTacToe(n);
		System.out.println(move(0, 1, 1)); 
		System.out.println(move(1, 1, 2)); 
		System.out.println(move(1, 0, 1)); 
		 

	}
	
	/** Initialize your data structure here. */
    public static void TicTacToe(int n) {
        
        p1Row = new int[n];
        p1Col = new int[n];
        p1Diag = new int[2];
        
        p2Row = new int[n];
        p2Col = new int[n];
        p2Diag = new int[2];
        
        p1Diag[0] = 0;p1Diag[1] = 0;
        p2Diag[0] = 0;p2Diag[1] = 0;
        
        for(int i = 0;i<n;i++) {
        	p1Row[i] = 0;
        	p1Col[i] = 0;
        	p2Row[i] = 0;
        	p2Col[i] = 0;
        }
        
        
        
    }
    
    /* Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
            0: No one wins.
            1: Player 1 wins.
            2: Player 2 wins. */
	public static int move(int row, int col, int player) {
		int res = 0;
		int n = p1Row.length;
		//System.out.println("n "+n);
		
		if(player == 1) {//p1
			
			p1Row[row]++;
			p1Col[col]++;
			
			if(row==col) p1Diag[0]++;
			if(row==n-col-1) p1Diag[1]++;
			
		}
		if(player==2){//p2
			
			p2Row[row]++;
			p2Col[col]++;
			
			if(row==col) p2Diag[0]++;
			if(row==n-col-1) p2Diag[1]++;
			
		}
		
		
		//Check for results after the move is placed
		
		//Check the diagonals
		if(p1Diag[0]==n || p1Diag[1]==n) return 1;
		if(p2Diag[0]==n || p2Diag[1]==n) return 2;
		
		//Check rows
		for(int i = 0;i<n;i++) {
			
			if(p1Row[i]==n) {
				res = 1;
				break;
			}
			if(p2Row[i]==n) {
				res = 2;
				break;
			}
			if(p1Col[i]==n) {
				res = 1;
				break;
			}
			if(p2Col[i]==n) {
				res = 2;
				break;
			}
		}
		
		
		return res;
		
	}
	

/*
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

}
