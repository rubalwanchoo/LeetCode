package LeetCode2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChange {
	
	/*
	You are given coins of different denominations and a total amount of money amount. 
	Write a function to compute the fewest number of coins that you need to make up that amount. 
	If that amount of money cannot be made up by any combination of the coins, return -1.

			Example 1:

			Input: coins = [1, 2, 5], amount = 11
			Output: 3 
			Explanation: 11 = 5 + 5 + 1
			Example 2:

			Input: coins = [2], amount = 3
			Output: -1
			Note:
			You may assume that you have an infinite number of each kind of coin.


	*/
	public static Map<Integer,Integer> minCoinsForAmount = new HashMap<>();
	
	public static void main(String[] args) {
		
		//System.out.println(coinChange(new int[] {1,2,3},5));
		//System.out.println(coinChange(new int[] {1,2,5},11));
		System.out.println(coinChange(new int[] {2},3));
		//System.out.println(coinChange(new int[] {2,5},23));
		
		

	}
	
	public static int coinChange(int[] coins, int amount) {
		
		
		if(minCoinsForAmount.containsKey(amount)) 
			return minCoinsForAmount.get(amount);
			

		if(amount==0) return 0;
		if(amount <0) return -1;
		int minAmount = Integer.MAX_VALUE;
		
		for(int i=0;i<coins.length;i++) {

			int recur = coinChange(coins,amount-coins[i]);
			//System.out.println("amount "+amount+" recur "+recur);
			
			if(recur>=0)
				minAmount = Math.min(minAmount, recur);

			
		}// end for
		int resp = 0;
		
		if(minAmount>=0 && minAmount!=Integer.MAX_VALUE)
			resp = minAmount+1;
		else
			resp = -1;
		
		
		minCoinsForAmount.put(amount, resp);
	
		return resp;
	
	}
	
	
	
	
	
	
	
	

}
