package arrays;

public class FindAnagrams {
	public static void main(String[] args) {
		String s = "rat";
		String r = "car";

		System.out.println(isAnagram(s, r));
	}

	public static boolean isAnagram(String s, String t) {

		int[] charArray = new int[27];

		for (char ch : s.toCharArray()) {
			charArray[ch - 'a'] += 1;
		}

		for (char ch : t.toCharArray()) {
			charArray[ch - 'a'] -= 1;
		}

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
