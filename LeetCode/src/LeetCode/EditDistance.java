package LeetCode;

public class EditDistance {

	/*
	  
	 	(https://www.youtube.com/watch?v=We3YDTzNXEk)
	  
	 	Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
	
		You have the following 3 operations permitted on a word:
		
		    Insert a character
		    Delete a character
		    Replace a character
		
		
		Example 1:
		
		Input: word1 = "horse", word2 = "ros"
		Output: 3
		Explanation: 
		horse -> rorse (replace 'h' with 'r')
		rorse -> rose (remove 'r')
		rose -> ros (remove 'e')
		
		Example 2:
		
		Input: word1 = "intention", word2 = "execution"
		Output: 5
		Explanation: 
		intention -> inention (remove 't')
		inention -> enention (replace 'i' with 'e')
		enention -> exention (replace 'n' with 'x')
		exention -> exection (replace 'n' with 'c')
		exection -> execution (insert 'u')

	 */
	
	public static void main(String[] args) {

		//System.out.println(minDistance("horse","ros"));
		System.out.println(minDistance("abcdef","azced"));
	}
	
	
	public static int minDistance(String word1, String word2) {
		//Make word1 into word 2
        int count = 0;
        
        int[][] T = new int[word2.length()+1][word1.length()+1];
        
        
        T[0][0] = 0;
        
        for(int i = 1;i<T.length;i++){
        	T[i][0] = i;
        }
        for(int j = 1;j<T[0].length;j++){
        	T[0][j] = j;
        }
        
        for(int i = 1;i<T.length;i++){
        	for(int j=1;j<T[0].length;j++){
        		
        		
        		if(word1.charAt(j-1)==word2.charAt(i-1)){
        			T[i][j] = T[i-1][j-1];
        		}
        		else{
        			T[i][j] = Math.min(T[i-1][j],Math.min(T[i][j-1], T[i-1][j-1]))+1;
        			
        		}
        		
        	}//end loop j
        }//end loop i
        
        display2DArray(T);
        
        count = T[word2.length()][word1.length()];
        
		return count;
		
    }
	
	
	public static void display2DArray(int[][] T){
		
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				System.out.print(T[i][j]+" ");

			}
			System.out.println();
		}
	}

}
