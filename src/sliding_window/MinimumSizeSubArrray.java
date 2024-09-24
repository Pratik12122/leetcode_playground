package sliding_window;

public class MinimumSizeSubArrray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int target = 11;

		System.out.println(minSubArrayLen(target, nums));
	}

	public static int minSubArrayLen(int target, int[] nums) {
		int minDistance = Integer.MAX_VALUE;

		int sum = 0;

		int start = 0;

		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];

			if (sum >= target) {
				while (sum >= target) {
					minDistance = Math.min(minDistance, end - start + 1);
					sum -= nums[start++];
				}

			}
		}

		return minDistance == Integer.MAX_VALUE ? 0 : minDistance;
	}
}
