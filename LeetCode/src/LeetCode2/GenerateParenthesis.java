package LeetCode2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {
	
	public static List<String> retList = new ArrayList<>();
	
	/*
	 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

		For example, given n = 3, a solution set is:
		
		[
		  "((()))",
		  "(()())",
		  "(())()",
		  "()(())",
		  "()()()"
		]
	 */

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		
	}
	
	
	public static List<String> generateParenthesis(int n) {
		
		createParenString("(",n-1,n);
		
		return retList;
    }
	
	
	public static void createParenString (String inStr, int leftRem,int rightRem) {
		
		
		
		if(leftRem==0 && rightRem==0) {
			System.out.println(inStr);
			retList.add(inStr);
		}else if (rightRem>=leftRem) {
			if(leftRem>0) createParenString(inStr+"(",leftRem-1,rightRem);
			if(rightRem>0) createParenString(inStr+")",leftRem,rightRem-1);
		}
		
		
		
	}
	
	
}
