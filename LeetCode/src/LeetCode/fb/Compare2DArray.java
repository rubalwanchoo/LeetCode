package LeetCode.fb;

import java.util.Arrays;
import java.util.Comparator;

public class Compare2DArray {

	public static void main(String[] args) {
		
		
		Integer[][] arr = new Integer[2][2];
		
		arr[0][0] = 5;
		arr[0][1] = 4;
		arr[1][0] = 3;
		arr[1][1] = 6;

		Arrays.sort(arr, new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] a1, Integer[] a2) {
				
				if(a1[0]>a2[0]) return 1;
				else if(a1[0]<a2[0]) return -1;
				else return 0;
			}
			
		});
		
		
		
		System.out.println(arr[0][0] + " " + arr[1][0]);
	}

}
