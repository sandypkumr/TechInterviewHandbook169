package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<int[]> barDeque = new ArrayDeque<>();
        int[] cur = new int[2];
        for (int i = 0; i < heights.length; i++) {
            if (barDeque.isEmpty() || barDeque.peek()[1] < heights[i]) {
                barDeque.push(new int[] {i, heights[i]});
            } else {
                while (!barDeque.isEmpty() && barDeque.peek()[1] >= heights[i]) {
                    cur = barDeque.pop();
                    res = Math.max(res, (i - cur[0]) * cur[1]);
                }
                cur[1] = heights[i];
                barDeque.push(cur);
            }
        }
        while (!barDeque.isEmpty()) {
            cur = barDeque.pop();
            res = Math.max(res, (heights.length - cur[0]) * cur[1]);
        }
        return res;
    }
}
