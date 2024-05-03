package two_pointers;

import java.util.HashMap;
import java.util.TreeMap;

public class TrappingRainWater {

	// Link : https://leetcode.com/problems/trapping-rain-water/description/
	public static void main(String[] args) {
//		System.out.println(trap(null));
//		
//		int[] arr1 = { 1 };
//		System.out.println(trap(arr1));
//		
//		int[] arr2 = { 1, 2 };
//		System.out.println(trap(arr2));
//
//		int[] arr3 = { 1, 1, 3 };
//		System.out.println(trap(arr3));
//
		int[] arr4 = { 0, 0, 0,0,0,1,0,1 };
		//System.out.println(trap(arr4));

//		int[] arr5 = { 3, 2, 2, 5 };
//		System.out.println(trap(arr5));
//
//		int[] arr6 = { 5, 2, 2, 3 };
//		System.out.println(trap(arr6));
		
//		int[] arr7 = {0,1,0,2,1,0,1,3,2,1,2,1};
//		System.out.println(trap(arr7));
		
		String s = "";
		
		int[] arr8 = {5,4,1,2};
		//System.out.println(trap(arr8));
		
		int[] arr9 = {4,2,0,3,2,5};
		System.out.println(trap(arr9));
	}

	// using extra space 
	public static int trap(int[] height) {
		int sum = 0;
        int[] left = new int[height.length]; 
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length-1] = height[height.length-1];

        for(int i=1;i< height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        for(int j=height.length-2 ;j>=0;j--) {
        	right[j] = Math.max(height[j], right[j+1]);
        }


        for(int i=0; i<height.length; i++) {
            sum+= Math.min(left[i], right[i]) - height[i];
        }


        return sum;
	}

	// no extra space 
	public static int trap1(int[] height) {
		int water =0;
		
		if(height.length == 0) {
			return water;
		}
		
		int left=0, right = height.length -1;
		
		int leftMax = height[left];
		int rightMax = height[right];
		
		
		while(left < right) {
			if(leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, height[left]);
				water += leftMax - height[left];
			} else {
				right--;
				rightMax = Math.max(rightMax, height[right]);
				water += rightMax - height[right];
			}
		}
		
		return water;
	}
	

}
