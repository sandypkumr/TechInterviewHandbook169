package string;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int res = 0;
        boolean oddPresent = false;
        int[] upperLetters = new int[26];
        int[] lowerLetters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (isLowerChar(s.charAt(i))) {
                lowerLetters[s.charAt(i) - 'a'] += 1;
            } else {
                upperLetters[s.charAt(i) - 'A'] += 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (lowerLetters[i] % 2 == 0) {
                res += lowerLetters[i];
            } else {
                oddPresent = true;
                res += lowerLetters[i] - 1;
            }
            if (upperLetters[i] % 2 == 0) {
                res += upperLetters[i];
            } else {
                oddPresent = true;
                res += upperLetters[i] - 1;
            }
        }
        return (oddPresent) ? res + 1 : res;
    }

    private boolean isLowerChar(char c) {
        return (c >= 'a' && c <= 'z');
    }
}
