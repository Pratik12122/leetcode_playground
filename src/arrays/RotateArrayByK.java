package arrays;

import java.util.Arrays;

public class RotateArrayByK {

	public static void main(String[] args) {
		RotateArrayByK obj = new RotateArrayByK();

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

		obj.rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

	public void rotate(int[] nums, int k) {
		rotate(nums, 0, nums.length - 1);

		k = k % nums.length;

		rotate(nums, 0, k - 1);
		rotate(nums, k, nums.length - 1);

	}

	void rotate(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = temp;
		}
	}
}
