package sliding_window;

import java.util.HashSet;

public class ContainsDuplicate2 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 2, 3 };
		int k = 2;

		System.out.println(containsNearbyDuplicate(nums, k));

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length <= 1) {
			return false;
		}
		// nums = [1,2,3,1], k = 3
		var store = new HashSet<Integer>();

		int start = 0;

		for (int end = 0; end < nums.length; end++) {
			if (!store.add(nums[end]) && end - start <= k) {
				return true;
			}

			if (store.size() > k) {
				store.remove(nums[start++]);
			}
		}

		return false;
	}

}
