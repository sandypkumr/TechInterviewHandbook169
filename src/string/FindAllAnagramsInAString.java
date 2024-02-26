package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resList = new ArrayList<>();
        if (p.length() > s.length()) return resList;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            charFreqMap.put(p.charAt(i), charFreqMap.getOrDefault(p.charAt(i), 0) + 1);
            charFreqMap.put(s.charAt(i), charFreqMap.getOrDefault(s.charAt(i), 0) - 1);
        }
        if (verifyAllZeroesInMap(charFreqMap)) resList.add(0);
        for (int i = 1; i <= (s.length() - p.length()); i++) {
            charFreqMap.put(s.charAt(i - 1), charFreqMap.getOrDefault(s.charAt(i - 1), 0) + 1);
            char newChar = s.charAt(i + p.length() - 1);
            charFreqMap.put(newChar, charFreqMap.getOrDefault(newChar, 0) - 1);
            if (verifyAllZeroesInMap(charFreqMap)) resList.add(i);
        }
        return resList;
    }

    private boolean verifyAllZeroesInMap(Map<Character, Integer> charFreqMap) {
        for (int freq : charFreqMap.values()) {
            if (freq != 0) return false;
        }
        return true;
    }
}
