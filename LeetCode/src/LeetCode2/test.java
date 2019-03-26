package LeetCode2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.*;


public class test {

	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(2);
		
		cache.put(1, 1);
		cache.put(2, 2);
		
		cache.get(1);
		
		
		cache.put(3, 3);
		/*
		cache.get(2);
		
		cache.put(4, 4);
		
		cache.get(1);
		cache.get(3);
		cache.get(4);
		*/
		
	}

}
