package stack;

import java.util.Arrays;
import java.util.Stack;

public class PolishNotation {

	public static void main(String[] args) {
		String[] tokens = {"2","1","+","3","*"};
		
		System.out.println(evalRPN(tokens));

	}

	public static int evalRPN(String[] tokens) {
		var stack = new Stack<Integer>();
		var operators = Arrays.asList("+", "-", "*", "/");

		for (String token : tokens) {
			if (operators.contains(token)) {
				int num2 = stack.pop();
				int num1 = stack.pop();

				switch (token) {
				case "+":
					stack.push(num1 + num2);
				case "-":
					stack.push(num1 - num2);
				case "/":
					stack.push(num1 / num2);
				case "*":
					stack.push(num1 * num2);
				}
			} else {
				stack.add(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

}
