package LeetCode;


public class ReverseString {

	public static void main(String args[]) {
		System.out.println(reverseString("RubalWanchoo"));
	}
	
	public static String reverseString(String s) {

       char[] arr = s.toCharArray();
       
       int low=0;
       int hi = s.length()-1;
       
       while(low<hi) {
    	  
    	   
    	   char tmp= arr[hi];
    	   arr[hi]=arr[low];
    	   arr[low]=tmp;
           
           low++;
    	   hi--;
    
       }
	
		
		return new String(arr);
		    
    }
}
