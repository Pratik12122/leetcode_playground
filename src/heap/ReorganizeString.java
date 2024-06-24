package heap;

import java.util.HashMap;
import java.util.PriorityQueue;

// @Link: https://leetcode.com/problems/reorganize-string/description/
public class ReorganizeString {

	public static void main(String[] args) {
		String s = "aaab";

		System.out.println(reorganizeString(s));
	}

	public static String reorganizeString(String s) {
		StringBuilder result = new StringBuilder();

		var counts = new HashMap<Character, Integer>();

		for (char ch : s.toCharArray()) {
			counts.put(ch, counts.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<Character> maxHeap = new PriorityQueue<Character>((a, b) -> counts.get(b) - counts.get(a));

		maxHeap.addAll(counts.keySet());

		while (maxHeap.size() > 1) {
			char current = maxHeap.poll();
			char next = maxHeap.poll();

			result.append(current).append(next);

			counts.put(current, counts.get(current) - 1);
			counts.put(next, counts.get(next) - 1);

			if (counts.get(current) > 0) {
				maxHeap.add(current);
			}

			if (counts.get(next) > 0) {
				maxHeap.add(next);
			}
		}

		if (maxHeap.size() == 1) {
			char last = maxHeap.poll();
			if (counts.get(last) > 1) {
				return "";
			}

			result.append(last);
		}

		return result.toString();
	}
}
