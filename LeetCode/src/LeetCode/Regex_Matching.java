package LeetCode;

public class Regex_Matching {

	public static void main(String[] args) {
		
		//System.out.println(isMatch("xaabyc".toCharArray(),"xa*b.c".toCharArray()));
		System.out.println(isMatch("aab".toCharArray(),"c*a*b".toCharArray()));

	}
	
	public static boolean isMatch(char[] s, char[] p) {
		
		boolean[][] T = new boolean[s.length+1][p.length+1];
		
		T[0][0] = true;
		
		
		for(int j=1;j<T[0].length;j++){//condition 4
			//Run through the first row of pattern, if a * is found, the match state for that would be similar to the match
			//state for pattern 2 chars behind, as there is no row above it to go through the || condition - condition3
			if(p[j-1]=='*'){
				T[0][j] = T[0][j-2];
			}
			
		}
		
		
		
		
		for(int i = 1;i<T.length;i++) {
			for(int j=1;j<T[0].length;j++) {
				
				if(s[i-1] == p[j-1] || p[j-1] == '.'){//condition 1
					//if current schar matches current pchar , then isMatch result is same as what was the
					//state of previous schar and pchar match, the substring without current schar/pchar should
					//also be a match
					T[i][j] = T[i-1][j-1];
				}
				
				else if(p[j-1] == '*'){//condition 2
					//if pchar is a *, then assuming zero occurences of the char behind pchar, check if 2chars 
					//behind the * is also a match with schar
					T[i][j] = T[i][j-2];
					
					if(s[i-1]==p[j-2]||p[j-2]=='.'){//condition 3
						//if previous char behind pchar (*) is a match with schar, then check the state of string without
						//the schar and current pattern with pchar
						T[i][j] = T[i][j]||T[i-1][j];
					}
				}
				else{
					T[i][j] = false;
				}
				
				
			}//end for j
		}//end for i
		
		
		display2DArray(T);
		
		
		
		return T[s.length][p.length];
		
	}
	
	public static void display2DArray(boolean[][] T){
		
		for(int i=0;i<T.length;i++){
			for(int j=0;j<T[0].length;j++){
				if(T[i][j]){
					System.out.print("T ");
				}else{
					System.out.print("F ");
				}
					
				
				
			}
			System.out.println();
		}
	}
	
	
	

}
