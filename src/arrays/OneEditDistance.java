package arrays;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class OneEditDistance {

	public static void main(String[] args) {
		String s = "teacher";
		String t = "detacher";

		System.out.println(new OneEditDistance().isOneEditDistance(s, t));
	}

	public boolean isOneEditDistance(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1 || (s.isEmpty() && t.isEmpty())) {
			return false;
		}

		int editRequired;

		if (s.length() == t.length()) {
			editRequired = isOneEditAway(s, t);
			return editRequired == 1;
		} else if (s.length() < t.length()) {
			editRequired = isOneEditAway(t, s);
			return editRequired == 1;
		} else {
			editRequired = isOneEditAway(s, t);
			return editRequired == 1;
		}
	}

	private int isOneEditAway(String s, String t) {
		var map = s.chars().mapToObj(ch -> (char) ch).collect(groupingBy(c -> c, counting()));

		t.chars().mapToObj(ch -> (char) ch)
				.forEach(c -> map.computeIfPresent(c, (key, count) -> count == 1 ? null : count - 1));

		return (int) (map.size() > 1 ? map.size() : map.isEmpty() ? 0 : map.entrySet().iterator().next().getValue());
	}

}
