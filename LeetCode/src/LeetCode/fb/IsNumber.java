package LeetCode.fb;

public class IsNumber {

	public static void main(String[] args) {
		System.out.println(isNumber("e9"));
		System.out.println(isNumber("abc"));
		System.out.println(isNumber("2e9"));
		System.out.println(isNumber("."));
		System.out.println(isNumber("1 "));
		System.out.println(isNumber(" "));

	}
	
	
	public static boolean isNumber(String s) {
        
        
        char[] charArr = s.trim().toCharArray();
        
        if(charArr.length==0) return false;
        
        for(int i = 0;i<charArr.length;i++){
            if(
            	!((int)charArr[i]>=48 && (int)charArr[i]<=57)//numbers
            	||
                ((int)charArr[i]>=65 && (int)charArr[i]<=90)//uppercase alpha
                ||
                ((int)charArr[i]>=97 && (int)charArr[i]<=122)//lowercase alpha
            ){
                
                if((int)charArr[i]==101 && i>0 && !((int)charArr[i-1]>=48 && (int)charArr[i-1]<=57)) return false;
                else if ((int)charArr[i]==101 && i==0) return false;
                else if((int)charArr[i]!=101) return false;

                
            }
            
            
                
        }
        
        return true;
    }

}
