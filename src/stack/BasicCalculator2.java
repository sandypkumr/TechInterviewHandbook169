package stack;

public class BasicCalculator2 {
    public int calculate(String s) {
        int res = 0;
        s = s.replaceAll("\\s", "");
        int cur = 0, prev = 0;
        char sign = '+';
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                cur = 10 * cur + (c - '0');
            } else {
                if (sign == '+') {
                    res += prev;
                    prev = cur;
                } else if (sign == '-') {
                    res += prev;
                    prev = -1 * cur;
                } else if (sign == '*') {
                    prev = prev * cur;
                } else {
                    prev = prev/cur;
                }
                sign = c;
                cur = 0;
            }
        }
        if (sign == '+') {
            res += prev;
            prev = cur;
        } else if (sign == '-') {
            res += prev;
            prev = -1 * cur;
        } else if (sign == '*') {
            prev = prev * cur;
        } else {
            prev = prev/cur;
        }
        res += prev;
        return res;
    }
}
