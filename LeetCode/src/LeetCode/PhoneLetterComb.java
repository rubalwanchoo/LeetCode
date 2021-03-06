package LeetCode;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneLetterComb {
	
	/*
	 Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

		A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
	
		Example:
		
		Input: "23"
		Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
		Note:
		
		Although the above answer is in lexicographical order, your answer could be in any order you want.
	 */
	
	
	public static void main(String args[]) {
		//displayList(letterCombinations("23"));
		displayList(letterCombinations("2"));
		//displayList(letterCombinations("22"));
	}
	
	public static List<String> letterCombinations(String digits) {
		
		List<String> myList = new ArrayList<String>();
		
		HashMap<Integer,String[]> map1 = new HashMap<Integer,String[]>();
		
		map1=initializeMap1(map1);
		
		
		for(int i =0;i<digits.length();i++){//go through each digit

			String[] digitsAlphabets = map1.get(Integer.parseInt(String.valueOf(digits.charAt(i))));

			//displayList(Arrays.asList(digitsAlphabets));
			
			//displayList(Arrays.asList(digitsAlphabets));
			myList = combine(myList,Arrays.asList(digitsAlphabets));
			//displayList(myList);
		}

		
		return myList;
        
    }
	
	
	public static List<String> combine(List<String> myList,List<String> alphaList){
		
		List<String> returnList = new ArrayList<String>();
		
		if(myList.size()==0){
			for(int i=0;i<alphaList.size();i++){
				
				returnList.add((String)alphaList.toArray()[i]);

			}
		}else{
			
			for(int i=0;i<alphaList.size();i++){
				for(int j=0;j<myList.size();j++){
					
					//System.out.println("i-"+i+",j-"+j);
					returnList.add((String)myList.toArray()[j]+(String)alphaList.toArray()[i]);

				}
			}

		}

				
			
		
		return returnList;
	}
	
	public static HashMap<Integer,String[]> initializeMap1(HashMap<Integer,String[]> myMap1){
		
		myMap1.put(2,new String[]{"a","b","c"});
		myMap1.put(3,new String[]{"d","e","f"});
		myMap1.put(4,new String[]{"g","h","i"});
		myMap1.put(5,new String[]{"j","k","l"});
		myMap1.put(6,new String[]{"m","n","o"});
		myMap1.put(7,new String[]{"p","q","r","s"});
		myMap1.put(8,new String[]{"t","u","v"});
		myMap1.put(9,new String[]{"w","x","y","z"});
		
		
		return myMap1;
	}
	
	public static void displayList(List<String> myList) {
		
		Iterator<String> it = myList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		System.out.println();
	}
}
