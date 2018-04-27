package LeetCode;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;


public class KFrequentElements {
	/*
	 	https://www.youtube.com/watch?v=EYFcQRwcqk0
	 	
	 	Given a non-empty array of integers, return the k most frequent elements.

		For example,
		Given [1,1,1,2,2,3] and k = 2, return [1,2].
		
		Note: 
		You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
		Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

	 */
	
	public static void main(String args[]) {
		topKFrequent(new int[] {1,1,1,2,2,3},2);
		//topKFrequent(new int[] {1,2},2);
	}
	
	
	public static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> returnList = new ArrayList<Integer>();
        
        //To Do logic here
        
        
        if(nums.length == 1 && k ==1) {

        	returnList.add(Integer.valueOf(nums[0]));
        	displayArray(returnList);
        	return returnList;
        }
        
        
        
        HashMap<Integer,ArrayList<Integer>> myMap = new HashMap<Integer,ArrayList<Integer>>();
        //key is the frequency , value is the array of integers that match that frequency
        
        for(int i=0;i<nums.length;i++) {
        	myMap.put(i+1, null);
        }
        
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++) {
        	
        	int count = 1;

        	if(i<nums.length-1) {
        		while(i<nums.length-1 && nums[i]==nums[i+1]) {
        			count++;
        			i++;
        		}

        	}
        	
        		myMap = addToMap(myMap,count,nums[i]);
        }

        
        
        System.out.println(myMap.get(3));
        System.out.println(myMap.get(2));
        System.out.println(myMap.get(1));
        
        
        //Get k prominent integers
        int returnCount = 0;
        for(int j=nums.length;j>0;j--) {
        	
        	
        	if(myMap.get(j)!=null) {

        		Iterator<Integer> it = myMap.get(j).iterator();

        		while(it.hasNext()) {
        			returnList.add(it.next());
        			returnCount ++;
        			
        			//System.out.println("returnCount-"+returnCount+" k-"+k);
        			if(returnCount==k) {return returnList;}
        		}
        		
        	}
        	
        	
        }
        
        
        
        
        displayArray(returnList);
        return returnList;
    }
	
	
	public static HashMap<Integer,ArrayList<Integer>> addToMap(HashMap<Integer,ArrayList<Integer>> myMap,int key, int valueToAdd){
		ArrayList<Integer> arrayList;
		
		if(myMap.get(key)==null) {
			arrayList = new ArrayList<Integer>();	
			System.out.println("Creating new arrayList and adding "+valueToAdd);
		}
		else {
			arrayList = myMap.get(Integer.valueOf(key));
			System.out.println("Updating existing arrayList and adding "+valueToAdd);
			
		}
		
		arrayList.add(Integer.valueOf(valueToAdd));
		myMap.put(Integer.valueOf(key),arrayList );
		
		return myMap;
	}
	
	
	public static void displayArray(List<Integer> list) {
		
		Iterator<Integer> it = list.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}

}
