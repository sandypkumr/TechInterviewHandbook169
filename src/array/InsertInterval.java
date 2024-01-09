package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int newIntStart = newInterval[0], newIntEnd = newInterval[1];
        int currIndex = 0;
        int[][] resArray;
        while (currIndex < intervals.length) {
            if (intervals[currIndex][1] < newIntStart) {
                res.add(intervals[currIndex]);
            } else if (intervals[currIndex][0] > newIntEnd) {
                break;
            } else {
                newIntStart = Math.min(newIntStart, intervals[currIndex][0]);
                newIntEnd = Math.max(newIntEnd, intervals[currIndex][1]);
            }
            currIndex++;
        }
        res.add(new int[]{newIntStart, newIntEnd});
        for (int i = currIndex; i < intervals.length; i++) {
            res.add(intervals[i]);
        }
        resArray = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            resArray[i] = res.get(i);
        }
        return resArray;
    }
}
