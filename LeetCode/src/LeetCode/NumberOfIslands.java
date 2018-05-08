package LeetCode;

public class NumberOfIslands {
	
	
	/* https://www.youtube.com/watch?v=CGMNePwovA0
	 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
	 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
	 You may assume all four edges of the grid are all surrounded by water.

	 */
	
	static boolean[][] isVisited;
	
	public static void main(String args[]) {
		//System.out.println(numIslands(new char[][] {{'1','0','1','0','1'},{'1','1','0','0','0'},{'0','1','0','1','1'}}));
		//System.out.println(numIslands(new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
		System.out.println(numIslands(new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
	}
	
	public static int numIslands(char[][] grid) {
		
		if(grid.length == 0) {
			return 0;
		}
		
        int clusters = 0;
        isVisited = new boolean[grid.length][grid[0].length];
        
        //Initialize the boolean grid with F
        for(int i = 0;i<grid.length;i++) {
        	for(int j=0;j<grid[i].length;j++) {
        		isVisited[i][j] = false;
        	}
        }
        
        
        
        for(int i = 0;i<grid.length;i++) {
        	for(int j=0;j<grid[i].length;j++) {
        		
        		if(grid[i][j]=='1') {
        			
        			if(!isVisited[i][j]) {
        				visit(i,j,grid);
        				System.out.println("incrementing cluster");
            			clusters++;
        			}

        		}

        	}//end loop j
        }//end loop i

        return clusters;
    }
	
	
	public static void visit(int row, int column, char[][] grid) {

		if(row>=0 && row<grid.length && column>=0 && column<grid[0].length) {
			
			if(isVisited[row][column]) return;
			
			System.out.println("visiting row "+row+",column "+column);
			isVisited[row][column] = true;
			
			//if(row>0 && column>0 && grid[row-1][column-1]=='1') visit(row-1,column-1,grid); //topleft
			if(column>0 && grid[row][column-1]=='1') visit(row,column-1,grid); //left
			//if(row<grid.length-1 && column>0 && grid[row+1][column-1]=='1') visit(row+1,column-1,grid); //bottomleft
			if(row<grid.length-1 && grid[row+1][column]=='1') visit(row+1,column,grid); //bottom
			//if(row<grid.length-1 && column<grid[0].length-1 && grid[row+1][column+1]=='1') visit(row+1,column+1,grid); //bottomright
			if(column<grid[0].length-1 && grid[row][column+1]=='1') visit(row,column+1,grid); //right
			//if(row>0 && column<grid[0].length-1 && grid[row-1][column+1]=='1') visit(row-1,column+1,grid); //topright
			if(row>0 && grid[row-1][column]=='1') visit(row-1,column,grid); //top
		}

	}
	
}
