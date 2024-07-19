package sliding_window;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxFrequency {

	// @Link: https://leetcode.com/problems/frequency-of-the-most-frequent-element/
	public static void main(String[] args) {
		var obj = new MaxFrequency();
		int[] nums = { 9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990,
				9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000,
				9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981,
				9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926,
				9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946,
				9966 };
		
		int[] nums1 = {3,9,6};
		int k = 2;

		System.out.println(obj.maxFrequency1(nums1, k));
	}

	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int maxFrq = 1;
		int left = 0;
		int windowSum = 0;
		int score = 0;

		for (int right = 0; right < nums.length; right++) {
			windowSum += nums[right];
			score = nums[right] * (right - left + 1);

			while (score - windowSum > k) {
				windowSum -= nums[left++];
				score = nums[right] * (right - left + 1);
			}

			maxFrq = Math.max(maxFrq, (right - left + 1));

		}

		return maxFrq;
	}
	
	
	public static int maxFrequency1(int[] nums, int k) {
		int start = 0;
		int windowSum = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

		int maxSize = 1;

		for (int end = 0; end < nums.length; end++) {
			windowSum += nums[end];
			maxHeap.offer(nums[end]);
			int total = ((end - start) + 1) * maxHeap.peek();

			while (total > windowSum + k) {
				windowSum -= nums[start];
				maxHeap.remove(nums[start++]);
				total = (end - start) + 1 * maxHeap.peek();
			}
			maxSize = Math.max(maxSize, end - start + 1);
		}

		return maxSize;
	}
}
