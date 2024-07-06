package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRows {

	public static void main(String[] args) {
		int[][] nums = {{1,0},{1,0},{1,0},{1,1}};

		System.out.println(Arrays.toString(kWeakestRows(nums, 4)));
	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		int m = mat.length;

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> {
			return compareRows(b, a, mat);
		});

		for (int i = 0; i <= m - 1; i++) {
			maxHeap.add(i);
			
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		int[] result = new int[k];
		int index = k-1;
		while (!maxHeap.isEmpty()) {
			result[index--] = maxHeap.poll();
		}

		return result;
	}

	static int compareRows(int first, int second, int[][] mat) {
		// how to compare two ints
		int iNoOfSoliders = findOfNoSolider(mat[first]);
		int jNoOfSoliders = findOfNoSolider(mat[second]);

		
		if (iNoOfSoliders == jNoOfSoliders) {
			return Integer.compare(first, second);
		}

		
		System.out.println("first index " + first + " no of soliders " + iNoOfSoliders);
		System.out.println("second index " + second + " no of soliders " + jNoOfSoliders);

		return Integer.compare(iNoOfSoliders, jNoOfSoliders);
	}

	private static int findOfNoSolider(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == 1) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}

}
