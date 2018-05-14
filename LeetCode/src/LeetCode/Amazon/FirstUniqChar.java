package LeetCode.Amazon;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class FirstUniqChar {
	
	/*
	 Given a string, find the first non-repeating character in it and return it's index. 
	 If it doesn't exist, return -1.

		Examples:
		
		s = "leetcode"
		return 0.
		
		s = "loveleetcode",
		return 2.
		Note: You may assume the string contain only lowercase letters.
	 */

	
	public static void main(String args[]) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}
	
	public static int firstUniqChar(String s) {
        int returnIdx = -1;
		
		LinkedHashMap<String,Integer[]> map = new LinkedHashMap<String,Integer[]>();
		//string -> int1(exists once 1 or multiple 0),int2(first occuring idx)
		
		for(int i=0;i<s.length();i++) {
			String currChar = String.valueOf(s.charAt(i));
			
			if(map.containsKey(currChar)) {
				int firstIdx = map.get(currChar)[1];
				map.put(currChar,new Integer[] {0,firstIdx});
			}
			else {
				map.put(currChar, new Integer[] {1,i});
			}
		
		}
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			Integer[] arr = map.get(it.next());
			
			if(arr[0] == 1) {
				returnIdx = arr[1];
				break;
			}
		}
		
		
		
		return returnIdx;
    }
}
