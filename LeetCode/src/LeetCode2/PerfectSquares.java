package LeetCode2;

import java.util.*;

public class PerfectSquares {
	/*
	Given a positive integer n, find the least number of perfect square numbers 
	(for example, 1, 4, 9, 16, ...) which sum to n.

	Example 1:

	Input: n = 12
	Output: 3 
	Explanation: 12 = 4 + 4 + 4.
	Example 2:

	Input: n = 13
	Output: 2
	Explanation: 13 = 4 + 9.
	*/
	
	public static Map<Integer,Integer> myMap = new HashMap<>();

	public static void main(String[] args) {
		
		//System.out.println(numSquares(5));
		System.out.println(numSquares(13));
		
		

	}
	
	public static int numSquares(int n) {
		
		System.out.println("FOR INPUT "+n);
		
		if(myMap.containsKey(n)) return myMap.get(n);

		if(n<0) {
			System.out.println(" returning2 maxvalue");
			return 0;
		}
		
		
		int resp = Integer.MAX_VALUE;
		int temp = 0;
		
		for(int i = (int)Math.sqrt(n);i>0;i--) {
			
			//System.out.println("for "+ i +" square");
			if(n-i*i<0) break;
			else if(n-i*i==0) {
				temp = 0;
			}else {
				temp = numSquares(n-i*i);
			}
			
	
			
			resp  = temp>0?Math.min(temp,resp):temp;
			
				
	
			
		}//end for
		
		System.out.println(" returning3 "+(resp==0?resp:resp+1)); 
		
		
		if(!myMap.containsKey(n)) {
			myMap.put(n, resp+1);
		}
		
		return resp+1;
		
    }

}
