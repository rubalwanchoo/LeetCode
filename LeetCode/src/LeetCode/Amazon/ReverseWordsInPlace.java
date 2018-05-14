package LeetCode.Amazon;

import java.util.Arrays;
public class ReverseWordsInPlace {

	/*
	 	Given an input string , reverse the string word by word. 

		Example:
		
		Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
		Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
		Note: 
		
		A word is defined as a sequence of non-space characters.
		The input string does not contain leading or trailing spaces.
		The words are always separated by a single space.
		Follow up: Could you do it in-place without allocating extra space?
	 */
	
	public static void main(String[] args) {
		
		reverseWords(new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'});
		
	}
	
	
	public static void reverseWords(char[] str) {
		
		//display(str);
        
		//reverse chars
		str = reverse(0,str.length-1,str);
		
		
		
		//reverse each word
		int lo = 0;
		int hi = 0;
		
		while(hi<str.length) {
			
			if(str[hi] == ' ' || hi==str.length-1){
				str = reverse(lo,hi==str.length-1?hi:hi-1,str);
				//display(str);
				lo = hi+1;
			}
			
			hi++;
		}
    }
	
	public static char[] reverse(int lo, int hi,char[] chars) {
		
		while(lo<hi) {
			char temp = chars[hi];
			chars[hi] = chars[lo];
			chars[lo] = temp;
			
			lo++;hi--;
			
		}
		
		
		return chars;
	}
	
	public static void display(char[] chars) {
		System.out.println();
		
		for(char c:chars) {
			System.out.print(c);
		}
	}
	
	
}
