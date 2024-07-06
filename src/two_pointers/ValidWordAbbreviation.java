package two_pointers;

public class ValidWordAbbreviation {

	public static void main(String[] args) {
		String word = "internationalization";
		String abbr = "i12iz4n";

		System.out.println(validWordAbbreviation(word, abbr));
	}

	public static boolean validWordAbbreviation(String word, String abbr) {
		int word_index = 0;
		int abbr_index = 0;

		while (word_index < word.length() && abbr_index < abbr.length()) {
			char abbr_char = abbr.charAt(abbr_index);

			if (Character.isDigit(abbr_char)) {
				if (abbr_char == '0') {
					return false;
				}
				int total = 0;
				while (abbr_index < abbr.length() && Character.isDigit(abbr.charAt(abbr_index))) {
					total = total * 10 + abbr.charAt(abbr_index) - '0';
					abbr_index++;
				}
				word_index += total;
			} else {
				if (word.charAt(word_index) != abbr.charAt(abbr_index)) {
					return false;
				}
				word_index++;
				abbr_index++;
			}
		}

		return word_index == word.length() && abbr_index == abbr.length();
	}

}
