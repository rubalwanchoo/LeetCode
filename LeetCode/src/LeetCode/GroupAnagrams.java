package LeetCode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupAnagrams {

	/*
	 	Given an array of strings, group anagrams together.

		Example:
		
		Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
		Output:
		[
		  ["ate","eat","tea"],
		  ["nat","tan"],
		  ["bat"]
		]
		Note:
		
		All inputs will be in lowercase.
		The order of your output does not matter.

	 */
	
	public static void main(String args[]) {
		
		HashMap<String,Integer> alphaMap = new HashMap<String,Integer>(); 
		
		alphaMap = initializePrimeAlpha(alphaMap);
	}
	
	/*
	public List<List<String>> groupAnagrams(String[] strs) {
        
		HashMap<String,Integer> alphaMap = new HashMap<String,Integer>(); 
		
		alphaMap = initializePrimeAlpha(alphaMap);
    }
    */
	
	public static HashMap<String,Integer> initializePrimeAlpha(HashMap<String,Integer> map){
		
		HashMap<String,Integer> myMap = new HashMap<String,Integer>();
		char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int[] primeNumbers = new int[26];
		
		
		int count = 0; // to count the number of primes captured
		
		int i=0;
		
		
		while(count<=26) {
		
			int j=0;
			
			while(j<i) {
				
				if(i%j==0) {//not prime
					i++;
					break;
				}
				
				
				
				j++;
			}
			
			
		}
		
		
		System.out.println(myMap);
		return myMap;
	}
}
