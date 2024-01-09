package array;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (numMap.containsKey(num)) {
                continue;
            }
            numMap.put(num, numMap.getOrDefault(num - 1, 0) +
                    numMap.getOrDefault(num + 1, 0) + 1);
            numMap.put(num - numMap.getOrDefault(num - 1, 0), numMap.get(num));
            numMap.put(num + numMap.getOrDefault(num + 1, 0), numMap.get(num));
            res = Math.max(res, numMap.get(num));
        }
        return res;
    }
}
