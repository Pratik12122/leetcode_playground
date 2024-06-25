package heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

// @Link : https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;

		Arrays.stream(kClosest1(points, k)).forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

	public static int[][] kClosest(int[][] points, int k) {

		var distanceMap = new HashMap<Integer, Integer>();

		int index = 0;

		for (int[] point : points) {
			Integer distance = (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
			distanceMap.put(index, distance);
			index++;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> distanceMap.get(b) - distanceMap.get(a));

		for (Entry<Integer, Integer> entry : distanceMap.entrySet()) {
			minHeap.add(entry.getKey());

			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		int[][] result = new int[k][2];

		index = 0;

		while (!minHeap.isEmpty()) {
			var entry = minHeap.poll();
			int[] point = points[entry];
			result[index] = point;
			index++;
		}
		return result;
	}

	// Better code
	public static int[][] kClosest1(int[][] points, int k) {
		// Max-heap to store the k closest points
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
				(a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]));

		// Iterate through each point
		for (int[] point : points) {
			// Add point to the heap
			maxHeap.offer(point);
			// If the heap size exceeds k, remove the farthest point
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		// Prepare the result array
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			result[i] = maxHeap.poll();
		}

		return result;
	}
}
