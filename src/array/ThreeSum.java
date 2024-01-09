package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            if (nums[i] + nums[start] > 0 || nums[end] < 0) {
                break;
            }
            while (start < end) {
                if (nums[i] + nums[start] > 0 || nums[end] < 0) {
                    break;
                }
                if (nums[i] + nums[start] + nums[end] == 0) {
                    resList.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                    while (start < end && nums[end + 1] == nums[end]) {
                        end--;
                    }
                } else if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                    while (start < end && nums[end + 1] == nums[end]) {
                        end--;
                    }
                } else {
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                }
            }
        }
        return resList;
    }
}
