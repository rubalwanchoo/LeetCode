package LeetCode;

import java.util.HashMap;
import java.util.Iterator;

public class ValidAnagram {
	
	/*
	 	Given two strings s and t, write a function to determine if t is an anagram of s.

		For example,
		s = "anagram", t = "nagaram", return true.
		s = "rat", t = "car", return false.
		
		Note:
		You may assume the string contains only lowercase alphabets.
		
		Follow up:
		What if the inputs contain unicode characters? How would you adapt your solution to such case?

	 */
	
	
	public static void main(String args[]) {
		System.out.println(isAnagram("anagram","nagaram"));//true
		System.out.println(isAnagram("anagramp","nagaram"));//false
		System.out.println(isAnagram("rubal","bubal"));//false
		System.out.println(isAnagram("",""));//true
	}
	
	public static boolean isAnagram(String s, String t) {
        
		if((s.length()!=t.length())) {
			return false;
		}
		
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		
		//Create a map for all chars in s and t and increment/decrement respectively
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		int length = sChars.length;
		int i = 0;
		while(i<length){//Can run for any char length as both must be the same at this point
			

			String sChar = String.valueOf(sChars[i]);
			String tChar = String.valueOf(tChars[i]);
			
			if(map.containsKey(sChar)) {
				map.put(sChar, map.get(sChar)+1);
			}else {
				map.put(sChar, 1);
			}
			
			if(map.containsKey(tChar)) {
				map.put(tChar, map.get(tChar)-1);
			}else {
				map.put(tChar, -1);
			}
			
			i++;
			
		}
		
		
		//Iterate through map and look for non zeroes
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			if(map.get(it.next())!=0) {
				return false;
			}
		}

		
		
		
		return true;
    }

}
