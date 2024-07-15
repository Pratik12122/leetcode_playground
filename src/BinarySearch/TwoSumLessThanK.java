package BinarySearch;

import java.util.Arrays;

public class TwoSumLessThanK {

	public static void main(String[] args) {
		int nums[] = { 254, 914, 110, 900, 147, 441, 209, 122, 571, 942, 136, 350, 160, 127, 178, 839, 201, 386, 462,
				45, 735, 467, 153, 415, 875, 282, 204, 534, 639, 994, 284, 320, 865, 468, 1, 838, 275, 370, 295, 574,
				309, 268, 415, 385, 786, 62, 359, 78, 854, 944 };
		int sum = 200;

		System.out.println(twoSumLessThanK(nums, sum));
	}

	public static int twoSumLessThanK(int[] nums, int k) {
		Arrays.sort(nums);

		int left = 0;
		int right = nums.length - 1;
		int sum = -1;

		while (left < right) {
			int totalSum = nums[left] + nums[right];

			if (totalSum == k) {
				return k;
			} else if (totalSum > k) {
				right--;
			} else {
				sum = Math.max(totalSum, sum);
				left++;
			}
		}

		return sum;
	}

}
