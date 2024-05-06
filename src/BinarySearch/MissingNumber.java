package BinarySearch;

public class MissingNumber {
	public static void main(String[] args) {
		int[] nums = { 0,0,0,0,0 };

		System.out.println(missingNumber(nums));
	}

	public static int missingNumber(int[] nums) {
		int length = nums.length - 1;
		int diff = (nums[length] - nums[0]) / nums.length;
		boolean isAsc = diff > 0;
		int index = 1;

		while (index < nums.length) {
			int number = nums[index - 1] + diff;
			if (binarySearch(nums, number, 0, length, isAsc) == -1) {
				return number;
			}
			index++;
		}
		return nums[nums.length-1];
	}

	static int binarySearch(int[] nums, int target, int left, int right, boolean isAsc) {
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (isAsc) {
				if (nums[mid] < target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				// 5 3 2 1 0
				if (nums[mid] > target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
