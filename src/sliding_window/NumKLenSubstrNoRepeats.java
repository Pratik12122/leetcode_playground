package sliding_window;

import java.util.HashMap;

public class NumKLenSubstrNoRepeats {

	public static void main(String[] args) {
		String s = "havefunonleetcode";
		int k=5;
		
		System.out.println(numKLenSubstrNoRepeats(s, k));
	}

	public static int numKLenSubstrNoRepeats(String s, int k) {
		int result = 0;

		int start = 0;
		var map = new HashMap<Character, Integer>();
		var charArray = s.toCharArray();

		for (int end = 0; end < s.length(); end++) {
			char ch = charArray[end];
			int count = map.getOrDefault(ch, 0);

			if (count == 0) {
				map.put(ch, 1);

				if (map.size() == k) {
					result++;
					map.remove(charArray[start++]);
				}
			} else {
				while (charArray[start] != ch) {
					map.remove(charArray[start++]);
				}
				start++;
			}
		}

		return result;
	}
}
