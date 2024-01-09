package array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        int res = 0;
        int curHigh = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < curHigh) {
                res++;
                curHigh = Math.min(curHigh, interval[1]);
            } else {
                curHigh = interval[1];
            }
        }
        return res;
    }
}
