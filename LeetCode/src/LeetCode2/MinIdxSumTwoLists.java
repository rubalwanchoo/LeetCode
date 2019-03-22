package LeetCode2;

import java.util.*;

public class MinIdxSumTwoLists {

	
	//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
	
	
	public static void main(String[] args) {
		String[] arr1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] arr2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
		
		System.out.println(Arrays.toString(findRestaurant(arr1,arr2)));

	}
	
	
	public static String[] findRestaurant(String[] list1, String[] list2) {
	        List<String> ret = new ArrayList<>();
	        
	        Map<String,Integer> visited = new HashMap<>();
	        Map<Integer,List<String>> commonRest = new HashMap<>();
	        
	        for(int i=0;i<list1.length;i++) {
	        	visited.put(list1[i], i);
	        }
	        
	        int minIdxSum = Integer.MAX_VALUE;
	        
	        
	        for(int j=0;j<list2.length;j++) {
	        	
	        	if(visited.containsKey(list2[j])) {
	        		
	        		int idxSum = j + visited.get(list2[j]);
	        		
	        		 if(idxSum<=minIdxSum) {
	        			 
	        			 minIdxSum = idxSum;
	        			 
	        			 if(commonRest.containsKey(idxSum)) {
	        				 List<String> newList = commonRest.get(idxSum);
	        				 newList.add(list2[j]);
	        				 commonRest.put(idxSum,newList);
	        			 }
	        			 else {
	        				 List<String> newList = new ArrayList<>();
	        				 newList.add(list2[j]);
	        				 commonRest.put(idxSum, newList);
	        			 }
	        		 }
	        	}
	        	
	        }//end for
	        
	        
	        ret = commonRest.get(minIdxSum);
	        
	        
	        
	        return ret.toArray(new String[ret.size()]);
    }

}
