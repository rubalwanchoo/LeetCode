package LeetCode;

public class Regex_Matching {

	public static void main(String[] args) {
		
		System.out.println(isMatch("aab".toCharArray(),"c*a*b".toCharArray()));

	}
	
	public static boolean isMatch(char[] s, char[] p) {
		
		boolean[][] T = new boolean[s.length()+1][p.length()+1];
		
		T[0][0] = true;
		
		for(int i = 1;i<T.length;i++) {
			for(int j=1;j<T[0].length;j++) {
				
				if(s.charAt(i)==)
				
				
			}
		}
		
		
		
		
		return T[s.length()][p.length()];
		
	}
	
	

}
