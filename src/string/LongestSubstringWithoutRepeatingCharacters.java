package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int curStart = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                curStart = Math.max(curStart, charMap.get(s.charAt(i)));
            }
            res = Math.max(res, i - curStart);
            charMap.put(s.charAt(i), i);
        }
        return res;
    }
}
