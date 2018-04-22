package LeetCode;

import java.util.Map;
import java.util.HashMap;

public class Knapsack_Problem {

	/*
	 	https://www.youtube.com/watch?v=8LusJS5-AGo
	 	
	 	How to fill a sack with max value of items but not exceeding the weight of the bag.
		0/1 means, the item cannot be split.

	*/
	
	public static void main(String[] args) {
		
		int totalWeight = 7;
		
		Map<Integer,Integer> items = new HashMap<Integer,Integer>();
		
		items.put(1, 1);
		items.put(3, 4);
		items.put(4, 5);
		items.put(5, 7);
		
		
		
		
		System.out.println(knapsackMaxValue(totalWeight,items));
	}
	
	
	public static int knapsackMaxValue(int totalWeight, Map items){
		int maxValue=-1;
		
		Object[] weights = items.keySet().toArray();
		
		int[][] T = new int[weights.length][totalWeight+1];
		//2d grid created for same number of rows as weights. No row for 0 weight.
		
		for(int i=0;i<T.length;i++){
			
			
			//With weight as 0, the best value any item can do is to keep the weight 0 in the knapsack
			T[i][0] = 0;
		}
		
		for(int j=1;j<T[0].length;j++){
			
			if((int)weights[0]<=j){
				T[0][j] = (int)items.get(weights[0]);
			}
			else{
				T[0][j] = T[0][j-1];
			}
		}
		
		
		for(int i=1;i<T.length;i++){
			for(int j=1;j<T[0].length;j++){
				System.out.println("Comparing weight "+(int)weights[i]+" and weight "+j);
				
				if((int)weights[i]<=j){
					
					T[i][j] = Math.max((int)items.get(weights[i])+T[i-1][j-(int)weights[i]],T[i-1][j]);
					//Max of current weights value + remaining weights BEST value OR do not consider the current weight/best value of previous weight
					
					System.out.println("condition1 "+ T[i][j]);
				}
				else{
					
					T[i][j] = T[i-1][j];
					System.out.println("condition2"+ T[i][j]);
					
				}
			}//end loop j
		}//end loop i
		
		
		display2DArray(T);
		
		maxValue = T[weights.length-1][totalWeight];
		
		return maxValue;
		
	}
	
	
	public static void display2DArray(int[][] T){
		
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				System.out.print(T[i][j]+" ");

			}
			System.out.println();
		}
	}

}
