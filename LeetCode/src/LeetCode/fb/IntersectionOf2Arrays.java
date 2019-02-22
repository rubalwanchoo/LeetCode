package LeetCode.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IntersectionOf2Arrays {
	/*
	Given two arrays, write a function to compute their intersection.

	Example:
	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

	Note:
	Each element in the result should appear as many times as it shows in both arrays.
	The result can be in any order.
	Follow up:
	What if the given array is already sorted? How would you optimize your algorithm?
	What if nums1's size is small compared to nums2's size? Which algorithm is better?
	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
	 */
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersect(new int[] {1,1,2,3,4,5},new int[] {2,4})));
		
		
		//1,1,2,3,4,5  b
		//2,4  a
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
        
		int[] a = null; //smaller array
		int[] b = null; //larger array
		ArrayList<Integer> result = new ArrayList<>();
		
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		if(nums1.length<=nums2.length) {a= nums1; b= nums2;}
		else {a=nums2; b= nums1;}
		
		int p1 = 0; //for a
		int p2 = 0; //for b


		
		while(p2<b.length && p1<a.length) {
			System.out.println("comparing a["+p1+"] "+a[p1]+" and b["+p2+"] "+b[p2]);
			
			if(a[p1] == b[p2]) {
				result.add(a[p1]);
				p1++;
				p2++;
				
			}
			else if(a[p1]<b[p2]) {
				p1++;
			}
			else if(a[p1]>b[p2]) {
				p2++;
			}
		}
		

		return convertToIntArray(result);
    }
	
	public static int[] convertToIntArray(ArrayList<Integer> arrList) {
		
		int[] result = new int[arrList.size()];
		Iterator<Integer> it = arrList.iterator();
		
		for(int i = 0;i<result.length;i++) {
			result[i] = it.next();
		}
		
		return result;
	}

}
