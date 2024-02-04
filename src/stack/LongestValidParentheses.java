package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> integerDeque = new ArrayDeque<>();
        integerDeque.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                integerDeque.push(i);
            } else {
                integerDeque.pop();
                if (integerDeque.isEmpty()) {
                    integerDeque.push(i);
                } else {
                    res = Math.max(res, i - integerDeque.peek());
                }
            }
        }
        return res;
    }
}
