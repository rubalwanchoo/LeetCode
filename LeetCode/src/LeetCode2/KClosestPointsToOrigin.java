package LeetCode2;

import java.util.PriorityQueue;
import java.util.Comparator;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		
		display2DArray(kClosest(new int[][] {{1,3},{-2,2}},1));

	}
	
	public static int[][] kClosest(int[][] points, int K) {
        
		Comparator<Integer[]> pointComp = new Comparator<Integer[]>() {
			
			@Override
			public int compare(Integer[] p1,Integer[] p2) {
				int p1Dist = p1[0]*p1[0] + p1[1]*p1[1];
				System.out.println("p1Dist "+p1Dist);
				
				int p2Dist = p2[0]*p2[0] + p2[1]*p2[1];
				System.out.println("p2Dist "+p2Dist);
				
				return p1Dist-p2Dist;
			}
		};
		
		
		
		PriorityQueue<Integer[]> pq = new PriorityQueue<>(pointComp);
        int[][] ans = new int[K][2];
        
        for(int i = 0;i<points.length;i++) {
        	
        	pq.add(new Integer[] {points[i][0],points[i][1]});
        }//end for
        
  
        
        for(int j=0;j<K;j++) {
        	
        	Integer[] pqitem = pq.poll();
        	ans[j][0] = pqitem[0];
        	ans[j][1] = pqitem[1];
        }//end for
        
        return ans;
    }
	
	
	public static void display2DArray(int[][] arr){
		
		for(int row = 0;row<arr.length;row++) {
			
			System.out.println(arr[row][0]+","+arr[row][1]);
		}//end for
	}
}
