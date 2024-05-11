package palindrome;

public class LongestPalindromicSubString {

	// @Link :
	// https://leetcode.com/problems/longest-palindromic-substring/description/
	public static void main(String[] args) {
		String s = "babad";

		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {

		boolean[][] dp = new boolean[s.length()][s.length()];
		String result = "" + s.charAt(0);
		for (int gap = 0; gap < s.length(); gap++) {
			for (int i = 0, j = gap; j < s.length(); i++, j++) {
				if (gap == 0) {
					dp[i][j] = true;
				} else if (gap == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}
				if (dp[i][j]) {
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;

	}

}
