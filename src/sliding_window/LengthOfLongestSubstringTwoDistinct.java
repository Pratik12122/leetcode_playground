package sliding_window;

import java.util.HashMap;

public class LengthOfLongestSubstringTwoDistinct {

	// @Link:
	// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/

	public static void main(String[] args) {
		var obj = new LengthOfLongestSubstringTwoDistinct();
		String s = "eceba";
		System.out.println(obj.lengthOfLongestSubstringTwoDistinct(s));
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		var lookup = new HashMap<Character, Integer>();
		char[] array = s.toCharArray();
		int start = 0;
		int maxLength = 0;

		for (int end = 0; end < array.length; end++) {
			Character ch = array[end];

			lookup.put(ch, lookup.getOrDefault(ch, 0) + 1);

			while (lookup.size() > 2) {
				ch = array[start++];
				lookup.put(ch, lookup.get(ch) - 1);
				if (lookup.get(ch) == 0) {
					lookup.remove(ch);
				}
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}

}
