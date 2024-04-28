package sliding_window;

import java.util.HashSet;

public class LengthOfLongestSubstring {

	// @Link:
	// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
	public static void main(String[] args) {
		var obj = new LengthOfLongestSubstring();
		String s = "abcabcbb";
		System.out.println(obj.lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;

		var lookup = new HashSet<Character>();
		var chArray = s.toCharArray();
		int size = 1;
		int left = 0;
		lookup.add(chArray[left]);

		for (int right = 1; right < chArray.length; right++) {
			if (lookup.add(chArray[right])) {
				size = Math.max(size, (right - left) + 1);
			} else {
				while (chArray[left] != chArray[right]) {
					lookup.remove(chArray[left++]);
				}
				left++;
			}
		}
		return size;
	}

}
