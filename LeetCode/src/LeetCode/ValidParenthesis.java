package LeetCode;


import java.util.Stack;


public class ValidParenthesis {

	
	/*
	 	Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

		An input string is valid if:
		
		Open brackets must be closed by the same type of brackets.
		Open brackets must be closed in the correct order.
		Note that an empty string is also considered valid.
		
		Example 1:
		
		Input: "()"
		Output: true
		Example 2:
		
		Input: "()[]{}"
		Output: true
		Example 3:
		
		Input: "(]"
		Output: false
		Example 4:
		
		Input: "([)]"
		Output: false
		Example 5:
		
		Input: "{[]}"
		Output: true
	 */
	
	public static void main(String args[]) {
		
		//System.out.println(isValid("()"));
		//System.out.println(isValid("()[]{}"));
		//System.out.println(isValid("(]"));
		//System.out.println(isValid("([)]"));
		//System.out.println(isValid("]"));
		//System.out.println(isValid("){"));
		System.out.println(isValid("{[]}"));
	}
	
	public static boolean isValid(String s) {
        boolean isValid = true;
        Stack<String> st = new Stack<String>();
        
        if(s.length()==0) {
        	return true;
        }
        
        if(s.length()==1) {
        	return false;
        }
        
        
        int i=0;
        while(i<s.length()) {
        	
        	String currChar = String.valueOf(s.charAt(i));
        	
        	System.out.println("currChar-"+currChar);
        	
        	if(currChar.equals("(")||currChar.equals("{")||currChar.equals("[")) {
        		System.out.println("c1");
        		st.push(currChar);
        	}
        	else if(currChar.equals(")") && (st.isEmpty()||!st.peek().equals("("))) {
        		System.out.println("c2");	
        		isValid = false;
        		if(!st.isEmpty()) {st.pop();}
        		break;
        	}
        	else if(currChar.equals("}") && (st.isEmpty() || !st.peek().equals("{"))) {
        		System.out.println("c3");
        		isValid = false;
        		if(!st.isEmpty()) {st.pop();}
    			break;
        	}
        	else if(currChar.equals("]") && (st.isEmpty() || !st.peek().equals("["))) {
        		System.out.println("c4");
        		isValid = false;
        		if(!st.isEmpty()) {st.pop();}
    			break;
        	}
        	else {
        		st.pop();
        	}
        	
        	i++;
        }
        	
        if(!st.isEmpty()) {
        	return false;
        }
        
        
        return isValid;
    }
}
