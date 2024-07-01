package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] num = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutiveGPT(num));
	}
	
	
	public static int longestConsecutiveGPT(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		var numSet = new HashSet<Integer>();
		for (int num : nums) {
			numSet.add(num);
		}

		int longestStreak = 0;

		for (int num : nums) {
			if (!numSet.contains(num - 1)) {
				int currentNum = num;
				int currentStreak = 1;

				while (numSet.contains(currentNum + 1)) {
					currentNum += 1;
					currentStreak += 1;
				}

				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}

		return longestStreak;
	}

	public static int longestConsecutive(int[] nums) {
		int maxSequence = 0;

		var store = new HashMap<Integer, Pair>();

		for (int n : nums) {
			if (!store.containsKey(n)) {
				store.put(n, new Pair(n));
			}
			
			int length = findMaxSequence(store, nums, n);

			maxSequence = Math.max(maxSequence, length);

		}

		return maxSequence;
	}

	private static int findMaxSequence(Map<Integer, Pair> store, int[] nums, int n) {
		int length = 0;

		Pair pair = store.get(n);

		int left = pair.left;
		int right = pair.right;

		while (store.containsKey(left)) {
			pair.left = left;
			left--;
		}

		while (store.containsKey(right)) {
			pair.right = right;
			right++;
		}

		length = Math.abs(pair.right - pair.left) + 1;

		return length;
	}

}

class Pair {
	public int left;
	public int right;

	public Pair(int number) {
		left = number;
		right = number;
	}
}
