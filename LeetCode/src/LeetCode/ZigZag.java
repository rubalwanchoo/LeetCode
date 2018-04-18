package LeetCode;

import java.util.List;
import java.util.ArrayList;

public class ZigZag {

	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
		
		P   A   H   N
		A P L S I I G
		Y   I   R
		And then read line by line: "PAHNAPLSIIGYIR"
		
		Write the code that will take a string and make this conversion given a number of rows:
		
		string convert(string s, int numRows);
		Example 1:
		
		Input: s = "PAYPALISHIRING", numRows = 3
		Output: "PAHNAPLSIIGYIR"
		Example 2:
		
		Input: s = "PAYPALISHIRING", numRows = 4
		Output: "PINALSIGYAHRPI"
		Explanation:
		
		P     I    N
		A   L S  I G
		Y A   H R
		P     I
			 
	 */
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(convert("ABC",1));
		//System.out.println(convert("PAYPALISHIRING",4));

	}
	
	
	public static String convert(String s, int numRows) {
		
		String resultString = "";
		int row = -1;
		
		boolean down = true;
		//System.out.println("down");
		
		
		if(numRows == 1) {
			return s;
		}
		
		List<List<String>> grid = new ArrayList<List<String>>(numRows);
		
		
		for(int i = 0;i<numRows;i++) {
			grid.add(new ArrayList<String>());
		}
		
		for(int i = 0;i<s.length();i++){
			String currChar = String.valueOf(s.charAt(i));
			
			if(down) {
				
				row++;
				
				grid.get(row).add(currChar);
				//System.out.println(currChar+" at "+row);
				
				if(row == numRows-1) {
					down = false;
					//System.out.println("across");

				}
				
				
			}
			else if (!down) {
				
				row--;
				grid.get(row).add(currChar);
				//System.out.println(currChar+" at "+row);
				
				
				if(row==0) {
					down=true;
					//System.out.println("down");
				}
			}

			
			
		}
		
		
		for(int i = 0;i<numRows;i++) {
			for(String j:grid.get(i)) {
				resultString+=j;
			}
		}
		
		return resultString;
        
    }

}
