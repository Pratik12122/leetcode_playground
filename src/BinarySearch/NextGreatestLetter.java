package BinarySearch;

public class NextGreatestLetter {

	// @Link
	// https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/?envType=study-plan-v2&envId=binary-search

	public static void main(String[] args) {
		char[] letters = {'c','f','j'};
		char ch = 'j';
		
		System.out.println(nextGreatestLetter(letters, ch));
	}

	public static char nextGreatestLetter(char[] letters, char target) {

		int left = 0;
		int right = letters.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (letters[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return left == letters.length ? letters[0] : letters[left];
	}

}
