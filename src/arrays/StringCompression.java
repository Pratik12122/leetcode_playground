package arrays;

public class StringCompression {
	public static void main(String[] args) {
		String s = "ab";

		System.out.println(compress2(s.toCharArray()));
	}

	static int compress2(char[] chars) {
		int red = 0;
		int green = 0;

		for (int i = 0; i <= chars.length; i++) {
			if (i == chars.length || chars[i] != chars[green]) {
				// Calculate the count of the current sequence
				int count = i - green;
				chars[red++] = chars[green]; // Store the character

				// If count is greater than 1, store the count as characters
				if (count > 1) {
					String s = Integer.toString(count);
					for (int j = 0; j < s.length(); j++) {
						chars[red++] = s.charAt(j);
					}
				}

				// Move green to the current position
				green = i;
			}
		}

		return red;
	}

	public static int compress(char[] chars) {
		int index = 0;

		int start = 0;

		for (int end = 0; end < chars.length; end++) {
			if (chars[start] == chars[end] && end != chars.length - 1) {
				continue;
			} else {
				int count = end - start;
				int countLength = (int) Math.log(count) + 1;

				chars[index] = chars[start];
				int j = index + countLength;

				while (count != 0) {
					int digit = count % 10;
					chars[j--] = (char) digit;
					count /= 10;
				}
				index += countLength;
				start = end;
			}
		}

		return index - 1;
	}
}
