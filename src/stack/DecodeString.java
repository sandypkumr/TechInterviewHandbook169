package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {
    public String decodeString(String s) {
        int rep = 0;
        StringBuilder resBuilder = new StringBuilder();
        Deque<Integer> integerDeque = new ArrayDeque<>();
        Deque<String> stringDeque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                    integerDeque.push(rep);
                    stringDeque.push(resBuilder.toString());
                    rep = 0;
                    resBuilder = new StringBuilder();
                    break;
                case ']':
                    int curRep = integerDeque.pop();
                    String curTemp = resBuilder.toString();
                    resBuilder = new StringBuilder(stringDeque.pop());
                    resBuilder.append(curTemp.repeat(Math.max(0, curRep)));
                    break;
                default:
                    if (Character.isDigit(c)) {
                        rep = (10 * rep) + (c - '0');
                    } else {
                        resBuilder.append(c);
                    }
                    break;
            }
        }
        return resBuilder.toString();
    }
}
