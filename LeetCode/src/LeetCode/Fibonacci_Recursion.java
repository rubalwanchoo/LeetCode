package LeetCode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fibonacci_Recursion {

	//Find 40th fibonacci nubmer
	
	public static void main(String[] args) {
		
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date myDate = new Date();
		
		System.out.println("startDate-"+format.format(myDate));
		System.out.println(fibonacci(45));
		
		
		myDate = new Date();
		System.out.println("endDate-"+format.format(myDate));

	}
	
	public static int fibonacci(int n) {
		//System.out.println("Processing n-"+n);

		if(n==1) {
			return 0;
		}
		if(n==2) {
			return 1; 
		}
		
		return fibonacci(n-1)+fibonacci(n-2);
	}

}
