package string;

public class StringToIntegerAToI {
    public int myAtoi(String s) {
        boolean areDigitsStarted = false;
        boolean signDefined = false;
        boolean isNegative = false;
        long res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!areDigitsStarted && s.charAt(i) == ' ')
                continue;
            areDigitsStarted = true;
            if (!signDefined && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
                signDefined = true;
                if (s.charAt(i) == '-') isNegative = true;
                continue;
            }
            if (s.charAt(i) - '0' < 0 || s.charAt(i) - '0' > 9)
                break;
            if (!signDefined) signDefined =true;
            res = (10 * res) + (s.charAt(i) - '0');
            if (isNegative && res * -1 <= Integer.MIN_VALUE) {
                res = Integer.MIN_VALUE;
                break;
            }
            if (!isNegative && res >= Integer.MAX_VALUE) {
                res = Integer.MAX_VALUE;
                break;
            }
        }
        if (isNegative && res > 0)
            res = -res;
        return (int) res;
    }
}
