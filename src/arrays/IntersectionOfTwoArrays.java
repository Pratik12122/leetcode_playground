package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] n1 = { 4, 9, 5 };
		int[] n2 = { 9, 4, 9, 8, 4 };

		System.out.println(Arrays.toString(intersection(n1, n2)));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		int[] memo = new int[1001];

		for (int n : nums1) {
			memo[n] += 1;
		}

		for (int n : nums2) {
			memo[n] += 1;
		}

		var res = new ArrayList<Integer>();

		for (int i = 0; i < memo.length; i++) {
			if (memo[i] >= 2) {
				res.add(i);
			}
		}

		return res.stream().mapToInt(Integer::intValue).toArray();

	}

}
