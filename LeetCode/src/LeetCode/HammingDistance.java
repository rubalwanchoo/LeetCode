package LeetCode;

public class HammingDistance {
/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 	Given two integers x and y, calculate the Hamming distance.
	
	Note:
	0 ≤ x, y < 231.
	
	Example:
	
	Input: x = 1, y = 4
	
	Output: 2
	
	Explanation:
	1   (0 0 0 1)
	4   (0 1 0 0)
	       ↑   ↑
	
	The above arrows point to positions where the corresponding bits are different.

 */
	
	public static void main (String[] args) {

		System.out.println(hammingDistance(1,4));
	
	}
	
	public static int hammingDistance(int x, int y) {
		
		int hammingDistance = 0;
		String xorBinary = Integer.toBinaryString(x^y);
		
		
		for(int i=0;i<xorBinary.length();i++) {
			
			if(xorBinary.charAt(i)=='1') {
				hammingDistance++;
			}
		}
        
		
		return hammingDistance;
    }
}
