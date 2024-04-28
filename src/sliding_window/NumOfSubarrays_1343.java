package sliding_window;

public class NumOfSubarrays_1343 {

	// @Link :
	// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
	public static void main(String[] args) {
		var obj = new NumOfSubarrays_1343();
		int[] arr = { 11,13,17,23,29,31,7,5,2,3 };
		int k = 3;
		int threshold = 5;

		System.out.println(obj.numOfSubarrays(arr, k, threshold));
	}

	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int count = 0;

		int windowStart = 0;
		int windowSum = 0;

		for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
			windowSum += arr[windowEnd];

			if (windowEnd - windowStart + 1 == k) {
				int avg = windowSum / k;
				if (avg >= threshold) {
					count++;
				}
				windowSum -= arr[windowStart++];
			}
		}

		return count;

	}
}
