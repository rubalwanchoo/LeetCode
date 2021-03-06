package LeetCode.fb;



public class FirstBadVersion {
	/*
	 	You are a product manager and currently leading a team to develop a new product. 
	 	Unfortunately, the latest version of your product fails the quality check. 
	 	Since each version is developed based on the previous version, 
	 	all the versions after a bad version are also bad.
		
		Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
		which causes all the following ones to be bad.
		
		You are given an API bool isBadVersion(version) which will return whether version is bad. 
		Implement a function to find the first bad version. You should minimize the number of calls to the API.
		
		Example:
		
		Given n = 5
		
		call isBadVersion(3) -> false
		call isBadVersion(5) -> true
		call isBadVersion(4) -> true
		
		Then 4 is the first bad version. 
	 */
	
	
	public static void main(String args[]){
		
		
		System.out.println(firstBadVersion(2126753390));
		
		
	}
	
	public static int firstBadVersion(int n) {
		 
        return getBadVersion(1,n);
        
        
    }
    
    public static int getBadVersion(int startIdx, int endIdx){
        
        System.out.println("startIdx "+startIdx+", endIdx "+endIdx);
        
        int currIdx = startIdx+(endIdx-startIdx)/2;
        if(isBadVersion(currIdx) && !isBadVersion(currIdx-1)) {
        	return currIdx;
        }else if(!isBadVersion(currIdx)) {
        	return getBadVersion(currIdx+1,endIdx);
        }else {
        	return getBadVersion(startIdx,currIdx-1);
        }
    }
    
    public static boolean isBadVersion(int n) {
    	return n>=1702766719?true:false;
    }
    
    

}
