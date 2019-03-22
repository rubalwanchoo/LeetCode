package LeetCode2;

import java.util.*;

public class TargetSum {
	
	//https://leetcode.com/problems/target-sum/
	
	public static Map<String,Integer> visited = new HashMap<>();

	public static void main(String[] args) {
		//System.out.println(findTargetSumWays(new int[] {1,1,1,1,1},3));
		//System.out.println(findTargetSumWays(new int[] {42,24,30,14,38,27,12,29,43,42,5,18,0,1,12,44,45,50,21,47},38));
		System.out.println(findTargetSumWays(new int[] {1,2,3,4,5},7));

	}

    public static int findTargetSumWays(int[] nums, int S) {

        int ret =  dp(nums,S,0);
        
        System.out.println(visited);
        
        return ret;
    }
    
    public static int dp(int[] nums, int S, int currIdx) {
    	
//    	try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	System.out.println("Calling dp currIdx "+currIdx+" currNum "+(currIdx<nums.length?nums[currIdx]:"NA")+" S "+S);
        
        
        int resp = 0;
        
        
        if(currIdx == nums.length && S==0) resp = 1;
        else if(currIdx == nums.length && S!=0) resp = 0;
        else if(visited.containsKey(""+currIdx+S)) resp = visited.get(""+currIdx+S);
        else{
        	
            resp = dp(nums, S-nums[currIdx],currIdx+1) + dp(nums, S+nums[currIdx],currIdx+1);
            visited.put(""+currIdx+S,resp);
        }
         
        
        System.out.println("Resp dp currIdx "+currIdx+" S "+S +" resp "+resp);
        return resp;
        
    }
}
