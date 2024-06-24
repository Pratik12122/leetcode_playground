package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

// Link: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class FindKthLargestElement {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;

		new Solution().findKthLargest(nums, k);
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		for (int num : nums) {
			minHeap.offer(num);

			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		return minHeap.peek();
	}
}

class Solution {
	public int findKthLargest(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			list.add(num);
		}

		return quickSelect(list, k);
	}

	public int quickSelect(List<Integer> nums, int k) {
		int pivotIndex = new Random().nextInt(nums.size());
		int pivot = nums.get(pivotIndex);

		List<Integer> left = new ArrayList<>();
		List<Integer> mid = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		for (int num : nums) {
			if (num > pivot) {
				left.add(num);
			} else if (num < pivot) {
				right.add(num);
			} else {
				mid.add(num);
			}
		}

		if (k <= left.size()) {
			return quickSelect(left, k);
		}

		if (left.size() + mid.size() < k) {
			return quickSelect(right, k - left.size() - mid.size());
		}

		return pivot;
	}
}