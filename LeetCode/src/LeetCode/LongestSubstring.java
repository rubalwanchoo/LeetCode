package LeetCode;


import java.util.HashSet;

public class LongestSubstring {
	
	
	/*
	 	Given a string, find the length of the longest substring without repeating characters.

		Examples:
		Given "abcabcbb", the answer is "abc", which the length is 3.
		Given "bbbbb", the answer is "b", with the length of 1.
		Given "pwwkew", the answer is "wke", with the length of 3. 
		Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

	 */
	

	public static void main(String[] args) {
		
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		
	}
	
	
	public static int lengthOfLongestSubstring(String s) {
		System.out.println("inside lengthOfLongestSubstring");
		
		if(s.length() ==1) {
			return s.length();
		}
		
		int longestLength = 0;
		int startIdx = 0;
		int endIdx = 0;
		
		HashSet<String> mySet = new HashSet<String>();
		
		while(endIdx < s.length()) {
			
			String currChar = String.valueOf(s.charAt(endIdx));
			
			//System.out.println("Evaluating char"+ currChar);
			
			
			if(!mySet.contains(currChar)) {
				
				mySet.add(currChar);
				
				longestLength = Math.max(endIdx-startIdx+1, longestLength);
				//Compares the length of current substring with longestLength value set till now
				//Not using substring function as that takes time.
				
				endIdx++;

				 
				
			}
			else {
				 
				 
				 mySet.remove(String.valueOf(s.charAt(startIdx)));
				 startIdx++;
				
			}
			
			
			
		}

		return longestLength;
        
    }

}
