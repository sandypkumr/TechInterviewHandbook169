package array;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> resMap = new HashMap<>();
        int max = 0;
        resMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (resMap.containsKey(sum)) {
                max = Math.max(max, i - resMap.get(sum));
            } else {
                resMap.put(sum, i);
            }
        }
        return max;
    }
}
