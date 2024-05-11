package sliding_window;

import java.util.HashMap;

public class Longest_repeating_character_replacement {

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;

		System.out.println(characterReplacement(s, k));
	}

	public static int characterReplacement(String s, int k) {
		var map = new HashMap<Character, Integer>();

		int left = 0;
		int maxLength = 0;
		for (int right = 0; right < s.length(); right++) {
			Character ch = s.charAt(right);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() > k + 1 || (ch != s.charAt(left) && map.get(ch) > 2)) {
				while (s.charAt(left) != ch) {
					map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
					if (map.get(s.charAt(left)) == 0) {
						map.remove(ch);
					}
					left++;
				}
			} else {
				maxLength = Math.max(maxLength, right - left + 1);
			}

		}

		return maxLength;

	}
}
