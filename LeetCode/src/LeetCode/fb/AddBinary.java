package LeetCode.fb;

public class AddBinary {

	
	/*
	 	Given two binary strings, return their sum (also a binary string).
	
		The input strings are both non-empty and contains only characters 1 or 0.
		
		Example 1:
		
		Input: a = "11", b = "1"
		Output: "100"
		Example 2:
		
		Input: a = "1010", b = "1011"
		Output: "10101"
	 */

	public static void main(String[] args) {
		//System.out.println(addBinary("11","1"));
		//System.out.println(addBinary("1010","1011"));
		System.out.println(addBinary("0","0"));
	}
	
	public static String addBinary(String a, String b) {
        
		char[] aChars = a.toCharArray();
		char[] bChars = b.toCharArray();
		char[] cChars = new char[Math.max(aChars.length,bChars.length)+1];
		
		int aIdx = aChars.length-1;
		int bIdx = bChars.length-1;
		int cIdx = cChars.length-1;
		int sum = 0;
		int carry = 0;
		
		while(aIdx>=0 || bIdx>=0) {
			
			int aBin = (aIdx>=0 && aIdx<aChars.length)?aChars[aIdx]-'0':0;
			int bBin = (bIdx>=0 && bIdx<bChars.length)?bChars[bIdx]-'0':0;
			
			System.out.println("evaluatin aBin "+aBin + " bBin"+bBin);
			
			sum = aBin+bBin+carry;
			
			//System.out.println("sum before "+sum);
			
			if(sum == 0) {
				carry = 0;
			}
			else if(sum == 1) {
				carry = 0;
			}
			else if(sum == 2) {
				sum = 0;
				carry = 1;
			}
			else if(sum == 3) {
				sum = 1;
				carry = 1;
			}
			
			cChars[cIdx] = (char) (sum + '0');
			
			//System.out.println("sum after "+sum);
			System.out.println("cChar "+String.valueOf(cChars[cIdx]));
			
			aIdx--;bIdx--;cIdx--;
		}
		
		if(carry == 1) cChars[cIdx] = (char)(1+'0');
		else cChars[cIdx] = (char)(0 + '0');
		System.out.println("cChar "+String.valueOf(cChars[cIdx]));
		
		
		
		return trimLeadingZeroes(String.valueOf(cChars));
    }

	private static String trimLeadingZeroes(String str) {
		
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)=='0') continue;
			else {
				return str.substring(i);
			}
		}
		
		return String.valueOf(str.charAt(str.length()-1));
	}
	
}
