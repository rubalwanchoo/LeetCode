package LeetCode;

public class ReverseInteger {
	
	/*
	 	Given a 32-bit signed integer, reverse digits of an integer.
		
		Example 1:
		Input: 123
		Output: 321
		
		Example 2:
		Input: -123
		Output: -321
		
		Example 3:
		Input: 120
		Output: 21

		Note:
		Assume we are dealing with an environment which could only store integers within the 
		32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, 
		assume that your function returns 0 when the reversed integer overflows.


	 */

	public static void main(String[] args) {
		
		//reverse(-123);
		//System.out.println(reverse(-123));
		System.out.println(reverse(-1563847412));
		


	}
	
	public static int reverse(int x) {
		int returnInt = 0;
		String returnNo = "";
		int currInt = 0;
		boolean signedPositive = true;
		int length = 0;
		
		System.out.println((int)(Math.pow(2,31)*(-1)));
		System.out.println(((int)Math.pow(2, 31)));
		
		if(x<=(int)(Math.pow(2,31)*(-1)) || x>=((int)Math.pow(2, 31)-1)) {
			return 0;
		}
		
		
		if(x<0) {
			System.out.println("x is negative");
			length = String.valueOf(x*-1).length();
			signedPositive = false;
		}
		else {
			System.out.println("x is positive");
			length = String.valueOf(x).length();	
		}
		currInt = Math.abs(x);
		
		System.out.println("currInt-"+currInt);
		System.out.println("length-"+length);
		System.out.println("signedPositive-"+signedPositive);
		
		
		String currNo= String.valueOf(currInt);
		
		for(int i = length-1 ;i>=0;i--) {
			returnNo+=String.valueOf(currNo.charAt(i));
			
		}
		
		if(!signedPositive) {
			returnNo = "-"+returnNo;
		}
		
		System.out.println("returnNo-"+returnNo);

		
		if(Double.parseDouble(returnNo)<=(int)(Math.pow(2,31)*(-1)) || Double.parseDouble(returnNo)>=((int)Math.pow(2, 31)-1)) {
			return 0;
		}
		
		
		returnInt = Integer.parseInt(returnNo);
		
		
		
		return returnInt; 
        
    }

}
