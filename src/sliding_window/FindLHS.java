package sliding_window;

import java.util.Arrays;

public class FindLHS {
	public static void main(String[] args) {
		// @Link : https://leetcode.com/problems/longest-harmonious-subsequence/
		int nums[] = { 1, 3, 2, 2, 5, 2, 3, 7 };

		System.out.println(new FindLHS().findLHS(nums));
	}

	public int findLHS(int[] nums) {
		if (nums.length == 0)
			return 0;

		Arrays.sort(nums);
		int result = 0;
		int left = 0;
		int right = 1;

		while (right < nums.length) {
			int diff = nums[right] - nums[left];
			if (diff == 1) {
				result = Math.max(result, right - left + 1);
			}

			if (diff <= 1) {
				right++;
			} else {
				left++;
			}
		}

		return result;
	}
}
