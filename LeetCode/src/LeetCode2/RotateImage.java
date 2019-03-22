package LeetCode2;

public class RotateImage {
	
	//https://leetcode.com/problems/rotate-image/

	public static void main(String[] args) {
		rotate(new int[][] {
			{5,1,9,11},
			{2,4,8,10},
			{13,3,6,7},
			{15,14,12,16}
		});

	}
	
	
	public static void rotate(int[][] matrix) {
		
		int layer = 0;
		
		while(layer<=matrix.length/2) {
			
			int startIdx = layer;
			int endIdx = matrix[0].length-layer-1;
			System.out.println("startIdx "+startIdx+" endIdx "+endIdx);
			
			int iter = 0;
			while(startIdx+iter<endIdx && startIdx<endIdx) {
				
				System.out.println();
				
				//First transition
				int temp1 = matrix[startIdx+iter][endIdx];
				matrix[startIdx+iter][endIdx] = matrix[startIdx][startIdx+iter];
				System.out.println("t1 from "+startIdx+","+(startIdx+iter)+" to "+(startIdx+iter)+","+endIdx);
				
				//Second transition
				int temp2 = matrix[endIdx][endIdx-iter];
				matrix[endIdx][endIdx-iter] = temp1;
				System.out.println("t2 from "+(startIdx+iter)+","+endIdx+" to "+endIdx+","+(endIdx-iter));
				
				//Third transition
				temp1 = matrix[endIdx-iter][startIdx];
				matrix[endIdx-iter][startIdx] = temp2;
				System.out.println("t3 from "+endIdx+","+(endIdx-iter)+" to "+(endIdx-iter)+","+startIdx);
				
				//Fourth transition
				matrix[startIdx][startIdx+iter] = temp1;
				System.out.println("t4 from "+(endIdx-iter)+","+startIdx+" to "+startIdx+","+(startIdx+iter));
				
				
				iter++;
				
			}//end while
			
								
			layer++;
			
		}//end while
		
		print2DArray(matrix);
		
    }
	
	public static void print2DArray(int[][] matrix) {
		
		System.out.println();
		
		for(int row=0;row<matrix.length;row++) {
			for(int col=0;col<matrix[0].length;col++) {
				System.out.print(matrix[row][col]+"  ");
			}
			
			System.out.println();
		}
	}
	
	
}
