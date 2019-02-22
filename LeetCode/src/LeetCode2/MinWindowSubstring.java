package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

	
	/*
	 * Given a string S and a string T, find the minimum window in S which will 
	 * contain all the characters in T in complexity O(n).

		Example:
		
		Input: S = "ADOBECODEBANC", T = "ABC"
		Output: "BANC"
		Note:
		
		If there is no such window in S that covers all characters in T, return the empty string "".
		If there is such window, you are guaranteed that there will 
		always be only one unique minimum window in S.

	 */
	
	public static void main(String args[]) {
		
		//System.out.println(minWindow("ADOBECODEBANC","ABC"));
		//System.out.println(minWindow("AB","B"));
		//System.out.println(minWindow("BDAB","AB"));
		//System.out.println(minWindow("A","AA"));
		System.out.println(minWindow("ABC","C"));
	}
	
	public static String minWindow(String s, String t) {
        String res = "";
        boolean hiIncremented = false;
        
        Map<String,Integer> tMap = new HashMap<>();
        Map<String,Integer> sMap = new HashMap<>();
        
        
        
        for(int i =0;i<t.length();i++) {
        	String currChar = String.valueOf(t.charAt(i));
        	if(tMap.containsKey(currChar)) {
        		tMap.put(currChar, tMap.get(currChar)+1);
        	}else {
        		tMap.put(currChar, 1);
        		sMap.put(currChar, 0);
        	}
        	
        }
        
        System.out.println("tMap "+tMap);
        System.out.println("sMap "+sMap);
        
        int lo = 0;
        int hi = 0;
        
        while(hi>=lo && hi<=s.length()) {
        	
        	if(hi<s.length()) System.out.println("loop lo "+lo+", hi "+hi+", s.charAt(lo) "+s.charAt(lo)+", s.charAt(hi) "+s.charAt(hi));
        	
        	String charLo = "";
        	if(lo<s.length()) charLo = String.valueOf(s.charAt(lo));
        	
        	String charHi = "";
        	if(hi<s.length()) charHi = String.valueOf(s.charAt(hi));
        	
        	if(!tMap.containsKey(charLo)) {
        		System.out.println("in c1");
        		lo++;
        		
        		if(!hiIncremented) hi=lo;
        	}
        	else {
        		
        		if(allUsed(sMap,tMap)) {
        			System.out.println("in c2");
        			res = ((res.length()==0) || (s.substring(lo, hi).length()<res.length()))?s.substring(lo, hi):res;
        			System.out.println("res "+res);
        			
        			sMap.put(charLo, sMap.get(charLo)-1);
        			lo++;
        		}else if(tMap.containsKey(charHi) && sMap.get(charHi)==tMap.get(charHi)) {
        			System.out.println("in c3");
        			clearKeys(sMap);
        			lo=hi;
        		}else {
        			System.out.println("in c4");
        			if(tMap.containsKey(charHi)) {
        				System.out.println("in c5");
        				sMap.put(charHi, sMap.get(charHi)+1);
        			}
        			
        			hiIncremented = true;
        			hi++;
        		}
        		
        		System.out.println("tMap "+tMap);
                System.out.println("sMap "+sMap);
        	}
        	
        	System.out.println("hi "+hi+",lo "+lo);
        	
        }//end while loop
        
          
        return res;
    }
	
	
	public static Map<String,Integer> clearKeys(Map<String,Integer> sMap){
		
		for(Map.Entry<String, Integer> item: sMap.entrySet()) {
			item.setValue(0);
		}
		
		System.out.println("sMap reset "+sMap);
		
		return sMap;
	}
	
	public static boolean noneUsed(Map<String, Integer> sMap) {
		
		boolean resp = true;
		
		for(Map.Entry<String, Integer> item: sMap.entrySet()) {
			
			if(item.getValue() != 0) {
				resp = false;
				break;
			}
		}
		
		System.out.println("noneUsed "+resp);
		return resp;
	}
	
	public static boolean allUsed(Map<String, Integer> sMap, Map<String, Integer> tMap) {
		
		boolean resp = true;
		
		for(Map.Entry<String, Integer> item: tMap.entrySet()) {
			
			if(item.getValue() != sMap.get(item.getKey())) {
				resp = false;
				break;
			}
		}
		
		System.out.println("allUsed "+resp);
		return resp;
	}
}
