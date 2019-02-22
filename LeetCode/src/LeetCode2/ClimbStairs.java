package LeetCode2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ClimbStairs {
	
	/*
	 	You are climbing a stair case. It takes n steps to reach to the top.

		Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
		
		Note: Given n will be a positive integer.
		
		Example 1:
		
		Input: 2
		Output: 2
		Explanation: There are two ways to climb to the top.
		1. 1 step + 1 step
		2. 2 steps
		Example 2:
		
		Input: 3
		Output: 3
		Explanation: There are three ways to climb to the top.
		1. 1 step + 1 step + 1 step
		2. 1 step + 2 steps
		3. 2 steps + 1 step

	 */

	static Map<Integer,Integer> map1 = new HashMap<>();
	static Map<Integer,Integer> map2 = new HashMap<>();
	
	public static void main(String[] args) {
		
		System.out.println(climbStairs(3));
		
		System.out.println("map1- " + map1);
		System.out.println("map2- " + map2);

		
		
		
		
	}
	
	
	
	
	public static int climbStairs(int n) {
		
		if(n==0) return 1;
		
		
		
		int count1 = 0;
		int count2 = 0;
		
		if(n-1>=0) {
			
			if(map1.containsKey(n)) count1 = map1.get(n);
			else {
				count1 = climbStairs(n-1);
				map1.put(n, count1);
			}
				
		}
		
		
		if(n-2>=0) {
			
			if(map2.containsKey(n)) count2 = map2.get(n);
			else {
				count2 = climbStairs(n-2);
				map2.put(n, count2);
			}
			
			
		}
		
		
		return count1+count2;
		
		
		
    }

}
