package BinarySearch;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		System.out.println(nums[findPeakElement(nums)]);
	}

	public static int findPeakElement(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (nums[mid] > nums[mid + 1])
				r = mid;
			else
				l = mid + 1;
		}
		return l;
	}
}
