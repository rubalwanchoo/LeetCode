package LeetCode2;

import java.util.LinkedList;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		
		System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0},2));
		System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
		System.out.println(longestOnes(new int[] {0,0,1,1,1,0,0},0));
	}
	
    public static int longestOnes(int[] A, int K) {

    	LinkedList<Integer> ll = new LinkedList<>();
        int maxLength = Integer.MIN_VALUE;
        int start = 0;
        
        
        for(int i=0;i<A.length;i++) {
        	
        	if(A[i]==0) {
        		ll.add(i);//store the index of zero
        		
        		if(ll.size()>K) {
        			start = ll.removeFirst()+1;
        		}
        	}
        	
        	maxLength = Math.max(maxLength,i-start+1);
        	
        	
        }
        
            
        return maxLength;  
        
    }

}
