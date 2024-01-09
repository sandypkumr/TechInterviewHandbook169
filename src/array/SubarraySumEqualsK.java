package array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> resMap = new HashMap<>();
        int sum = 0, res = 0;
        resMap.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (resMap.containsKey(sum - k)) {
                res += resMap.get(sum - k);
            }
            resMap.put(sum, resMap.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
