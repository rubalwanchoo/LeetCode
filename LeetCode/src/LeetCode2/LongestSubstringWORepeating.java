package LeetCode2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWORepeating {
	
	/*
	  Given a string, find the length of the longest substring without repeating characters.

		Example 1:
		
		Input: "abcabcbb"
		Output: 3 
		Explanation: The answer is "abc", with the length of 3. 
		Example 2:
		
		Input: "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.
		Example 3:
		
		Input: "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3. 
		             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */

	public static void main(String[] args) {
		
		System.out.println(lengthOfLongestSubstring("ab"));
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));

	}
	
	public static int lengthOfLongestSubstring(String s) {
		
		int len = 0;
		
		int left = 0;
		int right = 0;
		
		Set<String> visited = new HashSet<>();
		
		while(left<=right && right<s.length()) {
			
			String currChar = String.valueOf(s.charAt(right));
			
			if(!visited.contains(currChar)) {
				visited.add(currChar);
				right++;
	
			}else {
				len = Math.max(len,right-left);
				visited.remove(String.valueOf(s.charAt(left)));
				left++;
			}
	
		}
		len = Math.max(len,right-left);
		
		
		return len;
        
    }

}
