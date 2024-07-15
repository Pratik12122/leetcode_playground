package sliding_window;

import java.util.HashMap;

public class FruitIntoBaskets {
	public static void main(String[] args) {
		int[] fruits = { 1, 2, 3, 2, 2 };

		System.out.println(totalFruit(fruits));
	}

	public static int totalFruit(int[] nums) {
		int windowStart = 0;
		var map = new HashMap<Integer, Integer>();
		int maxNoOfFruits = 0;
		for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
			map.put(nums[windowEnd], map.getOrDefault(nums[windowEnd], 0) + 1);

			if (map.size() > 2) {
				while (map.size() != 2) {
					map.computeIfPresent(nums[windowStart++], (k, v) -> v > 1 ? v - 1 : null);
				}
			}

			maxNoOfFruits = Math.max(maxNoOfFruits, windowEnd - windowStart + 1);
		}

		return maxNoOfFruits;
	}
}
