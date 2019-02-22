package LeetCode.fb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.ArrayList;

public class TaskScheduler {

	/*
	 	Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

		However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
		
		You need to return the least number of intervals the CPU will take to finish all the given tasks.
		
		Example 1:
		Input: tasks = ["A","A","A","B","B","B"], n = 2
		Output: 8
		Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
		Note:
		The number of tasks is in the range [1, 10000].
		The integer n is in the range [0, 100].
	 */
	static SortedMap<String,Integer> taskCountMap = new TreeMap<>();
	
	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] {'A','A','A','B','B','B'},50));
		//System.out.println(leastInterval(new char[] {'A','B','A','B','A','A'},2));

	}
	
	public static int leastInterval(char[] tasks, int n) {
        
        
        Arrays.sort(tasks);
        ArrayList<String> resultArray = new ArrayList<>();
        
        
        
        for(int i=0;i<tasks.length;i++) { //O(n)
        	
        	String currTask = String.valueOf(tasks[i]);
        	
        	if(taskCountMap.containsKey(currTask)) {
        		taskCountMap.put(currTask,taskCountMap.get(currTask)+1);
        	}else {
        		taskCountMap.put(currTask,1);
        	}
        }
        System.out.println("1 "+taskCountMap);
        
        
        resultArray.add(String.valueOf(tasks[0]));
        System.out.println(resultArray);
        
        taskCountMap.put(String.valueOf(tasks[0]), taskCountMap.get(String.valueOf(tasks[0]))-1);
        System.out.println("2 " +taskCountMap);
        
        
        for(int j=1;j<tasks.length;j++) {
        	if(taskCountMap.get(String.valueOf(tasks[j]))>0 && tasks[j]==tasks[j-1]) {
        		
        		int count = 0;
        		while(count<n) {
        			String newTask = getNextAvailableTask(String.valueOf(tasks[j-1]),resultArray);
            		resultArray.add(newTask);
            		System.out.println(resultArray);
            		count++;
        		}
        		
        	}
        	if(taskCountMap.get(String.valueOf(tasks[j]))>0) {
        		resultArray.add(String.valueOf(tasks[j]));
        		taskCountMap.put(String.valueOf(tasks[j]), taskCountMap.get(String.valueOf(tasks[j]))-1);
            	System.out.println("3 " +taskCountMap);
        	}
        	
        }
        
        System.out.println(resultArray);
        return resultArray.size();
    }
	
	public static String getNextAvailableTask(String currTask,ArrayList<String> resultArray) {
		String returnValue = "idle";
		
		for(Map.Entry<String, Integer> entry:taskCountMap.entrySet()) {
			if(!entry.getKey().equals(currTask) && !entry.getKey().equals(resultArray.toArray()[resultArray.size()-1]) && entry.getValue()>0) {
				returnValue = entry.getKey();
				break;
			}
		}
		
		if(!returnValue.equals("idle")) {
			taskCountMap.put(returnValue, taskCountMap.get(returnValue)-1);
			//System.out.println("4 "+taskCountMap);
		}
		
		
		return returnValue;
	}

}
