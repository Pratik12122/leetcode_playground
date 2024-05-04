package BinarySearch;

import java.util.Arrays;

public class SearchRange {

	// @Link :
	// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/

	public static void main(String[] args) {
		int[] nums = { 1 };
		int target = 1;

		System.out.println(Arrays.toString(new SearchRange().searchRange(nums, target)));

	}

	public int[] searchRange(int[] nums, int target) {
		int result[] = { -1, -1 };
		if (result.length == 0)
			return result;

		int left = 0;
		int right = nums.length - 1;

		int firstElementIndex = binarySearch(nums, target, left, right);

		System.out.println("firstElementIndex : " + firstElementIndex);

		if (firstElementIndex == -1) {
			return result;
		} else {
			left = findLeft(nums, target, left, firstElementIndex - 1);
			right = findRight(nums, target, firstElementIndex + 1, right);

			System.out.println("min left Index: " + left + " Max right Index : " + right);

			if (left == -1 && right == -1) {
				return result;
			}

			left = left == -1 ? firstElementIndex : Math.min(left, firstElementIndex);
			right = right == -1 ? firstElementIndex : Math.max(right, firstElementIndex);

			return new int[] { left, right };

		}

	}

	private int findRight(int[] nums, int target, int left, int right) {
		if (right < nums.length) {
			int mid = binarySearch(nums, target, left, right);
			if (mid == -1) {
				return -1;
			} else {
				return Math.max(mid, findRight(nums, target, mid + 1, right));
			}
		}
		return -1;
	}

	private int findLeft(int[] nums, int target, int left, int right) {
		if (left >= 0) {
			int mid = binarySearch(nums, target, left, right);
			if (mid == -1) {
				return Integer.MAX_VALUE;
			} else {
				return Math.min(mid, findLeft(nums, target, left, mid - 1));
			}
		}
		return -1;
	}

	int binarySearch(int[] nums, int target, int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
