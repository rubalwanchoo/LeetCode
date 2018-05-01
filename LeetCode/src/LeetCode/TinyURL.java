package LeetCode;

import java.util.HashMap;
import java.util.Iterator;

public class TinyURL {

	/*
	 * TinyURL is a URL shortening service where you enter a URL such as 
	 	https://leetcode.com/problems/design-tinyurl and it 
	 	returns a short URL such as http://tinyurl.com/4e9iAk.

		Design the encode and decode methods for the TinyURL service. 
		There is no restriction on how your encode/decode algorithm should work. 
		You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be 
		decoded to the original URL.

	 */
	
	static HashMap<String,String> myMap =new HashMap<String,String>();;
	
	public static void main(String arge[]) {
		
		//System.out.println(encode("https://leetcode.com/problems/design-tinyurl"));
		//System.out.println(decode("http://tinyurl.com/4e9iAk"));
		System.out.println(encode("rubalwanchoo"));
		System.out.println(encode("rubalwanchoo"));
		System.out.println(encode("rubalwanchoo"));
		System.out.println(decode(encode("rubalwanchoo")));


		
	}
	
	// Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        
    	String encodedUrl="";
    	boolean found = false;
    	
    	while(!found) {
    		
    		
    		if(!myMap.containsValue(longUrl)) {
    			encodedUrl = getRandomAlphaNum(6);
    			myMap.put(encodedUrl, longUrl);
    			found = true;
    		}else {
    			Iterator<String> it = myMap.keySet().iterator();
    			
    			while(it.hasNext()) {
    				String nextKey = it.next();
    				String nextValue = myMap.get(nextKey);
    				if(nextValue.equals(longUrl)) {
    					encodedUrl = nextKey;
    					found = true;
    					break;
    				}
    			}
    		}
    	}
    	
        return "http://tinyurl.com/"+encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        
        return myMap.get(shortUrl.substring(19,shortUrl.length()));
    }
    
    
    public static String getRandomAlphaNum(int length) {
    	String returnString="";
    	String allChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";//62
    	
    	
    	int i=0;
    	while(i<length) {
    		
    		int random = (int) (Math.random()*100);
    		
    		if(random<62) {

    			returnString+=String.valueOf(allChars.charAt(random));
    			i++;
    		}
    	}

    	return returnString;
    	
    	
    }
}
