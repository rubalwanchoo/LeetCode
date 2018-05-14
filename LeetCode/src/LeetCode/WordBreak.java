package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class WordBreak {

	/*
	Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
	determine if s can be segmented into a space-separated sequence of one or more dictionary words.

	Note:

	The same word in the dictionary may be reused multiple times in the segmentation.
	You may assume the dictionary does not contain duplicate words.
	Example 1:

	Input: s = "leetcode", wordDict = ["leet", "code"]
	Output: true
	Explanation: Return true because "leetcode" can be segmented as "leet code".
	Example 2:

	Input: s = "applepenapple", wordDict = ["apple", "pen"]
	Output: true
	Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	             Note that you are allowed to reuse a dictionary word.
	Example 3:

	Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	Output: false

	*/
	
	static HashSet<String> mySet = new HashSet<String>();
	static HashMap<String,Boolean> myMap = new HashMap<String,Boolean>();
	
	
	public static void main(String args[]) {
		
		System.out.println(wordBreak("leetcode",new ArrayList<String>(Arrays.asList("leet","code"))));
		//System.out.println(wordBreak("applepenapple",new ArrayList<String>(Arrays.asList("apple","en"))));
		//System.out.println(wordBreak("aaaaaaa",new ArrayList<String>(Arrays.asList("aaaa","aaa"))));
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
        
		boolean result = false;
		
		for(Object item:wordDict) {
			mySet.add((String)item);
		}
		
		result = checkWord(s);
		
		
		return result;
    }
	
	
	public static boolean checkWord(String s) {
		
		System.out.println("checkingWord "+s);
		
		if(myMap.containsKey(s)) {
			
			System.out.println("returning "+myMap.get(s));
			return myMap.get(s);
		}else if(mySet.contains(s)){
			myMap.put(s, mySet.contains(s));
			return true;
			
		}else if(s.length()>1){
			
			myMap.put(s, mySet.contains(s));
			
			boolean result = false;
			
			for(int i = 0;i<s.length();i++) {
				
				String wordLeft = s.substring(0, i+1);
				String wordRight = s.substring(i+1, s.length());
				
				
				if(wordLeft.length()>0) {
					System.out.println("wordLeft "+wordLeft);
					result = result||checkWord(wordLeft);
				}
				if(wordRight.length()>0) {
					System.out.println("wordRight "+wordRight);
					result = result && checkWord(wordRight);
				}
				
				if(result) break;
				
			}
			
			System.out.println("returning "+result);
			return result;
		}else {
			myMap.put(s, mySet.contains(s));
			
			System.out.println("returning "+myMap.get(s));
			return myMap.get(s);
		}
	}
}
