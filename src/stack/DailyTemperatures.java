package stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temp = { 89, 62, 70, 58, 47, 47, 46, 76, 100, 70 };

		System.out.println(Arrays.toString(dailyTemperatures(temp)));

	}

	public static int[] dailyTemperatures(int[] temperatures) {
		var stack = new Stack<Integer>();
		int[] result = new int[temperatures.length];

		for (int i = temperatures.length - 1; i >= 0; i--) {
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
					stack.pop();
				}

				if (!stack.isEmpty()) {
					int distance = stack.peek() - i;
					result[i] = distance;
				}
			}
			stack.push(i);
		}

		return result;
	}

}
