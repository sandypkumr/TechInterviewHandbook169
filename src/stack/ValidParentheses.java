package stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '{', '[':
                    charStack.push(c);
                    break;
                case ')':
                    if (charStack.isEmpty() || charStack.pop() != '(') return false;
                    break;
                case '}':
                    if (charStack.isEmpty() || charStack.pop() != '{') return false;
                    break;
                case ']':
                    if (charStack.isEmpty() || charStack.pop() != '[') return false;
                    break;
            }
        }
        return charStack.isEmpty();
    }
}
