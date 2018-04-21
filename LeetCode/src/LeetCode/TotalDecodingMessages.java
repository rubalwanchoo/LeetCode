package LeetCode;

import java.util.Map;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TotalDecodingMessages {

	/*
	  A top secret message containing letters from A-Z is being encoded to numbers using the following mapping:

		'A' -> 1
		'B' -> 2
		...
		'Z' -> 26
		You are an FBI agent. You have to determine the total number of ways that message can be decoded.
		Note: An empty digit sequence is considered to have one decoding. 
		It may be assumed that the input contains valid digits from 0 to 9 and 
		If there are leading 0’s, extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.
		
		Example :
		Given encoded message "123",  it could be decoded as "ABC" (1 2 3) or "LC" (12 3) or "AW"(1 23).
		So total ways are 3.
		
		Input:
		First line contains the test cases T.  1<=T<=1000
		Each test case have two lines
		First is length of string N.  1<=N<=40
		Second line is string S of digits from '0' to '9' of N length.
		
		Example:
		Input:
		2
		3
		123
		4
		2563
		Output:
		3
		2
	 */
	
	public static void main(String[] args) throws IOException{
		
		/*
		//Create decodeMap
		Map<Integer,String> decodeMap = new HashMap<Integer,String>();
		decodeMap = createDecodeMap();
		//End decodeMap
		*/
		
		//Process Input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String noOfTestCases = reader.readLine();
		String[] lengthArray = new String[Integer.parseInt(noOfTestCases)];
		String[] encodedDigitString = new String[Integer.parseInt(noOfTestCases)];
		
		
		for(int i=0;i<Integer.parseInt(noOfTestCases);i++) {
			String line2 = reader.readLine();
			lengthArray[i] = line2;
			
			String line3 = reader.readLine();
			encodedDigitString[i] = line3;
			
			//System.out.println("Number of decodedCount-"+getDecodeCount(encodedDigitString[i],Integer.parseInt(lengthArray[i])));
			System.out.println(getDecodeCount(encodedDigitString[i],Integer.parseInt(lengthArray[i])));
			
		}			
		// End Process Input
		
		
	}
	
	
	public static int getDecodeCount(String encodedString,Integer length) {
		//encodedString - 1212134, length - 7
		
		int count = 0;
		
		for(int i = 1;i<length;i++) {
			
			
			int num = Integer.parseInt(String.valueOf(encodedString.charAt(i-1)))*10 + Integer.parseInt(String.valueOf(encodedString.charAt(i)));
			//System.out.println("char at i-1-"+encodedString.charAt(i-1)+" char at i-"+encodedString.charAt(i)+" num-"+num);
			if(num<=27 && num>0) {
				count++;
			}
		}
		
		
		return count+1;
		
	}
	
	
	
	
	public static Map<Integer,String> createDecodeMap(){
		
		Map<Integer,String> decodeMap = new HashMap<Integer,String>();
		
		Integer i= 1;
		for(char alphabet = 'A';alphabet<='Z';alphabet++) {
			decodeMap.put(i, String.valueOf(alphabet));
			i++;
		}
		
		return decodeMap;
	}

}
