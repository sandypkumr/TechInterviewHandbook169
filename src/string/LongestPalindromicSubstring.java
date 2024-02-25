package string;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String res = "";
        int curRes;
        for (int i = 0; i < s.length(); i++) {
            if (2 * (s.length() - i) - 1 > res.length()) {
                curRes = getEqualCycleCount(s, i, i);
                if (2 * curRes - 1 > res.length()) {
                    res = s.substring(i - curRes + 1, i + curRes);
                }
                curRes = getEqualCycleCount(s, i, i + 1);
                if (2 * curRes > res.length()) {
                    res = s.substring(i - curRes + 1, i + curRes + 1);
                }
            }
        }
        return res;
    }

    private int getEqualCycleCount(String s, int start, int end) {
        int res = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            res++;
            start--;
            end++;
        }
        return res;
    }
}
