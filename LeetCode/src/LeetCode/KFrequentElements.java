package LeetCode;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class KFrequentElements {
	/*
	 	Given a non-empty array of integers, return the k most frequent elements.

		For example,
		Given [1,1,1,2,2,3] and k = 2, return [1,2].
		
		Note: 
		You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
		Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

	 */
	
	public static void main(String args[]) {
		topKFrequent(new int[] {1,1,1,2,2,3},2);
		
	}
	
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> returnList = new ArrayList<Integer>();
        
        //To Do logic here
        
        
        displayArray(returnList);
        return returnList;
    }
	
	public static void displayArray(List<Integer> list) {
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}

}
