package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        int res = 0, cur = 0;
        char sign = '+';
        Deque<Integer> resDeque = new ArrayDeque<>();
        Deque<Character> charDeque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                cur = (10 * cur) + (c - '0');
            } else if (c == '(') {
                resDeque.push(res);
                charDeque.push(sign);
                res = 0;
                sign = '+';
            } else if (c == ')') {
                if (sign == '-') {
                    cur = -cur;
                }
                res += cur;
                if (charDeque.pop() == '-') {
                    res = resDeque.pop() - res;
                } else {
                    res = resDeque.pop() + res;
                }
                cur = 0;
            } else {
                if (sign == '-') {
                    cur = -cur;
                }
                res += cur;
                cur = 0;
                sign = c;
            }
        }
        if (cur != 0) {
            if (sign == '-') {
                cur = -cur;
            }
            res += cur;
        }
        return res;
    }
}
