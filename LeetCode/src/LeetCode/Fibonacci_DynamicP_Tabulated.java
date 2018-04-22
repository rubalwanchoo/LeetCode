package LeetCode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fibonacci_DynamicP_Tabulated {
	//Calculate all subproblems first.

	public static void main(String[] args) {
		
		int n = 45;

		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date myDate = new Date();
		
		System.out.println("startDate-"+format.format(myDate));
		System.out.println(fibonacci(45));

		myDate = new Date();
		System.out.println("endDate-"+format.format(myDate));


	}
	
	
	public static int fibonacci(int n) {
		
		int[] f = new int[n];
		
		f[0]=0;f[1]=1;
		for(int i=2;i<n;i++) {
			f[i] = f[i-1]+f[i-2]; 
		}
		
		
		return f[n-1];
	}
}
