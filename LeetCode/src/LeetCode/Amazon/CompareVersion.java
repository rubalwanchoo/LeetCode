package LeetCode.Amazon;

public class CompareVersion {
	/*
	 	Compare two version numbers version1 and version2.
		If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
		
		You may assume that the version strings are non-empty and contain only digits and the . character.
		The . character does not represent a decimal point and is used to separate number sequences.
		For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
		
		Example 1:
		
		Input: version1 = "0.1", version2 = "1.1"
		Output: -1
		Example 2:
		
		Input: version1 = "1.0.1", version2 = "1"
		Output: 1
		Example 3:
		
		Input: version1 = "7.5.2.4", version2 = "7.5.3"
		Output: -1
	 */
	
	public static void main(String args[]) {
		System.out.println(compareVersion("7.5.2.4","7.5.3"));//-1
		System.out.println(compareVersion("1","1.1"));//-1
	}
	
	public static int compareVersion(String version1, String version2) {
        int returnValue = 0;
        
        String[] v1Tokens = version1.split("\\.");
        String[] v2Tokens = version2.split("\\.");
        
        //get longer length
        int length = v1Tokens.length>v2Tokens.length?v1Tokens.length:v2Tokens.length;
        
        
        int i = 0;
        
        while(i<length) {
        	
        	int v1Int = i>v1Tokens.length-1?0:Integer.parseInt(v1Tokens[i]);
        	int v2Int = i>v2Tokens.length-1?0:Integer.parseInt(v2Tokens[i]);
        	
        	if(v1Int>v2Int) {
        		returnValue = 1;
        		break;
        	}else if(v2Int>v1Int) {
        		returnValue = -1;
        		break;
        	}
        	i++;
        	
        }
        
        return returnValue;
    }

}
