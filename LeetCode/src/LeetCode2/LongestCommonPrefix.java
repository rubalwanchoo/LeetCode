package LeetCode2;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		//System.out.println("answer-"+longestCommonPrefix(new String[]{"flower","flow","flight"}));
		//System.out.println("answer-"+longestCommonPrefix(new String[]{"dog","racecar","car"}));
		//System.out.println("answer-"+longestCommonPrefix(new String[]{"a","ac"}));
		System.out.println("answer-"+longestCommonPrefix(new String[]{"aaa","aa","aaa"}));

	}
	
	 public static String longestCommonPrefix(String[] strs) {
		 
		 
		 String lcp = strs.length>0?strs[0]:"";
		 
		 for(int i=1;i<strs.length;i++) {
			 
			 System.out.println("lcp-"+lcp);
			 
			 if(strs[i].equals("")) return "";
			 
			 for(int j=0;j<strs[i].length();j++) {
				 
				 if(lcp.length()>j && strs[i].charAt(j)==lcp.charAt(j)) {
					 
					 if(j==strs[i].length()-1) {
						 lcp=strs[i];
					 }
					 
					 continue;
				 }else {
					 lcp=lcp.substring(0, j);
					 break;
				 }
				 
				 
				 
				 
				 
			 }//end for
			 
			 
		 }//end for
		 
		 return lcp;
	 }

}
