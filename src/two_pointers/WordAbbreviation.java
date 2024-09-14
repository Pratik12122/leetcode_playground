package two_pointers;

public class WordAbbreviation {

	public static void main(String[] args) {
		String word = "internationalization";
		String abbr = "i5a11o1";

		System.out.println(validWordAbbreviation(word, abbr));
	}

	public static boolean validWordAbbreviation(String word, String abbr) {

		int wordIndex = 0;
		int abbrIndex = 0;

		while (abbrIndex < abbr.length()) {
			char ch = abbr.charAt(abbrIndex);

			if (Character.isDigit(ch)) {
				StringBuilder sb = new StringBuilder();
				while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
					sb.append(abbr.charAt(abbrIndex));
					abbrIndex++;
				}

				int length = Integer.valueOf(sb.toString());
				wordIndex = wordIndex + length;
			} else if (wordIndex >= word.length() || ch != word.charAt(wordIndex)) {
				return false;
			} else {
				abbrIndex++;
				wordIndex++;
			}

		}

		return wordIndex == word.length() && abbrIndex == abbr.length();

	}

}
