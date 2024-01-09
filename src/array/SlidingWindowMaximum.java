package array;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> maxIndexList = new ArrayList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                int curMaxIndex = maxIndexList.getFirst();
                res[i - k] = nums[curMaxIndex];
                if (i - curMaxIndex >= k) {
                    maxIndexList.removeFirst();
                }
            }
            while (!(maxIndexList.isEmpty()) && nums[maxIndexList.getLast()] <= nums[i]) {
                maxIndexList.removeLast();
            }
            maxIndexList.add(i);
        }
        res[nums.length - k] = nums[maxIndexList.getFirst()];
        return res;
    }
}
