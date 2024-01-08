package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();
        int min = intervals[0][0];
        int max = intervals[0][0];
        for (int i = 1; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }
        int[] rangeArr = new int[max - min + 1];
        for (int[] interval : intervals) {
            rangeArr[interval[0] - min] = Math.max(rangeArr[interval[0] - min], interval[1] - min);
        }
        int start = 0, end = 0;
        for (int i = 0; i < rangeArr.length; i++) {
            if (rangeArr[i] == 0)
                continue;
            if (i <= end) {
                end = Math.max(end, rangeArr[i]);
            } else {
                resList.add(new int[]{start + min, end + min});
                start = i;
                end = rangeArr[i];
            }
        }
        resList.add(new int[]{start + min, end + min});
        return resList.toArray(new int[resList.size()][]);
    }
}
