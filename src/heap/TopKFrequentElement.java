package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElement {

	public static void main(String[] args) {
		int[] nums = {-1,-1};
		int k = 1;
		
		System.out.println(Arrays.toString(topKFrequentUsingBucketSort(nums, k)));
	}

	public static int[] topKFrequent(int[] nums, int k) {

		Map<Integer, Integer> count = new HashMap<>();

		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		Queue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

		for (int num : count.keySet()) {
			heap.add(num);
			if (heap.size() > k)
				heap.poll();
		}

		int[] top = new int[k];

		for (int i = k - 1; i >= 0; i--) {
			top[i] = heap.poll();
		}

		return top;

	}

	public static int[] topKFrequentUsingBucketSort(int[] nums, int k) {
		if (k == nums.length)
			return nums;

		Map<Integer, Integer> count = new HashMap<>();

		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}

		List<Integer>[] buckets = new List[nums.length+1];

		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		for (int key : count.keySet()) {
			buckets[count.get(key)].add(key);
		}

		List<Integer> flattened = new ArrayList<Integer>();

		for (int i = buckets.length - 1; i >= 0; i--) {
			for (int num : buckets[i]) {
				flattened.add(num);
			}
		}

		int[] top = new int[k];
		for (int i = 0; i < k; i++) {
			top[i] = flattened.get(i);
		}

		return top;

	}
}
