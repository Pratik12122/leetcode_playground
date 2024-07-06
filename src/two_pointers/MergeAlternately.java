package two_pointers;

public class MergeAlternately {

	public static void main(String[] args) {
		String w1 = "acdfgy";
		String w2 = "be";

		System.out.println(mergeAlternately(w1, w2));
	}

	public static String mergeAlternately(String word1, String word2) {
		int s1_index = 0;
		int s2_index = 0;

		int index = 1;

		StringBuffer result = new StringBuffer();
		while (s1_index < word1.length() && s2_index < word2.length()) {
			if (index % 2 == 0) {
				result.append(word2.charAt(s2_index++));
			} else {
				result.append(word1.charAt(s1_index++));
			}
			index++;
		}

		if (s1_index < word1.length()) {
			result.append(word1.substring(s1_index));
		}

		if (s2_index < word2.length()) {
			result.append(word2.substring(s2_index));
		}
		return result.toString();
	}

}
