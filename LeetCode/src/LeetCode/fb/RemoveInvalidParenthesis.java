package LeetCode.fb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class RemoveInvalidParenthesis {

	
	/*
	 	Remove the minimum number of invalid parentheses in order to make the input string valid. 
	 	Return all possible results.

		Note: The input string may contain letters other than the parentheses ( and ).
		
		Example 1:
		
		Input: "()())()"
		Output: ["()()()", "(())()"]
		Example 2:
		
		Input: "(a)())()"
		Output: ["(a)()()", "(a())()"]
		Example 3:
		
		Input: ")("
		Output: [""]
	 */
	
	
	public static void main(String args[]) {
		
		System.out.println(removeInvalidParentheses("()())()").toString());

	}
	
	
	public static List<String> removeInvalidParentheses(String s) {
		
        Queue<String> q = new LinkedList<>();
		Set<String> isVisited = new HashSet<>();
		List<String> resList = new ArrayList<>();
		
		q.add(s);
		isVisited.add(s);
		boolean found = false;
		
		while(!q.isEmpty()) {
			
			
			String qItem = q.poll();
			System.out.println("checking "+qItem);
			
			if(isValid(qItem)) {
				System.out.println(qItem+" isValid" );
				resList.add(qItem);
				found = true;
				
	
			}
			if(found) continue;//this is to make sure that if parent is found invalid, only then all children
			//in the q, else not.
			
			System.out.println(qItem+" isNOTValid" );
			
			
			
			for(int i = 0;i<qItem.length();i++) {
				
				if(qItem.charAt(i)!='(' && qItem.charAt(i)!=')') continue;
				
				String temp = qItem.substring(0, i)+qItem.substring(i+1);
				
				if(!isVisited.contains(temp)) {
					
					q.add(temp);
					isVisited.add(temp);
				}
				
						
			}
			
			System.out.println("qItems "+q.toString());
		}
		
		
		return resList;
    }
	
	public static boolean isValid(String s) {
		int count = 0;
		
		for(int i = 0;i<s.length();i++) {
			
			if(s.charAt(i) == '(') count++;
			if(s.charAt(i) == ')') count--;
			
			if(count<0) return false;
			
		}
		
		return (count==0);
	}
}
