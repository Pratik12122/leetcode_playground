package two_pointers;

public class LongestPalidromeTest {
	
	public static void main(String[] args) {
		String s = "bddcbaabcde";
		
		System.out.println(new LongestPalidromeTest().longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		String res = "";
		char prev = ' ';

		for (int i = 0; i < s.length(); i++) {
			int start = i;
			int end = i;

			if (prev == s.charAt(i)) {
				String s1 = palidromicString(s, start - 1, end);
				String s2 = palidromicString(s, start, end);

				String temp = s1.length() > s2.length() ? s1 : s2;
				res = res.length() > temp.length() ? res : temp;
			} else {
				String temp = palidromicString(s, start, end);
				res = res.length() > temp.length() ? res : temp;
			}

			prev = s.charAt(i);
		}

		return res;
	}

	String palidromicString(String s, int start, int end) {
		String res = "";

		while (isValid(s, start, end)) {
			if ((end - start + 1) > res.length()) {
				res = s.substring(start, end + 1);
			}

			start--;
			end++;
		}

		return res;
	}

	boolean isValid(String s, int start, int end) {
		if (start >= 0 && end < s.length()) {
			if (s.charAt(start) == s.charAt(end)) {
				return true;
			}
		}

		return false;
	}
}
