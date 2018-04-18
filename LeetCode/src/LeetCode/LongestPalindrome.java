package LeetCode;

public class LongestPalindrome {
	
	/*
	 Given a string s, find the longest palindromic substring in s. 
	 You may assume that the maximum length of s is 1000.

		Example 1:
		
		Input: "babad"
		Output: "bab"
		Note: "aba" is also a valid answer.
		
		Example 2:
		
		Input: "cbbd"
		Output: "bb"

	 */

	public static void main(String[] args) {
		
		//System.out.println("\n Longest Palindrome substring -"+longestPalindrome("babad"));
		System.out.println("\n Longest Palindrome substring -"+longestPalindrome("abb"));

	}

	
	public static String longestPalindrome(String s) {
		String longestPalindrome = "";
		int pLength = 0;
		int longestPlength = 0;
		int longestPIdx = -1;
		int startIdx = -1;
		int endIdx = -1;
		boolean allSame = true;
		

		for(int i=0;i<s.length();i++) {
			if(!String.valueOf(s.charAt(i)).equals(String.valueOf(s.charAt(0)))) {
				allSame = false;
			}
		}
		
		if(allSame) {
			return s;
		}
		
		
		
		s= addSpecialChar(s,"$");
		System.out.println(s);
		
		
		for(int i = 0;i<s.length();i++) {
			System.out.println("exploringAround-"+s.charAt(i));
			pLength = exploreAround(s,i);
			System.out.println("pLength-"+pLength);
			
			if(pLength>longestPlength) {
				longestPlength = pLength;
				longestPIdx = i;
			}
		}

		
		startIdx = longestPIdx - (longestPlength-1)/2;
		endIdx = longestPIdx + (longestPlength-1)/2;
		
		System.out.println("longestPIdx-"+longestPIdx);
		System.out.println("startIdx-"+startIdx+", endIdx-"+endIdx);
		
		longestPalindrome = s.substring(startIdx, endIdx+1);
		
		//longestPalindrome = removeSpecialChar(longestPalindrome,"$");
		longestPalindrome = longestPalindrome.replaceAll("[$]", "");
		
		
		
		return longestPalindrome;
	}
	
	public static int exploreAround(String s, int centerIdx) {
		int pLength = 0;
		
		int left = centerIdx -1;
		int right = centerIdx +1;
		
		while(left>=0 && right<s.length() && String.valueOf(s.charAt(left)).equals(String.valueOf(s.charAt(right)))) {
			pLength+=2;
			
			left--;
			right++;
		}
		
		
		pLength++;
		
		return pLength;
	}
	
	
	public static String addSpecialChar(String s, String specialChar) {
		String returnString = "";
		
		for(int i = 0;i<2*s.length()+1;i++) {
			if(i%2==0) {
				returnString = returnString+specialChar;
			}
			else {
				returnString = returnString+String.valueOf(s.charAt((i-1)/2));
			}
		}
		
		return returnString;
	}
	
	public static String removeSpecialChar(String s, String specialChar) {
		String returnString = "";
				
		for(int i = 0;i<s.length();i++) {
			if(i%2==0) {
				continue;
			}
			else {
				returnString = returnString+String.valueOf(s.charAt(i));
			}
		}
		
		return returnString;
	}
	
}
