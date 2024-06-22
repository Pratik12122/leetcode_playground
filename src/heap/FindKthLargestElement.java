package heap;

import java.util.PriorityQueue;

// Link: https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class FindKthLargestElement {
	public static void main(String[] args) {

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
