package LeetCode;

//Solution below DOES NOT WORK, need to get new knowledge on Dynamic Programming to solve this
public class RegeexMatching_Deprecated {
	
	/*
	 	Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

		'.' Matches any single character.
		'*' Matches zero or more of the preceding element.
		The matching should cover the entire input string (not partial).
		
		Note:
		
		s could be empty and contains only lowercase letters a-z.
		p could be empty and contains only lowercase letters a-z, and characters like . or *.
		Example 1:
		
		Input:
		s = "aa"
		p = "a"
		Output: false
		Explanation: "a" does not match the entire string "aa".
		Example 2:
		
		Input:
		s = "aa"
		p = "a*"
		Output: true
		Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
		Example 3:
		
		Input:
		s = "ab"
		p = ".*"
		Output: true
		Explanation: ".*" means "zero or more (*) of any character (.)".
		Example 4:
		
		Input:
		s = "aab"
		p = "c*a*b"
		Output: true
		Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
		Example 5:
		
		Input:
		s = "mississippi"
		p = "mis*is*p*."
		Output: false
	 */

	public static void main(String[] args) {
		System.out.println(isMatch("aaa","ab*a*c*a"));

	}
	
	public static boolean isMatch(String s, String p) {
        boolean resp = true;
        int[][] grid = new int[p.length()][s.length()];
        boolean[] columnOccupied = new boolean[s.length()];
        boolean[] rowOccupied = new boolean[p.length()];
        
        boolean[] rowsMarked = new boolean[p.length()];
        boolean[] columnsMarked = new boolean[s.length()];
        
        
        
        if(s.length()!=p.length() && !p.contains(".") && !p.contains("*")) {
        		return false;
        }
        
        int i=0;//Index for p chars
        int j=0;//Index for s chars
        
        while(i<p.length()) {//Complete all chars for pattern
        		System.out.println("--------------------------");
        		System.out.println("Evaluating row "+i);
	        	j=0;
	        	
	        	
	        	String pCurrChar = String.valueOf(p.charAt(i));
	        	String pPrevChar = i<=0?"":String.valueOf(p.charAt(i-1));
	        	
	        
	        	rowOccupied[i] = false;
	        
	        	
	        	
	        	while(j<s.length()) {//Complete all chars in string
	        		
	        		
		        	String sCurrChar = String.valueOf(s.charAt(j));
		        	String sPrevChar = j<=0?"":String.valueOf(s.charAt(j-1));
	        		
	        		System.out.println("Evaluating i-"+i+",j-"+j+",sCurrChar -"+sCurrChar+",pCurrChar-"+pCurrChar);
	        		
	        		if(!rowOccupied[i] && !columnOccupied[j]) {
	        			
	        			if(sCurrChar.equals(pCurrChar)) {
	        				System.out.println("condition1");
	            			grid[i][j] = 1;
	            			rowOccupied[i] = true;
	            			
	            			columnOccupied[j] = true;
	            			
	            			rowsMarked[i] = true;
	            			columnsMarked[j] = true;
	            			

	            			
	            		} 
	        			//-----------------------------------------------
	        			else if(!sCurrChar.equals(pCurrChar) ) {
	        				
	        				if(pCurrChar.equals(".")) {
	        					System.out.println("condition2");
	        					grid[i][j] = 1;
	        					rowOccupied[i] = true;
	        					columnOccupied[j] = true;
	        					
	        					rowsMarked[i] = true;
		            			columnsMarked[j] = true;
	        					
	        				}
	        				
	        				if (pCurrChar.equals("*") && (pPrevChar.equals(sCurrChar)||pPrevChar.equals("."))){
	        					System.out.println("condition3");
	        					grid[i][j] = 1;
	        					rowOccupied[i] = false;
	                			
	                			if(grid[i][j-1]!=1) {
	                				columnOccupied[j] = true;
	                			}
	                			else {
	                				columnOccupied[j] = false;
	                			}
	        					
	                			
	                			rowsMarked[i] = true;
		            			columnsMarked[j] = true;
	        				}
	        				
	        				if (pCurrChar.equals("*") && !(pPrevChar.equals(sCurrChar)||pPrevChar.equals("."))){
	        					System.out.println("condition4");
	        					grid[i][j] = 0;
	        					rowOccupied[i] = true;
	                			
	                			columnOccupied[j] = false;
	                			
	                			
	        				}
	        				
	        				
	        				
	        			}
	        			//-----------------------------------------------
	        				
	        		}
	        		else{
	        			System.out.println("condition5");
	        			grid[i][j] = 0;
	        		}
	        			
	        		System.out.println("Result-"+grid[i][j]);
	        		j++;
	        	}//end j loop
	        	
	        	i++;
	        	
        }//end i loop
        
        	
        display2DGrid(grid);
        
        boolean rowsMarkedTrue = false;
        boolean rowsMarkedFalse = false;
        
        resp = true;
        
        for(int k=0;k<s.length();k++) {//evaluating columns
	    		if(!columnsMarked[k]) {
	    			resp = false;
	    			break;
	    		}
	    }
        
        
        for(int k=p.length()-1;k>=0;k--) {//evaluating rows, start from last row, must see all 1's until see 0, after that should not see anymore 1
        		
        	String pCurrChar = String.valueOf(p.charAt(k));
        	String pNextChar = (k+1)<p.length()?String.valueOf(p.charAt(k+1)):"";
        	
	        	if(!(pCurrChar.equals("*")) &&(!(pNextChar).equals("*")) ) {
	        		System.out.println("evaluation patter row k-"+k+" with value- "+String.valueOf(p.charAt(k)));
	        		
	        		if(!rowsMarked[k] && !rowsMarkedTrue) {
	        			resp = false;
	        			break;
	        		}
	        		if(rowsMarked[k] && !rowsMarkedTrue) {
	        			rowsMarkedTrue = true;
	        		}
	        		if(!rowsMarked[k] && !rowsMarkedFalse) {
	        			rowsMarkedFalse = true;
	        		}
	        		if(rowsMarkedFalse && rowsMarked[k]) {
	        			resp = false;
	        			break;
	        		}
	        	
	        	}
        		
        }
        
        
        
        

        
        return resp;
    }
	
	

	
	
	
	public static void display2DGrid(int[][] grid) {
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println("");
		}
	}

}
