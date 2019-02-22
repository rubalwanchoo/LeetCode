package LeetCode.fb;

import java.util.HashMap;

public class DecodeWays {

	/*
	  	A message containing letters from A-Z is being encoded to numbers using the following mapping:

		'A' -> 1
		'B' -> 2
		...
		'Z' -> 26
		Given a non-empty string containing only digits, determine the total number of ways to decode it.
		
		Example 1:
		
		Input: "12"
		Output: 2
		Explanation: It could be decoded as "AB" (1 2) or "L" (12).
		Example 2:
		
		Input: "226"
		Output: 3
		Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
	 */
	
	static HashMap<String, Integer> myMap = new HashMap<>();
	public static void main(String[] args) {
		
		System.out.println(numDecodings("12"));
		//System.out.println(numDecodings("00"));

	}
	
	
	public static int numDecodings(String s) {
		int total = 0;
		
		System.out.println("s "+s);
		if(myMap.containsKey(s)) return myMap.get(s);
		
		
		if(s.length()==0) return 1;
		if(s.charAt(0)=='0') return 0;
		
		if(s.length()>0 && Integer.parseInt(s.substring(0, 1))<=26) {//left deduction valid
			System.out.println("lDeduction "+s.substring(0, 1));
			total += numDecodings(s.substring(1));
		}
		if(s.length()>1 && Integer.parseInt(s.substring(0, 2))<=26) {//right deduction valid
			System.out.println("rDeduction "+s.substring(0, 2));
			total += numDecodings(s.substring(2));
		}
		
		myMap.put(s,total);
		
		return total;
    }
	
	
}
