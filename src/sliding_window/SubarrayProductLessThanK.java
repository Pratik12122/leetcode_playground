package sliding_window;

public class SubarrayProductLessThanK {

	// @Link :
	// https://leetcode.com/problems/subarray-product-less-than-k/description/

	public static void main(String[] args) {
		var obj = new SubarrayProductLessThanK();
		int[] nums = { 1, 1, 1 };
		int k = 1;

		System.out.println(obj.numSubarrayProductLessThanK(nums, k));
	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1)
			return 0;

		int count = 0;

		int windowStart = 0;
		int product = 1;

		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
			product *= nums[windowEnd];

			while(product >= k) {
				product = product / nums[windowStart++];
			}
			
			count += windowEnd - windowStart + 1;

		}

		return count;
	}

	// better one

	int numSubarrayProductLessThanK_2(int[] nums, int k) {
		if (k <= 1)
			return 0;

		int totalCount = 0;
		int product = 1;

		int left = 0;

		for (int right = 0; right < nums.length; right++) {
			product *= nums[right];

			while (product >= k) {
				product /= nums[left++];
			}

			totalCount += right - left + 1;
		}

		return totalCount;

	}
}
