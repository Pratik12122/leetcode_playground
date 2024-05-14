package BinarySearch.rotate;

// @Link : https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=binary-search
public class SearchInRoatedArray {

	public static void main(String[] args) {

	}

	public int search(int[] nums, int target) {
		int left = 0;
		int n = nums.length;
		int right = n - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[left] <= nums[mid]) {
				if (target >= nums[left] && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target > nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}
}
