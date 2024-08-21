package stack;

import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;

public class AsteroidCollision {
	public static void main(String[] args) {
		int[] nums = {-5,2,5,-13 };
		ThreadPoolExecutor ex = new ThreadPoolExecutor(0, 0, 0, null, null);
		System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(nums)));
	}

	public int[] asteroidCollision(int[] asteroids) {
		var stack = new Stack<Integer>();

		for (int n : asteroids) {
			if (n > 0 || stack.isEmpty() || stack.peek() < 0) {
				stack.push(n);
			} else {
				boolean isCollionHappening = true;
				while (isCollionHappening) {
					int top = stack.peek();
					if(top < 0) {
						stack.push(n);
					}else if (top == (n * -1)) {
						stack.pop();
					} else if (top < (n * -1)) {
						stack.pop();
						isCollionHappening = stack.isEmpty() ? false : stack.peek() < 0 ? false : true;
					}else {
						isCollionHappening = false;
					}
				}
			}
		}

		int[] res = new int[stack.size()];

		int i = stack.size() - 1;

		while (!stack.isEmpty()) {
			res[i--] = stack.pop();
		}

		return res;

	}
}
