package LeetCode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fibonacci_DynamicP_Memoization {

	public static void main(String[] args) {
		int n = 45;
		
		Integer[] memo = new Integer[n];
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date myDate = new Date();
		
		System.out.println("startDate-"+format.format(myDate));
		System.out.println(fibonacci(45,memo));

		myDate = new Date();
		System.out.println("endDate-"+format.format(myDate));


	}
	
	public static int fibonacci(int n,Integer[] memo) {
		
		
		if(memo[n-1]!=null) {
			return memo[n-1];
		}

		if(n==1) {
			memo[n-1] = 0;
			return 0;
		}
		if(n==2) {
			memo[n-1] = 1;
			return 1; 
		}
		
		memo[n-1]= fibonacci(n-1,memo)+fibonacci(n-2,memo);
		
		System.out.println("Evaluating n-"+n+", result-"+memo[n-1]);
		return memo[n-1];
	}

}
