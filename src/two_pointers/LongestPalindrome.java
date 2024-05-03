package two_pointers;

public class LongestPalindrome {
	public static void main(String[] args) {

	}
	
	

	
	
	boolean isPalindrome(String s) {
		if (s.length() == 1)
			return true;

		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
