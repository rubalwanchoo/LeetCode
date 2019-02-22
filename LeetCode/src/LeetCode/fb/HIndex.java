package LeetCode.fb;

import java.util.HashMap;

public class HIndex {
	
	/*
	 	Given an array of citations in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

		According to the definition of h-index on Wikipedia: "A scientist has index h 
		if h of his/her N papers have at least h citations each, 
		and the other N − h papers have no more than hcitations each."
		
		Example:
		
		Input: citations = [0,1,3,5,6]
		Output: 3 
		Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
		             received 0, 1, 3, 5, 6 citations respectively. 
		             Since the researcher has 3 papers with at least 3 citations each and the remaining 
		             two with no more than 3 citations each, his h-index is 3.
		Note: If there are several possible values for h, the maximum one is taken as the h-index.
	 */

	public static void main(String[] args) {
		
		System.out.println(hIndex(new int[] {0,1,3,5,6}));
		System.out.println(hIndex(new int[] {1,1,1,1,1}));
		

	}
	
	public static int hIndex(int[] citations) {
        
		HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
		
		for(int i = 1;i<=citations.length;i++) {
			
			if(citations[i]>=i) {
				map1.put(i, citations.length-i);
			}
			else {
				map1.put(i,0);
			}
			
			if(citations[i]<=i) {
				map2.put(i,i);
			}
			else {
				//map2.put();
			}
			
			
			
		}
		
		
    }

}
