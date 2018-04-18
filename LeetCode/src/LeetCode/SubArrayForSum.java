package LeetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SubArrayForSum {
	
	/*
	 Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

		Input:		
		The first line of input contains an integer T denoting the number of test cases. 
		Then T test cases follow. Each test case consists of two lines. 
		The first line of each test case is N and S, where N is the size of array and S is the sum. 
		The second line of each test case contains N space separated integers denoting the array elements.
		
		Output:
		Corresponding to each test case, in a new line, print the starting and ending positions of first such 
		occuring subarray if sum equals to subarray, else print -1.
		Note: Position of 1st element of the array should be considered as 1.
		Expected Time Complexity: O(n)
		
		Constraints:
		1 ≤ T ≤ 100
		1 ≤ N ≤ 100
		1 ≤ an array element ≤ 200
		
		Example:
		
		Input:
		2
		5 12
		1 2 3 7 5
		10 15
		1 2 3 4 5 6 7 8 9 10
		
		Output:
		2 4
		1 5
		
		Explanation : 
		In first test case, sum of elements from 2nd position to 4th position is 12
		In second test case, sum of elements from 1st position to 5th position is 15 
	 */

	public static void main(String[] args) throws IOException{
		//Process Input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String noOfTestCases = reader.readLine();
		String[] arraySize = new String[Integer.parseInt(noOfTestCases)];
		String[] sumOfArray = new String[Integer.parseInt(noOfTestCases)];
		int[][] myNumberArray = new int[Integer.parseInt(noOfTestCases)][];
		
		for(int i=0;i<Integer.parseInt(noOfTestCases);i++) {
			StringTokenizer line2 = new StringTokenizer(reader.readLine()," ");
			arraySize[i] = line2.nextToken();
			sumOfArray[i] = line2.nextToken();
			
			myNumberArray[i] = new int[Integer.parseInt(arraySize[i])];
			
			StringTokenizer line3 = new StringTokenizer(reader.readLine()," ");
			
			int j = 0;
			while(line3.hasMoreTokens()) {
				myNumberArray[i][j] = Integer.parseInt(line3.nextToken());
				j++;
			}
			
			System.out.println("noOfTestCases-"+noOfTestCases);
			System.out.println("arraySize-"+arraySize[i]);
			System.out.println("sumOfArray-"+sumOfArray[i]);
			System.out.println("myArray length - "+myNumberArray[i].length);
			
			findSubArrayWithSum(myNumberArray[i],Integer.parseInt(sumOfArray[i]));
			
		// End Process Input
		
		}
	
	}
	
	
	
	public static void findSubArrayWithSum(int[] myNumberArray, int sum) {
		
		//Sliding window solution
		
		int left = 0;
		int right = 0;
		int mySum = 0;
		int[] resultArray = new int[2];
		
		
		while(right<myNumberArray.length && mySum != sum) {
			
			if(myNumberArray[left]==sum) {
				resultArray[0]=left;
				resultArray[1]= right;
				mySum = sum;
				break;
			}
			
			if(mySum+myNumberArray[right]<=sum) {
				
				mySum+= myNumberArray[right];
				resultArray[0]=left;
				resultArray[1]= right;
				right++;
				
			}
			else 
			{
				mySum-=myNumberArray[left];
				left++;
	
			}
		}
		
		System.out.println("left-"+left+",right-"+(right-1));
		
		
	}

}
