package sliding_window;

import java.util.HashMap;

public class Longest_repeating_character_replacement {

	
	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;

		//System.out.println(characterReplacement(s, k));
		Integer a = 1;
		System.out.println(testIncre(a));
		System.out.println(a);
	}

	
	static int testIncre(Integer a) {
		a = ++a;
		return a;
	}
	public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        int maxFreq = 0;
        int j = 0; // Left pointer of the window
        int[] charCount = new int[26]; // Count of each character

        for (int i = 0; i < s.length(); i++) { // Loop through the string (right pointer)
            charCount[s.charAt(i) - 'A']++; // Increment count of current character
            maxFreq = Math.max(maxFreq, charCount[s.charAt(i) - 'A']); // Update max frequency

            while (i - j + 1 - maxFreq > k) { // Check if window size exceeds allowed replacements
                charCount[s.charAt(j) - 'A']--; // Decrement count of leftmost character
                j++; // Shrink window from left
            }

            maxLen = Math.max(maxLen, i - j + 1); // Update max length of valid window
        }

        return maxLen;
    }
	

	public static int characterReplacementNW1(String s, int k) {
		var map = new HashMap<Character, Integer>();

		int left = 0;
		int maxLength = 1;
		int uniqueElements = k + 1;
		for (int right = 0; right < s.length(); right++) {
			Character ch = s.charAt(right);
			if (map.size() <= uniqueElements) {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			} else {
				while (map.size() > uniqueElements) {
					Character windowStartChar = s.charAt(left++);
					map.computeIfPresent(windowStartChar, (key, value) -> value == 1 ? null : value - 1);
				}
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}
		return maxLength;

	}
}
