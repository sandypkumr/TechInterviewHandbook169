package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (integerMap.containsKey(rem)) {
                return new int[]{integerMap.get(rem), i};
            }
            integerMap.put(nums[i], i);
        }
        return null;
    }
}
