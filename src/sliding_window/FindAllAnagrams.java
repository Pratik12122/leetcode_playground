package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";

		findAnagrams(s, p).forEach(System.out::println);
	}

	public static List<Integer> findAnagrams(String s, String p) {
		int pLength = p.length();
		var map = new HashMap<Character, Integer>();
		var pMap = new HashMap<Character, Integer>();
		var res = new ArrayList<Integer>();

		for (Character ch : p.toCharArray()) {
			pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);
		}

		int start = 0;
		for (int end = 0; end < s.length(); end++) {
			map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);

			if (end - start + 1 == pLength) {
				if (map.equals(pMap)) {
					res.add(start);
				}
				map.computeIfPresent(s.charAt(start++), (k, count) -> count - 1 == 0 ? null : count - 1);
			}

		}

		return res;
	}
}
