package BinarySearch;

public class CountNegatives {
	public static void main(String[] args) {
		int[][] nums = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		System.out.println(countNegatives(nums));
	}

	public static int countNegatives(int[][] nums) {
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			int left = 0;
			int right = nums[i].length - 1;

			while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[i][mid] < 0) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			count += nums[i].length - left;
		}

		return count;
	}
}
