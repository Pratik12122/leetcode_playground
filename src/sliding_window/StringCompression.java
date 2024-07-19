package sliding_window;

public class StringCompression {

	public static void main(String[] args) {
		char[] chars = {'a','b','c',};
		
		System.out.println(compress(chars));
	}

	public static int compress(char[] chars) {
		
		if(chars.length == 1) return 1;
		
		int left = 0;

		for (int index = 0; index < chars.length;) {
			int next = index + 1;

			while (next < chars.length && chars[next] == chars[index]) {
				next++;
			}

			int length = next - index;

			if (length > 1) {
				String size = "" + length;
				chars[left++] = chars[index];
				for (char ch : size.toCharArray()) {
					chars[left++] = ch;
				}
			} else {
				chars[left++] = chars[index];
			}
			index = next;
		}

		return left;
	}
}
