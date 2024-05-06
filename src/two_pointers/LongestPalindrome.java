package two_pointers;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		System.out.println(
				lp.longestPalindromeDP("babaddtattarrattatddetartrateedredividerb", new HashMap<String, Boolean>()));
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
