package BinarySearch;

public class FindFirstAndLastIndex {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		int k = 8;
		
		System.out.println(new FindFirstAndLastIndex().searchRange(nums, k));
	}

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];

		int leftIndex = findLeft(nums, target);
		int rightIndex = findRight(nums, target);

		result[0] = leftIndex;
		result[1] = rightIndex;

		return result;
	}

	int findLeft(int nums[], int target) {
		int l = 0;
		int r = nums.length - 1;
		int leftIndex = -1;

		while (l <= r) {
			int mid = (l + r)/ 2;

			if (nums[mid] == target) {
				leftIndex = mid;
				r = mid - 1;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return leftIndex;
	}

	int findRight(int nums[], int target) {
		int l = 0;
		int r = nums.length - 1;
		int rightIndex = -1;

		while (l <= r) {
			int mid = (l + r)/ 2;

			if (nums[mid] == target) {
				rightIndex = mid;
				l = mid + 1;
			} else if (nums[mid] < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return rightIndex;
	}
}
