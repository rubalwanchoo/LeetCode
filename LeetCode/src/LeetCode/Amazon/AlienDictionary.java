package LeetCode.Amazon;

import java.util.HashSet;
import java.util.Set;

public class AlienDictionary {
	
	/*
	There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

	Example 1:

	Input:
	[
	  "wrt",
	  "wrf",
	  "er",
	  "ett",
	  "rftt"
	]

	Output: "wertf"
	Example 2:

	Input:
	[
	  "z",
	  "x"
	]

	Output: "zx"
	Example 3:

	Input:
	[
	  "z",
	  "x",
	  "z"
	] 

	Output: "" 

	Explanation: The order is invalid, so return "".
	Note:

	You may assume all letters are in lowercase.
	You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
	If the order is invalid, return an empty string.
	There may be multiple valid order of letters, return any one of them is fine.
 */
	
	public static void main(String[] args) {
		System.out.println(alienOrder(new String[] {"wrt","wrf","er","ett","rftt"}));
	}
	
	
	public static String alienOrder(String[] words) {
        
		String outputStr = "";
		String lastAlpha = "";
		Set<String> visited = new HashSet<>();
        
		boolean allCharsRead = false;
		int currIdx = 0;
		int maxWordLen = 0;
		
		while(!allCharsRead) {
			
			for(int i=0;i<words.length;i++) {
				
				maxWordLen = Math.max(words.length,maxWordLen);
				
				System.out.println("word "+words[i]+", currIdx "+currIdx+", len "+words[i].length()+", maxWordLen "+maxWordLen);
				
				if(currIdx<words[i].length()) {//word has those many alphas
					
					String currAlpha = String.valueOf(words[i].charAt(currIdx));
					System.out.println("currAlpha "+ currAlpha);
					
					
					if(visited.contains(currAlpha) && !lastAlpha.equals(currAlpha)){//invalid order
						System.out.println("returning INVALID");
						return "";
					}
					
					lastAlpha = currAlpha;
					if(!visited.contains(currAlpha)) visited.add(currAlpha);
					
					if(!lastAlpha.equals(currAlpha)) {
						outputStr = outputStr + currAlpha;
						System.out.println("outputStr "+outputStr);
					}
					
				}
				
				
			}//end for
			
			if((currIdx+1)<maxWordLen) {
				currIdx++;
			}
			else {
				allCharsRead = true;
				System.out.println("allCharsRead marked true");
			}
		}
		
		
		
		return outputStr;
    }
}
