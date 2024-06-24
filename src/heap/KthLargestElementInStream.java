package heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInStream {

	private Queue<Integer> heap;

	int maxSize;

	public KthLargestElementInStream(int k, int[] nums) {
		heap = new PriorityQueue<Integer>();
		maxSize = k;

		for (int n : nums) {
			heap.add(n);

			if (heap.size() > maxSize) {
				heap.poll();
			}
		}
	}

	public int add(int val) {
		heap.add(val);

		if (heap.size() > maxSize) {
			heap.poll();
		}

		return heap.peek();
	}

	public static void main(String[] args) {

	}
}
