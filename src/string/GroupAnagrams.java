package string;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strMap = new HashMap<>();
        for (String str:strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            if (!strMap.containsKey(String.copyValueOf(charArr))) {
                strMap.put(String.copyValueOf(charArr), new ArrayList<>());
            }
            strMap.getOrDefault(String.copyValueOf(charArr), new ArrayList<>()).add(str);
        }
        return new ArrayList<>(strMap.values());
    }
}
