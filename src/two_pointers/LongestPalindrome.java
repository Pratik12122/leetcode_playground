package two_pointers;

import java.util.Map;

public class LongestPalindrome {
	public static void main(String[] args) {
		String s1 = "aaaa";

		System.out.println(longestPalindrome(s1));
	}

	public static String longestPalindrome(String s) {

		int index = 0;
		int n = s.length() - 1;

		String maxSubString = "" + s.charAt(index);

		while (index <= n) {
			int i = index - 1;
			String s1 = palindromicString(s, i, i);
			String s2 = palindromicString(s, i, i + 1);

			String max = s1.length() > s2.length() ? s1 : s2;

			maxSubString = maxSubString.length() < max.length() ? max : maxSubString;

			index++;
		}

		return maxSubString;
	}
	
	
	private static String palindromicString(String s, int i, int j) {
		String maxSubString = "";
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			maxSubString = s.substring(i, j + 1);
			i--;
			j++;
		}
		return maxSubString;
	}

	public String longestPalindromeDP(String s, Map<String, Boolean> dp) {
		System.out.println("Find LP For " + s);
		if (s.length() <= 1) {
			return s;
		}

		if (dp.containsKey(s)) {
			System.out.println("Key present in dp " + s);
		}

		boolean isPalindrome = dp.containsKey(s) ? dp.get(s) : isPalindrome(s);

		if (isPalindrome) {
			dp.put(s, true);
			return s;
		} else {
			dp.put(s, false);
			String left = longestPalindromeDP(s.substring(0, s.length() - 1), dp);
			String right = longestPalindromeDP(s.substring(1), dp);

			return left.length() > right.length() ? left : right;
		}
	}

	boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
