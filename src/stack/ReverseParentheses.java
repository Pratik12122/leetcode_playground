package stack;

import java.util.Stack;

public class ReverseParentheses {
	public static void main(String[] args) {
		String s = "(u(love)i)";
		
		System.out.println(reverseParentheses(s));
	}

	public static String reverseParentheses(String s) {
		Stack<Character> st = new Stack<>();

        for(int i=0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ')') {
            	StringBuilder temp = new StringBuilder();
            	
            	while(st.peek() != '(') {
            		temp.append(st.pop());
            	}
            	
            	st.pop();
            	
            	for(char t : temp.toString().toCharArray()) {
            		st.push(t);
            	}
              
            } else {
                st.push(ch);
            }
        }



        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
	}
}
