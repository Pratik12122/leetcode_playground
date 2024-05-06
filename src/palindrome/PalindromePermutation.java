package palindrome;

public class PalindromePermutation {

	// @Link https://leetcode.com/problems/palindrome-permutation/
	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("aab"));
	}

	public static boolean canPermutePalindrome(String s) {
		int[] letters = new int[26];

		for (char ch : s.toCharArray()) {
			int index = ch - 'a';
			letters[index] += 1;
		}

		boolean isOddLength = s.length() % 2 != 0;

		for (int count : letters) {
			if (count % 2 != 0) {
				if (isOddLength) {
					isOddLength = false;
				} else {
					return false;
				}
			}
		}

		return true;
	}

}
