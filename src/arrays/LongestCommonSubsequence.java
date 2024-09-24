package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String s = "abcdefghijkttxty";
		String t = "ttrrghyabckg";

		System.out.println(longestCommonSubsequence(t, t));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		int res = 0;

		if (text1.length() < text2.length()) {
			return longestCommonSubsequence(text2, text1);
		}
		var map = prepareMap(text1);

		int index = 0;

		while (index < text2.length()) {
			char ch = text2.charAt(index);

			if (map.containsKey(ch)) {
				int start = index;
				int end = index + 1;

				while (end < text2.length() && map.containsKey(text2.charAt(end))
						&& isCharIndexEqualOrGreater(text2.charAt(end), end, map)) {
					end++;
				}

				res = Math.max(res, end - start);
				index = end;
			} else {
				index++;
			}
		}

		return res;

	}

	private static boolean isCharIndexEqualOrGreater(char charAt, int end, Map<Character, List<Integer>> map) {
		var indxList = map.get(charAt);

		for (int index : indxList) {
			if (index >= end) {
				return true;
			}
		}
		return false;
	}

	private static Map<Character, List<Integer>> prepareMap(String text1) {
		var map = new HashMap<Character, List<Integer>>();

		for (int i = 0; i < text1.length(); i++) {
			Character ch = text1.charAt(i);

			if (map.containsKey(ch)) {
				var list = map.get(ch);
				list.add(i);
				map.put(ch, list);
			} else {
				var list = new ArrayList<Integer>();
				list.add(i);
				map.put(ch, list);
			}
		}

		return map;
	}

}
