package LeetCode;

public class MedianSortedArray {
	//https://www.youtube.com/watch?v=LPFhl65R7ww
	
	
	/*
	 	There are two sorted arrays nums1 and nums2 of size m and n respectively.
		Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
		
		Example 1:
		nums1 = [1, 3]
		nums2 = [2]
		The median is 2.0
		
		Example 2:
		nums1 = [1, 2]
		nums2 = [3, 4]
		The median is (2 + 3)/2 = 2.5

	 */

	public static void main(String[] args) {
		
		System.out.println(findMedianSortedArrays(new int[]{},new int[] {1,2}));

	}
	
	

	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		double median = 0;
		int[] x;
		int[] y;
		int xLength = 0;
		int yLength = 0;
		double maxLeftX,minRightX,maxLeftY,minRightY;
		boolean found = false;
		
		//Dedicate x as smaller array, y as larger array
		if(nums1.length<=nums2.length) 
			{x=nums1;y=nums2;} 
		else 
			{y=nums1;x=nums2;}
		
		xLength = x.length;
		yLength = y.length;
		
		
		//Return when either smaller array has no elements
		if(xLength == 0) {
			if(yLength%2 == 0) {//y is even
				median = ((double)y[yLength/2] + (double)y[yLength/2 - 1])/2;
			}
			else {
				median = (double)y[(yLength-1)/2];
			}
			
			//System.out.println("median-"+median);
			return median;
		}
		
		
		
		
		int startX = 0;
		int endX = xLength-1;		
		int partitionX = (endX+startX)/2;
		//System.out.println("partitionX-"+partitionX);
		
		while(!found) {
			
			int partitionY = (xLength + yLength +1)/2 - partitionX;
			//System.out.println("partitionY-"+partitionY);
			
			if(partitionX == 0) { 
				maxLeftX = Double.NEGATIVE_INFINITY;
				minRightX = x[partitionX];
			}
			else if(partitionX >= x.length) {
				maxLeftX = x[partitionX-1];
				minRightX = Double.POSITIVE_INFINITY;
			}
			else {
				maxLeftX = x[partitionX-1];
				minRightX = x[partitionX];
			}
			
			//System.out.println("maxLeftX-"+maxLeftX);
			//System.out.println("minRightX-"+minRightX);
			
			
			if(partitionY == 0) { 
				maxLeftY = Double.NEGATIVE_INFINITY;
				minRightY = y[partitionY];
			}
			else if(partitionY >= yLength) {
				maxLeftY = y[partitionY-1];
				minRightY = Double.POSITIVE_INFINITY;
			}
			else {
				maxLeftY = y[partitionY-1];
				minRightY = y[partitionY];
			}
			//System.out.println("maxLeftY-"+maxLeftY);
			//System.out.println("minRightY-"+minRightY);

			
			if(maxLeftX<=minRightY && maxLeftY<=minRightX) {
				found = true;
			}
			else if(maxLeftX>minRightY){
				partitionX--;
				System.out.println("partitionX-"+partitionX);
			}
			else {
				partitionX++;
				//System.out.println("partitionX-"+partitionX);
			}
			
			if(found) {
				if((xLength+yLength)%2 == 0) {//total items even
					median = (Math.max(maxLeftX,maxLeftY) + Math.min(minRightX,minRightY))/2;
				}
				else {//total items odd
					median = Math.max(maxLeftX, maxLeftY);
				}
				//System.out.println("median-"+median);
			}
			
		}
		      
		
		return median;
    }

}
