package LeetCode2;

import java.util.Arrays;

public class MergeSortedArray {
	
	/*
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

	Note:

	The number of elements initialized in nums1 and nums2 are m and n respectively.
	You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
	Example:

	Input:
	nums1 = [1,2,3,0,0,0], m = 3
	nums2 = [2,5,6],       n = 3

	Output: [1,2,2,3,5,6]
	
	*/
	
	public static void main(String[] args) {
		//merge(new int[] {1,2,3,0,0,0},3,new int[] {11,13,15},3);
		//merge(new int[] {16,0,0,0,0},1,new int[] {12,13,14,15},1);
		//merge(new int[] {-1,0,0,3,3,3,0,0,0},6,new int[] {1,2,2},3);
		merge(new int[] {4,5,6,0,0,0},3,new int[] {1,2,3},3);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int available = nums1.length - m;
        
		for(int i = 0;i<nums2.length;i++) {//for nums2
			
			System.out.println("available "+available);
			
			if(m>0) {
				for(int j = nums1.length-1;j>-1;j--) {//for nums1
					
					if(available>0 && j<nums1.length-available) {
						
						if(nums2[i]<nums1[j]) {
							System.out.println("c1");
							nums1[j+1] = nums1[j];
							nums1[j] = nums2[i];
							
						}else {
							System.out.println("c2");
							nums1[j+1] = nums2[i];
							
							break;
						}
						
						System.out.println(Arrays.toString(nums1));
						
					}
					
				}//end for j
				
				available--;
				
			}
			else {
				nums1[i] = nums2[i];
			}
			
			System.out.println(Arrays.toString(nums1));
		}//end for i
	
    }

}
