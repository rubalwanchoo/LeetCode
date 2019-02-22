package LeetCode.fb;

public class ValidPalindrome2 {

	/*
	 	Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
		
		Example 1:
		Input: "aba"
		Output: True
		Example 2:
		Input: "abca"
		Output: True
		Explanation: You could delete the character 'c'.
		Note:
		The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
	 */
	public static void main(String[] args) {
		
		//System.out.println("A man, a plan, a canal: Panama".replaceAll("[^a-zA-Z0-9]", ""));
		
		//System.out.println(validPalindrome("A man, a plan, a canal: Panama"));
		//System.out.println(validPalindrome("cbbcc"));
		System.out.println(validPalindrome("abc"));

	}
	
	
	public static boolean validPalindrome(String s) {
        
		boolean charRemoved = false;
		
		s= s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
		
		return checkValidPalindrome(s,charRemoved);
		
    }
	
	public static boolean checkValidPalindrome(String s, boolean charRemoved){
	
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
				
				if(!charRemoved) {
					charRemoved = true;
					return (checkValidPalindrome(s.substring(i+1, s.length()-i),charRemoved) 
							||checkValidPalindrome(s.substring(i,s.length()-i-1),charRemoved));
				}else {
					return false;
				}
				
			}
		}
		
		return true;
	}
}
