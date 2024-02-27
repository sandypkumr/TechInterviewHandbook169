package string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0, maxFreq = 0;
        char[] sChars = s.toCharArray();
        int[] freqArr = new int[26];
        for (int right = 0; right < s.length(); right++) {
            int curCharIndex = sChars[right] - 'A';
            freqArr[curCharIndex]++;
            maxFreq = Math.max(maxFreq, freqArr[curCharIndex]);
            if (right - left + 1 - maxFreq > k) {
                freqArr[sChars[left] - 'A']--;
                left++;
            }
        }
        return sChars.length - left;
    }
}
