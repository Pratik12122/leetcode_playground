package javaTricks;

import java.util.stream.Collectors;

public class SteamAPI {

	public static void main(String[] args) {
		convertStringToCharMap();
	}

	public static void convertStringToCharMap() {
		String s = "aabbccd";

		var map = s.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		map.forEach((k, v) -> System.out.println(k + " " + v));
	}

}
