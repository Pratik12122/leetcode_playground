package sliding_window;

public class MaxConsecutiveOnes {

	// @Link
	// https://leetcode.com/problems/max-consecutive-ones-ii/description/?envType=study-plan-v2&envId=premium-algo-100

	public static void main(String[] args) {
		var obj = new MaxConsecutiveOnes();
		int[] nums = {1,0,1,1,0,1};
		System.out.println(obj.findMaxConsecutiveOnes(nums));
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		int maxOnes = 0;
		int start = 0;
		int k = 1;

		for (int end = 0; end < nums.length; end++) {
			if (nums[end] == 0) {
				if (k == 1) {
					k--;
				} else if (k == 0) {
					while (nums[start] != 0) {
						start++;
					}
					start++;
				}
			}
			maxOnes = Math.max(maxOnes, end - start + 1);
		}

		return maxOnes;
	}
}
