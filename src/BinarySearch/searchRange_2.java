package BinarySearch;

import java.util.Arrays;

public class searchRange_2 {
	public static void main(String[] args) {
		int[] nums = { 2, 2 };
		int target = 1;

		System.out.println(Arrays.toString(searchRange(nums, target)));
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };

		if (nums.length == 0)
			return result;

		if (nums.length == 1) {
			if (nums[0] == target) {
				int[] res = { 0, 0 };
				return res;
			} else {
				return result;
			}

		}

		int n = nums.length;
		int left = 0;
		int right = n - 1;
		int leftBoundary = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				leftBoundary = mid;
			}
			if (nums[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (leftBoundary == -1) {
			return result;
		}
		
		int rightBoundary = -1;
		left = leftBoundary;
		right = n - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				rightBoundary = mid;
			}

			if (nums[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		result[0] = leftBoundary;
		result[1] = rightBoundary;
		return result;
	}
}
