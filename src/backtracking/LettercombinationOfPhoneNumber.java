package backtracking;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;

public class LettercombinationOfPhoneNumber {
	public static void main(String[] args) {
		String s = "23";

		var obj = new LettercombinationOfPhoneNumber();
		obj.letterCombinations(s).forEach(System.out::println);
	}

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return emptyList();
		}

		return getLetterCombinations(digits, 0);
	}

	static String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	private List<String> getLetterCombinations(String digits, int index) {

		if (index == digits.length()) {
			var baseResult = new ArrayList<String>();
			baseResult.add("");
			return baseResult;
		}

		var result = new ArrayList<String>();

		List<String> recResult = getLetterCombinations(digits, index + 1);

		char ch = digits.charAt(index);

		String code = mapping[ch - '0'];

		for (String letter : recResult) {
			for (int i = 0; i < code.length(); i++) {
				char chCode = code.charAt(i);
				result.add(chCode + letter);
			}
		}

		return result;
	}
}
