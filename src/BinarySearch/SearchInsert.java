package BinarySearch;

public class SearchInsert {

	public static void main(String[] args) {
		int[] nums = { -2, -1, -1};
		int target = 0;

		System.out.println(searchInsert(nums, target));
	}

	public static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int n = nums.length;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if(nums[mid] > target) {
				left = mid + 1;
			} else {
				right = mid -1;
			}
		}

		return n-left;

	}
}
