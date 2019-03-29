package LeetCode2;

import java. util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class LongestWordInDict {
	
	

	//https://leetcode.com/problems/longest-word-in-dictionary/
	
	class TrieNode{
		boolean isWord;
		Map<String,TrieNode> children;
		
		public TrieNode(){
			isWord = false;
			children = new HashMap<String,TrieNode>();
		}
		
	}//end TrieNode
	
	class Trie{
		
		TrieNode root;
		
		public Trie(){
			root = new TrieNode();
		}
		
		public void insert(String word){
			
			TrieNode currentNode = root;
			TrieNode child = null;
			
			for(int level=0;level<word.length();level++){
								
				String currChar = String.valueOf(word.charAt(level));
				System.out.println("inserting "+currChar);
				
				if(!currentNode.children.containsKey(currChar))
				{
					child = new TrieNode();
					currentNode.children.put(currChar, child);
				}
				
				if(level==word.length()-1){
					child.isWord = true;
				}
				else{
					currentNode = currentNode.children.get(currChar);
				}
				
				
				}
		}//end insert
		
		public void printTrieInOrder(TrieNode root){
			
			for(Map.Entry<String, TrieNode> child:root.children.entrySet()){
				
				System.out.println(child.getKey()+"-"+child.getValue().isWord);
				
				printTrieInOrder(child.getValue());
			}
			
			
		}
		
		public void printTrie(){
			printTrieInOrder(root);
		}
	}//end Trie
	
	
	public String longestWord(String[] words) {
		
		Trie myT = new LongestWordInDict().new Trie();
		
		for(int i = 0;i<words.length;i++){
			myT.insert(words[i]);
		}
		
		
	}
	
	public static void main(String[] args){
		
		Trie myT = new LongestWordInDict().new Trie();
		
		myT.insert("rub");
		myT.insert("rug");
		myT.insert("ram");
		myT.insert("ran");
		myT.printTrie();
		
	}
	
}
