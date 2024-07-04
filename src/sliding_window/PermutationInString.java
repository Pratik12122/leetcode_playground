package sliding_window;

import java.util.stream.Collectors;

public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab";
		String s2String = "eidbaooo";

		System.out.println(checkInclusionGPT(s1, s2String));

		s1 = "adc";
		s2String = "dcda";

		System.out.println(checkInclusionGPT(s1, s2String));

	}

	public static boolean checkInclusion(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return false;
		}

		var map = s1.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		int k = s1.length();
		int windowLeft = 0;
		boolean isWindowOpen = false;

		for (int right = 0; right < s2.length(); right++) {
			if (map.containsKey(s2.charAt(right))) {
				if (!isWindowOpen) {
					isWindowOpen = true;
					windowLeft = right;
				}
				map.computeIfPresent(s2.charAt(right), (key, v) -> v == 1 ? null : v - 1);
				if ((right - windowLeft + 1) == k && map.isEmpty()) {
					return true;
				}
			} else {
				if (isWindowOpen) {
					isWindowOpen = false;
					int next = windowLeft;
					while (windowLeft != right) {
						char leftChar = s2.charAt(windowLeft++);
						map.put(leftChar, map.getOrDefault(leftChar, 0l) + 1);
					}
					right = next;
				}
			}
		}

		return false;
	}

	public static boolean checkInclusionGPT(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		int[] s1Count = new int[26];
		int[] s2Count = new int[26];

		// Populate the character counts for s1 and the first window of s2
		for (int i = 0; i < s1.length(); i++) {
			s1Count[s1.charAt(i) - 'a']++;
			s2Count[s2.charAt(i) - 'a']++;
		}

		// Check if the first window is a permutation of s1
		if (matches(s1Count, s2Count)) {
			return true;
		}

		int windowSize = s1.length();

		// Slide the window over s2
		for (int i = s1.length(); i < s2.length(); i++) {
			s2Count[s2.charAt(i) - 'a']++;
			s2Count[s2.charAt(i - windowSize) - 'a']--;

			if (matches(s1Count, s2Count)) {
				return true;
			}
		}

		return false;
	}

	// Helper method to check if two character count arrays are identical
	private static boolean matches(int[] s1Count, int[] s2Count) {
		for (int i = 0; i < 26; i++) {
			if (s1Count[i] != s2Count[i]) {
				return false;
			}
		}
		return true;
	}

}
